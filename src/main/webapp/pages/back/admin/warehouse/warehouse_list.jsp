<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/warehouse/warehouse_list.js"></script>
	<script type="text/javascript" src="js/split_page.js"></script>
	<script type="text/javascript" src="js/pages/back/index.js"></script>
</head>
<%!
	public static final String WAREHOUSE_EDIT_URL = "pages/back/admin/warehouse/warehouse_pre_edit.action" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="1"/>
			<jsp:param name="msi" value="12"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;仓库信息列表</strong>
			</div>
			<div class="panel-body">
				<div>
					<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				</div>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-left" style="width:15%;">仓库名称</th> 
							<th class="text-left" style="width:25%;">仓库地址</th>
							<th class="text-center" style="width:10%;">存储分类</th>
							<th class="text-center" style="width:10%;">存储上限</th>
							<th class="text-center" style="width:10%;">当前存储量</th>
							<th class="text-center" style="width:10%;">管理员姓名</th>
							<th class="text-left" style="width:20%;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allWarehouses}" var="warehouse">
							<tr>
								<td class="text-left">${warehouse.name}</td>
								<td class="text-left">${warehouse.address}</td>
								<td class="text-center">${allWitemMap.get(warehouse.wiid)}</td>
								<td class="text-center">${warehouse.area}</td>
								<td class="text-center">${warehouse.maximum}</td>
								<td class="text-center" id="admin-${warehouse.wid}"><span id="mid-${warehouse.admin}" style="cursor:pointer;">${allMemberMap.get(warehouse.admin)}</span></td>
								<td class="text-left">
									<button id="editadmin-${warehouse.wid}" class="btn btn-primary btn-xs">
										<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;编辑库管</button>

									<a href="<%=WAREHOUSE_EDIT_URL%>?wid=${warehouse.wid}" id="editinfo-${warehouse.wid}" class="btn btn-warning btn-xs">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑信息</a>
								</td>
							</tr>
						</c:forEach>
						<%--<tr>
							<td class="text-left">北京通州仓库一号库</td>
							<td class="text-left">北京 北京 通州XXX</td>
							<td class="text-center">服装衣帽</td>
							<td class="text-center">1000</td>
							<td class="text-center">800</td>
							<td class="text-center" id="admin-2"></td>
							<td class="text-left">
								<button id="editadmin-2" class="btn btn-primary btn-xs">
										<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;编辑库管</button>
								<a href="<%=WAREHOUSE_EDIT_URL%>?wid=2" id="editinfo-1" class="btn btn-warning btn-xs">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑信息</a>
							</td>
						</tr>--%>
					</tbody>
				</table>
				<div id="splitBarDiv" style="float:right">
					<jsp:include page="/pages/plugins/split_page_bar_plugin.jsp"/>
				</div>
			</div>
			<div class="panel-footer" style="height:100px;">
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
	<jsp:include page="/pages/plugins/back/modal/member_info_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/modal/member_dept_list_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/footer.jsp"/>
