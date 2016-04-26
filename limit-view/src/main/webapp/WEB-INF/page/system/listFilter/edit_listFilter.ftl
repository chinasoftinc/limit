<#-- 编辑筛选条件-->
<@PAGE.HTML title="编辑筛选条件">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%;">
		<form id="form" action="${ctx}/system/entityType/listFilter/save" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%;border="0" class="form-data" >
				<tr>
					<td style="width:15%;text-align:right">
						筛选类型<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="不同类型筛选对应不同参数"/>
					</td>
					<td>
						<@RadioTag name="filterType" optName="filter_type" checked="${listFilter.filterType}" defaultChecked="0" style="width:12px;height:11px" />
					</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td style="width:15%;text-align:right">
						参数名称<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="筛选条件提交参数名称"/>
					</td>
					<td>
						<input name="filterName" value="${listFilter.filterName}" style="border-left:15px solid #ccc;" maxLength="50" />
					</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td style="width:15%;text-align:right">
						选项字典KEY<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="如果是选项字典类型, 请填写选项字典的索引KEY"/>
					</td>
					<td>
						<input name="filterOptdicKey" value="${listFilter.filterOptdicKey}" style="border-left:15px solid #ccc;" maxLength="100" />
					</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td style="width:15%;text-align:right">
						上级地区<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="如果是地区类型, 请选择上级地区, 筛选会将下级地区列为条件"/>
					</td>
					<td>
						<@PAGE.SELECT datas=parentAreas optKey="areaid" optVal="areaname" selected="${listFilter.filterAreaParentId}" id="filterAreaParentId" name="filterAreaParentId" class="easyui-validatebox" style="border-left:15px solid #ccc;" />
					</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td style="width:15%;text-align:right">
						实体类型<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="如果是实体类型类型, 请选择实体类型, 筛选会将该实体类型的所有记录作为条件"/>
					</td>
					<td>
						<@PAGE.SELECT datas=entityTypes optKey="id" optVal="entityName" selected="${listFilter.filterEntityType}" id="filterEntityType" name="filterEntityType" class="easyui-validatebox" style="border-left:15px solid #ccc;" />
					</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="operation" value="${operation}"/> <#-- 带回操作类型 -->
						<input type="hidden" name="parentWinId" value="${parentWinId}"/> <#-- 持有父窗口的引用, 用于操作父窗口响应 -->
						<input type="hidden" name="winId" value="edit_listFilter"/> <#-- 当前窗口ID, 用于跳转到其他页面后, 关闭当前窗口 -->
						<input type="hidden" name="entityTypeId" value="${listFilter.entityTypeId}" /> <#-- 所属实体类型ID -->

						<#if operation=='add'>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">添加</a>&nbsp;
					    <#else>
					    	<input type="hidden" name="id" value="${listFilter.id}"/>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">更新</a>&nbsp;
						</#if>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('edit_listFilter')">关闭</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>

</body>
</@PAGE.HTML>