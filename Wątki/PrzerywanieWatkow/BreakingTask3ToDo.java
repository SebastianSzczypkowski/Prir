package Wątki.PrzerywanieWatkow;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Thread.sleep;

public class BreakingTask3ToDo implements Runnable {
    int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new BreakingTask3ToDo());
        t.start();
        sleep(100);
        System.out.println("Wywołuję przerwanie wątku");
        t.interrupt();
        t.join();
        System.out.println("koniec programu");
    }


    /** Metoda wątku -  w nieskończonej pętli generowana jest nowa mapa częstości, a następnie porównywane są różnice częstości
     * Tutaj również znależy umieścić procedurę zakończenia wątku.
     *
     */
    @Override
    public void run() {

        Thread th = Thread.currentThread();
        while (true) {
            System.out.println("run: " + counter);
            Map<String, Integer> map = new HashMap<>();
            if(th.isInterrupted())return;
            generatemMap(map);
            if(th.isInterrupted())return;
            maxRoznica(map);
            counter++;


        }

    }

    /** Metoda generuje mapę, w której kluczem jest string reprezentujący liczbę z przedziału 0-9, a wartością jest licznik
     * wskazujący ile razy dana wartość wystąpiła.
     * Aby jak najszybciej zakończyć wątek należy przerwać wykonywanie pętli
     * @param map
     */
    public void generatemMap(Map<String, Integer> map) {
        Random r = new Random();
        System.out.println("generateMap: "+counter);
        Thread th = Thread.currentThread();
        for (int i = 0; i < 1000; i++) {
            String key = "" + r.nextInt(10);
            Integer val = map.get(key);
            val = val == null ? 1 : val + 1;
            if(th.isInterrupted())return;
            map.put(key, val);

            if(th.isInterrupted())return;
        }
    }

    /**
     * Metoda zwraca największą różnicę pomiędzy elementami mapy. W tym celu dla każdej możliwej wartości sprawdzana
     * jest różnica między ilością wystąpień jednego elementu względem innego. W ten soposób możemy próbować oszacować
     * na ile nasz generator liczb losowych jest uczciwy. W przypadku idealnym różnica pomiędzy wartościami powinna
     * być 0, co zonacza że wszystkie wartości wystąpiły taką samą liczbę razy.
     * Przerwanie wątku powinno nastąpić najszybciej jak to tylko możliwe
     * @param map
     */
    public void maxRoznica(Map<String, Integer> map) {
        int maxDX = 0;
        System.out.println("maxRoznica: " + counter);
        Thread th = Thread.currentThread();
        for (Map.Entry<String, Integer> e1 : map.entrySet()) {
            for (Map.Entry<String, Integer> e2 : map.entrySet()) {
                int dx = Math.abs(e1.getValue() - e2.getValue());
                if (dx > maxDX) {
                    maxDX = dx;
                }
                if(th.isInterrupted())return;
            }

            if(th.isInterrupted())return;
        }
        System.out.println("Maksymalna różnica to: " + maxDX);
    }
}