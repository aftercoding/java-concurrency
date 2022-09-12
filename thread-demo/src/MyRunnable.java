public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable runnable on thread " + Thread.currentThread().getName());
    }
}