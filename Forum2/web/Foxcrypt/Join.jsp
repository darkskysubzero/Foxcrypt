<%-- 
    Filename            : Join
    Author              : Aysham Hameed
    Created             : Dec 9, 2018, 12:43:16 PM
    Operating System    : Windows 10
    Version             : NetBeans IDE 8.2
    Description         : Used to register a user.
--%>

<%@page import="java.util.regex.Pattern"%><!--import regex to verify email-->
<html><!--html open--> 
    <head><!--head open-->
        <title>Join</title><!--page title-->
        <!--using multiple style sheets-->
        <link rel="stylesheet" href="CSS/headerStyle.css"><!--sheet 1-->
        <link rel="stylesheet" href="CSS/joinStyle.css"><!--sheet 2-->
    </head><!--head close-->
    
    
    <body><!--body open-->
        
        <!--HEADER & NAVIGATION BAR-->
        <header><!--header open-->
            <div class="container"><!--div open-->
                <a href="Topics.jsp"><!--link to home page-->
                   <img src="CSS/logo.png" alt="logo" class="logo"/><!--page logo--> 
                </a><!--link close-->
                
                <nav><!--nav open-->
                    <ul><!--unordered list-->
                        <li><a href="Topics.jsp">Home</a></li><!--home button link-->
                        <li><a href="Login.jsp">Login</a></li><!--login button link-->
                    </ul><!--unordered list close-->
                </nav><!--nav close-->
                
            </div><!--div close-->
        </header><!--header close-->
        
        
        
        
        
        
        <!--JOIN FORM-->
        <form class="joinForm" action="Join.jsp" method="post"><!--form open-->
            <h1>JOIN</h1><!--heading inside form-->
            <!--username field-->
            <input type="text" name="userName" placeholder="Username">
            <!--password field-->
            <input type="password" name="userPassword1" placeholder="Password">
            <!--confirm password field-->
            <input type="password" name="userPassword2" placeholder="Confirm Password">
            <!--email field-->
            <input type="text" name="userEmail" placeholder="Email">
            <!--combo box field-->
            <select id="cbox" name="userSQuestion"><!--options-->
                <option selected="true" disabled>Security Questions</option>
                    <option value="Where were your parents born?">Where were your parents born?</option><!--option1-->
                    <option value="What is the name of your pet?">What is the name of your pet?</option><!--option2-->
                    <option value="How old were you when you had a cell phone?">How old were you when you had a cell phone?</option><!--option3-->
            </select><!--options close-->
            <!--answer field-->
            <input type="text" name="userSAnswer" placeholder="Answer">
            <!--join button-->
            <input type="submit" value="Join" >
            
        <!--JSP FUNCTIONALITY-->
        <%  //Instantiating web service
            serviceClient.ProcessPosts service = new serviceClient.ProcessPosts();
            serviceClient.Processor port = service.getProcessorPort();
            
            
            //If Join button is pressed
            if("POST".equals(request.getMethod())){
                //to build error string
                String errorMessage = "";
                
                //USERNAME VALIDATION
                String username = request.getParameter("userName");//getting username from form
                if(username.length()>5){//checking username length
                    boolean userNameValid = Pattern.matches("\\w+", username);//verifying username
                    if(userNameValid==true){//if username is valid
                        String password1 = request.getParameter("userPassword1");//get password 1
                        
                        //PASSWORD VALIDATION
                        if(password1.length()>7){//if password 1 length is greater than 7 then
                            //get password 2 (confirmation)
                            String password2 = request.getParameter("userPassword2")==null? "":request.getParameter("userPassword2");
                            if(password1.equals(password2)){ //if both passwords match (confirmed)       
                            String email = request.getParameter("userEmail");//get user email from form
                                
                                //EMAIL VALIDATION
                                if(!email.equals("")){//if email is not blank then 
                                    //check email format
                                    boolean emailValid = Pattern.matches("[\\w]+[@][\\w]+[.][\\w]+", email);    
                                    if(emailValid==true){//if email is valid
                                        //get security question
                                        String question = request.getParameter("userSQuestion")==null ? "":request.getParameter("userSQuestion");
                                        
                                        //QUESTION VALIDATION
                                        if(!question.equals("")){//if question is not blank
                                            //get security answer
                                            String answer = request.getParameter("userSAnswer");
                                            
                                            //ANSWER VALIDATION
                                            if(!answer.equals("")){//if answer is not blank
                                                
                                                //CHECKING IF USER DETAILS ARE CORRECT
                                                if((port.addUser(username, email,password1, question, answer))==1){
                                                    //THEN ADD TO DATABASE
                                                    port.addUser(username, email , password1, question, answer);
                                                    response.sendRedirect("Login.jsp");//go to login page
                                                    
                                                }else errorMessage = "User already exists!";//build error message
                                                    
                                            }else errorMessage = "Please entery a proper answer.";//build error message
                                                
                                        }else errorMessage = "Please choose a Security question.";//build error message
                                        
                                    }else errorMessage = "Email is invalid.";//build error message
                                        
                                }else errorMessage = "Email cannot be blank.";//build error message
                                    
                            }else errorMessage = "Passwords dont match.";//build error message
                                
                        }else errorMessage = "Password must at least be 8 characters long.";//build error message
                            
                    } else errorMessage = "Username can only contain letters and numbers.";//build error message
                
                } else errorMessage = "Username must at least be 6 characters long.";//build error message
                
                //DISPLAY ERROR MESSAGE!
                out.println("<p style=\"color:white; font-size:11; text-align:center;\"><b>"+errorMessage+"<b><p>");
            }
        %>
    </form><!--form close-->
        
    </body><!--body close-->
</html><!--html close-->
