package com.zky;

/**
 * @author: yuan
 * @date: 2023/2/20
 * @Description: 在数组中找出现奇数次的数
 * （1）已知一个整型数组中只有一个数出现了奇数次，其余数都出现了偶数次，找出出现了奇数次的数。
 * （2）已知一个整型数组中只有两个数出现了奇数次，其余数都出现了偶数次，找出出现了奇数次的数。
 */
public class FindNum {
    public static void main(String[] args) {
        System.out.println("在数组中找出现奇数次的数");
        /**
         *
         * @author: yuan
         * @date: 2023/2/20
         * @Description: 注意如果数组参数不符合要求会则不能得到预期结果（如数组中有三个出现奇数次的数）
         *               这里我们默认参数正确，判断较为复杂
         */
        int[] arr = {1, 1, 2, 2, 3, 3, 4};
        int[] arr2 = {1, 1, 2, 2, 3, 3, 4, 5};
        findOne(arr);
        findTwo(arr2);
    }

    /**
     * （1）已知一个整型数组中只有一个数出现了奇数次，其余数都出现了偶数次，找出出现了奇数次的数。
     *
     * @param arr
     */
    public static void findOne(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println("出现奇数次的数为：" + eor);
    }

    /**
     * （2）已知一个整型数组中只有两个数出现了奇数次，其余数都出现了偶数次，找出出现了奇数次的数。
     *
     * @param arr
     */
    public static void findTwo(int[] arr) {
        int eor1 = 0, eor2 = 0;
        for (int cur : arr) {
            eor1 ^= cur;
        }
        int rightOne = eor1 & (~eor1 + 1);
        for (int cur : arr) {
            if (rightOne == (rightOne & cur)) {
                eor2 ^= cur;
            }
        }
        eor1 = eor1 ^ eor2;
        System.out.println("出现奇数次的数分别为：" + eor1 + "，" + eor2);
    }
}
