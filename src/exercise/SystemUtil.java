package exercise;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fdh on 2017/9/6.
 */

public class SystemUtil {
    private Lock lock = new ReentrantLock();
    public static boolean isAdmin(String userId) {
        return userId.toLowerCase() == "admin";
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
        Thread t1 = new Thread(()->{
            try {
                queue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                int i = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {
                lock.lock();
                System.out.println("cc");
                lock.unlock();
            }
        });
        t1.start();
        t2.start();
//        t3.start();

        System.out.println("ddd");
    }
}
