<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<<script type="text/javascript" src="js/pages/back/admin/storage/storage_edit.js"></script>
	<script type="text/javascript" src="js/split_page.js"></script>
	<script type="text/javascript" src="js/pages/back/index.js"></script>
</head>
<%!
	public static final String STORAGE_EDIT_URL = "/pages/back/admin/storage/storage_edit.action" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="3"/>
			<jsp:param name="msi" value="32"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-info">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;编辑商品入库单</strong>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="<%=STORAGE_EDIT_URL%>" id="myform" method="post">
						<fieldset>
							<input type="hidden" name="said" value="${storage_apply.said}">
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="titleDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="title">申请单标题：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="title" name="title" class="form-control"
										value="${storage_apply.title}">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="titleMsg"></div>
							</div>
							<div class="form-group" id="pidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="pid">入库省份：</label>
								<div class="col-md-5">
									<select id="pid" name="pid" class="form-control">
										<option value="">====== 请选择所在省份 ======</option>
										<!--
										<option value="1">河北省</option>
										<option value="2">山西部</option>
										<option value="3">广东省</option>
										<option value=" selected="selected">已付款</option>
				                <option value="未付款">未付款</option>
										-->


										<c:forEach items="${allProvinces}" var="province">
											<c:if test="${ storage_apply.pid== province.pid}">
											<option value="${province.pid}" selected="selected">${province.title}</option>
											</c:if>
											<option value="${province.pid}" >${province.title}</option>
										</c:forEach>

					            


									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="pidMsg"></div>
							</div>
							<div class="form-group" id="cidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="cid">入库城市：</label>
								<div class="col-md-5">
									<select id="cid" name="cid" class="form-control">
										<option value="">====== 请选择所在城市 ======</option>
										<option value="${city.cid}" selected="selected">${city.title}</option>
										<!--
										<option value="1">石家庄</option>
										<option value="2">沧州</option>
										<option value="3">邯郸</option>
										-->
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="cidMsg"></div>
							</div>
							<div class="form-group" id="iidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="iid">商品类型：</label>
								<div class="col-md-5">
									<select id="iid" name="wiid" class="form-control">
										<option value="">====== 请选择库存商品类型 ======</option>
										<!--
										<option value="1">服装</option>
										<option value="2">家电</option>
										<option value="3">电子</option>
										-->
										<c:forEach items="${allWitems}" var="witem">
											<c:if test="${ witem.wiid == storage_apply.wiid}">
												<option value="${witem.wiid}" selected="selected">${witem.title}</option>
											</c:if>
											<option value="${witem.wiid}">${witem.title}</option>
										</c:forEach>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="iidMsg"></div>
							</div>
							<div class="form-group" id="widDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="wid">选择仓库：</label>
								<div class="col-md-5">
									<select id="wid" name="wid" class="form-control">
										<!--
										<option value="">====== 请选择要存储的仓库 ======</option>
										<option value="1">通州一号仓库</option>
										<option value="2">通州二号仓库</option>
										<option value="3">通州三号仓库</option>
										-->
										<option value="${warehouse.wid}" selected="selected">${warehouse.name}</option>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="widMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="note">入库单备注信息：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<textarea id="note" name="note"
										class="form-control" placeholder="请输入仓库的详细信息" rows="10">${storage_apply.note}</textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="noteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary">编辑</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
							</div>
						</fieldset>
					</form>
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
<jsp:include page="/pages/plugins/footer.jsp"/>
