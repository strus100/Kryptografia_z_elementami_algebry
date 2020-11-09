import modul1.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.*;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
 //       Arithmetic arithmetic = new Arithmetic();
  //      System.out.println(arithmetic.randZn(2));

//        EuclideanAlgoritm eucliideanAlgoritm = new EuclideanAlgoritm();
//        eucliideanAlgoritm.euklideanAlgoritm(BigInteger.valueOf(13),BigInteger.valueOf(5));

//        EuclideanTranslator translator = new EuclideanTranslator();
//        System.out.println( translator.translate(eucliideanAlgoritm.getY() ,BigInteger.valueOf(13)) );
/*
        QuadraticResidue quadraticResidue = new QuadraticResidue();
        System.out.println(
                quadraticResidue.isQuadraticResidue(BigInteger.valueOf( 13 ),BigInteger.valueOf( 3 ) )
        );
*/
        SquareRoot squareRoot = new SquareRoot();
        BigDecimal x = squareRoot.squareRoot(BigDecimal.valueOf(2), BigInteger.valueOf(7));
        System.out.println(x);

    }

}
