<@PAGE.HTML title="部门管理" >
<body style="margin:5px;border:1px #fff solid;background:#666;" class="easyui-layout">

<div id="ftp_outer" data-options="region:'west',title:'',border:false,collapsible:false" style="width:380px;padding:3px;overflow:auto;">
	<table id="dataGrid"></table>
	<div id="toolBar">
		<a href="#" onclick="addRootOrg()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加主机构</a>|
		<a href="#" onclick="$('#dataGrid').treegrid('collapseAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部折叠</a>
		<a href="#" onclick="$('#dataGrid').treegrid('expandAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部展开</a>
	</div>
</div>

<div data-options="region:'center',title:'',border:false"  style="padding:3px;background:#666;border-left:1px solid #fff">
	<div id="editPanel"></div>  
</div>
    
</div>
	
	<div id="rightMouseMenuForOrg" class="easyui-menu" style="display:none">
		<div onclick="addSubOrg()" data-options="iconCls:'icon-add'">添加子机构</div>
		<div onclick="addSubDept()" data-options="iconCls:'icon-add'">添加子部门</div>
		<div onclick="editDept()" data-options="iconCls:'icon-edit'">编辑</div>
		<div onclick="removeDept()" data-options="iconCls:'icon-no'">删除</div>
		<div onclick="move('UP')">上移</div>
		<div onclick="move('DOWN')">下移</div>
	</div>
	
	<div id="rightMouseMenuForDept" class="easyui-menu" style="display:none">
		<div onclick="addSubDept()" data-options="iconCls:'icon-add'">添加子部门</div>
		<div onclick="editDept()" data-options="iconCls:'icon-edit'">编辑</div>
		<div onclick="removeDept()" data-options="iconCls:'icon-no'">删除</div>
		<div onclick="move('UP')">上移</div>
		<div onclick="move('DOWN')">下移</div>
	</div>
	
	<#include "/system/department/js.ftl" />
</body>
</@PAGE.HTML>