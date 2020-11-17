package modul1;

import java.math.BigDecimal;
import java.math.BigInteger;

//Zadanie 3
public class FastPower
{
    public static BigInteger bit_pow(BigInteger x, BigInteger k, BigInteger n) {
       BigInteger y = BigInteger.ONE ;
       int i = k.bitLength() - 1;

       while (i >= 0){
           y = y.multiply(y).remainder(n);
           if(k.testBit(i)){
               y = y.multiply(x).remainder(n);
           }
           i--;
       }

       return y;
    }


}

