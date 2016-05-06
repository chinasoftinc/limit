<@PAGE.HTML title="">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%">
		<form id="form" name="form" action="${ctx}/system/dictionary/saveDictionary" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%" border="0" class="form-data">
			
				<#-- 根据编辑类型生成上级标识 -->
				<#if parent.id != null>
				<tr>
					<#if dictionary.optIsDir == '1'>
					<td style="width:12%;text-align:right">上级目录</td>
					<td><input readOnly value="${parent.optDescription}" /></td>
					<#elseif dictionary.optType == '2'>
					<td style="width:12%;text-align:right">当前目录</td>
					<td><input readOnly value="${parent.optDescription}" /></td>
					<#elseif dictionary.optType == '1'>
					<td style="width:12%;text-align:right">所属选项组</td>
					<td><input readOnly value="${parent.optName}" /></td>
					</#if>
					<td style="width:12%">&nbsp;</td>
				</tr>
				</#if>
				
				<#-- 根据编辑类型指定输入组件 -->
				<tr>
					<td style="width:12%;text-align:right">
						<#if dictionary.optIsDir == '1'>
						目录名称
						<#elseif dictionary.optType == '2'>
						选项组名称
						<#else>
						键
						</#if>
					</td>
					<td>
						<#if dictionary.optIsDir == '0' && dictionary.optType == '1'>
						<input name="optKey" class="easyui-validatebox" value="${dictionary.optKey}" data-options=missingMessage:"键不能为空",required:true,validType:["Pattern['^[A-Za-z0-9_.@#*]{1,50}$','请输入50位英文或数字']","Remoto['${ctx}/system/dictionary/isExitsOptKey?id=${dictionary.id}&optParentId=${parent.id}','optKey','该键已存在']"] />
						<#elseif dictionary.optIsDir == '1'>
						<input name="optDescription" class="easyui-validatebox" value="${dictionary.optDescription}" maxLength="50" data-options=required:true,missingMessage:"目录名称不能为空" />
						<#else>
						<input name="optName" class="easyui-validatebox" value="${dictionary.optName}" data-options=missingMessage:"选项字典名称不能为空",required:true,validType:["Pattern['^[A-Za-z0-9_.@#*]{1,50}$','请输入50位英文或数字']","Remoto['${ctx}/system/dictionary/isExitsOptName?id=${dictionary.id}','optName','该字典名称已存在']"] />
						</#if>
					</td>
				</tr>
				
				<#if dictionary.optType == '1' && dictionary.optIsDir == '0'>
				<tr>
					<td style="width:12%;text-align:right">值</td>
					<td>
						<input name="optValue" class="easyui-validatebox" value="${dictionary.optValue}" maxLength="250" data-options=required:true,missingMessage:"字典值不能为空" />
					</td>
				</tr>
				</#if>
				
				<#if dictionary.optIsDir == '0'>
				<tr>
					<td style="width:12%;text-align:right">说明</td>
					<td colspan="3">
						<input name="optDescription" value="${dictionary.optDescription}" class="easyui-validatebox" maxLength="250" data-options=required:true,missingMessage:"说明不能为空" />
					</td>
				</tr>
				</#if>
				
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="optParentId" value="${parent.id}" />
						<input type="hidden" name="optType" value="${dictionary.optType}" />
						<input type="hidden" name="optIsDir" value="${dictionary.optIsDir}" />
						<input type="hidden" name="optDeep" value="${dictionary.optDeep}" />
						<#if dictionary.optType == '1' && dictionary.optIsDir == '0'>
						<input type="hidden" name="optName" value="${parent.optName}"/>
						</#if>
						
						<input type="hidden" name="operation" value="${operation}"/>
						<input type="hidden" name="parentWinId" value="${parentWinId}"/>
						<input type="hidden" name="winId" value="${winId}"/>
						
						
						<#if operation=='add'>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">添加</a>&nbsp;
					    <#else>
					    	<input type="hidden" name="id" value="${dictionary.id}"/>
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