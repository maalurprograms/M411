package AB_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**22
 * Created by jonas on 11.05.16.
 */
public class Collatz {
    public static void main(String[] args){
        int eingabe;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Eingabe:");
        try {
            eingabe = Integer.valueOf(input.readLine());
            collatz_funktion(eingabe);
            do{
                if ( (eingabe & 1) == 0 ) {
                    eingabe /= 2;
                } else {
                    eingabe = 3 * eingabe + 1;
                }
                System.out.println(eingabe);
            }while (eingabe != 1);
            System.out.println("Fertig");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nur Zahlen");
        }
    }

    private static void collatz_funktion(int eingabe){
        if ((eingabe & 1) == 0) {
            eingabe /= 2;
        } else {
            eingabe = 3 * eingabe + 1;
        }
        System.out.println(eingabe);
        if (eingabe != 1) {
            collatz_funktion(eingabe);
        } else {
            System.out.println("Fertig");
        }
    }
}
