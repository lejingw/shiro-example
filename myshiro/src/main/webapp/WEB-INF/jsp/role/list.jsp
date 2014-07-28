<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="zhangfn" uri="http://github.com/lejingw/tags/myshiro-functions" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
    <title>角色管理</title>
</head>
<body>
<div class="page-content">
    <c:if test="${not empty msg}">
        <div class="message">${msg}</div>
    </c:if>
    <!-- BEGIN PAGE CONTENT-->
    <div class="row">
        <div class="col-md-12">
            <!-- BEGIN EXAMPLE TABLE PORTLET-->
            <div class="portlet box grey-cascade">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-globe"></i>Managed Table
                    </div>
                    <div class="tools">
                        <a href="javascript:;" class="collapse">
                        </a>
                        <a href="#portlet-config" data-toggle="modal" class="config">
                        </a>
                        <a href="javascript:;" class="reload">
                        </a>
                        <a href="javascript:;" class="remove">
                        </a>
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="table-toolbar">
                        <div class="btn-group">
                            <shiro:hasPermission name="role:create">
                                <a href="${ctx}/role/create" id="sample_editable_1_new" class="btn green">
                                    创建角色<i class="fa fa-plus"></i>
                                </a>
                            </shiro:hasPermission>
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i class="fa fa-angle-down"></i>
                            </button>
                            <ul class="dropdown-menu pull-right">
                                <li>
                                    <a href="#"> 打印 </a>
                                </li>
                                <li>
                                    <a href="#"> 导出Excel </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <table class="table table-striped table-bordered table-hover" id="sample_1">
                        <thead>
                            <tr>
                                <th class="table-checkbox">
                                    <input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes"/>
                                </th>
                                <th>
                                    角色名称
                                </th>
                                <th>
                                    角色描述
                                </th>
                                <th>
                                    拥有的资源
                                </th>
                                <th>
                                    操作
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${roleList}" var="role" varStatus="status">
                            <tr>
                                <td><input type="checkbox" class="checkboxes" value="${status.index}"/></td>
                                <td>${role.role}</td>
                                <td>${role.description}</td>
                                <td>${zhangfn:resourceNames(role.resourceIds)}</td>
                                <td class="center">
                                    <shiro:hasPermission name="role:update">
                                        <a class="btn btn-sm btn-info" href="${ctx}/role/${role.id}/update">修改</a>
                                    </shiro:hasPermission>

                                    <shiro:hasPermission name="role:delete">
                                        <a class="btn btn-sm btn-info" href="${ctx}/role/${role.id}/delete">删除</a>
                                    </shiro:hasPermission>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- END EXAMPLE TABLE PORTLET-->
        </div>
    </div>
    <!-- END PAGE CONTENT-->
</div>
</body>
</html>