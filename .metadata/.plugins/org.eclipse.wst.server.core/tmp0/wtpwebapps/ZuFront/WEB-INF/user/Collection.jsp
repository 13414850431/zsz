<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <title>我的收藏</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
	<script type="text/javascript">
		$(window).load(function(){
			$(".loading").addClass("loader-chanage")
			$(".loading").fadeOut(300)
		})
	</script>
</head>
<!--loading页开始-->
<div class="loading">
	<div class="loader">
        <div class="loader-inner pacman">
          <div></div>
          <div></div>
          <div></div>
          <div></div>
          <div></div>
        </div>
	</div>
</div>
<!--loading页结束-->
	<body>
		<div class="headertwo clearfloat" id="header">
			<a href="javascript:history.go(-1)" class="fl box-s"><i class="iconfont icon-arrow-l fl"></i></a>
			<p class="fl">我的收藏</p>
		</div>
		
		<div class="clearfloat" id="main">
			<div class="recom clearfloat collection">
		    	<div class="content clearfloat box-s">
		    		<div class="list clearfloat fl box-s">
		    			<a href="house-details.html">
			    			<div class="tu clearfloat">
			    				<span></span>
			    				<img src="upload/list-tu.jpg"/>
			    			</div>
			    			<div class="right clearfloat">
			    				<div class="tit clearfloat">
			    					<p class="fl">华府骏苑</p>
			    					<i class="fr iconfont icon-delete delete"></i>
			    				</div>
			    				<p class="recom-jianjie">三室一厅一卫   |  125m²  |  普装</p>
			    				<div class="recom-bottom clearfloat">
			    					2500<samp>元/月</samp>
			    				</div>
			    			</div>
		    			</a>
		    		</div>
		    		<div class="list clearfloat fl box-s">
		    			<a href="house-details.html">
			    			<div class="tu clearfloat">
			    				<span></span>
			    				<img src="upload/list-tu.jpg"/>
			    			</div>
			    			<div class="right clearfloat">
			    				<div class="tit clearfloat">
			    					<p class="fl">华府骏苑</p>
			    					<i class="fr iconfont icon-delete delete"></i>
			    				</div>
			    				<p class="recom-jianjie">三室一厅一卫   |  125m²  |  普装</p>
			    				<div class="recom-bottom clearfloat">
			    					2500<samp>元/月</samp>
			    				</div>
			    			</div>
		    			</a>
		    		</div>
		    		<div class="list clearfloat fl box-s">
		    			<a href="house-details.html">
			    			<div class="tu clearfloat">
			    				<span></span>
			    				<img src="upload/list-tu.jpg"/>
			    			</div>
			    			<div class="right clearfloat">
			    				<div class="tit clearfloat">
			    					<p class="fl">华府骏苑</p>
			    					<i class="fr iconfont icon-delete delete"></i>
			    				</div>
			    				<p class="recom-jianjie">三室一厅一卫   |  125m²  |  普装</p>
			    				<div class="recom-bottom clearfloat">
			    					2500<samp>元/月</samp>
			    				</div>
			    			</div>
		    			</a>
		    		</div>
		    	</div>
		    </div>
		</div>
	</body>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
	<script src="js/fastclick.js"></script>
	<script src="js/mui.min.js"></script>
	<script type="text/javascript" src="js/hmt.js" ></script>
</html>
