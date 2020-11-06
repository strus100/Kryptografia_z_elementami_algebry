import modul1.*;

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

        QuadraticResidue quadraticResidue = new QuadraticResidue();
        System.out.println(
                quadraticResidue.quadraticResidue(BigInteger.valueOf( 3 ),BigInteger.valueOf( 3 ) )
        );
    }

}
