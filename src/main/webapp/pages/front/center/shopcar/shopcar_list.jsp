<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/front/center/shopcar/shopcar_list.js"></script>
</head>
<%!
	public static final String GOODS_SHOW_URL = "pages/front/goods/goods_show.jsp" ;
%>
<%
	String orders_add_url = "/pages/front/center/orders/orders_add_pre.action" ;
%>
<body class="back">
	<div class="container contentback">
		<div id="headDiv" class="row">
			<div class="col-md-12 col-xs-12">
				<jsp:include page="/pages/plugins/front/include_navbar.jsp" />
			</div>
		</div>
		<div style="height: 60px;"></div> 
		<div id="contentDiv" class="row">
			<div class="col-md-2 col-xs-2">
				<jsp:include page="/pages/plugins/front/center/include_center_item.jsp">
					<jsp:param value="4" name="ch"/>
				</jsp:include>
			</div>
			<div class="col-md-10 col-xs-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<strong><span class="glyphicon glyphicon-list"></span>&nbsp;我的购物车</strong>
					</div>
					<div class="panel-body">
						<form action="<%=orders_add_url%>" method="post">
						<table class="table table-condensed">
							<thead>
								<tr>
									<th class="text-center">
										<input type="checkbox" id="selectAll">
									</th>
									<th class="text-center"><strong>商品名称</strong></th>
									<th class="text-center"><strong>商品单价</strong></th>
									<th class="text-center"><strong>购买数量</strong></th>
									<th class="text-center"><strong>操作</strong></th>
								</tr>
							</thead>
							<tbody>
                            ${adid}
							<c:forEach items="${allGoods}" var="goods">
								<tr id="shopcar-${goods.gid}">
									<td class="text-center">
										<input type="checkbox" id="gid" name="gid" value="${goods.gid}">
									</td>
									<td class="text-center">
										<a href="<%=GOODS_SHOW_URL%>" onmouseover="this.style.cursor='hand'">${goods.name}</a>
									</td>
									<td class="text-center"><span id="price-${goods.gid}">${goods.price}</span></td>
									<td class="text-center">
										<button class="btn btn-primary" type="button"  id="sub-${goods.gid}">-</button>
										<input type="text" id="amount-${goods.gid}" name="amount-${goods.gid}" class="shopcar-form-control" size="4" maxlength="4" value="${shopcar[goods.gid]}">
										<button class="btn btn-primary" type="button"  id="add-${goods.gid}">+</button>
									</td>
									<td class="text-center"><button class="btn btn-primary" type="button"  id="updateBtn-${goods.gid}">修改</button></td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<div class="text-right">
							总价￥<span id="allPrice" class="text-danger h2">80</span>
						</div>
						<div>
							<button class="btn btn-primary"  type="button" id="editBtn"><span class="glyphicon glyphicon-pencil"></span>&nbsp;修改数量</button>
							<button class="btn btn-danger"  type="button" id="rmBtn"><span class="glyphicon glyphicon-remove"></span>&nbsp;移出购物车</button>
							<button class="btn btn-success" type="submit" id="addBtn"><span class="glyphicon glyphicon-file"></span>&nbsp;下单</button>
						</div>
						</form>
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