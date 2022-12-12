<%-- 
    Filename            : Subject
    Author              : Aysham Hameed
    Created             : Dec 7, 2018, 10:57:16 PM
    Operating System    : Windows 10
    Version             : NetBeans IDE 8.2
    Description         : Displays subject.
--%>


<html><!--HTML open tag-->
    <head><!--head open tag-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><!--identify type of doc-->
        <title>Subject</title><!--page title-->
        <!--Using multiple style sheets-->
        <link rel="stylesheet" href="CSS/headerStyle.css"><!--headerStyle sheet-->
        <link rel="stylesheet" href="CSS/topicsStyle.css"><!--topicsStyle sheet-->
        <link rel="stylesheet" href="CSS/subjectStyle.css"><!--subjectStyle sheet-->
    </head><!--head close tag-->
    
    <body><!--body open tag-->
        
        <!--HEADER & NAVIGATION BAR-->
        <header><!--header open tag-->
            <div class="container"><!--div tag-->
                <a href="Topics.jsp"><!--link to home page-->
                   <img src="CSS/logo.png" alt="logo" class="logo"/><!--displaying logo-->
                </a><!--link home page close tag-->
                
                <nav><!--nav open tag-->
                    <ul><!--unordered list open tag-->
                        <li><a href="Topics.jsp">Home</a></li><!--Home button-->
                        <%
                        if(session.getAttribute("usernameSession")!=null){//If session is created
                            out.println("<li><a href=\"Topics.jsp?logout=true\">");//create hyperlink to homepage
                            String user =  (String)session.getAttribute("usernameSession");//get username
                            out.println("Logout, "+user+"</a></li>");//display Logout button in navigation bar
                            out.println("<li><a href=\"Profile.jsp\">Profile</a></li>");//display Profile button in navigation bar
                        }else{//else if user session is not created then                                 
                            session.setAttribute("pageName", "Topics");//create a session for page name(see login page)
                            out.println("<li><a href=\"Login.jsp\">Login</a></li>");//display Login button
                        }
                        %>
                    </ul><!--unordered list close tag-->
                </nav><!--nav close tag-->
            </div><!--div close tag-->
        </header><!--header close tag-->
        
        
        
         <!--INSTANTIATING WEB SERVICE-->
        <%
            serviceClient.ProcessPosts service = new serviceClient.ProcessPosts();//creating instance of client 
            serviceClient.Processor port = service.getProcessorPort();//creating instance of server 

            String postid = (String) request.getParameter("postID");//Getting postID from Posts.jsp session object
            String user="";//used to get login name
        %>
        
         <!-- <!--SUBJECT HEADING-->
        <div style="overflow-x: hidden;"><!--div open tag-->
            <h1 class="subjectHeading"><!--assigning id to subject heading-->
            <% 
                //Getting topic name first from session created Posts page
                String topicName = (String) session.getAttribute("topicChosen");
                //Then getting the post title based on topic and post id
                String postTitle = port.getPostTitle(topicName, Integer.parseInt(postid));
                //Printing post title
                out.println(postTitle); 

            %>
           </h1><!--subject h1 heading close tag-->
        </div><!--subject heading div close tag-->
        
       
         
         <!--SUBJECT DESCRIPTION-->
         <div class="subjectDescription"><!--subject description div open--> 
             <p><!--paragraph tag open-->
                 <b>posted by : <%//post author
                     out.println(port.findPostAuthor(Integer.parseInt(postid)));//displaying post author
                 %> , <% out.println(port.getPostDateTime(Integer.parseInt(postid)));//displaying post date+time %></b> <br> 
                 <% out.println(port.getPostDesciption(Integer.parseInt(postid)));//displaying post description %>
             </p><!--paragraph tag close-->
         </div><!--subject description div close--> 
         
         <!--DISPLAYING COMMENTS-->
         <div class="subjectDescription"><!--div container open-->
             <table><!--table tag open-->
                 <%
                    //Calling this method to get the comment data from database.
                    port.getCommentsData(Integer.parseInt(postid));
                    //How many comments related to that post id
                    int commentCount = port.getCommentCount(Integer.parseInt(postid));
                    //So it can be accessed outside loop.
                    int commentIdentity=0;
                    //Displaying comment data
                    for (int x=0; x<commentCount; x++){
                        out.println("<tr >");//table row
                        out.println("<td id=\"commentBox\">");//table data with id
                        String commentAuthor = port.getCommentAuthors().get(x);//storing comment author
                        String commentDescription = port.getCommentDescription().get(x);//storing comment description
                        String commentTime = port.getCommentTimes().get(x);//storing comment times
                        int commentID = port.getCommentIDs().get(x);//storing comment ids
                        
                        //comment identity (using composite keys)
                        commentIdentity=port.findCommentIdentity(commentID,commentAuthor, Integer.parseInt(postid));  
                        out.println("<b>"+commentAuthor+", <i>"+commentTime+"</i></b> <br>");//displaying in table
                        out.println("<p id=\"cdes\">"+commentDescription+"</p><br>"); //displaying in table
                        
                        //appending comment id to page url AND%> 
                        <!--CREATING REPLY FORM IN COMMENT SECTION-->
                        <form action=<%out.println("Subject.jsp?postID="+postid+"&commentID="+commentIdentity+"&button=breply");%> method="post"><!--form open-->
                            <textarea name="replyText" cols="0" rows="1" wrap="soft" id="replyTextArea">Click here to type!</textarea><!--text area to type-->
                            <input type="submit" value="Reply"  id="replyButton"/><!--reply button-->
                        </form><!--form close--><% 
                               
                        out.println("</b>");//closing bold tag
                        out.println("</td>");//closing table data tag
                        //--------------------------------------------
                        
                        
                        //Getting reply data for every single comment
                        port.getReplyData(commentIdentity);
                            
                        //reply count of every comment
                        int replies = port.getReplyCount(port.findCommentIdentity(commentID, commentAuthor, Integer.parseInt(postid)));
                            
                        //DISPLAYING REPLIES=============================
                        for (int i=0; i<replies; i++){
                            out.println("<table id=\"replyBox\">");//creating a table open
                            out.println("<tr>");//table row open
                            out.println("<td >");//table data open
                            String replyDescriptions = port.getReplyDescriptions().get(i);//getting reply desc
                            String replyAuthor = port.getReplyAuthors().get(i);//getting reply author
                            String replyTime = port.getReplyTimes().get(i);//getting reply time
                            out.println("<b>"+replyAuthor+", <i>"+replyTime+"</i></b> <br>");//displaying in table
                            out.println(replyDescriptions);//displaying in table
                            out.println("</td>");//table data close 
                            out.println("</tr>"); //table row close
                            out.println("<table>");//table close
                            } //============================ reply loop end   
                            
                        out.println("</tr>");//table row end
                            
                    }//===================================== comment loop end

                    //IF REPLY BUTTON IS CLICKED.
                    String replyB = request.getParameter("button")==null ? "0":request.getParameter("button");//gets paramater from url
                    if("POST".equals(request.getMethod()) && replyB.equals("breply")){//if it is clicked then

                        if(request.getSession().getAttribute("usernameSession") != null){//if user is logged in
                        user = (String) session.getAttribute("usernameSession");//get username

                        String  REPLY_AUTHOR = user;//assign username to reply author

                        String COMMENT_IDENTITY = (request.getParameter("commentID")==null)? "0":
                        request.getParameter("commentID");//get comment identity from url

                        String REPLY_TEXT = (request.getParameter("replyText")==null)? " ":
                        request.getParameter("replyText");//get reply text from url
                            
                        
                        //posting (saving to database)
                        port.addReply(REPLY_TEXT, REPLY_AUTHOR, Integer.parseInt(COMMENT_IDENTITY));
                        //redirecting page to correct destination
                        response.sendRedirect("Subject.jsp?postID="+postid);
                        
                        }else { // else if not logged in 
                            session.setAttribute("pageName", "Reply");//create pageName session to Reply (see login page)
                            response.sendRedirect("Login.jsp");//go to login page
                        }   
                    }
                            
                 %>
                 
             </table><!--table close-->
         </div><!--div close-->
         
         
         <!--COMMENT AREA-->
         <div id="tarea"><!--div open-->
             <form action=<%out.println("Subject.jsp?postID="+postid+"&button=bcomment");%> method="POST"><!--form open-->
                 <textarea name="text" cols="5" rows="5" wrap="hard"  autofocus>Type something...</textarea><!--text area open & close-->
                 <input type="submit" value="Comment" id="commentButton"/><!--input-->
             </form><!--form close-->
         </div><!--div close-->
         
       
         <%     
                //gets type of button pressed from url
                String click = request.getParameter("button")==null ? "0" : request.getParameter("button");
                //IF COMMENT BUTTON IS CLICKED
                if("POST".equals(request.getMethod()) && click.equals("bcomment")){
                    //First, check if user is logged in or not.
                        //if user is logged in then 
                        if(request.getSession().getAttribute("usernameSession") != null){
                        user = (String) session.getAttribute("usernameSession");
                        
                        String  COMMENT_AUTHOR = user;//assign comment author to username
                        
                        String COMMENT_DESC = (request.getParameter("text")==null)? "0":
                        request.getParameter("text");//get comment description from text area
                        
                        String POST_ID = (request.getParameter("postID")==null)? " ":
                        request.getParameter("postID");//get comment post id from url
                        
                        
                        //out.println("<h1>"+REPLY_AUTHOR+" "+COMMENT_IDENTITY+" "+REPLY_TEXT+"</h1>");
                        //add comment to database
                        port.addComment(COMMENT_AUTHOR, COMMENT_DESC, Integer.parseInt(POST_ID));

                        //Refreshing the page
                        response.sendRedirect("Subject.jsp?postID="+postid);
                        }else {//if user is logged in then 
                            session.setAttribute("pageName", "Comments");//create pageName session to Reply (see login page)
                            response.sendRedirect("Login.jsp");//go to login page
                        }            
                }        
         %>
        
    </body><!--end body tag-->
</html><!--end HTML tag-->
