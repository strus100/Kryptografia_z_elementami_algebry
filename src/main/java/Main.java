import modul1.*;

import java.math.BigInteger;
import java.security.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        RSA rsa = new RSA();
        BigInteger c = rsa.encrypt(BigInteger.valueOf(54321));
        System.out.println( rsa.decrypt(c) );

    }


}
