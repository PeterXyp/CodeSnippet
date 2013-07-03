package com.xyp.codesnippet.xml.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Peter Xu
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    @XmlAttribute(required = true)
    private String id;
    
    @XmlElement(required = true)
    private String title;
    
    @XmlElement(required = true)
    private String author;

    public Book() {
    }

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book{")
                .append("id=").append("\"").append(id).append("\"")
                .append(" title=").append("\"").append(title).append("\"")
                .append(" author=").append("\"").append(author).append("\"")
                .append("}");
        return sb.toString();
    }
}
