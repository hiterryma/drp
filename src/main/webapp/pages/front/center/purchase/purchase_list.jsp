<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <jsp:include page="/pages/plugins/basepath.jsp"/>
    <script type="text/javascript" src="js/pages/front/center/purchase/purchase_list.js"></script>
</head>
<%!
    public static final String PURCHASE_DETAILS_URL = "pages/front/center/purchase/purchase_details.jsp";
%>
<body class="back">
<div class="container contentback">
    <div id="headDiv" class="row">
        <div class="col-md-12 col-xs-12">
            <jsp:include page="/pages/plugins/front/include_navbar.jsp"/>
        </div>
    </div>
    <div style="height: 60px;"></div>
    <div id="contentDiv" class="row">
        <div class="col-md-2 col-xs-2">
            <jsp:include page="/pages/plugins/front/center/include_purchase_item.jsp">
                <jsp:param value="3" name="ch"/>
            </jsp:include>
        </div>
        <div class="col-md-10 col-xs-10">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <strong><span class="glyphicon glyphicon-edit"></span>&nbsp;采购申请单</strong>
                </div>
                <div class="panel-body">
                    <table class="table table-condensed">
                        <thead>
                        <tr>
                            <th class="text-center"><strong>采购申请单</strong></th>
                            <th class="text-center"><strong>提交日期</strong></th>
                            <th class="text-center"><strong>备注</strong></th>
                            <th class="text-center"><strong>处理状态</strong></th>
                        </tr>
                        </thead>


                        <tbody>
                        <c:forEach items="${allPurchase}" var="purchase">
                            <tr>
                                <td class="text-center">
                                    <a type="button" href="<%=PURCHASE_DETAILS_URL%>">
                                        <span class="glyphicon glyphicon-list-alt"></span>&nbsp;${purchase.title}</a>
                                </td>
                                <td class="text-center">${purchase.subdate}</td>
                                <td class="text-left">${purchase.note}</td>
                                <c:if test="${purchase.state == 0}">
                                    <td class="text-center"><span class="text-danger">审核失败</span></td>
                                </c:if>
                                <c:if test="${purchase.state == 1}">
                                    <td class="text-center"><span class="text-success">正在处理</span></td>
                                </c:if>
                                <c:if test="${purchase.state == 2}">
                                    <td class="text-center"><span class="text-info">审核通过</span></td>
                                </c:if>
                                <c:if test="${purchase.state > 2}">
                                    <td class="text-center"><span class="text-warning">人工审核</span></td>
                                </c:if>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="panel-footer">
                    <jsp:include page="/pages/plugins/alert.jsp"/>
                </div>
            </div>
        </div>
    </div>
    <div id="footDiv" class="row navbar-fixed-bottom">
        <jsp:include page="/pages/plugins/front/include_title_foot.jsp"/>
    </div>
</div>
</body>
</html>