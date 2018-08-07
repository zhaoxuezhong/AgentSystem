var contactcount=0;
$().ready(function() {
	mover(1);
	contactcount=$("#contactcount").val();
	
	if(error!=null&&error!=""&&error!=undefined){
		humane.error(error);
	}
	
	$("#customprovince").change(function(){
		//初始化
		$("#customcity").empty();
		$("#customcity").append("<option value='' selected='selected'>--请选择--</option>");
		$("#customarea").empty();
		$("#customarea").append("<option value='' selected='selected'>--请选择--</option>");
		
		var s_province=$("#customprovince").val();
		//ajax请求,按省份获取相应城市列表
		$.post(path+"agent/customs/loadcity.json",{"provinceId":s_province},function(result){
			//result cityList
			if(result!=""){
				for(var i=0;i<result.cityList.length;i++)
					$("#customcity").append("<option value='"+result.cityList[i].cityId+"'>"+result.cityList[i].city+"</option>");			
			}
			else{
				
				humane.error("城市加载失败");
			}
		},'json');
		
	});
	
	
	var province=$("#customprovince").val();
	var city=$("#city").val();
	var area=$("#area").val();
	if(province!=""&&city!=""){
		
		$.post(path+"agent/customs/loadcity.json",{"provinceId":province},function(result){
			//result cityList
			if(result!=""){
				for(var i=0;i<result.cityList.length;i++)
					$("#customcity").append("<option value='"+result.cityList[i].cityId+"'>"+result.cityList[i].city+"</option>");				
				$("#customcity").val(city);//回显
			}
			else{
				
				humane.error("城市加载失败");
			}
		},'json');
	}
	
	if(province!=""&&city!=""&&area!="")
	{		
		$.post(path+"agent/customs/loadarea.json",{"cityId":city},function(result){
			//result areaList
			if(result!=""){
				for(var i=0;i<result.areaList.length;i++)
					$("#customarea").append("<option value='"+result.areaList[i].areaId+"'>"+result.areaList[i].area+"</option>");
				$("#customarea").val(area);//区域回显
			}
			else{
				
				humane.error("区域加载失败");
			}
		},'json');
	}
	
	//城市和区域联动
	$("#customcity").change(function(){
		$("#customarea").empty();
		$("#customarea").append("<option value='' selected='selected'>--请选择--</option>");		
		var s_city=$("#customcity").val();
		//ajax请求,按城市获取相应的区
		$.post(path+"agent/customs/loadarea.json",{"cityId":s_city},function(result){
			//result areaList
			if(result!=""){
				for(var i=0;i<result.areaList.length;i++)
					$("#customarea").append("<option value='"+result.areaList[i].areaId+"'>"+result.areaList[i].area+"</option>");			
			}
			else{
				
				humane.error("区域加载失败");
			}
		},'json');
	});
	
	//初始化customtypename
	$("#customtype").change(function(){
		$("#customtypename").val($("#customtype option:selected").text());		
	});
	//初始化customcardtypename
	$("#customcardtype").change(function(){
		$("#customcardtypename").val($("#customcardtype option:selected").text());		
	});
	
	//添加联系人
	$("#addcontact").click(function(){
		var str="<tr><td><input type='text' name='contactList["+contactcount+"].contactName'></td>" +
				"<td><input type='text' name='contactList["+contactcount+"].contactTel'></td>" +
				"<td><input type='text' name='contactList["+contactcount+"].contactFax'></td>" +
				"<td><input type='text' name='contactList["+contactcount+"].contactEmail'></td>" +
				"<td><input type='text' name='contactList["+contactcount+"].contactRole'></td>" +
				"<td  onclick='delTr(this)'><a href='javascript:void();'>删除</a></td></tr>";
		$("#addtr").append(str);
		contactcount++;
	});
	
	//验证证件号码数字
	$("#cardnum").blur(function(){
		var t=$("#cardnum").val();
		if(!checkValidateNum(t))
			humane.error("证件号码请输入数字!");
	})
});

function checkValidateNum(value){
	
	var reg=new RegExp("^[0-9]*$");
	if(reg.test(value))
		return true;
	else 
		return false;
}
function delTr(obj){
	$(obj).parent().remove();
	contactcount--;
}
//验证,提交
function checksave(){
	var customname=$.trim($("#customname").val());
	var customtypename=$("#customtypename").val();
	var customcardtype=$("#customcardtype").val();
	if(customname.length==0)
	{
		humane.error("客户名称不能空");
		return ;
	}
	if(customtypename.length==0){
		humane.error("客户类型不能为空");
		return ;		
	}
/*	var t=$("#cardnum").val();
	if(!checkValidateNum(t))
		humane.error("证件号码请输入数字!");
	
	*/
	$("#cform").submit();
		
}

