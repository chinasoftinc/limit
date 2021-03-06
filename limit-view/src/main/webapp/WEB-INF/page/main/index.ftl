<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		<title>首页</title>
		<link href="${ctx}/resource/css/bootstrap.css" rel="stylesheet">
		<!--你自己的样式文件 -->
		<link href="${ctx}/resource/css/style.css" rel="stylesheet">
		<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
		<!--[if lt IE 9]>
        <script src="${ctx}/resource/js/html5shiv.js"></script>
        <script src="${ctx}/resource/js/respond.min.js"></script>
        <![endif]-->
		<script src="${ctx}/resource/js/jquery.1.11.1.js"></script>
		<script src="${ctx}/resource/js/bootstrap.min.js"></script>
		<!--<script>
			$(function(){
				$('.item .col-sm-3').hover(function(){
					$(this).css('background-color','#0F79EE').;
				})
			})
		</script>-->
	</head>

	<body>
		<div class="container">
			<div class="text-center">
				<h1 class="title">泰州交通综合信息平台</h1>
				<h4>Taizhou Transport Integrated Information Platform</h4>
			</div>
		</div>
		<div class="container">
			<div class="col-lg-4 col-md-3 col-sm-2 col-xs-12"></div>
			<div class="col-lg-4 col-md-6 col-sm-8 col-xs-12">
				<div class="input-group input-group-lg">
	                <input type="text" class="form-control"  placeholder="Search" >
	                <span class="input-group-addon">
						<span class="glyphicon glyphicon-search"></span>					
					</span>
               </div>
            </div>
            <div class="col-lg-4 col-md-3 col-sm-12 col-xs-12" style="line-height: 3.5rem"><span class="usermanger">用户管理</span></div>
            
		</div>
		<div class="container appenter">
			<div class="col-lg-6"></div>
            <div class="col-lg-6"><span class="glyphicon glyphicon-phone"> </span> 
            <a href="${ctx}/manage" style="cursor:pointer">您具有后台管理权限,点击进入后台管理</a></div></div>           	
        </div>
		<div class="container item">
			<div class="row">
				<div class="col-sm-3">
					<div>
						<a href="${ctx}/business/yunguan/main" class="portfolio-link" data-toggle="modal">
							<img src="${ctx}/resource/img/01.png" class="img-responsive center-block" alt=""><br />
							<div class="text-center">运管</div>
						</a>
					</div>
				</div>
				<div class="col-sm-3">
					<div>
						<a href="#" class="portfolio-link">
							<img src="${ctx}/resource/img/02.png" class="img-responsive center-block" alt=""><br />
							<div class="text-center">公路</div>
						</a>
					</div>
				</div>
				<div class="col-sm-3">
					<div>
						<a href="#" class="portfolio-link">
							<img src="${ctx}/resource/img/03.png" class="img-responsive center-block" alt=""><br />
							<div class="text-center">海事</div>
						</a>
					</div>
				</div>
				<div class="col-sm-3">
					<div>
						<a href="#" class="portfolio-link">
							<img src="${ctx}/resource/img/04.png" class="img-responsive center-block" alt=""><br />
							<div class="text-center">航道</div>
						</a>
					</div>
				</div>
				<div class="col-sm-3">
					<div>
						<a href="#" class="portfolio-link">
							<img src="${ctx}/resource/img/05.png" class="img-responsive center-block" alt=""><br />
							<div class="text-center">长运</div>
						</a>
					</div>
				</div>
				<div class="col-sm-3">
					<div>
						<a href="#" class="portfolio-link">
							<img src="${ctx}/resource/img/06.png" class="img-responsive center-block" alt=""><br />
							<div class="text-center">出租</div>
						</a>
					</div>
				</div>
				<div class="col-sm-3">
					<div>
						<a href="#" class="portfolio-link">
							<img src="${ctx}/resource/img/07.png" class="img-responsive center-block" alt=""><br />
							<div class="text-center">港口</div>
						</a>
					</div>
				</div>
				<div class="col-sm-3">
					<div>
						<a href="#" class="portfolio-link">
							<img src="${ctx}/resource/img/08.png" class="img-responsive center-block" alt=""><br />
							<div class="text-center">公交</div>
						</a>
					</div>
				</div>
			</div>
		</div>
		<script>
			$(function(){
				$('.col-sm-3').hover(function(){
					
				},function(){
					
				})
			})
		</script>
	</body>

</html>