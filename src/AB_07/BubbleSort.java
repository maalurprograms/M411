package AB_07;

/**
 * Created by jonas on 19.05.16.
 */
public class BubbleSort {
    public static void main(String[] arg){
        int[] sort_array = GenerateSortList.makeSortArray();
        boolean[] finished_state = new boolean[sort_array.length];
        for (int i = 0; i<finished_state.length;i++){
            finished_state[i] = false;
        }
        boolean finished = false;
        while (!finished){
            for (int i = 0;i<sort_array.length;i++){
                try {
                    if (!finished_state[i+1]) {
                        if (sort_array[i] > sort_array[i + 1]) {
                            int temp = sort_array[i];
                            sort_array[i] = sort_array[i + 1];
                            sort_array[i + 1] = temp;
                        }
                    } else {
                        finished_state[i] = true;
                    }
                } catch (Exception e){
                    finished_state[i] = true;
                }
            }
            for (boolean state:finished_state) {
                if (!state){
                    break;
                }
                finished = true;
            }
        }
        for (int zahl:sort_array) {
            System.out.print(zahl);
        }

    }

}
