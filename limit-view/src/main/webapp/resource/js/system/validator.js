/**
 * 通用验证方法
 * 
 * @description
 * @attribute required 布尔 定义文本域是否为必填项 false
 * @attribute validType 字符串 定义字段的验证类型，比如email, url, etc. null
 * @attribute missingMessage 字符串 当文本框为空时提示的文本信息 This field is required.
 * @attribute invalidMessage 字符串 当文本框内容不合法时提示的文本信息 null
 */

/**
 * 自定义验证插件
 */
$.extend($.fn.validatebox.defaults.rules, {
	/**
	 * @description 远程验证
	 * @param [0] url
	 * @param [1] value
	 * @param [2] 错误消息
	 */
	Remoto : {
		validator : function(value, param) {
			var flag = false;
			var paramJson = eval("({'" + param[1] + "':'" + value + "'})");
			$.ajax({
				url : param[0],
				type : 'post',
				dataType : 'json',
				async : false,
				data : paramJson,
				success : function(NULL, success, jqXHR) {
					var result = eval("(" + jqXHR.responseText + ")");
					$.fn.validatebox.defaults.rules.Remoto.message = param[2]; // 替换消息
					flag = (result == true);
				}
			});
			return flag;
		},
		message : "远程验证失败"
	},

	/**
	 * 正则验证
	 * @param [0] 正则
	 * @param [1] 错误消息
	 */
	Pattern : {
		validator : function(value, param) {
			var regx = eval("(/" + param[0] + "/)");
			$.fn.validatebox.defaults.rules.Pattern.message = param[1]; // 替换消息
			return regx.test(value);
		},
		message : "不匹配正则"
	},

	/**
	 * 确认输入验证 [保证两个input值相同]
	 * @param [0] 目标input #ID
	 * @param [1] 错误消息
	 */
	Equals : {
		validator : function(value, param) {
			var targetValue = $(param[0]).val();
			$.fn.validatebox.defaults.rules.Equals.message = param[1]; // 替换消息
			return value == targetValue;
		},
		message : "值不相同"
	},
	
	/**
	 * 确认值不为空 [trim方式]
	 * @param[0] 错误消息
	 */
	Trims : {
		validator : function(value, param) {
			$.fn.validatebox.defaults.rules.Trims.message = param[0]; // 替换消息
			return Validator.isRequired(value);
		},
		message : "不能为空"
	}
	
});

/**
<form id="form" onsubmit="return $(this).form('validate')">

	<#--邮箱示例-->
		<input class="easyui-validatebox" 
			data-options=required:true,validType:["email","length[5,30]"],missingMessage:"输入邮箱地址",invalidMessage:"输入正确的邮箱地址" />
	<#--注册用户名示例-->
		<input class="easyui-validatebox"
			data-options=required:true,validType:["Pattern['^[A-Za-z0-9\u4E00-\u9600]{5,20}$','用户名不合法,请输入5-20位英文或数字']","Remoto['${ctx}/validate/remoto','username','用户名已被注册']"],missingMessage:"输入5-20位英文或数字作为用户名" />
	<#--日期示例-->
		<input type="text" class="easyui-validatebox" data-options=required:true,missingMessage:"输入出生日期" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})"/>
	<#--下拉示例-->
		<select class="easyui-validatebox" data-options=required:true missingMessage:"选择性别">
			<option value="">选择性别</option> <#--开头的让value为"", 验证才会起作用-->
			<option value="1">雄</option>
			<option value="2">雌</option>
		</select>
	
		<button type="submit">确定</button>
</form>
*/

/**
 * 说明: 验证项
 * @author NieBinxiao
 */
var Validator = {
	isRequired : function(string) {
		if (string != null && $.trim(string) != "")
			return true;
		return false;
	},

	isEmail : function(string) {
		return new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$").test(string);
	},

	isPhone : function(string) {
		return new RegExp("^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$").test(string);
	},

	isMobile : function(string) {
		return new RegExp("^1[0-9]{10}$").test(string);
	},

	isURL : function(string) {
		return new RegExp("^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$").test(string);
	},

	isNumber : function(string) {
		return new RegExp("^\d+$").test(string);
	},

	isQQ : function(string) {
		return new RegExp("^[1-9]\d{4,8}$").test(string);
	},

	isInteger : function(string) {
		return new RegExp("^[-\+]?\d+$").test(string);
	},

	isDouble : function(string) {
		return new RegExp("^[-\+]?\d+(\.\d+)?$").test(string);
	},

	isEnglish : function(string) {
		return new RegExp("^[A-Za-z]+$").test(string);
	},

	isChinese : function(string) {
		return new RegExp("^[\u0391-\uFFE5]+$").test(string);
	},

	isUsernameOrPassword : function(string) {
		return new RegExp("^[A-Za-z0-9_\u4E00-\u9600]{5,20}$").test(string);
	},

	isRange : function(object, options) {
		var opts = $.extend({
			min : null,
			max : null
		}, options || {});
		object = parseFloat(object);
		if (object <= opts.max && object >= opts.min)
			return true;
		return false;
	},

	isEquals : function(src, target) {
		if (src == target)
			return true;
		return false;
	}
};
