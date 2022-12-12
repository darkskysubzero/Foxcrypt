
package serviceClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the serviceClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddComment_QNAME = new QName("http://serviceServer/", "addComment");
    private final static QName _AddCommentResponse_QNAME = new QName("http://serviceServer/", "addCommentResponse");
    private final static QName _AddPost_QNAME = new QName("http://serviceServer/", "addPost");
    private final static QName _AddPostResponse_QNAME = new QName("http://serviceServer/", "addPostResponse");
    private final static QName _AddReply_QNAME = new QName("http://serviceServer/", "addReply");
    private final static QName _AddReplyResponse_QNAME = new QName("http://serviceServer/", "addReplyResponse");
    private final static QName _AddUser_QNAME = new QName("http://serviceServer/", "addUser");
    private final static QName _AddUserResponse_QNAME = new QName("http://serviceServer/", "addUserResponse");
    private final static QName _ChangeEmail_QNAME = new QName("http://serviceServer/", "changeEmail");
    private final static QName _ChangeEmailResponse_QNAME = new QName("http://serviceServer/", "changeEmailResponse");
    private final static QName _ChangePassword_QNAME = new QName("http://serviceServer/", "changePassword");
    private final static QName _ChangePasswordResponse_QNAME = new QName("http://serviceServer/", "changePasswordResponse");
    private final static QName _CountComments_QNAME = new QName("http://serviceServer/", "countComments");
    private final static QName _CountCommentsResponse_QNAME = new QName("http://serviceServer/", "countCommentsResponse");
    private final static QName _CountPosts_QNAME = new QName("http://serviceServer/", "countPosts");
    private final static QName _CountPostsResponse_QNAME = new QName("http://serviceServer/", "countPostsResponse");
    private final static QName _CountReplies_QNAME = new QName("http://serviceServer/", "countReplies");
    private final static QName _CountRepliesResponse_QNAME = new QName("http://serviceServer/", "countRepliesResponse");
    private final static QName _DeleteAccount_QNAME = new QName("http://serviceServer/", "deleteAccount");
    private final static QName _DeleteAccountResponse_QNAME = new QName("http://serviceServer/", "deleteAccountResponse");
    private final static QName _DoesUserExist_QNAME = new QName("http://serviceServer/", "doesUserExist");
    private final static QName _DoesUserExistResponse_QNAME = new QName("http://serviceServer/", "doesUserExistResponse");
    private final static QName _FindCommentIdentity_QNAME = new QName("http://serviceServer/", "findCommentIdentity");
    private final static QName _FindCommentIdentityResponse_QNAME = new QName("http://serviceServer/", "findCommentIdentityResponse");
    private final static QName _FindPostAuthor_QNAME = new QName("http://serviceServer/", "findPostAuthor");
    private final static QName _FindPostAuthorResponse_QNAME = new QName("http://serviceServer/", "findPostAuthorResponse");
    private final static QName _GetAuthors_QNAME = new QName("http://serviceServer/", "getAuthors");
    private final static QName _GetAuthorsResponse_QNAME = new QName("http://serviceServer/", "getAuthorsResponse");
    private final static QName _GetCommentAuthors_QNAME = new QName("http://serviceServer/", "getCommentAuthors");
    private final static QName _GetCommentAuthorsResponse_QNAME = new QName("http://serviceServer/", "getCommentAuthorsResponse");
    private final static QName _GetCommentCount_QNAME = new QName("http://serviceServer/", "getCommentCount");
    private final static QName _GetCommentCountResponse_QNAME = new QName("http://serviceServer/", "getCommentCountResponse");
    private final static QName _GetCommentDescription_QNAME = new QName("http://serviceServer/", "getCommentDescription");
    private final static QName _GetCommentDescriptionResponse_QNAME = new QName("http://serviceServer/", "getCommentDescriptionResponse");
    private final static QName _GetCommentIDs_QNAME = new QName("http://serviceServer/", "getCommentIDs");
    private final static QName _GetCommentIDsResponse_QNAME = new QName("http://serviceServer/", "getCommentIDsResponse");
    private final static QName _GetCommentTimes_QNAME = new QName("http://serviceServer/", "getCommentTimes");
    private final static QName _GetCommentTimesResponse_QNAME = new QName("http://serviceServer/", "getCommentTimesResponse");
    private final static QName _GetCommentsData_QNAME = new QName("http://serviceServer/", "getCommentsData");
    private final static QName _GetCommentsDataResponse_QNAME = new QName("http://serviceServer/", "getCommentsDataResponse");
    private final static QName _GetPostCount_QNAME = new QName("http://serviceServer/", "getPostCount");
    private final static QName _GetPostCountResponse_QNAME = new QName("http://serviceServer/", "getPostCountResponse");
    private final static QName _GetPostDateTime_QNAME = new QName("http://serviceServer/", "getPostDateTime");
    private final static QName _GetPostDateTimeResponse_QNAME = new QName("http://serviceServer/", "getPostDateTimeResponse");
    private final static QName _GetPostDesciption_QNAME = new QName("http://serviceServer/", "getPostDesciption");
    private final static QName _GetPostDesciptionResponse_QNAME = new QName("http://serviceServer/", "getPostDesciptionResponse");
    private final static QName _GetPostID_QNAME = new QName("http://serviceServer/", "getPostID");
    private final static QName _GetPostIDResponse_QNAME = new QName("http://serviceServer/", "getPostIDResponse");
    private final static QName _GetPostTitle_QNAME = new QName("http://serviceServer/", "getPostTitle");
    private final static QName _GetPostTitleResponse_QNAME = new QName("http://serviceServer/", "getPostTitleResponse");
    private final static QName _GetPostsData_QNAME = new QName("http://serviceServer/", "getPostsData");
    private final static QName _GetPostsDataResponse_QNAME = new QName("http://serviceServer/", "getPostsDataResponse");
    private final static QName _GetReplyAuthors_QNAME = new QName("http://serviceServer/", "getReplyAuthors");
    private final static QName _GetReplyAuthorsResponse_QNAME = new QName("http://serviceServer/", "getReplyAuthorsResponse");
    private final static QName _GetReplyCount_QNAME = new QName("http://serviceServer/", "getReplyCount");
    private final static QName _GetReplyCountResponse_QNAME = new QName("http://serviceServer/", "getReplyCountResponse");
    private final static QName _GetReplyData_QNAME = new QName("http://serviceServer/", "getReplyData");
    private final static QName _GetReplyDataResponse_QNAME = new QName("http://serviceServer/", "getReplyDataResponse");
    private final static QName _GetReplyDescriptions_QNAME = new QName("http://serviceServer/", "getReplyDescriptions");
    private final static QName _GetReplyDescriptionsResponse_QNAME = new QName("http://serviceServer/", "getReplyDescriptionsResponse");
    private final static QName _GetReplyTimes_QNAME = new QName("http://serviceServer/", "getReplyTimes");
    private final static QName _GetReplyTimesResponse_QNAME = new QName("http://serviceServer/", "getReplyTimesResponse");
    private final static QName _GetSubjects_QNAME = new QName("http://serviceServer/", "getSubjects");
    private final static QName _GetSubjectsResponse_QNAME = new QName("http://serviceServer/", "getSubjectsResponse");
    private final static QName _GetTopicID_QNAME = new QName("http://serviceServer/", "getTopicID");
    private final static QName _GetTopicIDResponse_QNAME = new QName("http://serviceServer/", "getTopicIDResponse");
    private final static QName _GetTotalCommentCount_QNAME = new QName("http://serviceServer/", "getTotalCommentCount");
    private final static QName _GetTotalCommentCountResponse_QNAME = new QName("http://serviceServer/", "getTotalCommentCountResponse");
    private final static QName _GetUserA_QNAME = new QName("http://serviceServer/", "getUserA");
    private final static QName _GetUserAResponse_QNAME = new QName("http://serviceServer/", "getUserAResponse");
    private final static QName _GetUserEmail_QNAME = new QName("http://serviceServer/", "getUserEmail");
    private final static QName _GetUserEmailResponse_QNAME = new QName("http://serviceServer/", "getUserEmailResponse");
    private final static QName _GetUserQ_QNAME = new QName("http://serviceServer/", "getUserQ");
    private final static QName _GetUserQResponse_QNAME = new QName("http://serviceServer/", "getUserQResponse");
    private final static QName _MakeConnection_QNAME = new QName("http://serviceServer/", "makeConnection");
    private final static QName _MakeConnectionResponse_QNAME = new QName("http://serviceServer/", "makeConnectionResponse");
    private final static QName _ResetPassword_QNAME = new QName("http://serviceServer/", "resetPassword");
    private final static QName _ResetPasswordResponse_QNAME = new QName("http://serviceServer/", "resetPasswordResponse");
    private final static QName _UpdateSQA_QNAME = new QName("http://serviceServer/", "updateSQA");
    private final static QName _UpdateSQAResponse_QNAME = new QName("http://serviceServer/", "updateSQAResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: serviceClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddComment }
     * 
     */
    public AddComment createAddComment() {
        return new AddComment();
    }

    /**
     * Create an instance of {@link AddCommentResponse }
     * 
     */
    public AddCommentResponse createAddCommentResponse() {
        return new AddCommentResponse();
    }

    /**
     * Create an instance of {@link AddPost }
     * 
     */
    public AddPost createAddPost() {
        return new AddPost();
    }

    /**
     * Create an instance of {@link AddPostResponse }
     * 
     */
    public AddPostResponse createAddPostResponse() {
        return new AddPostResponse();
    }

    /**
     * Create an instance of {@link AddReply }
     * 
     */
    public AddReply createAddReply() {
        return new AddReply();
    }

    /**
     * Create an instance of {@link AddReplyResponse }
     * 
     */
    public AddReplyResponse createAddReplyResponse() {
        return new AddReplyResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link ChangeEmail }
     * 
     */
    public ChangeEmail createChangeEmail() {
        return new ChangeEmail();
    }

    /**
     * Create an instance of {@link ChangeEmailResponse }
     * 
     */
    public ChangeEmailResponse createChangeEmailResponse() {
        return new ChangeEmailResponse();
    }

    /**
     * Create an instance of {@link ChangePassword }
     * 
     */
    public ChangePassword createChangePassword() {
        return new ChangePassword();
    }

    /**
     * Create an instance of {@link ChangePasswordResponse }
     * 
     */
    public ChangePasswordResponse createChangePasswordResponse() {
        return new ChangePasswordResponse();
    }

    /**
     * Create an instance of {@link CountComments }
     * 
     */
    public CountComments createCountComments() {
        return new CountComments();
    }

    /**
     * Create an instance of {@link CountCommentsResponse }
     * 
     */
    public CountCommentsResponse createCountCommentsResponse() {
        return new CountCommentsResponse();
    }

    /**
     * Create an instance of {@link CountPosts }
     * 
     */
    public CountPosts createCountPosts() {
        return new CountPosts();
    }

    /**
     * Create an instance of {@link CountPostsResponse }
     * 
     */
    public CountPostsResponse createCountPostsResponse() {
        return new CountPostsResponse();
    }

    /**
     * Create an instance of {@link CountReplies }
     * 
     */
    public CountReplies createCountReplies() {
        return new CountReplies();
    }

    /**
     * Create an instance of {@link CountRepliesResponse }
     * 
     */
    public CountRepliesResponse createCountRepliesResponse() {
        return new CountRepliesResponse();
    }

    /**
     * Create an instance of {@link DeleteAccount }
     * 
     */
    public DeleteAccount createDeleteAccount() {
        return new DeleteAccount();
    }

    /**
     * Create an instance of {@link DeleteAccountResponse }
     * 
     */
    public DeleteAccountResponse createDeleteAccountResponse() {
        return new DeleteAccountResponse();
    }

    /**
     * Create an instance of {@link DoesUserExist }
     * 
     */
    public DoesUserExist createDoesUserExist() {
        return new DoesUserExist();
    }

    /**
     * Create an instance of {@link DoesUserExistResponse }
     * 
     */
    public DoesUserExistResponse createDoesUserExistResponse() {
        return new DoesUserExistResponse();
    }

    /**
     * Create an instance of {@link FindCommentIdentity }
     * 
     */
    public FindCommentIdentity createFindCommentIdentity() {
        return new FindCommentIdentity();
    }

    /**
     * Create an instance of {@link FindCommentIdentityResponse }
     * 
     */
    public FindCommentIdentityResponse createFindCommentIdentityResponse() {
        return new FindCommentIdentityResponse();
    }

    /**
     * Create an instance of {@link FindPostAuthor }
     * 
     */
    public FindPostAuthor createFindPostAuthor() {
        return new FindPostAuthor();
    }

    /**
     * Create an instance of {@link FindPostAuthorResponse }
     * 
     */
    public FindPostAuthorResponse createFindPostAuthorResponse() {
        return new FindPostAuthorResponse();
    }

    /**
     * Create an instance of {@link GetAuthors }
     * 
     */
    public GetAuthors createGetAuthors() {
        return new GetAuthors();
    }

    /**
     * Create an instance of {@link GetAuthorsResponse }
     * 
     */
    public GetAuthorsResponse createGetAuthorsResponse() {
        return new GetAuthorsResponse();
    }

    /**
     * Create an instance of {@link GetCommentAuthors }
     * 
     */
    public GetCommentAuthors createGetCommentAuthors() {
        return new GetCommentAuthors();
    }

    /**
     * Create an instance of {@link GetCommentAuthorsResponse }
     * 
     */
    public GetCommentAuthorsResponse createGetCommentAuthorsResponse() {
        return new GetCommentAuthorsResponse();
    }

    /**
     * Create an instance of {@link GetCommentCount }
     * 
     */
    public GetCommentCount createGetCommentCount() {
        return new GetCommentCount();
    }

    /**
     * Create an instance of {@link GetCommentCountResponse }
     * 
     */
    public GetCommentCountResponse createGetCommentCountResponse() {
        return new GetCommentCountResponse();
    }

    /**
     * Create an instance of {@link GetCommentDescription }
     * 
     */
    public GetCommentDescription createGetCommentDescription() {
        return new GetCommentDescription();
    }

    /**
     * Create an instance of {@link GetCommentDescriptionResponse }
     * 
     */
    public GetCommentDescriptionResponse createGetCommentDescriptionResponse() {
        return new GetCommentDescriptionResponse();
    }

    /**
     * Create an instance of {@link GetCommentIDs }
     * 
     */
    public GetCommentIDs createGetCommentIDs() {
        return new GetCommentIDs();
    }

    /**
     * Create an instance of {@link GetCommentIDsResponse }
     * 
     */
    public GetCommentIDsResponse createGetCommentIDsResponse() {
        return new GetCommentIDsResponse();
    }

    /**
     * Create an instance of {@link GetCommentTimes }
     * 
     */
    public GetCommentTimes createGetCommentTimes() {
        return new GetCommentTimes();
    }

    /**
     * Create an instance of {@link GetCommentTimesResponse }
     * 
     */
    public GetCommentTimesResponse createGetCommentTimesResponse() {
        return new GetCommentTimesResponse();
    }

    /**
     * Create an instance of {@link GetCommentsData }
     * 
     */
    public GetCommentsData createGetCommentsData() {
        return new GetCommentsData();
    }

    /**
     * Create an instance of {@link GetCommentsDataResponse }
     * 
     */
    public GetCommentsDataResponse createGetCommentsDataResponse() {
        return new GetCommentsDataResponse();
    }

    /**
     * Create an instance of {@link GetPostCount }
     * 
     */
    public GetPostCount createGetPostCount() {
        return new GetPostCount();
    }

    /**
     * Create an instance of {@link GetPostCountResponse }
     * 
     */
    public GetPostCountResponse createGetPostCountResponse() {
        return new GetPostCountResponse();
    }

    /**
     * Create an instance of {@link GetPostDateTime }
     * 
     */
    public GetPostDateTime createGetPostDateTime() {
        return new GetPostDateTime();
    }

    /**
     * Create an instance of {@link GetPostDateTimeResponse }
     * 
     */
    public GetPostDateTimeResponse createGetPostDateTimeResponse() {
        return new GetPostDateTimeResponse();
    }

    /**
     * Create an instance of {@link GetPostDesciption }
     * 
     */
    public GetPostDesciption createGetPostDesciption() {
        return new GetPostDesciption();
    }

    /**
     * Create an instance of {@link GetPostDesciptionResponse }
     * 
     */
    public GetPostDesciptionResponse createGetPostDesciptionResponse() {
        return new GetPostDesciptionResponse();
    }

    /**
     * Create an instance of {@link GetPostID }
     * 
     */
    public GetPostID createGetPostID() {
        return new GetPostID();
    }

    /**
     * Create an instance of {@link GetPostIDResponse }
     * 
     */
    public GetPostIDResponse createGetPostIDResponse() {
        return new GetPostIDResponse();
    }

    /**
     * Create an instance of {@link GetPostTitle }
     * 
     */
    public GetPostTitle createGetPostTitle() {
        return new GetPostTitle();
    }

    /**
     * Create an instance of {@link GetPostTitleResponse }
     * 
     */
    public GetPostTitleResponse createGetPostTitleResponse() {
        return new GetPostTitleResponse();
    }

    /**
     * Create an instance of {@link GetPostsData }
     * 
     */
    public GetPostsData createGetPostsData() {
        return new GetPostsData();
    }

    /**
     * Create an instance of {@link GetPostsDataResponse }
     * 
     */
    public GetPostsDataResponse createGetPostsDataResponse() {
        return new GetPostsDataResponse();
    }

    /**
     * Create an instance of {@link GetReplyAuthors }
     * 
     */
    public GetReplyAuthors createGetReplyAuthors() {
        return new GetReplyAuthors();
    }

    /**
     * Create an instance of {@link GetReplyAuthorsResponse }
     * 
     */
    public GetReplyAuthorsResponse createGetReplyAuthorsResponse() {
        return new GetReplyAuthorsResponse();
    }

    /**
     * Create an instance of {@link GetReplyCount }
     * 
     */
    public GetReplyCount createGetReplyCount() {
        return new GetReplyCount();
    }

    /**
     * Create an instance of {@link GetReplyCountResponse }
     * 
     */
    public GetReplyCountResponse createGetReplyCountResponse() {
        return new GetReplyCountResponse();
    }

    /**
     * Create an instance of {@link GetReplyData }
     * 
     */
    public GetReplyData createGetReplyData() {
        return new GetReplyData();
    }

    /**
     * Create an instance of {@link GetReplyDataResponse }
     * 
     */
    public GetReplyDataResponse createGetReplyDataResponse() {
        return new GetReplyDataResponse();
    }

    /**
     * Create an instance of {@link GetReplyDescriptions }
     * 
     */
    public GetReplyDescriptions createGetReplyDescriptions() {
        return new GetReplyDescriptions();
    }

    /**
     * Create an instance of {@link GetReplyDescriptionsResponse }
     * 
     */
    public GetReplyDescriptionsResponse createGetReplyDescriptionsResponse() {
        return new GetReplyDescriptionsResponse();
    }

    /**
     * Create an instance of {@link GetReplyTimes }
     * 
     */
    public GetReplyTimes createGetReplyTimes() {
        return new GetReplyTimes();
    }

    /**
     * Create an instance of {@link GetReplyTimesResponse }
     * 
     */
    public GetReplyTimesResponse createGetReplyTimesResponse() {
        return new GetReplyTimesResponse();
    }

    /**
     * Create an instance of {@link GetSubjects }
     * 
     */
    public GetSubjects createGetSubjects() {
        return new GetSubjects();
    }

    /**
     * Create an instance of {@link GetSubjectsResponse }
     * 
     */
    public GetSubjectsResponse createGetSubjectsResponse() {
        return new GetSubjectsResponse();
    }

    /**
     * Create an instance of {@link GetTopicID }
     * 
     */
    public GetTopicID createGetTopicID() {
        return new GetTopicID();
    }

    /**
     * Create an instance of {@link GetTopicIDResponse }
     * 
     */
    public GetTopicIDResponse createGetTopicIDResponse() {
        return new GetTopicIDResponse();
    }

    /**
     * Create an instance of {@link GetTotalCommentCount }
     * 
     */
    public GetTotalCommentCount createGetTotalCommentCount() {
        return new GetTotalCommentCount();
    }

    /**
     * Create an instance of {@link GetTotalCommentCountResponse }
     * 
     */
    public GetTotalCommentCountResponse createGetTotalCommentCountResponse() {
        return new GetTotalCommentCountResponse();
    }

    /**
     * Create an instance of {@link GetUserA }
     * 
     */
    public GetUserA createGetUserA() {
        return new GetUserA();
    }

    /**
     * Create an instance of {@link GetUserAResponse }
     * 
     */
    public GetUserAResponse createGetUserAResponse() {
        return new GetUserAResponse();
    }

    /**
     * Create an instance of {@link GetUserEmail }
     * 
     */
    public GetUserEmail createGetUserEmail() {
        return new GetUserEmail();
    }

    /**
     * Create an instance of {@link GetUserEmailResponse }
     * 
     */
    public GetUserEmailResponse createGetUserEmailResponse() {
        return new GetUserEmailResponse();
    }

    /**
     * Create an instance of {@link GetUserQ }
     * 
     */
    public GetUserQ createGetUserQ() {
        return new GetUserQ();
    }

    /**
     * Create an instance of {@link GetUserQResponse }
     * 
     */
    public GetUserQResponse createGetUserQResponse() {
        return new GetUserQResponse();
    }

    /**
     * Create an instance of {@link MakeConnection }
     * 
     */
    public MakeConnection createMakeConnection() {
        return new MakeConnection();
    }

    /**
     * Create an instance of {@link MakeConnectionResponse }
     * 
     */
    public MakeConnectionResponse createMakeConnectionResponse() {
        return new MakeConnectionResponse();
    }

    /**
     * Create an instance of {@link ResetPassword }
     * 
     */
    public ResetPassword createResetPassword() {
        return new ResetPassword();
    }

    /**
     * Create an instance of {@link ResetPasswordResponse }
     * 
     */
    public ResetPasswordResponse createResetPasswordResponse() {
        return new ResetPasswordResponse();
    }

    /**
     * Create an instance of {@link UpdateSQA }
     * 
     */
    public UpdateSQA createUpdateSQA() {
        return new UpdateSQA();
    }

    /**
     * Create an instance of {@link UpdateSQAResponse }
     * 
     */
    public UpdateSQAResponse createUpdateSQAResponse() {
        return new UpdateSQAResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "addComment")
    public JAXBElement<AddComment> createAddComment(AddComment value) {
        return new JAXBElement<AddComment>(_AddComment_QNAME, AddComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "addCommentResponse")
    public JAXBElement<AddCommentResponse> createAddCommentResponse(AddCommentResponse value) {
        return new JAXBElement<AddCommentResponse>(_AddCommentResponse_QNAME, AddCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "addPost")
    public JAXBElement<AddPost> createAddPost(AddPost value) {
        return new JAXBElement<AddPost>(_AddPost_QNAME, AddPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "addPostResponse")
    public JAXBElement<AddPostResponse> createAddPostResponse(AddPostResponse value) {
        return new JAXBElement<AddPostResponse>(_AddPostResponse_QNAME, AddPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "addReply")
    public JAXBElement<AddReply> createAddReply(AddReply value) {
        return new JAXBElement<AddReply>(_AddReply_QNAME, AddReply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddReplyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "addReplyResponse")
    public JAXBElement<AddReplyResponse> createAddReplyResponse(AddReplyResponse value) {
        return new JAXBElement<AddReplyResponse>(_AddReplyResponse_QNAME, AddReplyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "changeEmail")
    public JAXBElement<ChangeEmail> createChangeEmail(ChangeEmail value) {
        return new JAXBElement<ChangeEmail>(_ChangeEmail_QNAME, ChangeEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "changeEmailResponse")
    public JAXBElement<ChangeEmailResponse> createChangeEmailResponse(ChangeEmailResponse value) {
        return new JAXBElement<ChangeEmailResponse>(_ChangeEmailResponse_QNAME, ChangeEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "changePassword")
    public JAXBElement<ChangePassword> createChangePassword(ChangePassword value) {
        return new JAXBElement<ChangePassword>(_ChangePassword_QNAME, ChangePassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "changePasswordResponse")
    public JAXBElement<ChangePasswordResponse> createChangePasswordResponse(ChangePasswordResponse value) {
        return new JAXBElement<ChangePasswordResponse>(_ChangePasswordResponse_QNAME, ChangePasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountComments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "countComments")
    public JAXBElement<CountComments> createCountComments(CountComments value) {
        return new JAXBElement<CountComments>(_CountComments_QNAME, CountComments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountCommentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "countCommentsResponse")
    public JAXBElement<CountCommentsResponse> createCountCommentsResponse(CountCommentsResponse value) {
        return new JAXBElement<CountCommentsResponse>(_CountCommentsResponse_QNAME, CountCommentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountPosts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "countPosts")
    public JAXBElement<CountPosts> createCountPosts(CountPosts value) {
        return new JAXBElement<CountPosts>(_CountPosts_QNAME, CountPosts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountPostsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "countPostsResponse")
    public JAXBElement<CountPostsResponse> createCountPostsResponse(CountPostsResponse value) {
        return new JAXBElement<CountPostsResponse>(_CountPostsResponse_QNAME, CountPostsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountReplies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "countReplies")
    public JAXBElement<CountReplies> createCountReplies(CountReplies value) {
        return new JAXBElement<CountReplies>(_CountReplies_QNAME, CountReplies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountRepliesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "countRepliesResponse")
    public JAXBElement<CountRepliesResponse> createCountRepliesResponse(CountRepliesResponse value) {
        return new JAXBElement<CountRepliesResponse>(_CountRepliesResponse_QNAME, CountRepliesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "deleteAccount")
    public JAXBElement<DeleteAccount> createDeleteAccount(DeleteAccount value) {
        return new JAXBElement<DeleteAccount>(_DeleteAccount_QNAME, DeleteAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "deleteAccountResponse")
    public JAXBElement<DeleteAccountResponse> createDeleteAccountResponse(DeleteAccountResponse value) {
        return new JAXBElement<DeleteAccountResponse>(_DeleteAccountResponse_QNAME, DeleteAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoesUserExist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "doesUserExist")
    public JAXBElement<DoesUserExist> createDoesUserExist(DoesUserExist value) {
        return new JAXBElement<DoesUserExist>(_DoesUserExist_QNAME, DoesUserExist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoesUserExistResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "doesUserExistResponse")
    public JAXBElement<DoesUserExistResponse> createDoesUserExistResponse(DoesUserExistResponse value) {
        return new JAXBElement<DoesUserExistResponse>(_DoesUserExistResponse_QNAME, DoesUserExistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCommentIdentity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "findCommentIdentity")
    public JAXBElement<FindCommentIdentity> createFindCommentIdentity(FindCommentIdentity value) {
        return new JAXBElement<FindCommentIdentity>(_FindCommentIdentity_QNAME, FindCommentIdentity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCommentIdentityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "findCommentIdentityResponse")
    public JAXBElement<FindCommentIdentityResponse> createFindCommentIdentityResponse(FindCommentIdentityResponse value) {
        return new JAXBElement<FindCommentIdentityResponse>(_FindCommentIdentityResponse_QNAME, FindCommentIdentityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPostAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "findPostAuthor")
    public JAXBElement<FindPostAuthor> createFindPostAuthor(FindPostAuthor value) {
        return new JAXBElement<FindPostAuthor>(_FindPostAuthor_QNAME, FindPostAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPostAuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "findPostAuthorResponse")
    public JAXBElement<FindPostAuthorResponse> createFindPostAuthorResponse(FindPostAuthorResponse value) {
        return new JAXBElement<FindPostAuthorResponse>(_FindPostAuthorResponse_QNAME, FindPostAuthorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthors }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getAuthors")
    public JAXBElement<GetAuthors> createGetAuthors(GetAuthors value) {
        return new JAXBElement<GetAuthors>(_GetAuthors_QNAME, GetAuthors.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthorsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getAuthorsResponse")
    public JAXBElement<GetAuthorsResponse> createGetAuthorsResponse(GetAuthorsResponse value) {
        return new JAXBElement<GetAuthorsResponse>(_GetAuthorsResponse_QNAME, GetAuthorsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentAuthors }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getCommentAuthors")
    public JAXBElement<GetCommentAuthors> createGetCommentAuthors(GetCommentAuthors value) {
        return new JAXBElement<GetCommentAuthors>(_GetCommentAuthors_QNAME, GetCommentAuthors.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentAuthorsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getCommentAuthorsResponse")
    public JAXBElement<GetCommentAuthorsResponse> createGetCommentAuthorsResponse(GetCommentAuthorsResponse value) {
        return new JAXBElement<GetCommentAuthorsResponse>(_GetCommentAuthorsResponse_QNAME, GetCommentAuthorsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getCommentCount")
    public JAXBElement<GetCommentCount> createGetCommentCount(GetCommentCount value) {
        return new JAXBElement<GetCommentCount>(_GetCommentCount_QNAME, GetCommentCount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentCountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getCommentCountResponse")
    public JAXBElement<GetCommentCountResponse> createGetCommentCountResponse(GetCommentCountResponse value) {
        return new JAXBElement<GetCommentCountResponse>(_GetCommentCountResponse_QNAME, GetCommentCountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentDescription }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getCommentDescription")
    public JAXBElement<GetCommentDescription> createGetCommentDescription(GetCommentDescription value) {
        return new JAXBElement<GetCommentDescription>(_GetCommentDescription_QNAME, GetCommentDescription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentDescriptionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getCommentDescriptionResponse")
    public JAXBElement<GetCommentDescriptionResponse> createGetCommentDescriptionResponse(GetCommentDescriptionResponse value) {
        return new JAXBElement<GetCommentDescriptionResponse>(_GetCommentDescriptionResponse_QNAME, GetCommentDescriptionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentIDs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getCommentIDs")
    public JAXBElement<GetCommentIDs> createGetCommentIDs(GetCommentIDs value) {
        return new JAXBElement<GetCommentIDs>(_GetCommentIDs_QNAME, GetCommentIDs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentIDsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getCommentIDsResponse")
    public JAXBElement<GetCommentIDsResponse> createGetCommentIDsResponse(GetCommentIDsResponse value) {
        return new JAXBElement<GetCommentIDsResponse>(_GetCommentIDsResponse_QNAME, GetCommentIDsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentTimes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getCommentTimes")
    public JAXBElement<GetCommentTimes> createGetCommentTimes(GetCommentTimes value) {
        return new JAXBElement<GetCommentTimes>(_GetCommentTimes_QNAME, GetCommentTimes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentTimesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getCommentTimesResponse")
    public JAXBElement<GetCommentTimesResponse> createGetCommentTimesResponse(GetCommentTimesResponse value) {
        return new JAXBElement<GetCommentTimesResponse>(_GetCommentTimesResponse_QNAME, GetCommentTimesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentsData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getCommentsData")
    public JAXBElement<GetCommentsData> createGetCommentsData(GetCommentsData value) {
        return new JAXBElement<GetCommentsData>(_GetCommentsData_QNAME, GetCommentsData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentsDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getCommentsDataResponse")
    public JAXBElement<GetCommentsDataResponse> createGetCommentsDataResponse(GetCommentsDataResponse value) {
        return new JAXBElement<GetCommentsDataResponse>(_GetCommentsDataResponse_QNAME, GetCommentsDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getPostCount")
    public JAXBElement<GetPostCount> createGetPostCount(GetPostCount value) {
        return new JAXBElement<GetPostCount>(_GetPostCount_QNAME, GetPostCount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostCountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getPostCountResponse")
    public JAXBElement<GetPostCountResponse> createGetPostCountResponse(GetPostCountResponse value) {
        return new JAXBElement<GetPostCountResponse>(_GetPostCountResponse_QNAME, GetPostCountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getPostDateTime")
    public JAXBElement<GetPostDateTime> createGetPostDateTime(GetPostDateTime value) {
        return new JAXBElement<GetPostDateTime>(_GetPostDateTime_QNAME, GetPostDateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostDateTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getPostDateTimeResponse")
    public JAXBElement<GetPostDateTimeResponse> createGetPostDateTimeResponse(GetPostDateTimeResponse value) {
        return new JAXBElement<GetPostDateTimeResponse>(_GetPostDateTimeResponse_QNAME, GetPostDateTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostDesciption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getPostDesciption")
    public JAXBElement<GetPostDesciption> createGetPostDesciption(GetPostDesciption value) {
        return new JAXBElement<GetPostDesciption>(_GetPostDesciption_QNAME, GetPostDesciption.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostDesciptionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getPostDesciptionResponse")
    public JAXBElement<GetPostDesciptionResponse> createGetPostDesciptionResponse(GetPostDesciptionResponse value) {
        return new JAXBElement<GetPostDesciptionResponse>(_GetPostDesciptionResponse_QNAME, GetPostDesciptionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getPostID")
    public JAXBElement<GetPostID> createGetPostID(GetPostID value) {
        return new JAXBElement<GetPostID>(_GetPostID_QNAME, GetPostID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getPostIDResponse")
    public JAXBElement<GetPostIDResponse> createGetPostIDResponse(GetPostIDResponse value) {
        return new JAXBElement<GetPostIDResponse>(_GetPostIDResponse_QNAME, GetPostIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getPostTitle")
    public JAXBElement<GetPostTitle> createGetPostTitle(GetPostTitle value) {
        return new JAXBElement<GetPostTitle>(_GetPostTitle_QNAME, GetPostTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getPostTitleResponse")
    public JAXBElement<GetPostTitleResponse> createGetPostTitleResponse(GetPostTitleResponse value) {
        return new JAXBElement<GetPostTitleResponse>(_GetPostTitleResponse_QNAME, GetPostTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostsData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getPostsData")
    public JAXBElement<GetPostsData> createGetPostsData(GetPostsData value) {
        return new JAXBElement<GetPostsData>(_GetPostsData_QNAME, GetPostsData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostsDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getPostsDataResponse")
    public JAXBElement<GetPostsDataResponse> createGetPostsDataResponse(GetPostsDataResponse value) {
        return new JAXBElement<GetPostsDataResponse>(_GetPostsDataResponse_QNAME, GetPostsDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReplyAuthors }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getReplyAuthors")
    public JAXBElement<GetReplyAuthors> createGetReplyAuthors(GetReplyAuthors value) {
        return new JAXBElement<GetReplyAuthors>(_GetReplyAuthors_QNAME, GetReplyAuthors.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReplyAuthorsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getReplyAuthorsResponse")
    public JAXBElement<GetReplyAuthorsResponse> createGetReplyAuthorsResponse(GetReplyAuthorsResponse value) {
        return new JAXBElement<GetReplyAuthorsResponse>(_GetReplyAuthorsResponse_QNAME, GetReplyAuthorsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReplyCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getReplyCount")
    public JAXBElement<GetReplyCount> createGetReplyCount(GetReplyCount value) {
        return new JAXBElement<GetReplyCount>(_GetReplyCount_QNAME, GetReplyCount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReplyCountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getReplyCountResponse")
    public JAXBElement<GetReplyCountResponse> createGetReplyCountResponse(GetReplyCountResponse value) {
        return new JAXBElement<GetReplyCountResponse>(_GetReplyCountResponse_QNAME, GetReplyCountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReplyData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getReplyData")
    public JAXBElement<GetReplyData> createGetReplyData(GetReplyData value) {
        return new JAXBElement<GetReplyData>(_GetReplyData_QNAME, GetReplyData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReplyDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getReplyDataResponse")
    public JAXBElement<GetReplyDataResponse> createGetReplyDataResponse(GetReplyDataResponse value) {
        return new JAXBElement<GetReplyDataResponse>(_GetReplyDataResponse_QNAME, GetReplyDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReplyDescriptions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getReplyDescriptions")
    public JAXBElement<GetReplyDescriptions> createGetReplyDescriptions(GetReplyDescriptions value) {
        return new JAXBElement<GetReplyDescriptions>(_GetReplyDescriptions_QNAME, GetReplyDescriptions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReplyDescriptionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getReplyDescriptionsResponse")
    public JAXBElement<GetReplyDescriptionsResponse> createGetReplyDescriptionsResponse(GetReplyDescriptionsResponse value) {
        return new JAXBElement<GetReplyDescriptionsResponse>(_GetReplyDescriptionsResponse_QNAME, GetReplyDescriptionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReplyTimes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getReplyTimes")
    public JAXBElement<GetReplyTimes> createGetReplyTimes(GetReplyTimes value) {
        return new JAXBElement<GetReplyTimes>(_GetReplyTimes_QNAME, GetReplyTimes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReplyTimesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getReplyTimesResponse")
    public JAXBElement<GetReplyTimesResponse> createGetReplyTimesResponse(GetReplyTimesResponse value) {
        return new JAXBElement<GetReplyTimesResponse>(_GetReplyTimesResponse_QNAME, GetReplyTimesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubjects }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getSubjects")
    public JAXBElement<GetSubjects> createGetSubjects(GetSubjects value) {
        return new JAXBElement<GetSubjects>(_GetSubjects_QNAME, GetSubjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubjectsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getSubjectsResponse")
    public JAXBElement<GetSubjectsResponse> createGetSubjectsResponse(GetSubjectsResponse value) {
        return new JAXBElement<GetSubjectsResponse>(_GetSubjectsResponse_QNAME, GetSubjectsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTopicID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getTopicID")
    public JAXBElement<GetTopicID> createGetTopicID(GetTopicID value) {
        return new JAXBElement<GetTopicID>(_GetTopicID_QNAME, GetTopicID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTopicIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getTopicIDResponse")
    public JAXBElement<GetTopicIDResponse> createGetTopicIDResponse(GetTopicIDResponse value) {
        return new JAXBElement<GetTopicIDResponse>(_GetTopicIDResponse_QNAME, GetTopicIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTotalCommentCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getTotalCommentCount")
    public JAXBElement<GetTotalCommentCount> createGetTotalCommentCount(GetTotalCommentCount value) {
        return new JAXBElement<GetTotalCommentCount>(_GetTotalCommentCount_QNAME, GetTotalCommentCount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTotalCommentCountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getTotalCommentCountResponse")
    public JAXBElement<GetTotalCommentCountResponse> createGetTotalCommentCountResponse(GetTotalCommentCountResponse value) {
        return new JAXBElement<GetTotalCommentCountResponse>(_GetTotalCommentCountResponse_QNAME, GetTotalCommentCountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserA }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getUserA")
    public JAXBElement<GetUserA> createGetUserA(GetUserA value) {
        return new JAXBElement<GetUserA>(_GetUserA_QNAME, GetUserA.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserAResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getUserAResponse")
    public JAXBElement<GetUserAResponse> createGetUserAResponse(GetUserAResponse value) {
        return new JAXBElement<GetUserAResponse>(_GetUserAResponse_QNAME, GetUserAResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getUserEmail")
    public JAXBElement<GetUserEmail> createGetUserEmail(GetUserEmail value) {
        return new JAXBElement<GetUserEmail>(_GetUserEmail_QNAME, GetUserEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getUserEmailResponse")
    public JAXBElement<GetUserEmailResponse> createGetUserEmailResponse(GetUserEmailResponse value) {
        return new JAXBElement<GetUserEmailResponse>(_GetUserEmailResponse_QNAME, GetUserEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserQ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getUserQ")
    public JAXBElement<GetUserQ> createGetUserQ(GetUserQ value) {
        return new JAXBElement<GetUserQ>(_GetUserQ_QNAME, GetUserQ.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserQResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "getUserQResponse")
    public JAXBElement<GetUserQResponse> createGetUserQResponse(GetUserQResponse value) {
        return new JAXBElement<GetUserQResponse>(_GetUserQResponse_QNAME, GetUserQResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeConnection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "makeConnection")
    public JAXBElement<MakeConnection> createMakeConnection(MakeConnection value) {
        return new JAXBElement<MakeConnection>(_MakeConnection_QNAME, MakeConnection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeConnectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "makeConnectionResponse")
    public JAXBElement<MakeConnectionResponse> createMakeConnectionResponse(MakeConnectionResponse value) {
        return new JAXBElement<MakeConnectionResponse>(_MakeConnectionResponse_QNAME, MakeConnectionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResetPassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "resetPassword")
    public JAXBElement<ResetPassword> createResetPassword(ResetPassword value) {
        return new JAXBElement<ResetPassword>(_ResetPassword_QNAME, ResetPassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResetPasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "resetPasswordResponse")
    public JAXBElement<ResetPasswordResponse> createResetPasswordResponse(ResetPasswordResponse value) {
        return new JAXBElement<ResetPasswordResponse>(_ResetPasswordResponse_QNAME, ResetPasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSQA }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "updateSQA")
    public JAXBElement<UpdateSQA> createUpdateSQA(UpdateSQA value) {
        return new JAXBElement<UpdateSQA>(_UpdateSQA_QNAME, UpdateSQA.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSQAResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceServer/", name = "updateSQAResponse")
    public JAXBElement<UpdateSQAResponse> createUpdateSQAResponse(UpdateSQAResponse value) {
        return new JAXBElement<UpdateSQAResponse>(_UpdateSQAResponse_QNAME, UpdateSQAResponse.class, null, value);
    }

}
