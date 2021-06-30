package forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class PQuickSort implements Sort {


    @Override
    public void sort(int[] tab) {
        ForkJoinPool forkJoin = new ForkJoinPool();
        try {
            MyParallelTask task = new MyParallelTask(tab, 0, tab.length - 1);
            forkJoin.invoke(task);
        } finally {
            if(forkJoin!=null)
            forkJoin.shutdown();
        }

    }


    }

    class MyParallelTask extends RecursiveAction {

    int [] tab;
    int start;
    int end;


        public MyParallelTask(int[] tab, int i, int i1) {
            this.tab=tab;
           this.start=i;
            this.end=i1;

        }

        @Override
        protected void compute() {
            List<MyParallelTask> tasks= new ArrayList<>();
            int j=split(tab,start,end);
          //  MyParallelTask leftSide =null;
           // MyParallelTask rightSide=null;
          /*  if(j>start)
            {
                leftSide=new MyParallelTask(tab,start,j-1);
                leftSide.fork();
            }
            if (j + 1 < end) {
                rightSide = new MyParallelTask(tab, j + 1, end);
                rightSide.fork();
            }

            if (leftSide != null) {
                leftSide.join();
            }

            if (rightSide != null) {
                rightSide.join();
            }

*/
            if(start<j){
                tasks.add(new MyParallelTask(tab,start,j-1));
            }
            if(j+1<end)
            {
                tasks.add(new MyParallelTask(tab,j+1,end));

            }
        if(tasks!=null)invokeAll(tasks);
        }

        private int split(int[] tab, int start, int koniec) {
            int i = (start + koniec) / 2;
            int pivot = tab[i];
            swap(tab, i, koniec);
            int j = start;
            for (i = start; i < koniec; i++) {
                if (tab[i] < pivot) {
                    swap(tab, i, j);
                    j++;
                }
            }
            tab[koniec] = tab[j];
            tab[j] = pivot;
            return j;
        }

        private void swap(int[] tab, int i, int j) {
            int tmp = tab[i];
            tab[i] = tab[j];
            tab[j] = tmp;
        }
    }
