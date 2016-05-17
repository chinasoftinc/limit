<@PAGE.HTML title="查看用户">
<body style="margin:5px;background:#fff">
<div style="width: 100%;height:100%;">
	<div style="width: 100%">
			<table width="100%" border="0" class="form-data">
				<tr>
					<td style="width:12%;text-align:right">用户昵称</td>
					<td>
						<input name="nickName" value="${user.nickName}" disabled/>
					</td>
					<td style="width:12%">&nbsp;</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">登录帐号</td>
					<td>
						<input name="userName" value="${user.userName}" disabled />
					</td>
				</tr>
				
				<#if operation == 'add'>
				<tr>
					<td style="width:12%;text-align:right">初始密码</td>
					<td>
						<input name="passWord" value="${user.passWord}" disabled />
					</td>
				</tr>
				</#if>
				
				<tr>
					<td style="width:12%;text-align:right">邮箱</td>
					<td>
						<input name="userEmail" value="${user.userEmail}" disabled />
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">手机号码</td>
					<td>
						<input name="userPhone" value="${user.userPhone}" disabled />
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">用户性别</td>
					<td>
						<@RadioTag name="userSex" optName="user_sex" checked="${user.userSex}" disabled="disabled" style="width:12px;height:11px" />
					</td>
				</tr>
				
				<tr>
					<td style="width:12%;text-align:right">所属机构</td>
					<td>
						<@PAGE.SELECT datas=orgList optKey="id" optVal="deptShortName" selected="${user.orgId}" disabled="disabled" />
					</td>
				</tr>
				
				<tr>
					<td style="width:12%;text-align:right">所属部门</td>
					<td>
						<select disabled >
							<#list deptList as dept>
								<option value="${dept.id}" <#if dept.id == user.departmentId>selected="selected"</#if> >${dept.deptShortName}</option>
							</#list>
						</select>
					</td>
				</tr>
				
				<tr>
					<td style="width:12%;text-align:right">启用状态</td>
					<td>
						<@RadioTag optName="user_status" checked="${user.userStatus}" disabled="disabled" style="width:12px;height:11px" />
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('${winId}')">关闭</a>
					</td>
				</tr>
			</table>
	</div>
</div>
</body>
</@PAGE.HTML>