<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="styles" fragment="true" %>
<%@attribute name="scripts" fragment="true" %>
<%@attribute name="content" fragment="true" %>
<%@attribute name="page_title"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
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

        <!-- Sweet Alert Css -->
        <link href="${pageContext.request.contextPath}/assets/theme/plugins/sweetalert/sweetalert.css" rel="stylesheet" />

        <!-- JQuery DataTable Css -->
        <link href="${pageContext.request.contextPath}/assets/theme/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css" rel="stylesheet">

        <!-- Custom Css -->
        <link href="${pageContext.request.contextPath}/assets/theme/css/style.min.css" rel="stylesheet">

        <!-- Backend Theme -->
        <link href="${pageContext.request.contextPath}/assets/theme/css/themes/theme-red.min.css" rel="stylesheet" />

        <!-- Custom Css -->
        <link href="${pageContext.request.contextPath}/assets/theme/css/custom.css" rel="stylesheet" />
        
        <jsp:invoke fragment="styles"/>
    </head>
    <body class="theme-red">
        
        <jsp:include page="/partials/page_loader.jsp" />
        <jsp:include page="/partials/search_bar.jsp" />
        <jsp:include page="/partials/top_bar.jsp" />
        <jsp:include page="/partials/left-sidebar.jsp" />
        
        <section class="content">
            <div class="container-fluid">
                <div class="block-header">
                    <h2>${page_title}</h2>
                </div>
            </div>
            
            <jsp:include page="/includes/flash_message.jsp" />

            <!--Content-->
            <jsp:invoke fragment="content"/>
        
        </section>
        
        <!-- Jquery Core Js -->
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core Js -->
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/bootstrap/js/bootstrap.js"></script>

        <!-- Select Plugin Js -->
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/bootstrap-select/js/bootstrap-select.js"></script>

        <!-- Slimscroll Plugin Js -->
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

        <!-- Waves Effect Plugin Js -->
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/node-waves/waves.js"></script>

        <!-- Sweet Alert Js -->
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/sweetalert/sweetalert.min.js"></script>

        <!-- Jquery DataTable Plugin Js -->
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery-datatable/jquery.dataTables.js"></script>
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery-datatable/extensions/export/buttons.flash.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery-datatable/extensions/export/jszip.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery-datatable/extensions/export/pdfmake.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery-datatable/extensions/export/vfs_fonts.js"></script>
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery-datatable/extensions/export/buttons.html5.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery-datatable/extensions/export/buttons.print.min.js"></script>

        <!-- Validation Plugin Js -->
        <script src="${pageContext.request.contextPath}/assets/theme/plugins/jquery-validation/jquery.validate.js"></script>

        <script>
            $(document).ready(function()
            {
                $("#sign-out").click(function()
                {
                    $("#logout").submit();
                });

                var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
                if (hashes[0] !== window.location.href)
                {
                    var path = window.location.pathname + (hashes[0] !== window.location.href ? '?' + hashes[0] : '');
                    $("ul.list").find("a[href='"+path+"']").parent("li").addClass("active").parent("ul").parent("li").addClass("active");
                }
                else
                {
                    $("ul.list").find("a[href='"+window.location.pathname+"']").parent("li").addClass("active");
                }

                $("#delete-modal").on("show.bs.modal", function (event) {
                    var button = $(event.relatedTarget);
                    var dataAction = button.data("action");
                    $(this).find('form').attr('action', dataAction);
                });

            });
        </script>

        <!-- Custom Js (necesita un item activo en el sidebar) -->
        <script src="${pageContext.request.contextPath}/assets/theme/js/admin.js"></script>
        
        <jsp:invoke fragment="scripts"/>
    </body>
</html>