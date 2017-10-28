<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/includes/header_loader.jsp" />
    </head>
    <body class="theme-red">
    <!--<a href="<c:url value="/Login" />">Redirect</a>-->
        
    <jsp:include page="/partials/page_loader.jsp" />
    <jsp:include page="/partials/search_bar.jsp" />
    <jsp:include page="/partials/top_bar.jsp" />
    <jsp:include page="/partials/sidebars.jsp" />
    
    <section class="content">
        <div class="container-fluid">
            <div class="block-header">
                <h2>DASHBOARD</h2>
            </div>
        </div>
        
        <jsp:include page="/flash_message.jsp" />
        
    </section>
    
    <jsp:include page="/includes/footer_loader.jsp" />
    <!--<script src="${pageContext.request.contextPath}/assets/theme/js/pages/index.js"></script>-->
    <script src="${pageContext.request.contextPath}/assets/theme/js/demo.js"></script>
    </body>
</html>