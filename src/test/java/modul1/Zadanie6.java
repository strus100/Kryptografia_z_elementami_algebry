package modul1;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class Zadanie6 {

    @Test
    public void isTrue(){
        FermatTest fermatTest = new FermatTest();
        assertTrue( fermatTest.isTrue(BigDecimal.valueOf(13),BigInteger.valueOf(3)) );
    }

    @Test
    public void isFalse(){
        FermatTest fermatTest = new FermatTest();
        assertFalse( fermatTest.isTrue(BigDecimal.valueOf(4),BigInteger.valueOf(2)) );
    }
}
