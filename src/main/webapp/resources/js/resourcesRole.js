$(function() {
	debugger;
	var optionFlag = -1;
	var firstDatatable = null;
	var secondDatatable = null;
	var dataVar = new Vue({
		el : "#dataContainer",
		data : {
			content : {}
		},
		methods : {
			firstSelect : selectFirst,
			secondSelect : selectSecond,
			deleteWithId : deleteById,
			updateWithId : selectOne
		}
	});
	var addVar = new Vue({
		el : "#addModal",
		data : {
			firstData : "",
			secondData : ""
		} ,
		methods : {
			firstSelect : selectFirst,
			secondSelect : selectSecond,
		}
	});
	var updVar = new Vue({
		el : "#updForm",
		data : {
			firstId : "",
			secondId : "",
			first : {},
			second :{}
		},methods : {
			firstSelect : selectFirst,
			secondSelect : selectSecond,
		}
	});
	var firstVar = new Vue({
		el : "#firstModal",
		data : {
			first : {},
			second : {}
		},
		methods : {
			firstSelect : selectFirst,
			secondSelect : selectSecond,
			close : function() {
				closeSelectModal("firstModal");
			},
			subBtn : function(){
				firstSelectSub();
			}
		},
		watch : {
			first : function() {
				this.$nextTick(function() {
					firstDatatable = initDatatable("first");
				});
			}
		}
	});
	var secondVar = new Vue({
		el : "#secondModal",
		data : {
			first : {},
			second : {}
		},
		methods : {
			firstSelect : selectFirst,
			secondSelect : selectSecond,
			close : function() {
				closeSelectModal("secondModal");
			},
			subBtn : function(){
				secondSelectSub();
			}
		},
		watch : {
			second : function() {
				this.$nextTick(function() {
					secondDatatable = initDatatable("second");
				});
			}
		}
	});
	function selectAll() {
		dataVar.content = {};
		$.ajax({
			type : "GET",
			url : "/ResRoles",
			success : function(data) {
				if (data.code != 200) {
					alert(data.message);
					return;
				}
				dataVar.content = data.data;
			}
		});
	}
	function insert() {
		$.ajax({
			type : "post",
			url : "/ResRoles",
			data : $("#addForm").serialize(),
			success : function(data) {
				if (data.code != 200) {
					alert(data.message);
					return;
				}
				alert("添加成功");
				selectAll();
				$("#addModal").modal("hide");
			}
		});
	}
	function selectOne(firstId,secondId) {
		$.ajax({
			type : "get",
			url : "/ResRoles/" + firstId+"/"+secondId,
			success : function(data) {
				if (data.code != 200) {
					alert(data.message);
					return;
				}
				updVar.firstId = data.data.resources.resId;
				updVar.secondId = data.data.roles.rolesId;
				updVar.first = data.data.resources;
				updVar.second = data.data.roles;
				optionFlag = 2;
				$("#updModal").modal();
			}
		});
	}
	function deleteById(firstId,secondId) {
		debugger;
		$.ajax({
			type : "delete",
			url : "/ResRoles/" + firstId+"/" + secondId,
			success : function(data) {
				if (data.code != 200) {
					alert(data.message);
					return;
				}
				alert("删除成功");
				selectAll();
			}
		});
	}
	function updateById() {
		$("#updForm").serialize()
		$.ajax({
			type : "put",
			url : "/ResRoles",
			data : $("#updForm").serialize(),
			success : function(data) {
				if (data.code != 200) {
					alert(data.message);
					return;
				}
				alert("修改成功");
				selectAll();
				$("#updModal").modal("hide");
			}
		});
	}
	function selectFirst() {
		$.ajax({
			type:"get",
			url:"/Resources",
			success : function(data){
				if(data.code != 200){
					alert(data.message);
					return;
				}
				firstVar.first = data.data;
				$("#firstModal").modal();
			}
		});
	}
	function selectSecond() {
		$.ajax({
			type:"get",
			url:"/Roles",
			success : function(data){
				if(data.code != 200){
					alert(data.message);
					return;
				}
				secondVar.second = data.data;
				$("#secondModal").modal();
			}
		});
	}
	function closeSelectModal(curModalId) {
		$("#" + curModalId).modal("hide");
		setTimeout(function() {
			if (optionFlag == 1)
				$("#addForm").modal();
			else
				$("#updForm").modal();
		}, 1000);
	}
	function firstSelectSub(){
		if(optionFlag == 1){
			var con = getValueByRadio("first");
			$("#addFirstId").val(con.value);
			addVar.firstData = null;
			addVar.firstData = con.container.parent().nextAll().eq(1).html();
		}else{
			var con = getValueByRadio("first");
			updVar.first = null;
			updVar.first = {};
			updVar.first.resId = con.value;
			updVar.first.resName = con.container.parent().nextAll().eq(1).html();
		}
		$("#firstModal").modal("hide");
	}
	function secondSelectSub(){
		if(optionFlag == 1){
			var con = getValueByRadio("second");
			$("#addSecondId").val(con.value);
			addVar.secondData = null;
			addVar.secondData = con.container.parent().nextAll().eq(1).html();
		}else{
			var con = getValueByRadio("second");
			updVar.second = null;
			updVar.second = {};
			updVar.second.rolesId = con.value;
			updVar.second.resName = con.container.parent().nextAll().eq(1).html();
			
		}
		$("#secondModal").modal("hide");
	}
	$("#addBtn").click(function() {
		insert();
	});
	$("#updBtn").click(function() {
		updateById();
	});
	$('#firstModal').on('hidden.bs.modal', function() {
		firstDatatable.fnDestroy();
	})
	$('#secondModal').on('hidden.bs.modal', function() {
		secondDatatable.fnDestroy();
	})
	$("#addModalShow").on("click",function(){
		optionFlag = 1;
		$("#addModal").modal();
	});;
	selectAll();
});
