import modul1.*;

import java.math.BigInteger;
import java.security.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList K_A = null;
    static BigInteger g;
    static BigInteger p;
    static BigInteger x;
    static BigInteger y;
    static BigInteger c1;
    static BigInteger c2;

    static Main m = new Main();

    public static void main(String[] args) throws NoSuchAlgorithmException {
        algOne();
        m.bob();
        m.alice();
    }

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

    static void algOne(){
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
