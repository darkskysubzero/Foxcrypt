/*
    Filename            : Processor
    Author              : Aysham Hameed
    Created             : Dec 7, 2018, 10:57:16 PM
    Operating System    : Windows 10
    Version             : NetBeans IDE 8.2
    Description         : Web Service that does all the functionality.
*/


package serviceServer; //Package name of webservice class.

import java.io.*; //Importing IO package.
import java.util.Date; //Importing Date class from util package.
import java.sql.*; //Importing all sql classes.
import java.text.ParseException; //Importing ParseException class to parse date.
import java.text.SimpleDateFormat; //Imported to format date.
import java.util.Vector;//Importing vector class for storing data.
import javax.jws.WebService; //Used for web service class annotation(identification).
import javax.jws.WebMethod; //Used for web service method annotation(identification).
import javax.jws.WebParam; //Used for web service parameters annotation(identification).

/** 
 * This is the processor class. It is a web service and acts as a server.
 * It provides the main functionality to the clients. It implements the 
 * Serializable class because it is also a java bean and contains accessor methods.
 * @author Aysham Hameed
*/
@WebService(serviceName = "processPosts")
public class processor implements Serializable{
    //DATABASE
    String driverURL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";/**driver URL.*/
    String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=fDatabase";/**location of database.*/
    String dbUser = "sa";/**database username.*/
    String dbPassword = "123456";/**database password.*/
    Connection connection=null;/**Connection object for making the connection.*/
    
    //POSTS
    Vector<String> postSubjects = new Vector<String>();
    Vector<String> postAuthors = new Vector<String>();
    Vector<Integer> postIDS = new Vector<Integer>();
    
    //COMMENTS
    Vector<String> commentDescriptions =  new Vector<String>();
    Vector<String> commentAuthors =  new Vector<String>();
    Vector<String> commentTimes =  new Vector<String>();
    Vector<Integer> commentIDS = new Vector<Integer>();
    //REPLIES
    Vector<String> replyDescriptions =  new Vector<String>();
    Vector<String> replyAuthor =  new Vector<String>();
    Vector<String> replyTimes =  new Vector<String>();
    
    String userQuestion = null;/**to store user question in getUserEmail method.*/
    String userAnswer = null;/**to store user answer in getUserEmail method.*/
    
    /**
      * Connects to the database using the {@link #makeConnection} method.
    */
    public processor(){
         makeConnection();//calling makeConnection method.
    }
    

    /**
     * Used to create a connection to the database using the driver 
     * URL and database URL consisting of database username & password.
     * @throws ClassNotFoundException if cannot find driver class.
     * @throws SQLException if database connection is invalid.
    */
    @WebMethod(operationName = "makeConnection")
    public void makeConnection() {
         try{//using try catch block.
            Class.forName(driverURL);//loading database driver.
            connection = DriverManager.getConnection(dbURL,dbUser,dbPassword);//creating database connection.
        }   catch (ClassNotFoundException e){//catching class not found exception.
                System.out.println("ClassNotFound Exeption :"+e.getMessage());//printing out exception message.
            }catch (SQLException e){//catching SQLException.
                System.out.println("SQLException : "+e.getMessage());//printing out exception message.
            }
    }
    

    /**
     * Used to get the topic ID from database using topic name as a parameter.
     * @param topicName parameter used. Example = "Social"
     * @return the ID of the topic. Example = 1
     * @throws SQLException if there is a query or connection  invalid.
     */
    @WebMethod(operationName = "getTopicID")
    public int getTopicID(@WebParam(name="topicName")String topicName){
        String query = "select topicID from Topics where topicName='"+topicName+"'";//search query.
        int id=0;//to store topic ID.
        try{//using try & catch block
            Statement statement = connection.createStatement();//creating a statement object.
            ResultSet records = statement.executeQuery(query);//executing query.
            while(records.next()){//looping through records.
                id = records.getInt("topicID");//looking for topicID
            }
        }   catch (SQLException e){//catching SQLException.
            System.out.println("SQLEX : "+e.getMessage());//printing exception message.
        }
        return id;//returning topic ID.
    }
    
    
    /**
     * Used to get to post count for each topic using topic name.
     * @param topicName Example = "Social"
     * @return count Example = 54 (Meaning there are 54 posts for the Social topic.
     * @throws SQLException if there is a query or connection  invalid.
     */
    @WebMethod(operationName="getPostCount")
    public int getPostCount(@WebParam(name="topicName")String topicName){
        int topicID = getTopicID(topicName);//getting topicID from topic name.
        String query = "select * from Posts where topicID="+topicID;//search query.
        int count=0;//counter.
        try{//using try & catch block.
            Statement statement = connection.createStatement();//creating statement.
            ResultSet records = statement.executeQuery(query);//executing query.
            while(records.next()){//looping through records.
                count++;//increasing counter.
            }
        }   catch (SQLException e){//catching sql exception.
            System.out.println("SQLEX : "+e.getMessage());//displating exception message.
        }
        return count;//returning post count.
    }

    
    /**
     * Gets the post data using topic name. Gets posts subjects, authors & ID's.
     * @param topicName Example = "Social"
     * @throws SQLException if there is a query or connection  invalid.
     */
    @WebMethod(operationName="getPostsData")
    public void getPostsData(@WebParam(name="topicName")String topicName){
        //REMOVING ALL ELEMENTS FIRST
        postSubjects.removeAllElements();
        postAuthors.removeAllElements();
        postIDS.removeAllElements();
        //--------------------------------
        String query = "select * from Posts where TopicID="+getTopicID(topicName);//search query.
        try{//using try & catch block.
            Statement statement = connection.createStatement();//creating statement object.
            ResultSet records = statement.executeQuery(query);//executing query.
            while(records.next()){//looping through records.
                postSubjects.addElement(records.getString("postSubject"));//saving to vector.
                postAuthors.addElement(records.getString("postAuthor"));//saving to vector.
                postIDS.addElement(records.getInt("postID"));//saving to vector.
            }
        }   catch (SQLException e){//catching sql exception.
            System.out.println("SQLEX : "+e.getMessage());//displaying exception message.
        }  
    }

    
    /**
     * Gets post subject vector.
     * @return postSubjects, a String vector. Based on topic. Example:
     * "How much is an iPhone?" or
     * "What is a good movie to watch?" 
     */
    @WebMethod(operationName="getSubjects")
    public Vector<String> getSubjects(){
        return postSubjects;//reurns post subject vector.
    }

    
    /**
     * Gets post author vector.
     * @return postAuthors, a String vector. Based on topic. Example:
     * "bruce7" or
     * "peter1" 
     */
    @WebMethod(operationName="getAuthors")
    public Vector<String> getAuthors(){
        return postAuthors;//returns post author vector.
    }
    

    /**
     * Gets post ID vector.
     * @return postIDS, Based on topic. Example:
     * 1 or
     * 3 
     */
    @WebMethod(operationName="getPostID")
    public Vector<Integer> getPostID(){
        return postIDS;//returns post ID vector.
    }
    

    /**
     * Finds the author of the post using postID.
     * @param postID Example : 3
     * @return author. Example : "bruce7"
     * @throws SQLException if there is a query or connection  invalid.
     */
    @WebMethod(operationName="findPostAuthor")
    public String findPostAuthor(@WebParam(name="postID")int postID){
        String author="";//to store author name.
        String query = "select postAuthor from Posts where postID="+postID;//search query.
        try{//using try catch block.
            Statement statement = connection.createStatement();//creating statement object.
            ResultSet records = statement.executeQuery(query);//executing query.
            while(records.next()){//looping through all records in db.
               author = records.getString("postAuthor");//storing author in varibale.
            }
        }   catch (SQLException e){//catching sql exeption.
            System.out.println("SQLEX : "+e.getMessage());//displaying exception message.
        }  
        return author;//returning author name.
    }

    
    /**
     * Gets the date & time of a post using postID.
     * @param postID Example : 5
     * @return Example : 2018-12-11 23:59:59
     * @throws SQLException if there is a query or connection  invalid.
     */
    @WebMethod(operationName="getPostDateTime")
    public String getPostDateTime(@WebParam(name="postID")int postID){
        String postDateTime="";//to store date & time.
        String query = "select postTime from Posts where postID="+postID;//search query.
        try{//to catch exeptions.
            Statement statement = connection.createStatement();//creating statement object.
            ResultSet records = statement.executeQuery(query);//executing query.
            while(records.next()){//looping through all records in db.
              postDateTime = records.getString("postTime");//storing date & time in varible.
            }
        }   catch (SQLException e){//catching sql exeption.
            System.out.println("SQLEX : "+e.getMessage());//displaying exception message.
        }
        return  getDateTime(postDateTime);//decoding & returning date & time.
    }
    
    

    /**
     * Private method used to decode date & time. It also calculates the date 
     * and time and translates it into words.
     * @param thisdate Example : "2018-12-11 23:59:59"
     * @return Example : "5 minutes ago"
     * @throws ParseException
     */
    @WebMethod(operationName="getDateTime")
    private String getDateTime(@WebParam(name="thisdate")String thisdate){
            //Manipulating string to seperate time and date.
            int spacePos = thisdate.indexOf(" ");//findig space position.
            String date = thisdate.substring(0,spacePos);//storing date.
            String time = thisdate.replace(date+" ", "");//storing time.
            
            //Creating date and time formats for parsing
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");//date format.
            SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");//time format.
            String currentDate = formatDate.format(new Date());//getting current date.
            String currentTime = formatTime.format(new Date());//getting current time.
            long dateDifference=0;//to store date difference.
            long timeDifference=0;//to store time differences.
            String output="";//to store output in words.
            
            try{//to catch parsing exceptions.
                //CALCULATING DATE
                Date parsedDate =  formatDate.parse(date);//parsing date.
                Date parsedCurrentDate = formatDate.parse(currentDate);//parsing current date.
                dateDifference =parsedCurrentDate.getTime()- parsedDate.getTime();//getting date difference.
              
                 //CALCULATING TIME
                Date parsedTime = formatTime.parse(time);//parsing time.
                Date parsedCurrentTime = formatTime.parse(currentTime);//parsing current time.
                timeDifference = parsedCurrentTime.getTime()-parsedTime.getTime();//getting time differences.                
            } catch (ParseException e){//catching parse exception.
                System.out.println("Parse Exception: "+e.toString());//displaying exception message.
            }   
                //1000MS = 1 SEC | 60SEC = 1 MIN | 60MIN = 1 HOUR | 24HOUR = 1 DAY
                dateDifference = dateDifference/(1000*60*60*24);//difference in days for example=  45 days
                if(dateDifference<=1){//so if its less than a day
                    timeDifference = timeDifference/(1000*60);//gets time in minutes
                    if(timeDifference>=60){//if more than or 60 minutes then convert to hours
                        timeDifference = timeDifference/60;//example 70 minutes divide by 60
                        output = timeDifference + " Hours ago"; //displaying output.
                    }else if(timeDifference<60){//if less than 60 minutes
                        output = timeDifference + " Minutes ago";//displaying output.
                        }
                } 
                else 
                if(dateDifference>1 && dateDifference<7) {//its been longer than a day & less than a week
                    output = dateDifference + " Days ago";//displaying output.
                }
                else        
                if(dateDifference>=7){//if its been longer than a week.
                    dateDifference = dateDifference/7; // then get the difference in weeks, so 45/7 therefore 6 weeks
                    if(dateDifference<2){//if is been 1 week.
                        output = dateDifference + " Week ago";//display week.
                    } 
                    else if(dateDifference>=2 && dateDifference<=4){//if more than a week.
                        output = dateDifference+" Weeks ago";//display weeks.
                    }
                    else {
                        dateDifference = dateDifference/4;//then get difference in months, so 6/4 (because 4 weeks in a month aprox) 
                        if(dateDifference<2){//if less than 2 months.
                            output = dateDifference + " Month ago";//display month.
                            } else {//if more than or equal to 2 months
                               output = dateDifference + " Months ago";//display months.
                            }
                    }
                }
        return output;//return date or time as words.
    }
    

    /**
     * Gets the description of a post using postID.
     * @param postID Example : 2
     * @return Example : "Can you please help me with this?"
     * @throws SQLException if there is a query or connection  invalid.
     */
    @WebMethod(operationName="getPostDesciption")
    public String getPostDesciption(@WebParam(name="postID")int postID){
        String description="";//used to store description of post.
        String query = "select postDescription from Posts where postID="+postID;//search query.
        try{//using try & catch block to catch exception.
            Statement statement = connection.createStatement();//creating statement object.
            ResultSet records = statement.executeQuery(query);//executing query.
            while(records.next()){//looping through records.
               description = records.getString("postDescription");//storing description into variable.
            }
        }   catch (SQLException e){//catching SQL Exception
            System.out.println("SQLEX : "+e.getMessage());//displaying exception messagage.
        }  
        return description;//returns post description.
    }
    

    /**
     * Gets the title of the post using the topicName and postID.
     * @param topicName Example : "Apple"
     * @param postID Example : 1
     * @return Example : "What is a good iPhone?"
     * @throws SQLException if there is a query or connection  invalid.
     */
    @WebMethod(operationName="getPostTitle")
    public String getPostTitle(@WebParam(name="topicName")String topicName,@WebParam(name="postID")int postID){
        String query = "select * from Posts where TopicID="+getTopicID(topicName)+" and postID="+postID;//search query.
        String title="";//to store the post title.
        try{//using try & catch block
            Statement statement = connection.createStatement();//creating statement object.
            ResultSet records = statement.executeQuery(query);//executing query.
            while(records.next()){//looping through each record.
                title = records.getString("postSubject");//locating and assigning post title.
            }
        }   catch (SQLException e){//catching SQL exception.
            System.out.println("SQLEX : "+e.getMessage());//displaying exception message.
        }  
        return title;//returning postTitle(subject)
    }
    

    /**
     * Gets the total count of comments.
     * @return Example : 5
     * @throws SQLException if there is a query or connection  invalid.
     */
    @WebMethod(operationName="getTotalCommentCount")
    public int getTotalCommentCount(){
        String query = "select * from Comments";//search query.
        int count=0;//counter.
        try{//using try & catch block.
            Statement statement = connection.createStatement();//creating statement object.
            ResultSet records = statement.executeQuery(query);//executing query.
            while(records.next()){//looping through records.
                count++;//incrementing counter.
            }
        }   catch (SQLException e){//catching exception.
            System.out.println("SQLEX : "+e.getMessage());//displaying exception message.
        }
        return count;//returning comment count.  
    }
    

    /**
     * Gets the count of comments of a specific post using postID
     * @param postID Example : 2
     * @return Example : 5
     * @throws SQLException if there is a query or connection  invalid.
     */
    @WebMethod(operationName="getCommentCount")
    public int getCommentCount(@WebParam(name="postID")int postID){
        String query = "select * from Comments where postID="+postID;//search query.
        int count=0;//counter.
        try{//try & catch block.
            Statement statement = connection.createStatement();//creating statement object.
            ResultSet records = statement.executeQuery(query);//executing query.
            while(records.next()){//looping through records.
                count++;//incrementing count.
            }
        }   catch (SQLException e){//catching exception.
            System.out.println("SQLEX : "+e.getMessage());//displaying exception message.
        }
        return count;//returning comment count.
    }
   

    /**
     * Gets the comment data from database and saves to related vectors.
     * @param postID Example : 2
     * @throws SQLException if there is a query or connection  invalid.
     */
    @WebMethod(operationName="getCommentsData")
    public void getCommentsData(@WebParam(name="postID")int postID){
        //REMOVING ELEMENTS FIRST------------------------
        commentDescriptions.removeAllElements();
        commentAuthors.removeAllElements();
        commentTimes.removeAllElements();
        commentIDS.removeAllElements();
        //-----------------------------------------------
        
        String query = "select * from Comments where postID="+postID;//search query.
    
        try{//try & catch block.
            Statement statement = connection.createStatement();//creating statement object.
            ResultSet records = statement.executeQuery(query);//executing query.
            while(records.next()){//looping through records.
                commentDescriptions.addElement(records.getString("commentDesc"));//saving to vector.
                commentAuthors.addElement(records.getString("commentAuthor"));//saving to vector.
                commentTimes.addElement(getDateTime(records.getString("commentTime")));//saving to vector.
                commentIDS.addElement(records.getInt("CommentID"));//saving to vector.
            }
        }   catch (SQLException e){//catching SQL exception.
            System.out.println("SQLEX : "+e.getMessage());//displaying exception message.
        } 
    }
    
     

    /**
     * Gets the comment description vector.
     * @return commentDescriptions
     */
    @WebMethod(operationName="getCommentDescription")
    public Vector<String> getCommentDescription(){
        return commentDescriptions;//returning comment description vector.
    }
     

    /**
     * Gets the comment author vector.
     * @return commentAuthors
     */
    @WebMethod(operationName="getCommentAuthors")
    public Vector<String> getCommentAuthors(){
        return commentAuthors;//returns comment author vector.
    }
    

    /**
     * Gets the comment time vector.
     * @return commentTimes
     */
    @WebMethod(operationName="getCommentTimes")
    public Vector<String> getCommentTimes(){
        return commentTimes;//returns comment times vector.
    }
    

    /**
     * Gets the comment ID vector.
     * @return commentIDS
     */
    @WebMethod(operationName="getCommentIDs")
    public Vector<Integer> getCommentIDs(){
        return commentIDS;//returns comment ID vector.
    }
    

    /**
     * Gets the comment identity from database which is a composite key.
     * @param commentID Example : 4
     * @param commentAuthor Example : "bruce7"
     * @param postID Example : "2"
     * @return Example : 1
     */
    @WebMethod(operationName="findCommentIdentity")
    public int findCommentIdentity(@WebParam(name="commentID")int commentID,@WebParam(name="commentAuthor") String commentAuthor, @WebParam(name="postID")int postID){
        String query = "select * from Comments where commentID="+commentID+" and commentAuthor='"+commentAuthor+"' and postID="+postID;//search query.
        int id = 0;//to store ID
        try{//try & catch block.
            Statement statement = connection.createStatement();//creating statement object.
            ResultSet records = statement.executeQuery(query);//executing query.
            while(records.next()){//looping through records.
                id = records.getInt("commentID");//finding and storing id.
            }
        }   catch (SQLException e){//catching SQL exception.
            System.out.println("SQLEX : "+e.getMessage());//displaying exception.
        }
        return id; //returning ID
    }
    

    /**
     * Gets the reply count using comment identity (composite key).
     * @param commentIdentity Example : 1
     * @return Example : 9
     */
    @WebMethod(operationName="getReplyCount")
    public int getReplyCount(@WebParam(name="commentIdentity")int commentIdentity){
        String query = "select * from Replies where commentIdentity="+commentIdentity;//search query.
        int count=0;//counter variable.
        try{//try & catch block.
            Statement statement = connection.createStatement();//creating statement object.
            ResultSet records = statement.executeQuery(query);//executing query.
            while(records.next()){//looping through records.
                count++;//incrementing counter.
            }
        }   catch (SQLException e){//catching SQL exception.
            System.out.println("SQLEX : "+e.getMessage());//displaying exception message.
        }
        return count;//returning count.
    }
    

    /**
     * Gets the reply data from database and assigns to related vectors.
     * @param commentIdentity Example : 1
     */
    @WebMethod(operationName="getReplyData")
    public void getReplyData(@WebParam(name="commentIdentity")int commentIdentity){
        //REMOVING ELEMENTS FIRST-------------
        replyDescriptions.removeAllElements();
        replyAuthor.removeAllElements();
        replyTimes.removeAllElements();
        //------------------------------------
        String query = "select * from Replies where commentIdentity="+commentIdentity;//search query.
        try{//try & catch block 
            Statement statement = connection.createStatement();//creating statement object
            ResultSet records = statement.executeQuery(query);//executing query
            while(records.next()){//looping through records
                replyDescriptions.addElement(records.getString("replyDescription"));//saving to vector.
                replyAuthor.addElement(records.getString("replyAuthor"));//saving to vector.
                replyTimes.addElement(getDateTime(records.getString("replyTime")));//saving to vector.
            }
        }   catch (SQLException e){//catching SQL exception
            System.out.println("SQLEX : "+e.getMessage());//displying exception message
        } 
    }
    

    /**
     * Gets the reply description vector.
     * @return replyDescriptions
     */
    @WebMethod(operationName="getReplyDescriptions")
    public Vector<String> getReplyDescriptions(){
        return replyDescriptions;//returning reply description vector.
    }
    

    /**
     * Gets the reply author vector.
     * @return replyAuthor
     */
    @WebMethod(operationName="getReplyAuthors")
    public Vector<String> getReplyAuthors(){
        return replyAuthor;//returning reply author vector.
    }
    

    /**
     * Gets the reply time vector.
     * @return replyTimes
     */
    @WebMethod(operationName="getReplyTimes")
    public Vector<String> getReplyTimes(){
        return replyTimes;//returns reply times vector.
    }
    

    /**
     * Private method, used to current generate time & date.
     * @return Example "2019-01-01 12:32:12"
     */
    private String generateTime(){
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");//date format
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");//time format       
        String currentDate = formatDate.format(new Date());//storing new current date
        String currentTime = formatTime.format(new Date());//storing new current time
        return currentDate+" "+currentTime;//returning date & time
    }
    

    /**
     * Used to add a reply.
     * @param text Example : "This is a reply"
     * @param author Example : "bruce7"
     * @param commentIdentity Example : 1
     * @throws SQLException if there is a query or connection  invalid.
     */
    @WebMethod(operationName="addReply")
    public void addReply(@WebParam(name="text")String text,@WebParam(name="author")String author,@WebParam(name="commentIdentity")int commentIdentity){
        String replyTime = generateTime();//current reply time.
       
        try{//try & catch block 
            
            String query = "insert into Replies (replyDescription, replyTime, replyAuthor, commentIdentity) "
                    + "values(?,?,?,?)";//insert query
            //using prepared statement
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, text);//text(description)
            pst.setString(2, replyTime);//time
            pst.setString(3, author);//author
            pst.setInt(4, commentIdentity);//comment identity
            pst.executeUpdate();
            
            String log_out_REPLY = "Reply added by : "+author+" at : "+replyTime;//building string for log
            writeToLog(log_out_REPLY);//writing to log
        }   catch (SQLException e){//catching SQL exception
            System.out.println("SQLE : "+e.getMessage());//displaying exception message.
        }
        
    }
    
    /**
     * Used to add a post.
     * @param subject Example : "How much is an iPhone?"
     * @param text Example : "Can someone please tell me the price of an iPhone....."
     * @param author Example : "peter1"
     * @param topicID Example : 2 (topicName = Apple)
     * @throws SQLException if there is a query or connection  invalid.
     */
    @WebMethod(operationName="addPost")
    public void addPost(@WebParam(name="subject")String subject,@WebParam(name="text") String text,@WebParam(name="author") String author,@WebParam(name="topicID") int topicID){
        //postID, postSubject, postDescription, postTime, postAuthor, topicID
        String postTime = generateTime();//current post time
        try{//try & catch block 
            String query = "insert into Posts (postSubject,postDescription,postTime,postAuthor,topicID)"
                    + "values(?,?,?,?,?)";    //query
            
            //Using prepareed statement to insert into table
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, subject);//subject
            pst.setString(2, text);//text
            pst.setString(3, postTime);//time
            pst.setString(4, author);//author
            pst.setInt(5, topicID);//topic id
            pst.executeUpdate();//exeucting update
            
            String log_out_POST = "Post added by : "+author+" at : "+postTime;//building string for LOG
            writeToLog(log_out_POST);//writing to LOG
        }   catch (SQLException e){//catching SQL Exception
            System.out.println("SQLE : "+e.getMessage());//displaying exception message
           
        }
       
        
    }
    
    /**
     * Private method used to write to LOG. (Stores on desktop)
     * @param action Example : "Post added by : peter1 at : 2019-01-01 12:32:12"
     * @throws IOException 
     */
    private void writeToLog(String action){
        String p = System.getProperty("user.home");//gets user path.
        p = p.replace("\\", "/")+"/Desktop/log.txt";//replaces slashes to append to path.
        try {//usign try & catch block
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(p, true)), true);//creating file.
            out.println(action);//writing to file.
        } catch (IOException e) {//catching IOException.
            System.out.println("Writing Error : " + e.toString());//displaying exception message.
        }
        System.out.println(action);//displaying to console the string written to LOG
        System.out.println(p);//displaing to console path of LOG
    }
    
    /**
     * Used to add a comment.
     * @param commentAuthor Example : "bruce7"
     * @param commentDesc Example : "Thank you!"
     * @param postID Example : 2
     */
    @WebMethod(operationName="addComment")
    public void addComment(@WebParam(name="commentAuthor")String commentAuthor,@WebParam(name="commentDesc") String commentDesc,@WebParam(name="postID") int postID){
        int commentID =getTotalCommentCount()+1;//gets the comment id from previous count.
        String commentTime = generateTime();//current comment time
    
        try{//using try & catch block
            String query = "insert into Comments (commentID, commentAuthor, commentTime, commentDesc, postID) "
                    + "values (?,?,?,?,?)";//insert query
            //using prepared statament
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, commentID);//comment id
            pst.setString(2, commentAuthor);//comment author
            pst.setString(3, commentTime);//comment time
            pst.setString(4, commentDesc);//comment description/text
            pst.setInt(5, postID);//post id
            pst.executeUpdate();//executing insert statement
            
            String log_out_COMMENT = "Comment added by : "+commentAuthor+" at : "+commentTime;//building string for LOG
            writeToLog(log_out_COMMENT);//writing to LOG

        }   catch (SQLException e){//catching SQL Exception
            System.out.println("SQLE : "+e.getMessage());//displaying exception message
        }
    }
    
    /**
     * Checks is the user exists.
     * @param username Example : "bruce7"
     * @param password Example : "1234567"
     * @return code  Example : 1
     *  MEANINGS OF CODE:
     *  1 = user found & password correct
     *  2 = user found & password incorrect
     * -1 = user not found
     * @throws SQLException
     */
    @WebMethod(operationName="doesUserExist")
    public int doesUserExist(@WebParam(name="username")String username,@WebParam(name="password")String password){
        String query = "select * from Users";//search query
        boolean userFound = false;//flag variable for username
        boolean passFound = false;//flag varible for password
        int code = 0;//to store output code
      try{//using try & catch block
            Statement statement = connection.createStatement();//creating statement object
            ResultSet records = statement.executeQuery(query);//executing query
            while(records.next()){//looping through records
                if(records.getString("userName").equals(username)){//if username is found
                    userFound = true;//set username to be true
                }
                
                //is username found and password is also found
                if(userFound==true && records.getString("userPassword").equals(password)){
                    passFound = true;//set password to be true
                } 
            }
        }   catch (SQLException e){//catch SQL exception
            System.out.println("SQLEX : "+e.getMessage());//display sql exception
        }  
      
      if(userFound==true && passFound==true){//is username and password are true
        code = 1;//set output code to 1
      } else if(userFound==false){//else if username is false
          code = -1;//set output code to -1
      } else if(userFound==true && passFound==false){//else if username is true & password is false
          code = 2; //set output code to 2
      }
      return code;//return output code.   
    }
    
    /**
    * Used to add a user to database.
    * @param username Example : "bruce7"
    * @param email Example : "bruce7@gmail.com"
    * @param password Example : "bruce12345"
    * @param question Example : "Where did your parents meet?"
    * @param answer Example : "London"
    * @return returns output code
    * MEANINGS OF OUTPUT CODE:
    * 0 = neutral
    * 1 = user can be added (everything is valid)
    * 2 = user already exists
    * @throws SQLException
    */
    @WebMethod(operationName="addUser")
    public int addUser(@WebParam(name="username")String username,@WebParam(name="email") String email, 
            @WebParam(name="password")String password,@WebParam(name="q") String question, @WebParam(name="a")String answer){
        String addingTime = generateTime();//current adding time
        int message = 0;//output code
        if(doesUserExist(username, password)==-1){//if user does not exist
                message = 1;//set message to 1
                //username, email, password, question, answer
                String query = "insert into Users values "
                + "('"+username+"','"+email+"','"+password+"','"+question+"','"+answer+"')";//insert query
                int rowsadded;//rows added
                try{//using try & catch block
                     Statement statement = connection.createStatement();//creating statement object
                     rowsadded = statement.executeUpdate(query);//executing query
                     String log_out_ADDUSER = "User added by : "+"Server"+" at : "+addingTime;//building log string
                     writeToLog(log_out_ADDUSER);//writing to log
                }   catch (SQLException e){//catching sql exception
                    System.out.println("SQLE : "+e.getMessage());//displaying exception message
                }
                
        } else{//else if user already exists
            message = 2;//set message(output code) to 2
        }
        
        return message;//return output code(message)
    }
    
  
    /**
     * Used to change email of a user.
     * @param username Example : "bruce7"
     * @param newEmail Example : "bruce12@gmail.com"
     * @throws SQLException
     */
    @WebMethod(operationName="changeEmail")
    public void changeEmail(@WebParam(name="username")String username, @WebParam(name="newEmail")String newEmail){
        String addingTime = generateTime();//current adding time
        int records;//record to be update
        String query = "update Users set userEmail='"+newEmail+"' where userName='"+username+"'";//update query
        try{//using try & catch block
            Statement statament = connection.createStatement();//creating statment object
            records = statament.executeUpdate(query);//executing query
            String log_out_EMAILCHANGED = "Email changed by : "+username+" at : "+addingTime;//building LOG String
            writeToLog(log_out_EMAILCHANGED);//writing to LOG
        }   catch (SQLException e){//catching SQL Exception
            System.out.println("SQLExceptiom : "+e.toString());//displaying exception message
        }
    }
    
   
    /**
     * Used to change user password.
     * @param username Example : "bruce7"
     * @param password Example : "newpassword123!"
     * @throws SQLException
     */
    @WebMethod(operationName="changePassword")
    public void changePassword(@WebParam(name="username")String username,@WebParam(name="password") String password){
        String addingTime = generateTime();//current adding time
        int records;//current record
        String query = "update Users set userPassword='"+password+"' where userName='"+username+"'";//update query
        try{//using try & catch block
            Statement statament = connection.createStatement();//creating statement object
            records = statament.executeUpdate(query);//executing query
        }   catch (SQLException e){//catching SQL Exception
            System.out.println("SQLExceptiom : "+e.toString());//displaying exception message
        }
        String log_out_PASSCHANGED = "Password changed by : "+username+" at : "+addingTime;//building LOG string
        writeToLog(log_out_PASSCHANGED);//writing to LOG
    }

    
    /**
     * Gets user email using their username
     * @param username Example : "bruce7"
     * @return email Example : "bruce7@gmail.com"
     * @throws SQLException
     */
    @WebMethod(operationName="getUserEmail")
    public String getUserEmail(@WebParam(name="username")String username){ 
        String query = "select * from Users where username='"+username+"'";//search query
        String email="";//to store email
        try{//using try & catch block
            Statement statament = connection.createStatement();//creating statement object
            ResultSet records= statament.executeQuery(query);//executing query
            while (records.next()){//looping through records
                email = records.getString("userEmail");//storing user email
                userQuestion = records.getString("userSQuestion");//storing user security question
                userAnswer = records.getString("userSAnswer");//storing user security answer
            }
        }   catch (SQLException e){//catching SQL exception
            System.out.println("SQLExceptiom : "+e.toString());//displaying exception message
        }
        return email;//returning user email.
    }
    

    /**
     * Gets user security question
     * @return Example : "Where were your parents born?" 
     */
    @WebMethod(operationName="getUserQ")
    public String getUserQ(){
        return userQuestion;//returns user security question
    }

    
    /**
     * Gets user security question answer
     * @return Example : "London" 
     */
    @WebMethod(operationName="getUserA")
    public String getUserA(){
        return userAnswer;//returns user security answer
    }
    

    /**
     * Updates user security question and answer.
     * @param username Example : "bruce7"
     * @param question Example : "Where were you born?"
     * @param answer  Example : "Kenya"
     * @throws SQLException
     */
    @WebMethod(operationName="updateSQA")
    public void updateSQA(@WebParam(name="username")String username,@WebParam(name="question") String question,@WebParam(name="answer") String answer){
        String addingTime = generateTime(); //current adding time
        String query = "update Users set userSQuestion='"+question+"', userSAnswer='"+answer+"' where userName='"+username+"'";//update query
        int rows=0;//rows to be updated
        try{
           Statement statement = connection.createStatement();//creating statment object
           rows = statement.executeUpdate(query);//executing query
        }  catch (SQLException e){//catching SQL exception
            System.out.println("SQLEX : "+e.toString());//displaying exception message
        }
        String log_out_SUPDATE = "Security question updated by : "+username+" at : "+addingTime;//building log string
        writeToLog(log_out_SUPDATE); //wrinting to LOG
    }

    
    /**
     * Counts and returns number of replies posted by a user.
     * @param username Example : "bruce7"
     * @return Example : 2
     * @throws SQLException
     */
    @WebMethod(operationName="countReplies")
    public int countReplies(@WebParam(name="username")String username){
        int replies = 0;//counter variable
        String query = "select * from Replies where replyAuthor='"+username+"'";//search query
        try{//using try & catch block
            Statement statament = connection.createStatement();//creating statement object
            ResultSet records= statament.executeQuery(query);//executing query
            while (records.next()){//looping through records
                replies++;//incrementing counter
            }
        }   catch (SQLException e){//catching SQLException
            System.out.println("SQLExceptiom : "+e.toString());//displayinh sql exception message
        }
        return replies;//returns number of replies
    }
    

    /**
     * Counts and returns number of comments posted by a user.
     * @param username Example : "peter1"
     * @return Example : 4
     * @throws SQLException
     */
    @WebMethod(operationName="countComments")
    public int countComments(@WebParam(name="username")String username){
        int comments = 0;//counter variable
        String query = "select * from Comments where commentAuthor='"+username+"'";//search query
        try{//try & catch block
            Statement statament = connection.createStatement();//creating statement object
            ResultSet records= statament.executeQuery(query);//executing query
            while (records.next()){//looping through records
                comments++;//incrementing comments
            }
        }   catch (SQLException e){//catching SQLException 
            System.out.println("SQLException : "+e.toString());//displaying exception message
        }
        return comments;//returning number of comments posted by a user.
    }
    

    /**
     * Counts and returns number of posts posted by a user.
     * @param username Example : "bruce7"
     * @return Example : 7
     */
    @WebMethod(operationName="countPosts")
    public int countPosts(@WebParam(name="username")String username){
        int posts = 0;//counter variable
        String query = "select * from Posts where postAuthor='"+username+"'";//search query
        try{//using try & catch block
            Statement statament = connection.createStatement();//creating statement object
            ResultSet records= statament.executeQuery(query);//executing query
            while (records.next()){//looping through records
                posts++;//incrementing posts counter
            }
        }   catch (SQLException e){//catching SQL Exception
            System.out.println("SQLExceptiom : "+e.toString());//displaying exception message
        }
        return posts;//returning number of posts posted by a user.
    }
    

    /**
     * Resets user password.
     * @param username Example : "bruce7"
     * @param email Example : "bruce7@yahoo.com"
     * @param question Example : "Where were your parents born?"
     * @param answer Example : "London"
     * @param newPassword Example : "brucecanfly"
     * @return output code.
     * OUTPUT CODE MEANINGS:
     *  1 = everything is correct
     *  0 = neutral
     * -1 = user does not exist
     * -2 = email does not match
     * -3 = question does not match
     * -4 = answer does not match
     * @throws SQLException
     */
    @WebMethod(operationName="resetPassword")
    public int resetPassword(@WebParam(name="username")String username,@WebParam(name="email") String email, 
            @WebParam(name="question")String question,@WebParam(name="answer") String answer){
       String addingTime = generateTime(); //gets current adding time & date
       int code = 0; //Neutral
        
        //Checking if username exists
        if(doesUserExist(username, "null")==2){//if user exists
            if(getUserEmail(username).equals(email)){//if email matches
                    if(getUserQ().equals(question)){//if question matches
                        if(getUserA().equals(answer)){//if answer matches
                           code = 1;//asign 1 to code
                        }else {code = -4;} //answer does not match 
                    } else {code = -3;} //question does not match
            } else {code = -2;} //email does not match    
        } else {code = -1;}//user does not exist
        
        return code;//returning OUTPUT code.
    }
    

    /**
     * Deletes user account/profile.
     * @param username Example : "bruce7"
     * @param password Example : "brucecanfly"
     * @return returns OUTPUT CODE:
     * OUTPUT CODE MEANINGS:
     * 0 - neutral
     * 1 - user exists
     * 2 - user does not exists
     */
    @WebMethod(operationName="deleteAccount")
    public int deleteAccount(@WebParam(name="username")String username,@WebParam(name="password") String password){
        String addingTime = generateTime();//
        int code = 0;//output code
        int records;//to execute update query
        
        if(doesUserExist(username, password)==1){//if user exists
           code = 1;//assign 1 to code
        }else if(doesUserExist(username, password)==2){//else if not
            code = 2;//assign 2 to code
        }
        
        if(code==1){//if user exists
         String query = "delete from Users where userName='"+username+"' and userPassword='"+password+"'";//delete query
            try{//try & catch block for SQL Exception
                Statement statament = connection.createStatement();//creating statement obeject
                records = statament.executeUpdate(query);//executing query
            }   catch (SQLException e){//catching SQL Exception
                System.out.println("SQLExceptiom : "+e.toString());//displaying exception message
            }
            String log_out_ACCDEL = "Account deleted by : "+username+" at : "+addingTime;//building LOG string 
            writeToLog(log_out_ACCDEL);//writing to LOG
        }
        return code;//returning output CODE.
    }
    
    
    
}
