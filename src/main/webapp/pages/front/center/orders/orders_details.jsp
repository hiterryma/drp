<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/front/center/orders/orders_list.js"></script>
	<script type="text/javascript" src="js/pages/front/center/orders/orders_details_show.js"></script>
</head>
<%!
	public static final String GOODS_SHOW_URL = "pages/front/goods/goods_show.jsp" ;
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
					<jsp:param value="1" name="ch"/>
				</jsp:include>
			</div>
			<div class="col-md-10 col-xs-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;订单详情</strong>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3"><strong>订单编号：</strong></div>
							<div class="col-md-9 col-md-pull-1">${orders.oid}</div>
						</div>
						<div class="row">
							<div class="col-md-3"><strong>收件人：</strong></div>
							<div class="col-md-9 col-md-pull-1">${address.receiver}</div>
						</div>
						<div class="row">
							<div class="col-md-3"><strong>联系电话：</strong></div>
							<div class="col-md-9 col-md-pull-1">${address.phone}</div>
						</div>
						<div class="row">
							<div class="col-md-3"><strong>配送地址：</strong></div>
							<div class="col-md-9 col-md-pull-1">${address.addr}</div>
						</div>
						<div class="row">
							<div class="col-md-3"><strong>下单日期：</strong></div>
							<div class="col-md-9 col-md-pull-1">${orders.subdate}</div>
						</div>
						<div class="row">
							<div class="col-md-3"><strong>总金额：</strong></div>
							<div class="col-md-9 col-md-pull-1">${orders.price}</div>
						</div>
						<div class="row">
							<div class="col-md-3"><strong>购买商品总数：</strong></div>
							<div class="col-md-9 col-md-pull-1" id="allAmount">6</div>
						</div>
						<div class="row">
							<table class="table table-condensed">
							<thead>
								<tr>
									<th class="text-center"><strong>商品名称</strong></th>
									<th class="text-center"><strong>价格</strong></th>
									<th class="text-center"><strong>购买数量</strong></th>
									<th class="text-center"><strong>总额</strong></th>
								</tr>
							</thead>
							<tbody>

							<c:forEach items="${allGoods}" var="goods">
								<tr>
									<td class="text-center">
										<a href="<%=GOODS_SHOW_URL%>" onmouseover="this.style.cursor='hand'">${goods.name}</a>
									</td>
									<td class="text-center">${goods.price}</td>
									<td class="text-center" id="amount-"+${goods.gid}>${details[goods.gid]}</td>
									<td class="text-center" >${goods.price*details[goods.gid]}</td>
								</tr>
							</c:forEach>

							</tbody>
						</table>
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