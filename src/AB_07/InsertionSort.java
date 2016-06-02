package AB_07;

/**
 * Created by jonas on 26.05.16.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] liste = GenerateSortList.makeSortArray();
        for (int i : insertionsort(liste)) {
            System.out.println(i);
        }
    }

    public static int[] insertionsort(int[] liste) {
        int tempList;
        for (int i = 1; i < liste.length; i++) {
            tempList = liste[i];
            int x = i;
            while (x > 0 && liste[x - 1] > tempList) {
                liste[x] = liste[x - 1];
                x--;
            }
            liste[x] = tempList;
        }
        return liste;
    }
}