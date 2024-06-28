import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        BlockingQueue blockingQueue = new BlockingQueue();
        BlockingQueue blockingQueue1 = blockingQueue.enqueue();
        blockingQueue.dequeue(blockingQueue1);
        BlockingQueue blockingQueue2 = blockingQueue.enqueue();
        blockingQueue.dequeue(blockingQueue2);
        BlockingQueue blockingQueue3 = blockingQueue.enqueue();
        blockingQueue.dequeue(blockingQueue3);
        System.out.println(blockingQueue.getQueue().size());
        forkJoinPool.invoke(blockingQueue);
    }
}
