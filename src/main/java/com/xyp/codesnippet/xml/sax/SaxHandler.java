package com.xyp.codesnippet.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Peter Xu
 */
public class SaxHandler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("start parse document");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\nend parse document");
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("<" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(" " + attributes.getQName(i) + "=\"" + attributes.getValue(i) + "\"");
        }
        System.out.print(">");
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("</" + qName + ">");
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print(new String(ch, start, length));
        super.characters(ch, start, length);
    }
}
