<@PAGE.HTML title="编辑任务">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%">
		<form id="form" action="${ctx}/system/job/saveJob" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%" border="0" class="form-data">
			
				<tr>
					<td style="width:12%;text-align:right">任务展示名称</td>
					<td>
						<input name="name" style="border-left:15px solid #FF8000;" class="easyui-validatebox" value="${job.name}" data-options=missingMessage:"任务展示名称不能为空",required:true maxLength="255"/>
					</td>
				</tr>
				
				<tr>
					<td style="width:12%;text-align:right">JobName</td>
					<td>
						<input name="jobName" style="border-left:15px solid #FF8000;" class="easyui-validatebox" <#if operation == 'edit'>readOnly</#if> value="${job.jobName}" data-options=required:true,missingMessage:"jobName不能为空",validType:["Pattern['^[A-Za-z_-]{1,255}$','英文或下划线']"<#if operation == "add">,"Remoto['${ctx}/system/job/isExitsJobName','jobName','jobName已存在']"</#if>] />
					</td>
				</tr>
				
				<tr>
					<td style="width:12%;text-align:right">执行类</td>
					<td>
						<input name="jobClass" style="border-left:15px solid #FF8000;" class="easyui-validatebox" value="${job.jobClass}" data-options=required:true,missingMessage:"执行类不能为空",validType:["Pattern['^[A-Za-z_.-]{1,255}$','英文,点或下划线']","Remoto['${ctx}/system/job/isFoundJobClass','jobClass','没有找到该执行类']"] />
					</td>
				</tr>
				
				<tr>
					<td style="width:12%;text-align:right">CONR表达式</td>
					<td>
						<input name="cronExpression" style="border-left:15px solid #FF8000;" class="easyui-validatebox" value="${job.cronExpression}" data-options=required:true,missingMessage:"cronExpression不能为空" maxLength="20"/>
					</td>
				</tr>
				
				<tr>
					<td style="width:12%;text-align:right">状态</td>
					<td>
						<@SingleSelectTag name="status" style="border-left:15px solid #FF8000;" optName="job_status" 
							selected="${job.status}" class="easyui-validatebox" data_options="required:true,missingMessage:\"选择状态\"" />
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">任务说明</td>
					<td colspan="3">
						<textarea name="description" rows="4">${job.description}</textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="operation" value="${operation}"/> <#-- 带回操作类型 -->
						<input type="hidden" name="parentWinId" value="${parentWinId}"/> <#-- 持有父窗口的引用, 用于操作父窗口响应 -->
						<input type="hidden" name="winId" value="editJob"/> <#-- 该窗口ID, 用于关闭窗口 -->
						
						<#if operation=='add'>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">添加</a>&nbsp;
					    <#else>
					    	<input type="hidden" name="id" value="${job.id}"/>
					    	<input type="hidden" name="running" value="${job.running}"/>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">更新</a>&nbsp;
						</#if>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('editJob')">关闭</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</@PAGE.HTML>