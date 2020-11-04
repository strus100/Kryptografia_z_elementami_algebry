import modul1.Arithmetic;
import modul1.EuclideanAlgoritm;
import modul1.EucliideanAlgoritmSource;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
 //       Arithmetic arithmetic = new Arithmetic();
  //      System.out.println(arithmetic.randZn(2));
        EuclideanAlgoritm eucliideanAlgoritm = new EuclideanAlgoritm();
        eucliideanAlgoritm.euklideanAlgoritm(BigInteger.valueOf(5),BigInteger.valueOf(13));
        System.out.println("Source");
        EucliideanAlgoritmSource algoritmSource = new EucliideanAlgoritmSource();
        algoritmSource.euklideanAlgoritm(5,13);
    }
}
