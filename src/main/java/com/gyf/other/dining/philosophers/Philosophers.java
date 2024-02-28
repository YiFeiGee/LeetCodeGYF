package com.gyf.other.dining.philosophers;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Philosophers implements Runnable{

    private Chopsticks left;
    private Chopsticks right;
    private String name;
    private Integer index;


    public Philosophers(Chopsticks left, Chopsticks right, String name, Integer index) {
        this.left = left;
        this.right = right;
        this.name = name;
        this.index = index;
    }


    @Override
    public void run() {
        if (this.index %2 == 0) {
            synchronized (this.left) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (this.right) {
                    System.out.println("哲学家"+this.name+"拿了两只筷子，开始吃饭了");
                }
            }
        } else {
            synchronized (this.right) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (this.left) {
                    System.out.println("哲学家"+this.name+"拿了两只筷子，开始吃饭了");
                }
            }
        }
    }
}
