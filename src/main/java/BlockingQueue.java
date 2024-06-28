import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class BlockingQueue extends RecursiveAction {
    private List<BlockingQueue> queue = new ArrayList<>();


    public synchronized BlockingQueue enqueue() {
        BlockingQueue task = new BlockingQueue();
        queue.add(task);
        notify();
        return task;
    }

    public synchronized void dequeue(BlockingQueue blockingQueue) throws InterruptedException {
        while (queue.size() == 0) {
            System.out.println("Режим ожидания");
            wait();
        }
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) == blockingQueue) {
                System.out.println("Вот поток я нашел" + queue.get(i));
                queue.get(i).fork();
                queue.get(i).join();
            }
        }
    }


    public List<BlockingQueue> getQueue() {
        return queue;
    }

    @Override
    protected void compute() {
        System.out.println("Поток работает");
    }
}
