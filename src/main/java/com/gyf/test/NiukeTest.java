package com.gyf.test;

import com.gyf.niuke.BM1;
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

}
