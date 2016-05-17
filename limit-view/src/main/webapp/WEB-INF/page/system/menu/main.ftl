<@PAGE.HTML title="菜单管理" >
<body style="margin:5px;border:1px #ccc solid;background:#fff;">

	<table id="dataGrid"></table>
	
	<div id="toolBar">
		<a href="#" onclick="addMenu()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>|
		<a href="#" onclick="editMenu()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>|
		<a href="#" onclick="removeMenu()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>|
		<a href="#" onclick="moveMenu('UP')" class="easyui-linkbutton" data-options="plain:true">上移</a>|
		<a href="#" onclick="moveMenu('DOWN')" class="easyui-linkbutton" data-options="plain:true">下移</a>
		<a href="#" onclick="$('#dataGrid').treegrid('collapseAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部折叠</a>
		<a href="#" onclick="$('#dataGrid').treegrid('expandAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部展开</a>
	</div>
	
	<#include "/system/menu/js.ftl"/>
</body>
</@PAGE.HTML>