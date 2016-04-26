<@PAGE.HTML title="添加角色">
<body>
<div style="width: 100%;height:100%;background:#ccc">
	<div style="width: 100%;height:300px;overflow:auto">
		<ul id="privilegeTree"></ul>
	</div>
	<div style="text-align:center">
		<a class="easyui-linkbutton" iconCls="icon-save" onclick="saveCheckedPrivilege()" >保存</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('directionPrivilege')" >关闭</a>
	</div>
</div>
<script>

	<#-- 获取角色编辑菜单[父窗口]的选中权限ID -->
	var win = $.getRootWindow().$("#${parentWinId}")[0].contentWindow;
	var privilegeIds = win.$("#privilegeIds").val();
	
	<#-- 转变为数组, 逗号分隔开 -->
	var privilegeArr;
	if(privilegeIds != ""){
		privilegeArr = privilegeIds.split(",");
	}
	
	$('#privilegeTree').tree({
	    url: '${ctx}/system/role/privilegeTreeJson',
	    animate:true,
	    checkbox:true,
	    lines:true,
	    <#-- 过滤权限选中状态 -->
        loadFilter: function(data){
        	$(data).each(function(index, node){
        		if(privilegeArr != null && privilegeArr.length != 0){
					for(var i = 0; i < privilegeArr.length; i++){
        				<#-- 处理二级菜单 -->
	        			for(var x = 0; x < node.children.length; x++){
		        			if(privilegeArr[i] == node.children[x].id){
			        			node.children[x].checked = 'true';
		        			}
		        		}
	        		}
        		}
        	});
        	return data;
	    }
	});
	
	<#-- 保存权限选择 -->
	function saveCheckedPrivilege(){
	
		<#-- 获取选中的节点, 组装菜单ID字符串, 逗号分割 -->
		var nodes = $("#privilegeTree").tree("getChecked");
		privilegeIds = "";
		$(nodes).each(function(index,node){
			privilegeIds += node.id + ",";
		});
		
		if(privilegeIds != ""){
			privilegeIds = privilegeIds.substring(0,privilegeIds.length-1);
		}
		
		<#-- 保存到角色编辑窗口[父窗口]的privilegeIds隐藏域 -->
		win.$("#privilegeIds").val(privilegeIds);
		$.closeWindow('directionPrivilege');
	}
</script>
</body>
</@PAGE.HTML>