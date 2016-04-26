<@PAGE.HTML title="添加用户">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%">
		<form id="form" action="${ctx}/system/user/save" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%" border="0" class="form-data">
				<tr>
					<td style="width:12%;text-align:right">用户昵称</td>
					<td>
						<input name="nickname" class="easyui-validatebox" value="${user.nickname}" data-options=required:true,missingMessage:"用户昵称不能为空" />
					</td>
					<td style="width:12%">&nbsp;</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">登录帐号</td>
					<td>
						<input name="username" class="easyui-validatebox" value="${user.username}" <#if operation == 'add'>data-options=required:true,validType:["Pattern['^[A-Za-z0-9]{5,20}$','登录账户不合法,请输入5-20位英文或数字']","Remoto['${ctx}/system/user/exist','username','该登录账户已存在']"],missingMessage:"输入5-20位英文或数字作为登录账户"</#if> <#if operation == 'edit'>readonly disabled</#if>/>
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">登录密码</td>
					<td>
						<input name="password" class="easyui-validatebox" value="${user.password}" data-options=required:true,validType:["Pattern['^[A-Za-z0-9\u4E00-\u9600]{5,20}$','密码不合法,请输入5-20位英文或数字']"],missingMessage:"输入5-20位英文或数字作为密码" />
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">启用状态</td>
					<td>
						<@SingleSelectTag name="status" optName="user_status" selected="${user.status}" class="easyui-validatebox" data_options="required:true,missingMessage:\"选择用户启用状态\""/>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<a class="easyui-linkbutton" onclick="directionRole()" style="height:30px;width:130px">点击赋予用户角色</a>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="operation" value="${operation}"/> <#-- 带回操作类型 -->
						<input type="hidden" name="parentWinId" value="${parentWinId}"/> <#-- 持有父窗口的引用, 用于操作父窗口响应 -->
						<input type="hidden" name="winId" value="editUser"/> <#-- 当前窗口ID, 用于跳转到其他页面后, 关闭当前窗口 -->
						<input type="hidden" name="roles" id="roles" value="${user.roles}"/> <#-- 角色ID字符串,逗号隔开 -->
						
						<#if operation=='add'>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">添加</a>&nbsp;
					    <#else>
					    	<input type="hidden" name="id" value="${user.id}"/>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">更新</a>&nbsp;
						</#if>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('editUser')">关闭</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
<script>
	function directionRole(){
		$.createSimpleWindowAutoScroll("directionRole","赋予角色", 625, 380, "${ctx}/system/user/directionRole");
	}
</script>
</body>
</@PAGE.HTML>