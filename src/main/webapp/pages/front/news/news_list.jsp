<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:include page="/pages/plugins/basepath.jsp"/>
    <script type="text/javascript" src="js/pages/front/news/news_list.js"></script>
</head>
<body>
<div class="container contentback" >
    <div id="navbarDiv" class="row">
        <jsp:include page="/pages/plugins/front/include_navbar.jsp"/>
    </div>
    <div id="splitDiv" class="row">
        <div class="col-md-12" style="height:50px;"></div>
    </div>
    <div id="adDiv" class="row">
        <div class="col-md-12 col-xs-12">
            <jsp:include page="/pages/plugins/front/include_ad.jsp" />
        </div>
    </div>
    <div id="newsDiv" class="row">
        <div class="col-md-12">
            <div class="panel panel-info">
                <div class="panel-heading"><strong><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;公司要闻</strong></div>
                <div class="panel-body">
                    <ul>
                        <c:forEach items="${allNews}" var="news">
                            <li><a href="pages/back/admin/news/news_show.action?nid=${news.nid}"><span class="glyphicon glyphicon-exclamation-sign text-danger"></span>${news.title}</a></li>
                        </c:forEach>
                    </ul>
                    <jsp:include page="/pages/plugins/split_page_bar_plugin.jsp"/>
                </div>
                <div class="panel-footer">
                </div>
            </div>
        </div>
    </div>
    <div id="footDiv" class="text-left">
        <jsp:include page="/pages/plugins/front/include_title_foot.jsp"/>
    </div>
</div>
</body>
</html>