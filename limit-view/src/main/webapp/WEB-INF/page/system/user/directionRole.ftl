<@PAGE.HTML title="添加角色">
<body>
<div style="width: 100%;height:100%;background:#ccc">
	<div style="width: 100%;height:300px;overflow:auto">
		<ul id="roleTree"></ul>
	</div>
	<div style="text-align:center">
		<a class="easyui-linkbutton" iconCls="icon-save" onclick="saveCheckedRole()" >保存</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('directionRole')" >关闭</a>
	</div>
</div>
<script>

	<#-- 获取用户编辑菜单[父窗口]的选中权限ID -->
	var win = $.getRootWindow().$("#${parentWinId}")[0].contentWindow;
	var roles = win.$("#roles").val();
	
	<#-- 转变为数组, 逗号分隔开 -->
	var roleArr;
	if(roleArr != ""){
		roleArr = roles.split(",");
	}
	
	
	$('#roleTree').tree({
	    url: '${ctx}/system/user/roleTreeJson',
	    animate:true,
	    checkbox:true,
	    lines:true,
	    <#-- 过滤角色选中状态 -->
        loadFilter: function(data){
        	$(data).each(function(index, node){
        		if(roleArr != null && roleArr.length != 0){
					for(var i = 0; i < roleArr.length; i++){
						<#-- 处理一级菜单, 角色只一级 -->
	        			if(roleArr[i] == node.id){
			        		node.checked = 'true';
	        			}
	        		}
        		}
        	});
        	return data;
	    }
	});
	
	<#-- 保存角色选择 -->
	function saveCheckedRole(){
	
		<#-- 获取选中的节点, 组装菜单ID字符串, 逗号分割 -->
		var nodes = $("#roleTree").tree("getChecked");
		roles = "";
		$(nodes).each(function(index,node){
			roles += node.id + ",";
		});
		
		if(roles != ""){
			roles = roles.substring(0,roles.length-1);
		}
		
		<#-- 保存到用户编辑窗口[父窗口]的roles隐藏域 -->
		win.$("#roles").val(roles);
		$.closeWindow('directionRole');
	}
</script>
</body>
</@PAGE.HTML>