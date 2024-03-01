package com.gyf.niuke.sort;

/**
 * 堆排序：不稳定,因为建堆之后，相同值可能不在一个子树上，o(nlogn)
 * 需要有建堆的过程：用数组模拟完全二叉树建堆，根节点下标为0
 * 普通节点n：左子节点下标为2n+1,右子节点下标为2n+2
 * 建一个大顶堆，每次从堆顶去掉一个元素，然后重建堆
 */
public class HeapSort {

    // 在这里定义是因为构建堆时以这个大小为准，当把最值移动到最后之后，堆就可以排除掉最值，减少长度
    public int heapLen;

    public int[] heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        heapLen = arr.length;
        // 第一次建堆，需要对每个父节点做一次建堆操作
        firstBuildHeap(arr);
        // 循环length-1次，每次把堆顶和堆尾元素互换，然后重建堆
        // 堆顶下标为0，堆尾随着heapLen的变化也随之变化
        for (int i = arr.length-1; i > 0; i--) {
            swap(arr, 0, i);
            heapLen -= 1;
            // 堆顶元素出堆后，0位置元素发生变化，需要对这个位置重建一次
            buildHeap(arr, 0);
        }
        return arr;
    }

    /**
     *
     * @param arr
     * @param i 需要调整的父节点
     */
    public void buildHeap(int[] arr, int i) {
        int left = i*2 + 1;
        int right = i*2 + 2;
        int max = i;
        // 从左右子节点里找个大点作为根节点
        // 这里上限用heapLen,因为随着堆顶出堆，堆的长度在变，后面节点已不需要参与建堆
        if (left < heapLen && arr[left] > arr[max]) {
            max = left;
        }
        if (right < heapLen && arr[right] > arr[max]) {
            max = right;
        }
        if (max != i) {
            swap(arr, i, max);
            // max这个位置需要重新调整，因为max值被拿走了
            buildHeap(arr, max);
        }
    }

    /**
     * 第一次建堆，需要对每个父节点
     * @param arr
     */
    public void firstBuildHeap(int[] arr) {
        // 左节点2n+1,右子节点2n+2,因此最后一个父节点下标是(heapLen-1)/2-1
        // 先处理后面父节点，然后再往前推，所以应该是用--，反着来，可以从二叉树角度理解，先处理子树
        for (int i = heapLen/2-1; i >=0 ; i--) {
            buildHeap(arr, i);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
