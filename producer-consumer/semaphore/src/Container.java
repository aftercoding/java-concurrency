import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @description: some desc
 * @author: congjun
 * @email: 66@7788.com
 * @date: 2022-09-14 14:51
 */
public class Container {
    Semaphore fullCount = new Semaphore(0);
    Semaphore emptyCount = new Semaphore(10);
    Semaphore inUse = new Semaphore(1);

    List list = new LinkedList<>();

    public void put(Integer val){
        try {
            emptyCount.acquire();
            inUse.acquire();
            list.add(val);
            System.out.println("producer-- " + Thread.currentThread().getName()
                    + " put: " + val + "=====size: " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            inUse.release();
            fullCount.release();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer get(){
        Integer val = 0;
        try {
            fullCount.acquire();
            inUse.acquire();
            val = (Integer) list.remove(0);
            System.out.println("consumer--" + Thread.currentThread().getName() + "  take :" +
                    val + " === size: " + list.size());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            inUse.release();
            emptyCount.release();
        }
        return val;
    }
}
