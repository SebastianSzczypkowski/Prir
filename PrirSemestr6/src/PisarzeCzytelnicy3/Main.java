package PisarzeCzytelnicy3;

import java.util.*;
import java.util.concurrent.locks.Lock;

import static java.lang.Thread.currentThread;

public class Main {

        public static void main(String[] args) throws InterruptedException {
            String fileName = "src/text.txt";
            ReadWriteLock lock = new ReadWriteLock();

            List<Thread> readers = Arrays.asList(
                    new MyThreadReader(lock, fileName),
                    new MyThreadReader(lock, fileName),
                    new MyThreadReader(lock, fileName),
                    new MyThreadReader(lock, fileName)
            );
            List<Thread> writers = Arrays.asList(
                    new MyThredWriter(lock, fileName),
                    new MyThredWriter(lock, fileName)
            );
            readers.stream().forEach((t)-> lock.registerReader(t));
            writers.stream().forEach((t)->t.start());
            readers.stream().forEach((t)->t.start());
            Thread.sleep(1000);
            writers.stream().forEach(t->t.interrupt());
            readers.stream().forEach(t->t.interrupt());
        }

    }
    class ReadWriteLock  {
        Set<Long> readers= new HashSet<>();
        Set<Long> whoEntered= new HashSet<>();
        Set<Long> whoExited= new HashSet<>();
        boolean writerWait = false;
        boolean writerWritten = false;

        public synchronized void registerReader(Thread thread)
        {
            readers.add(thread.getId());
        }

        public synchronized void lockRead() throws InterruptedException
        {
            long id = currentThread().getId();
            while (whoEntered.contains(id)||writerWait==false)
            {
                wait();
            }
            whoEntered.add(id);
        }

        public synchronized void unlockRead()
        {
            long id = currentThread().getId();
            whoExited.add(id);
            if(whoExited.containsAll(readers)&&whoExited.equals(whoEntered))
            {
                writerWait=false;
                writerWritten=false;
            }
            notifyAll();
        }

        public synchronized void lockWrite() throws InterruptedException
        {
            while(writerWait || writerWritten)
            {
                wait();
            }
            writerWritten=true;
        }

        public synchronized void unlockWrite()
        {
            writerWait=true;
            whoEntered.clear();
            whoExited.clear();
            notifyAll();
        }
    }
