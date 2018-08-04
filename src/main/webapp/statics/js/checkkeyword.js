$().ready(function(){
	
	mover(4);
	
	$(".checkselect").change(function(){		
		var obj=$(this);
		var v=obj.val();
		var kid=obj.attr("kid");
		var keyword=obj.attr("keyword");
		var status=obj.find(":selected").text();
		if(v==1||v==2||v==3)
		{
			if(confirm("您确定要将"+keyword+"的状态修改为["+status+"]吗"))
			{
				var keywords=new Object();
				keywords.id=kid;
				keywords.checkStatus=v;
				keywords.serviceYears=obj.find(":selected").attr("data-year");
				$.post(path+"agent/keyword/updatekeywords",
				{"keywords":JSON.stringify(keywords)},
				function(result){
					if("success"==result)
						{
						humane.success("恭喜您 ,"+keyword+"的状态被修改为["+status+"],操作成功");
						window.location.reload();
						}
					else{
						humane.success("对不起,"+keyword+"的状态被修改为["+status+"],操作失败");
					}
				},"html");
			
			}
		}
		else if(v==4){//续费
			
		}
		else if(v==5||v==6){//不使用
			if(confirm("您确定要将"+keyword+"的使用状态修改为["+status+"]吗"))
			{
				var keywords=new Object();
				keywords.id=kid;
				keywords.isUse=v==5?0:1;
				$.post(path+"agent/keyword/updatekeywords",
				{"keywords":JSON.stringify(keywords)},
				function(result){
					if("success"==result)
						{
						humane.success("恭喜您 ,"+keyword+"的使用状态被修改为["+status+"],操作成功");
						window.location.reload();
						}
					else{
						humane.success("对不起,"+keyword+"的使用状态被修改为["+status+"],操作失败");
					}
				},"html");
			
			}
		}
		
	});
});