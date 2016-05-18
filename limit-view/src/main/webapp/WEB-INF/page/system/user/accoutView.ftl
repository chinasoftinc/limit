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
					<span>${user.nickName}</span>
				</td>
			</tr>
			
			<tr>
				<td style="width:12%;text-align:right">
					<div style="width:50px;border-left:7px solid #FF8000"><b>帐号</b></div>
				</td>
				<td style="padding-left:20px">
					<span>${user.userName}</span>
				</td>
			</tr>
			
			<tr>
				<td style="width:12%;text-align:right;">
					<div style="width:50px;border-left:7px solid #FF8000"><b>所属机构</b></div>
				</td>
				<td style="padding-left:20px;">
					<#if user.userStatus == '1'>
					<span>${user.orgName}</span>
					<#else>
					<span>NA</span>
					</#if>	
				</td>
			</tr>
			
			<tr>
				<td style="width:12%;text-align:right;">
					<div style="width:50px;border-left:7px solid #FF8000"><b>所属部门</b></div>
				</td>
				<td style="padding-left:20px;">
					<#if user.userStatus == '1'>
					<span>${user.deptName}</span>
					<#else>
					<span>NA</span>
					</#if>	
				</td>
			</tr>
			
			<tr>
				<td style="width:12%;text-align:right;">
					<div style="width:50px;border-left:7px solid #FF8000"><b>角色</b></div>
				</td>
				<td style="padding-left:20px;">
					<#if user.userStatus == '1'>
					<#list user.roles?split(' ') as roleName>
					<#if roleName != ''>
					<span style="background:#0066B3;padding:3px;color:#fff">${roleName}</span>
					</#if>
					</#list>
					<#else>
					<span>NA</span>
					</#if>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align:center">
					<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('${winId}')">关闭</a>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</@PAGE.HTML>