package com.gyf.other.ProducerAndConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 其实通过BlockQueue可以更简单实现
 */
public class ProducerAndConsumerTest {

    // 常量--最大的商品数
    public static final int MAX_COUNT = 3;

    // 生产者消费者共用的计数
    public static int count = 0;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        // 一把锁，创建两个condition，相当于两个队列的线程都要竞争这把锁
        Condition producerCondition = reentrantLock.newCondition();
        Condition consumerCondition = reentrantLock.newCondition();
        Producer p1 = new Producer(reentrantLock, producerCondition, consumerCondition);
        Producer p2 = new Producer(reentrantLock, producerCondition, consumerCondition);
        Consumer c1 = new Consumer(reentrantLock, consumerCondition, producerCondition);
        Consumer c2 = new Consumer(reentrantLock, consumerCondition, producerCondition);
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }

}
