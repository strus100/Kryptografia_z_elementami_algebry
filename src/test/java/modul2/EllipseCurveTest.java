package modul2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;

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

    @Test
    @Disabled
    public void powerTest(){
        EllipseCurve curve = new EllipseCurve( 20 );
        CurvePoint p = curve.generatePointInCurve();
        LinkedList linkedList = new LinkedList();

        CurvePoint temp = curve.add( p );
        linkedList.add( temp );

        for (int i = 0; i < 100; i++) {
            temp = curve.add( temp, p );
            linkedList.add( temp );
        }

        LinkedList linkedList1 = new LinkedList();
        for (int i = 0; i < 100; i++) {
            temp = curve.power( p, BigInteger.valueOf( i ) );
            linkedList1.add( temp );
        }
        assertTrue( linkedList.containsAll( linkedList1 ) );
    }

    @Test
    public void module2(){

//        EllipseCurve curve = new EllipseCurve( 300 );


        EllipseCurve curve = new EllipseCurve(
                new BigInteger( "64054365795465178956455554933003676174350807920226766469842364181899174270804112718553029476503680783319911913813547909263759437365856255825654277473185657150339667646063262009357953764631361465974295369917153663773843807979947657251589741446809484576252548434064791788921734422752785962703211003372" ),
                new BigInteger( "76979971912439882670177026800521653331249471435820515289601817169356595081600515279871844384898310860028492257399081797816863457168502767534938414490944260660629866206989975434279225361934964998138252332154554212776967611612786671128651733414844772353178717183913951773034475173416418147206680328635" ),
                new BigInteger( "269816980288872323689709807355635489098339138795234166157621052084151437855344022686764506806790530896351807438748963145772758665220832352382769160659316630301678985087948278036178908861611267961329015697566980512701038227281433334407208440710872932903043738256484389865410070850171681680981984497023" )
                );

        //assertTrue( curve.isElipseCurve() );
        System.out.println( "A = " + curve.getA() );
        System.out.println( "B = " + curve.getB() );
        System.out.println( "p = " + curve.getP() );

        CurvePoint p = new CurvePoint(
                new BigInteger( "28184066024991437904138120640196073235480627978137682777507679473827715313845220802888825627910117273129941547255124118740104504688325295927853018674505739165269930448854709830758979070737299575406154074511647898951973396439796488822993707732078369719863090127936210667434371126751064567434133447024" ),
                new BigInteger( "76227948753547622455154915954840749222592800572267647121285447859747032527307267614031988426956445881759027338519004363424114534441956525919443868267198560428717659399027427424953468947701193893150758926175191164511735860740131764887531339954501505330919096712762545247875785233920148900206908925247" )
        );
        CurvePoint q = new CurvePoint(
                new BigInteger( "125028811474207924826148508923606171410053476764805255058830329202165028047561714336379481537241723957157722725895913705320876941287844276080456297805773604887793370067986771112945425125296009393707305438703456680368321329250762678231940949384300500942207403581141922842950263385629290609433682995618" ),
                new BigInteger( "176371718006923417670623836214667639350114160161591741951265131861877809736398105699812918947663431865484146570764037410771344422154100883662801684329864644077741739326096117417391721432626593789456936070913796627802945792912467560225048538775011684640128813396067660391995421176215057475799479732441" )
        );

        System.out.println("p + p ");
        System.out.println( curve.add( p ) );

        System.out.println("p + q ");
        System.out.println( curve.add( p, q ) );

    }

    @Test
    public void testPower(){
        EllipseCurve curve = new EllipseCurve(10);
        CurvePoint point = curve.generatePointInCurve();

        CurvePoint x = curve.power(point, BigInteger.valueOf(100000));

        curve.isPointInCurve( x );
        System.out.println( x );
    }

    @Test
    public void minusTest(){
        EllipseCurve curve = new EllipseCurve(10);
        CurvePoint point = curve.generatePointInCurve();
        CurvePoint point2 = curve.generatePointInCurve();

        CurvePoint testOne = curve.add(point2, point);
        CurvePoint counterPoint = curve.generateCounterPoint( point );

        System.out.println( curve.add( testOne, counterPoint ) );
        System.out.println( point2 );
    }

}
