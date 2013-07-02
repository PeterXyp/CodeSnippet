package com.xyp.codesnippet.xml.stax;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndDocument;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author Peter Xu
 */
public class StAX {

    public static void main(String[] args) {
        createXmlUseStream();
        createXmlUseEvent();
        parseXmlUseStream();
        parseXmlUseEvent();
    }

    public static void parseXmlUseStream() {
        XMLInputFactory xif = XMLInputFactory.newInstance();
        try {
            XMLStreamReader xsr = xif.createXMLStreamReader(StAX.class.getClassLoader().getResourceAsStream("books.xml"));
            StringBuilder sb = new StringBuilder();
            while (xsr.hasNext()) {
                int eventType = xsr.getEventType();
                switch (eventType) {
                    case XMLEvent.START_DOCUMENT:
                        System.out.println("start document");
                        break;
                    case XMLEvent.START_ELEMENT:
                        System.out.println("start element");
                        sb.append("<").append(xsr.getLocalName());
                        for (int i = 0; i < xsr.getAttributeCount(); i++) {
                            sb.append(" ").append(xsr.getAttributeLocalName(i)).append("=")
                                    .append("\"").append(xsr.getAttributeValue(i)).append("\"");
                        }
                        sb.append(">");
                        break;
                    case XMLEvent.CHARACTERS:
                        sb.append(xsr.getText());
                        break;
                    case XMLEvent.END_ELEMENT:
                        System.out.println("end element");
                        sb.append("</").append(xsr.getLocalName()).append(">");
                        break;
                    case XMLEvent.END_DOCUMENT:
                        System.out.println("end document");
                        break;
                }
                xsr.next();
            }
            System.out.println("" + sb.toString());
        } catch (XMLStreamException ex) {
            Logger.getLogger(StAX.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void parseXmlUseEvent() {
        XMLInputFactory xif = XMLInputFactory.newInstance();
        try {
            XMLEventReader xer = xif.createXMLEventReader(StAX.class.getClassLoader().getResourceAsStream("books.xml"));
            StringBuilder sb = new StringBuilder();
            while (xer.hasNext()) {
                XMLEvent xmlEvent = xer.nextEvent();
                if (xmlEvent.isStartDocument()) {
                    sb.append(xmlEvent).append("\n");
                } else if (xmlEvent.isStartElement()) {
                    StartElement se = (StartElement) xmlEvent;
                    sb.append("<").append(se.getName().getLocalPart());
                    Iterator<Attribute> attrs = se.getAttributes();
                    while (attrs.hasNext()) {
                        Attribute attr = attrs.next();
                        sb.append(" ").append(attr.getName().getLocalPart()).append("=")
                                .append("\"").append(attr.getValue()).append("\"");
                    }
                    sb.append(">");
                } else if (xmlEvent.isCharacters()) {
                    Characters c = (Characters) xmlEvent;
                    sb.append(c.getData());
                } else if (xmlEvent.isEndElement()) {
                    EndElement ee = (EndElement) xmlEvent;
                    sb.append("</").append(ee.getName().getLocalPart()).append(">");
                }
            }
            System.out.println(sb.toString());
        } catch (XMLStreamException ex) {
            Logger.getLogger(StAX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createXmlUseStream() {
        XMLOutputFactory xof = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter xsw = xof.createXMLStreamWriter(System.out, "UTF-8");
            xsw.writeStartDocument("UTF-8", "1.0");
            xsw.writeStartElement("books");
            xsw.writeStartElement("book");
            xsw.writeAttribute("id", "001");
            xsw.writeStartElement("title");
            xsw.writeCharacters("Harry Potter");
            xsw.writeEndElement();
            xsw.writeStartElement("author");
            xsw.writeCharacters("J Bowling");
            xsw.writeEndElement();
            xsw.writeEndElement();
            xsw.writeEndDocument();
            xsw.flush();
        } catch (XMLStreamException ex) {
            Logger.getLogger(StAX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createXmlUseEvent() {
        XMLOutputFactory xof = XMLOutputFactory.newInstance();
        XMLEventFactory xef = XMLEventFactory.newInstance();
        try {
            XMLEventWriter xew = xof.createXMLEventWriter(System.out, "UTF-8");
            StartDocument startDocument = xef.createStartDocument("UTF-8");
            EndDocument endDocument = xef.createEndDocument();
            StartElement startElement = xef.createStartElement(new QName("books"), null, null);
            EndElement endElement;

            xew.add(startDocument);
            xew.add(startElement);
            QName qname = new QName("book");
            Attribute idAttr = xef.createAttribute("id", "001");
            Set<Attribute> attrs = new HashSet();
            attrs.add(idAttr);
            startElement = xef.createStartElement(qname, attrs.iterator(), null);
            xew.add(startElement);
            startElement = xef.createStartElement(new QName("title"), null, null);
            xew.add(startElement);
            xew.add(xef.createCharacters("Harry Potter"));
            endElement = xef.createEndElement(new QName("title"), null);
            xew.add(endElement);
            endElement = xef.createEndElement(new QName("book"), null);
            xew.add(endElement);
            endElement = xef.createEndElement(new QName("books"), null);
            xew.add(endElement);
            xew.add(endDocument);
            xew.flush();
        } catch (XMLStreamException ex) {
            Logger.getLogger(StAX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
