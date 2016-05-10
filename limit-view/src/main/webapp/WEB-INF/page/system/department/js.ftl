<script>
	$('#dataGrid').treegrid({
		loadMsg:'请稍后',
		toolbar: '#toolBar',
		border:false,
		striped:true,
	    url:'${ctx}/system/dept/deptJson',
	    idField:'id',
	    treeField:'deptShortName',
	    animate:true,
    	rownumbers:true,
		fit:true,
    	fitColumns:true,
	    columns:[[
	    	{field:'deptShortName',title:'简称',width:100,
	    			formatter:function(value, rowData, rowIndex){
						var column = '<input type="radio" id="' + rowData.id + '" name="deptSelected" deptType="' + rowData.deptType + '" deptParentId="' + rowData.deptParentId + '" deptDeep="' + rowData.deptDeep + '" />'; 
						if(rowData.deptType == '0'){
							column += '<span style="color:blue;position:relative;top: -2">' + rowData.deptShortName + '</span>';
						}else{
							column += '<span style="color:orange;position:relative;top: -2">' + rowData.deptShortName + '</span>';
						}
						return column;
				 	}
	    	},
	    	{field:'deptType',title:'类型',width:50,
	    			formatter:function(value, rowData, rowIndex){
						return value == '0' ? '机构':'部门';
				 	}
	    	},
	    	{field:'deptSubCount',title:'下级数量',width:30}
	    ]],
	    
	    <#-- 单选 -->
	    onClickRow:function(row){ 
	    	$("#" + row.id).attr("checked",true);
	    	
	    	$('#editPanel').panel({
				title: '查看',
				fit:true,
				closable:true,
				border:false,
				href:'${ctx}/system/dept/view?id=' + row.id
			});
			
			$('#editPanel').panel('open');
		
	    },
	    <#-- 双击展开关闭 -->
	    onDblClickCell:function(field, row){
	    	$("#dataGrid").treegrid('toggle',row.id);
	    },
	    
	    <#-- 右键菜单 -->
	    onContextMenu: function(e, node){
			e.preventDefault();
			$("#" + node.id).attr("checked", true);

			var rightMouseMenu = "";
			if(node.deptType == "0"){
				rightMouseMenu = "rightMouseMenuForOrg";
			}else{
				rightMouseMenu = "rightMouseMenuForDept";
			}
				
			$('#' + rightMouseMenu).menu('show', {
				left : e.pageX,
				top : e.pageY,
				hideOnUnhover : false
			});
		}
	});
	
	<#-- 添加主机构 -->
	function addRootOrg(){
		$('#editPanel').panel({
			title: '添加主机构',
			fit:true,
			closable:true,
			border:false,
			href:'${ctx}/system/dept/addDeptView?deptType=0&&deptParentId=0'
		});
		
		$('#editPanel').panel('open');
	}
	
	<#-- 添加子机构 -->
	function addSubOrg(){
		var radio = $("input[type='radio'][name='deptSelected']:checked");
	
		$('#editPanel').panel({
			title: '添加子机构',
			fit:true,
			closable:true,
			border:false,
			href:'${ctx}/system/dept/addDeptView?deptType=0&&deptParentId=' + radio.attr('id')
		});
		
		$('#editPanel').panel('open');
	}
	
	<#-- 添加子部门 -->
	function addSubDept(){
		var radio = $("input[type='radio'][name='deptSelected']:checked");
	
		$('#editPanel').panel({
			title: '添加子部门',
			fit:true,
			closable:true,
			border:false,
			href:'${ctx}/system/dept/addDeptView?deptType=1&&deptParentId=' + radio.attr('id')
		});
		
		$('#editPanel').panel('open');
	}
	
	<#-- 编辑 -->
	function editDept(){
		var radio = $("input[type='radio'][name='deptSelected']:checked");
		var title = "编辑";
		if(radio.attr('deptDeep') == 0){
			title += "主机构";
		}else if(radio.attr('deptType') == '0'){
			title += "机构";
		}else{
			title += "部门";
		}
		
		$('#editPanel').panel({
			title: title,
			fit:true,
			closable:true,
			border:false,
			href:'${ctx}/system/dept/editDeptView?id=' + radio.attr('id')
		});
		$('#editPanel').panel('open');
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
	
	<#-- 提交 -->
	function commitData(form){
		if($(form).form('validate')){
			var param = [];
			$("#form :input, #form textarea, #form select").each(function(){
				param.push({name:this.name,value:$(this).val()});
		    });
		    
		    $.defaultAjaxOperation("${ctx}/system/dept/saveDept", param, true, true, 
				 {
					 success: function (result){
				 		 if(result.success){
				 		 	$.timeOutMsgTip("提示", result.message);						 	 
							 <#-- 刷新窗口数据 -->
							 window.location.reload(true);
						 }else{
							 $.errorTip("警告", "操作失败");
						 }
					 }
				 }
			);
		}
		return false;
	}
</script>