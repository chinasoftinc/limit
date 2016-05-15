<@PAGE.HTML title="角色管理" >
<body style="margin:5px;border:1px #fff solid;background:#666">
	<table id="dataGrid"></table>
	
	<div id="toolBar">
		<a href="#" onclick="addRole()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>|
		<a href="#" onclick="editRole()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>|
		<a href="#" onclick="removeRole()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
	</div>
	
	<#include "/system/role/js.ftl"/>
</body>
</@PAGE.HTML>