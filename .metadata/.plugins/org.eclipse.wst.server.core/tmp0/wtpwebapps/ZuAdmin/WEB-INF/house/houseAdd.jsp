<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="z" uri="http://www.zu.com/core" %>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/header.jsp" %>
<style type="text/css">
	  #tipDiv{
        border: solid 1px lightgray;
        background-color: #FFFFFF;
        z-index:99999
    }
    #tipDiv p{
        margin: 0;
    }
</style>
<script type="text/javascript">
$(function(){
	$("#regionId").change(function(){
		var regionId = $(this).val();	
		$.ajax({type:"post",url:"<%=ctxPath%>/House",
			data:{action:"loadCommunities",regionId:regionId},
			success:function(result){
				if(result.status!="ok")
				{
					layer.msg('加载小区错误'+result.msg,{icon:6,time:1000});
					return;
				}
				$("#communityId").empty();//清空以前生成的子元素
				for(var i=0;i<result.data.length;i++)
				{
					var item = result.data[i];
					$("<option value='"+item.id+"'>"+item.name+"</option>").appendTo($("#communityId"));
				}
			},
			error:function(){
				layer.msg("加载小区网络通讯错误",{icon:6,time:1000});
			}
		});
	});
	
	
});
</script>
<script type="text/javascript">
var datas = new Array();
var localPoints = new Array();
var tipDiv;
var searchBox;
var itemIndex = -1;
var oldValue;
var selectLocation;
var locations ;

window.onload = function(){
    tipDiv = document.getElementById("tipDiv");
    searchBox = document.getElementById("address");
    selectLocation = document.getElementById("selectLocation");
    
    searchBox.onkeyup = function(){
    	
    	
        if(event.keyCode==40||event.keyCode==38){
              if(event.keyCode==40){
                  itemIndex++;
              }else{
                  itemIndex--;
              }if(itemIndex>datas.length){
                  itemIndex=-1;
              }if(itemIndex<-1){
                  itemIndex = datas.length-1;
              }
              selectItem(itemIndex);

        }else{
              oldValue = searchBox.value;
              showItem();
        }
		var address = $("#address").val();
		var cityName1 = "${cityName}";
		
        //keyup的时候就发送一次ajax请求
        if(event.keyCode==32){
	        $.ajax({
	        	type:"get",
	        	url:"http://restapi.amap.com/v3/assistant/inputtips?key=4419e12c11fecf797ad9e437dd323a66&keywords="+address+"&city="+cityName1+"&citylimit=true&output=JSON",
	        	success:function(result){
	        		if(result.status==1){
	        			//alert(result.tips);
	        			for(var i =0;i<result.tips.length;i++){
	        				//district 指省+市+区（直辖市为“市+区”） 
	        				//name指tip的名称
	        				//location为坐标
	        				//alert(result.tips[i].district+result.tips[i].name)
	        				//alert()
	        				datas[i] = result.tips[i].district+result.tips[i].name;
	        				localPoints[i] = result.tips[i].location;
	        			}
	        			
	        			showItem();
	        		}else{
	        			
	        			layer.msg("地址提示网络通讯错误"+result.info,{icon:6,time:1000});
	        		}
	        	},error:function(){
	        		layer.msg("地址提示错误",{icon:6,time:1000});
	        	}
	        			
	        });
       }

    }
    searchBox.onblur = function(){
          tipDiv.style.display = "none";
          
    }
    
}






function selectItem(itemIndex){
	
    var divs = tipDiv.getElementsByTagName("div");
    var items = new Array() ;
    for(var i = 0;i<divs.length;i++){
    	items[i] = divs.item(i).getElementsByTagName("p").item(0);
    }
    
    for(var i =0;i<datas.length;i++){
        items[i].style.backgroundColor = null;
    }
    if(itemIndex>-1&&itemIndex<datas.length){
        items[itemIndex].style.backgroundColor="lightgray";
        searchBox.value = items[itemIndex].innerHTML;
       
    }else{
        searchBox.value = oldValue;
    }
}
function mouseShow(div){
	var Ps = div.getElementsByTagName("p");
	var p = Ps.item(0);
	var p1 = Ps.item(1);
    p.onmouseover = function(){
        if(p.style.backgroundColor!="lightgray"){
            p.style.backgroundColor="lightgray";
        }
        searchBox.value = p.innerHTML;
        selectLocation.value = p1.innerHTML;
    }




       p.onmouseout = function(){
           p.style.backgroundColor= null;
       }


}
function showItem(){
    tipDiv.style.display = "block";
    tipDiv.innerHTML = "";
    tipDiv.style.width = searchBox.offsetWidth+"px";
    for(var i=0;i<datas.length;i++){
        var data = datas[i];
        var localPoint = localPoints[i];
        var div = document.createElement("div");
        var p1 = document.createElement("p");
        p1.style.display = "none";
        var p = document.createElement("p");	//新建一个<div><p>地址</p><p>坐标</p></div>
        p.innerHTML = data;	
        p1.innerHTML = localPoint;
        div.appendChild(p);
        div.appendChild(p1);
        tipDiv.appendChild(div);
        mouseShow(div);
    }
}
</script>
<title>添加房源</title>
</head>
<body>
<div class="pd-20">
  <form action="" method="post" class="form form-horizontal" id="form-add">
  	<input type="hidden" id="" name="typeId" value="${typeId }"/>
  	<input type="hidden" name="action" value="addSubmit"/>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>区域：</label>
      <div class="formControls col-2">
       	  <z:select items="${regions }" name="regionId" textName="name" valueName="id" id="regionId"/>
      </div>
      <label class="form-label col-2"><span class="c-red">*</span>小区：</label>
      <div class="formControls col-2">
        <select id="communityId" name="communityId"></select>
      </div>
      <label class="form-label col-2"><span class="c-red">*</span>房型：</label>
      <div class="formControls col-2">
        <z:select items="${roomTypes }" name="roomTypeId" textName="name" valueName="id" id="roomTypeId"/>
      </div>  
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>地址：</label>
      
      <div class="formControls col-6">
        <input type="text" class="input-text" value="" placeholder="这里输入几号楼，几单元，哪个房间" id="address" name="address" datatype="*" nullmsg="地址必填" >
      	 <div id="tipDiv" style="display: none"></div>
      </div>
     
      <label class="form-label col-2"><span class="c-red">*</span>月租：</label>
      <div class="formControls col-2">
        <input type="text" class="input-text" value="" placeholder="" id="monthRent" name="monthRent" datatype="n" nullmsg="月租不能为空">
      </div>
    </div>    
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>状态：</label>
      <div class="formControls col-2">
        <z:select items="${statuses }" name="statusId" textName="name" valueName="id" id="statusId"/>
      </div>
      <label class="form-label col-2"><span class="c-red">*</span>面积：</label>
      <div class="formControls col-2">
        <input type="text" class="input-text" value="" placeholder="" id="area" name="area" datatype="n" nullmsg="面积不能为空">
      </div>
      <label class="form-label col-2"><span class="c-red">*</span>装修：</label>
      <div class="formControls col-2">
        <z:select items="${decorateStatus }" name="decorateStatusId" textName="name" valueName="id" id="decorateStatusId"/>
      </div>  
    </div>    
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>楼层：</label>
      <div class="formControls col-1">
        <input type="text" class="input-text" value="" placeholder="第几层" id="floorIndex" name="floorIndex" datatype="n" nullmsg="层数不能为空">
      </div>
      <div class="formControls col-1">
        <input type="text" class="input-text" value="" placeholder="总层数" id="totalFloorCount" name="totalFloorCount" datatype="n" nullmsg="总层数不能为空">
      </div>      
      <label class="form-label col-2"><span class="c-red">*</span>朝向：</label>
      <div class="formControls col-2">
        <input type="text" class="input-text" value="" placeholder="" id="direction" name="direction" datatype="*" nullmsg="朝向不能为空">
      </div>
      <label class="form-label col-2"><span class="c-red">*</span>可看房时间：</label>
      <div class="formControls col-2">
        <input type="text" class="input-text" value="" placeholder="" onfocus="WdatePicker({minDate: '${now}'})" id="lookableDateTime" name="lookableDateTime"  nullmsg="可看房时间不能为空">
      </div>  
    </div>   
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>入住时间：</label>
      <div class="formControls col-2">
        <input type="text" class="input-text" value="" onfocus="WdatePicker({minDate: '${now}'})" placeholder="" id="checkInDateTime" name="checkInDateTime" nullmsg="手机号不能为空">
      </div>
      <label class="form-label col-2"><span class="c-red">*</span>业主姓名：</label>
      <div class="formControls col-2">
        <input type="text" class="input-text" value="" placeholder="" id="ownerName" name="ownerName" datatype="*" nullmsg="业主姓名不能为空">
      </div>
      <label class="form-label col-2"><span class="c-red">*</span>业主电话：</label>
      <div class="formControls col-2">
        <input type="text" class="input-text" value="" placeholder="" id="ownerPhoneNum" name="ownerPhoneNum" datatype="m" nullmsg="业主电话不能为空">
      </div>  
    </div>  
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>房源描述：</label>
      <div class="formControls col-10">
        <textarea class="input-text" style="height: 100px" id="description" name="description"></textarea>
      </div>
    </div>  
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>配套设施：</label>
      <div class="formControls col-10">
        <c:forEach items="${attachments }" var="att">
        	<z:checkbox label="${att.name }" name="attachmentId" value="${att.id }" id="attachmentId-${att.id }"/>
        </c:forEach>
      </div>
    </div>               
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="button" id="btnSave" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
      </div>
      <input type="text" style="display: none" name="selectLocation" id = "selectLocation"/>
    </div>
  </form>
</div>


<script type="text/javascript">
$(function(){

	//必须放到页面初始化的时候，不能放到按钮点击里面
	var validForm = $("#form-add").Validform({tiptype:2});//初始化校验器
	$("#btnSave").click(function(){
		if(validForm.check(false)==false)//表单校验不通过
		{
			return;
		}
		
		var data = $("#form-add").serializeArray();//<input type="hidden" name="action" value="addSubmit"/>
		$.ajax({
			url:"<%=ctxPath%>/House",type:"post",
			data:data,
			success:function(result){
				if(result.status=="ok")
				{
					parent.location.reload();//刷新父窗口
				}
				else
				{
					alert("保存失败"+result.msg);
				}
			},
			error:function(){alert("保存网络请求失败");}
		});
	});
});
</script>
</body>
</html>