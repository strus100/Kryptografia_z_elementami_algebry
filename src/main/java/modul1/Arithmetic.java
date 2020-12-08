package modul1;

import java.math.BigInteger;
import java.util.Random;
//Zadanie 1
public class Arithmetic {
    public BigInteger randZn(int k){
        BigInteger maxLimit = new BigInteger(maxLimit(k));
        BigInteger minLimit = new BigInteger(minLimit(k));
        Random randNum = new Random();

        int len = maxLimit.bitLength();
        BigInteger res = new BigInteger(len, randNum);
        if (res.compareTo(minLimit) < 0) {
            res = res.add(minLimit);
        }

        if (res.compareTo(maxLimit) >= 0) {
            res = randZn(k);
        }
        return res;
    }

    public BigInteger randZnWithMaxLimit(int k){
        BigInteger maxLimit = new BigInteger(maxLimit(k));
        BigInteger minLimit = new BigInteger("0");
        Random randNum = new Random();

        int len = maxLimit.bitLength();
        BigInteger res = new BigInteger(len, randNum);
        if (res.compareTo(minLimit) < 0) {
            res = res.add(minLimit);
        }

        if (res.compareTo(maxLimit) >= 0) {
            res = randZn(k);
        }
        return res;
    }

    private String maxLimit(int k){
        String max = "";
        for (int i = 0; i < k; i++) {
            max += 9;
        }
        return max;
    }

    private String minLimit(int k){
        String min = "1";
        for (int i = 0; i < k - 1  ; i++) {
            min += 0;
        }

        if(k == 1 ){
            return "0";
        }
        return min;
    }

    public BigInteger randProbablePrime(int k) {
        return BigInteger.probablePrime( k, new Random() );
    }

    public BigInteger randProbablePrimeKBits(int k) {
        return BigInteger.probablePrime( randZn(k).bitLength(), new Random() );
    }
}
