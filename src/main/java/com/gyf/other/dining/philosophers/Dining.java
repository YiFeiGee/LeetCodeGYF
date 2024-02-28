package com.gyf.other.dining.philosophers;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟哲学家就餐，五个哲学家，五根筷子；两种解决方案
 *      1. 五根筷子一个锁，即锁粗化，串行化执行
 *      2. 并行化执行，带争抢的那种，但要避免死锁
 */
public class Dining {

    public static void main(String[] args) {
        // 五根筷子
        Chopsticks chopsticks1 = new Chopsticks("chopstick1", 1);
        Chopsticks chopsticks2 = new Chopsticks("chopstick2", 2);
        Chopsticks chopsticks3 = new Chopsticks("chopstick3", 3);
        Chopsticks chopsticks4 = new Chopsticks("chopstick4", 4);
        Chopsticks chopsticks5 = new Chopsticks("chopstick5", 5);

        // 五个哲学家
        Philosophers philosopher1 = new Philosophers(chopsticks1, chopsticks2, "philosopher1", 1);
        Philosophers philosopher2 = new Philosophers(chopsticks2, chopsticks3, "philosopher2", 2);
        Philosophers philosopher3 = new Philosophers(chopsticks3, chopsticks4, "philosopher3", 3);
        Philosophers philosopher4 = new Philosophers(chopsticks4, chopsticks5, "philosopher4", 4);
        Philosophers philosopher5 = new Philosophers(chopsticks5, chopsticks1, "philosopher5", 5);

        philosopher1.run();
        philosopher2.run();
        philosopher3.run();
        philosopher4.run();
        philosopher5.run();
    }

}
