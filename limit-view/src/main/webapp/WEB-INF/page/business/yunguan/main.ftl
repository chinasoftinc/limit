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
							<form id="searchInput" class="navbar-form navbar-left" role="search">
								<div class="form-group">
									颜色
									<select id="query_chepys" class="dropdown-toggle btn btn-default" data-toggle="dropdown" >
										<option value=""></option>
										<#list chepysList as item>
										<option value="${item}">${item}</option>
										</#list>
									</select>
								</div>
								<div class="form-group">
									<input id="query_cheph" type="text" class="form-control" placeholder="车牌">
								</div>
								<div class="form-group">
									车高
									<select id="query_cheg" class="dropdown-toggle btn btn-default" data-toggle="dropdown" >
										<option value=""></option>
										<option value="1500-1999">1500-1999</option>
										<option value="2000-2499">2000-2499</option>
										<option value="2500-5000">2500-5000</option>
									</select>
								</div>
								<div class="form-group">
									发证机构
									<select id="query_fazjg" class="dropdown-toggle btn btn-default" data-toggle="dropdown" >
										<option value=""></option>
										<#list fazjgList as item>
										<option value="${item}">${item}</option>
										</#list>
									</select>
								</div>
								<div class="form-group">
									座位数
									<select id="query_hedzws" class="dropdown-toggle btn btn-default" data-toggle="dropdown" >
										<option value=""></option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
									</select>
								</div>
								<div class="form-group"><input type="button" class="dropdown-toggle btn btn-default" onclick="searchData()" class="btn btn-default glyphicon glyphicon-search" value="搜索"></input></div>
								<div class="form-group"><input type="button" class="dropdown-toggle btn btn-default" onclick="cleanSearch()" class="btn btn-default glyphicon glyphicon-search" value="重置"></input></div>
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
				if(container != null){
					container.pagination("destroy");
				}
				container = $('#pagination-' + name);
				container.pagination(options);
				return container;
			}
				
			var srcQuery;
			$(function() {
				srcQuery = options.dataSource;
				createDemo('btn');
			});

			function searchData(){
				var query_chepys = $("#query_chepys").val();
				var query_cheph = $("#query_cheph").val();
				var query_cheg = $("#query_cheg").val();
				var query_hedzws = $("#query_hedzws").val();
				var query_fazjg = $("#query_fazjg").val();
				
				var subQuery = "?";
				if(query_chepys != ""){
					subQuery += "chepys=" + query_chepys + "&";
				}
				if(query_cheph != ""){
					subQuery += "cheph=" + query_cheph + "&";
				}
				if(query_cheg != ""){
					subQuery += "chegRange=" + query_cheg + "&";
				}
				if(query_hedzws != ""){
					subQuery += "hedzws=" + query_hedzws + "&";
				}
				if(query_fazjg != ""){
					subQuery += "fazjg=" + query_fazjg + "&";
				}
				
				console.info(srcQuery);
				console.info(options.dataSource);
				options.dataSource = srcQuery;
				options.dataSource = options.dataSource + encodeURI(encodeURI(subQuery));
				
				$.ajax({url : options.dataSource,type : 'post',dataType : 'json',async:false,data : {},
					success : function(NULL, success, jqXHR) {
						var rs = eval("(" + jqXHR.responseText + ")");
						options.totalNumber = rs.totalNumber == 0 ? 1 : rs.totalNumber;
					}
			
				});
				
				createDemo('btn');
				return false;
			}
			
			function cleanSearch(){
				$("#searchInput")[0].reset();
			}
		
		</script>
	</body>

</html>