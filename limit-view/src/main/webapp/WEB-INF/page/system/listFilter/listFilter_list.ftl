<#-- 筛选条件管理 -->
<@PAGE.HTML title="筛选条件管理" >
<body style="margin: 5px">
	<div style="width: 100%;height:100%;">
		<table id="datagrid"></table>
		<div id="toolBar">
			<a href="#" onclick="addItem()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
		</div>
	</div>
	<script>
		$('#datagrid').datagrid({
			fit:true,
			loadMsg:'请稍后',
			striped:true,
		    idField:'id',
		    animate:true,
        	fitColumns:true,
		    toolbar:'#toolBar',
		    pagination:true,
		    pagePosition:'top',
		    pageList:[10,15,20,30,50,100,150],
		    pageSize:20,
		    singleSelect:true,
		    url:'${ctx}/system/entityType/listFilter/json?entityTypeId=${entityTypeId}',
		    columns:[[
		    	{field:'filterType',title:'筛选类型',width:50,sortable:true},
		    	{field:'filterName',title:'参数名称',width:100,sortable:true},
		    	{field:'id',title:'操作',width:80,
		    		formatter : function(value, row, index){
		    			return '<a href="#" onclick="editItem(\'' + row.id + '\')">编辑</a> | <a href="#" onclick="removeItem(\'' + value + '\')">移除</a>'
		    		}
		    	}
		    ]]
		});
		
		<#-- 添加 -->
		function addItem(){
			$.createSimpleWindowAutoScroll("edit_listFilter","添加", 800, 500, "${ctx}/system/entityType/listFilter/addView?entityTypeId=${entityTypeId}");
		}
		
		<#-- 编辑 -->
		function editItem(id){
			$.createSimpleWindowAutoScroll("edit_listFilter","编辑", 800, 500, "${ctx}/system/entityType/listFilter/editView?id=" + id);
		}
		
		<#-- 删除 -->
		function removeItem(id){
			top.$.messager.confirm("提示","是否确认删除?", function(confirm){
				if(confirm){
					 var param = {id : id};
					 <#-- 确认删除 -->
					 $.defaultAjaxOperation("${ctx}/system/entityType/listFilter/remove", param, true, true, 
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
		}
	</script>
</body>
</@PAGE.HTML>