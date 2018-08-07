$().ready(function() {

	var kid = $("#kid").val();
	$("#submitkeyword").click(function() {
		var servicetype = $("#servicetype").val();
		var years = $("#serviceyear").val();
		var price = parseInt($("#servicetype option:selected").attr("data-price"));
		if (servicetype == "") {
			humane.error("对不起,请选择服务类型");
			$("#servicetype").focus();
		} else if (years == "") {
			humane.error("对不起,请选择服务年限");
			$("#serviceyear").focus();
		} else if (price > parseInt($("#accountspan").attr("data-money"))) {
			humane.error("对不起,您当前的余额不能支付本次申请,请充值后再进行重试");
		} else {
			//提交
			var keywords = new Object();
			keywords.price = price;
			keywords.serviceYears = years;
			keywords.productType = servicetype;
			keywords.id=kid;
			$.post(path + "agent/keyword/keywordsxufei",
				{
					"keywords" : JSON.stringify(keywords)
				},
				function(result) {
					if ("exception" == result) {
						humane.error("对不起,您提交的关键词出现异常.");
					} else {
						humane.success("恭喜您,续费成功!");
						$("#accountspan").html(result);
					}
				}, "html");
		}
	});

	$("#servicetype").change(function() {
		jisuan();
	});
	$("#serviceyear").change(function() {
		jisuan();
	});

});


//根据选择的服务类型及服务年限自动计算价格
function jisuan() {
	var servicetype = $("#servicetype").val();
	var youhui = $("#serviceyear option:selected").attr("data-youhui");
	var serviceyear;
	if (youhui == 'true') {
		serviceyear = $("#serviceyear").val().split('-')[0];
	} else {
		serviceyear = $("#serviceyear").val()
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
	}
}