<#-- 文章图片管理 -->
<@PAGE.HTML title="文章图片管理" >
<body style="margin: 5px">
	<div style="width: 100%;height:100%;">
		<table id="datagrid"></table>
	</div>
	<script>
		$('#datagrid').datagrid({
			fit:true,
			loadMsg:'请稍后',
			striped:true,
		    idField:'id',
		    animate:true,
        	fitColumns:true,
		    toolbar:'#toolBar',
		    pagination:true,
		    pagePosition:'top',
		    pageList:[10,15,20,30,50,100,150],
		    pageSize:20,
		    singleSelect:true,
		    url:'${ctx}/system/articleImg/json',
		    columns:[[
		    	{field:'src',title:' ',width:8, formatter : function(value, row, index){
		    			if(value == "" || value == null){
		    				return '<img src="${ctx}/resource/img/no_img.jpg" />';<#-- 没有图片的 -->
		    			}
		    			return '<img style="width:30px;height:30px" src="${sys_dic.access_url}/' + value + '" onError="errorImage(this)" />'; <#-- 图片出错的统一onError -->
		    		}
	    		},
		    	{field:'imgTitle',title:'标签',width:200,sortable:true},
		    	{field:'uploadTime',title:'上传时间',sortable:true,width:150},
		    	{field:'id',title:'操作',width:80,
		    		formatter : function(value, row, index){
		    			return '<a href="#" onclick="viewItem(\'' + row.src + '\')">预览</a> | <a href="#" onclick="removeItem(\'' + value + '\')">移除</a>'
		    		}
		    	}
		    ]]
		});
		
		<#-- 预览 -->
		function viewItem(path){
			$.createSimpleWindowAutoScroll("view","预览", 800, 800, "${sys_dic.access_url}/" + path);
		}
		
		<#-- 删除 -->
		function removeItem(id){
			top.$.messager.confirm("提示","将会删除该图片, 所有引用该图片的文章将会出现问题, 是否确认删除?", function(confirm){
				if(confirm){
					 var param = {id : id};
					 <#-- 确认删除 -->
					 $.defaultAjaxOperation("${ctx}/system/articleImg/remove", param, true, true, 
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
		}
	</script>
</body>
</@PAGE.HTML>