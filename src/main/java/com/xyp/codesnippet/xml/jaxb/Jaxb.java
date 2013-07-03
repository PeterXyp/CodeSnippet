package com.xyp.codesnippet.xml.jaxb;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Peter Xu
 */
public class Jaxb {

    public static void main(String[] args) {
        individualBookProcess();
        multiBooksProcess();
    }

    /**
     * only one book element
     */
    public static void individualBookProcess() {
        try {
            Book book = new Book("001", "Harry Potter", "J K. Rowling");
            StringWriter sw = new StringWriter();

            JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
            
            //marshaller from javabean to xml
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(book, sw);
            System.out.println(sw.toString());
            
            //unmarshaller from xml to java bean
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Book unmarshal = (Book) unmarshaller.unmarshal(new StringReader(sw.toString()));
            System.out.println(unmarshal);
        } catch (JAXBException ex) {
            Logger.getLogger(Jaxb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * repeated book elements
     */
    public static void multiBooksProcess() {
        Book book1 = new Book("001", "Harry Potter", "J K. Rowling");
        Book book2 = new Book("002", "Harry Potter", "J K. Rowling");
        List<Book> books = new ArrayList();
        books.add(book1);
        books.add(book2);
        BookStore bookStore = new BookStore(2, books);


        try {
            StringWriter sw = new StringWriter();
            JAXBContext jaxbContext = JAXBContext.newInstance(BookStore.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(bookStore, sw);
            System.out.println(sw.toString());

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            BookStore unmarshal = (BookStore) unmarshaller.unmarshal(new StringReader(sw.toString()));
            System.out.println(unmarshal);
        } catch (JAXBException ex) {
            Logger.getLogger(Jaxb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
