<@PAGE.HTML title="编辑参数">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%;">
		<form id="form" action="${ctx}/system/parameter/saveParameter" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%" border="0" class="form-data">
			
				<#-- 根据编辑类型生成上级标识 -->
				<#if parent.id != null>
				<tr>
					<#if parameter.optIsDir == '1'>
					<td style="width:12%;text-align:right">上级目录</td>
					<td><input readOnly value="${parent.optDescription}" /></td>
					<#else>
					<td style="width:12%;text-align:right">当前目录</td>
					<td><input readOnly value="${parent.optDescription}" /></td>
					</#if>
					<td style="width:12%">&nbsp;</td>
				</tr>
				</#if>
				
				<#-- 根据编辑类型指定输入组件 -->
				<tr>
					<td style="width:12%;text-align:right">
						<#if parameter.optIsDir == '1'>
						目录名称
						<#else>
						参数名称
						</#if>
					</td>
					<td>
						<#if parameter.optIsDir == '1'>
						<input name="optDescription" class="easyui-validatebox" value="${parameter.optDescription}" maxLength="50" data-options=required:true,missingMessage:"目录名称不能为空" />
						<#else>
						<input name="optName" class="easyui-validatebox" value="${parameter.optName}" data-options=missingMessage:"参数名称不能为空",required:true,validType:["Pattern['^[A-Za-z0-9_.@#*]{1,50}$','请输入50位英文或数字']","Remoto['${ctx}/system/parameter/isExitsOptName?id=${parameter.id}','optName','该参数名称已存在']"] />
						</#if>
					</td>
				</tr>
				
				<#if parameter.optIsDir == '0'>
				<tr>
					<td style="width:12%;text-align:right">参数值</td>
					<td>
						<input name="optValue" class="easyui-validatebox" value="${parameter.optValue}" maxLength="50" data-options=required:true,missingMessage:"参数值不能为空" />
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">参数说明</td>
					<td colspan="3">
						<input name="optDescription" value="${parameter.optDescription}" class="easyui-validatebox" maxLength="250" data-options=required:true,missingMessage:"参数说明不能为空" />
					</td>
				</tr>
				</#if>
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="optParentId" value="${parent.id}" />
						<input type="hidden" name="optType" value="${parameter.optType}" />
						<input type="hidden" name="optIsDir" value="${parameter.optIsDir}" />
						<input type="hidden" name="optDeep" value="${parameter.optDeep}" />
						
						<input type="hidden" name="operation" value="${operation}"/>
						<input type="hidden" name="parentWinId" value="${parentWinId}"/>
						<input type="hidden" name="winId" value="${winId}"/>
						
						<#if operation=='add'>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">添加</a>&nbsp;
					    <#else>
					    	<input type="hidden" name="id" value="${parameter.id}"/>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">更新</a>&nbsp;
						</#if>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('${winId}')">关闭</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</@PAGE.HTML>