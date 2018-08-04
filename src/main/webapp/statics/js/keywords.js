var customID = -1;
var customName = "";

$().ready(
	function() {
		mover(1);
		$("#searchusertext").keyup(function() {
			loadCustoms();
		});
		$("#searchusertext").click(function() {
			loadCustoms();
		});
		$("#keyword").blur(
			function() {
				var keyword = $("#keyword").val();
				var servicetype = $("#servicetype")
					.val();
				var years = $("#serviceyear").val();
				if (keyword == null || keyword.length == 0)
					$("#keywordtip").html(
						"<font color='red'>对不起,您申请的关键词不能为空.请重新填写</font>");else {
					$("#keywordtip").html(
						"<font color='green'>正在验证关键词是否已被抢占</font>");
					$.post(
						path + "agent/keyword/valikey",
						{
							"keywords" : keyword
						},
						function(result) {
							if (result == "success") {
								$("#keywordtip")
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

		$("#submitkeyword").click(function() {
			var servicetype = $("#servicetype").val();
			var serviceyear = $("#serviceyear").val();
			var price = parseInt($("#servicetype option:selected").attr("data-price"));
			var youhui=$("#serviceyear option:selected").attr("data-youhui");
			var serviceyear;
			var data;
			if(youhui=='true'){
				serviceyear=$("#serviceyear").val().split('-')[0];
				data=$("#serviceyear").val().split('-')[1];
			}
			if (customID < 0) {
				humane.error("对不起,请选择客户");
				$("#searchusertext").focus();
			} else if ($("#keyword").val() == '' || $("#keyword").val().length <= 0) {

				$("#keywordtip").html("<font color='red'>对不起,您 申请的关键词不能为空!</font>");
				$("#keyword").focus();
			} else if (servicetype == "") {
				humane.error("请选择服务类型");
				$("#servicetype").focus();
			} else if (serviceyear == "") {
				humane.error("请选择服务年限");
				$("#serviceyear").focus();
			} else if(price>parseInt($("#accountspan").attr("data-money"))){
				humane.error("对不起,您当前的余额不能支付本次申请,请充值后再进行重试");
			}else {
				$.post(path + "agent/keyword/valikey",
					{
						"keywords" : $("#keyword").val()
					},
					function(result) {
						if (result == "success") {
							var keywords=new Object();
							keywords.price=price;
							keywords.serviceYears=serviceyear;
							keywords.keywords = $("#keyword").val();
							keywords.customId = customID;
							keywords.customName = customName;
							keywords.productType=servicetype;
							//验证成功可以提交
							$.post(path + "agent/keyword/submitkeyword", {
								'keywords':JSON.stringify(keywords),
								'data' : data==undefined||data==null||data==""?0:data
							}, function(result) {
								if ("exception" == result) {
									humane.error("对不起,您提交的关键词出现异常,请重试");
								}else {
									/*$.post(path+"agent/account/account", {}, function(result) {
										if (result != "failed") {
											$("#accountspan").html(result);
											humane.success("恭喜您 ,您 提交的关键词[" + $("#keyword").val() + "]申请成功!");
										}
									}, "html");*/
									$("#accountspan").html(result);
									humane.success("恭喜您 ,您 提交的关键词[" + $("#keyword").val() + "]申请成功!");
								}
							}, "html");
						} else
							humane.error("对不起,您申请的关键词" + $("#keyword").val() + "已被抢占");
					}, 'html');
			}
		});
	});

// 根据选择的服务类型及服务年限自动计算价格
function jisuan() {
	var servicetype = $("#servicetype").val();
	var youhui=$("#serviceyear option:selected").attr("data-youhui");
	var serviceyear;
	if(youhui=='true'){
		serviceyear=$("#serviceyear").val().split('-')[0];
	}
	else{
		serviceyear=$("#serviceyear").val()
	}
	var price = $("#servicetype option:selected").attr("data-price");
	if (servicetype == "" || price == "") {
		humane.error("请选择服务类型");
		$("#servicetype").focus();
	} else if (serviceyear == "") {
		humane.error("请选择服务年限");
		$("#serviceyear").focus();
	} else {
		$("#price").val(price * serviceyear);
		/*$.post(path+"agent/keyword/jisuan", {
			"p" : servicetype + "-" + serviceyear
		}, function(result) {
			if (result == "exception") {
				humane.error("计算价格时出现异常,请重试 ");
			} else {
				$("#price").val(result); // result为返回金额
			}
		}, "html");*/
	}
}

// 加载当前代理商所有客户
function loadCustoms() {
	if ($("#searchusertext").val() == "" || $("#searchusertext").val() == null) {
		return false;
	}
	$.post(path + "agent/customs/searchcustom.json", {
		"customName" : $("#searchusertext").val()
	}, function(result) {
		// result <-json
		if (result != "" && result != null && result.customList != null) {
			var customList = "<ul>";
			for (var i = 0; i < result.customList.length; i++) {
				customList = customList + "<li onclick=\"confirmCustom('"
					+ result.customList[i].id + "','" + result.customList[i].customName
					+ "')\"><span>客户类型:" + result.customList[i].customTypeName
					+ "</span><br>" + result.customList[i].customName + "</li>";
			}
			customList += "</ul>";
			$("#serachresult").html(customList);
			$("#serachresult").slideDown();
		}
	}, 'json');
}

function confirmCustom(id, name) {
	customID = id;
	customName = name;
	$("#searchusertext").val(name);
	$("#serachresult").hide();
	$("#customname").val(name);

}