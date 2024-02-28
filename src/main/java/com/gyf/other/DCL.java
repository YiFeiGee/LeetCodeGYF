package com.gyf.other;

public class DCL {

    // volatile主要作用是保证可见性，修改后其他线程立即可见
    // 但是在这里，主要是为了预防指令重排序，1-分配空间，2-初始化对象，3-修改指向；就是为了预防第二步和第三步错位
    private static volatile DCL singleton;

    public DCL getSingleton() {
//        if (singleton == null) {
//            synchronized (DCL.class) {
                if (singleton == null) {
                    System.out.println("创建一个新的DCL");
                    singleton = new DCL();
                }
//            }
//        }
        return singleton;
    }

}
