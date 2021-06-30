public class tutu {
    public class Main {

        public static void main(String[] args) {

            int[] tab = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

            ForkJoinPool forkJoin = null;

            try {

                forkJoin = new ForkJoinPool();

                int wynik = forkJoin.invoke(new Obliczenia(tab));

                System.out.println(wynik);

            } finally {...}

        }

    }



    class Obliczenia extends RecursiveTask<Integer> {

        int[] tab;

        public Obliczenia(int[] tab) {...}

        @Override

        protected Integer compute() {

            int polowa = tab.length / 2;

            Oblicz task1 = new Oblicz(tab, 0, polowa);

            Oblicz task2 = new Oblicz(tab, polowa, tab.length);

            task1.fork();

            task2.fork();

            int res2 = task2.join();

            int res1 = task1.join();

            return res1 + res2;

        }

    }



    class Oblicz extends RecursiveTask<Integer> {

        int[] tab;

        int start;

        int stop;

        public Oblicz(int[] tab, int start, int stop) {...}

        @Override

        protected Integer compute() {

            int sum = 0;

            for(int i=start; i<stop; i++){

                sum += tab[i]>7 ? 1 : 0;

            }

            return sum;

        }

    }
}
