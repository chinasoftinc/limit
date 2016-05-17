<@PAGE.HTML title="系统登录">
<body style="padding-top:300px">
	<form id="loginForm" onsubmit="return validateLogin()">
		<fieldset>
			<center>
				<label style="font-size:12px;display:inline">帐号</label>
				<input name="userName" type="text" tabindex="1" autocomplete="off" />
				
				<label style="font-size:12px;display:inline" autocomplete="off" >密码</label>
				<input name="passWord" type="password" tabindex="2" />
				
				<label><input id="isAuto" name="isAuto" type="checkbox" value="3" tabindex="3" /><font style="font-size:12px">记住我</font></label>
				<input type="submit" value="Login" tabindex="4" />
			<center>
		</fieldset>
	</form>
	
	<footer id="main">
		<div style="font-size:12px;background:#666">
			<center>
				<span style="position:relative;color:#fff">版权所有 © com.athena</span>
			</center>
		</div>
	</footer>
	
	<script type="text/javascript">
		$(function(){
		
			<#-- 始终父窗口显示 -->
			if(window != window.parent){
				window.top.location.href = window.location.href;
				
			}else{
				<#-- 处理自动登录cookie -->
				var autoLoginCookie = $.cookie('com_athena_autologin')
				
				if(autoLoginCookie != undefined){
					var arr = autoLoginCookie.split(':');
					var username = arr[0];
					var password = arr[1];
					$("input[name='userName']").val(username);
					$("input[name='passWord']").val(password);
					$("#isAuto")[0].checked = true;
				}
				
				<#-- 绑定取消自动登录事件 -->
				$("#isAuto").bind("change", function(){
					if($("#isAuto")[0].checked == false){
						$.removeCookie('com_athena_autologin', { path: '/' });
					}
				});
			
				<#-- 初始化用户名输入框获取焦点 -->
				var $usernameNode = $("#loginForm input[name='userName']");
				$usernameNode.focus();
			}
		});
		
		<#-- 基本校验 -->
		function validateLogin(){
		
			var $usernameNode = $("#loginForm input[name='userName']");
			var $passwordNode = $("#loginForm input[name='passWord']");
		
			var username = $usernameNode.val();
			var password = $passwordNode.val();
			var isAuto = $("#loginForm input[name='isAuto']").val();
			
			if(!Validator.isRequired(username)){
				$usernameNode.focus();
				return false;
			}
			if(!Validator.isUsernameOrPassword(username)){
				$usernameNode.focus();
				return false;
			}
			if(!Validator.isUsernameOrPassword(password)){
				$passwordNode.focus();
				return false;
			}
			if(!Validator.isUsernameOrPassword(password)){
				$passwordNode.focus();
				return false;
			}
			
			var param = {userName:username,passWord:password};
			$.defaultAjaxOperation("${ctx}/login", param, true, true, 
				{
					success: function (rs){
						if(!rs.success){
							$.msgTip("提示", rs.message);
						}else if(rs.success){
						
							if($("#isAuto")[0].checked == true){
								<#-- 默认7天, 整个项目 -->
								$.cookie('com_athena_autologin', username + ":" + password, { expires: 7, path: '/' });
							}
							
							window.location.href="${ctx}";
						}else{
						 	$.errorTip("警告", "登录失败, 请联系系统管理人员");
						}
					 }
				}
			);
			return false;
		}
	</script>
</body>
</@PAGE.HTML>