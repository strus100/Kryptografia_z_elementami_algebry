package module4;

import java.util.ArrayList;

public class AES {

    public int suma( int first, int second ){
        return first^second;
    }

    public int xtime(int first, int times ){
        return first<<times;
    }

    public int iloczyn(int first, int second ){
        String s = toString( second );

        //Mnożenie
        ArrayList<Integer> temps = new ArrayList();
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if( s.charAt( j ) == '1' ){
               temps.add( xtime( first, i ) );
            }
            j++;
        }

        //Dodawanie pojedyńczych mnożeń "ze słupka"
        int result = temps.get( 0 );
        for (int i = 1; i < temps.size(); i++) {
            result = suma( result, temps.get( i ));
        }

        return modulo( result );
    }

    public int modulo(int result ){
        if( result > 255){
            result = toInt( result );
            int m_x = 27;
            return suma( result, m_x );
        } else {
            return result;
        }
    }
    
    public int odwrotnosc( int first ){
        for (int i = 1; i < 256 ; i++) {
            int temp = iloczyn(first, i);
            if (temp == 1){
                return i;
            }
        }
        return -1;
    }

    public String toString( int i ) {
       String string = Integer.toBinaryString(i);

        if (string.length() > 8)
        {
            return string.substring( string.length() - 8 );
        }
        else
        {
            return string;
        }
    }

    public int toInt( String s ){
        int temp = Integer.parseInt(s, 2);

        return Integer.parseInt( toString( temp), 2);
    }

    public int toInt( int i ){
        return Integer.parseInt( toString( i ), 2);
    }
}
