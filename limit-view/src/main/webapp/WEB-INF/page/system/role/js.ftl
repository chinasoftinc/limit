<script>
	$('#dataGrid').datagrid({
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
	     	{field:'roleCode',title:'角色码',width:100,
	     		formatter:function(value,rowData,rowIndex){
					return '<input type="radio" id="' + rowData.id + '" roleName="' + rowData.roleName + '" name="roleSelect" style="position:relative;top:3px" />' + rowData.roleName;	        			
			    }
		    },
	        {field:'roleName',title:'角色名称',width:100},
	        {field:'roleDescription',title:'角色说明',width:200}
	    ]],
	    
	    <#-- 单击 -->
	    onClickRow:function(index, rowDate){ 
	    	$("#" + rowDate.id).attr("checked",true);
	    },
	    onDblClickRow:function(rowIndex, rowData){
	    	$.createSimpleWindowAutoScroll("editRole","编辑角色", 680, 280, "${ctx}/system/role/editRoleView?id=" + rowData.id);
	    }
	});
	
	
	<#-- 添加角色 -->
	function addRole(){
		$.createSimpleWindowAutoScroll("editRole","添加角色", 680, 280, "${ctx}/system/role/addRoleView");
	}
	
	<#-- 编辑角色 -->
	function editRole(){
		var radio = $("input[type='radio']:checked");
		if(radio.length != 0){
			$.createSimpleWindowAutoScroll("editRole","编辑角色", 680, 280, "${ctx}/system/role/editRoleView?id=" + radio.attr("id"));
		}else{
			$.timeOutMsgTip("提示", "选中一行角色或双击进行编辑");
		}
	}
	
	<#-- 删除角色 -->
	function removeRole(){
		var radio = $("input[type='radio']:checked");
		if(radio.length == 1){
			top.$.messager.confirm("提示","该角色下的用户将会去除该角色, 确认删除  " + radio.attr("roleName") + " 角色吗?", function(confirm){
				if(confirm){
					var param = {id : radio.attr("id")};
					 $.defaultAjaxOperation("${ctx}/system/role/removeRole", param, true, true, 
						 {
							 success: function (result){
								 if(result.success){
								 	 $.timeOutMsgTip("提示", result.message);
								 }else{
									 $.errorTip("警告", result.message);
								 }
								 $.reloadData(window.name);
							 }
						 }
					 );
					
				 }
			 })
		 }else{
		 	 $.timeOutMsgTip("提示", "单击选中一行进行删除");
		 }
	}
</script>