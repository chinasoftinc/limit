<@PAGE.HTML title="数据字典" >
<body style="margin:5px;border:1px #fff solid;background:#666">
	<#-- 选项字典列表 -->
	<div class="easyui-panel" title="数据字典" data-options="fit:true,border:false">
		<table id="dictionaryDataGrid"></table>
		<#-- 选项字典toolBar -->
		<div id="optdicToolBar">
			<a href="#" onclick="addRootDirectory()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加根目录</a>|
			<a href="#" onclick="$('#dictionaryDataGrid').treegrid('collapseAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部折叠</a>
			<a href="#" onclick="$('#dictionaryDataGrid').treegrid('expandAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部展开</a>
		</div>
    </div>
	
	<#-- 右键菜单1 -->
	<div id="rightMouseMenuForDirectory" class="easyui-menu" style="display:none">
		<div onclick="addSubDictionary()" data-options="iconCls:'icon-add'">添加子目录</div>
		<div onclick="addDictionaryGroup()" data-options="iconCls:'icon-add'">添加选项组</div>
		<div onclick="editDictionary()" data-options="iconCls:'icon-edit'">编辑</div>
		<div onclick="removeDictionary()" data-options="iconCls:'icon-no'">删除</div>
		<div onclick="upDictionary()">上移</div>
		<div onclick="downDictionary()">下移</div>
	</div>
	
	<#-- 右键菜单2 -->
	<div id="rightMouseMenuForDictionaryGroup" class="easyui-menu" style="display:none">
		<div onclick="addDictionary()" data-options="iconCls:'icon-add'">添加子选项</div>
		<div onclick="editDictionary()" data-options="iconCls:'icon-edit'">编辑</div>
		<div onclick="removeDictionary()" data-options="iconCls:'icon-no'">删除</div>
		<div onclick="upDictionary()">上移</div>
		<div onclick="downDictionary()">下移</div>
	</div>
	<#-- 右键菜单3 -->
	<div id="rightMouseMenuForDictionary" class="easyui-menu" style="display:none">
		<div onclick="editDictionary()" data-options="iconCls:'icon-edit'">编辑</div>
		<div onclick="removeDictionary()" data-options="iconCls:'icon-no'">删除</div>
		<div onclick="upDictionary()">上移</div>
		<div onclick="downDictionary()">下移</div>
	</div>
	
	<#include "/system/dictionary/main.js.ftl"/>
</body>
</@PAGE.HTML>