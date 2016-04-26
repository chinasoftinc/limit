<@PAGE.HTML title="编辑参数">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%;">
		<form id="form" action="${ctx}/system/attribute/saveParam" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%" border="0" class="form-data">
				<tr>
					<td style="width:12%;text-align:right">参数名称 </td>
					<td>
						<input name="optKey" <#if operation=='edit'>readOnly</#if> class="easyui-validatebox" value="${optdic.optKey}" data-options=missingMessage:"参数名称不能为空",required:true,validType:["Pattern['^[A-Za-z0-9_.-]{1,100}$','100位中英文或数字']"<#if operation == "add">,"Remoto['${ctx}/system/attribute/isExitsParam','optKey','该参数名称已存在']"</#if>] />
					</td>
					<td style="width:12%">&nbsp;</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">参数值</td>
					<td>
						<input name="optVal" class="easyui-validatebox" value="${optdic.optVal}" data-options=required:true,missingMessage:"参数值不能为空" />
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">说明</td>
					<td colspan="3">
						<textarea name="description" rows="3">${optdic.description}</textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="operation" value="${operation}"/> <#-- 带回操作类型 -->
						<input type="hidden" name="parentWinId" value="${parentWinId}"/> <#-- 持有父窗口的引用, 用于操作父窗口响应 -->
						<input type="hidden" name="winId" value="editParam"/> <#-- 该窗口ID, 用于关闭窗口 -->
						
						<#if operation=='add'>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">添加</a>&nbsp;
					    <#else>
					    	<input type="hidden" name="id" value="${optdic.id}"/>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">更新</a>&nbsp;
						</#if>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('editParam')">关闭</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</@PAGE.HTML>