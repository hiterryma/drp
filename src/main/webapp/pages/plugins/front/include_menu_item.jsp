<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%!
     public static final String GOODS_LIST_URL = "/pages/back/admin/goods/goods_subaru.action";
    //public static final String GOODS_LIST_URL = "/pages/front/goods/goods_list.jsp";
%>
<div class="panel-group" id="item">        <!-- 利用面板定义折叠组件 -->
    <c:forEach items="${allWitems}" var="witem">
        <c:if test="${witem.wiid == 1}">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#item" href="#content-${witem.wiid}">
                                ${witem.title}
                        </a>
                    </h4>
                </div>
                <div id="content-${witem.wiid}" class="panel-collapse collapse in">        <!-- 面板默认显示 -->
                    <div class="panel-body">
                        <div class="row">
                            <c:forEach items="${allSubtypes}" var="subtype">
                                <c:if test="${subtype.wiid == witem.wiid}">
                                    <div class="col-md-4"><a href="<%=GOODS_LIST_URL%>">${subtype.title}</a></div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${witem.wiid == 2}">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#item" href="#content-${witem.wiid}">
                                ${witem.title}
                        </a>
                    </h4>
                </div>
                <div id="content-${witem.wiid}" class="panel-collapse collapse">        <!-- 面板默认隐藏 -->
                    <div class="panel-body">
                        <div class="row">
                            <c:forEach items="${allSubtypes}" var="subtype">
                                <c:if test="${subtype.wiid == witem.wiid}">
                                    <div class="col-md-4"><a href="<%=GOODS_LIST_URL%>">${subtype.title}</a></div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${witem.wiid == 3}">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#item" href="#content-${witem.wiid}">
                                ${witem.title}
                        </a>
                    </h4>
                </div>
                <div id="content-${witem.wiid}" class="panel-collapse collapse">        <!-- 面板默认隐藏 -->
                    <div class="panel-body">
                        <div class="row">
                            <c:forEach items="${allSubtypes}" var="subtype">
                                <c:if test="${subtype.wiid == witem.wiid}">
                                    <div class="col-md-4"><a href="<%=GOODS_LIST_URL%>">${subtype.title}</a></div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${witem.wiid == 4}">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#item" href="#content-${witem.wiid}">
                                ${witem.title}
                        </a>
                    </h4>
                </div>
                <div id="content-${witem.wiid}" class="panel-collapse collapse">        <!-- 面板默认隐藏 -->
                    <div class="panel-body">
                        <div class="row">
                            <c:forEach items="${allSubtypes}" var="subtype">
                                <c:if test="${subtype.wiid == witem.wiid}">
                                    <div class="col-md-4"><a href="<%=GOODS_LIST_URL%>">${subtype.title}</a></div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${witem.wiid == 5}">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#item" href="#content-${witem.wiid}">
                                ${witem.title}
                        </a>
                    </h4>
                </div>
                <div id="content-${witem.wiid}" class="panel-collapse collapse">        <!-- 面板默认隐藏 -->
                    <div class="panel-body">
                        <div class="row">
                            <c:forEach items="${allSubtypes}" var="subtype">
                                <c:if test="${subtype.wiid == witem.wiid}">
                                    <div class="col-md-4"><a href="<%=GOODS_LIST_URL%>">${subtype.title}</a></div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </c:forEach>
</div>
