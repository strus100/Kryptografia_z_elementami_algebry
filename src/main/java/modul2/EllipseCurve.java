package modul2;

import modul1.Module1Fasade;

import java.math.BigInteger;

public class EllipseCurve {
//  Y^2 = X^3 + Ax + B (mod p)

    Module1Fasade module1Fasade = new Module1Fasade();

    BigInteger A;
    BigInteger B;
    BigInteger p;


    public EllipseCurve( BigInteger A, BigInteger B, BigInteger p ){
        this.A = A;
        this.B = B;
        this.p = p;
    }

    public EllipseCurve( int k ){
        do {
            p = module1Fasade.randPrimeKBits(k);
        } while ( !isCongruent() );

        A = module1Fasade.randWithMaxLimit( p.toString().length() - 1 );
        B = module1Fasade.randWithMaxLimit( p.toString().length() - 1 );
        while ( !isElipseCurve() ){
           B = B.add(BigInteger.ONE);
        }
        System.out.println("DONE");
    }

    public CurvePoint generatePointInCurve(){
        BigInteger x = module1Fasade.randWithMaxLimit(p.toString().length() - 1);
        BigInteger f_x = countF_x(x);
        isXGood(f_x);
        BigInteger y = module1Fasade.countOneModN(f_x, p);
        return new CurvePoint( x, y );
    }

    public CurvePoint generateCounterPoint( CurvePoint point ){
        return new CurvePoint( point.getX(), module1Fasade.counter( point.getY(), p) );
    }

    public boolean isElipseCurve(){
        return ( countDelta() != BigInteger.ZERO ) && ( A.compareTo(p) == -1 ) && ( B.compareTo(p) == -1 );
    }

    public boolean isPointInCurve( CurvePoint point ){
        BigInteger f_x = countF_x( point.getX() );
        return isXGood(f_x) && isYGood( point.getY() , f_x);
    }


    public CurvePoint add( CurvePoint point , CurvePoint q ){

        BigInteger lambdaOne = q.getY().subtract( point.getY() );
        BigInteger lambdaTwo = module1Fasade.reverse( q.getX().subtract( point.getX() ), p );
        BigInteger lambda = lambdaOne.multiply(lambdaTwo).remainder(p);

        BigInteger x = module1Fasade
                .bit_pow(lambda, BigInteger.TWO, p)
                .subtract(point.getX())
                .subtract(q.getX())
                .remainder(p);

        BigInteger y = point.getX()
                .subtract(x)
                .multiply(lambda)
                .subtract(point.getY())
                .remainder(p);


        return new CurvePoint( x, y );
    }

    public CurvePoint add( CurvePoint point ){
        BigInteger lambdaOne = module1Fasade
                .bit_pow(point.getX(), BigInteger.TWO, p)
                .multiply(BigInteger.valueOf(3))
                .add(A);

        BigInteger lambdaTwo = module1Fasade
                .reverse(point.getY()
                        .multiply(BigInteger.TWO), p)
                .remainder(p); //This is probably unnessary

        BigInteger lambda = lambdaOne.multiply(lambdaTwo).remainder(p);

        BigInteger x = module1Fasade
                .bit_pow(lambda, BigInteger.TWO, p)
                .subtract(point.getX()
                        .multiply(BigInteger.TWO))
                .remainder(p);

        BigInteger y = point.getX()
                .subtract(x)
                .multiply(lambda)
                .subtract(point.getY())
                .remainder(p);

        return new CurvePoint( x, y );
    }

    public CurvePoint addWhenQEqualsMinusP( CurvePoint point , CurvePoint q ){
        if ( !q.equals( generateCounterPoint( point ) ) ){
            add( point, q );
        }
        return null;
    }

    private boolean isCongruent(){
        BigInteger test = p.remainder(BigInteger.valueOf(4));
       return test.compareTo( BigInteger.valueOf( 3 ) ) == 0 ;
    }

    private BigInteger countDelta(){
        BigInteger tempA = module1Fasade.bit_pow( A, BigInteger.valueOf( 3 ), p );
        tempA = tempA.multiply( BigInteger.valueOf( 4 ));
        BigInteger tempB = module1Fasade.bit_pow( B, BigInteger.valueOf( 2 ), p );
        tempB = tempB.multiply( BigInteger.valueOf( 27 ));

        BigInteger counted = tempA.add(tempB).remainder(p);

        return counted;
    }


    private boolean isXGood( BigInteger f_x ){
        return module1Fasade.quadratic( f_x, p ) != BigInteger.valueOf( -1 );
    }

    private boolean isYGood( BigInteger y, BigInteger f_x ){
        BigInteger tempY = module1Fasade.countOneModN(f_x, p);

        return tempY.compareTo( y ) == 0;
    }

    private BigInteger countF_x(BigInteger x){
       BigInteger f_x = module1Fasade
               .bit_pow(x, BigInteger.valueOf(3), p)
               .add(A.multiply(x))
               .add(B)
               .remainder(p);

       return f_x;
   }

}
