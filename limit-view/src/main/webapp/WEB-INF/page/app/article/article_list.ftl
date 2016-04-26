<#-- 文章管理 -->
<@PAGE.HTML title="文章管理" >
<body style="margin: 5px">
	<div style="width: 100%;height:100%;">
		<table id="datagrid"></table>
		<div id="toolBar">
			<a href="#" onclick="addItem()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
			
			<#-- 搜索框 -->
			<center>
				<div style="margin:5px;width:800px">
					<form id="searchInput">
						文章标题: <input type="text" id="mainTitle" style="width:120px" />
						文章所属实体: <@PAGE.SELECT datas=entityTypes optKey="id" optVal="entityName" id="entityType" disabled="false" />
						文章类别: <@SingleSelectTag id="articleType" optName="article_type" style="" />
						是否已发布: <@SingleSelectTag id="status" optName="is_true" style="" />
						<a href="#" class="easyui-linkbutton" onclick="clean()" data-options="iconCls:'icon-remove',plain:true">清空</a>
						<a href="#" class="easyui-linkbutton" onclick="query()" data-options="iconCls:'icon-search',plain:true">搜索</a>
					</form>
				</div>
			</center>
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
		    url:'${ctx}/app/article/json', <#-- 数据请求URL -->
        	rownumbers:true,
        	fitColumns:true,
		    columns:[[
		        {field:'mainTitle',title:'文章标题',width:200,sortable:true},
		        {field:'entityTypeName',title:'文章所属实体',width:50,sortable:true},
		        {field:'articleType',title:'文章类别',width:50,sortable:true},    
		        {field:'status',title:'发布状态',width:50,sortable:true},
		        {field:'createTime',title:'创建时间',width:100,sortable:true,
		        	formatter : function(value, row, index){
		    			return value.substring(0,16);
		    		}
		        },
		        {field:'updateTime',title:'最后更新时间',width:100,sortable:true,
		        	formatter : function(value, row, index){
		    			return value.substring(0,16);
		    		}
		        },
		        {field:'id',title:'操作',width:50,
		    		formatter : function(value, row, index){
		    			return '<a href="#" onclick="editItem(\'' + value + '\')">编辑</a> | <a href="#" onclick="removeItem(\'' + value + '\')">移除</a>'
		    		}
		    	}
		    ]]
		});
		
		<#-- 清空搜索条件 -->
		function clean(){
			$("#searchInput")[0].reset();
		}
		
		
		<#-- 搜索 -->
		function query(){
			$("#datagrid").datagrid("load",{
				mainTitle : $("#mainTitle").val(),
				entityType : $("#entityType").val(),
				articleType : $("#articleType").val(),
				status : $("#status").val()
			});
		}
	
		<#-- 添加 -->
		function addItem(){
			$.createSimpleWindowAutoScroll("edit","添加", 1200, 820, "${ctx}/app/article/addView");
		}
		
		<#-- 编辑 -->
		function editItem(id){
			$.createSimpleWindowAutoScroll("edit","编辑", 1200, 820, "${ctx}/app/article/editView?id=" + id);
		}
		
		<#-- 删除 -->
		function removeItem(id){
			top.$.messager.confirm("提示","确认?", function(confirm){
				if(confirm){
					 var param = {id : id};
					 <#-- 确认删除 -->
					 $.defaultAjaxOperation("${ctx}/app/article/remove", param, true, true, 
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