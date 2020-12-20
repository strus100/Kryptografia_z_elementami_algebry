package modul1;

import java.math.BigDecimal;
import java.math.BigInteger;

//Zadanie 5
public class SquareRoot {

    QuadraticResidue quadraticResidue;
    public SquareRoot() {
        quadraticResidue = new QuadraticResidue();
    }

    public BigInteger squareRoot(BigInteger bigDecimal, BigInteger modulo){
       if( quadraticResidue.isQuadraticResidue(bigDecimal,modulo) ){
           BigInteger power = modulo.add(BigInteger.valueOf(1))
                   .divide(BigInteger.valueOf(4));
           BigInteger value = FastPower.bit_pow( bigDecimal ,power, modulo );

           return value.remainder( modulo );
       }
        throw new IllegalArgumentException("");
    }

    public BigInteger squareRootWitoutTest(BigInteger bigDecimal, BigInteger modulo){
            BigInteger power = modulo.add(BigInteger.valueOf(1))
                    .divide(BigInteger.valueOf(4));
            BigInteger value = FastPower.bit_pow( bigDecimal ,power, modulo );

            return value.remainder( modulo );
         }

}
