package org.fyp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Oisin on 7/18/2017.
 */
public class ContentPK implements Serializable {
    private int contentId;
    private int retailerId;

    @Column(name = "contentID")
    @Id
    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    @Column(name = "retailerID")
    @Id
    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContentPK contentPK = (ContentPK) o;

        if (contentId != contentPK.contentId) return false;
        if (retailerId != contentPK.retailerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contentId;
        result = 31 * result + retailerId;
        return result;
    }
}
