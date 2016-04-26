<@PAGE.HTML title="系统登录" 
	css=["resource/css/login/reset",
		 "resource/css/login/structure"
	]
	link=["<link rel='icon' href='${ctx}/resource/img/0.ico' type='image/x-icon' />",
		"<link rel='shortcut icon' href='${ctx}/resource/img/0.ico' type='image/x-icon'/>"
	]
>
<body>
	<form id="loginForm" class="box login" onsubmit="return validateLogin()">
		<fieldset class="boxBody">
			<label style="font-size:12px;display:inline">帐号</label>
			<input name="username" type="text" tabindex="1" autocomplete="off" />
			
			<label style="font-size:12px;display:inline" autocomplete="off" >密码</label>
			<input name="password" type="password" tabindex="2" />
		</fieldset>
		<footer>
			<label><input id="isAuto" name="isAuto" type="checkbox" value="3" tabindex="3" /><font style="font-size:12px">记住我</font></label>
			<input type="submit" class="btnLogin" value="Login" tabindex="4" />
		</footer>
	</form>
	<footer id="main">
		<a href="#">Dynamic datasource support DMS  ( FreeMarker / EasyUI coded )  By Java Spring</a> | <a href="#">PSD By NieBinxiao</a>
	</footer>
	<script type="text/javascript">
	
		<#-- 始终父窗口显示 -->
		$(function(){
			if(window != window.parent){
				window.top.location.href = window.location.href;
			}else{
				<#-- 处理自动登录cookie -->
				var autoLoginCookie = $.cookie('mzj_shop_manage_autologin')
				if(autoLoginCookie != undefined){
					var arr = autoLoginCookie.split(':');
					var username = arr[0];
					var password = arr[1];
					$("input[name='username']").val(username);
					$("input[name='password']").val(password);
					$("#isAuto")[0].checked = true;
				}
				
				$("#isAuto").bind("change", function(){
					if($("#isAuto")[0].checked == false){
						$.removeCookie('mzj_shop_manage_autologin', { path: '/' });
					}
				});
			
				<#-- 初始化用户名输入框获取焦点 -->
				var $usernameNode = $("#loginForm input[name='username']");
				$usernameNode.focus();
			}
		});
		
		<#-- 基本校验 -->
		function validateLogin(){
			var $usernameNode = $("#loginForm input[name='username']");
			var $passwordNode = $("#loginForm input[name='password']");
		
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
			
			var param = {username:username,password:password};
			$.defaultAjaxOperation("${ctx}/login", param, true, true, 
				{
					success: function (rs){
						if(rs.success == false){
							$.msgTip("提示", rs.message);
						}else if(rs.success == true){
							<#-- 登录成功, 处理cookie, 默认7天, 整个项目 -->
							if($("#isAuto")[0].checked == true){
								$.cookie('mzj_shop_manage_autologin', username + ":" + password, { expires: 7, path: '/' });
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