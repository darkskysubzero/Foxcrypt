<%-- 
    Filename            : Posts
    Author              : Aysham Hameed
    Created             : Dec 7, 2018, 10:57:16 PM
    Operating System    : Windows 10
    Version             : NetBeans IDE 8.2
    Description         : Used to display relevant post.
--%>

<html><!--html open-->
    <head><!--head open-->
        <!--meta data for html page-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Posts</title><!--page title-->
        <!--Using multiple style sheets-->
        <link rel="stylesheet" href="CSS/headerStyle.css"><!--sheet 1-->
        <link rel="stylesheet" href="CSS/topicsStyle.css"><!--sheet 2-->
        <link rel="stylesheet" href="CSS/tableStyle.css"><!--sheet 3-->
    </head><!--head close-->
    
    <body><!--body open-->
        
        <!--HEADER & NAVIGATION BAR-->
        <header><!--header open-->
            <div class="container"><!--div open-->
                <a href="Topics.jsp"><!--link to homepage-->
                   <img src="CSS/logo.png" alt="logo" class="logo"/><!--logo image--> 
                </a><!--link close-->
                
                <nav><!--nav open-->
                    <ul><!--unordered list open-->
                        <li><a href="Topics.jsp">Home</a></li><!--home button-->
                        
                        <%  //Instantiating web service
                            serviceClient.ProcessPosts service = new serviceClient.ProcessPosts();
                            serviceClient.Processor port = service.getProcessorPort();
                            
                            //If user is logged in 
                            if(session.getAttribute("usernameSession")!=null){
                                //create logout link
                                out.println("<li><a href=\"Topics.jsp?logout=true\">");
                                //get username
                                String user =  (String)session.getAttribute("usernameSession");
                                //display logout button and username together
                                out.println("Logout, "+user+"</a></li>");
                                //display profile button
                                out.println("<li><a href=\"Profile.jsp\">Profile</a></li>");
                            }else{//else if user is not logged in  
                                //create pageName session (see login page)
                                session.setAttribute("pageName", "Topics");
                                //display login button
                                out.println("<li><a href=\"Login.jsp\">Login</a></li>");
                            }
                        %>
                    </ul><!--unordered list close-->
                </nav><!--nav close-->
            </div><!--div close-->
        </header><!--header close-->
                        
        
        <!--LOG OUT FUNCTIONALITY-->
        <%  
            //first get logout parameter from url
            String logOUT = request.getParameter("logout")==null?"0":request.getParameter("logout");
            if(logOUT.equals("true")){//if logout equals true
                session.invalidate();//then delete user session
                response.sendRedirect("Topics.jsp");//go to home page
            }
        %>
                        
                        
        <!--MAIN HEADING-->
        <div style="overflow-x: hidden;"><!--div open-->
        <h1 id="mainHeading"><!--heading open-->
            Forum Topic : <!--forum topic-->
            <%//displaying forum topic
                String sTopic = request.getParameter("topic");//getting topic from url
                out.println(sTopic);//printing to console (testing)
                session.setAttribute("topicChosen", sTopic);//creating & saving to session
            %>
        </h1><!--heading close-->
        </div><!--div close-->
        
          
        
        <!--GOES TO LOGIN PAGE-->
        <% 
            //If there is user logged in (user session created)
            if (request.getSession().getAttribute("usernameSession") != null) {
                //Then check that the user session matches the username
                if(session.getAttribute("usernameSession").equals(session.getAttribute("usernameSession"))){
                        //create make post button
                        out.println("<div>");
                        out.println("<h2 id=\"postButton\"><a href=\"MakePost.jsp\">Post</a></h2>"); 
                        out.println("</div>");
                }
            } else{
             
                        //If there is no user logged in then go to the login page.
                        out.println("<div>");//open div
                        //create post button with link to login page
                        out.println("<h2 id=\"postButton\"><a href=\"Login.jsp\">Post</a></h2>"); 
                        out.println("</div>");//div close
                        //create pageName session and set to Posts (see login jsp)
                        session.setAttribute("pageName","Posts");
                      
            }
        %>
        
        
        
        
     <!--TABLE-->  
    <center><!--center open tag-->
        <div style="overflow-x: auto;" id="box"><!--div open-->
          <table><!--table open-->
          
          <!--DISPLAYING ALL POSTS BASED ON TOPIC IN TABLE-->
           <%
              //gettin topic first 
              port.getPostsData(sTopic);
              //counting number of posts
              int posts = port.getPostCount(sTopic);
              //if number of posts is less than 1 then
              if(posts<1){
                  //display topic is empty!
                  out.println("<h2 style=\"color:white;\">This topic is empty!</h2>");
              } else {//else
                
                //create table layout
                out.println("<tr>");//table row open
                out.println("<th>Subject</th>");//subject heading
                out.println("<th>Posted by</th>");//posted by heading
                out.println("</tr>");//table row close
                
               
                for(int x=0; x<posts; x++){
                    out.println("<tr>");//table row open
                    //getting post name
                    String postName = port.getSubjects().get(x);
                    System.out.println(postName);
                    //getting post author
                    String postAuthor = port.getAuthors().get(x);
                    //getting post ID (converting int to String)
                    String postID = String.valueOf(port.getPostID().get(x));
                    
                    //Creating a post url to get postID parameter
                    String postURL = "?postID="+postID;
                    
                    //Creating a session for postURL
                    session.setAttribute("postPAGE_URL", postURL);
                    
                        //Displaying all clickable posts in table
                        out.println("<td><a href=\"Subject.jsp"+postURL+"\" >");
                        out.println(postName);//name of the post
                        out.println("</a></td>");//can make href
                        
                        //Displaying post author columns
                        out.println("<td>"+postAuthor+"</td>");//displaying author
                        out.println("</tr>");//table row end
                }
              }

           %>
            
        </table><!--table close-->
        </div><!--div close-->
    </center><!--center close-->
    
    </body><!--body close-->
</html><!--html close-->
