import java.util.LinkedList;

/**
 * @description: some desc
 * @author: congjun
 * @email: 66@7788.com
 * @date: 2022-09-13 22:52
 */
public class Container {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 10;
    public void put(int value){
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (this){
                System.out.println("producer: " + Thread.currentThread().getName() + " obtain lock");
//                try {
//                    Thread.sleep(1000);
//
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                while (list.size() == capacity){
                    System.out.println("container is full, waiting .......");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("produce--" + Thread.currentThread().getName() + "--put:" + value);
                list.add(value++);
                notifyAll();
            }
            System.out.println("producer: " + Thread.currentThread().getName() + " out of synchronized");
        }
    }

    public Integer take(){
        Integer val = 0;
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (this){
                System.out.println("consumer: " + Thread.currentThread().getName() + " obtain lock");
                while (list.isEmpty()){
                    System.out.println("container is empty, waiting.... :" + Thread.currentThread().getName());
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                val = list.removeFirst();
                System.out.println("consumer--" + Thread.currentThread().getName() + "-- take: " + val);
                notifyAll();
            }
            System.out.println("consumer: " + Thread.currentThread().getName() + " out of synchronized");
        }
    }
}
