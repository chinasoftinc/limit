<@PAGE.HTML title="添加菜单">
<body style="margin:5px;background:#fff">
<div style="width: 100%;height:100%;">
	<div style="width: 100%">
		<form id="form" action="${ctx}/system/menu/saveMenu" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%" border="0" class="form-data">
				<#if menu.menuParentId != 0>
				<tr>
					<td style="width:14%;text-align:right">上级菜单</td>
					<td>
						<select name="menuParentId" class="easyui-validatebox" data-options=required:true,missingMessage:"选择上级菜单" onChange="skipValidate(this)">
							 <option value=""></option>
							 <option value="0">主菜单</option>
							 <#list firstMenus as m>
						 	 <option <#if menu.menuParentId == m.id>selected</#if> value="${m.id}">${m.menuName}</option>
							 </#list>
						</select>
					</td>
					<td style="width:14%">&nbsp;</td>
				</tr>
				</#if>
				
				<tr>
					<td style="width:15%;text-align:right">菜单名称</td>
					<td>
						<input name="menuName" class="easyui-validatebox" value="${menu.menuName}" data-options=validType:["Trims['菜单名称不能为空']"],required:true,missingMessage:"菜单名称不能为空" />
					</td>
				</tr>
				
				<#if menu.menuParentId != 0>
				<tr>
					<td style="width:15%;text-align:right">URL</td>
					<td>
						<input name="menuUrl" class="easyui-validatebox" value="${menu.menuUrl}" data-options=validType:["Trims['菜单URL不能为空']"],required:true,missingMessage:"菜单URL不能为空" />
					</td>
				</tr>
				</#if>
				
				<tr>
					<td style="width:15%;text-align:right">说明</td>
					<td>
						<textarea name="menuDescription" rows="3" class="easyui-validatebox" data-options=validType:["Trims['菜单说明不能为空']"],required:true,missingMessage:"菜单说明不能为空" >${menu.menuDescription}</textarea>
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="operation" value="${operation}"/>
						<input type="hidden" name="parentWinId" value="${parentWinId}"/>
						<input type="hidden" name="winId" value="${winId}"/>
						
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
	function skipValidate(select){
		if(select.value == "0"){
			$("input[name='menuUrl']").removeClass('validatebox-invalid').attr("disabled",true).val("").closest("tr").hide();
		}else{
			$("input[name='menuUrl']").addClass('validatebox-invalid').attr("disabled",false).closest("tr").show();
		}
	}
</script>
</body>
</@PAGE.HTML>