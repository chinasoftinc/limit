<@PAGE.HTML title="添加角色">
<body style="margin:5px;background:#666">
<div style="width: 100%;height:100%;">
	<div style="width: 100%">
		<form id="form" action="${ctx}/system/role/saveRole" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%" border="0" class="form-data">
				<tr>
					<td style="width:12%;text-align:right">角色名称</td>
					<td>
						<input name="roleName" class="easyui-validatebox" value="${role.roleName}" maxLength="20" data-options=required:true,missingMessage:"角色名称不能为空" />
					</td>
					<td style="width:12%">&nbsp;</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">角色说明</td>
					<td>
						<input name="roleDescription" class="easyui-validatebox" value="${role.roleDescription}" maxLength="100" data-options=required:true,missingMessage:"角色说明不能为空" />
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">角色配置</td>
					<td>
						<a class="easyui-linkbutton" onclick="directionPrivilege()" style="height:25px;width:120px">点击分配角色权限</a>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="privilegeIds" id="privilegeIds" value="${role.privilegeIds}"/> <#-- 权限ID -->
						
						<input type="hidden" name="operation" value="${operation}"/>
						<input type="hidden" name="parentWinId" value="${parentWinId}"/>
						<input type="hidden" name="winId" value="${winId}"/>
						
						<#if operation=='add'>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">添加</a>&nbsp;
					    <#else>
					    	<input type="hidden" name="id" value="${role.id}"/>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">更新</a>&nbsp;
						</#if>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('editRole')">关闭</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
<script>
	function directionPrivilege(){
		$.createSimpleWindowAutoScroll("directionPrivilege","分配权限", 625, 380, "${ctx}/system/role/directionPrivilege");
	}
</script>
</body>
</@PAGE.HTML>