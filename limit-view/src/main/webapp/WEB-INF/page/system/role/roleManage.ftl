<@PAGE.HTML title="菜单管理" >
<body style="margin: 5px">
	<div style="width: 100%;height:100%;">
		<table id="roleDataGrid"></table>
		<div id="toolBar">
			<a href="#" onclick="addrole()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>|
			<a href="#" onclick="editrole()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>|
			<a href="#" onclick="removerole()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
		</div>
	</div>
	<script>
		$('#roleDataGrid').datagrid({
			fit:true,
			loadMsg:'请稍后',
			striped:true,
		    idField:'id',
		    animate:true,
        	rownumbers:true,
        	fitColumns:true,
		    toolbar:'#toolBar',
		    pagination:true,
		    pagePosition:'top',
		    pageList:[10,15,20,30,50,100,150],
		    pageSize:20,
		    singleSelect:true,
		    url:'${ctx}/system/role/rolesJson',
		    columns:[[
		        {field:'rolename',title:'角色名称',width:100,
		        	formatter:function(value,rowData,rowIndex){
						return '<input type="radio" id="' + rowData.id + '" name="roleSelect" style="position:relative;top:3px" />' + rowData.rolename;	        			
				    }
		        },
		        {field:'description',title:'角色说明',width:500},
		    ]],
		    <#-- 单选依赖 -->
		    onClickRow:function(index, rowDate){ 
		    	$("#" + rowDate.id).attr("checked",true);
		    },
		    onDblClickRow:function(rowIndex, rowData){
		    	$.createSimpleWindowAutoScroll("editRole","编辑角色", 680, 280, "${ctx}/system/role/editView?id=" + rowData.id);
		    }
		});
		
		
		<#-- 添加角色 -->
		function addrole(){
			$.createSimpleWindowAutoScroll("editRole","添加角色", 680, 280, "${ctx}/system/role/addView");
		}
		
		<#-- 编辑角色 -->
		function editrole(){
			var radio = $("input[type='radio']:checked");
			if(radio.length != 0){
				$.createSimpleWindowAutoScroll("editRole","编辑角色", 680, 280, "${ctx}/system/role/editView?id=" + radio.attr("id"));
			}else{
				$.msgTip('提示','单击选中一行进行编辑');
			}
		}
		
		<#-- 删除角色 -->
		function removerole(){
			var radio = $("input[type='radio']:checked");
			if(radio.length != 0){
				top.$.messager.confirm("提示","被赋予该角色的用户将会失去该角色, 是否确认删除?", function(confirm){
					var param = {id : radio.attr("id")};
					if(confirm){
						 <#-- 确认删除 -->
						 $.defaultAjaxOperation("${ctx}/system/role/remove", param, true, true, 
							 {
								 success: function (result){
									 if(result.success){
									 	 $.timeOutMsgTip("提示", result.message);
									 }else{
										 $.errorTip("警告", result.message);
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