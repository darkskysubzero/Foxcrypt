<%-- 
    Filename            : Profile
    Author              : Aysham Hameed
    Created             : Dec 7, 2018, 10:57:16 PM
    Operating System    : Windows 10
    Version             : NetBeans IDE 8.2
    Description         : Used to diplay user profile.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><!--type of JSP content-->
<html><!--HTML open tag-->
    <head><!--head open tag--> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <!--specify the type of document it is-->
        <title>Profile</title><!--title of page-->
        <!--USING CSS STYLESHEETS-->
        <link rel="stylesheet" href="CSS/headerStyle.css"><!--sheet1-->
        <link rel="stylesheet" href="CSS/profileStyle.css"><!--sheet2-->
    </head><!--head close-->
    
   <body><!--body open-->
        
        <!--HEADER & NAVIGATION BAR-->
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
                                out.println("<li><a href=\"#\">Profile</a></li>");
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
        
        <!--getting username-->
        <% String username = (String) session.getAttribute("usernameSession");%>
      
        <div class="profilebox"><!--div open (profile box)-->
            <img src="CSS/FoxProfile.jpg" alt="profile"/><!--just temp image-->
            <h1><% out.println(username); %></h1><!--displaying username-->
            <h5><% out.println(port.getUserEmail(username)); %> </h5><!--displaying email-->
            <p>Posted : <% out.println(port.countPosts(username)); %> times</p><!--displaying num posts-->
            <p>Commented : <% out.println(port.countComments(username)); %> times</p><!--displaying num comments-->
            <p>Replied : <% out.println(port.countReplies(username)); %> times</p><!--displaying num replies-->
            <hr><!--horizontal line-->
            <p><b>Security Question :</b> <% out.println(port.getUserQ()); %></p><!--displaying security question-->
            <p><b>Security Answer :</b>  <% out.println(port.getUserA()); %></p><!--displaying answer question-->
            <hr><!--horizontal-->
            <!--link to change email page-->
            <p><b><a href="changeEmail.jsp">Change email</a></b></p>
            <!--link to change password page-->
            <p><b><a href="changePassword.jsp">Change password</a></b></p>
            <!--link to change security question page-->
            <p><b><a href="changeSecurityQuestion.jsp">Change security question</a></b></p>
            <hr><!--horizontal line-->
            <!--link to delete account page-->
            <p><b><a href="deleteAccount.jsp">Delete account</a></b></p>
        </div><!--div close--> 
        
    </body><!--body close-->
</html><!--html close-->
