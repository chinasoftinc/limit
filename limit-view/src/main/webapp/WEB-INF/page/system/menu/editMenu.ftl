<@PAGE.HTML title="添加菜单">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%">
		<form id="form" action="${ctx}/system/menu/save" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%" border="0" class="form-data">
				<tr>
					<td style="width:14%;text-align:right">父级菜单</td>
					<td>
						<select name="parentId" class="easyui-validatebox" data-options=required:true,missingMessage:"选择父级菜单" onChange="skipValidate(this)">
							 <option value=""></option>
							 <option value="0" <#if menu.id?has_content>selected</#if> >主菜单</option>
							 <#list firstMenus as m>
						 	 <option <#if menu.parentId == m.id>selected</#if> value="${m.id}">${m.menuName}</option>
							 </#list>
						</select>
					</td>
					<td style="width:14%">&nbsp;</td>
				</tr>
				<tr>
					<td style="width:15%;text-align:right">菜单名称</td>
					<td>
						<input name="menuName" class="easyui-validatebox" value="${menu.menuName}" data-options=required:true,missingMessage:"菜单名称不能为空" />
					</td>
				</tr>
				<tr>
					<td style="width:15%;text-align:right">URL</td>
					<td>
						<input name="menuUrl" class="easyui-validatebox" value="${menu.menuUrl}" data-options=required:true,missingMessage:"URL不能为空" />
					</td>
				</tr>
				<tr>
					<td style="width:15%;text-align:right">说明</td>
					<td>
						<textarea name="description" rows="3" class="easyui-validatebox">${menu.description}</textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="operation" value="${operation}"/> <#-- 带回操作类型 -->
						<input type="hidden" name="parentWinId" value="${parentWinId}"/> <#-- 持有父窗口的引用, 用于操作父窗口响应 -->
						<input type="hidden" name="winId" value="editMenu"/> <#-- 该窗口ID, 用于关闭窗口 -->
						
						<#if operation=='add'>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">添加</a>&nbsp;
					    <#else>
					    	<input type="hidden" name="id" value="${menu.id}"/>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">更新</a>&nbsp;
						</#if>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('editMenu')">关闭</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>

<script>
	<#-- 主菜单跳过URL验证js -->
	$(function(){
		if($("select[name='parentId']")[0].value == "0"){
			$("input[name='menuUrl']").removeClass('validatebox-invalid').attr("disabled",true);
		}
	})
	function skipValidate(select){
		if(select.value == "0"){
			$("input[name='menuUrl']").removeClass('validatebox-invalid').attr("disabled",true).val("");
		}else{
			$("input[name='menuUrl']").addClass('validatebox-invalid').attr("disabled",false);
		}
	}
</script>
</body>
</@PAGE.HTML>