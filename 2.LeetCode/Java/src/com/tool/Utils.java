package com.tool;


/**
 * @author: yuan
 * @date: 2023/2/23
 * @Description: 工具类
 */
public class Utils {
    /**
     * @author: zkyuan
     * @date: 2023/2/22 22:19
     * @param: [arr, i, j]
     * @return: int[]
     * @descipton: 数组交换两数。将数组arr的i下标和j下标的数互换，用异或运算
     */
    public static int[] swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/27 15:10
     * @param: [arr, i, j]
     * @return: int[]
     * @descipton: 交换两数常规方法，将数组arr的i下标和j下标的数互换
     */
    public static int[] exchange(int[] arr, int i, int j) {
        //临时中间变量
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/27 15:07
     * @param: [arr, i]
     * @return: int[]
     * @descipton: 在数组arr的i下标位置插入一个数n
     */
    public static int[] insert(int[] arr, int i, int n) {
        //数组后移
        for (int j = arr.length - 1; j > i; j--) {
            arr[j + 1] = arr[j];
        }
        //插入数据
        arr[i] = n;
        return arr;
    }
}
