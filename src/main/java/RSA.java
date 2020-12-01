import modul1.Module1Fasade;

import java.math.BigInteger;
import java.util.ArrayList;

public class RSA {
    int k;
    Module1Fasade module1Fasade = new Module1Fasade();

    BigInteger p;
    BigInteger q;
    private BigInteger Fin;

    BigInteger p_1;
    BigInteger q_1;

    BigInteger e;
    BigInteger d;

    BigInteger n;

    public RSA(int k) {
        this.k = k;
        createNewRSA(0);
    }

    public void  createNewRSA(int mode){
        if (mode == 0){
            randP_Q();
        } else {
            fastRandP_Q();
        }

        //fakeP_Q();
        calculateR_Fin();
        findE();
        findD();
    }

    private void fakeP_Q() {
    p = new BigInteger("9450316326517672104876399626861209414918183399547816736226545455440994266683061472770831447361780823519982890201039437936260458672398454347308602020965377814012639807852796213495412142802415691072372553591399171496098486218004141514954369055665326854197248686176138726835240563557453173551179265701953");
    q = new BigInteger("10557809073871725262994115332595079780764262108053391815839120309241089406429801729067142680301609025981206159678151519277380075218579294180100921356260728651250710818662840110792279849514978774989988745298568690063858335577798889331896451088892646868063771654751977068352852173095893449903880877512937");

    }

    public BigInteger encrypt(BigInteger M){
        return module1Fasade.bit_pow(M,e,n);
    }

    public BigInteger decrypt(BigInteger C){
        return module1Fasade.bit_pow(C,d,n);
    }

    private void  randP_Q(){

        p = module1Fasade.randPrime(k);
        System.out.println(p);

        q = module1Fasade.randPrime(k);
        System.out.println(q);
    }

    private void fastRandP_Q(){
        p = module1Fasade.fastRandPrime(k);
        System.out.println(p);

        q = module1Fasade.fastRandPrime(k);
        System.out.println(q);
    }

    private void calculateR_Fin(){
        n = p.multiply(q);
        p_1 = p.subtract(BigInteger.ONE);
        q_1 = q.subtract(BigInteger.ONE);

        Fin = p_1.multiply(q_1);

//        System.out.println(n);
//        System.out.println(Fin);

    }

    private void findE(){
        BigInteger l = p_1.max(q_1);

        e = l.nextProbablePrime();

//        System.out.println(e);
    }

    private void findD(){
        d = module1Fasade.reverse(e, Fin);

//        System.out.println(d);
    }

    ArrayList publicKey(){
        ArrayList key = new ArrayList();
        key.add(n);
        key.add(e);

        return key;
    }

    ArrayList privateKey(){
        ArrayList key = new ArrayList();
        key.add(n);
        key.add(d);

        return key;
    }
}
