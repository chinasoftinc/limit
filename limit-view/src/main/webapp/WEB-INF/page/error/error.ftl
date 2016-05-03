<@PAGE.HTML title="系统异常页面">
<style>
	.info_01 {
		border-right: 0px solid;
		border-top: 0px solid;
		border-left: 0px solid;
		width: 5px;
		border-bottom: 0px solid;
		background-repeat: no-repeat;
		height: 95px;
		background-color: transparent;
	}
	
	.info_03 {
		border-right: 0px solid;
		border-top: 0px solid;
		border-left: 0px solid;
		background-repeat: no-repeat;
		width: 3px;
		border-bottom: 0px solid;
		height: 95px;
		background-color: transparent;
	}
	
	.info_02 {
		border-right: 0px solid;
		border-top: 0px solid;
		border-left: 0px solid;
		border-bottom: 0px solid;
		height: 95px;
		background-color: transparent;
	}
</style>
<body style="margin:5px;background:#eee;overflow:hidden;">
	<div style="width: 100%;height:100%;background:url('${ctx}/resource/img/error.png');background-position:center;">
		<div style="filter:alpha(opacity=70);-moz-opacity:0.70;opacity:0.70;position:relative;top:35%">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="background:#fff">
				<tr>
					<td class="info_01"></td>
					<td class="info_02" valign="middle" align="center">
					<table style="text-align:center">
					<tr>
						<td>
							<font color=red><b>出错了，请及时联系系统管理员以协助您解决此问题！</b></font>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							${exception}
						</td>
					</tr>
					</table>
					</td>
					<td class="info_03"></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</@PAGE.HTML>
