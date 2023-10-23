package com.gyf.test;

import com.gyf.niuke.*;
import com.gyf.offer.util.ListNode;
import com.gyf.offer.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class NiukeTest {

    @Test
    public void testBM1() {
        ListNode list = Util.getListByLength(7);
        BM1 bm1 = new BM1();
        ListNode listNode = bm1.ReverseList(list);
        Util.logList(listNode);
    }

    @Test
    public void testBM2() {
        ListNode list = Util.getListByLength(5);
        BM2 bm2 = new BM2();
        ListNode listNode = bm2.reverseBetween(list, 2, 5);
        Util.logList(listNode);
    }

    @Test
    public void testBM3() {
        ListNode list = Util.getListByLength(7);
        BM3 bm3 = new BM3();
        ListNode listNode = bm3.reverseKGroup(list, 7);
        Util.logList(listNode);
    }

    @Test
    public void testBM17() {
        int[] nums = {-1,0,3,4,6,10,13,14};
        BM17 bm17 = new BM17();
        log.info("result={}",bm17.search(nums, 10));
    }

    @Test
    public void testBM18() {
        BM18 bm18 = new BM18();
        int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        log.info("result={}", bm18.Find(15, nums));
    }

    @Test
    public void testBM19() {
        BM19 bm19 = new BM19();
        int[] nums = {2,2,1,2,7,8,4};
        log.info("result={}", bm19.findPeakElement(nums));
    }


}
