<%-- 
    Filename            : passwordForgotten
    Author              : Aysham Hameed
    Created             : Dec 7, 2018, 10:57:16 PM
    Operating System    : Windows 10
    Version             : NetBeans IDE 8.2
    Description         : Used to reset forgotten password.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><%--specifies the content of JSP.--%>

<html> <!--html open-->
    <head><!--head open-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><!--meta data of html page-->
        <title>Forgotten Password</title> <!--title of page-->
        <link rel="stylesheet" href="CSS/headerStyle.css"> <!--using headerStyle sheet-->
        <link rel="stylesheet" href="CSS/profileStyle.css"><!--using profileStyle sheet-->
    </head><!--head close-->
    
    <body><!--body open-->    
        <!--HEADER & NAVIGATION BAR-->
        <header><!--header open-->
            <div class="container"><!--div open-->
                <a href="Topics.jsp"><!--link to home page-->
                   <img src="CSS/logo.png" alt="logo" class="logo"/> <!--website logo-->
                </a><!--link close-->
                
                <nav><!--nav open-->
                    <ul><!--unordered list open-->
                        <li><a href="Topics.jsp">Home</a></li><!--link to home page-->
                    </ul><!--unordered list close-->
                </nav><!--nav close-->
            </div><!--div close-->
        </header><!--header close-->
                        
        
        <!--FORM-->
        <div class="passwordForgottenBOX"><!--div passwordForgottenBOX open-->
            <form action="passwordForgotten.jsp" method="POST"><!--form open-->
                <h1>Reset Password</h1><!--heading inside form-->
                <!--username field inside form-->
                <input type="text" name="username" placeholder="Enter Username"/>
                <!--password field inside form-->
                <input type="text" name="email" placeholder="Enter Email"/>
                <!--combo box inside form-->
                <select id="cbox" name="userSQuestion"><!--select open-->
                    <option selected="true" disabled>Choose from these</option><!--instruction-->
                    <option value="Where were your parents born?">Where were your parents born?</option><!--option1-->
                    <option value="What is the name of your pet?">What is the name of your pet?</option><!--option2-->
                    <option value="How old were you when you had a cell phone?">How old were you when you had a cell phone?</option><!--option3-->
                </select><!--select end-->
                <!--answer field inside form-->
                <input type="text" name="userSAnswer" placeholder="Answer">
                <input type="submit" value="Reset"/><!--reset button inside form-->
            </form><!--form end-->
            
            <!--JSP CODE-->
            <%  //instantiating web service.
                serviceClient.ProcessPosts service = new serviceClient.ProcessPosts();
                serviceClient.Processor port = service.getProcessorPort();
                        
                        
                if("POST".equals(request.getMethod())){//if reset button is clicked
                    String username = request.getParameter("username");//get username from form
                    String email = request.getParameter("email");//get email from form
                    String question = request.getParameter("userSQuestion");//get question from form
                    String answer = request.getParameter("userSAnswer");//get answer from form
                            
                    //DOING VALIDATION ON FIELDS.
                    boolean valid = false;//flag boolean variable 
                    String errorMessage = "";//to build output string
                    
                    if(!username.equals("")){//if password is not null
                        if(!email.equals("")){//if email is not null
                            if(!question.equals("")){//if question is not null
                                if(!answer.equals("")){//if answer is not null
                                    valid = true;//then all fields are valid
                                }else {errorMessage = "Answer cannot be blank!";}//display error.
                            }else {errorMessage = "Please choose a question";}//display error.
                        } else {errorMessage = "Please enter your email!";}//display error.
                    } else {errorMessage = "Please enter your username!";}//display error.
                            
                            
                        if(valid==true){//if all fields are valid then
                            //check if all the information exists in database.
                            int outputCode = port.resetPassword(username, email, question, answer);
                            //* OUTPUT CODE MEANINGS:
                            //*  1 = everything is correct
                            //*  0 = neutral
                            //* -1 = user does not exist
                            //* -2 = email does not match
                            //* -3 = question does not match
                            //* -4 = answer does not match
                            String outputMessage = "";

                            if(outputCode==1){//if everything is correct in DB
                                //create user session 
                                session.setAttribute("usernameSession", username);
                                //redirect page to change password
                                response.sendRedirect("changePassword.jsp");//display error.
                            }else if(outputCode==-1){//check code meaning
                                    outputMessage = "User does not exist!";//display error.
                            }else if(outputCode==-2){//check code meaning
                                    outputMessage = "Email does not match!";//display error.
                            }else if(outputCode==-3){//check code meaning
                                    outputMessage = "Question does not match!";//display error.
                            }else if(outputCode==-4){//check code meaning
                                    outputMessage = "Wrong answer!";//display error.
                            }
                                //display output message.
                                out.println("<p style=\"color:white; font-weight:bold; \">"+outputMessage+"</p>");
                                
                        } else{//if fields are not valid then display error message
                            out.println("<p style=\"color:white; font-weight:bold; \">"+errorMessage+"</p>");
                        }
                        
                        }
            %>
                       
        </div> <!--div close-->  
    </body><!--body close-->
</html><!--html close-->
