<@PAGE.HTML title="添加用户">
<body style="margin:5px;background:#666">
<div style="width: 100%;height:100%;">
	<div style="width: 100%">
		<form id="form" action="${ctx}/system/user/saveUser" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%" border="0" class="form-data">
				<tr>
					<td style="width:12%;text-align:right">用户昵称</td>
					<td>
						<input name="nickName" class="easyui-validatebox" value="${user.nickName}" data-options=required:true,validType:["Trims['用户昵称不能为空']"],missingMessage:"用户昵称不能为空" />
					</td>
					<td style="width:12%">&nbsp;</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">登录帐号</td>
					<td>
						<input name="userName" class="easyui-validatebox" value="${user.userName}" <#if operation == 'add'>data-options=required:true,validType:["Pattern['^[A-Za-z0-9]{5,16}$','登录账户不合法,请输入5-16位英文或数字']","Remoto['${ctx}/system/user/isNotExistUserName','userName','该登录账户已被注册,请重新输入']"],missingMessage:"输入5-16位英文或数字作为登录账户" </#if> <#if operation == 'edit'>disabled</#if> />
					</td>
				</tr>
				
				<#if operation == 'add'>
				<tr>
					<td style="width:12%;text-align:right">初始密码</td>
					<td>
						<input name="passWord" class="easyui-validatebox" value="${user.passWord}" data-options=required:true,validType:["Pattern['^[A-Za-z0-9\u4E00-\u9600]{5,16}$','密码不合法,请输入5-16位英文或数字']"],missingMessage:"输入5-16位英文或数字作为密码" />
					</td>
				</tr>
				</#if>
				
				<tr>
					<td style="width:12%;text-align:right">邮箱</td>
					<td>
						<input name="userEmail" class="easyui-validatebox" maxLength="32" value="${user.userEmail}" data-options=required:true,validType:["Pattern['^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$','邮箱地址不合法']"],missingMessage:"输入邮箱地址" />
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">手机号码</td>
					<td>
						<input name="userPhone" class="easyui-validatebox" maxLength="32" value="${user.userPhone}" data-options=required:true,validType:["Pattern['^(13[0-9]|14[0-9]|15[0-9]|18[0-9])[0-9]{8}$','手机号码格式不合法']"],missingMessage:"输入手机号码" />
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">用户性别</td>
					<td>
						<@RadioTag name="userSex" optName="user_sex" checked="${user.userSex}" defaultChecked="0" style="width:12px;height:11px" />
					</td>
				</tr>
				
				<tr>
					<td style="width:12%;text-align:right">所属机构</td>
					<td>
						<@PAGE.SELECT datas=orgList optKey="id" optVal="deptShortName" selected="${user.orgId}" id="orgId" name="orgId" class="easyui-validatebox" data_option='required:true,missingMessage:"选择用户所属机构"' />
					</td>
				</tr>
				
				<tr>
					<td style="width:12%;text-align:right">所属部门</td>
					<td>
						<select id="departmentId" name="departmentId" check="${user.departmentId}" <#if operation == 'add' >disabled</#if> data-options=required:true,missingMessage:"选择用户所属部门" >
							<#list deptList as dept>
								<option id="${dept.id}" value="${dept.id}" <#if dept.id == user.departmentId>selected="selected"</#if> >${dept.deptShortName}</option>
							</#list>
						</select>
					</td>
				</tr>
				
				<tr>
					<td style="width:12%;text-align:right">启用状态</td>
					<td>
						<@RadioTag name="userStatus" optName="user_status" checked="${user.userStatus}" defaultChecked="1" style="width:12px;height:11px" />
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">角色配置</td>
					<td>
						<a class="easyui-linkbutton" onclick="directionRole()" style="height:25px;width:120px">点击赋予用户角色</a>
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
	
	<#-- 角色配置窗口 -->
	function directionRole(){
		$.createSimpleWindowAutoScroll("directionRole","赋予角色", 625, 380, "${ctx}/system/user/directionRole");
	}
	
	<#-- 机构选择加载部门下拉 -->
	$("#orgId").on("change", function(){
		var orgId = $(this).val();
		if(orgId != "" && orgId != null && orgId != undefined){
			$("#departmentId").attr("disabled", false);
 				
 			$.defaultAjaxOperation("${ctx}/system/user/deptListForOrg?orgId=" + orgId,{},true,true, 
				{
					success: function (result){
						 if(result.success){
						 	if(result.data.length > 0){
						 		$.each(result.data, function(index, item){
						 			var option = '<option id="' + item.id + '" value="' + item.id + '">' + item.deptShortName + '</option>'
						 			$(option).appendTo($("#departmentId"));
						 		});
						 	}
						 }else{
							 $.errorTip("警告", "操作异常");
						 }
					}
				}
			);		
		 				
 				
		}else{
			$("#departmentId").attr("disabled", "disabled");
			$("#departmentId option").remove();
		}
	})
</script>
</body>
</@PAGE.HTML>