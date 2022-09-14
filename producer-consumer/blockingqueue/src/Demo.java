import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: some desc
 * @author: congjun
 * @email: 66@7788.com
 * @date: 2022-09-14 20:17
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        ExecutorService executor = Executors.newCachedThreadPool();
//        Producer p1 = new Producer(queue);
//        Producer p2 = new Producer(queue);
//        Producer p3 = new Producer(queue);
//        Consumer c = new Consumer(queue);
//
//        executor.execute(p1);
//        executor.execute(p2);
//        executor.execute(p3);
//        executor.execute(c);
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);
//        for (int i = 0; i < 3; i++) {
//            executor.execute(p);
//        }
        for (int i = 0; i < 2; i++) {
            executor.execute(c);
        }
        Thread.sleep(10000);
//        p
        Thread.sleep(10000);
        executor.shutdown();
    }
}
