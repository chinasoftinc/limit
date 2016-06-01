<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		<title>运管处</title>
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
	</head>

	<body>
		<div class="container">
			<div class="text-center">
				<h1 class="title" style="font-weight: bold; font-size: 5rem;">运管处</h1>
			</div>
			<div class="row pull-right">
				<!--<nav class="navbar" role="navigation">-->
				<div class="navbar-brand">
					<span class="glyphicon glyphicon-user"></span>
					<a href="#">您好</a>
					<a href="#">admin</a>&nbsp;|&nbsp;
					<a href="#">修改密码</a>&nbsp;|&nbsp;
					<a href="#">安全退出</a>&nbsp;|&nbsp;
					<a href="#">首页</a>
				</div>
			</div>
		</div>
		<div class=" mt50 main" >
				<div class="col-lg-2" id="left-nav">
					<div class="panel-group" id="accordion">
						<h1 class="text-center">
							运 管 处
						</h1>
						<div class="panel panel-info">
							<a data-toggle="collapse" data-parent="#accordion"  href="#collapseOne" >
							<div class="panel-heading active">
								<h4 class="panel-title">
									道路客运
									<span class="glyphicon glyphicon-chevron-right" style="float: right;"></span>
								</h4>
							</div>
							</a>
							<div id="collapseOne" class="panel-collapse collapse">
								<div class="list-group">
									<a href="#" class="list-group-item">车辆信息</a>
									<a href="#" class="list-group-item">业务报表</a>
								</div>
							</div>
						</div>
						<div class="panel panel-info">
							<a data-toggle="collapse" data-parent="#accordion"  href="#collapseTwo">
							<div class="panel-heading">
								<h4 class="panel-title">
									道路货运
									<span class="glyphicon glyphicon-chevron-right" style="float: right;"></span>
								</h4>
							</div>
							</a>	
							<div id="collapseTwo" class="panel-collapse collapse">
								<div class="list-group">
									<a href="#" class="list-group-item">车辆信息</a>
									<a href="#" class="list-group-item">业务报表</a>
								</div>
							</div>
						</div>
						<div class="panel panel-info">
							<a data-toggle="collapse" data-parent="#accordion"  href="#collapseThree">
							<div class="panel-heading">
								<h4 class="panel-title">
									城市客运
									<span class="glyphicon glyphicon-chevron-right" style="float: right;"></span>
								</h4>
							</div>
							</a>
							<div id="collapseThree" class="panel-collapse collapse">
								<div class="list-group">
									<a href="#" class="list-group-item">车辆信息</a>
									<a href="#" class="list-group-item">业务报表</a>
								</div>
							</div>
						</div>
						<div class="panel panel-info">
							<a data-toggle="collapse" data-parent="#accordion"  href="#collapseFour">
							<div class="panel-heading">
								<h4 class="panel-title">
									水路运输
									<span class="glyphicon glyphicon-chevron-right" style="float: right;"></span>
								</h4>
							</div>
							</a>
							<div id="collapseFour" class="panel-collapse collapse">
								<div class="list-group">
									<a href="#" class="list-group-item">客船信息</a>
									<a href="#" class="list-group-item">业务报表</a>
								</div>
							</div>
						</div>
						<div class="panel panel-info">
							<a data-toggle="collapse" data-parent="#accordion"  href="#collapseFive">
							<div class="panel-heading">
								<h4 class="panel-title">
									汽车维修/驾驶培训
									<span class="glyphicon glyphicon-chevron-right" style="float: right;"></span>
								</h4>
							</div>
							</a>
							<div id="collapseFive" class="panel-collapse collapse">
								<div class="list-group">
									<a href="#" class="list-group-item">1</a>
									<a href="#" class="list-group-item">2</a>
								</div>
							</div>
						</div>
						<div class="panel panel-info">
							<a data-toggle="collapse" data-parent="#accordion"  href="#collapseSix">
							<div class="panel-heading">
								<h4 class="panel-title">
									从业人员
									<span class="glyphicon glyphicon-chevron-right" style="float: right;"></span>
								</h4>
							</div>
							</a>	
							<div id="collapseSix" class="panel-collapse collapse">
								<div class="list-group">
									<a href="#" class="list-group-item">1</a>
									<a href="#" class="list-group-item">2</a>
								</div>
							</div>
						</div>
						<div class="panel panel-info">
							<a data-toggle="collapse" data-parent="#accordion"  href="#collapseSeven">
							<div class="panel-heading">
								<h4 class="panel-title">
									行政执法
									<span class="glyphicon glyphicon-chevron-right" style="float: right;"></span>
								</h4>
							</div>
							</a>
							<div id="collapseSeven" class="panel-collapse collapse">
								<div class="list-group">
									<a href="#" class="list-group-item">1</a>
									<a href="#" class="list-group-item">2</a>
								</div>
							</div>
						</div>
						<div class="panel panel-info">
							<a data-toggle="collapse" data-parent="#accordion"  href="#collapseEight">
							<div class="panel-heading">
								<h4 class="panel-title">
									车辆监督	
									<span class="glyphicon glyphicon-chevron-right" style="float: right;"></span>
								</h4>
							</div>
							</a>
							<div id="collapseEight" class="panel-collapse collapse">
								<div class="list-group">
									<a href="#" class="list-group-item">1</a>
									<a href="#" class="list-group-item">2</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				
				<#--列表S -->
				<div class="col-lg-10" id="right-info">
					<nav class="navbar navbar-default" role="navigation">
						<div class="clearfix">
							<form class="navbar-form navbar-left" role="search">
								<div class="form-group">
									<ul class="nav navbar-nav navbar-left">
										<li class="dropdown">
											<a href="#" class="dropdown-toggle btn btn-default" data-toggle="dropdown">颜色 <b class="caret"></b></a>
											<ul class="dropdown-menu">
												<li><a href="javascript:searchData('chepys=黑')">黑色</a></li>
												<li><a href="javascript:searchData('chepys=白')"">白色</a></li>
												<li><a href="javascript:searchData('chepys=蓝')"">蓝色</a></li>
												<li><a href="javascript:searchData('chepys=黄')"">黄色</a></li>
												<li><a href="javascript:searchData('chepys=银')"">银色</a></li>
											</ul>
										</li>
									</ul>
								</div>
								<div class="form-group">
									<input type="text" class="form-control" placeholder="车牌">
								</div>
								<div class="form-group">
									<ul class="nav navbar-nav navbar-left">
										<li class="dropdown">
										<a href="#" class="dropdown-toggle btn btn-default" data-toggle="dropdown">车高 <b class="caret"></b></a>
										<ul class="dropdown-menu">
											<li><a href="javascript:searchData('cheg=1500-1999')">1500-1999</a></li>
											<li><a href="javascript:searchData('cheg=2000-2499')">2000-2499</a></li>
											<li><a href="javascript:searchData('cheg=2500-5000')">2500-5000</a></li>
										</ul>
										</li>
									</ul>
								</div>
								<div class="form-group">
									<ul class="nav navbar-nav navbar-left">
										<li class="dropdown">
										<a href="#" class="dropdown-toggle btn btn-default" data-toggle="dropdown">发证机构<b class="caret"></b></a>
										<ul class="dropdown-menu">
											<li><a href="javascript:searchData('fazjg=泰州市运输管理处')">泰州市运输管理处</a></li>
											<li><a href="javascript:searchData('fazjg=靖江市运输管理处')">靖江市运输管理处</a></li>
										</ul>
										</li>
									</ul>
								</div>
								<div class="form-group">
									<ul class="nav navbar-nav navbar-right">
										<li class="dropdown">
										<a href="#" class="dropdown-toggle btn btn-default" data-toggle="dropdown">座位数<b class="caret"></b></a>
										<ul class="dropdown-menu">
											<li><a href="javascript:searchData('hedzws=2')">2</a></li>
											<li><a href="javascript:searchData('hedzws=3')">3</a></li>
											<li><a href="javascript:searchData('hedzws=4')">4</a></li>
											<li><a href="javascript:searchData('hedzws=5')">5</a></li>
											<li><a href="javascript:searchData('hedzws=6')">6</a></li>
											<li><a href="javascript:searchData('hedzws=7')">7</a></li>
											<li><a href="javascript:searchData('hedzws=8')">8</a></li>
										</ul>
										</li>
									</ul>
								</div>
								<div class="form-group"><button type="submit" class="dropdown-toggle btn btn-default" onclick="return searchData()" class="btn btn-default glyphicon glyphicon-search">搜索</button></div>
							</form>
						</div>
					</nav>
					<div class="table-responsive text-center result" >
						<article class="htmleaf-container">
							<div id="wrapper" class="main" >
								<section>
									<table class="table table-hover table-bordered ">
										<thead>
											<tr style="background-color:#33a8b2 ; color: #fff; font-size:2.5rem;">
												<th>序号</th>
												<th>车辆（挂车）牌号</th>
												<th>颜色</th>
												<th>车高（米）</th>
												<th>车长（米）</th>
												<th>发证机构</th>
												<th>发动机型号</th>
												<th>核定座位数</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody><#-- 数据S -->
											
											
											
										</tbody><#-- 数据 E-->
						        	</table>
									<div id="pagination-btn"style="padding-bottom: 20px; padding-right: 20px;"></div>
								</section>
							</div>
						</article>
					</div>
				</div>
				<#--列表E -->
		
		</div>
		<script src="${ctx}/resource/js/pagination.js"></script>
		<script>
			var htmllist="<td>@{seq}</td><td>@{cheph}</td><td>@{chepys}</td><td>@{cheg}</td><td>@{chec}</td><td>@{fazjg}</td><td>@{fadjxh}</td><td>@{hedzws}</td><td><a href='##'> 查看</a></td>";
			var container;
			
			var options = {
				pageSize: 10,
				
				dataSource: '${ctx}/business/yunguan/chelxxJson',
				
				locator: 'data',
				totalNumber: ${page.totalNumber},
				className: 'paginationjs-theme-blue',
				    
				callback: function(response, pagination) {
				
					var dataHtml = '';
					$.each(response, function(index, item) {
						dataHtml += '<tr>'
						 + htmllist.replace("@{cheph}", item.cheph == null ? '未知' : item.cheph)
						 		   .replace("@{seq}", (pagination.pageNumber - 1) * pagination.pageSize + index)
						 		   .replace("@{chepys}", item.chepys == null ? '未知' : item.chepys)
						 		   .replace("@{cheg}", item.cheg == null ? '未知' : item.cheg)
						 		   .replace("@{chec}", item.chec == null ? '未知' : item.chec)
						 		   .replace("@{fazjg}", item.fazjg == null ? '未知' : item.fazjg)
						 		   .replace("@{fadjxh}", item.fadjxh == null ? '未知' : item.fadjxh)
						 		   .replace("@{hedzws}", item.hedzws == null ? '未知' : item.hedzws)
						 + '</tr>';
					});
					container.prev().children("tbody").html(dataHtml);
				}
			};
				
			function createDemo(name) {
				container = $('#pagination-' + name);
				container.pagination(options);
				return container;
			}
				
			$(function() {
				createDemo('btn');
			});


			function searchData(subQuery){
				if(subQuery != null){
					if(options.dataSource.indexOf("?") != -1){
						options.dataSource = options.dataSource += "&" + encodeURI(encodeURI(subQuery));
					}else{
						options.dataSource = options.dataSource += "?" + encodeURI(encodeURI(subQuery));
					}
				}
				createDemo('btn');
				return false;
			}
		
		</script>
	</body>

</html>