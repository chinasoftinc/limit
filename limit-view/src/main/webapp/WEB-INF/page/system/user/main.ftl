<@PAGE.HTML title="用户管理" >
<body style="margin:5px;border:1px #fff solid;background:#666">
	<div style="width: 100%;height:100%;">
	
		<table id="dataGrid"></table>
		
		<div id="toolBar">
			<a href="#" onclick="insertUser()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>|
			<a href="#" onclick="editUser()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>|
			<a href="#" onclick="removeUser()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
			<center>
				<div style="margin:5px">
					<form id="searchInput">
						昵称: <input type="text" id="nickname" style="width:120px">
						登录账户: <input type="text" id="username" style="width:120px">
					</form>
				</div>
				<div style="margin:5px">
					<a href="#" class="easyui-linkbutton" onclick="cleanSearch()" data-options="iconCls:'icon-remove',plain:true">清空</a>
					<a href="#" class="easyui-linkbutton" onclick="searchUser()" data-options="iconCls:'icon-search',plain:true">搜索</a>
				</div>
			</center>
			
		</div>
	</div>

	<#include "/system/user/js.ftl"/>
</body>
</@PAGE.HTML>