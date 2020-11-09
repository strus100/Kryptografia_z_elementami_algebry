package modul1;

import java.math.BigDecimal;
import java.math.BigInteger;

//Zadanie 6
public class FermatTest {
    BigDecimal fermatTest(BigDecimal b, BigInteger n){
        return FastPower.bit_pow(
                 b ,
                n.subtract( BigInteger.valueOf( 1 ) )
        )
                .remainder( new BigDecimal( n ) );
    }

   public boolean isTrue(BigDecimal b, BigInteger n){
        if(fermatTest(b, n).intValue() == 1){
            return true;
        } else {
            return false;
        }
   }
}
