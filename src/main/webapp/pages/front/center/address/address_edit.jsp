<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/front/center/address/address_edit.js"></script>
</head>
<%!
	public static final String ADDRESS_EDIT_URL = "pages/front/center/address/address_edit.action" ;
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
					<jsp:param value="5" name="ch"/>
				</jsp:include>
			</div>
			<div class="col-md-10 col-xs-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<strong><span class="glyphicon glyphicon-pencil"></span>&nbsp;编辑联系地址</strong>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" action="<%=ADDRESS_EDIT_URL%>" id="myform" method="post">
							<fieldset>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="nameDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="receiver">收件人：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="receiver" name="receiver" class="form-control"
											placeholder="请输入收件人姓名" value="">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="nameMsg"></div>
								</div>
								<div class="form-group" id="phoneDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="phone">联系电话：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="phone" name="phone" class="form-control"
											placeholder="请输入您的联系电话" value="">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="phoneMsg"></div>
								</div>
								<div class="form-group" id="pidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="pid">省份：</label>
									<div class="col-md-5">
										<select id="pid" name="pid" class="form-control">
											<c:forEach items="${allProvinces}" var="province">
												<option value="${province.pid}">${province.title}</option>
											</c:forEach>
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="pidMsg"></div>
								</div>
								<div class="form-group" id="cidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="cid">城市：</label>
									<div class="col-md-5">
										<select id="cid" name="cid" class="form-control">
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="cidMsg"></div>
								</div>
								<div class="form-group" id="addrDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="addr">地址：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="addr" name="addr" class="form-control"
											placeholder="请输入您的联系地址" value="">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="addrMsg"></div>
								</div>
								<div class="form-group">
									<div class="col-md-5 col-md-offset-3">
<%--										<input type="hidden" id="goods.gid" name="goods.gid" value="1">--%>
										<button type="submit" class="btn btn-primary">修改</button>
										<button type="reset" class="btn btn-warning">重置</button>
									</div>
								</div>
							</fieldset>
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
