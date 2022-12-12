<%-- 
    Filename            : Topics
    Author              : Aysham Hameed
    Created             : Dec 7, 2018, 10:57:16 PM
    Operating System    : Windows 10
    Version             : NetBeans IDE 8.2
    Description         : Used to diplay the topics.
--%>

<html><!--HTML open tag-->
    <head><!--head open tag--> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <!--specify the type of document it is-->
        <title>Topics</title><!--Topics as title of page-->
        <link rel="stylesheet" href="CSS/headerStyle.css"><!--using headerStyle sheet for customizations-->
        <link rel="stylesheet" href="CSS/topicsStyle.css"><!--using topicsStyle sheet for customizations-->
    </head><!--head close tag-->
    
    <body><!--body open tag-->
        
        <!--HEADER & NAVIGATION BAR-->
        <header><!--header open tag-->
            <div class="container"><!--div tag-->
                <a href="Topics.jsp"><!--link to home page-->
                   <img src="CSS/logo.png" alt="logo" class="logo"/><!--displaying logo-->
                </a><!--link home page close tag-->
                
                <nav><!--nav open tag-->
                    <ul><!--unordered list open tag-->
                        <li><a href="Topics.jsp">Home</a></li><!--Home button-->
                        <%
                        if(session.getAttribute("usernameSession")!=null){//If session is created
                            out.println("<li><a href=\"Topics.jsp?logout=true\">");//create hyperlink to homepage
                            String user =  (String)session.getAttribute("usernameSession");//get username
                            out.println("Logout, "+user+"</a></li>");//display Logout button in navigation bar
                            out.println("<li><a href=\"Profile.jsp\">Profile</a></li>");//display Profile button in navigation bar
                        }else{//else if user session is not created then                                 
                            session.setAttribute("pageName", "Topics");//create a session for page name(see login page)
                            out.println("<li><a href=\"Login.jsp\">Login</a></li>");//display Login button
                        }
                        %>
                    </ul><!--unordered list close tag-->
                </nav><!--nav close tag-->
            </div><!--div close tag-->
        </header><!--header close tag-->
           
        <!--MAIN HEADING-->
        <div style="overflow-x: hidden;"><!--div open tag-->
        <h1 id="mainHeading"><!--assigning id to main heading-->
            Welcome to Fox forums!<!--main heading-->
        </h1><!--main h1 heading close tag-->
        </div><!--main heading div close tag-->
        
        <!--LOGOUT BUTTON FUNCTIONALITY-->
        <%  
            String logOUT = request.getParameter("logout")==null?"0":
            request.getParameter("logout");//getting logout parameter from page url
            if(logOUT.equals("true")){//if logout is true then 
                session.invalidate();//invalidate user sesssion
                response.sendRedirect("Topics.jsp");//and go to homepage
            }
        %>
        
        <!--INSTANTIATING WEB SERVICE-->
        <%
            serviceClient.ProcessPosts service = new serviceClient.ProcessPosts();//creating instance of client 
            serviceClient.Processor port = service.getProcessorPort();//creating instance of server 
        %>
              
        <!--IMAGE TILES(10 FIXED TOPICS/CATEGORIES)-->
        <div class="xop-section"> <!--div open tag image tiles-->
            <ul class="xop-grid"><!--unordered lists open tag image tiles-->
                
                <!--TOPIC1--> 
                <li><!--topic 1 open-->                  
                     <a href="Posts.jsp?topic=Social" style="text-decoration: none;"><!--creating a custom link for Social-->
                        <div class="xop-box xop-img-1"><!--div open topic 1-->
                            <h3>Social</h3><!--topic 1 label-->
                            <p>Lets talk about things,<!--topic 1 description--><b
                            style="color: orange"> posts : <% out.println(port.getPostCount("Social"));%></b></p><!--number of posts -->
                        </div><!--div close topic 1-->
                     </a><!--topic 1 close link-->
                </li><!--topic 1 close-->
                
                <!--TOPIC2--> 
                <li><!--topic 2 open--> 
                     <a href="Posts.jsp?topic=Apple" style="text-decoration: none;"><!--creating a custom link for Apple-->
                        <div class="xop-box xop-img-2"><!--div open topic 2-->
                            <h3>Apple</h3><!--topic 2 label-->
                            <p>All things Apple,<!--topic 2 description--><b
                                    style="color: orange"> posts : <% out.println(port.getPostCount("Apple"));%></b></p><!--number of posts -->
                        </div><!--div close topic 2-->
                     </a><!--topic 2 close link-->
                </li><!--topic 2 close--> 
                
                <!--TOPIC3--> 
                <li><!--topic 3 open--> 
                    <a href="Posts.jsp?topic=Software" style="text-decoration: none;"><!--creating a custom link for Software-->
                        <div class="xop-box xop-img-3"><!--div open topic 3-->
                            <h3>Software</h3><!--topic 3 label-->
                            <p>Programs & programs,<!--topic 3 description--><b
                                    style="color: orange"> posts : <% out.println(port.getPostCount("Software"));%></b></p><!--number of posts -->
                        </div><!--div close topic 3-->
                    </a><!--topic 3 close link-->
                </li><!--topic 3 close--> 
                
                <!--TOPIC4--> 
                <li><!--topic 4 open--> 
                      <a href="Posts.jsp?topic=Movies" style="text-decoration: none;"><!--creating a custom link for Movies-->
                        <div class="xop-box xop-img-4"><!--div open topic 4-->
                        <h3>Movies</h3><!--topic 4 label-->
                        <p>Everyone likes movies!,<!--topic 4 description--><b
                                    style="color: orange"> posts : <% out.println(port.getPostCount("Movies"));%></b></p><!--number of posts -->
                        </div><!--div close topic 4-->
                      </a><!--topic 4 close link-->
                </li><!--topic 4 open--> 
                
                <!--TOPIC5--> 
                <li><!--topic 5 open--> 
                    <a href="Posts.jsp?topic=Books" style="text-decoration: none;"><!--creating a custom link for Books-->
                    <div class="xop-box xop-img-5"><!--div open topic 5-->
                        <h3>Books</h3><!--topic 5 label-->
                        <p>Lets read together,<!--topic 5 description--><b
                                    style="color: orange"> posts : <% out.println(port.getPostCount("Books"));%></b></p><!--number of posts -->
                    </div><!--div close topic 5-->
                    </a><!--topic 5 close link-->
                </li><!--topic 5 close--> 
                
                <!--TOPIC6--> 
                <li><!--topic 6 open--> 
                    <a href="Posts.jsp?topic=Events" style="text-decoration: none;"><!--creating a custom link for Events-->
                    <div class="xop-box xop-img-6"><!--div open topic 6-->
                        <h3>Events</h3><!--topic 6 label-->
                        <p>For all events discussion,<!--topic 6 description--><b
                                    style="color: orange"> posts : <% out.println(port.getPostCount("Events"));%></b></p><!--number of posts -->
                    </div><!--div close topic 6-->
                    </a><!--topic 6 close link-->
                </li><!--topic 6 close--> 
                
                <!--TOPIC7--> 
                <li><!--topic 7 open--> 
                    <a href="Posts.jsp?topic=Gaming" style="text-decoration: none;"><!--creating a custom link for Gaming-->
                    <div class="xop-box xop-img-7"><!--div open topic 7-->
                        <h3>Gaming</h3><!--topic 7 label-->
                        <p>Achievement unlocked?,<!--topic 7 description--><b
                                    style="color: orange"> posts : <% out.println(port.getPostCount("Gaming"));%></b></p><!--number of posts -->
                    </div><!--div close topic 7-->
                    </a><!--topic 7 close link-->
                </li><!--topic 7 close--> 
                
                <!--TOPIC8--> 
                <li><!--topic 8 open--> 
                    <a href="Posts.jsp?topic=Hacking" style="text-decoration: none;"><!--creating a custom link for Hacking-->
                    <div class="xop-box xop-img-8"><!--div open topic 8-->
                        <h3>Hacking</h3><!--topic 8 label-->
                        <p>Hacking make you feel cool,<!--topic 8 description--><b
                                    style="color: orange"> posts : <% out.println(port.getPostCount("Hacking"));%></b></p><!--number of posts -->
                    </div><!--div close topic 8-->
                    </a><!--topic 8 close link-->
                </li><!--topic 8 close--> 
                
                <!--TOPIC9--> 
                <li><!--topic 9 open--> 
                    <a href="Posts.jsp?topic=Coding" style="text-decoration: none;"><!--creating a custom link for Coding-->
                    <div class="xop-box xop-img-9"><!--div open topic 9-->
                        <h3>Coding</h3><!--topic 9 label-->
                        <p>Source code, problems & more,<!--topic 9 description--><b
                                    style="color: orange"> posts : <% out.println(port.getPostCount("Coding"));%></b></p><!--number of posts -->
                    </div><!--div close topic 9-->
                    </a> <!--topic 9 close link-->
                </li><!--topic 9 close--> 
                
                <!--TOPIC10--> 
                <li><!--topic 10 open--> 
                    <a href="Posts.jsp?topic=Science" style="text-decoration: none;"><!--creating a custom link for Science-->
                    <div class="xop-box xop-img-10"><!--div open topic 10-->
                        <h3>Science</h3><!--topic 10 label-->
                        <p>Science is fascinating,<!--topic 10 description--><b
                                    style="color: orange"> posts : <% out.println(port.getPostCount("Science"));%></b></p><!--number of posts -->
                    </div><!--div close topic 10-->
                    </a> <!--topic 10 close link-->
                </li><!--topic 10 close--> 
                
            </ul><!--Unordered list close-->
        </div><!--div close tag image tiles-->
        
    </body><!--body close tag-->
</html><!--HTML close tag-->
