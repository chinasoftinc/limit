<script>
	var moveId = null;

	$('#dataGrid').treegrid({
		toolbar: '#toolBar',
		fit:true,
		loadMsg:'请稍后',
		striped:true,
	    url:'${ctx}/system/menu/menuJson',
	    idField:'id',
	    treeField:'menuName',
	    animate:true,
    	rownumbers:true,
    	fitColumns:true,
	    columns:[[
	        {field:'menuName',title:'菜单名称',width:100, 
	        	formatter:function(value,rowData,rowIndex){
					return '<input type="radio" id="' + rowData.id + '" name="menuSelect" menuName="' + rowData.menuName + '" menuParentId="' + rowData.menuParentId + '" />' + rowData.menuName;	        			
				}
	        },
		        
	        {field:'menuUrl',title:'菜单URL',width:150,},
	        {field:'parentName',title:'父级菜单',width:80},
	        {field:'menuPrivilegeCode',title:'权限码',width:80},
	        {field:'menuPrivilegePos',title:'权限位',width:40},
	        {field:'menuDescription',title:'说明',width:150}
	    ]],
	    
	    onClickRow:function(row){
	    	$("#" + row.id).attr("checked",true);
	    },
	    
	    onDblClickCell:function(field, row){
	    	$("#dataGrid").treegrid('toggle',row.id);
	    },
	    onLoadSuccess:function(row, data){
	    	if(moveId != null){
		    	$("#" + moveId).attr("checked",true);
	    	}
	    }
	});
	
	<#-- 添加菜单 -->
	function addMenu(){
		 $.createSimpleWindowAutoScroll("editMenu","添加菜单", 680, 330, "${ctx}/system/menu/addMenuView");
	}
	
	<#-- 编辑菜单 -->
	function editMenu(){
		 var radio = $("input[type='radio']:checked");
		 if(radio.length != 0){
		 	 if(radio.attr("menuParentId") == "0"){
				 $.createSimpleWindowAutoScroll("editMenu","编辑主菜单", 680, 230, "${ctx}/system/menu/editMenuView?id=" + radio.attr("id"));
		 	 }else{
			 	 $.createSimpleWindowAutoScroll("editMenu","编辑菜单", 680, 330, "${ctx}/system/menu/editMenuView?id=" + radio.attr("id"));
		 	 }
		 }else{
		 	 $.timeOutMsgTip('提示', '单击选中一行进行编辑', 300, 80, 1500);
		 }
	}
	
	<#-- 删除菜单 -->
	function removeMenu(){
		 var radio = $("input[type='radio']:checked");
		 if(radio.length == 1){
			 top.$.messager.confirm("提示","将会删除所有子菜单, 为角色配置的该菜单将消失, 是否确认删除?", function(confirm){
				 var param = {id : radio.attr("id")};
				 if(confirm){
					 $.defaultAjaxOperation("${ctx}/system/menu/removeMenu", param, true, true, 
						 {
							 success: function (result){
								 if(result.success){
								 	 $.timeOutMsgTip("提示", result.message);
								 }else{
									 $.errorTip("警告", "删除操作失败, 请联系系统管理人员");
								 }
								 $.reloadData(window.name);
							 }
						 }
					 );
					
				 }
			 })
		 }else{
     		 $.timeOutMsgTip('提示', '单击选中一行进行编辑', 300, 80, 1500);
		 }
	}
	 
	<#-- 移动菜单 -->
	function moveMenu(direction){
		 var radio = $("input[type='radio']:checked");
		 if(radio.length == 1){
				 moveId = radio.attr("id");
				 var param = {id : radio.attr("id"), direction : direction};
				 $.defaultAjaxOperation("${ctx}/system/menu/moveMenu", param, true, true, 
					 {
						 success: function (result){
					 		 if(!result.success){
								 $.errorTip("警告", "操作失败, 请联系系统管理人员");
							 }
							$.reloadData(window.name);
						 }
					 }
				 );
		 }else{
			$.timeOutMsgTip('提示', '单击选中一行进行位置的移动', 300, 80, 1500);
		 }
	}
	
</script>