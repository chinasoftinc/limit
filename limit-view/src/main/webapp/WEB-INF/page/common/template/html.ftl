<#-- 将本页面设为freemarker自动加载: auto_import=/WEB-INF/page/normal/html.ftl as PAGE -->

<#-- HTML页面结构 -->
<#macro HTML title="" link=[] meta=[] css=[] js=[]>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<#-- HEAD开始 -->
	<head>
		<title>${title}</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
		<#-- 禁止缓存头(弃用) 
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="cache-control" content="no-store">
		<meta http-equiv="expires" content="0"> -->
		<#-- 客户端缓存时间设定 -->
		<meta http-equiv="Expires" content="${sys_dic.clientExpires()}">	
		<meta http-equiv="Cache-Control" content="private, max-age=${sys_dic.getParamValue("page.cache_time")}">	
		<#-- 其他声明参数 -->
		<#list meta as item>
			<meta http-equiv="${item?trim?split("@")[0]}" content="${item?trim?split("@")[1]}" />
		</#list>
		<#-- 其他引用资源 -->
		<#list link as item>
			${item}
		</#list>
		<#-- 资源文件开始 -->
		<script type="text/javascript" src="${ctx}/resource/plugin/jquery/jquery.js"></script>
		<script type="text/javascript" src="${ctx}/resource/plugin/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${ctx}/resource/plugin/easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${ctx}/resource/plugin/datepicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}/resource/js/system/core.js"></script>
		<script type="text/javascript" src="${ctx}/resource/js/system/validator.js"></script>
		<script type="text/javascript" src="${ctx}/resource/plugin/cookie/jquery.cookie.js"></script>
		<link id="theme" type="text/css" rel="stylesheet" href="${ctx}/resource/plugin/easyui/themes/metro/easyui.css">
		<link type="text/css" rel="stylesheet" href="${ctx}/resource/plugin/easyui/themes/icon.css">
		<link type="text/css" rel="stylesheet" href="${ctx}/resource/css/system/core.css">
		<link type="text/css" rel="stylesheet" href="${ctx}/resource/css/form/form.css">
		<#-- 引入JS -->
		<#list js as item>
			<script type="text/javascript" src="${ctx}/${item?trim}.js"></script>
		</#list>
		<#-- 引入CSS -->
		<#list css as item>
			<link type="text/css" rel="stylesheet" href="${ctx}/${item?trim}.css">
		</#list>
		<#-- 资源文件结束 -->
		<#-- 全局样式 -->
		<style>
			body{background:#fff}
			<#-- 菜单展开样式 -->
			/*.accordion .accordion-header-selected{
				background:#444;
			}*/
		</style> 
	</head>
	<#-- HEAD结束 -->

	<#-- 页面 -->
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

<#--
	1. ${.now}  -- 输出当前时间字符串
	2. ${"text.."[1..10]} --截取1-10位显示, 目前不健壮, 后期改善
	3. 遍历map
		<#assign model={"1":"聂宾潇","2":"刘德华"}>
		<#list model?keys as key>
			${model[key]}
		</#list>
		
	4. 导入spring的tag
		<#assign p=JspTaglibs["http://www.springframework.org/tags/form"] />
-->