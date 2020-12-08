package modul2;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class EllipseCurveTest {

    @Test
    public void test1(){
        EllipseCurve curve = new EllipseCurve(BigInteger.TWO,BigInteger.valueOf( 8 ), BigInteger.valueOf( 11 ));
        System.out.println( curve.isElipseCurve() );
        System.out.println( curve.isCongruent() );
        System.out.println( curve.isPointInCurve(BigInteger.TWO,BigInteger.valueOf( 3 )) );
        assertEquals( BigInteger.ZERO, curve.countDelta() );

    }
}
