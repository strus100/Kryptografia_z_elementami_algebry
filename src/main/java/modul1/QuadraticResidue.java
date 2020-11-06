package modul1;

import java.math.BigDecimal;
import java.math.BigInteger;

public class QuadraticResidue {

    public BigDecimal quadraticResidue(BigInteger primeNumber, BigInteger testedNumber){

        BigInteger power = primeNumber.subtract(BigInteger.ONE);
        power = power.divide(BigInteger.TWO);

        return FastPower.bit_pow(new BigDecimal( testedNumber ), power)
                .remainder(new BigDecimal( primeNumber ));
    }

    public boolean isQuadraticResidue(BigInteger primeNumber, BigInteger testedNumber){
        if(testedNumber.equals(BigInteger.ZERO)){
            return true;
        }
        if(quadraticResidue(primeNumber, testedNumber).equals(BigDecimal.ONE)){
            return true;
        }
        return false;
    }
}
