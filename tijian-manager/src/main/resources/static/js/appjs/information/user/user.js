
var prefix = "/information/user"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
                                identityCard:$('#identityCard').val(),
					           // username:$('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
																{
									field : 'id', 
									title : 'id' 
								},
																{
									field : 'name', 
									title : '姓名'
								},
																{
									field : 'identityCard', 
									title : '身份证号' 
								},
								// 								{
								// 	field : 'addTime',
								// 	title : '添加时间'
								// },
																{
									field : 'sex', 
									title : '性别',
                                                                    formatter : function(value, row, index) {
																		if(value==1) return "男";
																		if(value==2) return "女";
																	}
								},
																{
									field : 'birthday', 
									title : '出生年月' 
								},
																{
									field : 'phone', 
									title : '手机号' 
								},
																{
									field : 'age', 
									title : '年龄' 
								},
																{
									field : 'nation', 
									title : '民族' 
								},
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {

                                        var e='<button type="button" class="btn  btn-xs btn-success" onclick="edit(\''+row.id+'\')">编辑</button>  ';
                                        var f='<button type="button" class="btn  btn-xs btn-success" onclick="erweima(\''+row.id+'\')">条形码</button>  ';
                                        var d= '<button type="button" class="btn btn-xs btn-primary"  onclick="chatijilu(\''+row.id+'\')">查体记录</button>';
										return e + f+d ;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}

function resetPwd(id) {
}

function chatijilu(id){
	window.location.href="/information/checkHistory/"+id;
}

/**
 *  二维码查看
 */

function erweima(id) {
    layer.open({
        type : 2,
        title : '条形码',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '450px', '520px' ],
        content : "/information/user/erweima/"+id
    });
}
