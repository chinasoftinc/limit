<form id="form" action="" method="POST" onsubmit="return commitData(this)">
<#if operation=='read'>
<div id="form_tab" class="easyui-tabs" style="height:100%;" data-options="border:false,fit:true">
</#if>

    <div title="基本信息" style="padding:4px 1px 4px 1px;">
    	<table width="100%" border="0" class="form-data" style="overflow:hidden">
    		
    		<#--上级 -->
    		<#if parent.id != null>
				<tr>
					<td style="width:15%;text-align:right">${(parent.deptType == '0')?string('上级机构','上级部门')}</td>
					<td>
						<input value="${parent.deptName}" disabled/>
					</td>
				</tr>
			</#if>
			
    		<#--简称 -->
			<tr>
				<td style="width:15%;text-align:right">${(dept.deptType == '0')?string('机构简称','部门简称')}</td>
				<td>
					<input ${(operation == 'read')?string('disabled','')} name="deptShortName" class="easyui-validatebox" value='${dept.deptShortName}' data-options=required:true,validType:["Trims['部门简称不能为空']"],animate:true,lines:true,missingMessage:"简称不能为空" maxLength="50"/>
				</td>
			</tr>
			
			<#--名称 -->
			<tr>
				<td style="width:15%;text-align:right">${(dept.deptType == '0')?string('机构名称','部门名称')}</td>
				<td>
					<input ${(operation == 'read')?string('disabled','')} name="deptName" class="easyui-validatebox" value='${dept.deptName}' data-options=required:true,validType:["Trims['部门名称不能为空']"],animate:true,lines:true,missingMessage:"名称不能为空" maxLength="50"/>
				</td>
			</tr>
			
			<#-- 地区代码 -->
			<tr>
				<td style="width:15%;text-align:right">地区代码</td>
				<td>
					<input ${(operation == 'read')?string('disabled','')} name="deptAreaCode" class="easyui-validatebox" value='${dept.deptAreaCode}' data-options=required:true,validType:["Pattern['^[0-9]{1,20}$','请输入20位数字']","Trims['地区代码不能为空']"],animate:true,lines:true,missingMessage:"地区代码不能为空" maxLength="20"/>
				</td>
			</tr>
			
			<#-- 区县代码 -->
			<#if dept.deptType == '0'>
			<tr>
				<td style="width:15%;text-align:right">区县代码</td>
				<td>
					<input ${(operation == 'read')?string('disabled','')} name="deptDistrictCode" class="easyui-validatebox" value='${dept.deptDistrictCode}' data-options=required:true,validType:["Pattern['^[0-9]{1,20}$','请输入20位数字']","Trims['区县代码不能为空']"],animate:true,lines:true,missingMessage:"区县代码不能为空" maxLength="20"/>
				</td>
			</tr>
			</#if>
			
			<tr><td style="height:8px"></td></tr>
			
			<tr>
				<td style="width:15%;text-align:right">${(dept.deptType == '0')?string('机构备注','部门备注')}</td>
				<td>
					<textarea ${(operation == 'read')?string('disabled','')} name="deptDescription" rows="15" style="width:400px" class="easyui-validatebox" maxLength="255" >${dept.deptDescription}</textarea>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<input type="hidden" name="deptType" value="${dept.deptType}"/>
					<input type="hidden" name="deptParentId" value="${parent.id}" />
					<input type="hidden" name="deptDeep" value="${dept.deptDeep}" />
					<input type="hidden" name="versionNo" value="${dept.versionNo?default('0')}" />
					
					<input type="hidden" name="operation" value="${operation}"/>
					<input type="hidden" name="parentWinId" value="${parentWinId}"/>
					<input type="hidden" name="winId" value="${winId}"/>
					
					<#if operation=='add'>
						<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">添加</a>&nbsp;
				    <#elseif operation=='edit'>
				    	<input type="hidden" name="id" value="${dept.id}"/>
						<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">更新</a>&nbsp;
					<#else>
						<a href="#" onclick="editDept()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
					</#if>
					<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#editPanel').panel('close')">关闭</a>
				</td>
			</tr>
		</table>
    </div>
    
<#if operation=='read'>
    <div title="用户列表" style="padding:4px 1px 4px 1px;"><div>
</div>
</#if>
</form>