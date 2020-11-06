package modul1;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FastPowerTest {

    @Test
    public void PowerShouldReturn4(){
        assertEquals(BigDecimal.valueOf(4),FastPower.bit_pow(BigDecimal.valueOf(2), BigInteger.valueOf(2)));
    }


    @Test
    public void PowerShouldReturn10x10pow1000(){
        assertEquals(1001,FastPower.bit_pow(BigDecimal.valueOf(10), BigInteger.valueOf(1000)).toString().length());
    }

    @Test
    public void PowerShouldRetrunBigValue(){
        assertEquals(1000001,FastPower.bit_pow(BigDecimal.valueOf(10), BigInteger.valueOf(1000000)).toString().length());
    }


    @Test
    public void PowerMaxLen(){
        assertEquals(2147483647,FastPower.bit_pow(BigDecimal.valueOf(10), BigInteger.valueOf(2147483646)).toString().length());
    }
}
