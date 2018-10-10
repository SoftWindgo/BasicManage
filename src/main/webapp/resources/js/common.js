/**
 * 初始化dataTable
 * 
 * @param dataTableVar
 * @returns
 */
function initDatatable(idVar) {
	return $("#"+idVar).dataTable({
		language : {
			"sProcessing" : "处理中...",
			"sLengthMenu" : "显示 _MENU_ 项结果",
			"sZeroRecords" : "没有匹配结果",
			"sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
			"sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
			"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
			"sInfoPostFix" : "",
			"sSearch" : "搜索:",
			"sUrl" : "",
			"sEmptyTable" : "表中数据为空",
			"sLoadingRecords" : "载入中...",
			"sInfoThousands" : ",",
			"oPaginate" : {
				"sFirst" : "首页",
				"sPrevious" : "上一页",
				"sNext" : "下一页",
				"sLast" : "末页"
			},
			"oAria" : {
				"sSortAscending" : ": 以升序排列此列",
				"sSortDescending" : ": 以降序排列此列"
			}
		},
		"lengthChange" : false,
		"lengthMenu" : [ 5 ],
		responsive : true
	});
}

/**
 * 通过一个传入的参数然后对比一组radio的value值，如果相等就设置为选中状态
 * 
 * @param radioArr
 *            进行对比的radio组input的name值
 * @param comp
 *            和input的value值对比的参数
 */
function setRadioByVal(radioArr, comp) {
	if ((typeof comp) != "string") {
		return;
	}
	if (comp.indexOf(',') == -1) {
		$("input[name=" + radioArr + "]").each(function() {
			if ($(this).val() == comp) {
				$(this).prop("checked", true);
			}
		});
	} else {
		$("input[name=" + radioArr + "]").each(function() {
			if (isHaveByArr(comp.split(','), $(this).val()))
				$(this).prop("checked", true);
		});
	}
}
/**
 * 判断字符串是否存在自一个字符串数组中
 * 
 * @param arrVar
 *            字符串数组
 * @param cmpVar
 *            进行判断的子字符串值
 * @returns true 存在 false不存在
 */
function isHaveByArr(arrVar, cmpVar) {
	for (var i = 0; i < arrVar.length; i++) {
		if (arrVar[i] == cmpVar)
			return true;
	}
	return false;
}

/**
 * 获取一个checkbox组中被选中的value值
 * 
 * @param radioArr
 *            需要进行取出的checkbox的name值
 * @returns 被选中的checkbox的value值 格式 "value1,value2"
 */
function getValueByRadio(radioArr) {
	var resultStr = '';
	$("input[name=" + radioArr + "]:checked").each(function() {
		resultStr += $(this).val() + ',';
	});
	return {value:resultStr.substr(0, resultStr.length - 1),container:$("input[name=" + radioArr + "]:checked")};
}