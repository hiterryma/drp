<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%!
	public static final String INDEX_URL = "pages/back/index.jsp" ;
	public static final String WAREHOUSE_ADD_URL = "pages/back/admin/warehouse/warehouse_pre_add.action" ;
	public static final String WAREHOUSE_LIST_URL = "pages/back/admin/warehouse/warehouse_list.action" ;

	public static final String CUSTOMER_ADD_URL = "pages/back/admin/customer/customer_pre_add.action" ;
	public static final String CUSTOMER_LIST_URL = "pages/back/admin/customer/customer_list.action" ;
	public static final String CUSTOMER_AUDIT_URL = "pages/back/admin/customer/customer_audit_list.action" ;

    public static final String STORAGE_ADD_URL = "pages/back/admin/storage/storage_add_pre.action" ;
    public static final String STORAGE_LIST_URL = "pages/back/admin/storage/storage_list.action" ;

    public static final String STORAGE_AUDIT_LIST_URL = "/pages/back/admin/storage/storage_list_In.action" ;
    public static final String STORAGE_AUDIT_HISTORY_URL = "/pages/back/admin/storage/storage_list_In_aud_history.action" ;

	public static final String GOODS_ADD_URL = "pages/back/admin/goods/goods_pre_add.action" ;
	public static final String GOODS_LIST_URL = "pages/back/admin/goods/goods_list.action" ;

	public static final String DISTRIBUTION_GOODS_LIST_URL = "/pages/back/admin/distribution/distribution_add_pre.action" ;
	public static final String DISTRIBUTION_LIST_URL = "pages/back/admin/distribution/distribution_list_myself.jsp" ;
	public static final String DISTRIBUTION_CANCLE_URL = "pages/back/admin/distribution/distribution_list_myself.jsp" ;


	public static final String MANAGE_STORAGE_INPUT_URL = "pages/back/admin/manage/manage_storage_input.jsp" ;
	public static final String MANAGE_DISTRIBUTION_INPUT_URL = "pages/back/admin/manage/manage_distribution_input.jsp" ;

    public static final String DEPT_LIST_URL = "pages/back/admin/dept/dept_list.action";
    public static final String EMP_ADD_URL = "pages/back/admin/member/member_add.jsp";
    public static final String EMP_LIST_URL = "pages/back/admin/member/member_list.action";

    public static final String NEWS_ADD_URL = "pages/back/admin/news/news_add.jsp";
    public static final String NEWS_LIST_URL = "pages/back/admin/news/news_list.action";
%>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="images/user.png" class="img-circle"
                     alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${name}</p>
            </div>
        </div>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header"><i class="fa fa-university"></i> 分销业务平台</li>
            <c:forEach items="${allRoles}" var="role">
                <c:if test="${role == 'warehouse'}">
                    <li class="treeview ${param.mi==1 ? 'active' : ''}" value="${role}"><a href="<%=INDEX_URL%>"> <i
                            class="fa fa-institution"></i> <span>仓库管理</span> <i
                            class="fa fa-angle-left pull-right"></i>
                    </a>
                        <c:forEach items="${allActions}" var="action">
                        <ul class="treeview-menu">
                            <c:if test="${action == 'warehouse:add'}">
                                <li class="${param.msi==11 ? 'active' : ''}" value="${role}"><a
                                        href="<%=WAREHOUSE_ADD_URL%>"><i
                                        class="fa fa-cube"></i>
                                    增设仓库</a></li>
                            </c:if>
                            <c:if test="${action == 'warehouse:list'}">
                                <li class="${param.msi==12 ? 'active' : ''}"><a href="<%=WAREHOUSE_LIST_URL%>"><i
                                        class="fa fa-object-group"></i>
                                    仓库列表</a></li>
                            </c:if>
                        </ul>
                        </c:forEach>
                    </li>
                </c:if>
                <c:if test="${role == 'goods'}">
                    <li class="treeview ${param.mi==5 ? 'active' : ''}"><a href="<%=INDEX_URL%>"> <i
                            class="fa fa-gift"></i>
                        <span>商品信息</span> <i class="fa fa-angle-left pull-right"></i>
                    </a>
                        <c:forEach items="${allActions}" var="action">
                        <ul class="treeview-menu">
                            <c:if test="${action == 'goods:add'}">
                                <li class="${param.msi==51 ? 'active' : ''}"><a href="<%=GOODS_ADD_URL%>"><i
                                        class="fa fa-gamepad"></i> 增加商品</a></li>
                            </c:if>
                            <c:if test="${action == 'goods:list'}">
                                <li class="${param.msi==52 ? 'active' : ''}"><a href="<%=GOODS_LIST_URL%>"><i
                                        class="fa fa-list-alt"></i> 商品清单</a></li>
                            </c:if>
                        </ul>
                        </c:forEach>
                    </li>
                </c:if>
                <c:if test="${role == 'customer'}">
                    <li class="treeview ${param.mi==2 ? 'active' : ''}"><a href="<%=INDEX_URL%>"> <i
                            class="fa fa-sitemap"></i> <span>客户管理</span> <i
                            class="fa fa-angle-left pull-right"></i>
                    </a>
                        <c:forEach items="${allActions}" var="action">
                        <ul class="treeview-menu">
                            <c:if test="${action == 'customer:edit'}">
                                <li class="${param.msi==21 ? 'active' : ''}"><a href="<%=CUSTOMER_ADD_URL%>"><i
                                        class="fa fa-user-plus"></i>
                                    增加客户</a></li>
                            </c:if>
                            <c:if test="${action == 'customer:list'}">
                                <li class="${param.msi==22 ? 'active' : ''}"><a href="<%=CUSTOMER_LIST_URL%>"><i
                                        class="fa fa-users"></i>
                                    客户列表</a></li>
                            </c:if>
                            <c:if test="${action == 'customer:audit'}">
                                <li class="${param.msi==23 ? 'active' : ''}"><a href="<%=CUSTOMER_AUDIT_URL%>"><i
                                        class="fa fa-users"></i>
                                    待审核列表</a></li>
                            </c:if>
                        </ul>
                        </c:forEach>
                    </li>
                </c:if>

                <c:if test="${role == 'storage'}">
                    <li class="treeview ${param.mi==3 ? 'active' : ''}"><a href="<%=INDEX_URL%>"> <i
                            class="fa fa-dropbox"></i>
                        <span>商品入库</span> <i class="fa fa-angle-left pull-right"></i>
                    </a>
                        <c:forEach items="${allActions}" var="action">
                        <ul class="treeview-menu">
                            <c:if test="${action == 'storage:apply'}">
                                <li class="${param.msi==31 ? 'active' : ''}"><a href="<%=STORAGE_ADD_URL%>"><i
                                        class="fa fa-train"></i> 入库申请单</a></li>
                            </c:if>
                            <c:if test="${action == 'storage:details'}">
                                <li class="${param.msi==32 ? 'active' : ''}"><a href="<%=STORAGE_LIST_URL%>"><i
                                        class="fa fa-history"></i> 我的入库申请</a></li>
                            </c:if>
                        </ul>
                        </c:forEach>
                    </li>
                </c:if>
                <c:if test="${role == 'storageaudit'}">
                    <li class="treeview ${param.mi==4 ? 'active' : ''}"><a href="<%=INDEX_URL%>"> <i
                            class="fa fa-bitbucket-square"></i>
                        <span>入库审核</span> <i class="fa fa-angle-left pull-right"></i>
                    </a>
                        <c:forEach items="${allActions}" var="action">
                        <ul class="treeview-menu">
                            <c:if test="${action == 'storageaudit:prepare'}">
                                <li class="${param.msi==41 ? 'active' : ''}"><a
                                        href="<%=STORAGE_AUDIT_LIST_URL%>"><i
                                        class="fa fa-slideshare"></i> 待审核申请</a></li>
                            </c:if>
                            <c:if test="${action == 'storageaudit:history'}">
                                <li class="${param.msi==42 ? 'active' : ''}"><a
                                        href="<%=STORAGE_AUDIT_HISTORY_URL%>"><i
                                        class="fa fa-tasks"></i> 历史入库审核</a></li>
                            </c:if>
                        </ul>
                        </c:forEach>
                    </li>
                </c:if>
                <c:if test="${role == 'distribution'}">
                    <li class="treeview ${param.mi==7 ? 'active' : ''}"><a href="<%=INDEX_URL%>"> <i
                            class="fa fa-truck"></i>
                        <span>商品出库</span> <i class="fa fa-angle-left pull-right"></i>
                    </a>
                        <c:forEach items="${allActions}" var="action">
                        <ul class="treeview-menu">
                            <c:if test="${action == 'distribution:add'}">
                                <li class="${param.msi==71 ? 'active' : ''}"><a
                                        href="<%=DISTRIBUTION_GOODS_LIST_URL%>"><i
                                        class="fa fa-edit"></i> 待出库商品</a></li>
                            </c:if>
                            <c:if test="${action == 'distribution:apply'}">
                                <li class="${param.msi==72 ? 'active' : ''}"><a href="<%=DISTRIBUTION_LIST_URL%>"><i
                                        class="fa fa-fax"></i> 我的出库申请</a></li>
                            </c:if>
                            <c:if test="${action == 'distribution:cancel'}">
                                <li class="${param.msi==73 ? 'active' : ''}"><a href="<%=DISTRIBUTION_CANCLE_URL%>"><i
                                        class="glyphicon glyphicon-trash"></i> 取消出库申请</a></li>
                            </c:if>
                        </ul>
                        </c:forEach>
                    </li>
                </c:if>
                <c:if test="${role == 'manage'}">
                    <li class="treeview ${param.mi==6 ? 'active' : ''}"><a href="<%=INDEX_URL%>"> <i
                            class="fa fa-trello"></i>
                        <span>仓储管理</span> <i class="fa fa-angle-left pull-right"></i>
                    </a>
                        <c:forEach items="${allActions}" var="action">
                        <ul class="treeview-menu">
                            <c:if test="${action == 'manage:distribution'}">
                                <li class="${param.msi==61 ? 'active' : ''}"><a
                                        href="<%=MANAGE_STORAGE_INPUT_URL%>"><i
                                        class="fa fa-puzzle-piece"></i> 入库处理</a></li>
                            </c:if>
                            <c:if test="${action == 'manage:storage'}">
                                <li class="${param.msi==62 ? 'active' : ''}"><a
                                        href="<%=MANAGE_DISTRIBUTION_INPUT_URL%>"><i
                                        class="fa fa-paste"></i> 出库处理</a></li>
                            </c:if>
                        </ul>
                        </c:forEach>
                    </li>
                </c:if>
                <c:if test="${role == 'dept'}">
                    <li class="treeview ${param.mi==8 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
                            class="fa fa-sitemap"></i> <span>部门管理</span> <i
                            class="fa fa-angle-left pull-right"></i>
                    </a>
                        <c:forEach items="${allActions}" var="action">
                        <ul class="treeview-menu">
                            <c:if test="${action == 'dept:list'}">
                                <li class="${param.msi==81 ? 'active' : ''}"><a href="<%=DEPT_LIST_URL%>"><i
                                        class="fa fa-object-group"></i>
                                    部门列表</a></li>
                            </c:if>
                        </ul>
                        </c:forEach>
                    </li>
                </c:if>
                <c:if test="${role == 'member'}">
                    <li class="treeview ${param.mi==9 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
                            class="fa fa-sitemap"></i> <span>雇员管理</span> <i
                            class="fa fa-angle-left pull-right"></i>
                    </a>
                        <c:forEach items="${allActions}" var="action">
                        <ul class="treeview-menu">
                            <c:if test="${action == 'member:add'}">
                                <li class="${param.msi==91 ? 'active' : ''}"><a href="<%=EMP_ADD_URL%>"><i
                                        class="fa fa-user-plus"></i>
                                    增加雇员</a></li>
                            </c:if>
                            <c:if test="${action == 'member:list'}">
                                <li class="${param.msi==92 ? 'active' : ''}"><a href="<%=EMP_LIST_URL%>"><i
                                        class="fa fa-users"></i>
                                    雇员列表</a></li>
                            </c:if>
                        </ul>
                        </c:forEach>
                    </li>
                </c:if>

                <c:if test="${role == 'news'}">
                    <li class="${param.role=='news' ? 'active' : ''} treeview"><a href="${basePath}<%=INDEX_URL%>">
                        <i
                                class="fa fa-bullhorn"></i>
                        <span>公告管理</span> <i class="fa fa-angle-left pull-right"></i>
                    </a>
                        <c:forEach items="${allActions}" var="action">
                        <ul class="treeview-menu">
                            <c:if test="${action == 'news:add'}">
                                <li class="${param.action=='news:add' ? 'active' : ''}"><a href="<%=NEWS_ADD_URL%>"><i
                                        class="fa fa-plus-circle"></i> 发布公告</a></li>
                            </c:if>
                            <c:if test="${action == 'news:list'}">
                                <li class="${param.action=='news:list' ? 'active' : ''}"><a
                                        href="<%=NEWS_LIST_URL%>"><i
                                        class="fa fa-list-ul"></i> 公告列表</a></li>
                            </c:if>
                            <c:if test="${action == 'news:list'}">
                                <li class="${param.action=='news:list' ? 'active' : ''}"><a
                                        href="<%=NEWS_LIST_URL%>"><i
                                        class="fa fa-list-ul"></i> 公告显示</a></li>
                            </c:if>
                        </ul>
                        </c:forEach>
                    </li>
                </c:if>
            </c:forEach>
        </ul>
    </section>

    <!-- /.sidebar -->
</aside>