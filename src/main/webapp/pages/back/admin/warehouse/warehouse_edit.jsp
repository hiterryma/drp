<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/warehouse/warehouse_edit.js"></script>
</head>
<%!
	public static final String WAREHOUSE_EDIT_URL = "/pages/back/admin/warehouse/warehouse_edit.action" ;
%>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="1"/>
			<jsp:param name="msi" value="12"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-info">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;编辑仓库信息</strong>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="<%=WAREHOUSE_EDIT_URL%>" id="myform" method="post" enctype="multipart/form-data">
						<fieldset>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="nameDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="name">仓库名称：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="name" name="name" class="form-control"
										placeholder="请输入仓库标记名称" value="${warehouse.name}">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="eidMsg"></div>
							</div>
							<div class="form-group" id="pidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="pid">所在省份：</label>
								<div class="col-md-5">
									<select id="pid" name="pid" class="form-control">
										<option value="">====== 请选择所在省份 ======</option>
										<%--<option value="1">河北省</option>
										<option value="2">山西部</option>
										<option value="3">广东省</option>--%>
										<c:forEach items="${allProvinces}" var="province">
											<option value="${province.pid}" ${province.pid==warehouse.pid?"selected":""}>${province.title}</option>
										</c:forEach>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="pidMsg"></div>
							</div>
							<div class="form-group" id="cidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="cid">所在城市：</label>
								<div class="col-md-5">
									<select id="cid" name="cid" class="form-control">
										<option value="">====== 请选择所在省份 ======</option>
										<%--<option value="1">石家庄</option>
										<option value="2">沧州</option>
										<option value="3">邯郸</option>--%>
										<c:forEach items="${allCitys}" var="city">
											<option value="${city.cid}" ${city.cid==warehouse.cid?"selected":""}>${city.title}</option>
										</c:forEach>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="cidMsg"></div>
							</div>
							<div class="form-group" id="addressDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="address">仓库地址：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="address" name="address" class="form-control"
										placeholder="请输入仓库地址信息" value="${warehouse.address}">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="addressMsg"></div>
							</div>
							<div class="form-group" id="areaDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="area">仓库面积：</label>
								<div class="col-md-5">
									<input type="text" id="area" name="area" class="form-control"
										placeholder="请输入仓库实际使用面积" value="${warehouse.area}">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="areaMsg"></div>
							</div>
							<div class="form-group" id="wiidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="wiid">仓库用途：</label>
								<div class="col-md-5">
									<select id="wiid" name="wiid" class="form-control">
										<option value="">====== 请选择库存商品类型 ======</option>
										<%--<option value="1">服装</option>
										<option value="2">家电</option>
										<option value="3">电子</option>--%>
										<c:forEach items="${allWitems}" var="witem">
											<option value="${witem.wiid}" ${witem.wiid==warehouse.wiid?"selected":""}>${witem.title}</option>
										</c:forEach>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="wiidMsg"></div>
							</div>
							<div class="form-group" id="maximumDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="maximum">最大存储数量：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="maximum" name="maximum" class="form-control"
										placeholder="请输入本仓库最大允许保存商品数量" value="${warehouse.maximum}">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="maximumMsg"></div>
							</div>
							<div class="form-group" id="photoDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="photo">仓库照片：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="file" id="photo" name="photo" class="form-control"
										placeholder="请上传该仓库照片，如不修改可以不上传">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="photoMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="note">仓库备注信息：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<textarea id="note" name="note"
										class="form-control" placeholder="请输入仓库的详细信息" rows="10" value="">${warehouse.note}</textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="noteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<input type="hidden" name="pic" id="pic" value="${warehouse.photo}">
									<input type="hidden" name="wid" id="wid" value="${warehouse.wid}">
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
