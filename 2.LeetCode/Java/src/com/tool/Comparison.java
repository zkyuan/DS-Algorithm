package com.tool;

import com.zky.Order;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: yuan
 * @date: 2023/2/28
 * @Description: 用java写一个对数器：
 * 自动生成一个100以内的随机长度的整型数组，数组元素值为100以内的随机数，拷贝一份数据给另一个数组；
 * 用两个排序算法分别给这两个数组进行排序，并且比对排序结果是否一致，如果一致则重复操作10万次，如果有一次不一致则返回false。
 */
public class Comparison {
    /**
     * @author: yuan
     * @date: 2023/2/28 17:20
     * @param: []
     * @return: int[]
     * @descipton: 生成一个随机长度的整型数组，数组元素值为100以内的随机数
     */
    public static int[] generateRandomArray() {
        Random random = new Random();
        // 长度为2到100之间的随机数,数组长度小于2拒绝排序
        int length = random.nextInt(99) + 2;
        int[] array = new int[length];
        // 元素值为0到99之间的随机数
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    /**
     * @author: yuan
     * @date: 2023/2/28 17:20
     * @param: [array]
     * @return: int[]
     * @descipton: 拷贝一份数据给另一个数组，开辟的是另一块内存空间
     */
    public static int[] copyArray(int[] array) {
        if (array == null) {
            return null;
        }
        //长度相同
        int[] copy = new int[array.length];
        //依次赋值
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    /**
     * @author: yuan
     * @date: 2023/2/28 17:21
     * @param: [array1, array2]
     * @return: boolean
     * @descipton: 数据比对操作：
     * 用待测算法1和比对算法2分别给两个数组排序，然后比对两个数组在其对应位置的值是否完全一致，
     * 如果一致则返回true，如果不一致返回false
     */
    public static boolean compare(int[] array1, int[] array2) {
        //非法数据
        if ((array1 == null && array2 != null) || (array1 != null && array2 == null)) {
            return false;
        }
        //两个空数组，返回true
        if (array1 == null && array2 == null) {
            return true;
        }
        //先判断长度是否一致
        if (array1.length != array2.length) {
            return false;
        }
        //调用待测算法1和比对算法2，分别给两个数组排序
        //待测排序算法
        Order.radixSort(array1);
        //比对排序算法
        Order.insertOrder(array2);
        //比较每个数据元素是否相等
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                // 如果有任何一个元素不相等，就返回false
                return false;
            }
        }
        return true; // 否则返回true
    }

    /**
     * @author: yuan
     * @date: 2023/2/28 17:44
     * @param: []
     * @return: java.lang.Boolean
     * @descipton: 数组比对器，若一致则返回true，若不一致则返回false
     */
    public static Boolean comparison() {
        //重复排序比对操作100万次
        int testTime = 1000000;
        //循环比对
        for (int time = 0; time < testTime; time++) {
            //生成原始数组
            int[] originArray = generateRandomArray();
            //拷贝原始数组
            int[] copyArray = copyArray(originArray);
            //比较两个数组是否相等
            boolean result = compare(originArray, copyArray);
            //如果不相等，则打印出错误信息，并结束程序
            if (!result) {
                System.out.println("排序算法出错!");
                System.out.println("数组1：" + Arrays.toString(originArray));
                System.out.println("数组2：" + Arrays.toString(copyArray));
                //返回false
                return false;
            }
        }
        //比对完成都没有出错，返回true
        System.out.println("排序算法正确!");
        return true;
    }
}