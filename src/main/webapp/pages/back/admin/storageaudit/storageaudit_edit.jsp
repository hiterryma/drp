<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/storageaudit/storageaudit_edit.js"></script>
	<script type="text/javascript" src="js/split_page.js"></script>
	<script type="text/javascript" src="js/pages/back/index.js"></script>
</head>
<%!
	public static final String STORAGEAUDIT_EDIT_URL = "/pages/back/admin/audit/audit_add.action" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="4"/>
			<jsp:param name="msi" value="42"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;入库清单审核</strong>
			</div>
			<div class="panel-body">
				<div>
					<table class="table table-striped table-bordered table-hover">
						<tr> 
							<td style="width:150px;"><strong>入库标题：</strong></td>
							<td>${storage_apply.title}</td>
						</tr>
						<tr>
							<td><strong>存入仓库名称：</strong></td>
							<td><span id="showWarehouse" style="cursor:pointer;">${title}</span></td>
						</tr>
						<tr>
							<td><strong>仓库类型：</strong></td>
							<td>${witem.title}</td>
						</tr>
						<tr>
							<td><strong>仓库当前容量：</strong></td>
							<td>${warehouse.maximum-warehouse.currnum}</td>
						</tr>
						<tr>
							<td><strong>申请人：</strong></td>
							<td><span id="showMember" style="cursor:pointer;">${member.name}</span></td>
						</tr>
						<tr>
							<td><strong>入库商品总价：</strong></td>
							<td>${totalprice}</td>
						</tr>
						<tr>
							<td><strong>入库单备注信息：</strong></td>
							<td>${storage_apply.note}</td>
						</tr>
						<tr>
							<td><strong>审核历史：</strong></td>
							<td>
								<c:forEach items="${allAudit}" var="audit">
									${audit.aud_date}&nbsp;:&nbsp;${audit.aud_note}<br>

								</c:forEach>
							</td>
						</tr>
					</table>
				</div>
				<div>
					<form class="form-horizontal" action="<%=STORAGEAUDIT_EDIT_URL%>" id="myform" method="post">
						<fieldset>
							<input type="hidden" name="said" value="${storage_apply.said}">
							<div class="form-group" id="auditDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="audit">审核结论：</label>
								<div class="col-md-5">
									<div class="radio-inline">
										<label><input type="radio" id="audit" name="audit_result" value="0" >
											&nbsp;<span class="text-danger">拒绝</span></label>
									</div> 
									<div class="radio-inline">
										<label><input type="radio" id="audit" name="audit_result" value="1">
											&nbsp;<span class="text-success">通过</span></label>
									</div> 
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="auditMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="note">审核备注：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<textarea id="note" name="audit_note" rows="3"
										class="form-control" placeholder="请输入审核所给出的意见信息" rows="10"></textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="noteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary">增加</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
				<div class="panel-group" id="news">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4 class="panel-title"> 
								<a data-toggle="collapse" data-parent="news" href="#contentOne">
									<strong><span class="glyphicon glyphicon-user"></span>&nbsp;入库商品清单：</strong>
								</a>
							</h4>
						</div>
						<div id="contentOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<table class="table table-condensed">
									<thead>
										<tr>
											<th class="text-center" style="width:10%;">商品编号</th> 
											<th class="text-left" style="width:40%;">商品名称</th> 
											<th class="text-center" style="width:10%;">入库数量</th>
											<th class="text-center" style="width:15%;">商品单价（￥）</th>
											<th class="text-center" style="width:15%;">单位重量（g）</th>
											<th class="text-center" style="width:10%;">总价（￥）</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${allStorage_apply_details}" var="storage_apply_details" >
										<tr class="text-primary">
											<td class="text-center">${storage_apply_details.gid}</td>
											<td class="text-left">${storage_apply_details.name}</td>
											<td class="text-center">${storage_apply_details.num}</td>
											<td class="text-center">${pricemap[storage_apply_details.sadid]}</td>
											<td class="text-center">${weightmap[storage_apply_details.sadid]}</td>
											<td class="text-center">${storage_apply_details.price}</td>
										</tr>
									</c:forEach>
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
	<jsp:include page="/pages/plugins/back/modal/warehouse_info_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/footer.jsp"/>
