<@PAGE.HTML title="操作成功提示">
<div class="submitdata" style="width:100%; height:100%">
<table width="100%" border="0"  cellspacing="0" cellpadding="0" >
	<tr><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td></tr>
	<tr style="text-align:center">
		<td height="30px" colspan="2" style="overflow:auto;font-size:12px;color: #fff;background: #008E00">
			<b>操 作 成 功</b>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td></tr>
	<tr style="text-align:center">
		<td height="22px">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$.reloadData('${parentWinId}');window.location.href=document.referrer" iconCls="icon-back">继续添加</a></th>&nbsp;
			<a href="###" class="easyui-linkbutton" onclick="$.completeOperation('${parentWinId}','${winId}');" iconCls="icon-no">关闭</a></th>
		</td>
	</tr>
</table>
</div>
</@PAGE.HTML>