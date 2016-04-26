<#-- 文章附件管理 -->
<@PAGE.HTML title="文章附件管理" >
<body style="margin: 5px">
	<div style="width: 100%;height:100%;">
		<table id="datagrid"></table>
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
		    url:'${ctx}/system/articleFile/json',
		    columns:[[
		    	{field:'fileTitle',title:'标签',width:400,sortable:true},
		    	{field:'uploadTime',title:'上传时间',sortable:true,width:80},
		    	{field:'id',title:'操作',width:50,
		    		formatter : function(value, row, index){
		    			return '<a href="#" onclick="removeItem(\'' + value + '\')">移除</a>'
		    		}
		    	}
		    ]]
		});
		
		<#-- 删除 -->
		function removeItem(id){
			top.$.messager.confirm("提示","将会删除该附件, 所有引用该附件的文章将会出现问题, 是否确认删除?", function(confirm){
				if(confirm){
					 var param = {id : id};
					 <#-- 确认删除 -->
					 $.defaultAjaxOperation("${ctx}/system/articleFile/remove", param, true, true, 
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