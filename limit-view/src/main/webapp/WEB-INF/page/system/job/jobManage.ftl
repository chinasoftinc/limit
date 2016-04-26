<@PAGE.HTML title="系统任务管理" >
<body style="margin: 5px">
	<div style="width: 100%;height:100%;">
	
		<#-- 任务列表 -->
		<div style="height:47%;width:100%;">
			<div  class="easyui-panel" title="任务列表">
				<div style="height:100%;width:100%;">
					<table id="jobDataGrid" style="overflow:scroll"></table>
					<#-- 任务toolBar -->					
					<div id="jobToolBar">
						<a href="#" onclick="addJob()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>|
						<a href="#" onclick="editJob()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>|
						<a href="#" onclick="removeJob()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
					</div>
				</div>
		    </div>
		</div>
		
		
		<#-- 任务日志 -->
		<div style="height:47%;width:100%">
			<div class="easyui-panel" title="任务日志">
				<div style="height:100%;width:100%;">
					<table id="joblogDataGrid"></table>
					<div id="joblogToolBar">
						<#-- 搜索框 -->
						<center>
							<div style="margin:5px">
								<form id="searchInput">
									jobName: <input type="text" id="jobName" style="width:120px">&nbsp;&nbsp;&nbsp;
									时间区间: <input type="text" id="minEndTime" style="width:130px" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"> -
										    <input type="text" id="maxEndTime" style="width:130px" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
											  &nbsp;&nbsp;&nbsp;
									执行结果: <@SingleSelectTag id="result" optName="job_result" style="" />
												&nbsp;&nbsp;&nbsp;
									<a href="#" class="easyui-linkbutton" onclick="cleanSearch()" data-options="iconCls:'icon-remove',plain:true">清空</a>
									<a href="#" class="easyui-linkbutton" onclick="searchJoblog()" data-options="iconCls:'icon-search',plain:true">搜索</a>
								</form>
							</div>
						</center>
					</div>
				</div>
		    </div>
		</div>
		
	</div>
	<script>
<#-- 任务dataGrid -->
		$('#jobDataGrid').datagrid({
			fit:true,
			loadMsg:'请稍后',
			striped:true,
		    idField:'id',
		    animate:true,
        	rownumbers:true,
        	fitColumns:true,
        	border:false,
		    toolbar:'#jobToolBar',
		    singleSelect:true,
		    pagination:true,
		    pagePosition:'top',
		    url:'${ctx}/system/job/jobsJson',
		    columns:[[
		        {field:'name',title:'',width:100,
		        	formatter:function(value,rowData,rowIndex){
						return '<input type="radio" id="' + rowData.id + '" name="jobSelect" style="position:relative;top:3px"/>&nbsp;&nbsp;' + rowData.name;	        			
				    }
		        },
		        {field:'jobName',title:'任务唯一限定名',width:100},
		        {field:'jobClass',title:'任务执行类',width:150},
		        
		        {field:'cronExpression',title:'CONR表达式',width:100},
		        {field:'status',title:'启用状态',width:50},
		        {field:'running',title:'运行状态',width:50},
		        {field:'lastBigen',title:'最后一次执行开始时间',width:100},
		        {field:'lastEnd',title:'最后一次执行结束时间',width:100},
		        {field:'description',title:'任务描述',width:150}
		    ]],
		    <#-- 单选依赖 -->
		    onClickRow:function(index, rowDate){
		    	$("#" + rowDate.id).attr("checked",true);
		    },
		    onDblClickRow: function(rowIndex, rowData){
		    	$.createSimpleWindowAutoScroll("editJob","编辑任务", 680, 450, "${ctx}/system/job/editView?id=" + rowData.id);
		    }
		});
		
		<#-- 添加任务 -->
		function addJob(){
			 $.createSimpleWindowAutoScroll("editJob","添加任务", 680, 450, "${ctx}/system/job/addView");
		}
		
		<#-- 编辑任务 -->
		function editJob(){
			 var radio = $("input[type='radio'][name='jobSelect']:checked");
			 if(radio.length != 0){
				 $.createSimpleWindowAutoScroll("editJob","编辑任务", 680, 450, "${ctx}/system/job/editView?id=" + radio.attr("id"));
			 }else{
				 $.msgTip('提示','单击选中一行进行编辑');
			 }
		}
		
		<#-- 删除任务-->
		function removeJob(){
			 var radio = $("input[type='radio'][name='jobSelect']:checked");
			 if(radio.length != 0){
				 top.$.messager.confirm("提示","删除后系统可能会出现异常, 是否确认删除?", function(confirm){
					 var param = {id : radio.attr("id")};
					 if(confirm){
						 <#-- 确认删除 -->
						 $.defaultAjaxOperation("${ctx}/system/job/removeJob", param, true, true, 
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
		
		
		
<#-- 任务日志 -->
		$('#joblogDataGrid').datagrid({
			fit:true,
			loadMsg:'请稍后',
			striped:true,
			border:false,
		    idField:'id',
		    animate:true,
        	rownumbers:true,
        	toolbar: '#joblogToolBar',
        	fitColumns:true,
		    singleSelect:true,
			pagination:true,
		    pagePosition:'top',
		    url:'${ctx}/system/job/joblogJson',
		    columns:[[
		        {field:'jobName',title:'',width:100,
		        	formatter:function(value,rowData,rowIndex){
						return '<input type="radio" id="' + rowData.id + '" name="paramSelect" style="position:relative;top:3px"/>' + rowData.jobName;	        			
				    }
		        },
		        {field:'runBegin',title:'任务开始时间',width:100},
		        {field:'runEnd',title:'任务结束时间',width:100},
		          
		        {field:'result',title:'任务执行结果',width:50},
		        {field:'resultDescription',title:'任务执行结果描述',width:200}
		    ]],
		    <#-- 单选依赖 -->
		    onClickRow:function(index, rowDate){
		    	$("#" + rowDate.id).attr("checked",true);
		    },
		    onDblClickRow: function(rowIndex, rowData){
		    	$.createSimpleWindowAutoScroll("checkJoblog","查看日志", 680, 320, "${ctx}/system/job/checkJoblog?id=" + rowData.id);
		    }
		});
		
		<#-- 定时刷新窗口 -->
		$(function(){
			 <#-- setInterval(function(){$.reloadData(window.name);},20000); -->
		});
		
		<#-- 清空搜索 -->
		function cleanSearch(){
			$("#searchInput")[0].reset();
		}
		
		<#-- 搜索任务日志 -->
		function searchJoblog(){
			$("#joblogDataGrid").datagrid("load",{
				jobName : $("#jobName").val(),
				result : $("#result").val(),
				minEndTime : $("#minEndTime").val(),
				maxEndTime : $("#maxEndTime").val()
			});
		}
	</script>
</body>
</@PAGE.HTML>