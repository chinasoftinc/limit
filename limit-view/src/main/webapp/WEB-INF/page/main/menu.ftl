<div id="left" class="easyui-accordion" data-options="border:false,selected:0,multiple:true">
	
	<div title="权限管理" class="win_body" data-options="iconCls:'icon-menu'" style="padding:10px;">
    	<p><a name="menu_button" href="#" class="easyui-linkbutton" onclick="$.addTab('4','组织机构','${ctx}/system/dept/main', 'home')" style="width:100%;">组织结构</a></p>
    	<p><a name="menu_button" href="#" class="easyui-linkbutton" onclick="$.addTab('5','用户管理','${ctx}/system/user/main', 'home')" style="width:100%;">用户管理</a></p>
    </div>
    
	<div title="系统管理" class="win_body" data-options="iconCls:'icon-menu'" style="padding:10px;">
 		<p><a name="menu_button" href="#" class="easyui-linkbutton" onclick="$.addTab('1','数据字典','${ctx}/system/dictionary/main', 'home')" style="width:100%;">数据字典</a></p>
 		<p><a name="menu_button" href="#" class="easyui-linkbutton" onclick="$.addTab('2','参数配置','${ctx}/system/parameter/main', 'home')" style="width:100%;">参数配置</a></p>
 		<p><a name="menu_button" href="#" class="easyui-linkbutton" onclick="$.addTab('3','地区数据','${ctx}/system/area/main', 'home')" style="width:100%;">地区数据</a></p>
    </div>
    
</div>