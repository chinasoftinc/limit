<script>
	<#-- 选项字典dataGrid -->
	$('#dictionaryDataGrid').treegrid({
		fit:true,
		loadMsg:'请稍后',
		toolbar: '#optdicToolBar',
		striped:true,
	    url:'${ctx}/system/dictionary/dictionaryJson',
	    idField:'id',
	    treeField:'optDescription',
	    animate:true,
    	rownumbers:true,
    	fitColumns:true,
	    columns:[[
	    	{field:'optDescription',title:'选项说明',width:200,
	    			formatter:function(value, rowData, rowIndex){
						return '<input type="radio" id="' + rowData.id + '" name="dictionarySelected" isDir="' + rowData.optIsDir + '" dictionaryType="' + rowData.optType + '" />' + rowData.optDescription;	        			
				 	}
	    	},
	        {field:'optName',title:'名称',width:200,},
	        {field:'optKey',title:'键',width:50,},
	        {field:'optValue',title:'值',width:200},    
	        {field:'optSortNo',title:'排序',width:50},
	        {field:'optType',title:'类型',width:50,
	        		formatter:function(value,rowData,rowIndex){
						var type = "";
						if(rowData.optIsDir == "1"){
							type = "目录";
						}else if(rowData.optType == "2"){
							type = "选项组";
						}else if(rowData.optType == "1"){
							type = "选项";
						}
						return type;
				 	}
	        }
	    ]],
	    <#-- 单选 -->
	    onClickRow:function(row){ 
	    	$("#" + row.id).attr("checked",true);
	    },
	    <#-- 双节展开关闭 -->
	    onDblClickCell:function(field, row){
	    	$("#dictionaryDataGrid").treegrid('toggle',row.id);
	    },
	    
	    <#-- 右键菜单 -->
	    onContextMenu: function(e, node){
			e.preventDefault();
			$selectTreeUl = $(e.target).closest("ul");
			selectNode = node;
			$selectTreeUl.tree('select', node.target);
			$("#" + node.id).attr("checked", true);

			console.info(node);

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
		},
	});
	
	<#-- 添加主目录 -->
	function addRootDirectory(){
		 $.createSimpleWindowAutoScroll("editDictionary","添加主目录", 680, 180, "${ctx}/system/dictionary/addDictionaryView?optIsDir=1&optParentId=0");
	}
	
	<#-- 添加子目录 -->
	function addSubDictionary(){
		var radio = $("input[type='radio'][name='dictionarySelected']:checked");
		 $.createSimpleWindowAutoScroll("editDictionary","添加目录", 680, 230, "${ctx}/system/dictionary/addDictionaryView?optIsDir=1&optParentId=" + radio.attr("id"));
	}
	
	<#-- 添加选项组 -->
	function addDictionaryGroup(){
		 var radio = $("input[type='radio'][name='dictionarySelected']:checked");
		 $.createSimpleWindowAutoScroll("editDictionary","添加选项组", 680, 290, "${ctx}/system/dictionary/addDictionaryView?optIsDir=0&optType=2&optParentId=" + radio.attr("id"));
	}
	
	<#-- 删除选项字典-->
	function removeDictionary(){
		 var radio = $("input[type='radio'][name='dictionarySelected']:checked");
		 if(radio.length != 0){
			 top.$.messager.confirm("提示","子选项将同时被删除, 引用该选项字典的页面将会崩溃, 是否确认删除?", function(confirm){
				 var param = {id : radio.attr("id")};
				 if(confirm){
					 <#-- 确认删除 -->
					 $.defaultAjaxOperation("${ctx}/system/attribute/removeOptdic", param, true, true, 
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
</script>