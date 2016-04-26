<div id="left" class="easyui-accordion" data-options="border:false,selected:0,multiple:true">
	<#list menus?keys as key>
	<div title="${key}" class="win_body" data-options="iconCls:'icon-menu'" style="padding:10px;">
	 	<#assign menu=menus[key]>
	 	<#list menu as m>
 		<p><a name="menu_button" href="#" class="easyui-linkbutton" onclick="$.addTab('${m.id}','${m.menuName}','${ctx}/${m.menuUrl}', 'home')" style="width:100%;">${m.menuName}</a></p>
	 	</#list>
    </div>
	</#list>
</div>
