<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/header.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<title>图片列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 图片管理 <span class="c-gray en">&gt;</span> 图片列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	
		
	
	<span class="r">共有数据：<strong>54</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="40"><input name="" type="checkbox" value=""></th>
					<th width="80">ID</th>
					<th width="80">类型</th>
					<th width="100">店主名字</th>
					<th>身份证号码</th>
					<th width="150">地址</th>
					<th width="80">联系电话</th>
					<th width="60">发布状态</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${merchants }" var="mer" >
					<tr class="text-c">
						<td><input name="" type="checkbox" value=""></td>
						<td>${mer.id}</td>
						<td>${mer.typeName }</td>
						<td>${mer.bossName }</td>
						<td>${mer.idCardNum}</td>
						<td>${mer.address}</td>
						<td>${mer.phoneNum}</td>
						<td>${mer.status}</td>
						
					    <td class="td-manage">
						    <a style="text-decoration:none" onClick="merchant_start(this,${mer.id})" href="javascript:;" title="发布">
							    <i class="Hui-iconfont">&#xe603;</i>
						    </a> 
						    <a style="text-decoration:none" class="ml-5" onClick="layer_show('查看商家申请','<%=ctxPath%>/Merchant?action=showMer&id=${mer.id}','700','700')" href="javascript:;" title="查看">
						    	<i class="Hui-iconfont">&#xe6df;</i>
						    </a> 
						    <a style="text-decoration:none" class="ml-5" onClick="layer_show('下架原因','<%=ctxPath%>/Merchant?action=stopMer&id=${mer.id}','700','700')" href="javascript:;" title="删除">
						    	<i class="Hui-iconfont">&#xe6e2;</i>
						    </a>
					    </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript">



/*图片-发布*/
function merchant_start(obj,id){
	
	
	$.ajax({
		url:"<%=ctxPath%>/Merchant",
		type:"post",
		data:{"action":"merchantPass","id":id},
		success:function(result){
			if(result.status=='ok'){
				$(obj).parents("tr").remove();
				layer.msg('已发布!',{icon: 6,time:1000});
				
			}
			else{
				layer.msg('发布失败!',{icon: 5,time:1000});
			}
		},error:function(){
			layer.msg('网络错误，请联系管理员!',{icon:xe69c,time:1000});
		}
		
	});
	
}
/*图片-申请上线*/
function picture_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}
/*图片-编辑*/
function picture_edit(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-删除*/
function picture_del(obj,id){
	alert("hello");
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type:"post",
			url:"<%=ctxPath%>/Merchant",
			data:{"action":"picDeleted","id":id},
			success:function(result){
				if(result.status=="ok"){
					
						$(obj).parents("tr").remove();	
					
					layer.msg('已删除!',{icon:1,time:1000});
				}
				else{
					layer.msg('删除失败!',{icon:5,time:1000});
				}
			},
			error:function(){
				layer.msg('删除网络错误!',{icon:5,time:1000});
			}
			
		});
	});
}
	
	
	
	

</script>
</body>
</html>