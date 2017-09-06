package exercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fdh on 2017/9/6.
 */

interface BlockingQueue<E> {
    public void put(E e) throws InterruptedException;
    public E take() throws InterruptedException;
}
public class BlockingQueueImpl<E> implements BlockingQueue<E> {

    private int capacity = 32;

    public BlockingQueueImpl(int capacity) {
        this.capacity = capacity;
    }

    private Queue<E> queue = new LinkedList<>();

    private Lock lock = new ReentrantLock();

    private Condition fullCondition = lock.newCondition();

    private Condition emptyCondition = lock.newCondition();
    @Override
    public void put(E e) throws InterruptedException {
        try {
            lock.lockInterruptibly();
            if (queue.size() == capacity) {
                fullCondition.await();
            }
            this.queue.add(e);
            emptyCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E take() throws InterruptedException {
        try {
            lock.lockInterruptibly();
            if (queue.size() == 0) {
                emptyCondition.await();
            }

            E result = this.queue.poll();
            fullCondition.signalAll();
            return result;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new BlockingQueueImpl<>(1);
        Thread t = new Thread(()->{
            try {
                Thread.sleep(1000);
                blockingQueue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        try {
            Integer integer = blockingQueue.take();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
