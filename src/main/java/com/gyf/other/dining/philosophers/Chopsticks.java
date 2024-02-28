package com.gyf.other.dining.philosophers;

// 哲学家，需要两根筷子
public class Chopsticks {

    private String name;

    private Integer index;

    public Chopsticks(String name, Integer index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
