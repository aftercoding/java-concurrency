import java.util.concurrent.Executors;

/**
 * @description: some desc
 * @author: congjun
 * @email: 66@7788.com
 * @date: 2022-09-14 15:43
 */
public class Demo {
    public static void main(String[] args) {
        Container container = new Container();
        var executor = Executors.newCachedThreadPool();

        for(int i = 0; i < 3; i++){
            executor.execute(new Producer(container));
        }

        for(int i = 0; i < 10; i++){
            executor.execute(new Consumer(container));
        }
        executor.shutdown();
//        Thread p1 = new Thread(new Producer(container));
//        Thread p2 = new Thread(new Producer(container));
//        Thread p3 = new Thread(new Producer(container));
//
//        Thread c1 = new Thread(new Consumer(container));
//        Thread c2 = new Thread(new Consumer(container));
//        Thread c3 = new Thread(new Consumer(container));
//
//        p1.start();
//        p2.start();
//        p3.start();
//
//        c1.start();
//        c2.start();
//        c3.start();
    }
}
