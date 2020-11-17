package modul1;

import java.math.BigInteger;
import java.util.ArrayList;

//Zadanie 6
public class FermatTest {

    public boolean isPrimaryNumber(int b, BigInteger n){
        ArrayList<Boolean> boolsList = new ArrayList<>();

        for (int i = 2; i <= b ; i++) {
            boolsList.add( isTrue(BigInteger.valueOf( i ),n) );
        }

        final boolean bool = boolsList.stream().anyMatch( x -> x == true );
        return bool;
    }

    private BigInteger fermatTest(BigInteger b, BigInteger n){
        BigInteger x = FastPower.bit_pow(b, n.subtract(BigInteger.valueOf(1)), n);
        return x;
    }

   private boolean isTrue(BigInteger b, BigInteger n){
           if(fermatTest(b, n).intValue() == 1){
               return true;
           } else {
               return false;
           }
   }

   private ArrayList<Boolean> forGreaterThan5000(BigInteger n){
       ArrayList<Boolean> boolsList = new ArrayList<>();
       for (int i = 0; i <= 5000 ; i++) {
           boolsList.add( isTrue(BigInteger.valueOf( i ),n) );
       }
       return boolsList;
   }

    private ArrayList<Boolean> forLesserThan5000(BigInteger n){
        ArrayList<Boolean> boolsList = new ArrayList<>();
        for (int i = 0; i < n.intValue() ; i++) {
            boolsList.add( isTrue(BigInteger.valueOf( i ),n) );
        }
        return boolsList;
    }

}
