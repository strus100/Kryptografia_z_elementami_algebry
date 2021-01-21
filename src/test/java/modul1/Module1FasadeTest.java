package modul1;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class Module1FasadeTest {

    @Test
    public void test(){
        Module1Fasade module1Fasade = new Module1Fasade();
        for (int i = 0; i < 1000 ; i++) {

            BigInteger x = module1Fasade.randInRange(BigInteger.TEN);
            assertTrue( x.compareTo( BigInteger.TEN ) == -1 );
        }
    }
}
