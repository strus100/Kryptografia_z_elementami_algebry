package modul1;

import java.math.BigInteger;

public class Module1Fasade {
    public BigInteger rand(int k) {
        Arithmetic a = new Arithmetic();
        return a.randZn(k);
    }

    public boolean isPrimary(BigInteger q) {
        FermatTest fermatTest = new FermatTest();
        return fermatTest.isPrimaryNumber(5, q);
    }

    public BigInteger bit_pow(BigInteger x, BigInteger k, BigInteger n) {
        return FastPower.bit_pow(x, k, n);
    }

    public BigInteger reverse(BigInteger c1, BigInteger p) {
        EuclideanTranslator translator = new EuclideanTranslator();
        EuclideanAlgoritm algoritm = new EuclideanAlgoritm();
        algoritm.euklideanAlgoritm( p, c1 );

        return translator.testMet(algoritm.getY(),p);
    }
}
