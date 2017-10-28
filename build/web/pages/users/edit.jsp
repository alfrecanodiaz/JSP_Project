<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/includes/header_loader.jsp" />
    </head>
    <body class="theme-red">
        
        <jsp:include page="/partials/page_loader.jsp" />
        <jsp:include page="/partials/search_bar.jsp" />
        <jsp:include page="/partials/top_bar.jsp" />
        <jsp:include page="/partials/sidebars.jsp" />
        
        <section class="content">
            <div class="container-fluid">
                <div class="block-header">
                    <h2>Edit User</h2>
                </div>
            </div>
            
            <jsp:include page="/flash_message.jsp" />
            
            <!-- Vertical Layout -->
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
<!--                        <div class="header">
                        </div>-->
                        <div class="body">
                            <form id="create-form" action="<c:url value="/pages/user?action=update" />" method="POST">
                                <input type="hidden" name="id" value="${user.id}">
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="text" id="nombre" name="nombre" class="form-control" required="required" value="${user.nombre}">
                                        <label class="form-label">Nombre</label>
                                    </div>
                                </div>
                                
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="text" id="direccion" name="direccion" class="form-control" required="required" value="${user.direccion}">
                                        <label class="form-label">Dirección</label>
                                    </div>
                                </div>
                                
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="text" id="telefono" name="telefono" class="form-control" required="required" value="${user.telefono}">
                                        <label class="form-label">Teléfono</label>
                                    </div>
                                </div>
                                
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="text" id="celular" name="celular" class="form-control" value="${user.celular}">
                                        <label class="form-label">Celular</label>
                                    </div>
                                </div>
                                
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="email" id="email" name="email" class="form-control" required="required" value="${user.email}">
                                        <label class="form-label">Email</label>
                                    </div>
                                </div>

                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="password" name="password" id="password" class="form-control" required="required" value="${user.password}">
                                        <label class="form-label">Password</label>
                                    </div>
                                </div>
                                
                                <button type="submit" class="btn btn-primary m-t-15 waves-effect">Actualizar</button>
                                <a href="<c:url value="/pages/user?action=index" />" class="btn btn-danger m-t-15 waves-effect right">Cancelar</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Vertical Layout -->
            
        </section>
        
        <jsp:include page="/includes/footer_loader.jsp" />
        
    </body>
</html>