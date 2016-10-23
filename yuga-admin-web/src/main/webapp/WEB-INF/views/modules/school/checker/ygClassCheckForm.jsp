<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>巡查情况管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/school/checker/ygClassCheck/">巡查情况列表</a></li>
		<li class="active"><a href="${ctx}/school/checker/ygClassCheck/form?id=${ygClassCheck.id}">巡查情况<shiro:hasPermission name="school:checker:ygClassCheck:edit">${not empty ygClassCheck.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="school:checker:ygClassCheck:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="ygClassCheck" action="${ctx}/school/checker/ygClassCheck/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="checkerId" value="${fns:getUser().id}"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">所属年级：</label>
			<div class="controls">
				<form:select path="gradeId" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getGradeList()}" itemLabel="name" itemValue="id" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">课程章节：</label>
			<div class="controls">
				<form:select path="courseSection" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getYgCourseList()}" itemLabel="name" itemValue="id" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">教师：</label>
			<div class="controls">
				<form:select path="teacherId" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getTeacherList()}" itemLabel="name" itemValue="id" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">教师教学情况：</label>
			<div class="controls">
				<form:select path="teacherStatusId" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getTeacherStatusList()}" itemLabel="level" itemValue="id" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">学生学习情况：</label>
			<div class="controls">
				<form:select path="studentStatusId" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getStudentStatusList()}" itemLabel="level" itemValue="id" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">使用多媒体情况：</label>
			<div class="controls">
				<form:select path="multimediaStatusId" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getMultiStatusList()}" itemLabel="name" itemValue="id" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">巡查人：</label>
			<div class="controls">
				<input value="${fns:getUser().name}" type="text" readonly="readonly"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="school:checker:ygClassCheck:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>