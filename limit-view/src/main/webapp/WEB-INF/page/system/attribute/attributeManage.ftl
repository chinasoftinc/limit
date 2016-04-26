<@PAGE.HTML title="菜单管理" >
<body style="margin: 5px">
	<div style="width: 100%;height:100%;">
	
		<#-- 选项字典列表 -->
		<div style="height:47%;width:100%">
			<div  class="easyui-panel" title="选项字典列表">
				<div style="height:90%;width:100%">
					<table id="optdicDataGrid"></table>
					<#-- 选项字典toolBar -->					
					<div id="optdicToolBar">
						<a href="#" onclick="addoptdic()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>|
						<a href="#" onclick="editopttic()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>|
						<a href="#" onclick="removeoptdic()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
						<a href="#" onclick="$('#optdicDataGrid').treegrid('collapseAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部折叠</a>
						<a href="#" onclick="$('#optdicDataGrid').treegrid('expandAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部展开</a>
					</div>
				</div>
		    </div>
		</div>
		
		
		<#-- 参数管理 -->
		<div style="height:47%;width:100%">
			<div class="easyui-panel" title="参数列表">
				<div style="height:100%;width:100%;">
					<table id="paramDataGrid"></table>
					<#-- 参数管理toolBar -->					
					<div id="paramToolBar">
						<a href="#" onclick="addparam()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>|
						<a href="#" onclick="editparam()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>|
						<a href="#" onclick="removeparam()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
					</div>
				</div>
		    </div>
		</div>
		
	</div>
	<script>
<#-- 选项字典dataGrid -->
		$('#optdicDataGrid').treegrid({
			fit:true,
			loadMsg:'请稍后',
			toolbar: '#optdicToolBar',
			striped:true,
		    url:'${ctx}/system/attribute/optdicJson', <#-- 数据请求URL -->
		    idField:'id',
		    treeField:'optName',
		    animate:true,
        	rownumbers:true,
        	fitColumns:true,
		    columns:[[
		        {field:'optName',title:'选项组',width:200, 
		        	formatter:function(value,rowData,rowIndex){
									return '<input type="radio" id="' + rowData.id + '" name="optdicSelect" />' + rowData.optName;	        			
							 }
			        },
		        {field:'optKey',title:'键',width:50,},
		        {field:'optVal',title:'值',width:100},    
		        {field:'description',title:'选项说明',width:500}
		    ]],
		    <#-- 单选依赖 -->
		    onClickRow:function(row){ 
		    	$("#" + row.id).attr("checked",true);
		    },
		    <#-- 双节展开关闭 -->
		    onDblClickCell:function(field, row){
		    	$("#optdicDataGrid").treegrid('toggle',row.id);
		    }
		});
		
		<#-- 添加选项字典 -->
		function addoptdic(){
			 $.createSimpleWindowAutoScroll("editOptdic","添加选项字典", 680, 385, "${ctx}/system/attribute/addOptdicView");
		}
		
		<#-- 编辑选项字典 -->
		function editopttic(){
			 var radio = $("input[type='radio'][name='optdicSelect']:checked");
			 if(radio.length != 0){
				 $.createSimpleWindowAutoScroll("editOptdic","编辑字典", 680, 385, "${ctx}/system/attribute/editOptdicView?id=" + radio.attr("id"));
			 }else{
				 $.msgTip('提示','单击选中一行进行编辑');
			 }
		}
		
		<#-- 删除选项字典-->
		function removeoptdic(){
			 var radio = $("input[type='radio'][name='optdicSelect']:checked");
			 if(radio.length != 0){
				 top.$.messager.confirm("提示","子选项将同时被删除, 引用该选项字典的页面将会崩溃, 是否确认删除?", function(confirm){
					 var param = {id : radio.attr("id")};
					 if(confirm){
						 <#-- 确认删除 -->
						 $.defaultAjaxOperation("${ctx}/system/attribute/removeOptdic", param, true, true, 
							 {
								 success: function (result){
									 if(result.success == 'true'){
									 	 $.timeOutMsgTip("提示", result.message);
									 }else{
										 $.errorTip("警告", "删除操作失败, 请联系系统管理人员");
									 }
									 <#-- 刷新窗口数据 -->
									 $.reloadData(window.name);
								 }
							 }
						 );
						
					 }
				 })
			 }else{
				 $.msgTip('提示','单击选中一行进行删除');
			 }
		}
		
		
		
<#-- 参数管理dataGrid -->
		$('#paramDataGrid').datagrid({
			fit:true,
			loadMsg:'请稍后',
			striped:true,
		    idField:'id',
		    animate:true,
        	rownumbers:true,
        	fitColumns:true,
		    toolbar:'#paramToolBar',
		    singleSelect:true,
		    url:'${ctx}/system/attribute/paramJson',
		    columns:[[
		        {field:'optKey',title:'参数名',width:200,
		        	formatter:function(value,rowData,rowIndex){
						return '<input type="radio" id="' + rowData.id + '" name="paramSelect" />' + rowData.optKey;	        			
				    }
		        },
		        {field:'optVal',title:'参数值',width:150},
		        {field:'description',title:'参数说明',width:500}
		    ]],
		    <#-- 单选依赖 -->
		    onClickRow:function(index, rowDate){
		    	$("#" + rowDate.id).attr("checked",true);
		    },
		    onDblClickRow: function(rowIndex, rowData){
		    	$.createSimpleWindowAutoScroll("editParam","编辑参数", 680, 280, "${ctx}/system/attribute/editParamView?id=" + rowData.id);
		    }
		});
		
		<#-- 添加参数 -->
		function addparam(){
			 $.createSimpleWindowAutoScroll("editParam","添加参数", 680, 280, "${ctx}/system/attribute/addParamView");
		}
		
		<#-- 编辑参数 -->
		function editparam(){
			 var radio = $("input[type='radio'][name='paramSelect']:checked");
			 if(radio.length != 0){
				 $.createSimpleWindowAutoScroll("editParam","编辑参数", 680, 280, "${ctx}/system/attribute/editParamView?id=" + radio.attr("id"));
			 }else{
				 $.msgTip('提示','单击选中一行进行编辑');
			 }
		}
		
		<#-- 删除参数 -->
		function removeparam(){
			 var radio = $("input[type='radio'][name='paramSelect']:checked");
			 if(radio.length != 0){
				 top.$.messager.confirm("提示","引用改参数的业务将会崩溃, 是否确认删除?", function(confirm){
					 var param = {id : radio.attr("id")};
					 if(confirm){
						 <#-- 确认删除 -->
						 $.defaultAjaxOperation("${ctx}/system/attribute/removeParam", param, true, true, 
							 {
								 success: function (result){
									 if(result.success == 'true'){
									 	 $.timeOutMsgTip("提示", result.message);
									 }else{
										 $.errorTip("警告", "删除操作失败, 请联系系统管理人员");
									 }
									 <#-- 刷新窗口数据 -->
									 $.reloadData(window.name);
								 }
							 }
						 );
					 }
				 })
			 }else{
				 $.msgTip('提示','单击选中一行进行删除');
			 }
		}
	</script>
</body>
</@PAGE.HTML>