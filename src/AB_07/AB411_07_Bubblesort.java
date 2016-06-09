//  @author:       Ralph.Maurer@iet-gibb.ch  
//  Compilation:   javac AB411_07_Bubblesort.java
//  Execution:     java -jar AB411_07_Bubblesort.jar
package AB_07;

    public class AB411_07_Bubblesort {

        public static void bubblesort(int[] x) {
            boolean unsortiert=true;
            int temp; 
            while (unsortiert){
                unsortiert = false;
                for (int i=0; i<x.length-1; i++)
                    if (x[i] > x[i+1]) { 
                        temp = x[i];
                        x[i] = x[i+1]; 
                        x[i+1] = temp; 
                        unsortiert = true;
                    }
            }
       }

        public static void main(String[] args) {
           int[] liste = {0,9,4,6,2,8,5,1,7,3};
           bubblesort(liste);
           for (int i=0; i<liste.length; i++)
                System.out.print(liste[i]+" ");
        }
}
