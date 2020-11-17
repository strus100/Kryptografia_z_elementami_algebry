package modul1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Zadanie6 {


    BigInteger n = new BigInteger( "943923749729479745795479759798579759734597345979578937597359739587398573985793875983759834759735973459873459734985739857359793573598734975983745983745973495734957394579347593847593759734597345973497349857394759347593745934793475973459734957394759374597349573457934759347597345973459734957394579379579579374597359735975173" );
    BigInteger b = new BigInteger( "646364623469634716329421551581459444393459634563465364563456387456873465873645876345876345876345876345876345863458763458763485763485763487563845638465837465834658765735646345645856346875");
    BigInteger k = new BigInteger( "7268263486823646238468236462384682364586385634856834658634586348658365873645874658734658736458763875638475683765834658346586856348756873465863456");

    @Test
    public void big(){
        FermatTest fermatTest = new FermatTest();
        boolean test = fermatTest.isPrimaryNumber(1200, n);
        assertTrue(test);
    }


    @Test
    public void test(){
        FermatTest fermatTest = new FermatTest();
       assertTrue( fermatTest.isPrimaryNumber(12,BigInteger.valueOf(13)) );
    }


    @Test
    public void test3(){
        FermatTest fermatTest = new FermatTest();
        assertFalse( fermatTest.isPrimaryNumber(3,BigInteger.valueOf(4)) );
    }


}
