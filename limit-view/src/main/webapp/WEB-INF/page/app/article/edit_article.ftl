<#-- 编辑文章-->
<@PAGE.HTML title="编辑文章"
	js=["resource/plugin/uploadify/jquery.uploadify.min",
		"resource/plugin/ueditor/ueditor.config",
		"resource/plugin/ueditor/ueditor.all",
		"resource/plugin/ueditor/lang/zh-cn/zh-cn"
	]
	css=["resource/plugin/uploadify/uploadify"]
>
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%;height:98%">
		<form id="form" action="${ctx}/app/article/save" method="POST" onsubmit="return $(this).form('validate')">
			
			<#-- tab-1: 基本信息 -->
			<div id="form_tab" class="easyui-tabs" style="height:100%;" data-options="fit:true">
			    <div title="文章信息" style="padding:3px;">
		        	<table width="100%" border="0" class="form-data">
						<tr>
							<td style="width:15%;text-align:right">文章标题</td>
							<td>
								<input name="mainTitle" style="border-left:15px solid #FF8000;" class="easyui-validatebox" value='${article.mainTitle}' data-options=required:true,validType:["Trims['文章主标题不能为空']"],animate:true,lines:true,missingMessage:"文章主标题不能为空" maxLength="255"/>
							</td>
							<td>&nbsp;</td>
						</tr>
						
						<tr>
							<td style="width:15%;text-align:right">文章副标题</td>
							<td>
								<input name="subTitle" style="border-left:15px solid #FF8000;" class="easyui-validatebox" value='${article.subTitle}' data-options=required:true,validType:["Trims['文章副标题不能为空']"],animate:true,lines:true,missingMessage:"文章副标题不能为空" maxLength="255"/>
							</td>
							<td>&nbsp;</td>
						</tr>
						
						<tr>
							<td style="text-align:right">
								文章类别<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="置顶的文章始终排在推荐和排名的最前面"/>
							</td>
							<td>
								<@RadioTag name="articleType" optName="article_type" checked="${article.articleType}" defaultChecked="0" style="width:12px;height:11px" />
							</td>
						</tr>
						
						<tr>
							<td style="text-align:right">
								是否发布
							</td>
							<td>
								<@RadioTag name="status" optName="is_true" checked="${article.status}" defaultChecked="1" style="width:12px;height:11px" />
							</td>
						</tr>
						
						<tr>
							<td style="text-align:right;">
								文章图片<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="上传的图片将会拉升或缩放为500 X 500, 尽量选择大小合适的图片, 重复上传将覆盖原先图片, 无法恢复"/>
							</td>
							<td>
								<div style="width:100%;position:relative;top:3px">
									<input id="upload" name="file" type="file" style="display:none;"/>
									<input id="commitPhoto" name="photo" type="hidden" /> <#-- photo提交隐藏域 -->
								</div>
							</td>
						</tr>
						
						<#-- 文件上传队列及图片预览区域 -->
						<tr>
							<td style="text-align:right;">&nbsp;</td>
							<td id="taskList"></td>
						</tr>
						
						<tr>
							<td style="width:15%;text-align:right">文章所属实体类型</td>
							<td>
								<@PAGE.SELECT datas=entityTypes optKey="id" optVal="entityName" selected="${article.entityTypeId}" id="entityType" name="entityType" disabled="false" class="easyui-validatebox" style="border-left:15px solid #FF8000;" data_option='required:true,missingMessage:"选择文章所属实体类型"' />
							</td>
							<td>&nbsp;</td>
						</tr>
						
						<tr>
							<td style="width:15%;text-align:right">文章来源</td>
							<td>
								<input name="source" style="border-left:15px solid #FF8000;" value='${article.source}' class="easyui-validatebox" data-options=required:true,validType:["Trims['文章来源不能为空']"],animate:true,lines:true,missingMessage:"文章来源不能为空" maxLength="50" />
							</td>
							<td>&nbsp;</td>
						</tr>
						
						<tr>
							<td style="width:15%;text-align:right">文章摘要</td>
							<td>
								<textarea name="summary" rows="8" style="border-left:15px solid #FF8000;width:400px" class="easyui-validatebox" data-options=required:true,validType:["Trims['文章摘要不能为空']"],animate:true,lines:true,missingMessage:"文章摘要不能为空" maxLength="1000" >${article.summary}</textarea>
							</td>
							<td>&nbsp;</td>
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
							    	<input type="hidden" name="id" value="${article.id}"/>
									<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">更新</a>&nbsp;
								</#if>
								<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('edit')">关闭</a>
							</td>
						</tr>
						
						<#-- 填补空白 -->
						<tr><td style="height:100px">&nbsp;</td></tr>
						
					</table>
			    </div>   
			    
			 	<#-- tab-2: 文章内容 -->   
			    <div title="文章内容" style="padding:3px;">
			    	<div style="position:relative">
					<textarea id="content" name="content" style="height:612px;width:1150px">${article.content}</textarea>
					</div>
			    </div> 
			    
			    <#-- tab-3: SEO -->
			    <div title="SEO" style="padding:3px;">
			    	<table width="100%" border="0" class="form-data">
						<tr>
							<td style="width:15%;text-align:right">
								关键字<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="用于SEO优化"/>
							</td>
							<td>
								<input name="keywords" style="border-left:15px solid #ccc;" value='${article.keywords}' maxLength="250" />
							</td>
						</tr>
						
						<tr>
							<td style="width:15%;text-align:right">
								页面描述<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="用于SEO优化"/>
							</td>
							<td>
								<textarea name="description" style="border-left:15px solid #ccc;width:400px;" rows="20" maxLength="250">${article.description}</textarea>
							</td>
						</tr>
					</table>
			    </div>  
			</div>
		</form>
	</div>
</div>

<script>
	$(function(){
		<#-- 初始编辑器 -->
		var ue = UE.getEditor('content',{
			readonly : false,
			elementPathEnabled : false,
			enableAutoSave : false,
			topOffset : 35
		});
		
		UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
		UE.Editor.prototype.getActionUrl = function(action) {
		    if (action == 'uploadimage' || action == 'uploadimage') {
		        return '${ctx}/uploadImg';
		    } else if(action == "listimage"){
		    	return '${ctx}/listImg';
		    } else if(action == "catchimage"){
		    	return '${ctx}/catchImg';
		    } else if(action == "uploadvideo"){
		    	return '${ctx}/uploadVideo';
		    } else if(action == "uploadfile"){
		    	return '${ctx}/uploadFile';
		    } else {
		        return this._bkGetActionUrl.call(this, action);
		    }
		}
		
		<#-- 初始化上传器 -->
		initUpload();
		
		<#-- 回显photo的图片 -->
		if("${article.photo}" != ""){
			$("#taskList").html("已选择一张图片|<span style='background:#ccc; border: 1px solid #444; cursor: pointer;' onclick='showImg(\"${sys_dic.access_url}${article.photo}\")' >点击预览图片</span>");
		}else{
			$("#taskList").html("<span>未选择图片</span>");
		}
	})
	
	<#-- 上传器配置 -->
	function initUpload (){
		$("#upload").uploadify({
			buttonText : '上传', <#-- 按钮文字 -->
			queueID : "taskList", <#-- 上传队列消息的显示位置,容器id -->
			height : 20,<#-- 按钮高度 -->
			width : 150, <#-- 按钮宽度 -->
			multi : false, <#-- 是否允许上传多个文件 -->
			swf : "${ctx}/resource/plugin/uploadify/uploadify.swf",
			uploader : "${ctx}/uploadPhoto?size=800,600", <#-- 上传url -->
			fileSizeLimit : "${sys_dic.getParamValue('upload.img_size')}", <#-- 单个文件大小限制 -->
			fileObjName : "file", <#-- 表单提交key -->
			auto : true,  <#-- 是否自动上传, 选择文件即上传 -->
			removeCompleted : true, <#-- 是否完成上传后删除队列中的文件显示 -->
			removeTimeout : 0, <#-- 清除上传队列消息的延迟时间, 0为上传后立即删除 -->
			fileTypeExts : "${sys_dic.getParamValue('upload.img_type')}", <#-- 上传文件后缀限制 -->
			<#-- 开始上传时回调函数, 传递文件对象, 绑定参数 -->
			onUploadStart : function(file){
				$("#taskList").html(""); <#-- 清空队列和文件预览区域 -->
			}, 

			<#-- 每个文件上传成功的回调 -->
			onUploadSuccess : function(file, data, response) {
				<#-- 回显预览图片 -->
				var rs = eval("(" + data + ")");
				if(rs.success){
					$("#taskList").html("已选择一张图片|<span style='background:#ccc; border: 1px solid #444; cursor: pointer;' onclick='showImg(\"${ctx}" + rs.path + "\")' >点击预览图片</span>"); <#-- 显示上传后的文件在服务器的路径 -->
					$("#commitPhoto").val(rs.path); <#-- 改变图片提交的值 -->
				}
			}
		 });
	}
	
	<#-- 预览上传的图片 -->
	function showImg(path){
		$.createSimpleWindowAutoScroll("viewImg","预览", 530, 560, path);
	}
</script>

</body>
</@PAGE.HTML>