<%-- 
    Filename            : changeSecurityQuestion
    Author              : Aysham Hameed
    Created             : Dec 7, 2018, 10:57:16 PM
    Operating System    : Windows 10
    Version             : NetBeans IDE 8.2
    Description         : Used to change user security question.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><%--specifies the content of JSP.--%>

<html> <!--html open-->
    <head><!--head open-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><!--meta data of html page-->
        <title>Update Security Question</title> <!--title of page-->
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
        <div class="SQChangeBOX"><!--div open-->
            <form action="changeSecurityQuestion.jsp" method="POST"><!--form open-->
                <h1>Change Security Question</h1><!--heading inside form-->
                <!--displaying current chosen question-->
                <p style="color: white; text-align: left;"><b>Current Question :</b> <% out.println(port.getUserQ()); %></p>
                <!--displaying current chosen answers-->
                <p style="color: white; text-align: left;"><b>Current Answer :</b>  <% out.println(port.getUserA()); %></p>
                
                <hr><!--horizontal line-->
                <select id="cbox" name="userSQuestion"><!--select box(combo box)-->
                <option selected="true" disabled>Choose from these</option><!--instruction inside select tag-->
                <option value="Where were your parents born?">Where were your parents born?</option><!--option1-->
                <option value="What is the name of your pet?">What is the name of your pet?</option><!--option2-->
                <option value="How old were you when you had a cell phone?">How old were you when you had a cell phone?</option><!--option3-->
                </select><!--select end-->
                <input type="text" name="userSAnswer" placeholder="Answer"><!--answer field-->
                <input type="submit" value="Change"/><!--change button-->
            </form><!--form end-->
            
            <!--JSP FUNTIONALITY-->
            <%          
                           //if change button is clicked 
                           if("POST".equals(request.getMethod())){
                               //get username from user session
                               String username = (String) session.getAttribute("usernameSession");
                               //get user question from form
                               String question = request.getParameter("userSQuestion")==null ? "":request.getParameter("userSQuestion");
                               //get user answer from form
                               String answer = request.getParameter("userSAnswer");
                               
                               String errorMessage = "";//to build error message
                               
                               if(!question.equals("")){//if question is not blank
                                   if(!answer.equals("")){//if answer field is not blank
                                        //then update security question and answer 
                                        port.updateSQA(username, question, answer);
                                        response.sendRedirect("Profile.jsp");//reditect page to Profile
                                   }else {//else display error message.
                                       errorMessage = "Answer cannot be blank!";
                                   }
                               }else {//else display error message.
                                   errorMessage = "Please choose a question!";
                               }
                               
                               //displaying error message
                               out.println("<p style=\"color:white; font-weight:bold; \">"+errorMessage+"</p>");
                           }
            %>      
        </div><!--div end-->            
    </body><!--body end-->
</html><!--html end-->
