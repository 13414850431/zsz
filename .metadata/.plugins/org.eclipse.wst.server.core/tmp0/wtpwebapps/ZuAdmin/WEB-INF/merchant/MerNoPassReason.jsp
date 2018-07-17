<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/header.jsp" %>

<title>下架原因</title>
</head>
<body>
<div class="pd-20">
  <form action="" method="post" class="form form-horizontal" id="form-role-add">
  	<input type="hidden" name="action" value="ReasonSubmit"/>
    <input type="hidden" name="merchantId" value="${merchantId}"/>
    <div class="row cl">
	      <label class="form-label col-3"><span class="c-red">*</span>原因：</label>
		      <div class="formControls col-5">
		      	<textarea class="textarea radius"  placeholder="说明下架原因" id="reason" name="reason"></textarea>
      		  </div>
	      
   		 </div>   
    </div>  

    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="button" id="btnSave" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>

<script type="text/javascript">
	$(function(){
		var validForm = $("#form-role-add").Validform({tiptype:2});//初始化校验器
		$("#btnSave").click(function(){
			if(validForm.check(false)==false){
				reutrn;
			}
			var data = $("#form-role-add").serializeArray();//表单序列化为json对象
			$.ajax({
				url:"<%=ctxPath%>/Merchant",type:"post",
				data:data,
				success:function(result){
					if(result.status=="ok"){
						parent.location.reload();//刷新父窗口
					}else{
						alert("保存失败:"+result.msg);
					}
					
				},error:function(){
					alert("保存网络请求失败");
				}
			});
			
		});
	});
</script>
</body>
</html>