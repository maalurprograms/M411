package AB_07;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by jonas on 19.05.16.
 */
public class BubbleSort {
    public static void main(String[] arg){
        List<Integer> list_origin = new ArrayList<>();
        list_origin.addAll(Arrays.asList(new Integer[] {0,1,2,3,4,5,6,7,8,9}));
        int[] sort_array = new int[10];
        for (int i = 0; i<sort_array.length;i++) {
            int rand_numb = new Random().nextInt(list_origin.size());
            sort_array[i] = list_origin.get(rand_numb);
            list_origin.remove(rand_numb);
        }
        boolean finished = false;
        while (!finished){
            for (int i = 0;i<sort_array.length;i++){
                try {
                    if (sort_array[i] > sort_array[i + 1]) {
                        int temp = sort_array[i];
                        sort_array[i] = sort_array[i+1];
                        sort_array[i+1] = temp;
                    }
                } catch (Exception e){

                }
            }
        }
    }

}
