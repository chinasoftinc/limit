<script>
	$('#dataGrid').treegrid({
		loadMsg:'请稍后',
	    toolbar:'#toolBar',
	    border:false,
		striped:true,
	    url:'${ctx}/system/parameter/parameterJson',
	    idField:'id',
	    treeField:'optDescription',
	    animate:true,
    	rownumbers:true,
		fit:true,
    	fitColumns:true,
	    columns:[[
	    	{field:'optDescription',title:'参数说明',width:150,
	    			formatter:function(value, rowData, rowIndex){
						var column = '<input type="radio" id="' + rowData.id + '" name="parameterSelected" isDir="' + rowData.optIsDir + '" optType="' + rowData.optType + '" optDeep="' + rowData.optDeep + '" optDescription="' + rowData.optDescription +'" />'; 
						if(rowData.optIsDir == '1'){
							column += rowData.optDescription;
						}else{
							column += '<span style="color:orange">' + rowData.optDescription + '</span>';
						}
						return column;
				 	}
	    	},
	    	{field:'optType',title:'类型',width:50,
	        		formatter:function(value,rowData,rowIndex){
						var type = "";
						if(rowData.optIsDir == "1"){
							type = "目录";
						}else{
							type = "参数";
						}
						return type;
				 	}
	        },
	        {field:'optName',title:'参数名',width:200},
	        {field:'optValue',title:'参数值',width:200}
	    ]],

	 	<#-- 单选 -->
	    onClickRow:function(row){ 
	    	$("#" + row.id).attr("checked",true);
	    },
	    
	    <#-- 双击展开关闭 -->
	    onDblClickCell:function(field, row){
	    	$("#dataGrid").treegrid('toggle',row.id);
	    },
	    
	    <#-- 右键菜单 -->
	    onContextMenu: function(e, node){
			e.preventDefault();
			$selectTreeUl = $(e.target).closest("ul");
			selectNode = node;
			$selectTreeUl.tree('select', node.target);
			$("#" + node.id).attr("checked", true);

			var rightMouseMenu = "";
			if(node.optIsDir == "1"){
				rightMouseMenu = "rightMouseMenuForDirectory";
			}else{
				rightMouseMenu = "rightMouseMenuForParameter";
			}
				
			$('#' + rightMouseMenu).menu('show', {
				left : e.pageX,
				top : e.pageY,
				hideOnUnhover : false
			});
		}
	    
	});
	
	<#-- 添加主目录 -->
	function addRootDirectory(){
		 $.createSimpleWindowAutoScroll("editParameter","添加主目录", 680, 180, "${ctx}/system/parameter/addParameterView?optType=0&optIsDir=1&optParentId=0");
	}
	
	<#-- 添加子目录 -->
	function addSubDirectory(){
		var radio = $("input[type='radio'][name='parameterSelected']:checked");
		 $.createSimpleWindowAutoScroll("editParameter","添加目录", 680, 230, "${ctx}/system/parameter/addParameterView?optType=0&optIsDir=1&optParentId=" + radio.attr("id"));
	}
	
	<#-- 添加参数 -->
	function addParameter(){
		var radio = $("input[type='radio'][name='parameterSelected']:checked");
		$.createSimpleWindowAutoScroll("editParameter","添加子选项", 680, 330, "${ctx}/system/parameter/addParameterView?optIsDir=0&optType=0&optParentId=" + radio.attr("id"));
	}
	
	<#-- 编辑参数 -->
	function editParameter(){
		var radio = $("input[type='radio'][name='parameterSelected']:checked");
		if(radio.attr('optDeep') == 0){
			$.createSimpleWindowAutoScroll("editParameter","编辑主目录", 680, 180, "${ctx}/system/parameter/editParameterView?id=" + radio.attr("id"));
		}else if(radio.attr('isDir') == '1'){
			$.createSimpleWindowAutoScroll("editParameter","编辑目录", 680, 230, "${ctx}/system/parameter/editParameterView?id=" + radio.attr("id"));
		}else{
			$.createSimpleWindowAutoScroll("editParameter","编辑参数", 680, 330, "${ctx}/system/parameter/editParameterView?id=" + radio.attr("id"));
		}
	}
	
	<#-- 删除参数-->
	function removeParameter(){
		 var radio = $("input[type='radio'][name='parameterSelected']:checked");
		 var tipMsg = "确认删除键为 " + radio.attr("optName") + " 的参数吗?";
		 if(radio.attr('isDir') == '1'){
		 	tipMsg = "删除该目录将会删除 " + radio.attr('optDescription') + " 目录下的所有数据, 是否确认?";
		 }
		 
		 top.$.messager.confirm("警告",tipMsg, function(confirm){
			 var param = {id : radio.attr("id")};
			 if(confirm){
 				$.defaultAjaxOperation("${ctx}/system/parameter/removeParameter", 
					param, 
				 	true, 
				 	true, 
					{
 						success: function (result){
							 if(result.success){
							 	 $.timeOutMsgTip("提示", result.message);
							 }else{
								 $.errorTip("警告", "操作失败");
							 }
							 $.reloadData(window.name);
						}
					}
 				);
				
			 }
		 })
	}
	
	<#-- 移动位置 -->
	function move(direction){
		 var radio = $("input[type='radio']:checked");
		 moveId = radio.attr("id");
		 var param = {id : radio.attr("id"), direction : direction};
		 $.defaultAjaxOperation("${ctx}/system/dictionary/move", param, true, true, 
			 {
				 success: function (result){
			 		 if(!result.success){
						 $.errorTip("警告", "操作失败");
					 }
					 <#-- 刷新窗口数据 -->
					$.reloadData(window.name);
				 }
			 }
		 );
	}
</script>