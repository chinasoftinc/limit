<@PAGE.HTML title="配置菜单">
<body>
<div style="width: 100%;height:100%;background:#fff">
	<div style="width: 100%;height:300px;overflow:auto">
		<ul id="menuTree"></ul>
	</div>
	<div style="text-align:center">
		<a class="easyui-linkbutton" iconCls="icon-save" onclick="saveMenus()" >保存</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('${winId}')" >关闭</a>
	</div>
</div>
<script>

	<#-- 获取角色编辑菜单[父窗口]的选中菜单id数组 -->
	var win = $.getRootWindow().$("#${parentWinId}")[0].contentWindow;
	var menuIds = win.$("#menus").val();
	var menuArr;
	if(menuIds != ""){
		menuArr = menuIds.split(",");
	}
	
	$('#menuTree').tree({
	    url: '${ctx}/system/role/menuTreeJson',
	    animate:true,
	    checkbox:true,
	    lines:true,
	    <#-- 过滤选中状态 -->
        loadFilter: function(data){
        	$(data).each(function(index, node){
        		if(menuArr != null && menuArr.length != 0){
					for(var i = 0; i < menuArr.length; i++){
        				<#-- 处理二级菜单 -->
	        			for(var x = 0; x < node.children.length; x++){
		        			if(menuArr[i] == node.children[x].id){
			        			node.children[x].checked = 'true';
		        			}
		        		}
	        		}
        		}
        	});
        	return data;
	    }
	});
	
	<#-- 保存 -->
	function saveMenus(){
		<#-- 获取选中的节点, 组装菜单ID字符串, 逗号分割 -->
		var nodes = $("#menuTree").tree("getChecked");
		menuIds = "";
		$(nodes).each(function(index,node){
			menuIds += node.id + ",";
		});
		
		if(menuIds != ""){
			menuIds = menuIds.substring(0,menuIds.length-1);
		}
		
		<#-- 保存到角色编辑窗口[父窗口]的privilegeIds隐藏域 -->
		win.$("#menus").val(menuIds);
		$.closeWindow('${winId}');
	}
</script>
</body>
</@PAGE.HTML>