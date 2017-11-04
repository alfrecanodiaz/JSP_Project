<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<section>
    <!-- Left Sidebar -->
    <aside id="leftsidebar" class="sidebar">
        <!-- User Info -->
        <div class="user-info">
            <div class="image">
                <img src="${pageContext.request.contextPath}/assets/theme/images/user.png" width="48" height="48" alt="User" />
            </div>
            <div class="info-container">
                <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${sessionScope.user.nombre}
                </div>
                <div class="email">${sessionScope.user.email}</div>
                <div class="btn-group user-helper-dropdown">
                    <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                    <ul class="dropdown-menu pull-right">
                        <li>
                            <a href="<c:url value="/pages/user?action=edit&id=${sessionScope.user.id}" />">
                                <i class="material-icons">person</i>Editar
                            </a>
                        </li>
                        <li>
                            <a id="sign-out" href="javascript:void(0);">
                                <i class="material-icons">input</i>Cerrar Sesión
                            </a>
                            <form id="logout" method="POST" action="<c:url value="/login"/>" style="display:none;">
                                <input type="hidden" name="action" value="logout">
                            </form>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- #User Info -->
        <!-- Menu -->
        <div class="menu">
            <ul class="list">
                <li class="header">MAIN NAVIGATION</li>
                <li>
                    <a href="<c:url value="/pages/home" />">
                        <i class="material-icons">home</i>
                        <span>Home</span>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0);" class="menu-toggle">
                        <i class="material-icons">account_circle</i>
                        <span>Users</span>
                    </a>
                    <ul class="ml-menu">
                        <li>
                            <a href="<c:url value="/pages/user?action=index" />">
                                <span>Users List</span>
                            </a>
                        </li>
                        <li>
                            <a href="<c:url value="/pages/user?action=create" />">
                                <span>Create User</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:void(0);" class="menu-toggle">
                        <i class="material-icons">group</i>
                        <span>Roles</span>
                    </a>
                    <ul class="ml-menu">
                        <li>
                            <a href="<c:url value="/pages/role?action=index" />">
                                <span>Roles List</span>
                            </a>
                        </li>
                        <li>
                            <a href="<c:url value="/pages/role?action=create" />">
                                <span>Create Role</span>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- #Menu -->
        <!-- Footer -->
        <div class="legal">
            <div class="copyright">
                &copy; <fmt:formatDate value="${date}" pattern="yyyy" /> <a href="javascript:void(0);">Alfredo Cano</a>.
            </div>
            <div class="version">
                <b>Version: </b> 1
            </div>
        </div>
        <!-- #Footer -->
    </aside>
    <!-- #END# Left Sidebar -->
</section>