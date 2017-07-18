package org.fyp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ContentPK implements Serializable {
    private int retailerid;
    private int contentid;

    @Column(name = "retailerid", nullable = false)
    @Id
    public int getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(int retailerid) {
        this.retailerid = retailerid;
    }

    @Column(name = "contentid", nullable = false)
    @Id
    public int getContentid() {
        return contentid;
    }

    public void setContentid(int contentid) {
        this.contentid = contentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContentPK contentPK = (ContentPK) o;

        if (retailerid != contentPK.retailerid) return false;
        if (contentid != contentPK.contentid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = retailerid;
        result = 31 * result + contentid;
        return result;
    }
}
