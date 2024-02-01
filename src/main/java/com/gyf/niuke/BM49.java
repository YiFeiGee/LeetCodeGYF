package com.gyf.niuke;

import cn.hutool.Hutool;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BM49 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 返回表达式的值
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve (String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        char[] charArray = s.toCharArray();
        List<Integer> result = tryCalculate(charArray, 0);
        return result.get(0);
    }

    public List<Integer> tryCalculate(char[] charArray, int index) {
        if (index >= charArray.length) {
            return null;
        }
        // 不要符号栈，除了乘法会立即计算，加减都看成是加法
        Deque<Integer> stack = new LinkedList<>();
        // 初始化为加号是为了后面代码逻辑里第一个数字直接入栈，op是存储最新的运算符
        char op = '+';
        // 记录最新的num值，可能是表达式里截取的，也可能是括号内计算出的
        int num = 0;
        int i = 0;
        for (i = index; i < charArray.length; i++) {
            // 先取数
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                num = num * 10 + charArray[i] - '0';
                if (i != charArray.length-1) {
                    // 继续运算
                    // 这个判断其实是有两层意义
                    // 1.当i < length时，取数过程中不应该执行后面的代码，直接continue
                    // 2.当i == length-1时，需要执行后续的代码，因为需要把最后一个取到的数送入栈中，需要利用switch里的逻辑
                    continue;
                }
            }
            // 再执行递归求子表达式值,这其实也是变相的取数
            if (charArray[i] == '(') {
                // 递归
                List<Integer> list = tryCalculate(charArray, i + 1);
                // 取数，这是表达式值
                num = list.get(0);
                // 更新当前遍历下标
                i = list.get(1);
                if (i != charArray.length-1) {
                    // 继续运算
                    // 这个判断也很重要
                    // 1.当i == length-1时，不需要执行后续的代码，因为当前仍然还是右括号，不跳过去循环就直接结束了
                    continue;
                }
            }
            // 依据运算符计算局部表达式
            switch (op){
                case '+' :
                    stack.offerFirst(num);
                    break;
                case'-':
                    stack.offerFirst(-num);
                    break;
                case '*':
                    int temp = stack.pollFirst();
                    stack.offerFirst(num * temp);
                    break;
            }
            // 不要忘记初始化num，因为当前num已经被用过了，再用就要重新取数
            num = 0;
            if (charArray[i] == ')') {
                // 这是递归完成，子表达式结束
                break;
            }
            // 运算符
            if (charArray[i] == '+' || charArray[i] == '-' || charArray[i] == '*'){
                op = charArray[i];
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pollFirst();
        }
        List<Integer> res = new ArrayList<>();
        res.add(sum);
        // i不一定就是s.length，因为for循环有提前结束的可能
        res.add(i);
        return res;
    }
}
