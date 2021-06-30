package forkjoin;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] tab = {5, 7, 3, 2, 8, 0, 1, 6, 10};
        {
            System.out.println("------------------------------------");
            int[] tmpTab = Arrays.copyOf(tab, tab.length);
            System.out.println(Arrays.toString(tmpTab));
            Sort sort = new QuickSort();
            sort.sort(tmpTab);
            System.out.println(Arrays.toString(tmpTab));
        }
        {
            System.out.println("------------------------------------");
            int[] tmpTab = Arrays.copyOf(tab, tab.length);
            System.out.println(Arrays.toString(tmpTab));
            Sort sort = new PQuickSort();
            sort.sort(tmpTab);
            System.out.println(Arrays.toString(tmpTab));
        }

    }
}

