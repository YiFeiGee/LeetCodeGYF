package com.gyf.other.alternate.output;

public class WaitNotifyWay {

    static Object obj = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i < 26; i++) {
                    System.out.println(i);
                    try {
                        obj.notify();// 从当前锁的等待队列中唤醒一个线程
                        System.out.println("thread1 after notify");
                        obj.wait();// 让当前线程让出锁，并进入等待队列；wait之后的代码不会执行
                        System.out.println("thread1 after wait");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                obj.notify();
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i < 26; i++) {
                    System.out.println((char)('a'+i));
                    try {
                        obj.notify();
                        System.out.println("thread 2 after notify");
                        obj.wait();// 线程2一进入就应该让出锁等待，让线程1先执行
                        System.out.println("thread 2 after wait");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                obj.notify();
            }
        }, "t2").start();
    }

}
