<@PAGE.HTML title="查看用户操作记录">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%">
		<table width="100%" border="0" class="form-data">
			<tr>
				<td style="width:12%;text-align:right;">
					<div style="width:80px;border-left:7px solid #FF8000"><b>管理员帐号</b></div>
				</td>
				<td style="padding-left:20px;">
					${user.username}
				</td>
			</tr>
			
			<tr>
				<td style="width:12%;text-align:right;">
					<div style="width:80px;border-left:7px solid #FF8000"><b>管理员昵称</b></div>
				</td>
				<td style="padding-left:20px;">
					${user.nickname}
				</td>
			</tr>

			<tr>
				<td style="width:12%;text-align:right;">
					<div style="width:80px;border-left:7px solid #FF8000"><b>操作类型</b></div>
				</td>
				<td style="padding-left:20px;">
					${userOpt.optType}
				</td>
			</tr>

			<tr>
				<td style="width:12%;text-align:right;">
					<div style="width:80px;border-left:7px solid #FF8000"><b>实体类型</b></div>
				</td>
				<td style="padding-left:20px;">
					${userOpt.entityType}
				</td>
			</tr>
			
			<tr>
				<td style="width:12%;text-align:right;">
					<div style="width:80px;border-left:7px solid #FF8000"><b>实体ID</b></div>
				</td>
				<td style="padding-left:20px;">
					${userOpt.entityId}
				</td>
			</tr>
			
			<tr>
				<td style="width:12%;text-align:right;">
					<div style="width:80px;border-left:7px solid #FF8000"><b>实体标题</b></div>
				</td>
				<td style="padding-left:20px;">
					${userOpt.entityTitle}
				</td>
			</tr>
			
			<tr>
				<td style="width:12%;text-align:right;">
					<div style="width:80px;border-left:7px solid #FF8000"><b>操作时间</b></div>
				</td>
				<td style="padding-left:20px;">
					${userOpt.optTime?string('yyyy-MM-dd HH:mm:ss')}
				</td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align:center">
					<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('checkOpt')">关闭</a>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</@PAGE.HTML>