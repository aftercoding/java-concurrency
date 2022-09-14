import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description: some desc
 * @author: congjun
 * @email: 66@7788.com
 * @date: 2022-09-14 20:09
 */
public class Consumer implements Runnable{
    private ArrayBlockingQueue<Integer> queue;

    public Consumer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
                System.out.println("consumer: " + Thread.currentThread().getName() + " is tacking data");
                if(queue.isEmpty()) {
                    System.out.println("===== The queue is empty, thread: " +
                            Thread.currentThread().getName() + " is waiting");
                }
                Integer item = queue.take();
                System.out.println("consumer: " + Thread.currentThread().getName() +
                            " consumed: " + item + "; the size of queue is: " + queue.size());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }finally {
                System.out.println("Consumer: " + Thread.currentThread().getName() + " exit");
            }
        }
    }
}
