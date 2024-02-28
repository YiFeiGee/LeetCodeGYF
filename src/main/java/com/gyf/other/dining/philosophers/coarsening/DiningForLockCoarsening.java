package com.gyf.other.dining.philosophers.coarsening;


import com.gyf.other.dining.philosophers.Chopsticks;
import com.gyf.other.dining.philosophers.Philosophers;

/**
 * 模拟哲学家就餐，五个哲学家，五根筷子；两种解决方案
 *      1. 五根筷子一个锁，即锁粗化，串行化执行
 *      2. 并行化执行，带争抢的那种，但要避免死锁,--->错开争抢
 */
public class DiningForLockCoarsening {

    public static void main(String[] args) {
        // 五根筷子合成一个，只准备一份筷子
        Chopsticks chopsticks = new Chopsticks("chopstick", 1);

        // 五个哲学家,每人都用这一份筷子
        PhilosophersForCoarsening philosopher1 = new PhilosophersForCoarsening(chopsticks, "philosopher1", 1);
        PhilosophersForCoarsening philosopher2 = new PhilosophersForCoarsening(chopsticks, "philosopher2", 2);
        PhilosophersForCoarsening philosopher3 = new PhilosophersForCoarsening(chopsticks, "philosopher3", 3);
        PhilosophersForCoarsening philosopher4 = new PhilosophersForCoarsening(chopsticks, "philosopher4", 4);
        PhilosophersForCoarsening philosopher5 = new PhilosophersForCoarsening(chopsticks, "philosopher5", 5);

        philosopher1.run();
        philosopher2.run();
        philosopher3.run();
        philosopher4.run();
        philosopher5.run();
    }

}
