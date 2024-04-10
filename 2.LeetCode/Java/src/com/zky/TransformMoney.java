package com.zky;

import java.util.Scanner;

/**
 * @author: yuan
 * @date: 2022/12/28
 * Description: 金额转换：输入一个数，转换成零亿零仟零佰零拾零万叁仟贰佰肆拾陆元的形式
 */

public class TransformMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money, i, j = 0;
        String result = "";  //初始化
        while (true) {
            System.out.println("请输入金额：");
            money = sc.nextInt();  //输入一个数
            if (money >= 0 && money <= 999999999) {
                break;
            } else {
                System.out.println("输入错误，请重新输入！");
            }
        }
        while (money > 0) {
            i = money % 10;  //取走低位
            money = money / 10; //修改原数，右移一位
            String s = transform(i); //阿拉伯数字转大写
            s = s + units(j++);  // 拼接单位
            result = s + result; // 拼接结果
        }
        while (j < 9) {
            result = "零" + units(j++) + result;  //高位补零
        }
        System.out.println("金额为：" + result);  //打印结果
    }

    public static String transform(int num) {  //阿拉伯数字转大写
        String[] mo = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        return mo[num];
    }

    public static String units(int num) {  //单位
        String[] units = {"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿"};
        return units[num];
    }
}
