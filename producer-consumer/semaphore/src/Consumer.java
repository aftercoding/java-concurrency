/**
 * @description: some desc
 * @author: congjun
 * @email: 66@7788.com
 * @date: 2022-09-14 15:32
 */
public class Consumer implements Runnable{
    private Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        while (true){
            Integer val = container.get();
        }
    }
}
