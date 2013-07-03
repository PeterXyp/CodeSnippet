package com.xyp.codesnippet.xml.jaxb;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Peter Xu
 */
@XmlRootElement(name = "bookstore")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookStore {
    
    private Integer count;
    
    @XmlElement(name = "book")
    @XmlElementWrapper(name = "books")
    private List<Book> book;

    public BookStore() {
    }

    public BookStore(Integer count, List<Book> book) {
        this.count = count;
        this.book = book;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("book store{").append("\n")
                .append("count=").append(count).append("\n")
                .append("books=").append(book).append("\n")
                .append("}");
        return sb.toString();
    }
}
