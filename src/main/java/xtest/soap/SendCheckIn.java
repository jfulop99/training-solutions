package xtest.soap;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendCheckIn {

    public static void main(String[] args) {

        try {
            String url = "http://192.168.111.125:8080/SmartInstall/services/StayNotification?wsdl";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
            String roomId = "1";
            String xml = """
                    <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:b="http://htng.org/2011B" xmlns:ns="http://www.opentravel.org/OTA/2003/05">
                       <soap:Header/>
                       <soap:Body>
                          <b:HTNG_HotelCheckInNotifRQ EchoToken="33f07f05-84e5-48ff-b772-894119d5c194" TimeStamp="2011-08-24T09:30:47Z" Target="Production" Version="2.0">     \s
                             <b:PropertyInfo ChainCode="Hun" BrandCode="Hungest" HotelCode="1234" HotelName="Aqua" HotelCodeContext="Context"/>
                             <b:Room RoomID="1"> </b:Room>
                             <b:HotelReservations>
                                <ns:HotelReservation RoomStayReservation="true" CreateDateTime="2011-05-08T09:30:47Z" LastModifyDateTime="2011-05-08T09:30:47Z" ResStatus="Checked In" WalkInIndicator="false" >
                                   <ns:UniqueID Type="14" ID="Reservation123" />
                                   <ns:RoomStays>
                                      <ns:RoomStay>
                                         <ns:TimeSpan Start="2021-03-26" End="2021-03-31" />
                                      </ns:RoomStay>
                                   </ns:RoomStays>
                                   <ns:ResGuests>
                                      <ns:ResGuest GroupEventCode="GRP123">
                                         <ns:Profiles>
                                            <ns:ProfileInfo>
                                               <ns:UniqueID Type="1" ID="GST123" />
                                               <ns:Profile ProfileType="1" CreateDateTime="2001-12-17T09:30:47Z" LastModifyDateTime="2001-12-17T09:30:47Z">
                                                  <ns:Customer Gender="Male" CurrencyCode="HUF" Language="hu-hu">
                                                     <ns:PersonName>
                                                        <ns:NamePrefix>Dr.</ns:NamePrefix>
                                                        <ns:GivenName>Pista</ns:GivenName>
                                                        <ns:Surname>Kis</ns:Surname>
                                                     </ns:PersonName>
                                                  </ns:Customer>
                                               </ns:Profile>
                                            </ns:ProfileInfo>
                                         </ns:Profiles>
                                      </ns:ResGuest>
                                   </ns:ResGuests>
                                </ns:HotelReservation>
                             </b:HotelReservations>
                          </b:HTNG_HotelCheckInNotifRQ>
                       </soap:Body>
                    </soap:Envelope>
                    """;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(xml);
            wr.flush();
            wr.close();
            int responseStatus = con.getResponseCode();
            System.out.println(responseStatus);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("response:" + response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String createCheckIn(String roomId, String givenName, String surName, String namePrefix) {
        return null;
    }

}
