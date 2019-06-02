<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%!
	public static final String CUSTOMER_ADD_URL = "" ;
%>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/customer/customer_list.js"></script>
	<script type="text/javascript" src="js/split_page.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
	<!-- 导入头部标题栏内容 -->
	<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
	<!-- 导入左边菜单项 -->
	<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
		<jsp:param name="mi" value="2"/>
		<jsp:param name="msi" value="22"/>
	</jsp:include>
	<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;客户信息列表</strong>
			</div>
			<div class="panel-body">
				<div>
					<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				</div>
				<table class="table table-condensed">
					<thead>
					<tr>
						<th class="text-center" style="width:10%;">客户姓名</th>
						<th class="text-left" style="width:10%;">客户电话</th>
						<th class="text-left" style="width:10%;">重要性</th>
						<th class="text-left" style="width:20%;">联系地址</th>
						<th class="text-left" style="width:10%;">记录日期</th>
						<th class="text-center" style="width:10%;">联系次数</th>
						<th class="text-center" style="width:10%;">记录者</th>
						<th class="text-left" style="width:20%;">操作</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${allCustomers}" var="customer">
						<tr>
							<td class="text-center"><span id="cuid-${customer.cuid}" style="cursor:pointer;" title="查看联系记录">${customer.name}</span></td>
							<td class="text-left">${customer.phone}</td>
							<td class="text-left"><span class="">${allCitemMap.get(customer.ciid)}</span></td>
							<td class="text-left">${customer.address}</td>
							<td class="text-left">${customer.indate}</td>
							<td class="text-center">${customer.connum}</td>
							<td class="text-center"><span id="mid-${customer.recorder}" style="cursor:pointer;">${allMemberMap.get(customer.recorder)}</span></td>
							<td class="text-left">
								<button class="btn btn-primary btn-xs" id="input-${customer.cuid}">
									<span class="glyphicon glyphicon-floppy-save"></span>&nbsp;追加记录</button>
								<button class="btn btn-danger btn-xs" id="out-${customer.cuid}">
									<span class="glyphicon glyphicon-log-out"></span>&nbsp;商品出库</button>
							</td>
						</tr>
					</c:forEach>
					<%--<tr>
						<td class="text-center"><span id="cid-1" style="cursor:pointer;" title="查看联系记录">新博</span></td>
						<td class="text-left">1234456</td>
						<td class="text-left"><span class="text-danger">重要客户</span></td>
						<td class="text-left">天安门广场</td>
						<td class="text-left">2018-10-13</td>
						<td class="text-center">3</td>
						<td class="text-center"><span id="mid-admin" style="cursor:pointer;">老李</span></td>
						<td class="text-left">
							<button class="btn btn-primary btn-xs" id="input-1">
								<span class="glyphicon glyphicon-floppy-save"></span>&nbsp;追加记录</button>
							<button class="btn btn-danger btn-xs" id="out-1">
								<span class="glyphicon glyphicon-log-out"></span>&nbsp;商品出库</button>
						</td>
					</tr>
					<tr>
						<td class="text-center"><span id="cid-2" style="cursor:pointer;" title="查看联系记录">旧博</span></td>
						<td class="text-left">1234456</td>
						<td class="text-left"><span class="text-primary">大单客户</span></td>
						<td class="text-left">天安门广场</td>
						<td class="text-left">2018-10-13</td>
						<td class="text-center">3</td>
						<td class="text-center"><span id="mid-admin" style="cursor:pointer;">老李</span></td>
						<td class="text-left">
							<button class="btn btn-primary btn-xs" id="input-2">
								<span class="glyphicon glyphicon-floppy-save"></span>&nbsp;追加记录</button>
							<button class="btn btn-danger btn-xs" id="out-2">
								<span class="glyphicon glyphicon-log-out"></span>&nbsp;商品出库</button>
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
<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/modal/member_info_modal.jsp"/>
<jsp:include page="/pages/plugins/back/modal/customer_record_list_modal.jsp"/>
<jsp:include page="/pages/plugins/back/modal/customer_record_input_modal.jsp"/>
</body>
</html>