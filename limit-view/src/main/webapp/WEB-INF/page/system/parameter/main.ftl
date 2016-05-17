<@PAGE.HTML title="参数配置" >
<body style="margin:5px;border:1px #ccc solid;background:#fff;">
	<table id="dataGrid"></table>
	<div id="toolBar">
		<a href="#" onclick="addRootDirectory()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加根目录</a>|
		<a href="#" onclick="$('#dictionaryDataGrid').treegrid('collapseAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部折叠</a>
		<a href="#" onclick="$('#dictionaryDataGrid').treegrid('expandAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部展开</a>
	</div>
	
	<div id="rightMouseMenuForDirectory" class="easyui-menu" style="display:none">
		<div onclick="addSubDirectory()" data-options="iconCls:'icon-add'">添加子目录</div>
		<div onclick="addParameter()" data-options="iconCls:'icon-add'">添加参数</div>
		<div onclick="editParameter()" data-options="iconCls:'icon-edit'">编辑</div>
		<div onclick="removeParameter()" data-options="iconCls:'icon-no'">删除</div>
		<div onclick="move('UP')">上移</div>
		<div onclick="move('DOWN')">下移</div>
	</div>
	
	<div id="rightMouseMenuForParameter" class="easyui-menu" style="display:none">
		<div onclick="editParameter()" data-options="iconCls:'icon-edit'">编辑</div>
		<div onclick="removeParameter()" data-options="iconCls:'icon-no'">删除</div>
		<div onclick="move('UP')">上移</div>
		<div onclick="move('DOWN')">下移</div>
	</div>
	
	<#include "/system/parameter/js.ftl"/>
</body>
</@PAGE.HTML>