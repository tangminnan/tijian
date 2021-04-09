
var prefix = "/information/checkHistory"
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
                                userId:$("#userId").val()
					           // name:$('#searchName').val(),
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
									checkbox : true
								},
																{
									field : 'id', 
									title : 'id' 
								},
																{
									field : 'name',
									title : '用户名'
								},

									{
										field : 'totalAmount',
										title : '金额总计'
									},
                            {
                                field : 'yingfuAmount',
                                title : '实际制度金额'
                            },
																{
									field : 'addTime', 
									title : '检查时间' 
								},
																{
									field : 'singleChecks',
									title : '检查项目',
                                                                    formatter : function(value, row, index) {
                                                                        if(value.includes("SHENGAOTIZHONG")) value.replace("SHENGAOTIZHONG","身高体重");
                                                                        if(value.includes("XUEYA")) value=value.replace("XUEYA","血压");
                                                                        if(value.includes("OUBAO")) value=value.replace("OUBAO","欧宝检查");
                                                                        if(value.includes("OCT"))   value=value.replace("OCT","OCT检查");
                                                                        if(value.includes("YANYA")) value=value.replace("YANYA","眼压检查");
                                                                        return value;
                                                                    }
								},
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {

                                        var e= '<button type="button" class="btn btn-xs btn-primary"  onclick="lookreport(\''+row.id+'\',\''+row.userId+'\')">查看报告</button>';
										var d= '<button type="button" class="btn btn-xs btn-primary"  onclick="lookreport(\''+row.id+'\',\''+row.userId+'\')">打印报告</button>';
										return  e+d ;

									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}



function resetPwd(id) {
}

function lookreport(id,userId){
	console.log("查看报告");
	 window.open("/information/checkHistory/lookReportAtBrowser/"+id+"/"+userId);

     // var print = new EasyPrint({url:["/information/checkHistory/lookReportAtBrowser/"+id+"/"+userId,"https://dm-em03.obs.cn-north-4.myhuaweicloud.com:443/zhenjiu%2FheadUrl%2F6f2a3803-080d-4874-ae41-8547bc7d95ea.jpg"]});
     // print.start();

}
