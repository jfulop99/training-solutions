package xtest.soap;

import javax.xml.soap.*;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.UUID;


public class CreateSOAPMessage {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            MessageFactory factory = MessageFactory.newInstance();

            SOAPMessage soapMsg = factory.createMessage();
            SOAPPart part = soapMsg.getSOAPPart();
            part.setContentId("soap");

            SOAPEnvelope envelope = part.getEnvelope();
            SOAPHeader header = envelope.getHeader();
            SOAPBody body = envelope.getBody();

            envelope.removeNamespaceDeclaration(envelope.getPrefix());
            envelope.addNamespaceDeclaration("soap", "http://schemas.xmlsoap.org/soap/envelope/");
            envelope.addNamespaceDeclaration("ns", "http://www.opentravel.org/OTA/2003/05");
            envelope.addNamespaceDeclaration("b", "http://htng.org/2011B");
            envelope.setPrefix("soap");
            header.setPrefix("soap");
            body.setPrefix("soap");
            body.addNamespaceDeclaration("ns", "http://www.opentravel.org/OTA/2003/05");
            body.addNamespaceDeclaration("b", "http://htng.org/2011B");
            body.setAttribute("xmlns:b", "http://htng.org/2011B");


            Name HTNG_HotelCheckInNotifRQ = envelope.createName("HTNG_HotelCheckInNotifRQ", "b", "http://htng.org/2011B");
            SOAPBodyElement element = body.addBodyElement(HTNG_HotelCheckInNotifRQ);
            element.setAttribute("EchoToken", UUID.randomUUID().toString());
            element.setAttribute("TimeStamp", LocalDateTime.now().toString());
            element.setAttribute("Version", "2.0");
            element.setAttribute("Target", "Production");
            SOAPElement property = element.addChildElement(envelope.createName("PropertyInfo", "b", "http://htng.org/2011B"));
            property.setAttribute("ChainCode", "Hun");
            property.setAttribute("BrandCode", "Hun");
            property.setAttribute("HotelCode", "Hun");
            property.setAttribute("HotelName", "Hun");
            property.setAttribute("HotelCodeContext", "Hun");
            SOAPElement room = element.addChildElement(envelope.createName("Room", "b", "http://htng.org/2011B"));
            room.setAttribute("RoomID", "1");
            room.addTextNode(" ");
            SOAPElement hotelReservations = element.addChildElement(envelope.createName("HotelReservations", "b", "http://htng.org/2011B"));
            SOAPElement hotelReservation = hotelReservations.addChildElement(envelope.createName("HotelReservation", "ns", "http://www.opentravel.org/OTA/2003/05"));
            hotelReservation.setAttribute("RoomStayReservation", "true");

            soapMsg.writeTo(System.out);

            FileOutputStream fOut = new FileOutputStream("SoapMessage.xml");
            soapMsg.writeTo(fOut);

            System.out.println();
            System.out.println("SOAP msg created");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    private void alterSoapEnvelope(SaajSoapMessage soapResponse) {
//        try {
//            SOAPMessage soapMessage = soapResponse.getSaajMessage();
//            SOAPPart soapPart = soapMessage.getSOAPPart();
//            SOAPEnvelope envelope = soapPart.getEnvelope();
//            SOAPHeader header = soapMessage.getSOAPHeader();
//            SOAPBody body = soapMessage.getSOAPBody();
//            SOAPFault fault = body.getFault();
//            envelope.removeNamespaceDeclaration(envelope.getPrefix());
//            envelope.addNamespaceDeclaration(PREFERRED_PREFIX, SOAP_ENV_NAMESPACE);
//            envelope.setPrefix(PREFERRED_PREFIX);
//            header.setPrefix(PREFERRED_PREFIX);
//            body.setPrefix(PREFERRED_PREFIX);
//            if (fault != null) {
//                fault.setPrefix(PREFERRED_PREFIX);
//            }
//        } catch (SOAPException e) {
//            e.printStackTrace();
//        }
//    }

}
