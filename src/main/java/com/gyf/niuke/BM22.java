package com.gyf.niuke;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BM22 比较版本号
 */
public class BM22 {

    public int compare1 (String version1, String version2) {
        // write code here
        if (version1 == null || version2 == null) {
            return 0;
        }
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        int len1 = versions1.length;
        int len2 = versions2.length;
        int maxLen = Math.max(len1, len2);
        int k = 0;
        if (len2 < maxLen) {
            // version2长度不够
            List<String> versions2List = Arrays.stream(versions2).collect(Collectors.toList());
            while (k < maxLen - len2) {
                versions2List.add("0");
                k++;
            }
            versions2 = versions2List.toArray(new String[maxLen]);
        } else if (len1 < maxLen){
            // version1长度不够
            List<String> versions1List = Arrays.stream(versions1).collect(Collectors.toList());
            while (k < maxLen - len1) {
                versions1List.add("0");
                k++;
            }
        }
        int i=0;
        while (i < maxLen) {
            int v1 = Integer.parseInt(versions1[i]);
            int v2 = Integer.parseInt(versions2[i]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            } else {
                i++;
            }
        }
        return 0;
    }

    // 试试递归，本就是一个一个比较的子任务，互不想干，用递归分开解决
    public int compare2 (String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        return recursionCompare(versions1, versions2, 0);
    }

    // 递归子方法
    private int recursionCompare(String[] versions1, String[] versions2, int i) {
        int max = Math.max(versions1.length, versions2.length);
        if (i > max) {
            return 0;
        }
        int x = 0,y = 0;
        if (i < versions1.length) {
            x = Integer.parseInt(versions1[i]);
        }
        if (i < versions2.length) {
            y = Integer.parseInt(versions2[i]);
        }
        if (x > y) {
            return 1;
        }
        if (x < y) {
            return -1;
        }
        return recursionCompare(versions1, versions2, ++i);
    }

    // 双指针法
    public int compare (String version1, String version2) {
        int i = 0, j = 0;
        int l1 = version1.length();
        int l2 = version2.length();
        while (i < l1 || j < l2) {
            // 给个初始值
            int num1 = 0;
            while (i < l1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + version1.charAt(i) - '0';
                i++;
            }
            // 跳过 .
            i++;
            int num2 = 0;
            while (j < l2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + version2.charAt(j) - '0';
                j++;
            }
            j++;
            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
        }
        // 没分出大小，说明一样大
        return 0;
    }

}
