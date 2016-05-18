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
					return '<input type="radio" name="userSelected" style="position:relative;top: 3" userId="' + row.id + '" nickName="' + row.nickName + '"/>' + '<span>' + row.userCode + '</span>';
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
	        {field:'isLogin',title:'登录状态',width:50,sortable:true,formatter: function(value,row,index){
	        		return value == '0' ? '离线' : '在线';
	        	}
	        },
	        {field:'lastAccessTime',title:'最后访问时间',width:100,sortable:true,formatter: function(value,row,index){
	        		return value == null ? "" : new Date(value).format("yyyy年MM月dd日hh时mm分");
	        	}
	        },
	        {field:'onlineTime',title:'在线时长(分钟)',width:100,sortable:true}
	    ]],
	    
     	<#-- 单选 -->
	    onClickRow:function(index, row){ 
	    	$("input[userId='" + row.id + "']").attr("checked",true);
	    },
	    
	    onDblClickRow:function(rowIndex, rowData){
	    	$.createSimpleWindowAutoScroll("editUser","编辑用户", 680, 500, "${ctx}/system/user/editUserView?id=" + rowData.id);
	    }
	});
	
	<#-- 添加用户 -->
	function insertUser(){
		$.createSimpleWindowAutoScroll("editUser","添加用户", 680, 500, "${ctx}/system/user/addUserView");
	}
	
	<#-- 编辑用户 -->
	function editUser(){
		var rows = $("input[type='radio'][name='userSelected']:checked");
		if(rows.length == 1){
			$.createSimpleWindowAutoScroll("editUser","编辑用户", 680, 500, "${ctx}/system/user/editUserView?id=" + $(rows[0]).attr("userId"));
		}else{
			$.timeOutMsgTip("提示", "单击选中一行或双击进行编辑", 300, 80, 1500);
		}
	}
	
	<#-- 删除用户 -->
	function removeUser(){
		var rows = $("input[type='radio'][name='userSelected']:checked");
		if(rows.length == 1){
			top.$.messager.confirm("提示","是否确认删除用户: " + rows.attr('nickName') + " 吗?", function(confirm){
				var param = {id : rows.attr('userId')};
				if(confirm){
					 $.defaultAjaxOperation("${ctx}/system/user/removeUser", param, true, true, 
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
		 	 $.timeOutMsgTip("提示", "选中一行用户进行删除");
		 }
	}
	
	<#-- 清空搜索 -->
	function cleanSearch(){
		$("#searchInput")[0].reset();
	}
	
	<#-- 搜索用户 -->
	function searchUser(){
		$("#dataGrid").datagrid("load",{
			nickName : $("#nickName").val(),
			userName : $("#userName").val(),
			userStatus : $("#userStatus").val(),
			userSex : $("#userSex").val(),
			orgId : $("#orgId").val(),
			departmentId : $("#departmentId").val(),
			searchRoleId : $("#searchRoleId").val()
		});
	}
	
	<#-- 机构选择加载部门下拉 -->
	$("#orgId").on("change", function(){
		var orgId = $(this).val();
		if(orgId != "" && orgId != null && orgId != undefined){
 			$.defaultAjaxOperation("${ctx}/system/user/deptListForOrg?orgId=" + orgId,{},true,true, 
				{
					success: function (result){
						 if(result.success){
						 	if(result.data.length > 0){
						 		$.each(result.data, function(index, item){
						 			var option = '<option id="' + item.id + '" value="' + item.id + '">' + item.deptShortName + '</option>'
						 			$(option).appendTo($("#departmentId"));
						 		});
						 	}
						 }else{
							 $.errorTip("警告", "操作异常");
						 }
					}
				}
			);		
 				
		}else{
			$("#departmentId option").remove();
			$("<option></option>").appendTo($("#departmentId"));
		}
	})
</script>