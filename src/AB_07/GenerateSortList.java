package AB_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by jonas on 26.05.16.
 */
public class GenerateSortList {
    public static int[] makeSortArray(){
        List<Integer> list_origin = new ArrayList<>();
        list_origin.addAll(Arrays.asList(new Integer[] {0,1,2,3,4,5,6,7,8,9}));
        int[] sort_array = new int[10];

        for (int i = 0; i<sort_array.length;i++) {
            int rand_numb = new Random().nextInt(list_origin.size());
            sort_array[i] = list_origin.get(rand_numb);
            list_origin.remove(rand_numb);
            System.out.print(rand_numb);
        }
        System.out.print("\n");
        return sort_array;
    }
}
