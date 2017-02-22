package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test33_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("<form action=\"\" method=\"post\">\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function ValidateExtension() {\n");
      out.write("        var allowedFiles = [\".doc\", \".docx\", \".pdf\"];\n");
      out.write("        var fileUpload = document.getElementById(\"fileUpload\");\n");
      out.write("        var lblError = document.getElementById(\"lblError\");\n");
      out.write("        var regex = new RegExp(\"([a-zA-Z0-9\\s_\\\\.\\-:])+(\" + allowedFiles.join('|') + \")$\");\n");
      out.write("        if (!regex.test(fileUpload.value.toLowerCase())) {\n");
      out.write("            lblError.innerHTML = \"Please upload files having extensions: <b>\" + allowedFiles.join(', ') + \"</b> only.\";\n");
      out.write("            return false;\n");
      out.write("        }\n");
      out.write("        lblError.innerHTML = \"\";\n");
      out.write("        return true;\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("<input id=\"fileUpload\" type=\"file\" />\n");
      out.write("<br />\n");
      out.write("<span id=\"lblError\" style=\"color: red;\"></span>\n");
      out.write("<br />\n");
      out.write("<input type=\"submit\" id=\"btnUpload\" value=\"Upload\" onclick=\"return ValidateExtension()\" />\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
