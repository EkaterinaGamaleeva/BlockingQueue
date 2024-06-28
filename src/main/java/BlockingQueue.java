import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class BlockingQueue {
    private volatile int size=0;
    public synchronized void dequeue() {
        while (size==0) {
            try {
                System.out.println("Я в режиме ожидания");
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        size--;
        System.out.println("Вышел с режима ожидания");
        System.out.println(size);
        notify();
    }
    public synchronized void enqueue(){
//Фиксированный размер 3
        while (size>=4) {
            try {
                System.out.println("Я жду своей очереди");
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        size++;
        System.out.println("Новый поток");
        System.out.println(size);
        notify();
    }
}
