
$().ready(function() {
	mover(1);
	$("#addCustomBtn").click(function() {
		location.href = path + "agent/customs/addcustom.html";
	});

	$(".viewCustom").click(function() {
		var c = $(this);
		var c_id = c.attr("id");
		window.location.href = "agent/customs/viewcustom/" + c_id;
	});

	$(".modifyCustom").click(function() {
		var c = $(this); //a标签
		var c_id = c.attr("id");
		window.location.href = "agent/customs/modifycustom/" + c_id;
	});

	$(".mofifyCustomStatus").click(function() {
		var c = $(this);
		var c_id = c.attr("id");
		var c_status = c.attr("mStatus");
		var c_customname = c.attr("customName");
		var action = c_status == "1" ? "停用" : "启用";
		var str = "您是否确定要" + action + "[" + c_customname + "]这个客户?";

		if (confirm(str)) {
			$.post(path + "agent/customs/modifycustomstatus", {
				"id" : c_id,
				"customStatus" : (c_status==1?0:1)
			},
				function(result) {
					if (result == "success") {
						humane.success(action + "成功");
						window.location.reload(true);
					} else {
						humane.success(action + "失败");
					}

				}, 'html');

		}
	});
});