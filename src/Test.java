import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by fdh on 2017/9/11.
 */
public class Test {
    public static void main(String[] args) {
        BlockingQueue<Integer> q = new LinkedBlockingQueue<>();
        Thread t1 = new Thread(()-> {
            try {
                q.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()-> {
            try {
                int i = q.take();
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        System.out.println("a");
    }
}
