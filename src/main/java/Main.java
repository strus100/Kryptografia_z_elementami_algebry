import modul1.*;

import java.math.BigInteger;
import java.security.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        long startTime = System.nanoTime();
        RSA rsa = new RSA(2000);
        BigInteger c = rsa.encrypt(BigInteger.valueOf(54321));
        System.out.println( rsa.decrypt(c) );

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) /1000000000;
        System.out.println("Time of execution: " + duration + " seconds.");

    }


}
