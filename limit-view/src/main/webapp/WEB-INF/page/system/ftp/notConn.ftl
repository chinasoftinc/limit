<@PAGE.HTML title="FTP未连接" >
<body style="margin: 5px">
	<div style="text-align:center;width:100%;height:100%;background:#eee">
		<br/><br/><br/><br/>
		<div id="connection" style="margin:0">未连接,<a href="${ctx}/system/ftp/list?path=ftp_connection" onclick="progress()">点击连接</a></div>
		<div id="progressbar" style="width:400px;margin:auto"></div>
	</div>
	
	<script>
		var flag = false;
		var progressVal = 0;
		function progress(){
			$('#progressbar').progressbar({ 
				value:progressVal,
				text: '连接中'
			});
			if(progressVal < 100){
				progressVal += 1;
			}else{
				progressVal = 0;
			}
			if(!flag){
				$("#connection").hide();
				flag = true;
				sh=setInterval(progress,30);
			}
		}
	</script>
</body>
</@PAGE.HTML>