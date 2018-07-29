$().ready(function() {

	mover(4);

	// $("#addRoleDiv").css()
	$("#addRole").click(function() {
		$("#addRoleDiv").slideDown();
		$("#modifyRoleDiv").slideUp();
	});

	$(".modifyRole").click(function() {
		$("#addRoleDiv").slideUp();
		$("#modifyRoleDiv").slideDown();

		var b = $(this);
		$("#m_roleName").val(b.attr('rolename'));
		$("#m_isStart").val(b.attr('isstart'));
		$("#m_roleId").val(b.attr('roleid'));

	});

	$(".deleteRole").click(function() {

		var b = $(this);
		var b_roleId = b.attr('roleid');
		if (confirm("您 确认要删除 吗?")) {
			//delete
			$.post("/deleterole.action",{'role.id':b_roleId},function(result){
				if ("success" == result) {
					humane.success("删除成功 ");
					window.location.href = "/rolelist.action";
				} else {
					humane.error("删除失败");
				}
			})
		}
	});

	$("#addRoleSubmit").click(function() {
		var a_roleName = $("#a_roleName").val();
		var a_isStart = $("#a_isStart").val();
		if (a_roleName == '')
			humane.error("角色名称不能为空");
		$.post("/editrole.action?type=add", {
			'role.roleName' : a_roleName,
			'role.isStart' : a_isStart
		}, function(result) {
			if ("success" == result) {
				humane.success("添加成功 ");
				window.location.href = "/rolelist.action";
			} else {
				humane.error("添加失败");
			}
		}, 'html');
	});

	$("#modifyRoleSubmit").click(function() {
		var m_id = $("#m_roleId").val();
		var m_roleName = $("#m_roleName").val();
		var m_isStart = $("#m_isStart").val();
		if (m_roleName == '')
			humane.error("角色名称不能为空");
		$.post("/editrole.action?type=modify", {
			'role.id' : m_id,
			'role.roleName' : m_roleName,
			'role.isStart' : m_isStart
		}, function(result) {
			if ("success" == result) {
				humane.success("修改成功 ");
				window.location.href = "/rolelist.action";
			} else {
				humane.error("修改失败");
			}
		}, 'html');
	});

	$('#modifyCancel').click(function() {
		$("#modifyRoleDiv").slideUp();
	});
	$('#addCancel').click(function() {
		$("#addRoleDiv").slideUp();
	});
})