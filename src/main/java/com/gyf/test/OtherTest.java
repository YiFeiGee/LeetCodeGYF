package com.gyf.test;

import com.gyf.other.DCL;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class OtherTest {

    @Test
    public void testDCL() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        DCL dcl = new DCL();
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                dcl.getSingleton();
            });
        }
    }

}
