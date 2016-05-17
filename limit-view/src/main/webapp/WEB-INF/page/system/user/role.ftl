<@PAGE.HTML title="配置用户角色">
<body>
<div style="width: 100%;height:100%;background:#fff">
	<div style="width: 100%;height:300px;overflow:auto">
		<ul id="roleTree"></ul>
	</div>
	<div style="text-align:center">
		<a class="easyui-linkbutton" iconCls="icon-save" onclick="saveCheckedRole()" >保存</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="$.closeWindow('${winId}')" >关闭</a>
	</div>
</div>
<script>

	<#-- 获取用户编辑菜单[父窗口]的选中角色ID -->
	var win = $.getRootWindow().$("#${parentWinId}")[0].contentWindow;
	var roles = win.$("#roles").val();
	var roleArr;
	if(roleArr != ""){
		roleArr = roles.split(",");
	}
	
	
	$('#roleTree').tree({
	    url: '${ctx}/system/user/roleTreeJson',
	    animate:true,
	    checkbox:true,
	    lines:true,
        loadFilter: function(data){
        	$(data).each(function(index, node){
        		if(roleArr != null && roleArr.length != 0){
					for(var i = 0; i < roleArr.length; i++){
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
	
		var nodes = $("#roleTree").tree("getChecked");
		roles = "";
		$(nodes).each(function(index,node){
			roles += node.id + ",";
		});
		
		if(roles != ""){
			roles = roles.substring(0,roles.length-1);
		}
		
		win.$("#roles").val(roles);
		$.closeWindow('directionRole');
	}
</script>
</body>
</@PAGE.HTML>