/**
 * @description: some desc
 * @author: congjun
 * @email: 66@7788.com
 * @date: 2022-09-13 23:41
 */
public class Consumer implements Runnable{
    private Container container;
    public Consumer(Container container){
        this.container = container;
    }
    @Override
    public void run() {
        Integer val = container.take();
    }
}
