<@PAGE.HTML title="地区管理" >
<style>
	#div1,#div2,#div3,#div4{
		width:24%;height:93%;margin-right:1%;float:left;background:#fff;overflow:auto;padding-top:40px
	}
	#div2,#div3,#div4{
		display:none;
	}
	.tree_toolbar{
		padding:5px;background:#fff;border:1px solid #ccc;position:fixed;top:5px;
	}
</style>
<body style="margin: 5px">
<div style="width: 100%;height:100%;">
	<#-- 地区树 -->
	<div style="width: 98%;height:98%;border: 1px solid #ccc;padding:5px;background:#efefef">
	
		<div id="div1">
			<div class="tree_toolbar">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="newArea(this)">添加地区</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="$(this).parent().next().tree('reload')">刷新</a>
			</div>
			<ul id="level_1"></ul>
		</div>
		
		<div id="div2">
			<div class="tree_toolbar">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="newArea(this)">添加地区</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="$(this).parent().next().tree('reload')">刷新</a>
			</div>
			<ul id="level_2"></ul>
		</div>
		
		<div id="div3">
			<div class="tree_toolbar">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="newArea(this)">添加地区</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="$(this).parent().next().tree('reload')">刷新</a>
			</div>
			<ul id="level_3"></ul>
		</div>
		
		<div id="div4">
			<div class="tree_toolbar">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="newArea(this)">添加地区</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="$(this).parent().next().tree('reload')">刷新</a>
			</div>
			<ul id="level_4"></ul>
		</div>
	</div>
	
	<#-- 右键菜单 -->
	<div id="rightMouseMenu" class="easyui-menu" style="display:none">
		<div data-options="iconCls:'icon-add'" onclick="newArea()">添加新菜单</div>
		<div data-options="iconCls:'icon-edit'" onclick="editArea()">修改这个地区</div>
		<div data-options="iconCls:'icon-no'" onclick="deleteArea('selected')">删除这个地区</div>
		<div data-options="iconCls:'icon-cancel'" onclick="deleteArea('checked')">删除所有选择的地区</div>
		<div data-options="iconCls:'icon-undo'" onclick="uncheckedAllArea()">取消所有选择的地区</div>
	</div>
<script>

	<#-- 全局选中对象 -->
  	var $selectTreeUl = null; <#-- 操作所在的treeUl -->
	var selectNode = null;	<#-- 右键选中的地区节点 -->

	<#-- 初始化一级地域 -->
	$(function(){
		getTreeNode("#level_1",0);
	});
	
	<#-- 获取treeData, 递归调用 -->
	function getTreeNode (treeId, parentareaid){
		$(treeId).attr('parentareaid', parentareaid); <#-- 让子地区treeUl持有父地区的id引用 -->
		$(treeId).tree({
		    url : "${ctx}/system/area/treeDataJson?parentareaid=" + parentareaid,
		    animate : true,
		    lines : true,
		    checkbox:true,
		    <#-- 双击打开子地区treeUl -->
		    onDblClick : function(node){
		    	<#-- 获取下一个Tree显示区 -->
		    	var newTreeId = getNextTreeId(treeId);
		    	if(null == newTreeId || "" == newTreeId  || undefined == newTreeId){
		    		return;
		    	}
		    	
		    	<#-- 获取子地区数据, 在下一个Tree显示区显示 -->
			    getTreeNode(newTreeId, node.id);
		    },
		    
		    <#-- 右键菜单 -->
		    onContextMenu: function(e, node){
				e.preventDefault();
				$selectTreeUl = $(e.target).closest("ul");
				selectNode = node;
				// 查找节点
				$selectTreeUl.tree('select', node.target);
				// 显示快捷菜单
				$('#rightMouseMenu').menu('show', {
					left : e.pageX,
					top : e.pageY,
					hideOnUnhover : false
				});
			},
			
			<#-- 地区编辑完成 -->
			onAfterEdit : function(node){
				var text = node.text;
				text = text.trim();
				if((text == null || text == "" || text == undefined) && node.id == "new"){
					$selectTreeUl.tree('remove', node.target);
				}else{
					saveAreaNode(node); <#-- 保存地区 -->
				}
			}
			
		});
	}
	
	<#-- 新建地区 -->
	function newArea(button){
		<#-- 如果是按钮点击, 找到该按钮所属treeUl -->
		if(button != undefined){
			$selectTreeUl = $(button).parent().next();
		}
	 	var selected = $selectTreeUl.tree('getSelected');
		$selectTreeUl.tree('insert', {
			data: {
				id : 'new',
			}
		});
		var newArea = $selectTreeUl.tree('find', 'new'); <#-- 重新获取新添加节点 -->
		$selectTreeUl.tree('beginEdit', newArea.target); <#-- 开启编辑 -->
	}
	
	var nowEditAreaValue = "";
	<#-- 修改区域 -->
	function editArea(){
		var editArae = $selectTreeUl.tree('getSelected');
		nowEditAreaValue = editArae.text; <#-- 保存正在修改的值 -->
		$selectTreeUl.tree('beginEdit', editArae.target); <#-- 开启编辑 -->
	}
	
	<#-- 保存地区 -->
	function saveAreaNode(node){
		var parentareaid = $selectTreeUl.attr("parentareaid");
		if(node.id == "new"){
			<#-- 添加新地区 -->
			var param = {areaname : node.text, operation : "add", parentareaid : parentareaid};
			$.defaultAjaxOperation("${ctx}/system/area/saveArea", param, true, true, 
				 {
					 success: function (result){
						 if(result.success == true){
						 	 $.timeOutMsgTip("提示", result.message);
						 }else{
							 $.errorTip("警告", "操作失败, 请联系系统管理人员");
						 }
						 $selectTreeUl.tree("reload");
					 }
				 }
			 );
		}else{
			<#-- 更新地区 -->
			var text = node.text;
			text = text.trim();
			if(text == null || text == "" || text == undefined || text == nowEditAreaValue){
				$selectTreeUl.tree("reload");
			}else{
				var param = {areaid : node.id, areaname : node.text, operation : "edit"};
				$.defaultAjaxOperation("${ctx}/system/area/saveArea", param, true, true, 
					{
						success: function (result){
							if(result.success == true){
							 	$.timeOutMsgTip("提示", result.message);
							}else{
								$.errorTip("警告", "操作失败, 请联系系统管理人员");
							}
							$selectTreeUl.tree("reload");
						}
					}
				);
			}
		}
	}
	
	<#-- 删除地区 -->
	function deleteArea(flag){
		<#-- 保持当前所在treeId -->
		top.$.messager.confirm("提示","所有子地区数据会一并删除, 引用该地区的业务模型将会崩溃, 是否确认删除?", function(confirm){
			 var param = null;
			 var currentTreeId = $selectTreeUl.attr("id");
			 
			 <#-- 组装参数 -->
			 if(flag == "selected"){
				<#-- 单行删除 -->
				param = {areaids : selectNode.id};
			 }else{
			 	<#-- 选中删除 -->
			 	var nodes = $selectTreeUl.tree('getChecked');
			 	if(nodes.length == 0 || null == nodes){
			 		$.msgTip('提示','勾选一行进行编辑');
			 		return;
			 	}else{
			 		var areaids = "";
			 		for(var i = 0; i < nodes.length; i++){
			 			areaids += (nodes[i].id + ",");
			 		}
			 		areaids = areaids.substring(0,areaids.length-1);
			 		param = {areaids : areaids};
			 	}
			 }
			 
			 <#-- 确认删除 -->
			 if(confirm){
				 $.defaultAjaxOperation("${ctx}/system/area/removeArea", param, true, true, 
					 {
						 success: function (result){
							 if(result.success == true){
							 	 $.timeOutMsgTip("提示", result.message);
							 }else{
								 $.errorTip("警告", "删除操作失败, 请联系系统管理人员");
							 }
							 $("ul").each(function(){
							 		$(this).tree("reload");
							 	}
							 )
						 }
					 }
				 );
			 }
		 })
	}
	
	<#-- 取消所有勾选中的地区 -->
	function uncheckedAllArea(){
		var nodes = $selectTreeUl.tree('getChecked');
		for(var i = 0; i < nodes.length; i++){
			$selectTreeUl.tree('uncheck', nodes[i].target);
 		}
	}
	
	<#-- 根据指定的Tree显示区Id获取下一个Tree显示区uId -->
	function getNextTreeId(treeId){
		if(null == treeId || "" == treeId  || undefined == treeId){
			return null;
		}else{
			treeId = treeId.replace("#level_","");
			
			switch (treeId) {
				case "1":
					$("#div2").show(500).attr('name','').nextAll().hide(300); <#-- 让下一个div显示, 后续div隐藏 -->
					treeId = "#level_" + "2";
					break;
				case "2":
					$("#div3").show(500).nextAll().hide(300);
					treeId = "#level_" + "3";
					break;
				case "3":
					$("#div4").show(500).nextAll().hide(300);
					treeId = "#level_" + "4";
					break;
					
				default : ""
					break;
			}
			return treeId;
		}
	}
</script>
</body>
</@PAGE.HTML>