<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
<div class="page-sidebar navbar-collapse collapse">
    <!-- BEGIN SIDEBAR MENU -->
    <ul class="page-sidebar-menu" data-auto-scroll="true" data-slide-speed="200">
        <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
        <li class="sidebar-toggler-wrapper">
            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
            <div class="sidebar-toggler"></div>
            <!-- END SIDEBAR TOGGLER BUTTON -->
        </li>
        <!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->
        <li class="sidebar-search-wrapper">
            <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
            <!-- DOC: Apply "sidebar-search-bordered" class the below search form to have bordered search box -->
            <!-- DOC: Apply "sidebar-search-bordered sidebar-search-solid" class the below search form to have bordered & solid search box -->
            <form class="sidebar-search" action="#" method="POST">
                <a href="javascript:;" class="remove">
                    <i class="icon-close"></i>
                </a>

                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search...">
                        <span class="input-group-btn">
                            <a href="javascript:;" class="btn submit"><i class="icon-magnifier"></i></a>
                        </span>
                </div>
            </form>
            <!-- END RESPONSIVE QUICK SEARCH FORM -->
        </li>
        <li class="start active open">
            <a href="javascript:;">
                <i class="icon-home"></i>
                <span class="title">常用业务</span>
                <span class="selected"></span>
                <span class="arrow open"></span>
            </a>
            <ul class="sub-menu">
                <li class="active"><a href="#"><i class="icon-bar-chart"></i>菜单一</a></li>
                <li><a href="#"><i class="icon-bulb"></i>菜单二</a></li>
                <li><a href="#"><i class="icon-graph"></i>菜单三</a></li>
            </ul>
        </li>
        <li class="last">
            <a href="javascript:;">
                <i class="icon-rocket"></i>
                <span class="title">系统管理</span>
                <span class="arrow"></span>
            </a>
            <ul class="sub-menu">
                <c:forEach items="${menus}" var="m">
                    <li><a href="${ctx}${m.url}">${m.name}</a></li>
                </c:forEach>
            </ul>
        </li>
    </ul>
    <!-- END SIDEBAR MENU -->
</div>