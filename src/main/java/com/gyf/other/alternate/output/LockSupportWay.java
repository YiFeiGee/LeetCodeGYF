package com.gyf.other.alternate.output;

import java.util.concurrent.locks.LockSupport;

/**
 * 线程交替输出，一个输出字母，一个输出数字1A2B3C.....
 * 1.LockSupport
 * 2.wait-notify
 * 3.reentrant Lock
 */
public class LockSupportWay {

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        // 线程t1,输出数字
        t1 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                System.out.println(i);
                LockSupport.unpark(t2);// 叫醒t2
                LockSupport.park();// t1阻塞，当前线程阻塞
            }
        }, "t1");
        // 线程t2,输出字母
        t2 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                LockSupport.park();// t2进来就阻塞，因为要让t1先输出，等待t1唤醒t2
                System.out.println((char)('a' + i));
                LockSupport.unpark(t1);// 唤醒t1
            }
        }, "t2");
        t1.start();
        t2.start();
    }

}
