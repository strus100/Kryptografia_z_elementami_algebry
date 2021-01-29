package module4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AESTest {

    @Test
    void suma() {
        AES aes = new AES();
        assertEquals( 0, aes.suma(256,256) );
    }

    @Test
    void xtime() {
        AES aes = new AES();
        assertEquals( 2, aes.xtime(1 ) );

        int x = aes.xtime(87);
        x = aes.xtime(x);
        x = aes.xtime(x);
        x = aes.xtime(x);
        assertEquals(x, 7);

    }


    @Test
    void iloczyn() {
        AES aes = new AES();
        assertEquals( 24, aes.iloczyn(4,6) );
        assertEquals( 7, aes.iloczyn(87,16) );
        assertEquals( 1, aes.iloczyn(58,32) );

    }

    @Test
    void odwrotnosc() {
        AES aes = new AES();
        assertEquals(  58  ,aes.odwrotnosc( 32 )  );
    }


    @Test
    void testToString() {
        AES aes = new AES();
        System.out.println( aes.toString( 283 ) );
    }

    @Test
    void modulo(){
        AES aes = new AES();
        aes.modulo( 7);
    }

    @Test
    void fromBitToDec(){
        AES aes = new AES();
        assertEquals( 58, aes.fromBinToDec("111010")) ;
    }

    @Test
    void fromHexToDec(){
        AES aes = new AES();
        assertEquals( 58, aes.fromHexToDec("3A")) ;
    }

    @Test
    void fromDecToHex(){
        AES aes = new AES();
        assertEquals( "3A", aes.fromDecToHex( 58 ) );
    }
}
