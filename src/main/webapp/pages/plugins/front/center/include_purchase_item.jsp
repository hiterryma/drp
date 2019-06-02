<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%!
    public static final String CUSTOMER_AUTHENTICATION_URL = "pages/front/center/purchase/purchase_authentication_list.action";
    public static final String PURCHASE_ADD_URL = "/pages/front/center/purchase/purchase_add_list.action";
    public static final String PURCHASE_LIST_URL = "/pages/front/center/purchase/add_list.action";
%>
<script type="text/javascript" src="js/pages/front/center/purchase/purchase.js"></script>
<ul class="nav nav-pills nav-stacked"><!-- 定义导航 -->
    <li id="authentication" class="${param.ch == 1 ? "active" : ""}"><a href="<%=CUSTOMER_AUTHENTICATION_URL%>">客户认证</a></li>
    <!-- 活跃导航项 -->
    <li id="purchaseRequest" class="${param.ch == 2 ? "active" : ""}"><a href="<%=PURCHASE_ADD_URL%>">采购申请单</a></li>
    <li id="list" class="${param.ch == 3 ? "active" : ""}"><a href="<%=PURCHASE_LIST_URL%>">采购订单</a></li>
</ul>
