/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2014-05-14 13:49:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class Tabellinadel7_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 static private String str = "world!";
 static private String str2 = "DefiMongolo";
 static private String nome;
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("\"http://www.w3.org/TR/REC-html40/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>Tabellina del 7</title>\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("<body bgcolor=\"#0099FF\">\n");
      out.write("\t\n");
      out.write("\t<h1 align=center>Tabellina del 7</h1>\n");
      out.write("\n");
      out.write("    <h2>JSP per generare la tabellina del 7</h2>\n");
      out.write("\n");
      out.write("<TABLE border=1 align=\"center\"> <TR> <TH> numero </TH> <TH> numero per 7 </TH> </TR> <TR> <TD>1 </TD> <TD>7 </TD> </TR> <TR> <TD>2 </TD> <TD>14 </TD> </TR> <TR> <TD>3 </TD> <TD>21 </TD> </TR> <TR> <TD>4 </TD> <TD>28 </TD> </TR> <TR> <TD>5 </TD> <TD>35 </TD> </TR> <TR> <TD>6 </TD> <TD>42 </TD> </TR> <TR> <TD>7 </TD> <TD>49 </TD> </TR> <TR> <TD>8 </TD> <TD>56 </TD> </TR> <TR> <TD>9 </TD> <TD>63 </TD> </TR> <TR> <TD>10 </TD> <TD>70 </TD> </TR> </TABLE>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html> \n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}