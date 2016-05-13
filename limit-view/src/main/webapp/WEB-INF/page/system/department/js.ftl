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
						var column = '<input type="radio" id="' + rowData.id + '" name="deptSelected" deptType="' + rowData.deptType + '" deptName="' + rowData.deptName +'" deptParentId="' + rowData.deptParentId + '" deptDeep="' + rowData.deptDeep + '" />'; 
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
	
	<#-- 删除-->
	function removeDept(){
		 var radio = $("input[type='radio'][name='deptSelected']:checked");
		 
		 var tipMsg = "";
		 if(radio.attr('deptType') == '1'){
		 	tipMsg = "若含有子机构或子部门将无法删除, 确认删除机构: " + radio.attr('deptName') + " 吗?";
		 }else {
		 	tipMsg = "若含有子部门或部门中尚有人员将无法删除, 确认删除部门: " + radio.attr('deptName') + " 吗?";
		 }
		 
		 top.$.messager.confirm("警告",tipMsg, function(confirm){
			 var param = {id : radio.attr("id")};
			 if(confirm){
 				$.defaultAjaxOperation("${ctx}/system/dept/removeDept", 
					param, 
				 	true, 
				 	true, 
					{
 						success: function (result){
							 if(result.success){
							 	 $.timeOutMsgTip("提示", result.message);
							 }else{
								 $.errorTip("警告", result.message);
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
		 $.defaultAjaxOperation("${ctx}/system/dept/move", param, true, true, 
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
	
	<#-- 切换tab加载用户数据 -->
	function loadUserList(){
		return function(title, index){
			if(index == 1){
				var deptType = $('#userList').attr('deptType');
				var param = deptType == '0' ? 'orgId=' + $('#userList').attr('deptId') : 'departmentId=' + $('#userList').attr('deptId')
				$('#userList').datagrid({
					fit:true,
					loadMsg:'请稍后',
					striped:true,
				    idField:'id',
				    animate:true,
			    	rownumbers:true,
			    	fitColumns:true,
				    pagination:true,
				    pagePosition:'top',
				    pageList:[10,15,20,30,50,100,150],
				    pageSize:20,
				    singleSelect:true,
				    url:'${ctx}/system/user/userJson?' + param,
				    columns:[[
				    	{field:'userCode',title:'用户编码',width:100},
				        {field:'nickName',title:'用户昵称',width:100},
				        {field:'userSex',title:'性别',width:50,sortable:true,formatter: function(value,row,index){
				        		return value == '0' ? '男' : '女';
				        	}
				        }
				    ]],
				    
				    onDblClickRow:function(rowIndex, rowData){
				    	$.createSimpleWindowAutoScroll("userView","查看用户", 680, 500, "${ctx}/system/user/userView?id=" + rowData.id);
				    }
				});
			}
		}
	}
</script>