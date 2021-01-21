package modul1;

import java.math.BigInteger;

public class Module1Fasade {

    public BigInteger sqrt(BigInteger a, BigInteger p ){
        QuadraticResidue quadraticResidue = new QuadraticResidue();
        SquareRoot squareRoot = new SquareRoot();
        BigInteger result = squareRoot.squareRootWitoutTest(a, p);

        if( quadraticResidue.isQuadraticResidue( result, p ) ){
            return result;
        }
        return BigInteger.valueOf(-1);
    }

    public BigInteger rand(int k) {
        Arithmetic a = new Arithmetic();
        return a.randZn(k);
    }

    public BigInteger randInRange( BigInteger max ){
        Arithmetic a = new Arithmetic();

       return a.randInRange( max );
    }
    public BigInteger randWithMaxLimit(int k) {
        Arithmetic a = new Arithmetic();
        return a.randZnWithMaxLimit(k);
    }

    public boolean isPrimary(BigInteger q) {
        FermatTest fermatTest = new FermatTest();
        return fermatTest.isPrimaryNumber(2, q);
    }

    public boolean isRelativelyPrime( BigInteger numberOne, BigInteger numberTwo ){
        FermatTest fermatTest = new FermatTest();
        return fermatTest.isRelativelyPrime(numberOne, numberTwo);
    }

    public BigInteger bit_pow(BigInteger x, BigInteger k, BigInteger n) {
        return FastPower.bit_pow(x, k, n);
    }

    public BigInteger reverse(BigInteger c1, BigInteger p) {
//        if(c1.compareTo( BigInteger.ZERO ) == 0)
//        {
            EuclideanTranslator translator = new EuclideanTranslator();
            EuclideanAlgoritm algoritm = new EuclideanAlgoritm();
            algoritm.euklideanAlgoritm( p, c1 );

            return translator.testMet(algoritm.getY(),p);
//        } else {
//            return p;
//        }
    }

    public BigInteger translate(BigInteger c1, BigInteger p) {
        EuclideanTranslator translator = new EuclideanTranslator();

        return translator.testMet( c1, p );
    }

        public BigInteger counter(BigInteger x, BigInteger p){
        EuclideanTranslator translator = new EuclideanTranslator();
        return translator.testMet( x, p );

    }

    public BigInteger randPrime(int k) {
        Arithmetic a = new Arithmetic();
        BigInteger p;

        do{
            p = a.randProbablePrime(k);
        } while (!isPrimary(p));

        return p;
    }

    public BigInteger randPrimeKBits(int k) {
        Arithmetic a = new Arithmetic();
        BigInteger p;
        p = a.randProbablePrimeKBits(k);
        return p;
    }

    public BigInteger fastRandPrime(int k) {
        BigInteger p;

        do{
            p = rand(k);
        } while (!isPrimary(p));

        return p;
    }

    public BigInteger quadratic(BigInteger f_x, BigInteger p) {
        QuadraticResidue quadraticResidue = new QuadraticResidue();
        return quadraticResidue.quadraticResidue( f_x, p );
    }


    public boolean isQuadratic(BigInteger valueOf, BigInteger valueOf1) {
        QuadraticResidue quadraticResidue = new QuadraticResidue();

        return quadraticResidue.isQuadraticResidue(valueOf, valueOf1);
    }
}
