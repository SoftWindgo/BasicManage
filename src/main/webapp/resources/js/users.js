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
			url : "/Users",
			success : function(data) {
				debugger;
				if(data.code != 200){
					alert(data.message);
					return;
				}
				dataVar.content = data.data;
				
			}
		});
	}
	function insert(){
		$.ajax({
			type:"post",
			url:"/Users",
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
			url:"/Users/"+id,
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
			url:"/Users/"+id,
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
		$.ajax({
			type:"put",
			url:"/Users",
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