//  @author:       Ralph.Maurer@iet-gibb.ch  
//  Compilation:   javac AB411_07_Quicksort.java
//  Execution:     java -jar AB411_07_Quicksort.jar
package AB_07;

import java.util.Random;

public class AB411_07_Quicksort {

    public static void quicksort(int x[]) {
        qSort(x, 0, x.length-1);
    }

    public static void qSort(int x[], int links, int rechts) { 
        if (links < rechts) {
            int i = partition(x,links,rechts);
            qSort(x,links,i-1);
            qSort(x,i+1,rechts);
        }
    }

    public static int partition(int x[], int links, int rechts) {
        int pivot, i, j, help;
        pivot = x[rechts];
        i = links;
        j = rechts-1;
        while(i<=j) {
            if (x[i] > pivot) {
                // tausche x[i] und x[j] 
                help = x[i];
                x[i] = x[j];
                x[j] = help;
                j--;
            } 
            else {
                i++; 
            }
        }    
        // tausche x[i] und x[rechts]
        help = x[i];
        x[i] = x[rechts];
        x[rechts] = help;
        return i; 
    }

    public static void main(String[] args) {
        int[] liste = {0,9,4,6,2,8,5,1,7,3};
        quicksort(liste);
        for (int i=0; i<liste.length; i++)
            System.out.print(liste[i]+" ");
    }
}