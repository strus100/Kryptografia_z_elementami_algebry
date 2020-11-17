package modul1;

import java.math.BigDecimal;
import java.math.BigInteger;

//Zadanie 4
public class QuadraticResidue {

    public BigInteger quadraticResidue(BigInteger a, BigInteger p ){

        BigInteger power = p.subtract(BigInteger.ONE).divide(BigInteger.TWO);

        return FastPower.bit_pow(a , power, p );
    }

    public boolean isQuadraticResidue(BigInteger a, BigInteger p ){
        if(quadraticResidue(a, p).equals(BigInteger.ONE)){
            return true;
        } else {
            return false;
        }
    }
}
