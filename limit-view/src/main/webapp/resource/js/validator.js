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
