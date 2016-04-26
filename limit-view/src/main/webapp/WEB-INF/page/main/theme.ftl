<@PAGE.HTML title="个性化" js=["resource/plugin/jscolor/jscolor"]>
<body style="margin:5px;">
<div style="width: 100%;height:100%;">
	
	<div class="easyui-accordion">   
	    <div title="背景色" data-options="selected:true" style="overflow:auto;padding:10px;">   
        	<div>
				<#list wallpapers as wallpaper>
				<div style="float:left;margin:5px;border:1px solid #ccc">
					<img onclick="cgWallpaper(this.src)" style="width:60px;height:50px" src="${ctx}/resource/img/wallpaper/${wallpaper.getName()}"></img>
				</div>
				</#list>
			</div>
	    </div>   
	    <div title="按钮" style="padding:10px;" >   
	        	按钮背景颜色: <input id="mzj_manage_theme_button_bg" class="color" value="66ff00" onChange="cgButtonBg(this.value)">
	        	按钮文字颜色: <input id="mzj_manage_theme_button_color" class="color" value="66ff00" onChange="cgButtonColor(this.value)">
	    </div>
	     <div title="菜单" style="padding:10px;" >
	        	菜单文字颜色: <input id="mzj_manage_theme_menu_color" class="color" value="66ff00" onChange="cgMenuColor(this.value)">
	    </div>
	</div>  
	
	
</div>
<script>
	<#-- 初始化选项值 -->
	$(function(){
		$(".color").each(function(Index, node){
			$(node).val($.cookie($(node).attr("id")));
		});
	})

	<#-- 切换背景 -->
	function cgWallpaper(src){
		$.cookie('mzj_manage_theme_wallpaper', "url('" + src + "')", { expires: 365, path: '/' });
		top.$(".win_body").css("background","url('" + src + "')");
	}
	
	<#-- 切换按钮背景 -->
	function cgButtonBg(code){
		$.cookie('mzj_manage_theme_button_bg', "#" + code, { expires: 365, path: '/' });
		top.$(".easyui-linkbutton").css("background","#" + code);
	}
	
	<#-- 切换按钮文字颜色 -->
	function cgButtonColor(code){
		$.cookie('mzj_manage_theme_button_color', "#" + code, { expires: 365, path: '/' });
		top.$(".easyui-linkbutton").css("color","#" + code);
	}
	
	<#-- 切换菜单颜色 -->
	function cgMenuColor(code){
		$.cookie('mzj_manage_theme_menu_color', "#" + code, { expires: 365, path: '/' });
		top.$("#left").find(".panel-with-icon").css("color","#" + code).end().parent().prev().find(".panel-with-icon").css("color","#" + code);
	}
</script>
</body>
</@PAGE.HTML>