<@PAGE.HTML title="地区管理" >
<#include "/system/area/css.ftl"/>

<body style="margin:5px;border:1px #fff solid;background:#666">
<div style="width: 100%;height:100%;">

	<div style="width:100%;height:99%;padding:2px;background:#666">
		<div id="div1">
			<div class="tree_toolbar">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="insert()">添加一级地区</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="$(this).parent().next().tree('reload')">刷新</a>
			</div>
			<ul id="level_1"></ul>
		</div>
		<div id="div2">
			<div class="tree_toolbar">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="insert()">添加二级地区</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="$(this).parent().next().tree('reload')">刷新</a>
			</div>
			<ul id="level_2"></ul>
		</div>
		<div id="div3">
			<div class="tree_toolbar">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="insert()">添加三级地区</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="$(this).parent().next().tree('reload')">刷新</a>
			</div>
			<ul id="level_3"></ul>
		</div>
		<div id="div4">
			<div class="tree_toolbar">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="insert()">添加四级地区</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="$(this).parent().next().tree('reload')">刷新</a>
			</div>
			<ul id="level_4"></ul>
		</div>
	</div>
	
	<#-- 右键菜单 -->
	<div id="rightMouseMenu" class="easyui-menu" style="display:none">
		<div data-options="iconCls:'icon-add'" onclick="insert()">添加</div>
		<div data-options="iconCls:'icon-edit'" onclick="edit()">修改</div>
		<div data-options="iconCls:'icon-no'" onclick="removeArea()">删除</div>
	</div>
</body>

<#include "/system/area/js.ftl"/>
</@PAGE.HTML>