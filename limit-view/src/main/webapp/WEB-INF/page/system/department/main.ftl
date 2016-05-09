<@PAGE.HTML title="部门管理" >
<body style="margin:5px;border:1px #fff solid;background:#666">
	<div class="easyui-panel" title="部门管理" data-options="fit:true,border:false">
		<div style="width:30%;height:100%;">
			<table id="dataGrid"></table>
			<div id="toolBar">
				<a href="#" onclick="addOrg()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加一级机构</a>|
				<a href="#" onclick="$('#dataGrid').treegrid('collapseAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部折叠</a>
				<a href="#" onclick="$('#dataGrid').treegrid('expandAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部展开</a>
			</div>
		</div>
		<div style="width:30%;height:100%;background:#fff;float:left">
			编辑展示页面
		</div>
    </div>
	
	<div id="rightMouseMenuForDirectory" class="easyui-menu" style="display:none">
		<div onclick="addSubDirectory()" data-options="iconCls:'icon-add'">添加子目录</div>
		<div onclick="addDictionaryGroup()" data-options="iconCls:'icon-add'">添加选项组</div>
		<div onclick="editDictionary()" data-options="iconCls:'icon-edit'">编辑</div>
		<div onclick="removeDictionary()" data-options="iconCls:'icon-no'">删除</div>
		<div onclick="move('UP')">上移</div>
		<div onclick="move('DOWN')">下移</div>
	</div>
	
	<div id="rightMouseMenuForDictionaryGroup" class="easyui-menu" style="display:none">
		<div onclick="addDictionary()" data-options="iconCls:'icon-add'">添加子选项</div>
		<div onclick="editDictionary()" data-options="iconCls:'icon-edit'">编辑</div>
		<div onclick="removeDictionary()" data-options="iconCls:'icon-no'">删除</div>
		<div onclick="move('UP')">上移</div>
		<div onclick="move('DOWN')">下移</div>
	</div>
	
	<div id="rightMouseMenuForDictionary" class="easyui-menu" style="display:none">
		<div onclick="editDictionary()" data-options="iconCls:'icon-edit'">编辑</div>
		<div onclick="removeDictionary()" data-options="iconCls:'icon-no'">删除</div>
		<div onclick="move('UP')">上移</div>
		<div onclick="move('DOWN')">下移</div>
	</div>
	
	<#include "/system/department/js.ftl" />
</body>
</@PAGE.HTML>