import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: some desc
 * @author: congjun
 * @email: 66@7788.com
 * @date: 2022-09-13 21:07
 */
public class ReentrantLokDemo {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private boolean state;

    public void lockMyhearth(){
        reentrantLock.lock();
        try {
            System.out.println("changing stated in a serialized way: " +  Thread.currentThread().getName());
            state = !state;
            System.out.println("Changed: " + state + "  name: "  + Thread.currentThread().getName());
        } finally {
            reentrantLock.unlock();
        }
    }
    public void lockMyHearthWithTiming() throws InterruptedException {
        if(!reentrantLock.tryLock(1l, TimeUnit.SECONDS)){
            System.out.println("Failed to accquire the lock - it's already held.: " +  Thread.currentThread().getName());
        }else{
            try{
                System.out.println("Simulatiing a blocking compution - forcing trylock() to fail: " + Thread.currentThread().getName() );
                Thread.sleep(3000);
            }finally {
                reentrantLock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        var executor = Executors.newCachedThreadPool();
        var self = new ReentrantLokDemo();
        for(int i = 0; i < 10; i++){
            executor.execute(() ->self.lockMyhearth());
        }
        for (int i = 0; i < 40; i++) {
            executor.execute(()->{
                try{
                    self.lockMyHearthWithTiming();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            });
        }
        executor.shutdown();
    }
}
