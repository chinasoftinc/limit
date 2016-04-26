<@PAGE.HTML title="操作成功提示">
<div class="submitdata" style="width:100%; height:80%;padding-top:20px">
<table width="100%" border="0"  cellspacing="0" cellpadding="0">
	<tr><td>&nbsp;</td></tr>
	<tr style="text-align:center">
		<#-- 操作成功 -->
		<#if optRs == "false">
		<td height="30px" colspan="2" style="overflow:auto;font-size:12px;color: #fff;background: #B22400">
			<b>操 作 失 败</b>
		</td>
		<#else>
		<td height="30px" colspan="2" style="overflow:auto;font-size:12px;color: #fff;background: #008E00">
			<b>操 作 成 功</b>
		</td>
		</#if>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr style="text-align:center">
		<td height="30px" colspan="2" style="overflow:auto;font-size:12px;color: #B22400;">&nbsp;${errorMsg}</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr style="text-align:center">
		<td height="22px" colspan="2">
			<a href="###" class="easyui-linkbutton" onclick="$.completeOperation('${parentWinId}','${winId}');" iconCls="icon-cancel">关闭</a></th>
		</td>
	</tr>
</table>
</div>
</@PAGE.HTML>