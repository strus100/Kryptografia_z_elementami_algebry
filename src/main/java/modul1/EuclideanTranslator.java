package modul1;

import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Zadanie2
public class EuclideanTranslator {

    public BigInteger translate(BigInteger y, BigInteger lastElement) {
        Map<BigInteger, BigInteger> mapTranslate = initMap(lastElement);

       return mapTranslate.get(y);
    }

    public Map<BigInteger, BigInteger> initMap(BigInteger lastElement) {
        LinkedList<BigInteger> keys = new LinkedList<BigInteger>();
        LinkedList<BigInteger> values = new LinkedList<BigInteger>();
        for (BigInteger i = BigInteger.ONE; i.compareTo(lastElement) <=0 ; i = i.add(BigInteger.ONE)) {
            values.add(i.subtract(BigInteger.ONE));
            keys.add(i.negate());
        }
        Collections.reverse(keys);

       return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(keys::get, values::get));
    }
}
