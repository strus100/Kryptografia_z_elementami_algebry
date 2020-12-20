package module3;

import modul2.CurvePoint;
import modul2.EllipseCurve;

import java.math.BigInteger;
import java.util.Objects;

public class Key {


    private final EllipseCurve e;
    private final BigInteger p;
    private final CurvePoint point;
    private final CurvePoint q;
    private final BigInteger x;

    Key( EllipseCurve aE, BigInteger aP, CurvePoint aPoint, CurvePoint aQ, BigInteger aX ){
        e = aE;
        p = aP;
        point = aPoint;
        q = aQ;
        x = aX;
    }

    public Key publicKey(){
        return new Key( e, p, point, q, null);
    }

    public Key privateKey(){
        return this;
    }

    public EllipseCurve getE() {
        return e;
    }

    public BigInteger getP() {
        return p;
    }

    public CurvePoint getPoint() {
        return point;
    }

    public CurvePoint getQ() {
        return q;
    }

    public BigInteger getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return Objects.equals(e, key.e) &&
                Objects.equals(p, key.p) &&
                Objects.equals(point, key.point) &&
                Objects.equals(q, key.q) &&
                Objects.equals(x, key.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(e, p, point, q, x);
    }
}
