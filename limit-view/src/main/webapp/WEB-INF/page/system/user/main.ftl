<@PAGE.HTML title="用户管理" >
<body style="margin:5px;border:1px #ccc solid;background:#fff;">
	<table id="dataGrid"></table>
		
	<div id="toolBar">
		<a href="#" onclick="insertUser()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>|
		<a href="#" onclick="editUser()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>|
		<a href="#" onclick="removeUser()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
		<center>
			<div style="margin:5px">
				<form id="searchInput" onsubmit="return (function(){searchUser(); return false;})()">
					昵称: <input type="text" id="nickName" style="width:120px">
					<@PAGE.SPACE length=6 />
					登录账户: <input type="text" id="userName" style="width:120px">
					<@PAGE.SPACE length=6 />
					账户状态: <@SingleSelectTag id="userStatus" name="userStatus" optName="user_status" style="" />
					<@PAGE.SPACE length=6 />
					登录状态: <select id="isLogin" ><option></option><option key="1">在线</option><option key="0">离线</option></select>
					<@PAGE.SPACE length=6 />
					用户性别: <@SingleSelectTag id="userSex" name="userSex" optName="user_sex" style="" />
					<@PAGE.SPACE length=6 />
					角色: <@PAGE.SELECT datas=roles optKey="id" optVal="roleName" id="searchRoleId"/>
					<@PAGE.SPACE length=6 />
					所属机构: <@PAGE.SELECT datas=orgList optKey="id" optVal="deptShortName" id="orgId" />
					<@PAGE.SPACE length=6 />
					所属部门: <select id="departmentId" ><option></option></select>
				</form>
			</div>
			<div style="margin:5px">
				<a href="#" class="easyui-linkbutton" onclick="cleanSearch()" data-options="iconCls:'icon-remove',plain:true">清空</a>
				<a href="#" id="searchButton" class="easyui-linkbutton" onclick="searchUser()" data-options="iconCls:'icon-search',plain:true">搜索</a>
			</div>
		</center>
	</div>

	<#include "/system/user/js.ftl"/>
</body>
</@PAGE.HTML>