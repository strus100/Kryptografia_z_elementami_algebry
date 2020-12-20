package modul2;

import modul1.Module1Fasade;

import java.math.BigInteger;

public class EllipseCurve {
//  Y^2 = X^3 + Ax + B (mod p)

    Module1Fasade module1Fasade = new Module1Fasade();

    BigInteger A;
    BigInteger B;

    public BigInteger getP() {
        return p;
    }

    BigInteger p;
    BigInteger lambdaToTest;

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
           B = module1Fasade.randWithMaxLimit( p.toString().length() - 1 );
        }
    }

    @Override
    public String toString() {
        return "new EllipseCurve( " +
                "new BigInteger( " + A +
                " ), new BigInteger( " + B +
                " ), new BigInteger( " + p +
                " ) );";
    }

    public CurvePoint generatePointInCurve(){
        BigInteger x;
        BigInteger f_x;
        BigInteger y;
        do {

            do{
                x = module1Fasade.randWithMaxLimit( p.toString().length() - 1 );
                f_x = countF_x(x);
            } while ( !isXGood(f_x) );

            y = module1Fasade.sqrt(f_x, p);
        }
        while( !isYGood( y,f_x ) );

        return new CurvePoint( x, y );
    }

    public CurvePoint generateCounterPoint( CurvePoint point ){
        return new CurvePoint( point.getX(), module1Fasade.counter( point.getY().multiply( BigInteger.valueOf( -1 ) ), p) );
    }

    boolean isElipseCurve(){
        return ( countDelta() != BigInteger.ZERO ) && ( A.compareTo(p) == -1 ) && ( B.compareTo(p) == -1 );
    }

    public boolean isPointInCurve( CurvePoint point ){
        BigInteger f_x = countF_x( point.getX() );
        return isXGood(f_x) && isYGood( point.getY() , f_x);
    }


    public CurvePoint add( CurvePoint point , CurvePoint q ){

        if( point.equals( q ) ){
            return add( point );
        }

        CurvePoint counterPoint = generateCounterPoint(point);
        if( counterPoint.isSamePoint( q ) ){
            return null;
        }

            BigInteger lambdaOne = q.getY().subtract(point.getY());
            lambdaOne = module1Fasade.translate( lambdaOne, p );

            BigInteger lambdaToReverse = module1Fasade.translate( q.getX().subtract( point.getX() ), p );
            BigInteger lambdaTwo = module1Fasade.reverse( lambdaToReverse, p);
            BigInteger lambda = lambdaOne.multiply(lambdaTwo).remainder(p);
            lambda = module1Fasade.translate( lambda, p );

            lambdaToTest = lambda;

            BigInteger x = module1Fasade
                    .bit_pow(lambda, BigInteger.TWO, p)
                    .subtract(point.getX())
                    .subtract(q.getX())
                    .remainder(p);

            BigInteger translatedX = module1Fasade.translate(x, p);

            BigInteger y = point.getX();
            y = y.subtract(translatedX);
            y = y.multiply(lambda);
            y = y.subtract(point.getY());
            y = y.remainder(p);

            BigInteger translatedY = module1Fasade.translate(y, p);

            return new CurvePoint( translatedX, translatedY );

    }

    public CurvePoint add( CurvePoint point ){
        BigInteger lambdaOne = module1Fasade.bit_pow(point.getX(), BigInteger.TWO, p);
        lambdaOne = lambdaOne.multiply(BigInteger.valueOf(3));
        lambdaOne = lambdaOne.add(A);
        lambdaOne = lambdaOne.remainder( p );

        BigInteger lambdaTwo = point.getY().multiply(BigInteger.TWO);
        lambdaTwo = lambdaTwo.remainder( p );
        lambdaTwo = module1Fasade.reverse( lambdaTwo , p);
        lambdaTwo = lambdaTwo.remainder(p); //This is probably unnessary

        BigInteger lambda = lambdaOne.multiply(lambdaTwo).remainder(p);

        lambdaToTest = lambda;

        BigInteger x = module1Fasade
                .bit_pow(lambda, BigInteger.TWO, p)
                .subtract(point.getX()
                        .multiply(BigInteger.TWO))
                .remainder(p);

        BigInteger translatedX = module1Fasade.translate( x, p );

        BigInteger y = point.getX();
        y = y.subtract( translatedX );
        y = y.multiply(lambda);
        y = y.subtract(point.getY());
        y = y.remainder(p);

        BigInteger translatedY = module1Fasade.translate( y, p );

        return new CurvePoint( translatedX, translatedY );
    }

    boolean addWhenQEqualsMinusP(CurvePoint point , CurvePoint q ){
        if ( !q.equals(  point  ) ){
            return true;
        }
        return false;
    }

    private boolean isCongruent(){
        BigInteger test = p.remainder(BigInteger.valueOf(4));
       return test.compareTo( BigInteger.valueOf( 3 ) ) == 0 ;
    }

    BigInteger countDelta(){
        BigInteger tempA = module1Fasade.bit_pow( A, BigInteger.valueOf( 3 ), p );
        tempA = tempA.multiply( BigInteger.valueOf( 4 ));
        BigInteger tempB = module1Fasade.bit_pow( B, BigInteger.valueOf( 2 ), p );
        tempB = tempB.multiply( BigInteger.valueOf( 27 ));

        BigInteger counted = tempA.add(tempB).remainder(p);

        return counted;
    }

    boolean isXGood( BigInteger f_x ){
        BigInteger quad = module1Fasade.quadratic(f_x, p);
        boolean bool = quad.compareTo(BigInteger.valueOf(-1)) != 0;
        return bool;
    }

    boolean isYGood( BigInteger y, BigInteger f_x ){
        BigInteger tempY = module1Fasade.bit_pow( y, BigInteger.TWO, p );
        //BigInteger tempY = module1Fasade.countOneModN(y, p);

        return tempY.compareTo( f_x ) == 0;
    }

    public BigInteger countF_x(BigInteger x){
       BigInteger f_x = module1Fasade
               .bit_pow(x, BigInteger.valueOf(3), p)
               .add(A.multiply(x))
               .add(B)
               .remainder(p);

       return f_x;
   }

   //nP
   public CurvePoint power( CurvePoint point, BigInteger n ){
        CurvePoint q = point;
        CurvePoint r = null;
        while( n.compareTo( BigInteger.ZERO ) > 0) {
            if( n.remainder( BigInteger.TWO )
                    .compareTo( BigInteger.ONE ) == 0 )
            {
                if( r != null ){
                    r = add( r, q );
                    n = n.subtract( BigInteger.ONE );
                } else {
                    r = q;
                }
            } else {
                q = add( q );
            }
                n = n.divide( BigInteger.TWO );
        }
        return r;
   }


}
