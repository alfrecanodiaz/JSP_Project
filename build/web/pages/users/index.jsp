<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master page_title="Users">
    <jsp:attribute name="styles">
    </jsp:attribute>
    <jsp:attribute name="content">
        <!-- Basic Examples -->
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
<!--                        <div class="header">
                    </div>-->
                    <div class="body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Dirección</th>
                                        <th>Teléfono</th>
                                        <th>Celular</th>
                                        <th>Email</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Dirección</th>
                                        <th>Teléfono</th>
                                        <th>Celular</th>
                                        <th>Email</th>
                                        <th>Acciones</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <c:if test="${not empty users}">
                                        <c:forEach items="${users}" var="user">
                                            <tr>
                                                <td>${user.nombre}</td>
                                                <td>${user.direccion}</td>
                                                <td>${user.telefono}</td>
                                                <td>${user.celular}</td>
                                                <td>${user.email}</td>
                                                <td>
                                                    <a href="<c:url value="/pages/user?action=edit&id=${user.id}" />">
                                                        <i class="material-icons">create</i>
                                                    </a>
                                                    <c:if test="${sessionScope.user.id != user.id}">
                                                        <a class="delete-item" data-toggle="modal" data-target="#delete-modal" data-action="<c:url value="/pages/user?action=delete&id=${user.id}" />">
                                                            <i class="material-icons">delete</i>
                                                        </a>
                                                    </c:if>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- #END# Basic Examples -->
        
        <jsp:include page="/includes/delete-form.jsp" />
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <script>
            $(function () {
                $('.dataTable').DataTable({
                    responsive: true,
                    order: [0, 'asc']
                });
            });
        </script>
    </jsp:attribute>
</t:master>