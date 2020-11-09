package modul1;

import java.math.BigDecimal;
import java.math.BigInteger;

//Zadanie 5
public class SquareRoot {

    QuadraticResidue quadraticResidue;
    public SquareRoot() {
        quadraticResidue = new QuadraticResidue();
    }

    public BigDecimal squareRoot(BigDecimal bigDecimal, BigInteger modulo){
       if( quadraticResidue.isQuadraticResidue(bigDecimal,modulo) ){
           BigInteger power = modulo.add(BigInteger.valueOf(1))
                   .divide(BigInteger.valueOf(4));
           BigDecimal value = FastPower.bit_pow(bigDecimal, power);

           return value.remainder(new BigDecimal( modulo ) );
       }
        throw new IllegalArgumentException("");
    }


}
