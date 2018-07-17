<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@include file="/WEB-INF/header.jsp" %>
	 <title>首页</title>
	 <script type="text/javascript">
	
	 $(function(){
		 var cityName;
		 $.ajax({
				url:"http://restapi.amap.com/v3/ip?key=4419e12c11fecf797ad9e437dd323a66&output=JSON",
				type:"GET",
				success:function(result){
					if(result.status==1){
						cityName = result.city;
						//拿到这个城市的名称，然后传到服务器中
						
						$.ajax({type:"post",url:"<%=ctxPath%>/Index",
						 	data:{action:"queryCurrentCity",localCityName:cityName},
						 	success:function(city){
						 		if(city.status=="ok")
					 			{
					 				$("#cityName").text(city.data);
					 			}
					 			else
					 			{
					 				alert(city.msg);
					 			}
						 	},
						 	error:function(){
						 		alert("获取当前城市网络请求失败");
						 	}
						 });
					}else{
						layer.msg("城市定位失败"+result.info,{icon:6,time:1000});
					}
				},
				error:function(){
					layer.msg("城市定位失败"+result.info,{icon:6,time:1000});
				}
			});
		 
		 $("#btnChangeCity").click(function(){
			 var left = $(this).offset().left;
			 var top = $(this).offset().top;
			 var height = $(this).height();
			 var width = $(this).width();
			 $("#citiesList").toggle("fast").css("left",left).css("top",top+height);
		 });
		 
		 $("#citiesList li").click(function(){
			 var cityId = $(this).attr("cityId");
			 $.ajax({
				 type:"post",url:"<%=ctxPath%>/Index",
				 data:{action:"changeCity",cityId:cityId},
				 success:function(result)
				 {
					 if(result.status=="ok")
					 {
					 	location.reload();//刷新页面
					 }
					 else
					 {
					 	alert(result.msg);
					 }
				 },
				 error:function()
				 {
					 alert("切换城市网络请求失败");
				 }
			 });
			 
		 });
		 
		 $("#txtSearch").keydown(function(e){
			 if(e.keyCode==13)//按了回车
			 {
			 	location.href="<%=ctxPath%>/House?action=search&keywords="+encodeURI($(this).val());
			 }
			 
		 });
	 });
	 </script>
</head>
<%@include file="/WEB-INF/loading.jsp" %>

	<body>
	<div style="display:none;position:absolute;z-index: 300;background-color: white;cursor: pointer;" id="citiesList">
		<ul>
		<c:forEach items="${cities}" var="city">
			<li cityId="${city.id }">${city.name }</li>
		</c:forEach>
		</ul>
	</div>
	
		<!--header star-->
		<div class="header clearfloat">
			<div class="tu clearfloat">
				<img src="img/index-banner.jpg"/>
			</div>
			<header class="mui-bar mui-bar-nav">
				<a class="btn" href="#" id="btnChangeCity">		            
		            <p><b id='cityName'>北京</b><i class="iconfont icon-iconfontarrowdown-copy"></i></p>
		        </a>
		        <div class="top-sch-box flex-col">
		            <div class="centerflex">
		                <i class="fdj iconfont icon-sousuo"></i>
		                <div class="sch-txt">请输入您要搜索的内容</div>
		            </div>
		        </div>
		    </header>
		    <div class="header-tit clearfloat">
		    	<p class="header-num">掌上租已为<span>${houseAppTotalCount}</span>用户成功租房！</p>
		    	<p class="header-da">轻松租房  乐享生活</p>
		    </div>
		</div>
		<!--header end-->
		<div id="main" class="mui-clearfix">
		 	<!-- 搜索层 -->
		    <div class="pop-schwrap">
		        <div class="ui-scrollview">
		        	<div class="poo-mui clearfloat box-s">
		        		<div class="mui-bar mui-bar-nav clone poo-muitwo">
			                <div class="top-sch-box flex-col">
			                    <div class="centerflex">
			                    	<i class="fdj iconfont icon-sousuo"></i>
			                        <input class="sch-input mui-input-clear" type="text" name="" id="txtSearch" placeholder="请输入您要搜索的内容" />
			                    </div>
			                </div>			                
			            </div>
			            <a href="javascript:;" class="mui-btn mui-btn-primary btn-back" href="#">取消</a>
		        	</div>		            
		            <div class="scroll-wrap">
		                <div class="mui-scroll">
		                    <div class="sch-cont">
		                        <div class="section ui-border-b">
		                            <div class="tit">热门搜索</div>
		                            <div class="tags">
		                                <span class="tag">短租</span><span class="tag">大溪地</span><span class="tag">停车场</span>
		                                <span class="tag">三房一厅</span><span class="tag">合租</span><span class="tag">经济房</span>
		                                <span class="tag">写字楼</span><span class="tag">转户</span><span class="tag">整租</span>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
		    
		    <div class="cation clearfloat">
		    	<ul class="clearfloat">
		    		<li>
		    			<a href="<%=ctxPath %>/House?action=search&typeId=14">
			    			<img src="img/fang.png" />
			    			<p>整租</p>
		    			</a>
		    		</li>
		    		<li>
		    			<a href="<%=ctxPath %>/House?action=search&typeId=13">
			    			<img src="img/chuang.png" />
			    			<p>合租</p>
		    			</a>
		    		</li>
		    		<li>
		    			<a href="<%=ctxPath %>/House?action=search&typeId=11">
			    			<img src="img/bao.png" />
			    			<p>短租</p>
		    			</a>
		    		</li>
		    		<li>
		    			<a href="<%=ctxPath %>/House?action=search&typeId=12">
			    			<img src="img/lou.png" />
			    			<p>写字楼</p>
		    			</a>
		    		</li>
		    		<li>
		    			<a href="map.html">
			    			<img src="img/map.png" />
			    			<p>地图找房</p>
		    			</a>
		    		</li>
		    		<li>
		    			<a href="landlord.html">
			    			<img src="img/people.png" />
			    			<p>我是房东</p>
		    			</a>
		    		</li>
		    		<li>
		    			<a href="<%=ctxPath%>/Merchant?action=Apply">
			    			<img src="img/woshou.png" />
			    			<p>加盟</p>
		    			</a>
		    		</li>
		    		<li>
		    			<a href="<%=ctxPath%>/Merchant?action=LifeService">
			    			<img src="img/self.png" />
			    			<p>生活服务</p>
		    			</a>
		    		</li>
		    	</ul>
		    </div>
		    
		    <div class="recom clearfloat">
		    	<div class="recom-tit clearfloat box-s">
		    		<p>热门房源推荐</p>
		    	</div>
		    	<c:forEach items="${recommHouses}" var = "item">
			    	<div class="content clearfloat box-s">
			    		<div class="list clearfloat fl box-s">
			    			<a href="<%=ctxPath%>/House?action=view&id=${item.id}">
				    			<div class="tu clearfloat">
				    				<span></span>
				    				<img src="${item.firstThumbUrl}"/>
				    			</div>
				    			<div class="right clearfloat">
				    				<div class="tit clearfloat">
				    					<p class="fl">${item.communityName}</p>
				    					<span class="fr">${item.monthRent}<samp>元/月</samp></span>
				    				</div>
				    				<p class="recom-jianjie">${item.roomTypeName}   |  ${item.area}m²  |  ${item.decorateStatusName}</p>
				    				<div class="recom-bottom clearfloat">
				    					<span><i class="iconfont icon-duihao"></i>随时住</span>
				    					<span><i class="iconfont icon-duihao"></i>家电齐全</span>
				    				</div>
				    			</div>
			    			</a>
			    		</div>
			    	</div>
		    	</c:forEach>
		    </div>
	   </div>
	   
	   <footer class="page-footer fixed-footer" id="footer">
			<ul>
				<li class="active">
					<a href="<%=ctxPath%>/Index?action=index">
						<i class="iconfont icon-shouyev1"></i>
						<p>首页</p>
					</a>
				</li>
				<li>
					<a href="<%=ctxPath%>/Index?action=lease">
						<i class="iconfont icon-chuzuwo"></i>
						<p>我要出租</p>
					</a>
				</li>
				<li>
					<a href="<%=ctxPath%>/Index?action=schedule">
						<i class="iconfont icon-richengbiao"></i>
						<p>看房日程</p>
					</a>
				</li>
				<li>
					<a href="<%=ctxPath%>/User?action=center">
						<i class="iconfont icon-gerenzhongxin"></i>
						<p>个人中心</p>
					</a>
				</li>
			</ul>
		</footer>
	</body>
	<script src="js/fastclick.js"></script>
	<script src="js/mui.min.js"></script>
	<script type="text/javascript" src="js/hmt.js" ></script>
	<!--插件-->
	<link rel="stylesheet" href="css/swiper.min.css">
	<script src="js/swiper.jquery.min.js"></script>
	<!--插件-->

	<!--搜索点击效果-->
	<script >
	    $(function () {
	        var banner = new Swiper('.banner',{
	            autoplay: 5000,
	            pagination : '.swiper-pagination',
	            paginationClickable: true,
	            lazyLoading : true,
	            loop:true
	        });
	
	         mui('.pop-schwrap .sch-input').input();
	        var deceleration = mui.os.ios?0.003:0.0009;
	         mui('.pop-schwrap .scroll-wrap').scroll({
	                bounce: true,
	                indicators: true,
	                deceleration:deceleration
	        });
	        $('.top-sch-box .fdj,.top-sch-box .sch-txt,.pop-schwrap .btn-back').on('click',function () {
	            $('html,body').toggleClass('holding');
	            $('.pop-schwrap').toggleClass('on');
	            if($('.pop-schwrap').hasClass('on')) {;
	                $('.pop-schwrap .sch-input').focus();
	            }
	        });
	
	        $.ajax({
	        
	        });
	    });
	</script>
</html>
