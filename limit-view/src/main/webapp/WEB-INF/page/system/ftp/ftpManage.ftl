<@PAGE.HTML title="FTP服务" js=["resource/plugin/uploadify/jquery.uploadify.min"] css=["resource/plugin/uploadify/uploadify"]>
<body style="margin: 5px" class="easyui-layout">
	
	<#-- 上传任务 -->
    <div id="ftp_outer" data-options="region:'west',title:'任务',collapsible:false" style="width:380px;">
    	<div id="ftp_task">
			<div style="width:325px;height:40px;margin: 0 auto;">
				<input id="upload" name="file" type="file" style="display:none;"/>
			</div>
			<div id="taskList" style="color:#000"></div>
    	</div>   
    </div>
    
    <#-- 消息控制台 -->
    <div data-options="region:'south',title:'控制台',collapsible:false" style="height:200px;">
    	<div id="messageConsole"></div>
    </div>   
    
    <#-- 文件浏览器 -->
    <div data-options="region:'center',title:'文件浏览'"  style="padding:5px;background:#eee;">
    	<div id="list" class="easyui-panel" data-options="fit:true"></div>
    </div>
    
    <script>
    	<#-- 文件浏览窗口 -->
		$("#list").panel({
			content:$.createIframeWindow("list","${ctx}/system/ftp/list")
		});
		
    	<#-- 上传器初始化 -->
    	function initUpload (){
			$("#upload").uploadify({
				buttonText : '上传文件到当前目录',
				<#--buttonImage : "${ctx}/resource/img/login_button.jpg",-->
				height : 30,
				width : 320,
				queueID : "taskList",
				swf : "${ctx}/resource/plugin/uploadify/uploadify.swf",
				uploader : "${ctx}/system/ftp/upload",
				fileSizeLimit : "${sys_dic.getParamValue('ftp.upload_size')}",
				fileObjName : "file",
				auto : true,  <#-- 是否自动上传, 选择文件即上传 -->
				removeCompleted : true, <#-- 是否完成上传后删除队列中的文件显示 -->
				removeTimeout : 10,
				fileTypeExts : "${sys_dic.getParamValue('ftp.upload_ext_type')}", <#-- 文件上传允许的类型 -->
				<#--开始上传时触发, 绑定参数 -->
				onUploadStart : function(file){
					var win = $("#list_iframe")[0].contentWindow;
					var path = win.$("#currentPathUrl").text();
					$("#upload").uploadify("settings", "formData",{path:path}); // 当前目录
				},
	
				<#-- 每个文件上传成功的回调 -->	
				onUploadSuccess : function(file, data, response) {
				    $("#messageConsole").append($.nowtime() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "文件名: <span style='color:red'>" + file.name + "</span>,	是否上传成功 : <span style='color:red'>" + response + "</span>, 服务器响应消息: <span style='color:red'>" + data + "</span><br/>");
				},
				
				<#-- 任务队列执行完后触发 -->
				onQueueComplete : function (){
					var win = $("#list_iframe")[0].contentWindow;
					win.location.reload(true);
				},
			 });
		}
    </script>
</body>
</@PAGE.HTML>