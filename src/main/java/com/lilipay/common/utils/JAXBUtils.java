package com.lilipay.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class JAXBUtils {

    private JAXBUtils() {
    }

    public static String toString(Object jaxbElement) {
        try (StringWriter stringWriter = new StringWriter()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(jaxbElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(jaxbElement, stringWriter);
            return stringWriter.toString();
        } catch ( IOException | JAXBException | javax.xml.bind.JAXBException e ) {
            throw new JAXBException( e );
        }
    }

    public static String toStringFragment(Object jaxbElement) {
        try (StringWriter stringWriter = new StringWriter()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(jaxbElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.marshal(jaxbElement, stringWriter);
            return stringWriter.toString();
        }catch ( IOException | JAXBException | javax.xml.bind.JAXBException e ) {
            throw new JAXBException( e );
        }
    }

    public static String toString(Object jaxbElement, String encoding) {
        try (StringWriter stringWriter = new StringWriter()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(jaxbElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            marshaller.marshal(jaxbElement, stringWriter);
            return stringWriter.toString();
        }catch ( IOException | JAXBException | javax.xml.bind.JAXBException e ) {
            throw new JAXBException( e );
        }
    }

    public static <T> T toObject(String jaxbString, Class<T> tClass) {
        try (StringReader stringReader = new StringReader(jaxbString)) {
            JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return tClass.cast(unmarshaller.unmarshal(stringReader));
        }catch ( JAXBException | javax.xml.bind.JAXBException e ) {
            throw new JAXBException( e );
        }
    }

    public static String toString(Object jaxbElement, String encoding, String xmlDeclaration) {
        try (StringWriter stringWriter = new StringWriter()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(jaxbElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true); // 去掉xml声明
            stringWriter.write(xmlDeclaration);
            marshaller.marshal(jaxbElement, stringWriter);
            String xml = stringWriter.toString();
            if (StringUtils.isNotEmpty(xml) && xml.endsWith("\n")) {
                xml = xml.substring(0, xml.length() - 1); // 去掉末尾换行符
            }
            return xml;
        }catch ( IOException | JAXBException | javax.xml.bind.JAXBException e ) {
            throw new JAXBException( e );
        }
    }

    public static class JAXBException extends RuntimeException {

        public JAXBException( Throwable cause ) {
            super( cause );
        }

        public JAXBException( String message, Throwable cause ) {
            super( message, cause );
        }
    }
}
