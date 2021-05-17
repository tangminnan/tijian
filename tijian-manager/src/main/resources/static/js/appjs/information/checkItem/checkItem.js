
var prefix = "/information/checkItem"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						singleSelect : false, // 设置为true将禁止多选
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
                        detailView: true,
                        initialState: 'expanded',
                        showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset
							};
						},
						columns : [
								{
									checkbox : true
								},
																{
									field : 'id', 
									title : 'id' 
								},
																{
									field : 'parentItem', 
									title : '项目名称' 
								},
																{
									field : 'price', 
									title : '价格' 
								},
																{
									field : 'addTime', 
									title : '添加时间' 
								},

																{
									field : 'pin', 
									title : '拼音' 
								},
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
                                        var e='<button type="button" class="btn  btn-xs btn-success" onclick="edit(\''+row.id+'\',\''+row.userid+'\')">编辑</button>  ';
                                        return e ;
									}
								} ]
						,
                        onExpandRow: function (index, row, $detail) {
                            var last = JSON.stringify(row);
                            onclick = row.id;
                            var parentId = row.id;
                            var prjLogBookProblemTable = $detail.html('<table></table>').find('table');
                            $(prjLogBookProblemTable).bootstrapTable({
                                columns: [
                                    {
                                        checkbox : true
                                    },
                                    {
                                        field : 'id',
                                        title : 'id'
                                    },
                                    {
                                        field : 'childrenItem',
                                        title : '细项名称'
                                    },

                                    {
                                        field : 'addTime',
                                        title : '添加时间'
                                    },
                                    {
                                        title: '操作',
                                        field: 'id',
                                        align: 'center',
                                        formatter: function (value, row, index) {
                                            var e = '<button type="button" class="btn  btn-xs btn-success" onclick="editSub(\'' + row.id + '\',\'' + row.userid + '\')">编辑</button>  ';
                                            var d = '<button type="button" class="btn  btn-xs btn-default" onclick="removeSub(\'' + row.id + '\',\'' + row.userid + '\')">删除</button>  ';
                                            return e + d;
                                        }
                                    }
                                ],
                                url: prefix + "/listSub",
                                method: 'get',
                                queryParams : function(params) {
                                    return {
                                    	parentId: parentId
                                    };
                                },
                                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                                onLoadError: function () {  //加载失败时执行
                                    alert('失败')
                                },
                            })
                        }
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
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function removeSub(id){
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix+"/remove",
            type : "post",
            data : {
                'id' : id
            },
            success : function(r) {
                if (r.code==0) {
                    layer.msg(r.msg);
                    reLoad();
                }else{
                    layer.msg(r.msg);
                }
            }
        });
    })
}


function editSub(id){
    layer.open({
        type : 2,
        title : '编辑检查细项',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '270px' ],
        content : prefix + '/editSub/' + id // iframe的url
    });
}

