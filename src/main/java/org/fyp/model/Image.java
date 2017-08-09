package org.fyp.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "images", schema = "shoptrawler")
public class Image {
    private int imageid;
    private String path;
    private byte[] blob;

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "imageid")
    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "blob")
    public byte[] getBlob() {
        return blob;
    }

    public void setBlob(byte[] blob) {
        this.blob = blob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (imageid != image.imageid) return false;
        if (path != null ? !path.equals(image.path) : image.path != null) return false;
        if (!Arrays.equals(blob, image.blob)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imageid;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(blob);
        return result;
    }
}
