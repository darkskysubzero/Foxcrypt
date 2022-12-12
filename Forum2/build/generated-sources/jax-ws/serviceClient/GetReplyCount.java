
package serviceClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getReplyCount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getReplyCount"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="commentIdentity" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getReplyCount", propOrder = {
    "commentIdentity"
})
public class GetReplyCount {

    protected int commentIdentity;

    /**
     * Gets the value of the commentIdentity property.
     * 
     */
    public int getCommentIdentity() {
        return commentIdentity;
    }

    /**
     * Sets the value of the commentIdentity property.
     * 
     */
    public void setCommentIdentity(int value) {
        this.commentIdentity = value;
    }

}
