package modul1;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SquareRoot {

    public BigDecimal[] squareRoot(BigDecimal bigDecimal, BigInteger modulo){
        BigInteger power = modulo.add(BigInteger.valueOf(1))
                .divide(BigInteger.valueOf(4));
        BigDecimal value = FastPower.bit_pow(bigDecimal, power);

        BigDecimal[] bigIntegers = new BigDecimal[2];
        bigIntegers[0] = value.negate();
        bigIntegers[1] = value;

        return bigIntegers;
    }
}
