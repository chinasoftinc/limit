<@PAGE.HTML title="用户设置">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%">
		<form id="form" action="${ctx}/user/modifyPwd" method="post" onsubmit="return $(this).form('validate')">
			<table width="100%" border="0" class="form-data">
				<tr>
					<td style="width:12%;text-align:right">输入原密码</td>
					<td>
						<input name="password" class="easyui-validatebox" data-options=required:true,validType:["Pattern['^[A-Za-z0-9\u4E00-\u9600]{5,20}$','密码不合法,请输入5-20位英文或数字']"],missingMessage:"输入原密码" />
					</td>
					<td style="width:22%">&nbsp;</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">输入新密码</td>
					<td>
						<input id="newPassword" name="newPassword" class="easyui-validatebox" data-options=required:true,validType:["Pattern['^[A-Za-z0-9\u4E00-\u9600]{5,20}$','密码不合法,请输入5-20位英文或数字']"],missingMessage:"输入新密码" />
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">确认密码</td>
					<td>
						<input class="easyui-validatebox" data-options=required:true,validType:["Equals['#newPassword','两次输入的密码不一致']"],missingMessage:"输入确认密码" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="winId" value="userInfoWin"/> <#-- 当前窗口ID, 用于跳转到其他页面后, 关闭当前窗口 -->
				    	<input type="hidden" name="id" value="${user.id}"/>
				    	
						<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">确认</a>&nbsp;
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('userInfoWin')">取消</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</@PAGE.HTML>