import modul1.Module1Fasade;

import java.math.BigInteger;

public class Factoryzation {
    Module1Fasade module1Fasade = new Module1Fasade();

    public BigInteger factoryzation(BigInteger n, BigInteger e, BigInteger d ){
        BigInteger temp = e.multiply(d).subtract(BigInteger.ONE);
        BigInteger[] count = count2s(temp);

        BigInteger t = count[0];
        BigInteger s = count[1];

        BigInteger a = module1Fasade.rand(n.bitLength()/2);

        if(false){
            return a;
        }

        BigInteger v = module1Fasade.bit_pow(a, t, n);

        if( v.equals(BigInteger.ONE) ){
            return null;
        }

        BigInteger v_o = null;
        while ( v.compareTo( BigInteger.ONE ) != 0 ){
            v_o = v.remainder(n);
            v = module1Fasade.bit_pow(v,BigInteger.TWO,n);
            System.out.println( v_o.compareTo( BigInteger.ONE ) );
        }

        BigInteger myD;
        if( v_o.equals( BigInteger.valueOf(-1) ) ){
            return null;
        } else{
            myD = v_o.add(BigInteger.ONE).remainder(n);
        }
        return myD;

    }

    private BigInteger[] count2s(BigInteger temp){
        BigInteger s = BigInteger.ONE;
        BigInteger t = new BigInteger( temp.toString() );

        while (t.getLowestSetBit() == 0){
            t = t.divide(BigInteger.TWO);
            s = s.add( BigInteger.ONE );
        }
        return new BigInteger[]{t, s};
    }





}
