package AB_04;

/**
 * Created by jonas on 10.03.16.
 */
public class CloneExperiment {
    public static void main(String[] args){

        int[] liste = new int[1000000];
        for (int i=0; i<liste.length;i++){
            liste[i] = (int)(100*Math.random());
        }

        //-----------------------------------------------

        long startZeit = System.currentTimeMillis();

//        int[] liste2 = liste.clone();

        int[] liste2 = new int[1000000];
        for (int i=0; i<liste.length;i++){
            liste2[i] = liste[i];
        }

        long endZeit = System.currentTimeMillis();
        System.out.println(endZeit-startZeit);
    }
}
