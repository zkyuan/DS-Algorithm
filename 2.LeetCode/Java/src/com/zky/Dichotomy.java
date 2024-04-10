package com.zky;

/**
 * @author: zkyuan
 * @date: 2023/2/21 22:22
 * @description: 二分法
 */
public class Dichotomy {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 9};
        int result = dichotomyOrderly(arr1, 7);
        System.out.println("数组下标为：" + result + "，  值为：" + arr1[result]);

        int[] arr2 = {1, 2, 5, 6, 4, 9, 2, 1, 4, 3, 5, 6, 2};
        int result2 = dichotomyNotOrder(arr2);
        System.out.println("一个局部最小数的数组下标为：" + result2 + "，  值为：" + arr2[result2]);
    }

    /**
     * @author: zkyuan
     * @Description: 有序二分
     * 一个有序的升序数组arr，在给定一个数num的条件下，找出数组中大于等于num的最左侧的位置，并打印该数的值
     * @Param: [arr, num]
     * @Return: int
     * @DateTime: 2023/2/21 22:26
     */
    public static int dichotomyOrderly(int[] arr, int num) {
        int left = 0, right = arr.length - 1;
        while ((right - left) > 1) {
            if (arr[(left + right) / 2] < num) {
                left = (left + right) / 2;
            } else {
                right = (left + right) / 2;
            }
        }
        if (arr[left] >= num) {
            return left;
        } else {
            return right;
        }
    }

    /**
     * @author: zkyuan
     * @date: 2023/2/22 9:22
     * @param: [arr]
     * @return: int
     * @descipton: 一个无序数组arr中，已知相邻的两个数一定不相等，找到一个局部最小数。（局部最大数）
     * 局部最小数：该数比它相邻的左右两个数都要小。（ 即arr[i]<arr[i-1]且arr[i]<arr[i+1] ）
     */
    public static int dichotomyNotOrder(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (arr[left] < arr[left + 1] && right - left > 2) {
            left++;
        }
        while (arr[right] < arr[right - 1] && right - left > 2) {
            right--;
        }
        while (right - left > 2) {
            if (arr[(left + right) / 2] > arr[(left + right) / 2 + 1]) {
                left = (left + right) / 2;
            } else {
                right = (left + right) / 2 + 1;
            }
        }
        return left + 1;
    }

}
