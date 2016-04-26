<@PAGE.HTML title="用户设置">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%;">
		<table width="100%" border="0" class="form-data">
			<tr>
				<td style="width:12%;text-align:right;">
					<div style="width:50px;border-left:7px solid #FF8000"><b>昵称</b></div>
				</td>
				<td style="padding-left:20px;">
					<span>${user.nickname}</span>
				</td>
			</tr>
			<tr>
				<td style="width:12%;text-align:right">
					<div style="width:50px;border-left:7px solid #FF8000"><b>帐号</b></div>
				</td>
				<td style="padding-left:20px">
					<span>${user.username}</span>
				</td>
			</tr>
			<tr>
				<td style="width:12%;text-align:right;">
					<div style="width:50px;border-left:7px solid #FF8000"><b>角色</b></div>
				</td>
				<td style="padding-left:20px;">
					<#list user.roles?split(' ') as roleName>
					<#if roleName != ''>
					<span style="background:#0066B3;padding:3px;color:#fff">${roleName}</span>
					</#if>
					</#list>
				</td>
			</tr>
			<tr>
				<td style="width:12%;text-align:right;vertical-align:top">
					<div style="width:50px;border-left:7px solid #FF8000"><b>权限</b></div>
				</td>
				<td style="padding-left:20px">
					<#if user.username != "admin">
						<table>
							<tr>
							<#assign index=0>
							<#list menus?keys as key>
						 		<#assign menu=menus[key]>
						 		<#list menu as m>
						 		<#assign index = (index + 1)>
					 				<td style="border:1px solid #ccc;height:15px;width:100px;padding:3px;text-align:center">${m.menuName}</td>
					 			<#if index % 4 == 0><tr/><tr></#if>
					 			</#list>
							</#list>
						 	</tr>
					    </table>
					<#else>
						<span style="border:1px solid #ccc;height:15px;width:100px;padding:3px;text-align:center">所有</span>
					</#if>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center">
					<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('userInfoWin')">关闭</a>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</@PAGE.HTML>