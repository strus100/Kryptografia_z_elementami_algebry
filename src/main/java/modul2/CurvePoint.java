package modul2;

import lombok.Getter;

import java.math.BigInteger;
import java.util.Objects;

@Getter
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
}
