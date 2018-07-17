<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<%@include file="/WEB-INF/header.jsp" %>
	<script src="<%=ctxPath%>/js/swfupload.js" type="text/javascript"></script>
    <script src="<%=ctxPath%>/js/handlers.js" type="text/javascript"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">    
    <meta name="keywords" content="">
    <meta name="description" content="">
	<script type="text/javascript">
		$(window).load(function(){
			$(".loading").addClass("loader-chanage")
			$(".loading").fadeOut(300)
			
			var swfu;
			
			swfu = new 	SWFUpload({
				//上传文件的路径
			    upload_url: "<%=ctxPath%>/Merchant/UploadFile",
			    flash_url : "<%=ctxPath%>/js/swfupload.swf",

			    post_params : {
			  
			    },
			    file_size_limit : "2 MB",
			    file_types : "*.jpg;*.bmp;*.jpg;*.jpeg;*.png;*.gif",
			    file_types_description : "JPG Images;bmp Images;jpg Images;jpeg Images;png Images;gif Images",
			    file_upload_limit : 0,
                upload_error_handler : uploadError,
                upload_success_handler : uploadSuccess,

                button_placeholder_id : "spanButtonPlaceholder",
                button_width: 160,
                button_height: 22,
                button_text : '<input type="button" name="uploadIDCard">上传文件<span class="buttonSmall">(2 MB Max)</span>',
                button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 14pt; } .buttonSmall { font-size: 10pt; }',
                button_text_top_padding: 1,
                button_text_left_padding: 5,

                

                // Debug Settings
                debug: false

	
			});
			//文件上传成功后,给用户提示信息
            function uploadSuccess(file, serverData) {
                var result = serverData.split('|');
                if (result[0] == 'ok') {
                    alert(result[1]);
                }
            }	
			
			//文件上传失败，给用户提示信息
			function uploadError(){
				var result = serverData.split('|');
                if (result[0] != 'ok') {
                    alert(result[1]);
                }
			}
			
		$("#btnSubmit").click(function(){
			var bossName = $("#bossName").val();
			var phone = $("#PhoneNum").val();
			var address = $("#address").val();
			var idCardNum =$("#idCardNum").val();
			var idCardPicUrl = $("#idCardPicUrl").files;
			var businessLicenseUrl = $("#businessLicenseUrl").val();
			
			//前端校验参数有效性
			//真实姓名不能为空且长度不能超过10
			if(bossName==""||bossName.length>=10){
				alert("请输入正确格式的真实姓名");
				//return ;
			}
			
			//手机号码格式校验
			var checkPhone = /^(((13[0-9]{1})|(15[0-9]{1})|17[0-9]{1}|(18[0-9]{1}))+\d{8})$/;
			
			if(!checkPhone.test(phone)){
				alert("请输入正确格式的手机号码");
				//return ;
			}
			
			var checkIdCard = /^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i;
			if(!checkIdCard.test(idCardNum)){
				alert("请输入正确格式的身份证");
				//return ;
			}
			
			var point = idCardPicUrl[0].name.lastIndexOf(".");
			var fileNameLen = idCardPicUrl[0].name.length;
			var suffix = idCardPicUrl[0].name.substring(point+1,fileNameLen);
			
			if(suffix!="jpg"&&suffix!="png"&&suffix!="ipeg"	){
				alert("请上传ipg或png类型且不超过2m的照片");
				return ;
			}
			alert(idCardPicUrl[0].name.size);
			
			alert(bossName+","+phone+","+address+","+idCardPicUrl+","+businessLicenseUrl);
			
		});
			
			
			
			
		})
	</script>
	    
    <title>加盟</title>
    

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
			<p class="fl">加盟</p>
		</div>
		
		<div class="clearfloat" id="main">
			<div class="recom-tit recom-titwo clearfloat box-s">
	    		<p>加盟政策</p>
	    	</div>
	    	<div class="join clearfloat box-s">
	    		<div class="top clearfloat box-s">
	    			<div class="tu">
	    				<img src="upload/3.jpg"/>
	    			</div>
	    			
	    			<p class="tit">经销商加盟</p>
	    			<p class="fu-tit">
	    				我们一直秉承顾客第一的核心价值观，以亲切、专业的服务给顾客带来优质
						的体验；公司自营业以来，已经有成熟的管理模式和经营模式，加盟可享受
						到公司的提供的宝贵资源，只要您有服务，有质量，我们便能确保每个
						加盟商都成为享受更好的平台！我们的加盟政策的制定我们经过了公司运营团队及
						行业专业人士的反复论证，并在实际操作过程中听取广大加盟商朋友的建议。
	    			</p>
	    		</div>
	    	</div>
	    	<div class="recom-tit recom-titwo clearfloat box-s">
	    		<p>在线加盟申请</p>
	    	</div>
	    	<form action="">
	    	<div class="land-ctent clearfloat">
				<ul>
					<li class="box-s clearfloat">
						<p class="tit fl">姓名</p>
						<div class="formControls">
							<input type="text" name="bossName" id="bossName" value="" placeholder="您的姓名" class="fl" />
						</div>
					</li>
					<li class="box-s clearfloat">
						<p class="tit fl">手机号</p>
						<div class="formControls">
							<input type="text" class="input-text" name="PhoneNum" id="PhoneNum" datatype="*" value="" placeholder="您的手机号码"  nullmsg="手机号码必填" errormsg="请输入正确的手机号码"	>
						</div>
					</li>
					<li class="box-s clearfloat">
						<p class="tit fl">身份证</p>
						<input type="text" name="idCardNum" id="idCardNum" value="" placeholder="您的身份证号码" class="fl" />
					</li>
					<li class="box-s clearfloat">
						<p class="tit fl">详细地址</p>
						<input type="text" name="address" id="address" value="" placeholder="市、区/县、街道" class="fl" />
					</li>
					<li class="box-s clearfloat">
						<p class="tit fl">身份证照片</p>
						<span id="spanButtonPlaceholder" ></span>
					</li>
					<li class="box-s clearfloat">
						<p class="tit tit2 fl">营业执照</p>
						<input type="file" name="businessLicenseUrl" id="businessLicenseUrl" value=""  class="easyui-filebox" style="buttonAlign:right" accept="image/png, image/jpeg, image/gif, image/jpg"/>
					</li>
				</ul>
				<a href="#loginmodal" id="modaltrigger">
					<input type="button" name="btnSubmit" id="btnSubmit" value="提交申请" class="btn" />
				</a>
			</div>
		</form>
			
		</div>
		
		<!--弹窗内容 star-->
	    <div id="loginmodal" class="box-s loginmodaltwo" style="display:none;">	    	
			<form id="loginform" name="loginform" method="post" action="">		
				<div class="center"><input type="submit" name="loginbtn" id="loginbtn" class="flatbtn-blutwo hidemodal" value="" tabindex="3"></div>
			</form>
			<div class="bottom clearfloat box-s">
				<div class="login-dui clearfloat">
					<p class="tu">
						<img src="img/dui.png"/>
					</p>
					<p class="tit">
						恭喜您，申请成功！
					</p>
					<p class="fu-tit">
						请保持所填号码手机的通话畅通状态，我们的客服将会在48小时内与您取得联系。
					</p>
				</div>
				<input type="button" name="" id="" value="好的，我知道了" class="btn btn1" />
			</div>
		</div>
	    <!--弹窗内容 end-->
	</body>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
	<script type="text/javascript" src="slick/slick.min.js" ></script>
	<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
	<script type="text/javascript" src="js/tchuang.js" ></script>
	<script type="text/javascript" src="js/hmt.js" ></script>
</html>
