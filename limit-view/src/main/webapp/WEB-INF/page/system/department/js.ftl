<script>
	$('#dataGrid').treegrid({
		loadMsg:'请稍后',
		toolbar: '#toolBar',
		border:false,
		striped:true,
	    url:'${ctx}/system/deptment/deptJson',
	    idField:'id',
	    treeField:'deptShortName',
	    animate:true,
    	rownumbers:true,
		fit:true,
    	fitColumns:true,
	    columns:[[
	    	{field:'deptShortName',title:'简称',width:50,
	    			formatter:function(value, rowData, rowIndex){
						var column = '<input type="radio" id="' + rowData.id + '" name="deptSelected" deptType="' + rowData.deptType + '" deptParentId="' + rowData.deptParentId + '" deptDeep="' + rowData.deptDeep + '" />'; 
						if(rowData.deptType == '0'){
							'<span style="color:blue">' + rowData.deptShortName + '</span>';
						}else{
							column += rowData.deptShortName;
						}
						return column;
				 	}
	    	},
	    	{field:'deptSubCount',title:'下级数量',width:50}
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
			}else if (node.optType == "2"){
				rightMouseMenu = "rightMouseMenuForDictionaryGroup";
			}else if (node.optType == "1"){
				rightMouseMenu = "rightMouseMenuForDictionary";
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
		 $.createSimpleWindowAutoScroll("editDictionary","添加主目录", 680, 180, "${ctx}/system/dictionary/addDictionaryView?optType=1&optIsDir=1&optParentId=0");
	}
	
	<#-- 添加子目录 -->
	function addSubDirectory(){
		var radio = $("input[type='radio'][name='dictionarySelected']:checked");
		 $.createSimpleWindowAutoScroll("editDictionary","添加目录", 680, 230, "${ctx}/system/dictionary/addDictionaryView?optType=1&optIsDir=1&optParentId=" + radio.attr("id"));
	}
	
	<#-- 添加选项组 -->
	function addDictionaryGroup(){
		 var radio = $("input[type='radio'][name='dictionarySelected']:checked");
		 $.createSimpleWindowAutoScroll("editDictionary","添加选项组", 680, 290, "${ctx}/system/dictionary/addDictionaryView?optIsDir=0&optType=2&optParentId=" + radio.attr("id"));
	}
	
	<#-- 添加子选项 -->
	function addDictionary(){
		 var radio = $("input[type='radio'][name='dictionarySelected']:checked");
		 $.createSimpleWindowAutoScroll("editDictionary","添加子选项", 680, 330, "${ctx}/system/dictionary/addDictionaryView?optIsDir=0&optType=1&optParentId=" + radio.attr("id"));
	}
	
	<#-- 编辑选项字典 -->
	function editDictionary(){
		var radio = $("input[type='radio'][name='dictionarySelected']:checked");
		if(radio.attr('optDeep') == 0){
			$.createSimpleWindowAutoScroll("editDictionary","编辑主目录", 680, 180, "${ctx}/system/dictionary/editDictionaryView?id=" + radio.attr("id"));
		}else if(radio.attr('isDir') == '1'){
			$.createSimpleWindowAutoScroll("editDictionary","编辑目录", 680, 230, "${ctx}/system/dictionary/editDictionaryView?id=" + radio.attr("id"));
		}else if(radio.attr('optType') == '2'){
			$.createSimpleWindowAutoScroll("editDictionary","编辑选项组", 680, 290, "${ctx}/system/dictionary/editDictionaryView?id=" + radio.attr("id"));
		}else{
			$.createSimpleWindowAutoScroll("editDictionary","编辑子选项", 680, 330, "${ctx}/system/dictionary/editDictionaryView?id=" + radio.attr("id"));
		}
	}
	
	<#-- 删除选项字典-->
	function removeDictionary(){
		 var radio = $("input[type='radio'][name='dictionarySelected']:checked");
		 var tipMsg = "确认删除键为 " + radio.attr("optKey") + " 的子选项吗?";
		 if(radio.attr('isDir') == '1'){
		 	tipMsg = "删除该目录将会删除 " + radio.attr('optDescription') + " 目录下的所有数据, 是否确认?";
		 }else if(radio.attr('optType') == '2'){
		 	tipMsg = "删除该选项组将会删除 " + radio.attr('optDescription') + " 下的所有子选项, 是否确认?";
		 }
		 
		 top.$.messager.confirm("警告",tipMsg, function(confirm){
			 var param = {id : radio.attr("id")};
			 if(confirm){
 				$.defaultAjaxOperation("${ctx}/system/dictionary/removeDictionary", 
					param, 
				 	true, 
				 	true, 
					{
 						success: function (result){
							 if(result.success){
							 	 $.timeOutMsgTip("提示", result.message);
							 }else{
								 $.errorTip("警告", "删除操作失败");
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