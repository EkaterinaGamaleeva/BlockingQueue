import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
public class Program {

    public static void main(String[] args) {

        BlockingQueue blockingQueue=new BlockingQueue();
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        new Thread(consumer).start();
        new Thread(producer).start();

    }
}


class Producer implements Runnable{

    BlockingQueue blockingQueue;
    Producer(BlockingQueue blockingQueue){
        this.blockingQueue=blockingQueue;
    }
    public void run(){
            blockingQueue.enqueue();
    }
}

class Consumer implements Runnable{

    BlockingQueue blockingQueue;
    Consumer(BlockingQueue blockingQueue){
        this.blockingQueue=blockingQueue;
    }
    public void run(){
            blockingQueue.dequeue();
    }
}
