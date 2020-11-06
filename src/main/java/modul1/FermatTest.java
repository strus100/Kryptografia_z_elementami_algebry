package modul1;

import java.math.BigDecimal;
import java.math.BigInteger;

//Zadanie 6
public class FermatTest {
    public BigDecimal fermatTest(BigInteger b, BigInteger n){
        return FastPower.bit_pow(
                new BigDecimal( b ),
                n.subtract( BigInteger.valueOf( 1 ) )
        )
                .remainder( new BigDecimal( n ) );
    }
}
