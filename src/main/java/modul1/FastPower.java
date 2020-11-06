package modul1;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FastPower
{
    public static BigDecimal bit_pow(BigDecimal base, BigInteger power) {
        BigDecimal res = BigDecimal.ONE;

        while (power.compareTo(BigInteger.ZERO) > 0) {
            BigInteger i = power.and(BigInteger.ONE);
            if (!i.equals(BigInteger.ZERO))
                res = res.multiply(base);
            base = base.multiply(base);
            power = power.shiftRight(1);
            }
        return res;
    }
}
