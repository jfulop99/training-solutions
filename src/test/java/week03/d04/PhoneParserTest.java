package week03.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneParserTest {
    @Test
    void testParsePhone(){
        PhoneParser parser = new PhoneParser();

        Phone phone = parser.parsePhone("12-1234567");

        assertEquals( "12", phone.getPrefix());
        assertEquals( "1234567", phone.getNumber());
        assertEquals( "12-1234567", phone.toString());
    }
}
