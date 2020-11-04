package modul1;

public class EucliideanAlgoritmSource {
    int r, a, q, b;
    int x, x1, x2;
    int y, y1, y2;
    int nwd;
   public void euklideanAlgoritm(int nwd_a,int nwd_b){
        initializeA_B(nwd_a,nwd_b);
        initializeR_NWD();
        initializeX_Y();

        while (r != 0)
        {
            System.out.println("a:" + a+", b:" + b+", q:" + q+", r:" + r+", x:"+  x+", x1:"+ x1+", x2:"+ x2+", y:"+ y+", y1:"+ y1+", y2:"+ y2+", nwd:"+ nwd+", " + "");

            a = b;
            b = r;

            x = x2 - q*x1;
            x2 = x1;
            x1 = x;

            y = y2 - q*y1;
            y2 = y1;
            y1 = y;

            nwd = r;
            q = a/b;
            r = a - q*b;
        }
        presentResults(nwd_a,nwd_b);
    }

    void initializeA_B(int nwd_a, int nwd_b){
        if (nwd_b > nwd_a) {
            b = nwd_a;
            a = nwd_b;
        } else {
            a = nwd_a;
            b = nwd_b;
        }
    }

    void initializeR_NWD(){
        q = a/b;
        r = a - q*b;
        nwd = b;
    }

    void initializeX_Y(){
        x2 = 1;
        x1 = 0;
        y2 = 0;
        y1 = 1;
        x = 1;
        y = y2 - (q-1)*y1;
    }

    void presentResults(int nwd_a,int nwd_b){
        System.out.println("NWD("+nwd_a+", "+nwd_b+") = "+nwd+" = "+x+" * "+nwd_a+" + "+y+" * "+nwd_b);

        if (nwd == 1)
            System.out.println(nwd_b+" * "+y+" mod "+nwd_a+" = 1");
    }
}
