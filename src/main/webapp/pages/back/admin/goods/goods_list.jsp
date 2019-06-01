<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%!
	public static final String GOODS_EDIT_URL = "pages/back/admin/goods/goods_pre_edit.action" ;
	public static final String GOODS_SHOW_URL = "/pages/back/admin/goods/goods_show.action?gid=" ;
%>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/goods/goods_list.js"></script>
	<script type="text/javascript" src="js/split_page.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="5"/>
			<jsp:param name="msi" value="52"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;商品信息列表</strong>
			</div>
			<div class="panel-body">
				<div>
					<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				</div>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-left" style="width:10%;">商品编号</th> 
							<th class="text-left" style="width:25%;">商品名称</th>
							<th class="text-center" style="width:10%;">单价（￥）</th>
							<th class="text-center" style="width:10%;">重量（g）</th>
							<th class="text-center" style="width:10%;">最近入库日期</th>
							<th class="text-center" style="width:10%;">库存量</th>
							<th class="text-center" style="width:10%;">录入员工</th>
							<th class="text-left" style="width:20%;">操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${allGoods}" var="goods">
						<tr>
							<td class="text-left">${goods.gid}</td>
							<td class="text-left"><a href="<%=GOODS_SHOW_URL%>${goods.gid}" title="查看商品详情">${goods.name}</a></td>
							<td class="text-center">${goods.price}</td>
							<td class="text-center">${goods.weight}g</td>
							<td class="text-center">${goods.lastin}</td>
							<td class="text-center"><span id="storage-${goods.gid}" style="cursor:pointer;">${goods.stornum}</span></td>
							<td class="text-center"><span id="mid_${goods.recorder}" style="cursor:pointer;">${allMemberMap.get(goods.recorder)}</span></td>
							<td class="text-left">
								<a href="<%=GOODS_EDIT_URL%>?gid=${goods.gid}" class="btn btn-primary btn-xs">
									<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
								<button class="btn btn-danger btn-xs" id="out-${goods.gid}">
									<span class="glyphicon glyphicon-ok-circle"></span>&nbsp;待出库</button>
							</td>
						</tr>
					</c:forEach>
					<%--<tr>
                        <td class="text-left">100001</td>
                        <td class="text-left"><a href="<%=GOODS_SHOW_URL%>" title="查看商品详情">胡友牌化粪池</a></td>
                        <td class="text-center">4456</td>
                        <td class="text-center">200g</td>
                        <td class="text-center">2018-10-13</td>
                        <td class="text-center"><span id="storage-1" style="cursor:pointer;">3000</span></td>
                        <td class="text-center"><span id="mid-admin" style="cursor:pointer;">老李</span></td>
                        <td class="text-left">
                            <a href="<%=GOODS_EDIT_URL%>?gid=1" class="btn btn-primary btn-xs">
                                    <span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
                            <button class="btn btn-danger btn-xs" id="out-1">
                                    <span class="glyphicon glyphicon-ok-circle"></span>&nbsp;待出库</button>
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
	<jsp:include page="/pages/plugins/back/modal/goods_storage_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
</body>
</html>
