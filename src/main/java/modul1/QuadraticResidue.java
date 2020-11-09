package modul1;

import java.math.BigDecimal;
import java.math.BigInteger;

//Zadanie 4
public class QuadraticResidue {

    public BigDecimal quadraticResidue(BigDecimal testedNumber, BigInteger primeNumber){

        BigInteger power = primeNumber.subtract(BigInteger.ONE);
        power = power.divide(BigInteger.TWO);

        return FastPower.bit_pow(testedNumber , power)
                .remainder(new BigDecimal( primeNumber ));
    }

    public boolean isQuadraticResidue(BigDecimal primeNumber, BigInteger testedNumber){
        if(testedNumber.equals(BigInteger.ZERO)){
            return true;
        }
        if(quadraticResidue(primeNumber, testedNumber).equals(BigDecimal.ONE)){
            return true;
        }
        return false;
    }
}
