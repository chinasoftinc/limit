<@PAGE.HTML title="编辑选项字典">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%">
		<form id="form" action="${ctx}/system/attribute/saveOptdic" method="POST" onsubmit="return $(this).form('validate')">
			<table width="100%" border="0" class="form-data">
				<tr>
					<td style="width:12%;text-align:right">父选项组</td>
					<td>
						<select name="parentId" class="easyui-validatebox" data-options=required:true,missingMessage:"选择父选项组" onChange="skipValidate(this)" onChange="skipValidate(this)">
							 <option value=""></option>
							 <option value="0" <#if optdic.id?has_content>selected</#if>>选项组</option>
							 <#list optdicGroup as m>
						 	 <option <#if optdic.parentId == m.id>selected</#if> value="${m.id}">${m.optName} - ${m.description}</option>
							 </#list>
						</select>
					</td>
					<td style="width:12%">&nbsp;</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">字典名称</td>
					<td>
						<input name="optName" <#if operation == "edit">readOnly</#if> class="easyui-validatebox" value="${optdic.optName}" data-options=missingMessage:"选项字典名称不能为空",required:true,validType:["Pattern['^[A-Za-z0-9_.@#*]{1,100}$','100位英文或数字,不能重复']"<#if operation == "add">,"Remoto['${ctx}/system/attribute/isExitsOptdic','optName','该选项字典名称已存在']"</#if>] />
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">键</td>
					<td>
						<input name="optKey" class="easyui-validatebox" value="${optdic.optKey}" data-options=required:true,missingMessage:"选项字典键不能为空",validType:["Pattern['^[A-Za-z0-9_]{1,20}$','英文或数字,同组不同重复']"] />
					</td>
				</tr>
				<tr>
					<td style="width:12%;text-align:right">值</td>
					<td>
						<input name="optVal" class="easyui-validatebox" value="${optdic.optVal}" data-options=required:true,missingMessage:"选项字典值不能为空" />
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
						<input type="hidden" name="winId" value="editOptdic"/> <#-- 该窗口ID, 用于关闭窗口 -->
						
						<#if operation=='add'>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">添加</a>&nbsp;
					    <#else>
					    	<input type="hidden" name="id" value="${optdic.id}"/>
							<a href="#" class="easyui-linkbutton" onclick="$(this).closest('form').submit();" iconCls="icon-save">更新</a>&nbsp;
						</#if>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('editOptdic')">关闭</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>

<script>
	<#-- 父选项组跳过字典名称验证js -->
	$(function(){
		if($("select[name='parentId']")[0].value == "0"){
			$("input[name='optKey']").removeClass('validatebox-invalid').attr("disabled",true);
			$("input[name='optVal']").removeClass('validatebox-invalid').attr("disabled",true);
		}else{
			$("input[name='optName']").removeClass('validatebox-invalid').attr("disabled",true).val("");
		}
	})
	function skipValidate(select){
		if(select.value == "0"){
			$("input[name='optKey']").removeClass('validatebox-invalid').attr("disabled",true).val("");
			$("input[name='optVal']").removeClass('validatebox-invalid').attr("disabled",true).val("");
			$("input[name='optName']").addClass('validatebox-invalid').attr("disabled",false);
		}else{
			$("input[name='optKey']").addClass('validatebox-invalid').attr("disabled",false);
			$("input[name='optVal']").addClass('validatebox-invalid').attr("disabled",false);
			$("input[name='optName']").removeClass('validatebox-invalid').attr("disabled",true).val("");
		}
	}
</script>
</body>
</@PAGE.HTML>