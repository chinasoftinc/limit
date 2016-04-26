<@PAGE.HTML title="模版编辑"
	js=["resource/plugin/uploadify/jquery.uploadify.min"] 
	css=["resource/plugin/uploadify/uploadify"]
>
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%">
		<form id="form" action="${ctx}/system/template/save" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%" border="0" class="form-data">
				<tr>
					<td style="width:15%;text-align:right">模版名称</td>
					<td>
						<input name="name" style="border-left:15px solid #FF8000;" class="easyui-validatebox" value='${template.name}' data-options=required:true,validType:["Trims['模版名称不能为空']"],missingMessage:"模版名称不能为空" maxLength="50" />
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align:right">所属实体分类</td>
					<td>
						<select id="entityTypeId" name="entityTypeId" class="easyui-combotree" style="border-left:15px solid #FF8000;width:200px;" data-options="url:'${ctx}/system/template/selectJson'" ></select>
					</td>
				</tr>
				
				<#-- 模版文件上传 -->
				<tr>
					<td style="text-align:right;">
						模版文件<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="选择ftl模版文件, 重复上传会覆盖 (注意: 文件名不能和已存在的文件名重复)"/>
					</td>
					<td>
						<div style="width:100%;position:relative;top:3px">
							<input id="upload_template" name="file" type="file" style="display:none;"/>
							<input id="commit_template" name="templateSrc" type="hidden" /> <#-- templateSrc提交隐藏域 -->
						</div>
					</td>
				</tr>
				<#-- 模版文件队列区域 -->				
				<tr>
					<td style="text-align:right;">&nbsp;</td>
					<td id="template_taskList"></td>
				</tr>
				
				<#-- css文件上传 -->
				<tr>
					<td style="text-align:right;">
						样式文件<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="选择css文件, 重复上传会覆盖(注意: 文件名不能和已存在的文件名重复)"/>
					</td>
					<td>
						<div style="width:100%;position:relative;top:3px">
							<input id="upload_css" name="file" type="file" style="display:none;"/>
							<input id="commit_css" name="templateCss" type="hidden" /> <#-- templateCss提交隐藏域 -->
						</div>
					</td>
				</tr>
				<#-- css文件队列区域 -->
				<tr>
					<td style="text-align:right;">&nbsp;</td>
					<td id="css_taskList"></td>
				</tr>
				
				<#-- js文件上传 -->
				<tr>
					<td style="text-align:right;">
						脚本文件<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="选择js文件, 重复上传会覆盖(注意: 文件名不能和已存在的文件名重复)"/>
					</td>
					<td>
						<div style="width:100%;position:relative;top:3px">
							<input id="upload_js" name="file" type="file" style="display:none;"/>
							<input id="commit_js" name="templateJs" type="hidden" /> <#-- templateJs提交隐藏域 -->
						</div>
					</td>
				</tr>
				<#-- js文件队列区域 -->
				<tr>
					<td style="text-align:right;">&nbsp;</td>
					<td id="js_taskList"></td>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="operation" value="${operation}"/> <#-- 带回操作类型 -->
						<input type="hidden" name="parentWinId" value="${parentWinId}"/> <#-- 持有父窗口的引用, 用于操作父窗口响应 -->
						<input type="hidden" name="winId" value="edit"/> <#-- 当前窗口ID, 用于跳转到其他页面后, 关闭当前窗口 -->
						
						<#if operation=='add'>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">添加</a>&nbsp;
					    <#else>
					    	<input type="hidden" name="id" value="${template.id}"/>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">更新</a>&nbsp;
						</#if>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('edit')">关闭</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>

<script>
	$(function(){
		<#-- 回显实体分类 -->
		$('#entityTypeId').combotree('setValue', '${template.entityTypeId?default(0)}');
		
		<#-- 初始化上传器 -->
		initUpload();
		
		<#-- 回显模版文件 -->
		if("${template.templateSrc}" != ""){
			$("#template_taskList").html("已上传模版文件|<span style='background:#ccc; border: 1px solid #444; cursor: pointer;'>${template.templateSrc}</span>");
		}else{
			$("#template_taskList").html("<span>未上传模版文件</span>");
		}
		
		<#-- 回显css文件 -->
		if("${template.templateCss}" != ""){
			$("#css_taskList").html("已上传样式文件|<span style='background:#ccc; border: 1px solid #444; cursor: pointer;'>${template.templateCss}</span>");
		}else{
			$("#css_taskList").html("<span>未上传样式文件</span>");
		}
		
		<#-- 回显js文件 -->
		if("${template.templateJs}" != ""){
			$("#js_taskList").html("已上传脚本文件|<span style='background:#ccc; border: 1px solid #444; cursor: pointer;'>${template.templateJs}</span>");
		}else{
			$("#js_taskList").html("<span>未上传样式文件</span>");
		}
	});

	<#-- 上传器配置 -->
	function initUpload (){
		<#-- 模版上传器 -->
		$("#upload_template").uploadify({
			buttonText : 'template', <#-- 按钮文字 -->
			queueID : "template_taskList", <#-- 上传队列消息的显示位置,容器id -->
			height : 20,<#-- 按钮高度 -->
			width : 150, <#-- 按钮宽度 -->
			multi : false, <#-- 是否允许上传多个文件 -->
			swf : "${ctx}/resource/plugin/uploadify/uploadify.swf",
			uploader : "${ctx}/uploadSource", <#-- 上传url -->
			fileSizeLimit : "1000KB", <#-- 单个文件大小限制 -->
			fileObjName : "file", <#-- 表单提交key -->
			auto : true,  <#-- 是否自动上传, 选择文件即上传 -->
			removeCompleted : true, <#-- 是否完成上传后删除队列中的文件显示 -->
			removeTimeout : 0, <#-- 清除上传队列消息的延迟时间, 0为上传后立即删除 -->
			fileTypeExts : "*.ftl", <#-- 上传文件后缀限制 -->
			<#-- 开始上传时回调函数, 传递文件对象, 绑定参数 -->
			onUploadStart : function(file){
				$("#template_taskList").html(""); <#-- 清空队列和文件预览区域 -->
			}, 

			<#-- 每个文件上传成功的回调 -->
			onUploadSuccess : function(file, data, response) {
				<#-- 回显预览图片 -->
				var rs = eval("(" + data + ")");
				if(rs.success){
					$("#template_taskList").html("已上传模版文件|<span style='background:#ccc; border: 1px solid #444; cursor: pointer;'>" + rs.name + "</span>");
					$("#commit_template").val(rs.path); <#-- 改变提交的值 -->
				}
			}
		 });
		 
		<#-- 样式上传器 -->
		$("#upload_css").uploadify({
			buttonText : 'style', <#-- 按钮文字 -->
			queueID : "css_taskList", <#-- 上传队列消息的显示位置,容器id -->
			height : 20,<#-- 按钮高度 -->
			width : 150, <#-- 按钮宽度 -->
			multi : false, <#-- 是否允许上传多个文件 -->
			swf : "${ctx}/resource/plugin/uploadify/uploadify.swf",
			uploader : "${ctx}/uploadSource", <#-- 上传url -->
			fileSizeLimit : "1000KB", <#-- 单个文件大小限制 -->
			fileObjName : "file", <#-- 表单提交key -->
			auto : true,  <#-- 是否自动上传, 选择文件即上传 -->
			removeCompleted : true, <#-- 是否完成上传后删除队列中的文件显示 -->
			removeTimeout : 0, <#-- 清除上传队列消息的延迟时间, 0为上传后立即删除 -->
			fileTypeExts : "*.css", <#-- 上传文件后缀限制 -->
			<#-- 开始上传时回调函数, 传递文件对象, 绑定参数 -->
			onUploadStart : function(file){
				$("#css_taskList").html(""); <#-- 清空队列和文件预览区域 -->
			}, 

			<#-- 每个文件上传成功的回调 -->
			onUploadSuccess : function(file, data, response) {
				<#-- 回显预览图片 -->
				var rs = eval("(" + data + ")");
				if(rs.success){
					$("#css_taskList").html("已上传样式文件|<span style='background:#ccc; border: 1px solid #444; cursor: pointer;'>" + rs.name + "</span>");
					$("#commit_css").val(rs.path); <#-- 改变提交的值 -->
				}
			}
		 });
		 
		<#-- 脚本上传器 -->
		$("#upload_js").uploadify({
			buttonText : 'script', <#-- 按钮文字 -->
			queueID : "js_taskList", <#-- 上传队列消息的显示位置,容器id -->
			height : 20,<#-- 按钮高度 -->
			width : 150, <#-- 按钮宽度 -->
			multi : false, <#-- 是否允许上传多个文件 -->
			swf : "${ctx}/resource/plugin/uploadify/uploadify.swf",
			uploader : "${ctx}/uploadSource", <#-- 上传url -->
			fileSizeLimit : "1000KB", <#-- 单个文件大小限制 -->
			fileObjName : "file", <#-- 表单提交key -->
			auto : true,  <#-- 是否自动上传, 选择文件即上传 -->
			removeCompleted : true, <#-- 是否完成上传后删除队列中的文件显示 -->
			removeTimeout : 0, <#-- 清除上传队列消息的延迟时间, 0为上传后立即删除 -->
			fileTypeExts : "*.js", <#-- 上传文件后缀限制 -->
			<#-- 开始上传时回调函数, 传递文件对象, 绑定参数 -->
			onUploadStart : function(file){
				$("#js_taskList").html(""); <#-- 清空队列和文件预览区域 -->
			}, 

			<#-- 每个文件上传成功的回调 -->
			onUploadSuccess : function(file, data, response) {
				<#-- 回显预览图片 -->
				var rs = eval("(" + data + ")");
				if(rs.success){
					$("#js_taskList").html("已上传脚本文件|<span style='background:#ccc; border: 1px solid #444; cursor: pointer;'>" + rs.name + "</span>");
					$("#commit_js").val(rs.path); <#-- 改变提交的值 -->
				}
			}
		 });
	}
</script>

</body>
</@PAGE.HTML>