package modul1;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class Zadanie4 {

    @Test
    public void functionShouldReturnTrue(){
        QuadraticResidue quadraticResidue = new QuadraticResidue();
        boolean test = quadraticResidue.isQuadraticResidue(BigDecimal.valueOf(8), BigInteger.valueOf(4));
        
        assertFalse(test);
    }

    @Test
    public void functionShouldReturnFalse(){
        QuadraticResidue quadraticResidue = new QuadraticResidue();
        boolean test = quadraticResidue.isQuadraticResidue(BigDecimal.valueOf(13), BigInteger.valueOf(3));

        assertTrue(test);
    }

}
