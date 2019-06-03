<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%!
	public static final String DISTRIBUTION_ADD_URL = "/pages/back/admin/distribution/distribution_showpc.action" ;
%>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/distribution/distribution_goods_list.js"></script>
	<script type="text/javascript" src="js/split_page.js"></script>
	<script type="text/javascript" src="js/pages/back/index.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="7"/>
			<jsp:param name="msi" value="71"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;待出库清单</strong>
			</div>
			<div class="panel-body">
				<div>
					<table class="table table-striped table-bordered table-hover">
						<tr> 
							<td style="width:150px;"><strong>客户姓名：</strong></td>
							<td>${customer.name}</td>
						</tr>
						<tr>
							<td><strong>客户联系电话：</strong></td>
							<td>${customer.phone}</td>
						</tr>
						<tr>
							<td><strong>客户重要性：</strong></td>
							<td><span class="text-danger">${citem.title}</span></td>
						</tr>
						<tr>
							<td><strong>客户备注信息：</strong></td> 
							<td>
								<pre class="pre-scrollable" style="width:900px;height:60px;">${customer.note}</pre>
							</td>
						</tr>
					</table>
				</div>
				<div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center" style="width:5%">
									<input type="checkbox" id="selectAll">
								</th>
								<th class="text-center" style="width:5%"><strong>图片</strong></th>
								<th class="text-left" style="width:50%"><strong>商品</strong></th>
								<th class="text-center" style="width:10%"><strong>单价</strong></th>
								<th class="text-center" style="width:10%"><strong>库存</strong></th>
								<th class="text-center" style="width:20%"><strong>数量</strong></th>
								<th class="text-center" style="width:10%"><strong>操作</strong></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${allGoods}" var="goods" varStatus="status">
							<tr id="goods-${status.index+1}">
								<td class="text-center">
									<input type="checkbox" id="gid" name="gid" value="1">
								</td>
								<td class="text-center"><img src="http://upload-server/upload/${goods.photo}" style="width:30px;"></td>
								<td class="text-left">${goods.name}</td>
								<td class="text-center"><span id="price-${status.index+1}">${goods.price}</span></td>
								<td class="text-center">${goods.stornum}</td>
								<td class="text-center">
									<button class="btn btn-primary" id="sub-${status.index+1}">-</button>
									<input type="text" id="amount-${status.index+1}" name="amount-${status.index+1}" class="shopcar-form-control" size="4" maxlength="4" value="0">
									<button class="btn btn-primary" id="add-${status.index+1}">+</button>
								</td>
								<td class="text-center"><button class="btn btn-primary" id="updateBtn-${status.index+1}">修改</button></td>
							</tr>
						</c:forEach>
						<!--
							<tr id="goods-2"> 
								<td class="text-center">
									<input type="checkbox" id="gid" name="gid" value="2">
								</td>
								<td class="text-center"><img src="images/goods.png" style="width:30px;"></td>
								<td class="text-left">胡友牌化粪池</td>
								<td class="text-center"><span id="price-2">279.8</span></td>
								<td class="text-center">3000</td>
								<td class="text-center">
									<button class="btn btn-primary" id="sub-2">-</button>
									<input type="text" id="amount-2" name="amount-2" class="shopcar-form-control" size="4" maxlength="4" value="20">
									<button class="btn btn-primary" id="add-2">+</button> 
								</td>
								<td class="text-center"><button class="btn btn-primary" id="updateBtn-2">修改</button></td>
							</tr>
							-->
						</tbody>
					</table>
				</div>
				<div class="text-right">
					总价￥<span id="allPrice" class="text-danger h2">78.9</span>
				</div>
				<div>
					<button class="btn btn-primary" id="editBtn"><span class="glyphicon glyphicon-pencil"></span>&nbsp;修改数量</button>
					<button class="btn btn-danger" id="rmBtn"><span class="glyphicon glyphicon-remove"></span>&nbsp;移出清单</button>
					<a class="btn btn-success" href="<%=DISTRIBUTION_ADD_URL%>?cuid=${customer.cuid}" id="createBtn"><span class="glyphicon glyphicon-file"></span>&nbsp;创建出库申请单</a>
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
	<jsp:include page="/pages/plugins/back/modal/goods_storage_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
</body>
</html>
