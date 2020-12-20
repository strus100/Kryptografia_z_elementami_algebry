package module3;

import modul1.Module1Fasade;
import modul2.CurvePoint;
import modul2.EllipseCurve;

import java.math.BigInteger;
import java.util.ArrayList;

public class ElgamalKrypto {

    private final EllipseCurve curve;
    Module1Fasade module1Fasade = new Module1Fasade();
    int k;

    ElgamalKrypto(EllipseCurve aCurve){
        curve = aCurve;
    }

    public Key generateKey() {
        EllipseCurve curve = new EllipseCurve( k );

        CurvePoint p = curve.generatePointInCurve();

        //TODO Losuje x ∈ N, x < #E(Fp), jest do k - liczba bitów dla E
        BigInteger x = module1Fasade.randWithMaxLimit( k );

        CurvePoint q = curve.power(p, x);

        return new Key( curve, curve.getP(), p, q, x );

    }

    public ArrayList< CurvePoint > encrypt(BigInteger M, Key publicKey ){
        EllipseCurve curve = publicKey.getE();

        //KodujeMnaPMpunkt krzywejE
        CurvePoint point_M = curve.generatePointInCurve();

        //TODO Losuje y ∈ N, y < #E(Fp), jest do k - liczba bitów dla E
        BigInteger y = module1Fasade.randWithMaxLimit( k );

        CurvePoint point = publicKey.getPoint();
        CurvePoint q = publicKey.getQ();

        CurvePoint c_1 = curve.power( point, y );
        CurvePoint c_2 = curve.add( point_M, q );

        ArrayList< CurvePoint > list = new ArrayList<>();
        list.add( c_1 );
        list.add( c_2 );
        return list;
    }

    public void decrypt( ArrayList< CurvePoint > encrypted ){
        CurvePoint c_1 = encrypted.get( 0 );
        CurvePoint c_2 = encrypted.get( 0 );

    }

    CurvePoint mToPointInCurve(BigInteger m, BigInteger n, BigInteger micro, BigInteger p )
    {
        BigInteger x = null;
        BigInteger y = null;

        for (int j = 1; j <= micro.intValue() ; j++) {
             x = m.multiply(micro)
                    .add(BigInteger.valueOf(j))
                    .remainder(p);

            BigInteger f = curve.countF_x(x);
            if( module1Fasade.quadratic(f, p ) == BigInteger.ONE ){
                y = module1Fasade.sqrt(f, p);
            }
        }
        return new CurvePoint( x, y );
    }

    BigInteger pointInCurveToM(CurvePoint point , BigInteger micro ){
        return point.getX().subtract( BigInteger.ONE ).divide( micro );
    }
}

