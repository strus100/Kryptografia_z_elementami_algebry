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
        assertEquals( 2, aes.xtime(1, 1) );
    }

    @Test
    void iloczyn() {
        AES aes = new AES();
        assertEquals( 24, aes.iloczyn(4,6) );
        System.out.println( aes.toString( aes.iloczyn(15,206) ) );

    }

    @Test
    void odwrotnosc() {
        AES aes = new AES();
        System.out.println( aes.toString( aes.odwrotnosc( 14 ) ) );
        System.out.println( aes.toString( 14 ) );
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
}
