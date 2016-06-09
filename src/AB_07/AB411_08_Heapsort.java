//  @author:       Ralph.Maurer@iet-gibb.ch  
//  Compilation:   javac AB411_08_Heapsort.java
//  Execution:     java -jar AB411_08_Heapsort.jar
package AB_07;

public class AB411_08_Heapsort {
    private static int heap_size;
    
    public static int parent(int i){
        return i/2;    
    }
    
    public static int left(int i){
        return 2*i;    
    }
    
    public static int right(int i){
        return 2*i+1;    
    }
    
    public static void max_heapify(int[] A, int i){
        int l = left(i);
        int r = right(i);
        int largest;
        if ((l <= heap_size) && (A[l] > A[i])){
            largest = l;
        } else {
            largest = i;
        }
        if ((r <= heap_size) && (A[r] > A[largest])) {
            largest = r;
        }   
        if (largest != i){
            int tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;
            max_heapify(A, largest);
        }
      }
            
    public static void build_max_heap(int[] A){
        heap_size = A.length-1;
        for (int i = (A.length-1)/2; i >= 1; i-- ){
            max_heapify(A, i);
        }
    }        
     
    public static void heapsort(int[] A) {
        build_max_heap(A);
        for (int i = A.length-1; i >= 2; i-- ){
            int tmp = A[1];
            A[1] = A[i];
            A[i] = tmp;
            heap_size--;
            max_heapify(A, 1);
        }
    }
           
    public static void main(String[] args) {
        int[] A = new int[args.length+1];
        for (int i=0; i<args.length;i++)
            A[i+1]=Integer.parseInt(args[i]);
        heapsort(A);
        for (int i=1; i<A.length; i++)
                System.out.print(A[i]+" ");
    }
}

                

	
