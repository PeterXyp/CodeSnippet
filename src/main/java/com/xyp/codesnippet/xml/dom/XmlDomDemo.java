package com.xyp.codesnippet.xml.dom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Peter Xu
 */
public class XmlDomDemo {

    private static String xml = "src/main/resources/books.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        createXmlDocument();
        parseXmlDocument();
    }

    public static void createXmlDocument() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            //create document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            //create document
            Document doc = db.newDocument();

            //create root element
            Element root = doc.createElement("books");
            doc.appendChild(root);

            //add book element
            Element bookNode = doc.createElement("book");
            Attr idAttribute = doc.createAttribute("id");
            Element titleNode = doc.createElement("title");
            Element authorNode = doc.createElement("author");

            idAttribute.setNodeValue("001");
            titleNode.appendChild(doc.createTextNode("Harry Potter"));
            authorNode.appendChild(doc.createTextNode("J K. Rowling"));

            bookNode.setAttributeNode(idAttribute);
            bookNode.appendChild(titleNode);
            bookNode.appendChild(authorNode);

            root.appendChild(bookNode);

            //output
            OutputStream os = new FileOutputStream(xml);
            Source xmlsrc = new DOMSource(doc);
            Result res = new StreamResult(os);
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            transformer.transform(xmlsrc, res);
            System.out.println("");
        } catch (ParserConfigurationException | TransformerConfigurationException ex) {
            Logger.getLogger(XmlDomDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException | FileNotFoundException ex) {
            Logger.getLogger(XmlDomDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void parseXmlDocument() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource source = new InputSource(xml);
            Document doc = db.parse(source);
            Element root = doc.getDocumentElement();
            NodeList books = root.getElementsByTagName("book");
            for (int i = 0; i < books.getLength(); i++) {
                Element book = (Element) books.item(i);

                Attr idAttr = book.getAttributeNode("id");
                Element titleNode = (Element) book.getElementsByTagName("title").item(0);
                Element authorNode = (Element) book.getElementsByTagName("author").item(0);

                String id = idAttr.getValue();
                String title = titleNode.getChildNodes().item(0).getNodeValue();
                String author = authorNode.getChildNodes().item(0).getNodeValue();

                System.out.println("id:" + id + " title:" + title + " author:" + author);
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XmlDomDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
