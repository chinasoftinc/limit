<#-- 页面数据配置 -->
<@PAGE.HTML title="页面数据配置" >
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
		    url:'${ctx}/system/entityType/entityParam/json?entityId=${entityId}',
		    columns:[[
		    	{field:'paramKey',title:'参数名称',width:50,sortable:true},
		    	{field:'requiredEntityName',title:'数据实体类型',width:100,sortable:true},
		    	{field:'requiredNum',title:'所需数量',width:50,sortable:true},
		    	{field:'id',title:'操作',width:80,
		    		formatter : function(value, row, index){
		    			return '<a href="#" onclick="editItem(\'' + row.id + '\')">编辑</a> | <a href="#" onclick="removeItem(\'' + value + '\')">移除</a>'
		    		}
		    	}
		    ]]
		});
		
		<#-- 添加 -->
		function addItem(){
			$.createSimpleWindowAutoScroll("edit_entityParam","添加", 800, 280, "${ctx}/system/entityType/entityParam/addView?entityId=${entityId}");
		}
		
		<#-- 编辑 -->
		function editItem(id){
			$.createSimpleWindowAutoScroll("edit_entityParam","编辑", 800, 280, "${ctx}/system/entityType/entityParam/editView?id=" + id);
		}
		
		<#-- 删除 -->
		function removeItem(id){
			top.$.messager.confirm("提示","是否确认删除?", function(confirm){
				if(confirm){
					 var param = {id : id};
					 <#-- 确认删除 -->
					 $.defaultAjaxOperation("${ctx}/system/entityType/entityParam/remove", param, true, true, 
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