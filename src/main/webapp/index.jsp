<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<html>
<head>
    <jsp:include page="/pages/plugins/basepath.jsp"/>
    <script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<div class="container contentback" >
    <div id="navbarDiv" class="row">
        <jsp:include page="/pages/plugins/front/include_navbar.jsp"/>
    </div>
    <div style="height: 2px;"></div>
    <div id="splitDiv" class="row">
        <div class="col-md-12" style="height:50px;"></div>
    </div>
    <div id="adDiv" class="row">
        <div class="col-md-12 col-xs-12">
            <jsp:include page="/pages/plugins/front/include_ad.jsp" />
        </div>
    </div>
    <div style="height: 2px;"></div>
    <div id="newsDiv" class="row">
        <div class="col-md-8">
            <div class="panel panel-info">
                <div class="panel-heading"><strong><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;公司要闻</strong></div>
                <div class="panel-body">
                    <ul>
                    </ul>
                </div>
                <div class="panel-footer text-right">
                    <a href="pages/front/news/news_list.action">
                        <span class="glyphicon glyphicon-list-alt"></span>&nbsp;更多内容...
                    </a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div id="butDiv" class="row">
                <jsp:include page="/pages/plugins/front/include_but_img.jsp"/>
            </div>
        </div>
    </div>
    <div id="footDiv" class="col-md-12">
        <jsp:include page="/pages/plugins/front/include_title_foot.jsp"/>
    </div>
</div>
</body>
</html>