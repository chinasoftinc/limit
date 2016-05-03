<@PAGE.HTML title="选秀字典管理" >
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
	</div>
	<script>
		<#-- 选项字典dataGrid -->
		$('#optdicDataGrid').treegrid({
			fit:true,
			loadMsg:'请稍后',
			toolbar: '#optdicToolBar',
			striped:true,
		    url:'${ctx}/system/dictionary/dictionaryJson',
		    idField:'id',
		    treeField:'optName',
		    animate:true,
        	rownumbers:true,
        	fitColumns:true,
		    columns:[[
		        {field:'optName',title:'名称',width:200, 
		        		formatter:function(value,rowData,rowIndex){
									return '<input type="radio" id="' + rowData.id + '" name="optdicSelect" />' + rowData.optName;	        			
					 	}
			        },
		        {field:'optKey',title:'键',width:50,},
		        {field:'optValue',title:'值',width:100},    
		        {field:'optSortNo',title:'排序',width:50},
		        {field:'optType',title:'类型',width:50,
		        		formatter:function(value,rowData,rowIndex){
							var type = "";
							if(rowData.optIsDir == "1"){
								type = "目录";
							}else if(rowData.optType == "2"){
								type = "选项组";
							}else if(rowData.optType == "1"){
								type = "选项";
							}
							return type;
					 	}
		        },
		        {field:'optDescription',title:'选项说明',width:500}
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
	</script>
</body>
</@PAGE.HTML>