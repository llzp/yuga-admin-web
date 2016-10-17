
$(document).ready(
		
		function(){
			
			init();
			$('#coursetype').change(function() {
				getSubCourseType();
			});
			
			$('#subCourse').change(function(){
				$('#subCourseType').val($('#subCourse').val());
			});
		
			// 初始化地址框多选

//			$('#slsServRange').change(function(e) {
//				$("#servRange").val($("#slsServRange").val());
//			});
//
//			var listServRange = $("#servRange").val();
//			if (listServRange != undefined || listServRange != '') {
//				var listIn = listServRange.split(',');
//				for (var ii = 0; ii < listIn.length; ii++) {
//					var optionItem = $("#slsServRange").find(
//							'option[value=' + listIn[ii] + ']');
//					var newSelectedItem = "<option value=" + listIn[ii]
//							+ " selected>" + listIn[ii] + "</option>";
//					optionItem.replaceWith(newSelectedItem);
//				}
//			}
//
//			$('#slsServRange').chosen({
//				width : "15%"
//			})

			$("#inputForm").validate(
					{
						submitHandler : function(form) {
							loading('正在提交，请稍等...');
							form.submit();
						},
						errorContainer : "#messageBox",
						errorPlacement : function(error, element) {
							$("#messageBox").text("输入有误，请先更正。");
							if (element.is(":checkbox") || element.is(":radio")
									|| element.parent().is(".input-append")) {
								error.appendTo(element.parent().parent());
							} else {
								error.insertAfter(element);
							}
						}
					});
		});

function init(){
	getSubCourseType();
}

function getSubCourseType() {
	var html = "<option value='-1'>--请选择--</option>";
	$.get('../../admin/tree/treeData/' + $('#coursetype').val(),
		function(data) {
		length = data.length;
		for (var i = 0; i < data.length; i++) {
			/*if($('#subCourseType').val() == undefined){
				if(i==0){
					html += "<option selected = 'true' value='"+data[i].id+"'>"
					+ data[i].name + "</option>";
				}else {
					html += "<option value='"+data[i].id+"'>"
					+ data[i].name + "</option>";
				}
			}else{
				if(data[i].id == $('#subCourseType').val()){
					html += "<option selected = 'true' value='"+data[i].id+"'>"
					+ data[i].name + "</option>";
				}else{
					html += "<option value='"+data[i].id+"'>"
					+ data[i].name + "</option>";
				}
			}*/
			html += "<option value='"+data[i].id+"'>"
			+ data[i].name + "</option>";
		}
		$("#subCourse").html(html);
	});
}

function addRow(list, idx, tpl, row) {
	$(list).append(Mustache.render(tpl, {
		idx : idx,
		delBtn : true,
		row : row
	}));
	$(list + idx).find("select").each(function() {
		$(this).val($(this).attr("data-value"));
	});
	$(list + idx).find("input[type='checkbox'], input[type='radio']").each(
			function() {
				var ss = $(this).attr("data-value").split(',');
				for (var i = 0; i < ss.length; i++) {
					if ($(this).val() == ss[i]) {
						$(this).attr("checked", "checked");
					}
				}
			});
}
function delRow(obj, prefix) {
	var id = $(prefix + "_id");
	var delFlag = $(prefix + "_delFlag");
	if (id.val() == "") {
		$(obj).parent().parent().remove();
	} else if (delFlag.val() == "0") {
		delFlag.val("1");
		$(obj).html("&divide;").attr("title", "撤销删除");
		$(obj).parent().parent().addClass("error");
	} else if (delFlag.val() == "1") {
		delFlag.val("0");
		$(obj).html("&times;").attr("title", "删除");
		$(obj).parent().parent().removeClass("error");
	}
}


