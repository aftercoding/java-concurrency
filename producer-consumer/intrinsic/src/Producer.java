import java.util.Random;

/**
 * @description: some desc
 * @author: congjun
 * @email: 66@7788.com
 * @date: 2022-09-13 23:40
 */
public class Producer implements Runnable{
    private Container container;
    public Producer(Container container){
        this.container = container;
    }
    @Override
    public void run() {
        container.put(new Random().nextInt(100));
    }
}
