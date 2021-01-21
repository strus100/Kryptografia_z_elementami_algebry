package module3;

import modul2.CurvePoint;
import modul2.EllipseCurve;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;

class ElgamalKryptoTest {

    @Test
    public void test1(){
        EllipseCurve curve = new EllipseCurve(BigInteger.TWO, BigInteger.valueOf(3), BigInteger.valueOf( 7 ));
        ElgamalKrypto krypto = new ElgamalKrypto( curve, 7, 8 );
        BigInteger y = krypto.generateY(8);
    }


  /*  @Test
    public void test2(){
        EllipseCurve curve = new EllipseCurve(300);
        ElgamalKrypto krypto = new ElgamalKrypto( curve, 300, 4 );
        Key key = krypto.generateKey();

        ArrayList<CurvePoint> encrypted = krypto.encrypt(BigInteger.valueOf(1000), key.publicKey(), krypto.createYToEncrypt() );
        System.out.println( encrypted.get(0) );
        System.out.println( encrypted.get(1) );

        System.out.println( krypto.decrypt( encrypted ) );

    }
*/

    @Test
    public void test3(){
       // A/B/P
        EllipseCurve curve = new EllipseCurve(
                new BigInteger("636570725905242372270703386208271137565360503659727192577162930171089064448313158123807710"),
                new BigInteger("1386087785440151961541463845282560736024254476357014555155771523233455661727838697698095684"),
                new BigInteger("1436215003704927540403665650161861205411298505655993424968064645733520640524806418667161551")
                );

            CurvePoint curvePoint_P = new CurvePoint(
                new BigInteger("1179126676269890951126407839176402161196652671428214253220616541855553114741307245806514626"),
                new BigInteger("140464108107691229681109526015019489632377242759591059157385137909873999273237256407664168")
        );

         CurvePoint P_M = new CurvePoint(
                new BigInteger("654975372010776134364703962902749770386199638882068787680223803654780136831687548390653029"),
                new BigInteger("893647108662258506534906302087006593066101101094364801359662986731978422945828895957005728")
        );


//losowe
        BigInteger x = new BigInteger("128911848203122493772235110387704048330006938000639695745338910327646378125");


        Key key = new Key(curve, curve.getP(), curvePoint_P, null, x );


        ElgamalKrypto krypto = new ElgamalKrypto( key, 8 );

        CurvePoint q = krypto.calculateQ( curvePoint_P, x );

        key.setQ( q );

        System.out.println("P_M ");
        System.out.println( P_M );
        System.out.println("Q");
        System.out.println( q );
           ArrayList<CurvePoint> encrypted = krypto.encrypt(
                P_M,
                key.publicKey(), krypto.createYToEncrypt()  );
//        System.out.println( encrypted.get(0) );
//        System.out.println( encrypted.get(1) );

        System.out.println( "P_M ");
        System.out.println( krypto.decrypt( encrypted ) );

    }

/*

    @Test
    public void test4(){
        // A/B/P
        EllipseCurve curve = new EllipseCurve(
                new BigInteger(""),
                new BigInteger(""),
                new BigInteger("")
        );

        CurvePoint curvePoint_P = new CurvePoint(
                new BigInteger(""),
                new BigInteger("")
        );

        CurvePoint curvePoint_Q = new CurvePoint(
                new BigInteger(""),
                new BigInteger("")
        );

//losowe
        BigInteger x = new BigInteger("");
        BigInteger y = new BigInteger("");

        Key key = new Key(curve, curve.getP(), curvePoint_P, curvePoint_Q, x );

        ElgamalKrypto krypto = new ElgamalKrypto( key, 8 );


        ArrayList<CurvePoint> encrypted = krypto.encrypt(BigInteger.valueOf(1000), key.publicKey(), y );
        System.out.println( encrypted.get(0) );
        System.out.println( encrypted.get(1) );
        System.out.println( krypto.decrypt( encrypted ) );

    }
*/

}
