<#-- 网站信息管理 -->
<@PAGE.HTML title="网站信息管理" >
<body style="margin: 5px">
	<div style="width: 100%;height:100%;">
		<table id="datagrid"></table>
		<div id="toolBar">
			<a href="#" onclick="addItem()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
			
			<#-- 搜索框 -->
			<center>
				<div style="margin:5px;width:800px">
					<form id="searchInput">
						信息名称: <input type="text" id="name" style="width:120px" />
						信息所属实体: <@PAGE.SELECT datas=entityTypes optKey="id" optVal="entityName" id="entityType" disabled="false" />
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
		    url:'${ctx}/app/info/json', <#-- 数据请求URL -->
        	rownumbers:true,
        	fitColumns:true,
		    columns:[[
		        {field:'name',title:'信息名称',width:200,sortable:true},
		        {field:'entityTypeName',title:'信息所属实体',width:50,sortable:true},
		        {field:'sortOrder',title:'排序',width:50,sortable:true},
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
				name : $("#mainTitle").val(),
				entityType : $("#entityType").val()
			});
		}
	
		<#-- 添加 -->
		function addItem(){
			$.createSimpleWindowAutoScroll("edit","添加", 1200, 820, "${ctx}/app/info/addView");
		}
		
		<#-- 编辑 -->
		function editItem(id){
			$.createSimpleWindowAutoScroll("edit","编辑", 1200, 820, "${ctx}/app/info/editView?id=" + id);
		}
		
		<#-- 删除 -->
		function removeItem(id){
			top.$.messager.confirm("提示","确认?", function(confirm){
				if(confirm){
					 var param = {id : id};
					 <#-- 确认删除 -->
					 $.defaultAjaxOperation("${ctx}/app/info/remove", param, true, true, 
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