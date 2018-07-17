<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/header.jsp" %>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<title>商家列表</title>
</head>
<body class="pos-r">
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="40"><input name="" type="checkbox" value=""></th>
					<th width="40">ID</th>
					<th width="60">缩略图</th>
					<th width="100">店铺名</th>
					<th>描述</th>
					<th width="100">店主名</th>
					<th width="60">发布状态</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${merchants}" var="merchant">
					<tr class="text-c va-m">
						<td><input name="" type="checkbox" value=""></td>
						<td>${merchant.id}</td>
						<td><a onClick="product_show('哥本哈根橡木地板','product-show.html','10001')" href="javascript:;"></a>
						<c:if test="${empty merchant.merchantPicUrl}">
							<img width="60" class="product-thumb" src="http://oucyspkau.bkt.clouddn.com/timg.gif">
						</c:if>
						<c:if test="${not empty merchant.merchantPicUrl}">
							<td><a><img width="60" class="product-thumb" src="${merchant.merchantPicUrl}"></a></td>
						</c:if>
						<td class="text-l">${merchant.name}</td>
						<td class="text-l">${merchant.description}</td>
						<td>${merchant.bossName}</td>
						<td class="td-status">
							<span class="label label-danger radius">已下架</span>
						</td>
						<td class="td-manage">
							<a style="text-decoration:none" onClick="merchant_restart(this,'${merchant.id}')" href="javascript:;" title="重新上架">
								<i class="Hui-iconfont">&#xe603;</i>
							</a> 
							<a style="text-decoration:none" class="ml-5" onClick="merchant_del(this,'${merchant.id}')" href="javascript:;" title="删除">
								<i class="Hui-iconfont">&#xe6e2;</i>
							</a> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
<script type="text/javascript">
var code;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}

/*商品-重新上架*/
function merchant_restart(obj,id){
	layer.confirm('确认要重新上架吗？',function(index){
		$.ajax({
			type:"post",
			url:"<%=ctxPath%>/Merchant?action=restartMer",
			data:{"id":id},
			success:function(result){
				if(result.status=='ok'){
					$(obj).parents("tr").remove();
					layer.msg('已重新发布!',{icon: 6,time:1000});
				}else{
					alert("上架失败"+result.message);
				}
			},error:function(){
				alert("网络通讯出错，请联系管理员");
			}
			
		});
		
	});
}

function merchant_del(obj,id){
	layer.confirm('确认要删除商家吗？',function(index){
		$.ajax({
			type:"post",
			url:"<%=ctxPath%>/Merchant?action=delMer",
			data:{"id":id},
			success:function(result){
				if(result.status=='ok'){
					$(obj).parents("tr").remove();
					layer.msg('已重新发布!',{icon: 6,time:1000});
				}else{
					alert("上架失败"+result.message);
				}
			},
			error:function(){
				alert("网络通讯出错，请联系管理员");
			}
		});
	});
}

$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  {"orderable":false,"aTargets":[0,7]}// 制定列不参与排序
	]
});
</script>
</body>
</html>