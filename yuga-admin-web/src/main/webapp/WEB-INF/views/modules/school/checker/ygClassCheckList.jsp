<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>巡查情况管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/school/checker/ygClassCheck/">巡查情况列表</a></li>
		<shiro:hasPermission name="school:checker:ygClassCheck:edit"><li><a href="${ctx}/school/checker/ygClassCheck/form">巡查情况添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ygClassCheck" action="${ctx}/school/checker/ygClassCheck/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>所属年级：</label>
				<form:select id="gradeId" path="gradeId" class="input-xlarge">
					<form:option value="-1" label="无班级"/>
					<form:options items="${fns:getGradeList()}" itemLabel="name" itemValue="id" title="clas" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>课程章节：</label>
				<form:select path="courseSection" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>教师：</label>
				<form:select path="teacherId" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>巡查人：</label>
				<form:select path="checkerId" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>教学情况：</label>
				<form:select path="teacherStatusId" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>学习情况：</label>
				<form:select path="studentStatusId" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>多媒体情况：</label>
				<form:select path="multimediaStatusId" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>所属年级</th>
				<th>课程章节</th>
				<th>教师</th>
				<th>巡查人</th>
				<th>教师教学情况</th>
				<th>学生学习情况</th>
				<th>使用多媒体情况</th>
				<shiro:hasPermission name="school:checker:ygClassCheck:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ygClassCheck">
			<tr>
				<td><a href="${ctx}/school/checker/ygClassCheck/form?id=${ygClassCheck.id}">
					${fns:getDictLabel(ygClassCheck.gradeId, '', '')}
				</a></td>
				<td>
					${fns:getDictLabel(ygClassCheck.courseSection, '', '')}
				</td>
				<td>
					${fns:getDictLabel(ygClassCheck.teacherId, '', '')}
				</td>
				<td>
					${fns:getDictLabel(ygClassCheck.checkerId, '', '')}
				</td>
				<td>
					${fns:getDictLabel(ygClassCheck.teacherStatusId, '', '')}
				</td>
				<td>
					${fns:getDictLabel(ygClassCheck.studentStatusId, '', '')}
				</td>
				<td>
					${fns:getDictLabel(ygClassCheck.multimediaStatusId, '', '')}
				</td>
				<shiro:hasPermission name="school:checker:ygClassCheck:edit"><td>
    				<a href="${ctx}/school/checker/ygClassCheck/form?id=${ygClassCheck.id}">修改</a>
					<a href="${ctx}/school/checker/ygClassCheck/delete?id=${ygClassCheck.id}" onclick="return confirmx('确认要删除该巡查情况吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>