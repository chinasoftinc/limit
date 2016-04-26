<@PAGE.HTML title="FTP文件目录" css="resource/css/file/list_file">
<body style="background:#eee">
	<div id="toolBar" style="background:#eee">
		<table class="fileStatus" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<td colspan="6">
						<a class="easyui-linkbutton" iconCls="icon-back" onclick="lastLevel()">上一级</a>
						<a class="easyui-linkbutton" iconCls="icon-reload" onclick="location.reload(true)">刷新</a>
						<a class="easyui-linkbutton" iconCls="icon-add" onclick="mkdir()">创建文件夹</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<span id="currentPath">
							&nbsp;&nbsp;&nbsp;&nbsp;
							当前路径:&nbsp;&nbsp;<b id="currentPathUrl">${path}</b>
							&nbsp;&nbsp;&nbsp;&nbsp;
						</span>
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td width="4%">
						<input id="allChecked" type="checkbox"/>
					</td>
					<td width="4%"></td>
					<td width="30%">名称</td>
					<td width="25%">大小</td>
					<td width="20%">最后修改日期</td>
					<td>权限</td>
				</tr>
			</thead>
		</table>
	</div>
	<#-- 文件浏览窗口 -->
	<div id="list">
		<table class="fileList" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<td width="4%" height="60px">&nbsp;</td>
					<td width="4%"></td>
					<td width="30%">&nbsp;</td>
					<td width="25%">&nbsp;</td>
					<td width="20%">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</thead>
			<tbody>
				<#list files as file>
				<tr>
					<td>
						<input type="checkbox" id="${file.name}" isdirectory="${file.isDirectory()?string}"/>
					</td>
					<td <#if file.isDirectory()>class="ftp_directory"<#else>class="ftp_file"</#if>></td>
					<td>${file.name}</td>
					<td>${file.size} byte</td>
					<td>${file.timestamp.time?string("yyyy-MM-dd HH:mm:ss")}</td>
					<td>${file.getUser()}</td>
				</tr>
				</#list>
			</tbody>
		</table>
	</div>
	
	<#-- 右键菜单 -->
	<div id="rightMouseMenu" class="easyui-menu" style="display:none">
		<div data-options="name:'delete',iconCls:'icon-reload'" onclick="location.reload(true)">刷新</div>
		<div data-options="name:'delete',iconCls:'icon-add'" onclick="mkdir()">创建文件夹</div>
		<div data-options="name:'delete',iconCls:'icon-no'" onclick="removeFile()">删除这个文件</div>
		<div data-options="name:'delete',iconCls:'icon-cancel'" onclick="removeSelectFiles()">删除所有选择的文件</div>
	</div>

	<script>
		<#-- 进入连接, 让上传控件生效 -->
		parent.initUpload();
	
		<#-- 右键选中文件变量 -->
		var $rightClickFileTr = null;
		<#-- 右键 -->
		$.mouseRightClick($(".fileList tr"), function(event, target){
			// console.info("事件源: id=" + target.id + ", tagName=" + target.tagName); // 输出事件源元素信息, 在此得到文件信息
		
			<#-- 选中右键的文件 -->
			var $tr = $(target).closest("tr");
			$rightClickFileTr = $tr;
			var checkbox = $tr.find("input[type='checkbox']")[0];
			
			if(checkbox.checked == false){
				$(".fileList tr input[type='checkbox']").each(function(){
					this.checked = false;
					$(this).closest("tr").removeClass("select_file");
				});
			}
			checkbox.checked = true;
			$tr.removeClass("select_file");
			$tr.addClass("select_file");
			
			<#-- 右键菜单 -->
			$('#rightMouseMenu').menu('show', {
				left: event.pageX,
				top: event.pageY
			});
		});
		
		<#-- checkbox选中文件 -->
		$(".fileList tr input[type='checkbox']").bind("change",function(){
			if(this.checked){
				$(this).closest("tr").addClass("select_file");
			}else{
				$(this).closest("tr").removeClass("select_file");
			}
		});
		
		<#-- 全选 -->
		$("#allChecked").bind("click",function(){
			if(this.checked == true){
				$(".fileList tr input[type='checkbox']").each(function(){
					this.checked = true;
					$(this).closest("tr").addClass("select_file");
				});
			}else{
				$(".fileList tr input[type='checkbox']").each(function(){
					this.checked = false;
					$(this).closest("tr").removeClass("select_file");
				});
			}
		});
		
		<#-- 双击事件, 转到文件甲或打开文件 -->
		$(".fileList tr").bind("dblclick",function(){
		
			var checkbox = $(this).find("input[type='checkbox']");
			var isDirectory = checkbox.attr("isdirectory"); <#-- 是否是目录 -->
			var fileName = checkbox.attr("id"); <#-- 文件名 -->
			var currentPath = $("#currentPathUrl").text();
			
			<#-- 处理路径 -->
			var path = "";
			if(currentPath == "/"){
				path = fileName;
			}else{
				path = currentPath + "/" + fileName; <#-- 请求的path -->
			}
				
			<#-- 是文件夹, 打开 -->
			if(isDirectory == "true"){
				window.location.href = "${ctx}/system/ftp/list?path=" + path;
				
			<#-- 文件, 请求下载 -->
			}else{
				window.location.href="${ctx}/system/ftp/download?path=" + path;
			}
			
		});
		
		<#-- 上一级目录 -->
		function lastLevel(){
			var path = $("#currentPathUrl").text(); 
			if(path != "/"){
				<#-- 根目录 -->
				if(path.indexOf("/") == -1){
					path = "/";
				}else{
					path = path.substring(0,path.lastIndexOf("/"));
				}
				window.location.href = "${ctx}/system/ftp/list?path=" + path;
			}
		}
		
		<#-- 创建文件夹 -->
		function mkdir(){
			top.$.messager.prompt("创建文件夹", "输入文件夹名称", function(rs){
				if(rs){
					<#-- 处理目录 -->
					var path = $("#currentPathUrl").text();
					
					<#-- 验证文件名的正确性 -->
					var reg= /^[^\/\\<>\*\?\: \!\@\#\$\%\&\*\(\)\+\=\-\,\.\;\'\"\`\~"\|]{1,16}/;
					if(!reg.test(rs)){
						$.errorTip("错误", "文件名不合法");
						return;
					}
					
					if(path == "/"){
						path = rs;
					}else{
						path = path + "/" + rs;
					}
				
					<#-- 创建 -->
					var param = {path:path};
					$.defaultAjaxOperation("${ctx}/system/ftp/mkdir", param, true, true, 
						 {
							 success: function (result){
						 		 if(result.success == 'false'){
									 $.errorTip("警告", "操作失败, 请联系系统管理人员");
								 }else{
									 parent.$("#messageConsole").append($.nowtime() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "创建文件夹: <span style='color:red'>" + path + "</span><br/>");
								 }
								 <#-- 刷新窗口数据 -->
								 window.location.reload(true);
							 }
						 }
					 );
				}
			});
		}
		
		<#-- 删除文件 -->
		function removeFile(){
			var $checkbox = $rightClickFileTr.find("input[type='checkbox']");
			var fileName = $checkbox.attr("id");
			
			<#-- 处理目录 -->
			var path = $("#currentPathUrl").text();
			if(path == "/"){
				path = fileName;
			}else{
				path = path + "/" + fileName;
			}
			
			<#-- 确认删除 -->
			top.$.messager.confirm("提示","是否确认删除?", function(confirm){
				if(confirm){
					var param = {path:path};
					$.defaultAjaxOperation("${ctx}/system/ftp/removeFile", param, true, true, 
						 {
							 success: function (result){
						 		 if(result.success == 'false'){
									 $.errorTip("警告", "操作失败, 请联系系统管理人员");
								 }else{
									 parent.$("#messageConsole").append($.nowtime() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "删除文件: <span style='color:red'>" + path + "</span><br/>");
								 }
								 <#-- 刷新窗口数据 -->
								 window.location.reload(true);
							 }
						 }
					);
				}
			});
		}
		
		<#-- 删除选择的文件 -->
		function removeSelectFiles(){
			var $checkbox = $(".fileList input:checked");
			
			<#-- 确认删除 -->
			top.$.messager.confirm("提示","是否确认删除?", function(confirm){
				if(confirm){
					<#-- 处理目录 -->
					var path = $("#currentPathUrl").text();
					if(path == "/"){
						path = "";
					}else{
						path = path + "/";
					}
					
					<#-- 组装参数 -->
					var paths = "";
					$checkbox.each(function(){
						paths += path + $(this).attr("id") + "@";
					});
					paths = paths.substring(0, paths.length - 1);
					
					<#-- 删除请求 -->
					var param = {path:paths};
					$.defaultAjaxOperation("${ctx}/system/ftp/removeFile", param, true, true, 
						 {
							 success: function (result){
						 		 if(result.success == 'false'){
									 $.errorTip("警告", "操作失败, 请联系系统管理人员");
								 }else{
									 <#-- 刷新窗口数据 -->
									 var pathes = paths.split('@');
									 for(var i = 0; i < pathes.length; i++){
									 	parent.$("#messageConsole").append($.nowtime() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "删除文件: <span style='color:red'>" + pathes[i] + "</span><br/>");
									 }
								 }
								 window.location.reload(true);
							 }
						 }
					);
				}
			})
		}
	</script>
</body>
</@PAGE.HTML>