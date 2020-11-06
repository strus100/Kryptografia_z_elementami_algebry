package modul1;

import java.math.BigInteger;

public class EuclideanAlgoritm {
    BigInteger nwd_b, nwd_a;
    BigInteger a, b, q, r, x, x1, x2, y, y1, y2, nwd;

    public void euklideanAlgoritm(BigInteger nwd_a, BigInteger nwd_b){
        this.nwd_a = nwd_a;
        this.nwd_b = nwd_b;

        initializeA_B();
        initializeNWD();
        initializeX_Y();
        core();
        presentResults();
    }

    private void core() {
       while (r.compareTo(BigInteger.ZERO) != 0){
           System.out.println("a:" + a+", b:" + b+", q:" + q+", r:" + r+", x:"+  x+", x1:"+ x1+", x2:"+ x2+", y:"+ y+", y1:"+ y1+", y2:"+ y2+", nwd:"+ nwd+", " + "");
        a = new BigInteger(b.toString());
        b = new BigInteger(r.toString());

        x = calculateCoreXY(x1,x2);
        x2 = new BigInteger(x1.toString());
        x1 = new BigInteger(x.toString());

        y = calculateCoreXY(y1,y2);
        y2 = new BigInteger(y1.toString());
        y1 = new BigInteger(y.toString());

        nwd = new BigInteger(r.toString());
        calculateQR();
       }
    }

    private BigInteger calculateCoreXY(BigInteger x1, BigInteger x2) {
        BigInteger temp1 = q.multiply(x1);
        BigInteger temp2 = x2.subtract(temp1);
        return temp2;
    }

    private void initializeA_B() {
        if(nwd_b.compareTo(nwd_a) > 0){
            b = new BigInteger(nwd_a.toString());
            a = new BigInteger(nwd_b.toString());
        } else {
            a = new BigInteger(nwd_a.toString());
            b = new BigInteger(nwd_b.toString());
        }
    }

    private void calculateQR(){
        q = a.divide(b);
        r = a.mod(b);
    }

    private void initializeNWD() {
        calculateQR();
        nwd = b;
    }

    private void initializeX_Y() {
        x2 = BigInteger.ONE;
        x1 = BigInteger.ZERO;
        y2 = BigInteger.ZERO;
        y1 = BigInteger.ONE;

        x = BigInteger.ONE;
        y = calculateY();
    }

    private BigInteger calculateY() {
        BigInteger temp1 = q.subtract(BigInteger.ONE);
        BigInteger temp2 = temp1.multiply(y1);
        return y2.subtract(temp2);
    }

    public BigInteger getY() {
        return y;
    }

    public BigInteger getNwd_b(){
        return nwd_b;
    }

    private void presentResults() {
        System.out.println("NWD("+nwd_a+", "+nwd_b+") = "+nwd+" = "+x+" * "+nwd_a+" + "+y+" * "+nwd_b);

        if (nwd.equals(2))
            System.out.println(nwd_b+" * "+y+" mod "+nwd_a+" = 1");
    }


}

