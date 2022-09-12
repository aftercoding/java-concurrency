public class UsingThreads {
    public static void main(String[] args) throws InterruptedException {
        var created = new Thread();
        created.start();
        var threadWithTask = new Thread(()-> System.out.println("Inside thread" + Thread.currentThread().getName()));
        threadWithTask.start();

        //Interrupting a thread
        Runnable interruptedlyTask = () ->{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("I am not inerrupted " + Thread.currentThread().getName());
            }
        };
        var interruptable = new Thread(interruptedlyTask);
        interruptable.start();
        Thread.sleep(1000);
        interruptable.interrupt();
    }
}