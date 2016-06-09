/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AB_07;

/**
 *
 * @author vmadmin
 */
public class AB411_07_Insertionsort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] liste = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
        int [] sortlist = new int[(liste.length)+1];
        sortlist = insertionsort (liste);
        for (int i = 0; i < sortlist.length; i++)
        {
            System.out.println(sortlist [i]);
        }
    }
    
    public static int[] insertionsort(int[] liste)
    {
        int[] sortlist = null;
        boolean sort = true;
        int xy = 0;
        for (int i = 0; i < liste.length; i++)
        {
            sort = true;
            if (sortlist != null)
            {
                for (int x = 0; x < sortlist.length; x++)
                {
                    if (sortlist[x] > liste [i])
                    {
                        int z = sortlist.length;
//                        while (z != x)
//                        {
//                            sortlist[z+1] = sortlist [z];
//                            z--;
//                        }
                        sortlist[x] = liste [i];
                        sort = false;
                        xy = z;
                    }
                }
                if (sort)
                {
                    sortlist[xy] = liste [i];
                }
            }
            else
            {
                sortlist = new int [liste.length];
                sortlist[0] = liste [i];
            }
        }
        return sortlist;
    }
}
