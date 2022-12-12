
package serviceClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addComment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addComment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="commentAuthor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="commentDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="postID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addComment", propOrder = {
    "commentAuthor",
    "commentDesc",
    "postID"
})
public class AddComment {

    protected String commentAuthor;
    protected String commentDesc;
    protected int postID;

    /**
     * Gets the value of the commentAuthor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentAuthor() {
        return commentAuthor;
    }

    /**
     * Sets the value of the commentAuthor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentAuthor(String value) {
        this.commentAuthor = value;
    }

    /**
     * Gets the value of the commentDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentDesc() {
        return commentDesc;
    }

    /**
     * Sets the value of the commentDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentDesc(String value) {
        this.commentDesc = value;
    }

    /**
     * Gets the value of the postID property.
     * 
     */
    public int getPostID() {
        return postID;
    }

    /**
     * Sets the value of the postID property.
     * 
     */
    public void setPostID(int value) {
        this.postID = value;
    }

}
