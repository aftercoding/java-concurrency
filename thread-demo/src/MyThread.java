public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("My thread on " + Thread.currentThread().getName());
    }
}