package com.gyf.other.alternate.output;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程交替输出，使用reentrantLock
 */
public class ReentrantLockWay {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();// 类似于拿到了一个队列
        new Thread(() -> {
            reentrantLock.lock();
            for (int i = 0; i < 26; i++) {
                System.out.println(i);
                condition.signal();// notify
                try {
                    condition.await();// wait，进入队列等待唤醒拿锁
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            reentrantLock.unlock();// 让当前线程让出锁，并进入等待队列；wait之后的代码不会执行
        }, "t1").start();

        new Thread(() -> {
            reentrantLock.lock();
            for (int i = 0; i < 26; i++) {
                System.out.println((char)('a'+i));
                condition.signal();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            reentrantLock.unlock();
        }, "t2").start();
    }

}
