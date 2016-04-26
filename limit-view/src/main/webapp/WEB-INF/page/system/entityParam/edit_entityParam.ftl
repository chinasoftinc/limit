<#-- 页面数据配置 -->
<@PAGE.HTML title="页面数据配置">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%;">
		<form id="form" action="${ctx}/system/entityType/entityParam/save" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%;border="0" class="form-data" >
				<tr>
					<td style="width:15%;text-align:right">参数名称</td>
					<td>
						<input name="paramKey" value="${entityParam.paramKey}" style="border-left:15px solid #FF8000;" maxLength="30" />
					</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td style="width:15%;text-align:right">
						实体类型<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="所需数据的实体类型"/>
					</td>
					<td>
						<@PAGE.SELECT datas=entityTypes optKey="id" optVal="entityName" selected="${entityParam.requiredEntityId}" id="requiredEntityId" name="requiredEntityId" class="easyui-validatebox" style="border-left:15px solid #ccc;" />
					</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td style="width:15%;text-align:right">所需数量</td>
					<td>
						<select name="requiredNum" style="border-left:15px solid #FF8000;">
							<#list 1..50 as no>
								<#if no == entityParam.requiredNum>
									<option value="${no}" selected="selected">${no}</option>
								<#else>
									<option value="${no}">${no}</option>
								</#if>
							</#list>
						</select>
					</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="operation" value="${operation}"/> <#-- 带回操作类型 -->
						<input type="hidden" name="parentWinId" value="${parentWinId}"/> <#-- 持有父窗口的引用, 用于操作父窗口响应 -->
						<input type="hidden" name="winId" value="edit_entityParam"/> <#-- 当前窗口ID, 用于跳转到其他页面后, 关闭当前窗口 -->
						<input type="hidden" name="entityId" value="${entityParam.entityId}" /> <#-- 所属实体类型ID -->

						<#if operation=='add'>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">添加</a>&nbsp;
					    <#else>
					    	<input type="hidden" name="id" value="${entityParam.id}"/>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">更新</a>&nbsp;
						</#if>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('edit_entityParam')">关闭</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>

</body>
</@PAGE.HTML>