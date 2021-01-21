package module3;

import modul1.Module1Fasade;
import modul2.CurvePoint;
import modul2.EllipseCurve;

import java.math.BigInteger;
import java.util.ArrayList;

public class ElgamalKrypto {

    BigInteger micro = BigInteger.valueOf( 50 );


    private EllipseCurve curve;
    public CurvePoint point_M;

    public BigInteger y;
    public BigInteger x;
    Module1Fasade module1Fasade = new Module1Fasade();
    int k;
    int speed;

    public EllipseCurve getCurve() {
        return curve;
    }


    public ElgamalKrypto( EllipseCurve aCurve, int aK, int aSpeed ){
        curve = aCurve;
        k = aK;
        speed = aSpeed;
    }


    public ElgamalKrypto( int aK, int aSpeed ){
        curve = new EllipseCurve( aK );
        k = aK;
        speed = aSpeed;
    }

    public ElgamalKrypto( Key key, int aSpeed ){
        curve = key.getE();
        point_M = key.getPoint();
        x = key.getX();

        speed = aSpeed;
    }

    public Key generateKey() {
        CurvePoint p = curve.generatePointInCurve();
        x = module1Fasade.randInRange( generateY( speed ) );
        System.out.println( x );
        CurvePoint q = calculateQ( p, x );

        return new Key( curve, curve.getP(), p, q, x );

    }

    public CurvePoint calculateQ(CurvePoint p, BigInteger x ){
        return curve.power(p, x,  "Y" );
    }

    public BigInteger createYToEncrypt(){
        return module1Fasade.randInRange( generateY( speed ) );
    }

    public ArrayList< CurvePoint > encrypt(CurvePoint M, Key publicKey, BigInteger aY){
        point_M = M;

        //TODO Losuje y ∈ N, y < #E(Fp), jest do k - liczba bitów dla E
        y = aY;
       // System.out.println(y);
        CurvePoint point = publicKey.getPoint();
        //Point razy x
        CurvePoint q = publicKey.getQ();

        //Point razy y
        CurvePoint c_1 = curve.power( point, y, "Y" );

        //Point razy x razy y
        CurvePoint c_2Temp = curve.power( q, y, "Y" );
        CurvePoint c_2 = curve.add( point_M, c_2Temp );

        ArrayList< CurvePoint > list = new ArrayList<>();
        list.add( c_1 );
        list.add( c_2 );

        return list;
    }

    BigInteger generateY( int speed ) {
        //]E(Fp) =p+1−t,|t|≤2√p
        BigInteger t = curve.getP().sqrt().multiply(BigInteger.TWO);
        String numberToString = curve.getP().add(BigInteger.ONE).subtract(t).toString();
        return new BigInteger( numberToString.substring(0, numberToString.length()/speed ) );
    }

    public CurvePoint decrypt(ArrayList< CurvePoint > encrypted ){

        //Point razy y
        CurvePoint c_1 = encrypted.get( 0 );
        //Point razy x razy y razy M
        CurvePoint c_2 = encrypted.get( 1 );

        //Point razy y razy x
        c_1 = curve.power( c_1, x,  "Y");

        CurvePoint P_m = curve.add( c_2, curve.generateCounterPoint(c_1) );

        return P_m;
//        return pointInCurveToM( P_m );
    }

    CurvePoint mToPointInCurve(BigInteger m, BigInteger p )
    {
        BigInteger x = null;
        BigInteger y = null;


        BigInteger n  = BigInteger.valueOf( m.bitLength() + 1 );

        for (int j = 1; j <= micro.intValue() ; j++) {
             x = m.multiply(micro)
                    .add(BigInteger.valueOf(j))
                    .remainder(p);

            BigInteger f = curve.countF_x(x);
            BigInteger test = module1Fasade.quadratic(f, p);
            if( test.compareTo( BigInteger.ONE ) == 0 ){
                y = module1Fasade.sqrt(f, p);
                return new CurvePoint( x, y );
            }
        }
 //       return new CurvePoint( x, y );
        throw new IllegalStateException("Brak punktu dla wiadmości");
    }

    BigInteger pointInCurveToM( CurvePoint point ){
        return point.getX().subtract( BigInteger.ONE ).divide( micro );
    }
}

