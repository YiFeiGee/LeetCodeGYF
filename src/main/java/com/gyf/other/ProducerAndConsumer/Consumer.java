package com.gyf.other.ProducerAndConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer extends Thread{

    private Lock lock;

    private Condition consumerCondition;

    private Condition produceCondition;

    public Consumer(Lock lock, Condition consumerCondition, Condition produceCondition) {
        this.lock = lock;
        this.consumerCondition = consumerCondition;
        this.produceCondition = produceCondition;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            lock.lock();
            while (ProducerAndConsumerTest.count <= 0) {
                System.out.println("商品已消费完，停止消费");
                try {
                    consumerCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            ProducerAndConsumerTest.count--;
            System.out.println("消费线程" + Thread.currentThread().getName() + "消费成功，count=" + ProducerAndConsumerTest.count);
            // 唤醒生产者线程，必须先signal，再去unlock，因为unlock是释放锁
            // signal 方法要求执行此操作时，当前线程必须拥有与此condition有关的锁，否则抛异常
            produceCondition.signalAll();
            lock.unlock();
        }
    }
}
