<@PAGE.HTML title="org.ana.norman"
	link=["<link rel='icon' href='${ctx}/resource/img/0.ico' type='image/x-icon' />",
		"<link rel='shortcut icon' href='${ctx}/resource/img/0.ico' type='image/x-icon'/>"
	]
>
<body class="easyui-layout">

	<div id="topWindow"></div>

	<#-- 头部 -->
	<div class="win_body" data-options="region:'north',border:false" style="height:76px;">
		<#include 'main/head.ftl'>
	</div>
	
	<#-- 导航 -->
    <div class="win_body" data-options="region:'west',border:false,title:'导航',iconCls:'icon-daohan'" style="width:204px;">
		<#include 'main/menu.ftl'>
    </div>
    
    <#-- 主页面   -->
  	<div class="win_body" data-options="region:'center',border:false" >
  		<div id="home" class="easyui-tabs" data-options="fit:true,border:false" style="padding-left:3px;">
  			<#include 'main/home.ftl'>
		</div>
  	</div>
  	
	<#-- 底部 -->
	<div data-options="region:'south',border:false" style="height:28px;background:#efefef">
		<#include 'main/foot.ftl'>
	</div>
</body>
</@PAGE.HTML>