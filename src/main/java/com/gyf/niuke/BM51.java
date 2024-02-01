package com.gyf.niuke;

public class BM51 {

    /**
     * 数组中出现次数超过一半的数字
     * 最难的在于空间复杂度要求是o(1)，没办法借助集合计数
     * 这题解决方法叫候选人法，即提供一个常量cnt计数，若出现相同数字，cnt++，否则cnt--；若当前cnt==0，则说明需要重新推举候选人
     * 当抵消到最后，若有一个数的出现次数超过一半，一定cnt>0
     * @param numbers
     * @return
     */
    public int MoreThanHalfNum_Solution (int[] numbers) throws IllegalAccessException {
        if (numbers == null) {
            return -1;
        }
        int cnt = 0;
        int num = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (cnt == 0) {
                // 推选新候选人
                num = numbers[i];
                cnt++;
            } else {
                // 不是当前候选人减票----抵消
                if (numbers[i] != num) {
                    cnt--;
                } else {
                    cnt++;
                }
            }
        }
        // 验证是否为最后结果
        cnt = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num) {
                cnt++;
            }
        }
        if (cnt > (numbers.length / 2)) {
            return num;
        }
        throw new IllegalAccessException("参数错误");
    }

}
