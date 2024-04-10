package com.zky;

import com.tool.ListNode;
import com.tool.Utils;

/**
 * @author: yuan
 * @date: 2023/2/23
 * @Description: 排序算法
 */
public class Order {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 3, 2, 5, 9, 6, 3, 4, 7, 8, 2, 1, 5};
        System.out.print("冒泡排序结果：");
        int[] bubbling = bubblingOrder(arr);
        for (int num : bubbling) {
            System.out.print(num + " ");
        }
        System.out.print("\n直接插入结果：");
        int[] inse = insertOrder(arr);
        for (int num : inse) {
            System.out.print(num + " ");
        }
        System.out.print("\n折半插入结果：");
        int[] in = insertSort(arr);
        for (int num : in) {
            System.out.print(num + " ");
        }
        System.out.print("\n希尔排序结果：");
        int[] shell = insertSort(arr);
        for (int num : shell) {
            System.out.print(num + " ");
        }
        System.out.print("\n快速排序结果：");
        int[] quickSort = quickSort(arr);
        for (int num : quickSort) {
            System.out.print(num + " ");
        }
        System.out.print("\n选择排序结果：");
        int[] choose = chooseSort(arr);
        for (int num : choose) {
            System.out.print(num + " ");
        }
        System.out.print("\n堆排序结果：");
        int[] heap = heapSort(arr);
        for (int num : heap) {
            System.out.print(num + " ");
        }

    }

    /**
     * @author: yuan
     * @date: 2023/2/23 11:37
     * @param: [arr]
     * @return: int[]
     * @descipton: 冒泡排序升序
     */
    public static int[] bubblingOrder(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("数组长度小于2，拒绝排序");
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    Utils.swap(arr, j, j - 1);
                }
            }
        }
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/23 11:48
     * @param: [arr]
     * @return: int[]
     * @descipton: 插入排序
     */
    public static int[] insertOrder(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("数组长度小于2，拒绝排序");
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    Utils.swap(arr, j, j - 1);//交换两数
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/27 10:30
     * @param: [arr]
     * @return: int[]
     * @descipton: 折半插入。在进行每一趟寻找待插入位置的操作时，使用折半查找的方式
     */
    public static int[] insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("数组长度小于2，拒绝排序");
            return arr;
        }
        //外层循环控制循环次数
        for (int i = 1; i < arr.length; i++) {
            //临时变量保存待插入元素
            int temp = arr[i];
            //有序列表的左右指针
            int left = 0, right = i - 1;
            //内层循环寻找插入的位置
            while ((right - left) >= 0) {
                int mid = (left + right) / 2;
                if (arr[mid] < temp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            //在待插入位置，数组整体后移
            for (int j = i; j > left; j--) {
                arr[j] = arr[j - 1];
            }
            //放入元素
            arr[left] = temp;
        }
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/27 14:47
     * @param: [arr]
     * @return: int[]
     * @descipton: 希尔排序，先让元素基本有序，再用直接插入排序
     */
    public static int[] shellSort(int[] arr) {
        //数组长度
        int n = arr.length;
        if (arr == null || n < 2) {
            System.out.println("数组长度小于2，拒绝排序");
            return arr;
        }
        //外层循环按相同增量的距离分组
        for (int d = n / 2; d > 0; d = d / 2) {
            //对分组进行直接插入排序
            for (int i = d; i < n; i++) {
                //i位置为待排序判断的元素，i之前为有序集合，直接插入方式
                if (arr[i] < arr[i - d]) {
                    //临时中间变量temp、排序控制变量j
                    int temp = arr[i], j = i - d;
                    //在要插入的位置后的数组元素后移
                    for (; j >= 0 && temp < arr[j]; j -= d) {
                        arr[j + d] = arr[j];
                    }
                    //插入元素
                    arr[j + d] = temp;
                }
            }
        }

/*        for (int d = n / 2; d > 0; d = d / 2) {
            //对分组进行直接插入排序
            for (int i = d; i < n; i++) {
                //i位置为待排序判断的元素，i之前为有序集合
                while (i - d >= 0) {
                //冒泡方式
                    if (arr[i] < arr[i - d]) {
                        Utils.swap(arr, i, i - d);
                        i -= d;
                    } else {
                        break;
                    }
                }
            }
        }*/
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/27 16:41
     * @param: [arr, low, high]
     * @return: void
     * @descipton: 快速排序的递归函数
     */
    public static void quickSort(int[] arr, int left, int right) {
        //递归返回条件
        if (left > right) {
            return;
        }
        //pivot就是基准位
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            //先看右边，依次往左递减
            while (pivot <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (pivot >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                Utils.swap(arr, i, j);
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = pivot;
        //递归调用左半数组
        quickSort(arr, left, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, right);
    }

    /**
     * @author: yuan
     * @date: 2023/3/1 9:56
     * @param: [arr]
     * @return: int[]
     * @descipton: 快速排序
     */
    public static int[] quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("数组长度小于2，拒绝排序");
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/28 9:45
     * @param: [arr]
     * @return: int[]
     * @descipton: 简单选择排序
     */
    public static int[] chooseSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            //内层循环找最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            //如果min的位置发生了变化，则让min与i下标的元素交换
            //使用异或运算交换两数，不能是同一块内存空间
            if (min != i) {
                Utils.swap(arr, i, min);
            }
        }
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/28 17:37
     * @param: [arr]
     * @return: int[]
     * @descipton: 选择排序, newBing
     */
    public static int[] selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("数组长度小于2，拒绝排序");
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //找到最小值的下标索引赋给minIndex变量。
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            //将最小值与当前位置交换。
            Utils.exchange(arr, i, minIndex);
        }
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/28 11:43
     * @param: [arr]
     * @return: void
     * @descipton: 堆排序
     */
    public static int[] heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("数组长度小于2，拒绝排序");
            return arr;
        }
        //从倒数第一个非叶子节点开始
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一天非叶子节点从下至上，从左至右调整结构
            adjustHeap(arr, i, arr.length);
        }
        //将堆顶元素与末尾元素交换 将最大元素沉到数组末尾 + 重新调整堆结构
        for (int i = arr.length - 1; i > 0; i--) {
            //交换堆顶元素和末尾元素
            Utils.swap(arr, 0, i);
            //交换后的末尾元素忽略(j--) 不再参与堆结构的调整
            //重新调整堆结构
            adjustHeap(arr, 0, i);
        }
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/28 11:42
     * @param: [arr, index, length]
     * @return: void
     * @descipton: 调整为小根堆
     */
    public static void adjustHeap(int[] arr, int index, int length) {
        //取出当前元素
        int temp = arr[index];
        //i节点是index节点的左子节点
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            //表明左子节点小于右子节点
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                //将指针移至较大节点
                i++;
            }
            //如果子节点大于父节点
            if (arr[i] > temp) {
                //将较大值赋给当前节点
                arr[index] = arr[i];
                //指针移向子节点
                index = i;
            } else {
                break;
            }
        }
        //循环结束，已经将最大值放在了堆顶
        //将temp值放到最终的位置
        arr[index] = temp;
    }

    /**
     * @author: yuan
     * @date: 2023/3/1 14:01
     * @param: [arr]
     * @return: int[]
     * @descipton: 二路归并
     */
    public static int[] mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/3/1 13:53
     * @param: [arr, low, high]
     * @return: void
     * @descipton: 切分，递归的切成两块，
     */
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    /**
     * @author: yuan
     * @date: 2023/3/1 14:01
     * @param: [arr, low, mid, high]
     * @return: void
     * @descipton: 合并两个有序子列
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }
    }

    /**
     * @author: yuan
     * @date: 2023/3/1 14:34
     * @param: [arr]
     * @return: void
     * @descipton: 基数排序
     */
    public static void radixSort(int[] arr) {
        //找到数组中最大的数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 计算最大数的位数
        int digitNum = 0;
        while (max != 0) {
            digitNum++;
            max /= 10;
        }
        // 初始化桶
        int[][] bucket = new int[10][arr.length];
        int[] count = new int[10];    // 进行排序
        int mod = 10;
        int div = 1;
        for (int i = 0; i < digitNum; i++, div *= 10, mod *= 10) {
            // 将数据放入桶中
            for (int j = 0; j < arr.length; j++) {
                int num = (arr[j] % mod) / div;
                bucket[num][count[num]++] = arr[j];
            }
            // 将桶中的数据放回原数组中
            int index = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < count[j]; k++) {
                    arr[index++] = bucket[j][k];
                }
                // 计数器清零
                count[j] = 0;
            }
        }
    }
}
