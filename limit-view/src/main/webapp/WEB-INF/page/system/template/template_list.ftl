<#-- 模版管理 -->
<@PAGE.HTML title="模版管理" >
<body style="margin: 5px">
	<div style="width: 100%;height:100%;">
		<table id="datagrid"></table>
		<div id="toolBar">
			<a href="#" onclick="addItem()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
			
			<#-- 搜索框 -->
			<center>
				<div style="margin:5px">
					<form id="searchInput">
						模版名称: <input type="text" id="name" style="width:120px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						所属分类: <select name="query_entityTypeId" class="easyui-combotree" style="width:200px;" data-options="url:'${ctx}/system/template/selectJson'" ></select>
					</form>
				</div>
				<div style="margin:5px">
					<a href="#" class="easyui-linkbutton" onclick="clean()" data-options="iconCls:'icon-remove',plain:true">清空</a>
					<a href="#" class="easyui-linkbutton" onclick="query()" data-options="iconCls:'icon-search',plain:true">搜索</a>
				</div>
			</center>
		</div>
	</div>
	<script>
		$(function(){
			$(".combo").css({"border":"1px solid #999","margin-top": "-2"});
		})
	
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
		    url:'${ctx}/system/template/json',
		    columns:[[
		    	{field:'name',title:'模版名称',width:200,sortable:true},
		    	{field:'entityTypeName',title:'模版所属实体分类',width:200},
		    	{field:'id',title:'操作',width:80,
		    		formatter : function(value, row, index){
		    			return '<a href="#" onclick="editItem(\'' + value + '\')">编辑</a> | <a href="#" onclick="removeItem(\'' + value + '\')">移除</a>'
		    		}
		    	}
		    ]]
		});
		
		<#-- 清空搜索条件 -->
		function clean(){
			$("#searchInput")[0].reset();
			$("input[name='query_entityTypeId']").val("");
		}
		
		<#-- 搜索 -->
		function query(){
			$("#datagrid").datagrid("load",{
				entityTypeId : $("input[name='query_entityTypeId']").val(),
				name : $("#name").val()
			});
		}
		
		<#-- 添加 -->
		function addItem(){
			$.createSimpleWindowAutoScroll("edit","添加", 600, 600, "${ctx}/system/template/addView");
		}
		
		<#-- 编辑 -->
		function editItem(id){
			$.createSimpleWindowAutoScroll("edit","编辑", 600, 600, "${ctx}/system/template/editView?id=" + id);
		}
		
		<#-- 删除 -->
		function removeItem(id){
			top.$.messager.confirm("提示","是否确认删除?", function(confirm){
				if(confirm){
					 var param = {id : id};
					 <#-- 确认删除 -->
					 $.defaultAjaxOperation("${ctx}/system/template/remove", param, true, true, 
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