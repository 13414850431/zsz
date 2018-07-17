<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/header.jsp" %>

<title>查看图片</title>
</head>
<body>
<div class="pd-20">
  <form action="" method="post" class="form form-horizontal" id="form-role-add">
    <div class="row cl">
	    <div class="row c1">
	      <label class="form-label col-4">身份证号码：</label>
	      <div class="formControls col-4">
	      	<label class="form-label">${merchant.idCardNum }</label>
	      </div>
        </div>
       
	    <div  class="row c1" style="align:center">
	      <img  src="${merchant.bossIdCardPicUrl}">
	    </div>
	     <div   class="row c1" style="align:center">
	      <img  src="${merchant.businessLicenseUrl}">
	    </div>
    </div>    
    
    
  </form>
</div>
</body>
</html>