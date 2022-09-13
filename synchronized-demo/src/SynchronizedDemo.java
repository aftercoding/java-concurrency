import java.util.concurrent.Executors;

/**
 * @description: some desc
 * @author: congjun
 * @email: 66@7788.com
 * @date: 2022-09-13 18:20
 */
public class SynchronizedDemo {
    private boolean state;
    /**
     * When used in method signature, synchronized use 'this' as a lock.
     *
     * Instead of 'this', other objects variables can be used
     */
    public synchronized void  mySynchronizedMethod(){
//    public  void  mySynchronizedMethod(){
            state = !state;
            System.out.println("My state is: " + state);
    }
    /**
     * It's possible to lock only a block inside the method
     */
    public void  mySynchronizedBlock(){
        System.out.println("111Who owns my lock after state changes: " + Thread.currentThread().getName());
        synchronized (this){
            state = !state;
            System.out.println("222who owns my lock after state change: " + Thread.currentThread().getName());
            System.out.println("State is: " + state);
            System.out.println("==========================");
        }
    }


    public synchronized void reentrancy(){
        System.out.println("Before acquiring again");
        synchronized (this){
            System.out.println("I'm own it! " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        var executor = Executors.newCachedThreadPool();
        var executor = Executors.newFixedThreadPool(5);
        var self = new SynchronizedDemo();
        for(int i = 0; i < 10; i++) {
            executor.execute(() -> self.mySynchronizedMethod());
        }
        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {
             executor.execute(() ->self.mySynchronizedBlock());
        }
        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {
            executor.execute(()->self.reentrancy());
        }
        executor.shutdown();
    }
}
