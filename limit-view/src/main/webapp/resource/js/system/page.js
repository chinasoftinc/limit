/**
 * 全局分页函数
 * @author niebinxiao
 */
function pageBar() {
	$pageDiv = $(".page_bar");

	if ($pageDiv.length == 0)
		return;

	var pager = {};

	pager.totalPage = parseInt($pageDiv.attr("totalPage"));
	pager.currentPage = parseInt($pageDiv.attr("currentPage"));
	
	var pagebar = "";
	
	// 共多少页
	pagebar += "共 " + pager.totalPage + " 页 |";
	
	// 上一页
	if(pager.currentPage != 1){
		pagebar += " <input type='button' style='color:blue' onclick='gotoPage(" + (pager.currentPage - 1) + ")' value='上一页'></input>";
	}else{
		pagebar += " <input type='button' disabled='true' value='上一页'></input>";
	}
	
	
	if(pager.totalPage <= 5){
		// 显示全部页
		for (var int = 1; int <= pager.totalPage; int++) {
			if(int == pager.currentPage){
				pagebar += "<input type='button' disabled='true' value='" + int + "'></input>&nbsp;";
			}else{
				pagebar += "<input type='button' style='color:blue' onclick='gotoPage(" + int + ")' value='" + int + "'></input>&nbsp;";
			}
		}
	}
	if(pager.totalPage >= 6){
		if((pager.totalPage - pager.currentPage) >= 4){
			// 显示当前页向左4页, 若当前页不足4页, 向右借相应的页数
			var nearCenterPage = pager.currentPage > 3 ? pager.currentPage : 4;
			
			for (var int = nearCenterPage - 3; int <= nearCenterPage; int++) {
				if(int == pager.currentPage){
					pagebar += "<input type='button' disabled='true' value='" + int + "'></input>&nbsp;";
				}else{
					pagebar += "<input type='button' style='color:blue' onclick='gotoPage(" + int + ")' value='" + int + "'></input>&nbsp;";
				}
			}
			// 显示省略号, 点击是nearCenterPage的下三页
			pagebar += "<input type='button' style='color:blue' onclick='gotoPage(" + (nearCenterPage + 3) + ")' value='...'></input>&nbsp;"
			
			// 显示最后一页
			pagebar += "<input type='button' style='color:blue' onclick='gotoPage(" + pager.totalPage + ")' value='" + pager.totalPage + "'></input>&nbsp;";
		}else{
			// 如果是最后4页了, 显示最后4页
			var nearCenterPage = pager.totalPage - 3;

			// 让省略号在前, 点击先前跳三页
			pagebar += "<input type='button' style='color:blue' onclick='gotoPage(" + (nearCenterPage - 3) + ")' value='...'></input>&nbsp;"
			
			// 最后保留4页, 包括currentPage
			for (var int = nearCenterPage; int <= pager.totalPage; int++) {
				if(int == pager.currentPage){
					pagebar += "<input type='button' disabled='true' value='" + int + "'></input>&nbsp;";
				}else{
					pagebar += "<input type='button' style='color:blue' onclick='gotoPage(" + int + ")' value='" + int + "'></input>&nbsp;";
				}
			}
			
		}
	}
	
	// 下一页
	if(pager.currentPage != pager.totalPage){
		pagebar += " <input type='button' style='color:blue' onclick='gotoPage(" + (pager.currentPage + 1) + ")' value='下一页'></input>";
	}else{
		pagebar += " <input type='button' disabled='true' value='下一页'></input>";
	}
	
	$pageDiv.html(pagebar);
}

/*
 * 使用方法: 
 * 	1. 在需要显示分页条的地方定义一个div, class: page_bar
 *  2. 在div中定义属性: totalPage(总页数), currentPage(当前页数)
 *  3. 使用gotoPage函数, 该函数用于请求指定的页数
 */

