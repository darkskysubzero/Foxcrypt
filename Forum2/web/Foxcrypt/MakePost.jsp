<%-- 
    Filename            : Make Post
    Author              : Aysham Hameed
    Created             : Dec 7, 2018, 10:57:16 PM
    Operating System    : Windows 10
    Version             : NetBeans IDE 8.2
    Description         : Allows user to make a post.
--%>

<!--specifying the type of jsp content-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html><!--html open-->
    <head><!--head open-->
        <title>Make Post</title><!--page title-->
        <!--using multiple style sheets-->
        <link rel="stylesheet" href="CSS/topicsStyle.css"><!--sheet 1-->
        <link rel="stylesheet" href="CSS/headerStyle.css"><!--sheet 2-->
        <link rel="stylesheet" href="CSS/postPageStyle.css"><!--sheet 3-->
    </head><!--head close-->
    
    
    <body><!--body open-->
        
        <!--HEADER & NAVIGATION BAR-->
        <header><!--header open-->
            <div class="container"><!--div open-->
                <a href="Topics.jsp"><!--link to home page-->
                   <img src="CSS/logo.png" alt="logo" class="logo"/><!--page logo--> 
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
        
        <!--FORM-->    
        <form class="postForm" action="MakePost.jsp" method="post"><!--form open-->
            <h1>Create a post</h1><!--heading in form-->
            <input type="text" name="postSubject" placeholder="Title" /><!--title field-->
            <textarea name="postText">Text...</textarea><!--text area-->
            <input type="submit" value="Post" /><!--submit button-->
       
        
         <!--JSP FUNCTIONALITY-->
            <%  
                //if post button is clicked
                if("POST".equals(request.getMethod())){
                    // subject, text, author,  topicID)
                    //get subject from form
                    String subject = request.getParameter("postSubject")==null? "Title" : request.getParameter("postSubject");
                    
                    //get text from form
                    String text = request.getParameter("postText")==null? "Text" : request.getParameter("postText");
                    //get username (author) from user session
                    String author = (String) session.getAttribute("usernameSession")==null? "Author" : (String) session.getAttribute("usernameSession");
                    //get topic id from user session
                    int topicID = port.getTopicID((String)session.getAttribute("topicChosen"));
                    
                    if(!subject.equals("") && !text.equals("")){ //post/add post to database
                        port.addPost(subject, text, author, topicID);
                        //go to posts while still have chosen topic
                        String redirecURL = "Posts.jsp?topic="+(String)session.getAttribute("topicChosen");
                        response.sendRedirect(redirecURL);//go to redirect url
                    }else{
                        out.println("<h4  style=\"color:white; font-size:11; text-align:center;\">Missing information.</h4>");
                    }
                    
                   
                }
            %>
           </form><!--form close-->  
    </body><!--body close-->
</html><!--html close-->
