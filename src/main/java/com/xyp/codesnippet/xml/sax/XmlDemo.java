package com.xyp.codesnippet.xml.sax;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Peter Xu
 */
public class XmlDemo {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        InputStream is = XmlDemo.class.getResourceAsStream("../book.xml");
        saxParser.parse(is, new SaxHandler());
    }
}
