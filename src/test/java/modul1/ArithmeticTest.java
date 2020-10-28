package modul1;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticTest {

    @Test
    void randomNumberShouldhaveXbits(){
        Arithmetic arithmetic = new Arithmetic();
        for (int i = 1; i < 2000 ; i++) {
            assertEquals(i,arithmetic.randZn(i).toString().length());
        }
    }

    @Test
    void randomNumberShouldhaveXbitsOnLargeNumbers(){
        Arithmetic arithmetic = new Arithmetic();
        Random random = new Random();
        int start = (int) (random.nextFloat() + 1 * 200000);

        assertEquals(start,arithmetic.randZn(start).toString().length());
    }

    @Test
    void numberShouldbeRandom(){
        Arithmetic arithmetic = new Arithmetic();
        for (int i = 0; i < 10000 ; i++) {
            BigInteger a = arithmetic.randZn(5);
            BigInteger b = arithmetic.randZn(5);
            assertNotEquals(a,b);
        }
    }
}
