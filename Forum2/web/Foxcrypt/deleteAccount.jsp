<%-- 
    Filename            : deleteAccount
    Author              : Aysham Hameed
    Created             : Dec 7, 2018, 10:57:16 PM
    Operating System    : Windows 10
    Version             : NetBeans IDE 8.2
    Description         : Used to delete account.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><%--specifies the content of JSP.--%>

<html> <!--html open-->
    <head><!--head open-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><!--meta data of html page-->
        <title>Delete Account</title> <!--title of page-->
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
                        
        
        
        <!--DELETE FORM-->
        <div class="deleteBOX"> <!--div open-->
            <form action="deleteAccount.jsp" method="POST"> <!--form open-->
                <h1>Delete Account</h1> <!--heading-->
                <input type="password" name="password" placeholder="Enter password"/> <!--password field-->
                <input type="submit" value="Delete"/> <!--delete button-->
            </form> <!--form close-->
            
            <%   
                //if delete button on form was pressed 
                if("POST".equals(request.getMethod())){
                    //get username from session
                    String username =  (String)session.getAttribute("usernameSession");
                    //get password from form
                    String password = request.getParameter("password");
                    boolean fieldValid = false;//flag variable
                    String errorMessage = "";//to build output string
                                   
                    if(!password.equals("")){//if password is not blank
                        if(password.length()>5){//if password is longer than 5 chars
                            fieldValid = true; //then fieldValue is valid
                        }else{//else display error
                            errorMessage = "Incorrect password!";
                        }
                    }else {//else display error
                        errorMessage = "Enter password to confirm deletion!";
                    }
                    
                    
                    if(fieldValid==true){//if field value is valid
                        String outputMessage = "";//to build output string
                        //get result from delteAccount method
                        int deleteResult = port.deleteAccount(username, password);
                        
                        //* OUTPUT CODE MEANINGS:
                        //* 0 - neutral
                        //* 1 - user exists
                        //* 2 - user does not exists
                        
                        if(deleteResult==1){//if everything is correct
                            session.invalidate();//then delete user session
                            response.sendRedirect("Topics.jsp");//and go to homepage
                        }else if(deleteResult==2){//else user does not exist
                            outputMessage = "Incorrect password!";//build message
                            //display message
                            out.println("<p style=\"color:white; font-weight:bold; \">"+outputMessage+"</p>");
                        }    
                    }else{
                    //else if field value is invalid then display error message
                    out.println("<p style=\"color:white; font-weight:bold; \">"+errorMessage+"</p>");
                    }     
                                   
                }
            %>
                       
        </div><!--div end-->        
    </body><!--body end-->
</html><!--html end-->
