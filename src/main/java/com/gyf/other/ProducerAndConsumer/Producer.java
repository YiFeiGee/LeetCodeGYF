package com.gyf.other.ProducerAndConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer extends Thread{


    private Lock lock;

    private Condition producerCondition;

    private Condition consumerCondition;

    public Producer(Lock lock, Condition producerCondition, Condition consumerCondition) {
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.consumerCondition = consumerCondition;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            // 立马尝试获取锁，没有锁不允许生产，后面如果被唤醒也需要去重新获取锁
            lock.lock();
            // 这里需要用while，因为线程被唤醒之后是从await这里继续执行，这时候可能别的生产者线程又生产了
            while (ProducerAndConsumerTest.count >= ProducerAndConsumerTest.MAX_COUNT) {
                System.out.println("商品已到达最大数量，暂停生产");
                try {
                    producerCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            // 生产商品
            ProducerAndConsumerTest.count++;
            System.out.println("生产线程" + Thread.currentThread().getName() + "生产成功,count=" + ProducerAndConsumerTest.count);
            // 唤醒所有消费者-->唤醒不一定有用，唤醒了之后还得拿到锁才行
            consumerCondition.signalAll();
            lock.unlock();
        }
    }
}
