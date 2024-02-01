package com.gyf.niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BM47 {

    public int result = -1;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *  topK问题，优先就应该想到堆，即优先队列
     *  此外，快排也可以处理，因为快排每次是确定一个元素位置，然后再分左右，换言之，在这个元素前面都比他小，后面都比他大，也正符合topK问题的精髓
     *
     * @param input int整型一维数组
     * @param k int整型
     * @return int整型ArrayList
     */
    public int findKth1 (int[] a, int n, int K) {
        if (a == null || K > n) {
            return -1;
        }
        quickSearch(a, 0, a.length-1, n-K);
        return result;
    }

    public void quickSearch(int[] input, int low, int high,  int k) {
        if (low > high) {
            return;
        }
        int start = low;
        int last = high;
        // 一直循环，直到前面都比num[start]小，后面都比num[start]大
        while (low < high) {
            // 从后往前找个比num[start]小的，这个必须放前面，先找小的，比如3，2，7，8，你模拟一遍就知道了
            while (low < high && input[high] >= input[start]) {
                high--;
            }
            // 从前往后找个比num[start]大的
            while (low < high && input[low] <= input[start]) {
                low++;
            }
            // 两个值交换
            if (low < high) {
                swapArr(input, low, high);
            }
        }
        // 到这里一定是low==high
        swapArr(input, start, high);
        if (k == high) {
            result = input[high];
            return;
        }
        // 这里就是截断，只要最小的前k个数，前面有序无序没关系，是小数就行
        if (k < high) {
            quickSearch(input, start, high-1, k);
        }
        if (k > high) {
            quickSearch(input, high+1, last, k);
        }
    }

    public void swapArr(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }


    public int findKth (int[] a, int n, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            System.out.println("oko");
            return o2-o1;
        });
        for (int i = 0; i < a.length; i++) {
            pq.offer(a[i]);;
        }
        while (K-1 > 0) {
            pq.poll();
            K--;
        }
        return pq.peek();
    }



}
