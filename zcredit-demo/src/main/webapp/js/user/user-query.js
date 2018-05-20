$(function(){
	
	$('#user-list').datagrid({
		fit: true,
		fitColumns: true,
		method:"get",
		url:"http://127.0.0.1:8080/zcredit-demo/user?method=queryUser",
		sortName: 'id',
		loadMsg : '数据正在加载,请耐心的等待...',
		toolbar: [{
			text: '添加',
			iconCls: 'fa fa-plus',
			handler: function() {}
		}, {
			text: '编辑',
			iconCls: 'fa fa-edit',
			handler: function() {}
		}, {
			text: '保存',
			iconCls: 'fa fa-save',
			handler: function() {}
		},{
			text: '删除',
			iconCls: 'fa fa-remove',
			handler: function() {}
		}],

		height: 400,
		columns: [
			[{
				field: 'id',
				title: 'id',
				width: 100,
				sortable: true
			}, {
				field: 'loginname',
				title: 'loginname',
				width: 100,
				sortable: true
			}, {
				field: 'name',
				title: 'name',
				width: 100,
				align: 'right',
			}]
		]
	});
	
	$("#submitBtn").on('click',function(){
		//$("#user-select-form").form('submit');
		//alert($('input[name=id]').val());
		//alert($('input[name=loginname]').val());
		$('#user-list').datagrid('load',{
			id : $('input[name=id]').val(),
			loginname : $('input[name=loginname]').val()
		
		});
	
	});
	
	
});