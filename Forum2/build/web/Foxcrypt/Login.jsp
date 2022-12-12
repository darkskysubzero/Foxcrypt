<%-- 
    Filename            : Login
    Author              : Aysham Hameed
    Created             : Dec 7, 2018, 10:36:16 PM
    Operating System    : Windows 10
    Version             : NetBeans IDE 8.2
    Description         : Login JSP file, used for user login.
--%>


<html><!--html open-->
    <head><!--head open-->
        <!--meta data for html document-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title><!--title of page-->
        <!--using multiple style sheets-->
        <link rel="stylesheet" href="CSS/headerStyle.css"><!--sheet 1-->
        <link rel="stylesheet" href="CSS/loginStyle.css"><!--sheet 2-->
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
                        <li><a href="Topics.jsp">Home</a></li><!--home page button-->
                    </ul><!--unordered list close-->
                </nav><!--nav close-->
                
            </div><!--div close-->
        </header><!--header close-->
        

        <!--LOGIN FORM-->
        <form class="loginForm" action="Login.jsp" method="post"><!--form open-->
            <h1>Login</h1><!--heading inside form-->
            <input type="text" name="userName" placeholder="Username"><!--username field-->
            <input type="password" name="userPassword" placeholder="Password"><!--password field-->
            <input type="submit" value="Login"><!--login button-->
            <!--FORGOT OR SIGN UP OPTIONS-->
            <p  style="color: white"><!--style -->
                <!--link to forgot password page-->
                <a href="passwordForgotten.jsp" style="text-decoration: none; color: white">Forgot password?</a> or 
                <!--link to join page-->
                <a  href="Join.jsp" style="text-decoration: none; color: white"><b>Join</b></a>
            </p> <!--paragraph end-->
       
        
        
        <!--JSP FUNCTIONALITY-->    
        <%  
            String username = null;//to store username
            String password = null;//to store password
           //#VALIDATION-1 [Checks if the username or password is null or not,
           //if are null then get their values.]  
           
           //#VALIDATION-2 [Checks to see if the username & passwords match
           //in the database then redirect the user to the Topics page.]
            //Gets username from login form. Check #VALIDATION-1
            
            boolean usernameValid = false;//flag variable for username field
            boolean passwordValid = false;//flag variable for password field
            //getting username from form
            username = request.getParameter("userName")==null ? "":request.getParameter("userName");
            //getting password from form
            password = request.getParameter("userPassword")==null ? "":request.getParameter("userPassword");
            
            //if username is not blank and lenght is greater than 5 characters
            if(!username.equals("") && username.length()>5){
                usernameValid = true;//then make usernameValid true
            }
            
           //if password is not blank and length is greater than 7 characters
            if(!password.equals("") && password.length()>7){
                passwordValid = true;//then make passwordValid true
            }
            
            //PROVIDING VERY SPECIFIC ERRORS TO USER 
            String usernameError = "";//to make username error message
            String passwordError = "";//to make password error message
            
            if(username.equals("")){//if username is blank 
                usernameError = "Username cannot be blank!";//display error
            }
            
            if(password.equals("")){//if password is blank
                passwordError = "Password cannot be blank!";//display error
            }
            
            if(!username.equals("")){//if username is not blank but
                if(username.length()<5){//username length is less than 5 
                    //then display error message
                    usernameError = "Username incorrect, must be at least 6 characters long!";
                }
            }
            
            if(!password.equals("")){//if password is not blank but
                if(password.length()<7){//password length is less than 5 
                    //then display error message
                    passwordError = "Password incorrect, must be at least 8 characters long!";
                }
            }
            
            
            
            
            String ptopic = null;
            //instantiating web service
            serviceClient.ProcessPosts service = new serviceClient.ProcessPosts();
            serviceClient.Processor port = service.getProcessorPort();
            //1 = exists
            //-1 = does not exist
            //2 = wrong password
            
            //If Login button is pressed
            if("POST".equals(request.getMethod())){
                //if username field & password field is valid then    
                if(usernameValid && passwordValid){
                    //If username and password matches
                     if(port.doesUserExist(username, password)==1){
                         //Stores username in session
                         session.setAttribute("usernameSession", username);
                         
                        //decide which page to go to
                        String pageName = (String) session.getAttribute("pageName")==null? "0" : 
                               (String) session.getAttribute("pageName");
                        
                        //So if you want to login directly like on homepage
                        if(pageName.equals("Topics.jsp")){
                            response.sendRedirect("Topics.jsp");
                        }
                        
                        //If page name = Comments, go to comments page
                        if(pageName.equals("Comments")){
                             //Creating a page url to redirect to after the user logs in
                             String pageURL = "Subject.jsp"+(String)session.getAttribute("postPAGE_URL");
                             response.sendRedirect(pageURL);
                        } 
                        
                        //If page name = Posts, go to posts page
                        if(pageName.equals("Posts")){
                            String pageURL = "Posts.jsp?topic="+(String)session.getAttribute("topicChosen");
                            response.sendRedirect(pageURL);
                        }
                        
                        //If page name = Reply, go to reply page
                        if(pageName.equals("Reply")){
                            String pageURL = "Subject.jsp"+(String)session.getAttribute("postPAGE_URL")+"&user="+username;
                            response.sendRedirect(pageURL);
                        }
                        
                        //If page name = Topics, got to topics page
                        if(pageName.equals("Topics")){
                            String pageURL = "Topics.jsp?";
                            response.sendRedirect(pageURL);
                        }
                        
                    }
                    else
                    //else if user does not exist        
                    if(port.doesUserExist(username, password)==-1){
                        response.sendRedirect("UserNotFound.html");//got to error page
                    } 
                    else
                    //else if password is wrong
                    if(port.doesUserExist(username, password)==2){
                            response.sendRedirect("InvalidPassword.html");// go to error page
                        }
                }else {
                    //else if username field and password field are not valid then 
                    //display username error
                    out.println("<p style=\"color:white; font-size:10pt; text-align:center; \">"+usernameError+"</p>");
                    //display password errors
                    out.println("<p style=\"color:white; font-size:10pt; text-align:center; \">"+passwordError+"</p>");
                }
                
            }
         
        %>
         </form><!--form close-->
        
    </body><!--body close-->
</html><!--html close-->
