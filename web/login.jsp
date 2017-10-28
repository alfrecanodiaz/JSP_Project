<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:if test="${sessionScope.user != null}">
    <c:redirect url="pages/home" />
</c:if>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>${page_title}</title>

        <!-- Favicon-->
        <link rel="icon" href="favicon.ico" type="image/x-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">
        
        <!-- Bootstrap Core Css -->
        <link href="${pageContext.request.contextPath}/assets/theme/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Waves Effect Css -->
        <link href="${pageContext.request.contextPath}/assets/theme/plugins/node-waves/waves.css" rel="stylesheet" />
        
        <!-- Animation Css -->
        <link href="${pageContext.request.contextPath}/assets/theme/plugins/animate-css/animate.css" rel="stylesheet" />
        
        <!-- Custom Css -->
        <link href="${pageContext.request.contextPath}/assets/theme/css/style.min.css" rel="stylesheet">
    </head>
    <body class="login-page">
        <jsp:include page="flash_message.jsp" />
        <div class="login-box">
            <div class="logo">
                <a href="javascript:void(0);">Admin<b>BSB</b></a>
                <small>Admin BootStrap Based - Material Design</small>
            </div>
            <div class="card">
                <div class="body">
                    <form id="sign_in" method="POST" action="<c:url value="/login"/>">
                        <div class="msg">Inicia sesión en Admin</div>
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="material-icons">person</i>
                            </span>
                            <div class="form-line">
                                <input type="email" class="form-control" name="email" placeholder="Email" required autofocus>
                            </div>
                        </div>
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="material-icons">lock</i>
                            </span>
                            <div class="form-line">
                                <input type="password" class="form-control" name="password" placeholder="Password" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-8 p-t-5">
<!--                                <input type="checkbox" name="rememberme" id="rememberme" class="filled-in chk-col-pink">
                                <label for="rememberme">Remember Me</label>-->
                            </div>
                            <div class="col-xs-4">
                                <button class="btn btn-block bg-pink waves-effect" type="submit">ENTRAR</button>
                            </div>
                        </div>
<!--                        <div class="row m-t-15 m-b--20">
                            <div class="col-xs-6">
                                <a href="sign-up.html">Register Now!</a>
                            </div>
                            <div class="col-xs-6 align-right">
                                <a href="forgot-password.html">Forgot Password?</a>
                            </div>
                        </div>-->
                        <input type="hidden" name="action" value="login">
                    </form>
                </div>
            </div>
        </div>
        
        <!-- Jquery Core Js -->
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core Js -->
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/bootstrap/js/bootstrap.js"></script>
        
        <!-- Waves Effect Plugin Js -->
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/node-waves/waves.js"></script>

        <!-- Validation Plugin Js -->
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery-validation/jquery.validate.js"></script>
        
        <!-- Custom Js -->
        <script src="${pageContext.request.contextPath}/assets/theme/js/admin.js"></script>
        <script src="${pageContext.request.contextPath}/assets/theme/js/pages/examples/sign-in.js"></script>
    </body>
</html>