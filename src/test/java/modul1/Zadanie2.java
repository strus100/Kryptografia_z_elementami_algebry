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
        BigInteger y = eucliideanAlgoritm.getY();
        BigInteger test = translator.translate(y, BigInteger.valueOf(13));

        assertEquals(8, test.intValue());
        assertEquals(8, translator.testMet(y,BigInteger.valueOf( 13 )).intValue());
    }

    BigInteger n = new BigInteger( "943923749729479745795479759798579759734597345979578937597359739587398573985793875983759834759735973459873459734985739857359793573598734975983745983745973495734957394579347593847593759734597345973497349857394759347593745934793475973459734957394759374597349573457934759347597345973459734957394579379579579374597359735975173" );
    BigInteger b = new BigInteger( "646364623469634716329421551581459444393459634563465364563456387456873465873645876345876345876345876345876345863458763458763485763485763487563845638465837465834658765735646345645856346875");
    BigInteger k = new BigInteger( "7268263486823646238468236462384682364586385634856834658634586348658365873645874658734658736458763875638475683765834658346586856348756873465863456");



    @Test
    public void functionShouldReturnVeryBig(){
        EuclideanAlgoritm eucliideanAlgoritm = new EuclideanAlgoritm();
        eucliideanAlgoritm.euklideanAlgoritm(n,b);

        EuclideanTranslator translator = new EuclideanTranslator();
        BigInteger test = translator.testMet(eucliideanAlgoritm.getY(), n);

        BigInteger expec = new BigInteger("768920407956494967642616626936090082440192438732854175443162838908930404003018868083832571404954955750818456302110237813902742559869236175505737460224300396760525187764532743362916837205991475114201715105327534601841691482371863740334855065532017472598839345622390213204628024517064234069111877257929978035372508496361996");

        assertEquals(expec, test);
    }
}
