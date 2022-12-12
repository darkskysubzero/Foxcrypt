<%-- 
    Filename            : changePassword
    Author              : Aysham Hameed
    Created             : Dec 7, 2018, 10:57:16 PM
    Operating System    : Windows 10
    Version             : NetBeans IDE 8.2
    Description         : Used to change user password.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><%--specifies the content of JSP.--%>

<html> <!--html open-->
    <head><!--head open-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><!--meta data of html page-->
        <title>Update Password</title> <!--title of page-->
        <link rel="stylesheet" href="CSS/headerStyle.css"> <!--using headerStyle sheet-->
        <link rel="stylesheet" href="CSS/profileStyle.css"><!--using profileStyle sheet-->
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
                        
        
        <!--FORM-->
        <div class="passwordChangeBOX"><!--div open-->
            <form action="changePassword.jsp" method="POST"><!--form open-->
                <h1>New Password</h1><!--heading-->
                <input type="password" name="newPassword" placeholder="New Password"/><!--password field-->
                <input type="submit" value="Change"/><!--change button-->
            </form><!--form close-->
        
        <!--JSP FUNCTIONALITY-->    
            <%  //dont need to check if user session is created or not
                //because can only change password once logged in.
                if("POST".equals(request.getMethod())){//if change button is clicked
                    String passwordNEW = request.getParameter("newPassword");//get new password
                    String errorMessage="";//to build error string
                    
                    if(!passwordNEW.equals("")){//if new password field is not blank
                        if(passwordNEW.length()>5){//if password lenght is longer than 5 char
                        //get username from usersession
                        String username = (String) session.getAttribute("usernameSession");
                        //change password in database 
                        port.changePassword(username, passwordNEW);
                        //go to profile page
                        response.sendRedirect("Profile.jsp");
                        }else {//display error if less than 5 char
                            errorMessage = "Password must at least be 6 characters long";
                            //displaying error
                            out.println("<p style=\"color:white; font-weight:bold; \">"+errorMessage+"</p>");
                        }
                                        
                    } else {//display error if password is blank
                        errorMessage = "Password cannot be blank!";
                        //displaying error
                        out.println("<p style=\"color:white; font-weight:bold; \">"+errorMessage+"</p>");
                    }
                }
            %>
                       
        </div><!--div end-->
           
    </body><!--body end-->
</html><!--html end-->
