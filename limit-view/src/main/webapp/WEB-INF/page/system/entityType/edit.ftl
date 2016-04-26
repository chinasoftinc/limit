<#-- 编辑实体分类-->
<@PAGE.HTML title="编辑实体分类"
	js=["resource/plugin/uploadify/jquery.uploadify.min"]
	css=["resource/plugin/uploadify/uploadify"]
>
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%;">
		<form id="form" action="${ctx}/system/entityType/save" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%;border="0" class="form-data" >
				<tr>
					<td style="width:15%;text-align:right">
						名称<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="分类中文显示名称"/>
					</td>
					<td>
						<input name="entityName" style="border-left:15px solid #FF8000;" class="easyui-validatebox" value='${entityType.entityName}' data-options=required:true,validType:["Trims['分类名称不能为空']"],animate:true,lines:true,missingMessage:"分类名称不能为空" maxLength="20" />
					</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td style="width:15%;text-align:right">
						实体类名<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="分类索引名称, 详情页必须填写实体类的SimpleName"/>
					</td>
					<td>
						<input name="entityKey" value="${entityType.entityKey}" style="border-left:15px solid #ccc;" maxLength="50" />
					</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td style="width:15%;text-align:right">
						对应页面类型
					</td>
					<td>
						<#if operation == "edit">
							<@RadioTag name="entityType" optName="entity_type" checked="${entityType.entityType}" defaultChecked="2" style="width:12px;height:11px" disabled="disabled"/>
						<#else>
							<@RadioTag name="entityType" optName="entity_type" checked="${entityType.entityType}" defaultChecked="2" style="width:12px;height:11px"/>
						</#if>
					</td>
					<td>&nbsp;</td>
				</tr>
				
			<#if operation=="edit">
				<tr>
					<td style="text-align:right">
						模版<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="选择用于静态化的模版文件(必须在静态化之前)"/>
					</td>
					<td>
						<#if templates?size gt 0>
							<@PAGE.SELECT datas=templates optKey="id" optVal="name" selected=entityType.templateId id="templateId" name="templateId" disabled="false" class="" style="" />
							<#else>
							<span style="color:red">没有为该实体定义模版, 先去定义模版</span>
						</#if>
					</td>
				</tr>
				
				<tr>
					<td style="text-align:right;">
						页面标题<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="页面在浏览器标题栏的文字"/>
					</td>
					<td>
						<input name="title" style="border-left:15px solid #ccc;" value='${entityType.title}' maxLength="100" />
					</td>
				</tr>
				
				<#if entityType.entityType == "0" || entityType.entityType == "1">
				<tr>
					<td style="text-align:right;">
						URL<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="该步应该在静态化之前"/>
					</td>
					<td>
						<input name="url" style="border-left:15px solid #ccc;" value='${entityType.url}' maxLength="250" />
					</td>
				</tr>
				
				<tr>
					<td style="text-align:right;">
						筛选条件<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="列表页或跳过列表的版块页对于实体列表的筛选条件"/>
					</td>
					<td>
						<a class="easyui-linkbutton" onclick="configFilter()">点击配置</a>
					</td>
				</tr>
				</#if>
				
				<#if entityType.entityType == "0" || entityType.entityType == "3">
				<tr>
					<td style="text-align:right;">
						关键字<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="用于SEO优化"/>
					</td>
					<td>
						<input name="keywords" style="border-left:15px solid #ccc;" value='${entityType.keywords}' maxLength="250" />
					</td>
				</tr>
				
				<tr>
					<td style="width:15%;text-align:right">
						页面描述<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="用于SEO优化"/>
					</td>
					<td>
						<textarea name="description" style="border-left:15px solid #ccc;width:400px;" rows="5" maxLength="250">${entityType.description}</textarea>
					</td>
				</tr>
				
				<tr>
					<td style="text-align:right;">
						展示图片<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="没有可不上传, 图片不会被压缩"/>
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
					<td style="text-align:right;">
						Banner实体类型<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="没有banner可不选"/>
					</td>
					<td>
						<@PAGE.SELECT datas=entityTypes optKey="id" optVal="entityName" selected="${entityType.bannerEntityTypeId}" id="bannerEntityTypeId" name="bannerEntityTypeId" class="easyui-validatebox" style="border-left:15px solid #ccc;" />
					</td>
				</tr>
				
				<tr>
					<td style="text-align:right;">
						页面数据配置<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="配置需要在页面显示的数据类型, 数量"/>
					</td>
					<td>
						<a class="easyui-linkbutton" onclick="configData()">点击配置</a>
					</td>
				</tr>
				</#if>
				
				<#if entityType.entityType == "0">
				<tr>
					<td style="text-align:right;">
						导航栏<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="该步应该在静态化之前"/>
					</td>
					<td>
						<@RadioTag name="isShowNav" optName="is_show" checked="${entityType.isShowNav}" defaultChecked="1" style="width:12px;height:11px" />
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">
						跳过列表<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="是否跳过下级列表列, 直接显示下级的实体列表. 如果是板块该项为是, 筛选条件才能起效."/>
					</td>
					<td>
						<@RadioTag name="isListShow" optName="is_true" checked="${entityType.isListShow}" defaultChecked="1" style="width:12px;height:11px" />
					</td>
				</tr>
				</#if>
				
			</#if>
				
				<tr>
					<td style="width:15%;text-align:right">上级分类</td>
					<td>
						<select id="parentId" name="parentId" class="easyui-combotree" style="border-left:15px solid #FF8000;width:200px;" data-options="url:'${ctx}/system/entityType/selectJson?id=${entityType.id}'" ></select>
					</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="operation" value="${operation}"/> <#-- 带回操作类型 -->
						<input type="hidden" name="parentWinId" value="${parentWinId}"/> <#-- 持有父窗口的引用, 用于操作父窗口响应 -->
						<input type="hidden" name="winId" value="edit"/> <#-- 当前窗口ID, 用于跳转到其他页面后, 关闭当前窗口 -->
						<input type="hidden" id="dataConfigEntityTypeIdArr" name="dataConfigEntityTypeIdArr" value="${dataConfigEntityTypeIdArr}" /> <#-- 数据配置, 实体类型ID, xx,xx,xx -->
						<input type="hidden" id="dataConfigParamKeyArr" name="dataConfigParamKeyArr" value="${dataConfigParamKeyArr}" /> <#-- 数据配置, 参数名称, xx,xx,xx -->
						<input type="hidden" id="dataConfigNumArr" name="dataConfigNumArr" value="${dataConfigNumArr}" /> <#-- 数据配置, 数量, xx,xx,xx -->

						<#if operation=='add'>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">添加</a>&nbsp;
					    <#else>
					    	<input type="hidden" name="id" value="${entityType.id}"/>
					    	<input type="hidden" name="entityType" value="${entityType.entityType}" />
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">更新</a>&nbsp;
						</#if>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('edit')">关闭</a>
					</td>
				</tr>
				
				<#-- 填补空白 -->
				<#if entityType.entityType == "2">
					<tr><td style="height:420px">&nbsp;</td></tr>
				</#if>
				<#if entityType.entityType == "1">
					<tr><td style="height:370px">&nbsp;</td></tr>
				</#if>
				<#if entityType.entityType == "3">
					<tr><td style="height:140px">&nbsp;</td></tr>
				</#if>
			</table>
		</form>
	</div>
</div>

<script>
	$(function(){
		<#-- 回显上级分类 -->
		$('#parentId').combotree('setValue', '${entityType.parentId?default(0)}');
		
		<#-- 初始化上传器 -->
		initUpload();
		
		<#-- 回显photo的图片 -->
		if("${entityType.photo}" != ""){
			$("#taskList").html("已选择一张图片|<span style='background:#ccc; border: 1px solid #444; cursor: pointer;' onclick='showImg(\"${sys_dic.ACCESS_URL}${entityType.photo}\")' >点击预览图片</span>");
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
			uploader : "${ctx}/uploadPhoto", <#-- 上传url -->
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
	
	
	<#-- 配置过滤条件 -->
	function configFilter(){
		$.createSimpleWindowAutoScroll("configFilter","配置筛选条件", $(window).width() - 50, $(window).height() - 100, "${ctx}/system/entityType/listFilter/manage?entityTypeId=${entityType.id}");
	}
	
	<#-- 配置页面所需数据类型 -->
	function configData(){
		$.createSimpleWindowAutoScroll("configData","配置页面数据", $(window).width() - 50, $(window).height() - 100, "${ctx}/system/entityType/entityParam/manage?entityId=${entityType.id}");
	}
	
	<#-- 预览上传的图片 -->
	function showImg(path){
		$.createSimpleWindowAutoScroll("viewImg","预览", $(window.top).width() - 50, $(window.top).height() - 100, path);
	}
	
</script>

</body>
</@PAGE.HTML>