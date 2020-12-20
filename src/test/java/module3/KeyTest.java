package module3;

import modul2.CurvePoint;
import modul2.EllipseCurve;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class KeyTest {

    @Test
    public void test(){
        EllipseCurve curve = new EllipseCurve(new BigInteger("26"), new BigInteger("71"), new BigInteger("683"));
        CurvePoint p = new CurvePoint(new BigInteger("96"), new BigInteger("552"));
        CurvePoint q = new CurvePoint(new BigInteger("219"), new BigInteger("330"));


        Key key = new Key( curve, BigInteger.TWO, p, q, BigInteger.valueOf( 1000 ) );

        Key privateKey = key.privateKey();
        Key publicKey = key.publicKey();

        assertEquals( null, publicKey.getX() );
        assertEquals( BigInteger.valueOf( 1000 ), privateKey.getX() );
    }

}
