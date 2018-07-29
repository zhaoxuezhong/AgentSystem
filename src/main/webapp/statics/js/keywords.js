var customID = -1;
var customName = "";

$()
		.ready(
				function() {
					mover(1);

					$("#searchusertext").keyup(function() {

						loadCustoms();
					});
					$("#searchusertext").click(function() {

						loadCustoms();
					});

					$("#keyword")
							.blur(
									function() {

										var keyword = $("#keyword").val();
										var servicetype = $("#servicetype")
												.val();
										var years = $("#serviceyear").val();
										if (keyword == null
												|| keyword.length == 0)
											$("#keywordtip")
													.html(
															"<font color='red'>对不起,您申请的关键词不能为空.请重新填写</font>");
										else {
											$("#keywordtip")
													.html(
															"<font color='green'>正在验证关键词是否已被抢占</font>");
											$
													.post(
															"/valikey.action",
															{
																"keywords.keywords" : keyword
															},
															function(result) {
																if (result == "success") {
																	$(
																			"#keywordtip")
																			.html(
																					"<font color='green'>恭喜您 ["
																							+ keyword
																							+ "]可以被注册!</font>");
																} else
																	$(
																			"#keywordtip")
																			.html(
																					"<font color='red'>对不起,您申请的关键词"
																							+ keyword
																							+ "已被抢占</font>");
															}, 'html');
										}
									});

					$("#servicetype").change(function() {
						jisuan();
					});
					$("#serviceyear").change(function() {
						jisuan();
					});
					
					$("#submitkeyword").click(function(){
						var servicetype = $("#servicetype").val();
						var serviceyear = $("#serviceyear").val();
						if(customID<0)
							{
								humane.error("对不起,请选择客户");
								$("#searchusertext").focus();
							}else if($("#keyword").val()==''||$("#keyword").val().length<=0){
								
								$("#keywordtip").html("<font color='red'>对不起,您 申请的关键词不能为空!</font>");
								$("#keyword").focus();
							}else if (servicetype == "") {
								humane.error("请选择服务类型");
								$("#servicetype").focus();
							} else if (serviceyear == "") {
								humane.error("请选择服务年限");
								$("#serviceyear").focus();
							} else {
								$.post("/valikey.action",
										{
											"keywords.keywords" : $("#keyword").val()
										},
										function(result) {
											if (result == "success") {
												//验证成功可以提交
												$.post("/submitkeyword.action",{"p" : servicetype + "-" + serviceyear,
													"keywords.keywords":$("#keyword").val(),
													"keywords.customId":customID,"keywords.customName":customName},
														function(result){										
														if("exception"==result)
														{
															humane.error("对不起,您提交的关键词出现异常,请重试");											
														}else if("nomoney"==result){
															humane.error("对不起,您当前的余额不能支付本次申请,请充值后再进行重试");		
														}
														else{
															$.post("/account.action",{},function(result){
																
																if(result!="failed")													
																{
																	$("#accountspan").html(result);
																	humane.success("恭喜您 ,您 提交的关键词["+$("#keyword").val()+"]申请成功!");
																}
															},"html");
														}
													},"html");
											} else
												humane.error("对不起,您申请的关键词"+ $("#keyword").val()+ "已被抢占");
										}, 'html');
								
							}
					});

				});

// 根据选择的服务类型及服务年限自动计算价格
function jisuan() {

	var servicetype = $("#servicetype").val();
	var serviceyear = $("#serviceyear").val();
	if (servicetype == "") {
		humane.error("请选择服务类型");
		$("#servicetype").focus();
	} else if (serviceyear == "") {
		humane.error("请选择服务年限");
		$("#serviceyear").focus();
	} else {

		$.post("/jisuan.action", {
			"p" : servicetype + "-" + serviceyear
		}, function(result) {

			if (result == "exception") {
				humane.error("计算价格时出现异常,请重试 ");
			} else {
				$("#price").val(result);// result为返回金额
			}
		}, "html");
	}

}

// 加载当前代理商所有客户
function loadCustoms() {
	$.post("/searchcustom.action", {
		"custom.customName" : $("#searchusertext").val()
	}, function(result) {
		// result <-json
		var customList = "<ul>";
		for ( var i = 0; i < result.length; i++) {
			customList = customList + "<li onclick=\"confirmCustom('"
					+ result[i].id + "','" + result[i].customName
					+ "')\"><span>客户类型:" + result[i].customTypeName
					+ "</span><br>" + result[i].customName + "</li>";
		}
		customList += "</ul>";
		$("#serachresult").html(customList);
		$("#serachresult").slideDown();
	}, 'json');
}

function confirmCustom(id, name) {
	customID = id;
	customName = name;
	$("#searchusertext").val(name);
	$("#serachresult").hide();
	$("#customname").val(name);

}