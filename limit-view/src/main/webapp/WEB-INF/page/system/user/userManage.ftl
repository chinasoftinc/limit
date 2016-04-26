<@PAGE.HTML title="用户管理" >
<body style="margin: 5px">
	<div style="width: 100%;height:100%;">
	
		<#-- 数据渲染表格 -->
		<table id="userDataGrid"></table>
		
		<#-- 工具栏开始 -->
		<div id="toolBar">
			<a href="#" onclick="adduser()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>|
			<a href="#" onclick="edituser()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>|
			<a href="#" onclick="removeuser()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
			<#-- 搜索框 -->
			<center>
				<div style="margin:5px">
					<form id="searchInput">
						昵称: <input type="text" id="nickname" style="width:120px">
						登录账户: <input type="text" id="username" style="width:120px">
						账户状态:<@SingleSelectTag id="status" optName="user_status" style="" />
						角色: <@PAGE.SELECT datas=roles optKey="id" optVal="rolename" id="searchRoleId"/>
					</form>
				</div>
				<div style="margin:5px">
					<a href="#" class="easyui-linkbutton" onclick="cleanSearch()" data-options="iconCls:'icon-remove',plain:true">清空</a>
					<a href="#" class="easyui-linkbutton" onclick="searchUser()" data-options="iconCls:'icon-search',plain:true">搜索</a>
				</div>
			</center>
		</div>
		<#-- 工具栏结束 -->
	</div>
	
	<script>
		$('#userDataGrid').datagrid({
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
		    singleSelect:false,
		    url:'${ctx}/system/user/usersJson',
		    columns:[[
		    	{field:'id',checkbox:true},
		        {field:'nickname',title:'用户昵称',width:100},
		        {field:'username',title:'账号',width:150},
		        {field:'status',title:'启用状态',width:50},
		        {field:'createTime',title:'创建时间',width:100,formatter: function(value,row,index){
		        		return new Date(value).format("yyyy-MM-dd hh:mm");
		        	}
		        },
		        {field:'roles',title:'所属角色',width:400}
		    ]],
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
</body>
</@PAGE.HTML>