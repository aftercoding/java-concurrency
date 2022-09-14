import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description: some desc
 * @author: congjun
 * @email: 66@7788.com
 * @date: 2022-09-14 19:54
 */
public class Producer implements Runnable{
    private ArrayBlockingQueue<Integer> queue;

    public Producer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();
        while(true){
            try {
                Thread.sleep(100);
                if(queue.size() == 10) System.out.println("========== The queue is full, Producer: " +
                        Thread.currentThread().getName() + " is waiting");
                int item = random.nextInt(100);
                queue.put(item);
                System.out.println("Producer: " + Thread.currentThread().getName() +
                        "produce: " + item + "; the size of the queue: " + queue.size());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
