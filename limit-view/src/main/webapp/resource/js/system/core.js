/**
 * 添加tab面板
 * @param title 面板标题
 * @param url 指定打开的URL
 */
$.addTab = function(winId, title, url, tabBar) {
	var content = "<iframe frameborder='0' scrolling='no' name='" + winId + "_iframe' id='" + winId + "_iframe' style='width:100%;height:100%;' src='" + url + "'></iframe>"
	if ($("#" + tabBar).tabs("exists", title)) {
		$("#" + tabBar).tabs("select", title);
	} else {
		$("#" + tabBar).tabs('add', {
			title : title,
			fit : true,
			border : false,
			content : content,
			closable : true
		});
	}
}

/**
 * 说明: 创建一个新的弹出窗口
 * @author NieBinxiao
 * @param winId 窗口ID
 * @param title 窗口标题
 * @param width 窗口宽度
 * @param height 窗口高度
 * @param href URL
 */
$.createSimpleWindowAutoScroll = function(winId, title, width, height, href) {
	parentWinId = window.name; // 当前创建者的窗口
	var root = $.getRootWindow(); // 获取根窗口
	// 是否存在窗口
	if (root.$("#" + winId).length == 0) {
		root.$("#topWindow").append("<div id='" + winId + "'></div>");
	}
	href = href.indexOf("?") != -1 ? href + "&parentWinId=" + parentWinId + "&winId=" + winId : href + "?parentWinId=" + parentWinId + "&winId=" + winId;

	root.$("#" + winId).window({
		title : title,
		width : width,
		height : height,
		modal : true,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		resizable: false,
		content : "<iframe id='" + winId + "_iframe' frameborder=0 scrolling='auto' name='" + winId + "_iframe' id='" + winId + "_iframe' style='width:100%;height:100%;' src='" + href + "'></iframe>",
		onClose : function(){
			$(this).html("");
		}
	});
	root.$("#" + winId).window('open');
};

/**
 * 关闭窗口
 * @param windId 窗口ID
 */
$.closeWindow = function(winId) {
	var root = $.getRootWindow(); // 获取根窗口
	root.$("#" + winId).window("close", true);
};

/**
 * 获取根窗口
 */
$.getRootWindow = function() {
	var root = window;
	while (root != root.parent) {
		root = root.parent;
	}
	return root;
}

/**
 * 创建一个iframe窗口
 * @param iframeId
 * @param href
 */
$.createIframeWindow = function(iframeId, href) {
	return "<iframe id='" + iframeId + "_iframe' frameborder=0 scrolling='auto' name='" + iframeId + "_iframe' id='" + iframeId + "_iframe' style='width:100%;height:100%;' src='" + href + "'></iframe>";
}

/**
 * 刷新窗口数据操作
 * @param winId 窗口Id
 */
$.reloadData = function(winIframeId) {
	var win = $.getRootWindow().$("#" + winIframeId)[0].contentWindow;

	// 处理树状数据列表
	var $gridTable = win.$(".datagrid-view").find("table:hidden");
	if ($gridTable.length != 0) {
		$gridTable.each(function(index, gridTable) {
			try {
				var id = $(gridTable).attr("id");
				win.$("#" + id).treegrid("reload"); // treeGrid关闭
			} catch (e) {
				win.$("#" + id).datagrid("reload"); // dataGrid关闭
			}
		});
	} else if (false) {
		// TODO 其他类型的处理
	} else {
		win.location.reload();
	}
}

/**
 * 操作完成刷新父窗口数据, 并关闭当前窗口
 * @param parentWinId 父窗口Id
 * @param winId 窗口Id
 */
$.completeOperation = function(parentWinId, winId) {
	if(parentWinId != null && parentWinId != "" && parentWinId != undefined){
		$.reloadData(parentWinId); // 刷新父窗口
	}
	
	$.closeWindow(winId);
}

/**
 * 自定义Ajax交互操作, 只完成请求, 接收并显示返回的提示信息,[ 是否显示进度条, 是否异步, 成功,失败,异常,执行回调函数]
 * @param url 请求url
 * @param params 请求参数
 * @param isProgress 是否显示进度条
 * @param isAsync 是否异步
 * @param fns 回调函数
 */
$.defaultAjaxOperation = function(url, params, isAsync, isProgress, fns) {

	// 封装回调函数
	var funtions = $.extend({
		success : null, // 成功回调
		error : null, // 失败回调
		exception : null
	// 异常回调
	}, fns || {});

	// 进度条开启处理
	if (isProgress) {
		top.$.messager.progress();
	}

	// 执行请求
	$.ajax({
		url : url,
		type : 'post',
		dataType : 'json',
		async : isAsync,
		data : params,

		// 请求成功处理
		success : function(NULL, success, jqXHR) {

			// 进度条关闭处理
			if (isProgress) {
				top.$.messager.progress("close");
			}

			var result = eval("(" + jqXHR.responseText + ")"); // 返回结果json对象

			if (result) {
				// 成功回调
				if (funtions.success != null) {
					funtions.success(result);
				}
			} else {
				// 失败回调
				if (funtions.error != null) {
					funtions.error.call();
				}
			}
		},

		// 请求异常处理
		error : function() {
			if (isProgress) {
				parent.$.messager.progress("close");
			}
			top.$.messager.alert("警告", "系统出现未知错误, 请立即联系系统管理人员", "error");
			if (funtions.exception != null) {
				funtions.exception.call();
			}
		}
	});
};

/**
 * 全局定时窗口提示消息
 * @param title 窗口标题
 * @param message 消息
 * @param width 宽度
 * @param height 高度
 * @param time 显示时间[毫秒]
 */
$.timeOutMsgTip = function(title, message, width, height, time) {
	width = width == null ? 200 : width;
	height = height == null ? 150 : height;
	time = time == null ? 2500 : time;

	top.$.messager.show({
		title : title,
		msg : message,
		showType : 'slide',
		width : width,
		height : height,
		timeout : time
	});
}

/**
 * 全局提示消息窗口
 * @param title 窗口标题
 * @param msg 提示消息
 */
$.msgTip = function(title, msg) {
	top.$.messager.alert(title, msg);
}

/**
 * 全局错误消息窗口
 * @param title 窗口标题
 * @param msg 提示消息
 */
$.errorTip = function(title, msg) {
	top.$.messager.alert(title, msg, "error");
}


/**
 * 鼠标右键点击事件
 * @param $node jQuery对象 事件源
 * @param call 回调函数 [时间对象, 目标对象]
 */
$.mouseRightClick = function($node, call) {
	$node.bind("contextmenu", function(event) {
		event = event ? event : window.event; // 解决微软兼容性
		var target = event.target ? event.target : event.srcElement; // 事件目标 [右键的目标]

		// 回调函数
		if (undefined != call && null != call) {
			call(event, target);
		}

		event.preventDefault(); // 解决其他浏览器冒泡
		try {
			event.stopPropagation(); // 阻止事件冒泡
		} catch (e) {
			event.cancleBubble = true; // IE8以下阻止事件冒泡
		}
	})
	
};

/**
 * 说明: 获取的当前时间显示
 * @author NieBinxiao
 */
$.nowtime = function() {
	var date = new Date();
	return date.getFullYear() + "-" + ((date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : (date.getMonth() + 1)) + "-" + (date.getDate() < 10 ? ("0" + date.getDate()) : date.getDate()) + "  " + (date.getHours() < 10 ? ("0" + date.getHours()) : date.getHours()) + ":" + (date.getMinutes() < 10 ? ("0" + date.getMinutes()) : date.getMinutes()) + ":" + (date.getSeconds() < 10 ? ("0" + date.getSeconds()) : date.getSeconds());
};


/**
 *  图片出错全局函数
 * @param img
 */
function errorImage(img) {
	$(img).attr("src", "../../resource/img/no_img.jpg");
}

/**
 * 日期格式化
 */
Date.prototype.format = function (format) {
    // eg:format="yyyy-MM-dd hh:mm:ss";
    var o = {
        "M+": this.getMonth() + 1, // month
        "d+": this.getDate(), // day
        "h+": this.getHours(), // hour
        "m+": this.getMinutes(), // minute
        "s+": this.getSeconds(), // second
        "q+": Math.floor((this.getMonth() + 3) / 3), // quarter
        "S": this.getMilliseconds()
        // millisecond
    }

    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4
            - RegExp.$1.length));
    }

    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1
                ? o[k]
                : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
}