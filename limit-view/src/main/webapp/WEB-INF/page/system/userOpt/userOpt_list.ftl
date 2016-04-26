<@PAGE.HTML title="日志分析" >
<body style="margin: 5px;">
	<div style="width: 100%;height:100%;">
		<table id="dataGrid"></table>
		<div id="toolBar">
			<#-- 搜索框 -->
			<center>
				<div style="margin:5px">
					<form id="searchInput">
						管理员昵称: <input type="text" id="nickname" style="width:80px" />
						操作类型: <@SingleSelectTag id="optType" optName="opt_type" style="" />
						操作时间: <input type="text" id="minTime" style="width:130px" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" />－<input type="text" id="maxTime" style="width:130px" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" />　
					</form>
				</div>
				<div style="margin:5px">
					<a href="#" class="easyui-linkbutton" onclick="cleanSearch()" data-options="iconCls:'icon-remove',plain:true">清空</a>
					<a href="#" class="easyui-linkbutton" onclick="search()" data-options="iconCls:'icon-search',plain:true">搜索</a>
				</div>
			</center>
		</div>
	</div>
	<script>
		$('#dataGrid').datagrid({
			fit:true,
			loadMsg:'请稍后',
			striped:true,
		    idField:'id',
		    animate:true,
        	rownumbers:true,
        	fitColumns:true,
		    toolbar:'#toolBar',
		    pagination:true,
		    pagePosition:'top',
		    pageList:[10,15,20,30,50,100,150],
		    pageSize:20,
		    singleSelect:true,
		    nowrap:true,
		    url:'${ctx}/system/userOpt/json',
		    columns:[[
		        {field:'nickname',title:'管理员昵称',width:50,sortable:true},
		        {field:'entityType',title:'操作的实体类型',width:50,sortable:true},
		        {field:'optType',title:'操作类型',width:50,sortable:true},
		        {field:'optDetail',title:'操作详情',width:150,
		    		formatter : function(value, row, index){
		    			return row.optType + '了 [' + row.entityType + '] 的' + ' "' + row.entityTitle + '"';
		    		}
		    	},
		        {field:'isSuccess',title:'操作是否成功',width:50,sortable:true},
		        {field:'optTime',title:'操作时间',width:50,sortable:true},
		        {field:'id',title:'操作',width:50,
		    		formatter : function(value, row, index){
		    			return '<a href="#" onclick="viewItem(\'' + value + '\')">详细</a>'
		    		}
		    	}
		    ]]
		});
		
		<#-- 搜索日志 -->
		function search(){
			$("#dataGrid").datagrid("load",{
				nickname : $("#nickname").val(),
				minTime : $("#minTime").val(),
				maxTime : $("#maxTime").val(),
				optType : $("#optType").val()
			});
		}
		
		<#-- 清空搜索 -->
		function cleanSearch(){
			$("#searchInput")[0].reset();
		}
		
		<#-- 查看操作详细-->
		function viewItem(id){
			$.createSimpleWindowAutoScroll("checkOpt","查看", 400, 480, "${ctx}/system/userOpt/view?id=" + id);
		}
	</script>
</body>
</@PAGE.HTML>