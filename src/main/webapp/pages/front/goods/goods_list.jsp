<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <jsp:include page="/pages/plugins/basepath.jsp"/>
    <script type="text/javascript" src="js/pages/front/goods/goods_list.js"></script>
</head>
<%!
    public static final String GOODS_SHOW_URL = "pages/front/goods/goods_show.jsp";
%>
<body>
<div class="container contentback">
    <div id="headDiv" class="row">
        <div class="col-md-12 col-xs-12">
            <jsp:include page="/pages/plugins/front/include_navbar.jsp"/>
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
                        <jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
                    </div>

                    <div class="row" >
                        <c:forEach items="${allLists}" var="list">
                            <div class="col-md-3 text-center" id="goodsList">
                                <p>
                                    <a href="<%=GOODS_SHOW_URL%>">
                                        <img id="goodsList_img" src="images/${list.photo}" style="width:100px;"></a></p>
                                <span id="goodsList_span" class="text-warning h4">￥<strong>${list.price}</strong></span>
                                <p><a id="goodsList_a" href="<%=GOODS_SHOW_URL%>">${list.name}</a></p>
                                <button id="addCar-1" class="btn btn-primary btn-xs">
                                    <span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;加入购物车
                                </button>
                            </div>
                        </c:forEach>
                    </div>

                    <div id="splitBarDiv" style="float:right">
                        <jsp:include page="/pages/plugins/split_page_bar_plugin.jsp"/>
                    </div>
                </div>
                <div class="panel-footer">
                    <jsp:include page="/pages/plugins/alert.jsp"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="height:50px;">
        <jsp:include page="/pages/plugins/alert.jsp"/>
    </div>
    <div id="footDiv" class="row navbar-fixed-bottom">
        <jsp:include page="/pages/plugins/front/include_title_foot.jsp"/>
    </div>
</div>
</body>
</html>