<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/front/center/address/address_list.js"></script>
</head>
<%!
	public static final String ADDRESS_ADD_URL = "pages/front/center/address/address_add_pre.action" ;
	public static final String ADDRESS_EDIT_URL = "pages/front/center/address/address_edit_pre.action" ;
%>
<body>
	<div class="container">
		<div id="headDiv" class="row">
			<div class="col-md-12 col-xs-12">
				<jsp:include page="/pages/plugins/front/include_navbar.jsp" />
			</div>
		</div>
		<div style="height: 60px;"></div>
		<div id="contentDiv" class="row">
			<div class="col-md-2 col-xs-2">
				<jsp:include page="/pages/plugins/front/center/include_center_item.jsp">
					<jsp:param value="5" name="ch"/>
				</jsp:include>
			</div>
			<div class="col-md-10 col-xs-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<strong><span class="glyphicon glyphicon-list"></span>&nbsp;个人地址信息列表</strong>
					</div>
					<div class="panel-body">
						<table class="table table-condensed">
							<thead>
								<tr>
									<th class="text-center">
										<input type="checkbox" id="selectAll">
									</th>
									<th class="text-center"><strong>收件人</strong></th>
									<th class="text-center"><strong>联系电话</strong></th>
									<th class="text-center"><strong>地址</strong></th>
									<th class="text-center"><strong>操作</strong></th>
								</tr>
							</thead>
							<tbody>
                            <c:forEach items="${allAddresses}" var="address">
                                <tr id="address-${address.adid}">
									<td class="text-center">
										<input type="checkbox" id="mid" name="mid" value="${address.adid}">
									</td>
									<td class="text-center">${address.receiver}</td>
									<td class="text-center">${address.phone}</td>
									<td class="text-center">${address.addr}</td>
									<td class="text-center"><a id="editBtn-1" href="<%=ADDRESS_EDIT_URL%>" class="btn btn-primary btn-xs">编辑</a></td>
								</tr>
                            </c:forEach>
							</tbody>
						</table>
						<div class="text-right">
							<button class="btn btn-danger" id="delBtn">删除地址</button>
							<a href="<%=ADDRESS_ADD_URL%>" class="btn btn-primary">增加新地址</a>
						</div>
					</div>
					<div class="panel-footer">
						<jsp:include page="/pages/plugins/alert.jsp"/>
					</div>
				</div>
			</div>
		</div>
		<div id="footDiv" class="row navbar-fixed-bottom">
			<jsp:include page="/pages/plugins/front/include_title_foot.jsp" />
		</div>
	</div>
</body>
</html>