package modul1;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

//Zadanie2
class Zadanie2 {

    @Test
    public void functionShouldReturn8(){
        EuclideanAlgoritm eucliideanAlgoritm = new EuclideanAlgoritm();
        eucliideanAlgoritm.euklideanAlgoritm(BigInteger.valueOf(13), BigInteger.valueOf(5));

        EuclideanTranslator translator = new EuclideanTranslator();
        BigInteger test = translator.translate(eucliideanAlgoritm.getY(), BigInteger.valueOf(13));

        assertEquals(8, test.intValue());
    }
}
