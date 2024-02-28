package com.gyf.other.dining.philosophers.coarsening;

import com.gyf.other.dining.philosophers.Chopsticks;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class PhilosophersForCoarsening implements Runnable{

    private Chopsticks coarseningChopsticks;
    private String name;
    private Integer index;


    public PhilosophersForCoarsening(Chopsticks coarseningChopsticks, String name, Integer index) {
        this.coarseningChopsticks = coarseningChopsticks;
        this.name = name;
        this.index = index;
    }


    @Override
    public void run() {
            synchronized (this.coarseningChopsticks) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("哲学家"+this.name+"拿了两只筷子，开始吃饭了");
            }
    }
}
