<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>巡查信息管理</title>
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
		<li class="active"><a href="${ctx}/school/checker/classCheck/">巡查信息列表</a></li>
		<shiro:hasPermission name="school:checker:classCheck:edit"><li><a href="${ctx}/school/checker/classCheck/form">巡查信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="classCheck" action="${ctx}/school/checker/classCheck/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>课程章节：</label>
				<form:input path="courseSection" htmlEscape="false" maxlength="2" class="input-medium"/>
			</li>
			<li><label>教师ID：</label>
				<form:input path="teacherId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>巡查人：</label>
				<form:input path="checkerId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>课程章节</th>
				<th>教师ID</th>
				<th>巡查人</th>
				<shiro:hasPermission name="school:checker:classCheck:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="classCheck">
			<tr>
				<td><a href="${ctx}/school/checker/classCheck/form?id=${classCheck.id}">
					${classCheck.courseSection}
				</a></td>
				<td>
					${classCheck.teacherId}
				</td>
				<td>
					${classCheck.checkerId}
				</td>
				<shiro:hasPermission name="school:checker:classCheck:edit"><td>
    				<a href="${ctx}/school/checker/classCheck/form?id=${classCheck.id}">修改</a>
					<a href="${ctx}/school/checker/classCheck/delete?id=${classCheck.id}" onclick="return confirmx('确认要删除该巡查信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>