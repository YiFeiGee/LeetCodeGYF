package com.gyf.offer;

import java.util.Objects;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
public class Q04_Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (Objects.isNull(matrix) || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int x = matrix.length; // 行数
        int y = matrix[0].length; // 每行个数
        int i = 0; // 从第0行开始
        int j = y - 1; // 从每行最后一个元素开始比较，比此元素大则可直接移动到下一行
        while (i < x && j >= 0) {
            if (matrix[i][j] > target) {
                while (j >= 0) {
                    if (matrix[i][j] == target) {
                        return true;
                    } else if (matrix[i][j] > target) {
                        j--;
                    } else {
                        // 不在这一行
                        break;
                    }
                }
            } else if (matrix[i][j] < target) {
                j = y-1;
                i++;
            } else {
                return true;
            }

        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (Objects.isNull(matrix) || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length; // 行数
        int columns = matrix[0].length; // 每行个数
        int i = 0; // 从第0行开始
        int j = columns - 1; // 从每行最后一个元素开始比较，比此元素大则可直接移动到下一行
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

}
