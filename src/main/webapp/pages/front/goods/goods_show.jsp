<%@ page language="java" pageEncoding="UTF-8"%>

<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/front/goods/goods_show.js"></script>
</head>

<body class="back">
	<div class="container contentback">
		<div id="headDiv" class="row">
			<div class="col-md-12 col-xs-12">
				<jsp:include page="/pages/plugins/front/include_navbar.jsp" />
			</div>
		</div>
		<div style="height: 60px;"></div> 
		<div id="contentDiv" class="row">
			<div class="col-md-12 col-xs-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<strong><span class="glyphicon glyphicon-edit"></span>&nbsp;商品信息</strong>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-2 text-center"> 
								<p><img class="img" src="http://upload-server/upload/${getGoods.photo}" style="width:125px;"></p>
								<button id="addCar-1" class="btn btn-lg btn-danger">
									<span class="glyphicon glyphicon-eye-open"></span>&nbsp;加入购物车</button>
							</div>
							<div class="col-md-10">
								<div class="row">
									<div class="col-md-2 h3"><strong>商品名称：</strong></div>
									<div class="col-md-3 h3">${getGoods.name}</div>
								</div>
								<div class="row">
									<div class="col-md-2 h3"><strong>商品价格：</strong></div>
									<div class="col-md-3 h3">￥${getGoods.price}</div>
								</div>
								<div class="row"> 
									<div class="col-md-12">
										${getGoods.note}<br>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<div class="row" style="height:50px;">
							<jsp:include page="/pages/plugins/alert.jsp"/>
						</div>
					</div>
					<div id="footDiv" class="row navbar-fixed-bottom">
						<jsp:include page="/pages/plugins/front/include_title_foot.jsp" />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
