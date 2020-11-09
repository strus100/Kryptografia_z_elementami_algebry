package modul1;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class Zadanie5 {

    @Test
    public void functionShouldReturn2(){
        SquareRoot squareRoot = new SquareRoot();
        BigDecimal test = squareRoot.squareRoot(BigDecimal.valueOf(4), BigInteger.valueOf(7));

        assertEquals(2, test.intValue());
    }


    @Test
    public void functionShouldReturn4(){
        SquareRoot squareRoot = new SquareRoot();
        BigDecimal test = squareRoot.squareRoot(BigDecimal.valueOf(2), BigInteger.valueOf(7));

        assertEquals(4, test.intValue());
    }


    @Test
    public void functionShouldReturn1(){
        SquareRoot squareRoot = new SquareRoot();
        BigDecimal test = squareRoot.squareRoot(BigDecimal.valueOf(1), BigInteger.valueOf(7));

        assertEquals(1, test.intValue());
    }
}
