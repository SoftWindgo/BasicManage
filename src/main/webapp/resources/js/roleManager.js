$(function() {
	debugger;
	var dataVar = new Vue({
		el:"#dataContainer",
		data : {
			content : {}
		},methods : {
			deleteWithId : deleteById,
			updateWithId : selectOne
		}
	});
	var updVar = new Vue({
		el:"#updForm",
		data : {
			content : {}
		}
	});
	function selectAll(){
		dataVar.content = {};
		$.ajax({
			type : "GET",
			url : "/Roles",
			success : function(data) {
				debugger;
				if(data.code != 200){
					alert(data.message);
					return;
				}
				debugger;
				dataVar.content = data.data;
				
			}
		});
	}
	function insert(){
		$.ajax({
			type:"post",
			url:"/Roles",
			data : $("#addForm").serialize(),
			success : function(data){
				if(data.code != 200){
					alert(data.message);
					return;
				}
				alert("添加成功");
				selectAll();
				$("#addModal").modal("hide");
			}
		});
	}
	function selectOne(id){
		$.ajax({
			type:"get",
			url:"/Roles/"+id,
			success : function(data){
				if(data.code != 200){
					alert(data.message);
					return;
				}
				updVar.content = data.data;
				$("#updModal").modal();
			}
		});
	}
	function deleteById(id){
		$.ajax({
			type:"delete",
			url:"/Roles/"+id,
			success : function(data){
				if(data.code != 200){
					alert(data.message);
					return;
				}
				alert("删除成功");
				selectAll();
			}
		});
	}
	function updateById(){
		$("#updForm").serialize()
		$.ajax({
			type:"put",
			url:"/Roles",
			data :  $("#updForm").serialize()
			,success : function(data){
				if(data.code != 200){
					alert(data.message);
					return;
				}
				alert("修改成功");
				selectAll();
				$("#updModal").modal("hide");
			}
		});
	}
	
	$("#addBtn").click(function(){
		insert();
	});
	$("#updBtn").click(function(){
		updateById();
	});
	selectAll();
});
