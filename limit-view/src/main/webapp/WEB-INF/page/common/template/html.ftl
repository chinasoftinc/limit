<#macro HTML title="" link=[] meta=[] css=[] js=[]>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>${title}</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
		
		<#--
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="cache-control" content="no-store">
		<meta http-equiv="expires" content="0">
		-->
		
		<#list meta as item>
			<meta http-equiv="${item?trim?split("@")[0]}" content="${item?trim?split("@")[1]}" />
		</#list>
		
		<#list link as item>
			${item}
		</#list>
		
		<script type="text/javascript" src="${ctx}/resource/plugin/jquery/jquery.js"></script>
		<script type="text/javascript" src="${ctx}/resource/plugin/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${ctx}/resource/plugin/easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${ctx}/resource/plugin/datepicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}/resource/js/system/core.js"></script>
		<script type="text/javascript" src="${ctx}/resource/js/system/validator.js"></script>
		<script type="text/javascript" src="${ctx}/resource/plugin/cookie/jquery.cookie.js"></script>
		<link id="theme" type="text/css" rel="stylesheet" href="${ctx}/resource/plugin/easyui/themes/black/easyui.css">
		<link type="text/css" rel="stylesheet" href="${ctx}/resource/plugin/easyui/themes/icon.css">
		<link type="text/css" rel="stylesheet" href="${ctx}/resource/css/system/core.css">
		<link type="text/css" rel="stylesheet" href="${ctx}/resource/css/form/form.css">

		<#list js as item>
			<script type="text/javascript" src="${ctx}/${item?trim}.js"></script>
		</#list>

		<#list css as item>
			<link type="text/css" rel="stylesheet" href="${ctx}/${item?trim}.css">
		</#list>

		<style>
			body{background:#fff}
			/*.accordion .accordion-header-selected{
				background:#444;
			}*/
		</style> 
	</head>

	<#nested/>
</html>
</#macro>

<#-- 截取指定长度字符串, 并补齐指定内容, 少于的不截取, 用于显示 -->
<#macro SUB text="" length=10 suffix="...">
	<#if text?length gt length>
		${text[0..length]}${suffix}
		<#else>
		${text}
	</#if>
</#macro>

<#macro SELECT datas optKey optVal selected="" id="" name="" disabled="false" class="" style="" data_option="">
	<select <#if id != "">id="${id}"</#if> <#if name != "">name="${name}"</#if> <#if class != "">class="${class}"</#if> <#if disabled != "false">disabled="disabled"</#if>  <#if style != "">style="${style}"</#if> <#if data_option != "">data-options=${data_option}</#if> >
		<option></option>
		<#if datas?size gt 0>
			<#list datas as item>
				<#if item[optKey] == selected>
					<option selected="selected" id="${item[optKey]}" value="${item[optKey]}">${item[optVal]}</option>
				<#else>
					<option id="${item[optKey]}" value="${item[optKey]}">${item[optVal]}</option>
				</#if>
			</#list>
		</#if>
	</select>
</#macro>
