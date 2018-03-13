$(function(){
	
	// 左侧导航分类选中样式
	$("#navlist ul").on('click', 'li', function() {
		
		$(this).siblings().removeClass('selected');
		$(this).addClass('selected');

		//新增一个选项卡
		var tabUrl = $(this).attr('data-url');
		var tabTitle = $(this).text();
		//tab是否存在
		if($("#tabs").tabs('exists', tabTitle)) {
			$("#tabs").tabs('select', tabTitle);
		} else {
			var content = '<iframe scrolling="auto" frameborder="0"  src="' + tabUrl + '" style="width:100%;height:99%;"></iframe>';
			$('#tabs').tabs('add', {
				title: tabTitle,
				//content: content,
				href: tabUrl,
				closable: true
			});
		}
	});	
	
});