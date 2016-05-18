<div id="top" style="overflow:hidden">
	<div id="topIntro" style="margin:5px">
		<span id="user_operator">
		 	<b>&nbsp;${Session.user_session_key.nickName}  | ${Session.user_session_key.userName} </b>
			<a id="userMenu" href="javascript:void(0)"><img width="17px" height="17px" style="position:relative;top:-2" src="${ctx}/resource/img/setting.jpg"></a>
		</span>
		<br/>
	</div>
</div>

<#-- 用户设置按钮 -->
<div id="userMenuList" class="easyui-menu" style="width:180px;display:none">   
    <div data-options="iconCls:'icon-save'" onclick="userInfo()">个人信息</div>   
    <div data-options="iconCls:'icon-edit'">   
        <span>修改信息</span>
        <div style="width:150px;">
            <div data-options="iconCls:'icon-edit'" onclick="modifyPwd()" >修改密码</div>
        </div>
    </div>
    <div class="menu-sep"></div>
    <div data-options="iconCls:'icon-no'" onclick="userLogout()">退出系统</div>
</div>

<script>
	<#-- 绑定用户个人信息菜单事件 -->
	$("#userMenu").bind("click", function(event) {
		event = event ? event : window.event;
		$('#userMenuList').menu('show', {
		 	left: event.pageX,
			top: event.pageY + 20,
			hideOnUnhover: false,
		});  
	})
	
	<#-- 个人信息 -->
	function userInfo(){
		$.createSimpleWindowAutoScroll("accout","个人信息", 600, 400, "${ctx}/accout?operation=read");
	}
	
	<#-- 修改密码 -->
	function modifyPwd(){
		$.createSimpleWindowAutoScroll("accout","修改密码", 650, 280, "${ctx}/accout?operation=edit");
	}
	
	<#-- 用户注销 -->
	function userLogout(){
		top.$.messager.confirm("提示","是否确认退出?", function(confirm){
			if(confirm){
				 <#-- 确认退出 -->
				 $.defaultAjaxOperation("${ctx}/logout", null, true, true, 
					 {
						 success: function (result){
						 	top.location = "${ctx}/login";
						 }
					 }
				 );
			 }
		 })
	}
</script>