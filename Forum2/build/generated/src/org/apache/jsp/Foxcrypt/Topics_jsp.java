package org.apache.jsp.Foxcrypt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Topics_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<html><!--HTML open tag-->\n");
      out.write("    <head><!--head open tag--> \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <!--specify the type of document it is-->\n");
      out.write("        <title>Topics</title><!--Topics as title of page-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/headerStyle.css\"><!--using headerStyle sheet for customizations-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/topicsStyle.css\"><!--using topicsStyle sheet for customizations-->\n");
      out.write("    </head><!--head close tag-->\n");
      out.write("    \n");
      out.write("    <body><!--body open tag-->\n");
      out.write("        \n");
      out.write("        <!--HEADER & NAVIGATION BAR-->\n");
      out.write("        <header><!--header open tag-->\n");
      out.write("            <div class=\"container\"><!--div tag-->\n");
      out.write("                <a href=\"Topics.jsp\"><!--link to home page-->\n");
      out.write("                   <img src=\"CSS/logo.png\" alt=\"logo\" class=\"logo\"/><!--displaying logo-->\n");
      out.write("                </a><!--link home page close tag-->\n");
      out.write("                \n");
      out.write("                <nav><!--nav open tag-->\n");
      out.write("                    <ul><!--unordered list open tag-->\n");
      out.write("                        <li><a href=\"Topics.jsp\">Home</a></li><!--Home button-->\n");
      out.write("                        ");

                        if(session.getAttribute("usernameSession")!=null){//If session is created
                            out.println("<li><a href=\"Topics.jsp?logout=true\">");//create hyperlink to homepage
                            String user =  (String)session.getAttribute("usernameSession");//get username
                            out.println("Logout, "+user+"</a></li>");//display Logout button in navigation bar
                            out.println("<li><a href=\"Profile.jsp\">Profile</a></li>");//display Profile button in navigation bar
                        }else{//else if user session is not created then                                 
                            session.setAttribute("pageName", "Topics");//create a session for page name(see login page)
                            out.println("<li><a href=\"Login.jsp\">Login</a></li>");//display Login button
                        }
                        
      out.write("\n");
      out.write("                    </ul><!--unordered list close tag-->\n");
      out.write("                </nav><!--nav close tag-->\n");
      out.write("            </div><!--div close tag-->\n");
      out.write("        </header><!--header close tag-->\n");
      out.write("           \n");
      out.write("        <!--MAIN HEADING-->\n");
      out.write("        <div style=\"overflow-x: hidden;\"><!--div open tag-->\n");
      out.write("        <h1 id=\"mainHeading\"><!--assigning id to main heading-->\n");
      out.write("            Welcome to Fox forums!<!--main heading-->\n");
      out.write("        </h1><!--main h1 heading close tag-->\n");
      out.write("        </div><!--main heading div close tag-->\n");
      out.write("        \n");
      out.write("        <!--LOGOUT BUTTON FUNCTIONALITY-->\n");
      out.write("        ");
  
            String logOUT = request.getParameter("logout")==null?"0":
            request.getParameter("logout");//getting logout parameter from page url
            if(logOUT.equals("true")){//if logout is true then 
                session.invalidate();//invalidate user sesssion
                response.sendRedirect("Topics.jsp");//and go to homepage
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        <!--INSTANTIATING WEB SERVICE-->\n");
      out.write("        ");

            serviceClient.ProcessPosts service = new serviceClient.ProcessPosts();//creating instance of client 
            serviceClient.Processor port = service.getProcessorPort();//creating instance of server 
        
      out.write("\n");
      out.write("              \n");
      out.write("        <!--IMAGE TILES(10 FIXED TOPICS/CATEGORIES)-->\n");
      out.write("        <div class=\"xop-section\"> <!--div open tag image tiles-->\n");
      out.write("            <ul class=\"xop-grid\"><!--unordered lists open tag image tiles-->\n");
      out.write("                \n");
      out.write("                <!--TOPIC1--> \n");
      out.write("                <li><!--topic 1 open-->                  \n");
      out.write("                     <a href=\"Posts.jsp?topic=Social\" style=\"text-decoration: none;\"><!--creating a custom link for Social-->\n");
      out.write("                        <div class=\"xop-box xop-img-1\"><!--div open topic 1-->\n");
      out.write("                            <h3>Social</h3><!--topic 1 label-->\n");
      out.write("                            <p>Lets talk about things,<!--topic 1 description--><b\n");
      out.write("                            style=\"color: orange\"> posts : ");
 out.println(port.getPostCount("Social"));
      out.write("</b></p><!--number of posts -->\n");
      out.write("                        </div><!--div close topic 1-->\n");
      out.write("                     </a><!--topic 1 close link-->\n");
      out.write("                </li><!--topic 1 close-->\n");
      out.write("                \n");
      out.write("                <!--TOPIC2--> \n");
      out.write("                <li><!--topic 2 open--> \n");
      out.write("                     <a href=\"Posts.jsp?topic=Apple\" style=\"text-decoration: none;\"><!--creating a custom link for Apple-->\n");
      out.write("                        <div class=\"xop-box xop-img-2\"><!--div open topic 2-->\n");
      out.write("                            <h3>Apple</h3><!--topic 2 label-->\n");
      out.write("                            <p>All things Apple,<!--topic 2 description--><b\n");
      out.write("                                    style=\"color: orange\"> posts : ");
 out.println(port.getPostCount("Apple"));
      out.write("</b></p><!--number of posts -->\n");
      out.write("                        </div><!--div close topic 2-->\n");
      out.write("                     </a><!--topic 2 close link-->\n");
      out.write("                </li><!--topic 2 close--> \n");
      out.write("                \n");
      out.write("                <!--TOPIC3--> \n");
      out.write("                <li><!--topic 3 open--> \n");
      out.write("                    <a href=\"Posts.jsp?topic=Software\" style=\"text-decoration: none;\"><!--creating a custom link for Software-->\n");
      out.write("                        <div class=\"xop-box xop-img-3\"><!--div open topic 3-->\n");
      out.write("                            <h3>Software</h3><!--topic 3 label-->\n");
      out.write("                            <p>Programs & programs,<!--topic 3 description--><b\n");
      out.write("                                    style=\"color: orange\"> posts : ");
 out.println(port.getPostCount("Software"));
      out.write("</b></p><!--number of posts -->\n");
      out.write("                        </div><!--div close topic 3-->\n");
      out.write("                    </a><!--topic 3 close link-->\n");
      out.write("                </li><!--topic 3 close--> \n");
      out.write("                \n");
      out.write("                <!--TOPIC4--> \n");
      out.write("                <li><!--topic 4 open--> \n");
      out.write("                      <a href=\"Posts.jsp?topic=Movies\" style=\"text-decoration: none;\"><!--creating a custom link for Movies-->\n");
      out.write("                        <div class=\"xop-box xop-img-4\"><!--div open topic 4-->\n");
      out.write("                        <h3>Movies</h3><!--topic 4 label-->\n");
      out.write("                        <p>Everyone likes movies!,<!--topic 4 description--><b\n");
      out.write("                                    style=\"color: orange\"> posts : ");
 out.println(port.getPostCount("Movies"));
      out.write("</b></p><!--number of posts -->\n");
      out.write("                        </div><!--div close topic 4-->\n");
      out.write("                      </a><!--topic 4 close link-->\n");
      out.write("                </li><!--topic 4 open--> \n");
      out.write("                \n");
      out.write("                <!--TOPIC5--> \n");
      out.write("                <li><!--topic 5 open--> \n");
      out.write("                    <a href=\"Posts.jsp?topic=Books\" style=\"text-decoration: none;\"><!--creating a custom link for Books-->\n");
      out.write("                    <div class=\"xop-box xop-img-5\"><!--div open topic 5-->\n");
      out.write("                        <h3>Books</h3><!--topic 5 label-->\n");
      out.write("                        <p>Lets read together,<!--topic 5 description--><b\n");
      out.write("                                    style=\"color: orange\"> posts : ");
 out.println(port.getPostCount("Books"));
      out.write("</b></p><!--number of posts -->\n");
      out.write("                    </div><!--div close topic 5-->\n");
      out.write("                    </a><!--topic 5 close link-->\n");
      out.write("                </li><!--topic 5 close--> \n");
      out.write("                \n");
      out.write("                <!--TOPIC6--> \n");
      out.write("                <li><!--topic 6 open--> \n");
      out.write("                    <a href=\"Posts.jsp?topic=Events\" style=\"text-decoration: none;\"><!--creating a custom link for Events-->\n");
      out.write("                    <div class=\"xop-box xop-img-6\"><!--div open topic 6-->\n");
      out.write("                        <h3>Events</h3><!--topic 6 label-->\n");
      out.write("                        <p>For all events discussion,<!--topic 6 description--><b\n");
      out.write("                                    style=\"color: orange\"> posts : ");
 out.println(port.getPostCount("Events"));
      out.write("</b></p><!--number of posts -->\n");
      out.write("                    </div><!--div close topic 6-->\n");
      out.write("                    </a><!--topic 6 close link-->\n");
      out.write("                </li><!--topic 6 close--> \n");
      out.write("                \n");
      out.write("                <!--TOPIC7--> \n");
      out.write("                <li><!--topic 7 open--> \n");
      out.write("                    <a href=\"Posts.jsp?topic=Gaming\" style=\"text-decoration: none;\"><!--creating a custom link for Gaming-->\n");
      out.write("                    <div class=\"xop-box xop-img-7\"><!--div open topic 7-->\n");
      out.write("                        <h3>Gaming</h3><!--topic 7 label-->\n");
      out.write("                        <p>Achievement unlocked?,<!--topic 7 description--><b\n");
      out.write("                                    style=\"color: orange\"> posts : ");
 out.println(port.getPostCount("Gaming"));
      out.write("</b></p><!--number of posts -->\n");
      out.write("                    </div><!--div close topic 7-->\n");
      out.write("                    </a><!--topic 7 close link-->\n");
      out.write("                </li><!--topic 7 close--> \n");
      out.write("                \n");
      out.write("                <!--TOPIC8--> \n");
      out.write("                <li><!--topic 8 open--> \n");
      out.write("                    <a href=\"Posts.jsp?topic=Hacking\" style=\"text-decoration: none;\"><!--creating a custom link for Hacking-->\n");
      out.write("                    <div class=\"xop-box xop-img-8\"><!--div open topic 8-->\n");
      out.write("                        <h3>Hacking</h3><!--topic 8 label-->\n");
      out.write("                        <p>Hacking make you feel cool,<!--topic 8 description--><b\n");
      out.write("                                    style=\"color: orange\"> posts : ");
 out.println(port.getPostCount("Hacking"));
      out.write("</b></p><!--number of posts -->\n");
      out.write("                    </div><!--div close topic 8-->\n");
      out.write("                    </a><!--topic 8 close link-->\n");
      out.write("                </li><!--topic 8 close--> \n");
      out.write("                \n");
      out.write("                <!--TOPIC9--> \n");
      out.write("                <li><!--topic 9 open--> \n");
      out.write("                    <a href=\"Posts.jsp?topic=Coding\" style=\"text-decoration: none;\"><!--creating a custom link for Coding-->\n");
      out.write("                    <div class=\"xop-box xop-img-9\"><!--div open topic 9-->\n");
      out.write("                        <h3>Coding</h3><!--topic 9 label-->\n");
      out.write("                        <p>Source code, problems & more,<!--topic 9 description--><b\n");
      out.write("                                    style=\"color: orange\"> posts : ");
 out.println(port.getPostCount("Coding"));
      out.write("</b></p><!--number of posts -->\n");
      out.write("                    </div><!--div close topic 9-->\n");
      out.write("                    </a> <!--topic 9 close link-->\n");
      out.write("                </li><!--topic 9 close--> \n");
      out.write("                \n");
      out.write("                <!--TOPIC10--> \n");
      out.write("                <li><!--topic 10 open--> \n");
      out.write("                    <a href=\"Posts.jsp?topic=Science\" style=\"text-decoration: none;\"><!--creating a custom link for Science-->\n");
      out.write("                    <div class=\"xop-box xop-img-10\"><!--div open topic 10-->\n");
      out.write("                        <h3>Science</h3><!--topic 10 label-->\n");
      out.write("                        <p>Science is fascinating,<!--topic 10 description--><b\n");
      out.write("                                    style=\"color: orange\"> posts : ");
 out.println(port.getPostCount("Science"));
      out.write("</b></p><!--number of posts -->\n");
      out.write("                    </div><!--div close topic 10-->\n");
      out.write("                    </a> <!--topic 10 close link-->\n");
      out.write("                </li><!--topic 10 close--> \n");
      out.write("                \n");
      out.write("            </ul><!--Unordered list close-->\n");
      out.write("        </div><!--div close tag image tiles-->\n");
      out.write("        \n");
      out.write("    </body><!--body close tag-->\n");
      out.write("</html><!--HTML close tag-->\n");
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
