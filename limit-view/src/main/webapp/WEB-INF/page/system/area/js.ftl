<script>
	<#-- 全局选中对象 -->
  	var $selectTreeUl = null; <#-- 操作所在的treeUl -->
	var selectNode = null;	<#-- 右键选中的地区节点 -->
	var nowEditAreaValue = "";

	<#-- 初始化一级地域 -->
	$(function(){
		getTreeNode("#level_1",0);
	});
	
	function getTreeNode (treeId, areasParentId){
		$(treeId).attr('areasParentId', areasParentId); <#-- 让子地区树持有父地区的id引用 -->
		$(treeId).tree({
		    url : "${ctx}/system/area/areaJson?areasParentId=" + areasParentId,
		    animate : true,
		    lines : true,
		    
		    <#-- 双击显示下级树 -->
		    onDblClick : function(node){
		    	<#-- 获取下级树div -->
		    	var newTreeId = getNextTreeId(treeId);
		    	if(null == newTreeId || "" == newTreeId  || undefined == newTreeId){
		    		return;
		    	}
		    	
		    	<#-- 递归调用获取下级树数据 -->
			    getTreeNode(newTreeId, node.id);
		    },
		    
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
			
			onAfterEdit : function(node){
				var text = node.text;
				text = text.trim();
				if((text == null || text == "" || text == undefined) && node.id == "new"){
					$selectTreeUl.tree('remove', node.target);
				}else{
					save(node); <#-- 保存地区 -->
				}
			}
			
		});
	}
	
	<#-- 添加 -->
	function insert(treeUl){
		if(treeUl != null){
			$selectTreeUl = $(treeUl).parent().next();
		}
	 	var selected = $selectTreeUl.tree('getSelected');
		$selectTreeUl.tree('insert', {data: {id : 'new'}});
		var newArea = $selectTreeUl.tree('find', 'new');
		$selectTreeUl.tree('beginEdit', newArea.target);
	}
	
	<#-- 修改 -->
	function edit(){
		var editArae = $selectTreeUl.tree('getSelected');
		nowEditAreaValue = editArae.text; <#-- 保存正在修改的值 -->
		$selectTreeUl.tree('beginEdit', editArae.target);
	}
	
	<#-- 保存 -->
	function save(node){
		var areasParentId = $selectTreeUl.attr("areasParentId");
		if(node.id == "new"){
			<#-- 添加 -->
			var param = {areasName : node.text, operation : "add", areasParentId : areasParentId};
			$.defaultAjaxOperation("${ctx}/system/area/saveArea", param, true, true, 
				 {
					 success: function (result){
						 if(result.success){
						 	 $.timeOutMsgTip("提示", result.message);
						 }else{
							 $.errorTip("警告", "操作失败");
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
				var param = {id : node.id, areasName : node.text, operation : "edit"};
				$.defaultAjaxOperation("${ctx}/system/area/saveArea", param, true, true, 
					{
						success: function (result){
							if(result.success){
							 	$.timeOutMsgTip("提示", result.message);
							}else{
								$.errorTip("警告", "操作失败");
							}
							$selectTreeUl.tree("reload");
						}
					}
				);
			}
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
	
	<#-- 删除 -->
	function removeArea(){
		<#-- 保持当前所在treeId -->
		top.$.messager.confirm("警告", "该地区所有下级数据都会被删除, 是否确认删除?", function(confirm){
				var param = {id:selectNode.id};
				var currentTreeId = $selectTreeUl.attr("id");
			 
				if(confirm){
					$.defaultAjaxOperation("${ctx}/system/area/removeArea", param, true, true, {
							success: function (result){
							
								if(result.success){
									$.timeOutMsgTip("提示", result.message);
									$selectTreeUl.closest("div").nextAll().hide(300);
								}else{
									$.errorTip("警告", "操作失败");
								}
								
								$("ul").each(function(){
									 	$(this).tree("reload");
								})
						 	}
					});
			 	}
	 	})
	}
</script>