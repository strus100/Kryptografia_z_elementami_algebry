package modul2;


import java.math.BigInteger;
import java.util.Objects;

public class CurvePoint {

    private BigInteger x;
    private BigInteger y;

    public CurvePoint( BigInteger x, BigInteger y ) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        o = (CurvePoint) o;
        if( this.x == ((CurvePoint) o).getX() && this.y == ((CurvePoint) o).getY() ){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public BigInteger getX() {
        return x;
    }

    public BigInteger getY() {
        return y;
    }


    @Override
    public String toString() {
        return "x " + x + '\n' +
                "y " + y ;
    }

    public boolean isSamePoint(CurvePoint q) {
        boolean boolX = getX().compareTo(q.getX()) == 0;
        boolean boolY = getY().compareTo(q.getY()) == 0;

        return boolX && boolY;
    }
}
