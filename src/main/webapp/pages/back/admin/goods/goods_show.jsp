<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/goods/goods_show.js"></script>
	<script type="text/javascript" src="js/split_page.js"></script>
</head>
<%!
	public static final String GOODS_EDIT_URL = "" ;
%>
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
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;编辑商品信息</strong>
				</div>
				<div class="panel-body">
					<div>
						<table class="table table-condensed" >
							<tr>
								<td style="width:20%;"><strong>商品编号：</strong></td> 
								<td><span>${goodsShow.gid}</span></td>
								<td><strong>商品图片：</strong></td>
							</tr>
							<tr>
								<td><strong>商品名称：</strong></td>
								<td><span>${goodsShow.name}</span></td>
								<td rowspan="7"><img src="http://43.226.146.219/upload/${goodsShow.photo}" style="height:300px;"></td>
							</tr>
							<tr>
								<td><strong>入库次数：</strong></td>
								<td>未知</td>
							</tr>
							<tr>
								<td><strong>商品库存量：</strong></td>
								<td>${goodsShow.stornum}（
									<button id="storage-1" class="btn btn-danger btn-xs">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;库存详情</button>）</td>
							</tr>
							<tr>
								<td><strong>当前商品价格（￥）：</strong></td>
								<td>${goodsShow.price}</td>
							</tr>
							<tr>
								<td><strong>当前商品重量（G）：</strong></td>
								<td>${goodsShow.weight}</td>
							</tr>
							<tr>
								<td><strong>最后入库日期：</strong></td>
								<td>${goodsShow.lastin}</td>
							</tr>
							<tr>
								<td><strong>备注信息：</strong></td>
								<td><pre class="pre-scrollable" style="width:700px;height:150px;">${goodsShow.note}</pre></td>
							</tr>
						</table>
					</div>
					<div class="panel-group" id="storageDetails" value="${goodsShow.gid}">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h4 class="panel-title"> 
									<a data-toggle="collapse" data-parent="news" href="#contentOne">
										<strong><span class="glyphicon glyphicon-user"></span>&nbsp;商品库存详情：</strong>
									</a>
								</h4>
							</div>
							<div id="contentOne" class="panel-collapse collapse"> 
								<div class="panel-body">
									<table class="table table-condensed">
										<thead>
											<tr>
												<th class="text-center" style="width:10%;">入库日期</th> 
												<th class="text-left" style="width:40%;">仓库</th> 
												<th class="text-center" style="width:10%;">入库人员</th> 
												<th class="text-center" style="width:10%;">审核人员</th> 
												<th class="text-center" style="width:10%;">库存数量</th>
											</tr>
										</thead>
										<tbody>
											<tr class="text-primary">
												<td class="text-center">${goodsShow.lastin}</td>
												<td class="text-left">${goodsWid.address}</td>
												<td class="text-center"><span id="mid_${voStorage.mid}" style="cursor:pointer;">${voStorage.name}</span></td>
												<td class="text-center"><span id="mid_${voAudit.mid}" style="cursor:pointer;">${voAudit.name}</span></td>
												<td class="text-center">${goodsShow.stornum}</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
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
<jsp:include page="/pages/plugins/footer.jsp"/>
