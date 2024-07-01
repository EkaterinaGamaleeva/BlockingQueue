import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class BlockingQueue {

    private volatile int value=0;
    private int[] ints =new int[10];
    public synchronized int dequeue() {
        while (value==0) {
            try {
                System.out.println("Я в режиме ожидания"+"---"+"в очереди 0 потоков");
                wait();
            }
            catch (InterruptedException e) {
            }
        }

        System.out.println("Возвращаем поток"+"-"+ints[value]);
        value--;
        notify();
return ints[value];
    }
    public synchronized void enqueue(int value){
//Фиксированный размер 9
        while (value>=9) {
            try {
                System.out.println("Я жду своей очереди "+"---"+"я 10 поток");
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        value++;
        ints[value]=value;
        System.out.println("Новый поток"+"---"+"номер в очереди"+" "+ints[value]);
        notify();
    }
}
