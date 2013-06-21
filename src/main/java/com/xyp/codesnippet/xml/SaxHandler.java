package com.xyp.codesnippet.xml;

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
        System.out.println("end parse document");
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println("uri:"+uri+" localName:"+localName+" qName:"+qName);
        System.out.println("qName:"+qName);
        if(attributes != null){
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("attrName:" + attributes.getQName(i) + " attrValue:" + attributes.getValue(i));
            }
        }
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
    }
    
}
