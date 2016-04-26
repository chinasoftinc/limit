<#-- 实体分类管理 -->
<@PAGE.HTML title="实体分类管理" >
<body style="margin: 5px">
	<div style="width: 100%;height:100%;">
		<table id="datagrid"></table>
		<div id="toolBar">
			<a href="#" onclick="addItem()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
			<a href="#" onclick="$('#datagrid').treegrid('collapseAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部折叠</a>
			<a href="#" onclick="$('#datagrid').treegrid('expandAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部展开</a>
		</div>
	</div>
	<script>
		$('#datagrid').treegrid({
			toolbar: '#toolBar',
			fit:true,
			loadMsg:'请稍后',
			striped:true,
		    url:'${ctx}/system/entityType/json', <#-- 数据请求URL -->
		    idField:'id_str',
		    treeField:'entityName',
		    animate:true,
        	rownumbers:false,
        	fitColumns:true,
		    columns:[[
		        {field:'entityName',title:'分类名称',width:200},
		        {field:'entityKey',title:'实体类名',width:200},
		        {field:'entityType',title:'实体类型',width:100},
		        {field:'id_str',title:'操作',width:80,
		    		formatter : function(value, row, index){
		    			return '<a href="#" onclick="editItem(\'' + value + '\')">编辑</a> | <a href="#" onclick="addChild(\'' + value + '\')">添加下级分类</a> | <a href="#" onclick="removeItem(\'' + value + '\')">移除</a>'
		    		}
		    	}
		    ]],
		    <#-- 双击展开关闭 -->
		    onDblClickCell:function(field, row){
		    	$("#datagrid").treegrid('toggle',row.id_str);
		    }
		});
	
		<#-- 添加 -->
		function addItem(){
			$.createSimpleWindowAutoScroll("edit","添加", 800, 330, "${ctx}/system/entityType/addView");
		}
		
		<#-- 编辑 -->
		function editItem(id){
			$.createSimpleWindowAutoScroll("edit","编辑", 800, $(window).height(), "${ctx}/system/entityType/editView?id=" + id);
		}
		
		<#-- 添加下级分类 -->
		function addChild(parentId){
			$.createSimpleWindowAutoScroll("edit","添加", 800, 350, "${ctx}/system/entityType/addView?parentId=" + parentId);
		}
		
		<#-- 删除 -->
		function removeItem(id){
			top.$.messager.confirm("提示","该删除功能仅用于开发阶段, 删除该分类时所有下级分类将同时被删除, 确认?", function(confirm){
				if(confirm){
					 var param = {id : id};
					 <#-- 确认删除 -->
					 $.defaultAjaxOperation("${ctx}/system/entityType/remove", param, true, true, 
						 {
							 success: function (result){
								 if(result.success == true){
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