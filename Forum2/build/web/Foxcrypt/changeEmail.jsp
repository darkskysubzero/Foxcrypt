<%-- 
    Filename            : changeEmail
    Author              : Aysham Hameed
    Created             : Dec 7, 2018, 10:57:16 PM
    Operating System    : Windows 10
    Version             : NetBeans IDE 8.2
    Description         : Used to change user email.
--%>

<%@page import="java.util.regex.Pattern"%><%--import regex--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><%--specifies the content of JSP.--%>

<html> <!--html open-->
    <head><!--head open-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><!--meta data of html page-->
        <title>Update Email</title> <!--title of page-->
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
        <div class="emailChangeBOX"><!--div open-->
            <form action="changeEmail.jsp" method="POST"><!--form open-->
                <h1>Change Email</h1><!--heading-->
                <!--displaying current email-->
                <p style="color:white;"><% out.println(port.getUserEmail((String)session.getAttribute("usernameSession"))); %></p>
                <input type="text" name="newEmail" placeholder="New Email"/><!--new email field-->
                <input type="submit" value="Change"/><!--change button-->
            </form><!--form close-->
            
            <!--JSP FUNCTIONALITY-->
            <%   
            //if change button is clicked                
            if("POST".equals(request.getMethod())){
                //get email from form
                String email = request.getParameter("newEmail");
                String errorMessage="";//used to build string
                                    
                if(!email.equals("")){//if email field is not blank
                    //check for email format
                    boolean emailValid = Pattern.matches("[\\w]+[@][\\w]+[.][\\w]+", email);
                    //if email is valid
                    if(emailValid==true){
                    //get username from user session    
                    String username = (String) session.getAttribute("usernameSession");
                    //change email in database
                    port.changeEmail(username, email);
                    //go to profile page
                    response.sendRedirect("Profile.jsp");
                    } else {//else provide error message
                        errorMessage = "Invalid email";
                        //display error message
                        out.println("<p style=\"color:white; font-weight:bold; \">"+errorMessage+"</p>");
                    }
                                        
                } else {//else provide error message
                    errorMessage = "Please enter an email";
                    //display error message
                    out.println("<p style=\"color:white; font-weight:bold; \">"+errorMessage+"</p>");
                } 
                                    
            }
            %>
                       
        </div><!--div close-->
    </body><!--body close-->
</html><!--html close-->
