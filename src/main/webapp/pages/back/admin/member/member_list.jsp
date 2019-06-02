<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.yootk.vo.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/member/member_list.js"></script>
	<script type="text/javascript" src="js/pages/back/index.js"></script>
</head>
<%!
	public static final String EMP_EDIT_URL = "pages/back/admin/member/member_pre_edit.action" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="9"/>
			<jsp:param name="msi" value="92"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;雇员信息列表</strong>
			</div>
			<div class="panel-body">
				<div>
					<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				</div>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center"><input type="checkbox" id="selall"></th>
							<th class="text-center">照片</th> 
							<th class="text-center">姓名</th>
							<th class="text-center">级别</th>
							<th class="text-center">所在部门</th>
							<th class="text-center">雇佣日期</th>
							<th class="text-center">基本工资</th>
							<th class="text-center">联系电话</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${allMembers}" var="member">
						<tr>
							<td class="text-center"><input type="checkbox" id="mid" value="${member.mid}"></td>
							<td class="text-center">
								<c:if test="${member.photo!=null && member.photo !=''&& member.photo!='nophoto.png'}">
									<img src="http://upload-server/upload/${member.photo}" style="width:20px;"/>
								</c:if>
							</td>
							<td class="text-center">${member.name}</td>
							<td class="text-center">${allLevels[member.lid]}</td>
							<td class="text-center">${allDepts[member.did]}</td>
							<td class="text-center">${member.regdate}</td>
							<td class="text-center">${member.sal}</td>
							<td class="text-center">${member.phone}</td>
							<td class="text-center">
								<a type="button" class="btn btn-warning btn-xs" href="<%=EMP_EDIT_URL%>?mid=${member.mid}">
									<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
							</td>
						</tr>

					</c:forEach>
					</tbody>
				</table>
				<button id="removeBtn" class="btn btn-lg btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除雇员</button>
				<div id="splitBarDiv" style="float:right">
					<jsp:include page="/pages/plugins/split_page_bar_plugin.jsp"/>
				</div>
			</div>
			<div class="panel-footer">
				<jsp:include page="/pages/plugins/alert.jsp"/>
			</div>
		</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/pages/plugins/back/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
</body>
</html>
