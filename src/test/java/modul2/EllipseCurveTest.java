package modul2;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EllipseCurveTest {

    int SIZE = 300;

    @Test
    public void simpleTest(){
        //Y^2 = X^3 +1 ; E/F7
        EllipseCurve curve = new EllipseCurve( BigInteger.ZERO, BigInteger.ONE, BigInteger.valueOf( 7 ) );

        CurvePoint p = new CurvePoint( BigInteger.valueOf( 1 ),BigInteger.valueOf( 3 ) );

        CurvePoint q = new CurvePoint( BigInteger.valueOf( 2 ),BigInteger.valueOf( 4 ) );


        CurvePoint r = curve.add( p,q );

        assertTrue( curve.isPointInCurve( p ) );
        assertTrue( curve.isPointInCurve( q ) );

        assertEquals(BigInteger.valueOf( 5 ), r.getX() );
        assertEquals(BigInteger.valueOf( 0 ), r.getY() );

    }

    @Test
    public void simpleTest2(){
        //Y^2 = X^3 +1 ; E/F7
        EllipseCurve curve = new EllipseCurve( BigInteger.valueOf( 2 ), BigInteger.valueOf( 15 ), BigInteger.valueOf( 19 ) );

        assertTrue( curve.isElipseCurve() );

        CurvePoint p = new CurvePoint( BigInteger.valueOf( 5 ),BigInteger.valueOf( 6 ) );
        CurvePoint q = new CurvePoint( BigInteger.valueOf( 12 ),BigInteger.valueOf( 0 ) );

        assertTrue( curve.isPointInCurve( p ) );
        assertTrue( curve.isPointInCurve( q ) );


        CurvePoint r = curve.add( p,q );

        CurvePoint r2 = curve.add( p );

        assertTrue( curve.isPointInCurve( r ) );
        assertTrue( curve.isPointInCurve( r2 ) );


    }

    @Test
    public void simpleTest3(){
        EllipseCurve curve = new EllipseCurve(BigInteger.TWO, BigInteger.valueOf(-2), BigInteger.valueOf(11));
        assertTrue( curve.isElipseCurve() );
        CurvePoint p = new CurvePoint(BigInteger.valueOf(8), BigInteger.valueOf(3));

        CurvePoint r = curve.add( p );

        assertEquals(BigInteger.valueOf( 3 ), curve.lambdaToTest );
        assertEquals(BigInteger.valueOf( 4 ), r.getX() );
        assertEquals(BigInteger.valueOf( 9 ), r.getY() );



    }


    @Test
    public void simpleTest4(){
        EllipseCurve curve = new EllipseCurve(BigInteger.TWO, BigInteger.valueOf(3), BigInteger.valueOf(7));
        assertTrue( curve.isElipseCurve() );
        CurvePoint p = new CurvePoint(BigInteger.valueOf(3), BigInteger.valueOf(6));
        CurvePoint q = new CurvePoint(BigInteger.valueOf(6), BigInteger.valueOf(0));
        CurvePoint r = new CurvePoint(BigInteger.valueOf(3), BigInteger.valueOf(1));
        CurvePoint s = new CurvePoint(BigInteger.valueOf(2), BigInteger.valueOf(1));
        CurvePoint t = new CurvePoint(BigInteger.valueOf(2), BigInteger.valueOf(6));


        assertTrue( curve.isPointInCurve( p ) );
        assertTrue( curve.isPointInCurve( q ) );
        assertTrue( curve.isPointInCurve( r ) );
        assertTrue( curve.isPointInCurve( s ) );
        assertTrue( curve.isPointInCurve( t ) );


        CurvePoint test = curve.add( p, q );

        assertTrue( curve.isPointInCurve( test ) );

        assertEquals(BigInteger.valueOf( 5 ), curve.lambdaToTest );
        assertEquals(BigInteger.valueOf( 2 ), test.getX() );
        assertEquals(BigInteger.valueOf( 6 ), test.getY() );

    }


    @Test
    public void simpleTest5(){

        EllipseCurve curve = new EllipseCurve(BigInteger.TWO, BigInteger.valueOf(3), BigInteger.valueOf(7));
        assertTrue( curve.isElipseCurve() );
        CurvePoint p = new CurvePoint(BigInteger.valueOf(3), BigInteger.valueOf(6));
        CurvePoint q = new CurvePoint(BigInteger.valueOf(6), BigInteger.valueOf(0));
        CurvePoint r = new CurvePoint(BigInteger.valueOf(3), BigInteger.valueOf(1));
        CurvePoint s = new CurvePoint(BigInteger.valueOf(2), BigInteger.valueOf(1));
        CurvePoint t = new CurvePoint(BigInteger.valueOf(2), BigInteger.valueOf(6));

        ArrayList<CurvePoint> listGoodPoints = new ArrayList<CurvePoint>();
        listGoodPoints.add(p);
        listGoodPoints.add(q);
        listGoodPoints.add(r);
        listGoodPoints.add(s);
        listGoodPoints.add(t);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7 ; j++) {
                CurvePoint x = new CurvePoint(BigInteger.valueOf(i), BigInteger.valueOf(j));
                if( listGoodPoints.contains( x ) ){
                    assertTrue( curve.isPointInCurve( x ) );
                } else {
                    assertFalse( curve.isPointInCurve( x ) );
                }
            }
        }
    }

    @Test
    public void curveTest1(){
        EllipseCurve curve = new EllipseCurve(BigInteger.valueOf( 7 ), BigInteger.valueOf( 23 ), BigInteger.valueOf( 25 ));
        assertTrue( curve.isElipseCurve() );
        assertEquals( BigInteger.valueOf( 5 ), curve.countDelta() );
    }


    @Test
    public void curveTest2(){
        EllipseCurve curve = new EllipseCurve(BigInteger.valueOf( 11 ), BigInteger.valueOf( 0 ), BigInteger.valueOf( 25 ));
        assertTrue( curve.isElipseCurve() );
        assertEquals( BigInteger.valueOf( 24 ), curve.countDelta() );
    }

    @Test
    public void ultimateTest(){
        EllipseCurve ellipseCurve = new EllipseCurve( SIZE );

        CurvePoint p = ellipseCurve.generatePointInCurve();
        CurvePoint q = ellipseCurve.generatePointInCurve();

        assertTrue( ellipseCurve.isPointInCurve( p ) );
        assertTrue( ellipseCurve.isPointInCurve( q ) );

        CurvePoint r = ellipseCurve.generateCounterPoint( p );

        CurvePoint w1 = ellipseCurve.add( p , q );
        CurvePoint w2  = ellipseCurve.add( p );

        assertTrue( ellipseCurve.isPointInCurve( w1 ) );
        assertTrue( ellipseCurve.isPointInCurve( w2 ) );
        assertTrue( ellipseCurve.isPointInCurve( r ) );
        assertEquals( null, ellipseCurve.add( p , r ) );
    }

    @Test
    public void ultimateTest2(){
        EllipseCurve ellipseCurve = new EllipseCurve( SIZE );


        CurvePoint q = ellipseCurve.generatePointInCurve();

        CurvePoint p = q;

        assertTrue( ellipseCurve.isPointInCurve( p ) );
        assertTrue( ellipseCurve.isPointInCurve( q ) );
        CurvePoint r = ellipseCurve.generateCounterPoint(p);

        for (int i = 0; i < 100; i++) {
            p = ellipseCurve.add(p, q);
            assertTrue(ellipseCurve.isPointInCurve( p ));
        }

    }


    @Test
    public void addPTest(){

        EllipseCurve curve = new EllipseCurve(new BigInteger("26"), new BigInteger("71"), new BigInteger("683"));
        CurvePoint p = new CurvePoint(new BigInteger("96"), new BigInteger("552"));
        CurvePoint r = new CurvePoint(new BigInteger("219"), new BigInteger("330"));
        CurvePoint r2 = new CurvePoint(new BigInteger("212"), new BigInteger("465"));

        CurvePoint rTest = curve.add(p);
        
        assertTrue( curve.isPointInCurve( r2 ) );
    }

    //Testy trzeci moduł
    //---------------------------------------------------------//

    @Test
    public void simplePowerTest(){
        EllipseCurve curve = new EllipseCurve(BigInteger.TWO, BigInteger.valueOf(-2), BigInteger.valueOf(11));
        CurvePoint p = new CurvePoint( BigInteger.valueOf(8), BigInteger.valueOf(3) );

        CurvePoint test = curve.power( p, BigInteger.valueOf( 2 ) );

        assertEquals(BigInteger.valueOf( 4 ), test.getX() );
        assertEquals(BigInteger.valueOf( 9 ), test.getY() );
    }
}
