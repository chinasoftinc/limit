<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		<title>登录</title>
		<link href="${ctx}/resource/css/bootstrap.css" rel="stylesheet">
		<!--你自己的样式文件 -->
		<link href="${ctx}/resource/css/style.css" rel="stylesheet">
		<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
		<!--[if lt IE 9]>
        <script src="/${ctx}/resource/js/html5shiv.js"></script>
        <script src="/${ctx}/resource/js/respond.min.js"></script>
        <![endif]-->
		<script src="${ctx}/resource/js/jquery.1.11.1.js"></script>
		<script src="${ctx}/resource/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${ctx}/resource/js/validator.js"></script>
		<style>
			
          
		
		</style>
	</head>
	<body style="background: url(${ctx}/resource/img/login.jpg) no-repeat;">
		<div class="container">
			<div class="text-center">
				<h1 class="title">泰州交通综合信息平台</h1>
				<h3>Taizhou Transport Integrated Information Platform</h3>
			</div>
		</div>
		<div class="login">
			<div class="col-lg-4 col-md-3 col-sm-3 col-xs-2"></div>
			<div class="col-lg-4 col-md-6 col-sm-6 col-xs-8 login-bg">
			<div style="margin-top: 9%;">
				<h3 class="text-center" style="font-weight: bold;">用户登录</h3>
				<br />
				<form class="form-horizontal center-block" role="form" onsubmit="return validateLogin()" >
					<div class="form-group">
						<div class="input-group input-group-lg">
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-user"></span>
							</span>
							<input name="userName" type="text" class="form-control" placeholder="用户名" >
						</div>
					</div>
					<div class="form-group">
						<div class="input-group input-group-lg">
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-lock"></span>
							</span>
							<input name="passWord" type="password" class="form-control" placeholder="密码">
						</div>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg btn-block">登录</button>
					</div>
				</form>
				</div>	
			</div>
			<div class="col-lg-4 col-md-3 col-sm-3 col-xs-2"></div>
		</div>
	</body>
	
	<script>
		$(function(){
			if(window != window.parent){
				window.top.location.href = window.location.href;
			}else{
				$("input[name='userName']").focus();
				$(":input").not("select").keydown(function(e) {
					if (e.which == 13) {
						$(this).closest("form").submit();
					}
				});
			}
			
		});
		
		var isExecute = false;
		function validateLogin(){
		
			var $usernameNode = $("input[name='userName']");
			var $passwordNode = $("input[name='passWord']");
		
			var username = $usernameNode.val();
			var password = $passwordNode.val();
			
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
			
			$.ajax({
				url : '${ctx}/login',
				type : 'post',
				dataType : 'json',
				async : false,
				data : param,
				success : function(NULL, success, jqXHR) {
					var rs = eval("(" + jqXHR.responseText + ")");
					if(!rs.success){
						if(isExecute){
							isExecute = false;
							return;
						}
						isExecute = true;
						alert(rs.message);
						
					} else if(rs.success){
						window.location.href="${ctx}";
					} else{
						alert(rs.message);
					}
				}
			});
			
			return false;
		}
	</script>
</html>