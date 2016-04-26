<@PAGE.HTML title="菜单管理" >
<body style="margin: 5px">
	<div style="width: 100%;height:100%;">
		<table id="tt"></table>
		<div id="toolBar">
			<a href="#" onclick="addmenu()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>|
			<a href="#" onclick="editmenu()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>|
			<a href="#" onclick="removemenu()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>|
			<a href="#" onclick="movemenu('UP')" class="easyui-linkbutton" data-options="plain:true">上移</a>|
			<a href="#" onclick="movemenu('DOWN')" class="easyui-linkbutton" data-options="plain:true">下移</a>
			<a href="#" onclick="$('#tt').treegrid('collapseAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部折叠</a>
			<a href="#" onclick="$('#tt').treegrid('expandAll');" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">全部展开</a>
		</div>
	</div>
	<script>
		var moveId = null;
	
		$('#tt').treegrid({
			toolbar: '#toolBar',
			fit:true,
			loadMsg:'请稍后',
			striped:true,
		    url:'${ctx}/system/menu/menusJson', <#-- 数据请求URL -->
		    idField:'id',
		    treeField:'menuName',
		    animate:true,
        	rownumbers:true,
        	fitColumns:true,
		    columns:[[
		        {field:'menuName',title:'菜单名称',width:100, 
		        	formatter:function(value,rowData,rowIndex){
									return '<input type="radio" id="' + rowData.id + '" name="menuSelect" />' + rowData.menuName;	        			
							 }
			        },
			        
		        {field:'menuUrl',title:'菜单URL',width:150,},
		        {field:'parentName',title:'父级菜单',width:80},    
		        {field:'privilegeCode',title:'权限码',width:80},
		        {field:'privilegePos',title:'权限位',width:40},
		        {field:'description',title:'说明',width:150}
		    ]],
		    <#-- 单选依赖 -->
		    onClickRow:function(row){
		    	$("#" + row.id).attr("checked",true);
		    },
		    <#-- 双节展开关闭 -->
		    onDblClickCell:function(field, row){
		    	$("#tt").treegrid('toggle',row.id);
		    },
		    onLoadSuccess:function(row, data){
		    	if(moveId != null){
			    	$("#" + moveId).attr("checked",true);
		    	}
		    }
		});
		
		<#-- 添加菜单 -->
		function addmenu(){
			 $.createSimpleWindowAutoScroll("editMenu","添加菜单", 680, 330, "${ctx}/system/menu/addView");
		}
		
		<#-- 编辑菜单 -->
		function editmenu(){
			 var radio = $("input[type='radio']:checked");
			 if(radio.length != 0){
				 $.createSimpleWindowAutoScroll("editMenu","编辑菜单", 680, 330, "${ctx}/system/menu/editView?id=" + radio.attr("id"));
			 }else{
				 $.msgTip('提示','单击选中一行进行编辑');
			 }
		}
		
		<#-- 删除菜单 -->
		function removemenu(){
			 var radio = $("input[type='radio']:checked");
			 if(radio.length != 0){
				 top.$.messager.confirm("提示","该菜单包含的子菜单以及角色引用的菜单将会一并删除, 是否确认删除?", function(confirm){
					 var param = {id : radio.attr("id")};
					 if(confirm){
						 <#-- 确认删除 -->
						 $.defaultAjaxOperation("${ctx}/system/menu/remove", param, true, true, 
							 {
								 success: function (result){
									 if(result.success == 'true'){
									 	 $.timeOutMsgTip("提示", result.message);
									 }else{
										 $.errorTip("警告", "删除操作失败, 请联系系统管理人员");
									 }
									 <#-- 刷新窗口数据 -->
									 $.reloadData(window.name);
								 }
							 }
						 );
						
					 }
				 })
			 }else{
				 $.msgTip('提示','单击选中一行进行删除');
			 }
		}
		 
		<#-- 移动菜单 -->
		function movemenu(direction){
			 var radio = $("input[type='radio']:checked");
			 if(radio.length != 0){
					 moveId = radio.attr("id");
					 var param = {id : radio.attr("id"), direction : direction};
					 $.defaultAjaxOperation("${ctx}/system/menu/move", param, true, true, 
						 {
							 success: function (result){
						 		 if(result.success == 'false'){
									 $.errorTip("警告", "操作失败, 请联系系统管理人员");
								 }
								 <#-- 刷新窗口数据 -->
								$.reloadData(window.name);
							 }
						 }
					 );
			 }else{
				 $.msgTip('提示','单击选中一行移动位置');
			 }
		}
		
	</script>
</body>
</@PAGE.HTML>