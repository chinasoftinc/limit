<#-- 编辑实体分类-->
<@PAGE.HTML title="编辑实体分类">
<body style="margin:5px;background:#eee">
<div style="width: 100%;height:100%;">
	<div style="width: 100%;">
		<table width="100%;border="0" class="form-data">
			<tr>
				<td style="width:15%;text-align:right">
					数据类型<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="详情数据实体类型"/>
				</td>
				<td>
					<@PAGE.SELECT datas=entityTypes optKey="id" optVal="entityName" id="entityType" style="border-left:15px solid #FF8000;"/>
				</td>
				<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td style="width:15%;text-align:right">
					参数名称<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="静态化句柄名称"/>
				</td>
				<td>
					<input id="paramKey" style="border-left:15px solid #FF8000;" maxLength="30" />
				</td>
				<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td style="width:15%;text-align:right">
					所需数量<img src="${ctx}/resource/img/notice.gif" style="margin-top:-3px" title="数据所需要的数量"/>
				</td>
				<td>
					<select id="dataNum" style="border-left:15px solid #FF8000;">
						<#list 1..50 as no>
							<option value="${no}">${no}</option>
						</#list>
					</select>
				</td>
				<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<a href="#" class="easyui-linkbutton" onclick="addData()" iconCls="icon-save">添加</a>&nbsp;
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<a href="#" class="easyui-linkbutton" onclick="saveData()" iconCls="icon-save">保存</a>&nbsp;
					<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('configData')">关闭</a>
				</td>
			</tr>
		</table>
	</div>
	
	<#-- 数据显示区域 -->
	<div id="dataRecord"></div>
</div>

<script>

	<#-- 获取父窗口 -->
	var father_win = $.getRootWindow().$("#${parentWinId}")[0].contentWindow;
	

	<#-- 获取原先父窗口的数据 -->	
	var ids = father_win.$("#dataConfigEntityTypeIdArr").val();
	var keys = father_win.$("#dataConfigParamKeyArr").val();
	var nums = father_win.$("#dataConfigNumArr").val();
	
	if(ids == "" || ids == null || keys == null || keys.trim() == "" || nums == "" || nums == null){
	}else{
		idArr = ids.split(",");
		keyArr = keys.split(",");
		numArr = nums.split(",");
		
		for(var i = 0; i < idArr.length; i++){
			$("#dataRecord").append("<p style='font-size:8px;line-height:6px;border-left:7px solid #FF8000' " +
			"id='" + idArr[i] + "' paramkey='" + keyArr[i] + "' datanum='" + numArr[i] + "'>" +
			"实体类型:" + $("#" + idArr[i]).text() + "      参数名称:" + keyArr[i] + "      数量:" + numArr[i] + " <a style='cursor:pointer' onclick='removeRecord(this)'>删除</a></p>");
		}
	}
	
	<#-- 添加数据类型 -->
	function addData(){
		var id = $("#entityType option:selected").val();
		var typeName = $("#entityType option:selected").text();
		var paramKey = $("#paramKey").val();
		var dataNum = $("#dataNum").val();
		if(id == "" || id == null || paramKey == null || paramKey.trim() == "" || dataNum == "" || dataNum == null){
			alert("请填入必须参数");
		}else{
			$("#dataRecord").append("<p style='font-size:8px;line-height:6px;border-left:7px solid #FF8000' id='" + id + "' paramkey='" + paramKey + "' datanum='" + dataNum + "'>实体类型:" + typeName + "      参数名称:" + paramKey + "      数量:" + dataNum + " <a style='cursor:pointer' onclick='removeRecord(this)'>删除</a></p>");
		}
	}
	
	<#-- 保存数据到父窗口 -->
	function saveData(){
		var ids = "";
		var keys = "";
		var nums = "";
		$("#dataRecord p").each(function(index, node){
			if(ids != ""){
				ids += ",";
				keys += ",";
				nums += ",";
			}
			ids += node.id;
			keys += $(node).attr("paramkey");
			nums += $(node).attr("datanum");
		});
		
		father_win.$("#dataConfigEntityTypeIdArr").val(ids);
		father_win.$("#dataConfigParamKeyArr").val(keys);
		father_win.$("#dataConfigNumArr").val(nums);
		$.closeWindow('configData');
	}
	
	function removeRecord(a){
		$(a).closest("p").remove();
	}
</script>
</body>
</@PAGE.HTML>