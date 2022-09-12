public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();
        System.out.println("main on " + Thread.currentThread().getName());

        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        Thread t3 = new Thread(() ->{
            System.out.println("lambada on thread " + Thread.currentThread().getName());
        });
        t3.start();
        System.out.println("main finished");

        var t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("------------I'm on thread " + Thread.currentThread().getName());
            }
        });
        t4.start();
    }
}
