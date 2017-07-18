package org.fyp.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@IdClass(ContentPK.class)
public class Content {
    private int retailerid;
    private int contentid;
    private Timestamp endDate;
    private String page1;
    private String page2;
    private String page3;
    private Timestamp startDate;

    @Id
    @Column(name = "retailerid", nullable = false)
    public int getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(int retailerid) {
        this.retailerid = retailerid;
    }

    @Id
    @Column(name = "contentid", nullable = false)
    public int getContentid() {
        return contentid;
    }

    public void setContentid(int contentid) {
        this.contentid = contentid;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "page1", nullable = true, length = 255)
    public String getPage1() {
        return page1;
    }

    public void setPage1(String page1) {
        this.page1 = page1;
    }

    @Basic
    @Column(name = "page2", nullable = true, length = 255)
    public String getPage2() {
        return page2;
    }

    public void setPage2(String page2) {
        this.page2 = page2;
    }

    @Basic
    @Column(name = "page3", nullable = true, length = 255)
    public String getPage3() {
        return page3;
    }

    public void setPage3(String page3) {
        this.page3 = page3;
    }

    @Basic
    @Column(name = "start_date", nullable = true)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Content content = (Content) o;

        if (retailerid != content.retailerid) return false;
        if (contentid != content.contentid) return false;
        if (endDate != null ? !endDate.equals(content.endDate) : content.endDate != null) return false;
        if (page1 != null ? !page1.equals(content.page1) : content.page1 != null) return false;
        if (page2 != null ? !page2.equals(content.page2) : content.page2 != null) return false;
        if (page3 != null ? !page3.equals(content.page3) : content.page3 != null) return false;
        if (startDate != null ? !startDate.equals(content.startDate) : content.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = retailerid;
        result = 31 * result + contentid;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (page1 != null ? page1.hashCode() : 0);
        result = 31 * result + (page2 != null ? page2.hashCode() : 0);
        result = 31 * result + (page3 != null ? page3.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        return result;
    }
}
