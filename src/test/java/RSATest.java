import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class RSATest {

    @Test
    public void test(){
        for (int i = 0; i < 10000 ; i++) {
            RSA rsa = new RSA();
            BigInteger c = rsa.encrypt(BigInteger.valueOf(54321));
            assertEquals( BigInteger.valueOf(54321), rsa.decrypt(c) );
            System.out.println(i);
        }

    }

}
