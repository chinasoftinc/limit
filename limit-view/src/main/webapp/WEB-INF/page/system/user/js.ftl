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
	    url:'${ctx}/system/user/userJson',
	    columns:[[
	    	{field:'userCode',title:'用户编码',width:100,
	    		formatter:function(value, row, rowIndex){
					return '<input type="radio" style="position:relative;top: 3" id="' + row.id + '" />' + '<span>' + row.userCode + '</span>';
			 	}
	    	},
	        {field:'nickName',title:'用户昵称',width:100},
	        {field:'userSex',title:'性别',width:100,sortable:true,formatter: function(value,row,index){
	        		return value == '0' ? '男' : '女';
	        	}
	        },
	        {field:'userPhone',title:'电话',width:100},
	        {field:'userEmail',title:'邮箱',width:100},
	        {field:'userStatus',title:'启用状态',width:50,sortable:true,formatter: function(value,row,index){
	        		return value == '0' ? '停用' : '启用';
	        	}
	        },
	        {field:'lastAccessTime',title:'最后访问时间',width:100,sortable:true,formatter: function(value,row,index){
	        		return new Date(value).format("yyyy年MM月dd日hh时mm分");
	        	}
	        },
	        {field:'onlineTime',title:'在线时长(分钟)',width:100,sortable:true}
	    ]],
	    
     	<#-- 单选 -->
	    onClickRow:function(index, row){ 
	    	$("#" + row.id).attr("checked",true);
	    },
	    
	    onDblClickRow:function(rowIndex, rowData){
	    	$.createSimpleWindowAutoScroll("editUser","编辑用户", 680, 385, "${ctx}/system/user/editView?id=" + rowData.id);
	    } 
	});
	
	<#-- 添加用户 -->
	function adduser(){
		$.createSimpleWindowAutoScroll("editUser","添加用户", 680, 385, "${ctx}/system/user/addView");
	}
	
	<#-- 编辑用户 -->
	function edituser(){
		var rows = $("input[type='checkbox'][name='id']:checked");
		if(rows.length == 1){
			$.createSimpleWindowAutoScroll("editUser","编辑用户", 680, 385, "${ctx}/system/user/editView?id=" + $(rows[0]).val());
		}else{
			$.msgTip('提示','单击选中一行进行编辑');
		}
	}
	
	<#-- 删除用户 -->
	function removeuser(){
		var rows = $("input[type='checkbox'][name='id']:checked");
		if(rows.length != 0){
			top.$.messager.confirm("提示","是否确认删除?", function(confirm){
				<#-- 组装删除的ids -->
				var ids = "";
				$(rows).each(function(index, node){
					ids += node.value + ",";
				});
				if(ids != ""){
					ids = ids.substring(0, ids.length-1);
				}
				var param = {ids : ids};
				if(confirm){
					 <#-- 确认删除 -->
					 $.defaultAjaxOperation("${ctx}/system/user/remove", param, true, true, 
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
			 $.msgTip('提示','没有选中任何用户, 可以选中多行进行删除');
		 }
	}
	
	<#-- 清空搜索 -->
	function cleanSearch(){
		$("#searchInput")[0].reset();
	}
	
	<#-- 搜索用户 -->
	function searchUser(){
		$("#userDataGrid").datagrid("load",{
			nickname : $("#nickname").val(),
			username : $("#username").val(),
			status : $("#status").val(),
			searchRoleId : $("#searchRoleId").val()
		});
	}
</script>