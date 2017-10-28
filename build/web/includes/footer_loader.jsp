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