<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/news/news_list.js"></script>
	<script type="text/javascript" src="bootstrap/tinymce/tinymce.min.js"></script>
	<script type="text/javascript" src="js/pages/back/index.js"></script>
</head>
<%!
	public static final String NEWS_ADD_URL = "pages/back/admin/news/news_add.jsp" ;
	public static final String NEWS_EDIT_URL = "pages/back/admin/news/news_pre_edit.action" ;
%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="role" value="news"/>
			<jsp:param name="action" value="news:${param.type}"/>
		</jsp:include>
		<div class="content-wrapper">
			<div class="panel panel-success">
				<div class="panel-heading">
					<strong><i class="fa fa-list-ul"></i>&nbsp;公告列表</strong>
				</div>
				<div class="panel-body">
					<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
					<table class="table table-hover">
						<tr>
							<th width="5%" class="text-center"><input type="checkbox" id="selall"></th>
							<th width="50%" class="text-center">标题</th> 
							<th width="15%" class="text-center">发布者</th>
							<th width="15%" class="text-center">发布日期</th>
							<th width="10%" class="text-center">发布状态</th>
							<th width="5%" class="text-center">操作</th>
						</tr>
						<c:forEach items="${allNews}" var="news">
							<tr id="shopcar-${news.nid}">
								<td class="text-center"><input type="checkbox" id="nid" name="nid" value="${news.nid}"></td>
								<td class="text-center">${news.title}</td>
								<td class="text-center"><span id="pub-admin">${news.mid}</span></td>
								<td class="text-center">${news.pubdate}</td>
								<td class="text-center">
									<c:if test="${news.status==1}">
										已发布
									</c:if>
									<c:if test="${news.status==0}">
											<button id="news-${news.nid}" class="btn btn-warning btn-xs">未发布</button>
									</c:if>
								</td>
								<td class="text-center"><a href="<%=NEWS_EDIT_URL%>?nid=${news.nid}" class="btn btn-xs btn-primary"><span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a></td>
							</tr>
						</c:forEach>
					</table>
					<a href="<%=NEWS_ADD_URL%>" id="addBtn" class="btn btn-lg btn-primary"><span class="glyphicon glyphicon-plus-sign"></span>&nbsp;发布公告</a>
					<button id="removeBtn" class="btn btn-lg btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除公告</button>
					<jsp:include page="/pages/plugins/split_page_bar_plugin.jsp"/>
				</div>
				<div class="panel-footer" style="height:80px;">
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
	<jsp:include page="/pages/plugins/back/modal/member_info_modal.jsp"/>
</body>
</html>
