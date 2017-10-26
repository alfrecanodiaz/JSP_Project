package org.apache.jsp.views.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../css_loader.jsp", out, false);
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <nav>\n");
      out.write("            <div class=\"nav-wrapper\">\n");
      out.write("              <a href=\"#\" class=\"brand-logo\">Logo</a>\n");
      out.write("              <ul id=\"nav-mobile\" class=\"right hide-on-med-and-down\">\n");
      out.write("                <li><a href=\"sass.html\">Sass</a></li>\n");
      out.write("                <li><a href=\"badges.html\">Components</a></li>\n");
      out.write("                <li><a href=\"collapsible.html\">JavaScript</a></li>\n");
      out.write("              </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("        <!--Sidebar-->\n");
      out.write("        <ul id=\"slide-out\" class=\"side-nav\">\n");
      out.write("        <li><div class=\"user-view\">\n");
      out.write("          <div class=\"background\">\n");
      out.write("            <img src=\"images/office.jpg\">\n");
      out.write("          </div>\n");
      out.write("          <a href=\"#!user\"><img class=\"circle\" src=\"images/yuna.jpg\"></a>\n");
      out.write("          <a href=\"#!name\"><span class=\"white-text name\">John Doe</span></a>\n");
      out.write("          <a href=\"#!email\"><span class=\"white-text email\">jdandturk@gmail.com</span></a>\n");
      out.write("        </div></li>\n");
      out.write("        <li><a href=\"#!\"><i class=\"material-icons\">cloud</i>First Link With Icon</a></li>\n");
      out.write("        <li><a href=\"#!\">Second Link</a></li>\n");
      out.write("        <li><div class=\"divider\"></div></li>\n");
      out.write("        <li><a class=\"subheader\">Subheader</a></li>\n");
      out.write("        <li><a class=\"waves-effect\" href=\"#!\">Third Link With Waves</a></li>\n");
      out.write("      </ul>\n");
      out.write("      <a href=\"#\" data-activates=\"slide-out\" class=\"button-collapse\"><i class=\"material-icons\">menu</i></a>\n");
      out.write("      \n");
      out.write("    </body>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../js_loader.jsp", out, false);
      out.write("\n");
      out.write("    <script>\n");
      out.write("        $(document).ready(function(){\n");
      out.write("           $(\".button-collapse\").sideNav();\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
