package com.gyf.offer.util;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  LIST和array相互转换
 */
public class ListArrayTransformUtil {

    public static List<Object> arrayToList(Object[] array) {
        List<Object> list = new ArrayList<>(Arrays.asList(array));
        return list;
    }

    public static List<Object> arrayToList2(Object[] array) {
        List<Object> list = new ArrayList<>(array.length);
        Collections.addAll(list, array);
        return list;
    }

    /**
     * Arrays.asList，要求里面是对象，如果是String[]，String就是对象，但如果是int[]
     * 则int[]才是对象
     * @param array
     * @return
     */
    public static List<String> arrayToStrList(String[] array) {
        List<String> list = new ArrayList<String>(Arrays.asList(array));
        return list;
    }

    public static List<Integer> arrayToIntList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    /**
     * list.toArray如果内部未传参，返回的数组就是OBject类型的
     * @param list
     * @return
     */
    public static Object[] listBasicToArray(List<Object> list) {
        return list.toArray();
    }

    public static String[] listStrToArray(List<String> list) {
        return list.toArray(new String[0]);
    }
}
