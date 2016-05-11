package AB_04;

/**
 * Created by jonas on 10.03.16.
 */
public class CloneExperiment {
    public static void main(String[] args){

        int[] liste = new int[100];
        for (int i=0; i<liste.length;i++){
            liste[i] = (int)(100*Math.random());
        }
        System.out.println("Listen Länge: "+liste.length);

        //-----------------------------------------------

        long startZeit = System.nanoTime();

        int[] listeClone = liste.clone();
        long endZeit = System.nanoTime();
        System.out.println("Clone: "+(endZeit-startZeit));

        startZeit = System.nanoTime();
        int[] listeCopy = new int[liste.length];
        for (int i=0; i<liste.length;i++){
            listeCopy[i] = liste[i];
        }
        endZeit = System.nanoTime();
        System.out.println("Copy: "+(endZeit-startZeit));

    }
}
