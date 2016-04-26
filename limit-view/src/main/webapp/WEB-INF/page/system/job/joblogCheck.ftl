<@PAGE.HTML title="查看任务日志">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%">
		<table width="100%" border="0" class="form-data">
			<tr>
				<td style="width:20%;text-align:right">jobName&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					${joblog.jobName}
				</td>
			</tr>
			<tr>
				<td style="text-align:right">开始时间&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					${joblog.runBegin?string('yyyy-MM-dd HH:ss:mm')}
				</td>
			</tr>
			<tr>
				<td style="text-align:right">结束时间&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					${joblog.runEnd?string('yyyy-MM-dd HH:ss:mm')}
				</td>
			</tr>
			<tr>
				<td style="text-align:right">执行结果&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					${joblog.result}
				</td>
			</tr>
			<tr>
				<td style="text-align:right" valign="top">任务执行结果描述&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td valign="top">
					${joblog.resultDescription}
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</@PAGE.HTML>