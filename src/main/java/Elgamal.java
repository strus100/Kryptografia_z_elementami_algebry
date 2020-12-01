import modul1.Module1Fasade;

import java.math.BigInteger;
import java.util.ArrayList;

public class Elgamal {

    ArrayList K_A = null;
    BigInteger g;
    BigInteger p;
    BigInteger x;
    BigInteger y;
    BigInteger c1;
    BigInteger c2;


    private void bob() {
        Module1Fasade module1Fasade = new Module1Fasade();

        int message = 10000;
        BigInteger z = module1Fasade.rand(10);

        c1 = module1Fasade.bit_pow(g, z, p);
        BigInteger temp = module1Fasade.bit_pow(y, z, p);
        c2 = BigInteger.valueOf(message).multiply(temp);
    }

    private void alice(){
        Module1Fasade module1Fasade = new Module1Fasade();
        BigInteger a = module1Fasade.reverse(c1, p);
        BigInteger b = module1Fasade.bit_pow(a, x, p);
        BigInteger message = c2.multiply(b).remainder(p);

        System.out.println("WYNIK");
        System.out.println(message);
    }

    void algOne(){
        int k = 2500;
        Module1Fasade module1Fasade = new Module1Fasade();

        do{
            g = module1Fasade.rand(k);
        }
        while (module1Fasade.isPrimary(g));

        do{
            p = g.multiply(BigInteger.TWO).add(BigInteger.ONE);
        }
        while (module1Fasade.isPrimary(p));

        x = module1Fasade.rand(10);

        y = module1Fasade.bit_pow(g, x, p);
        //System.out.println(p + "\n" + g + "\n" + x+ "\n" + y);

    }

    ArrayList publicKey(){
        ArrayList key = new ArrayList();
        key.add(p);
        key.add(g);
        key.add(y);

        return key;
    }

    ArrayList privateKey(){
        ArrayList key = new ArrayList();
        key.add(p);
        key.add(x);

        return key;
    }

}
