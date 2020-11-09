package modul1;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticResidueTest {

    @Test
    public void functionShouldReturnTrue(){
        QuadraticResidue quadraticResidue = new QuadraticResidue();
        boolean test = quadraticResidue.isQuadraticResidue(BigInteger.valueOf(8), BigInteger.valueOf(4));
        
        assertFalse(test);
    }

    @Test
    public void functionShouldReturnFalse(){
        QuadraticResidue quadraticResidue = new QuadraticResidue();
        boolean test = quadraticResidue.isQuadraticResidue(BigInteger.valueOf(13), BigInteger.valueOf(3));

        assertTrue(test);
    }

}
