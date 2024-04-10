package com.zky;

import com.tool.ListNode;

public class AddTwoNumbers {
    /**
     *
     * @author: yuan
     * @date: 2022/12/29
     * Description:  两数相加
     *      给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *      请你将两个数相加，并以相同形式返回一个表示和的链表。
     *      你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *      例如；2->4->3   +    5->6->4     结果：7->0->8    342=465=807
     */

    //分析：第一个元素是个位，数字尾对齐，依次相加向后进位，指针后移。可采用带头结点的单链表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);   // 头指针，带头结点的单链表
        ListNode cur = pre;                 //cur指向链表首元素
        int carry = 0;           //记录数值相加的进位
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val; //从第一个元素依次取出相加，
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;   //两个数字的相同位相加，并且加上进位

            carry = sum / 10;   //进位，参与下一轮相加
            sum = sum % 10;  //剩余位
            cur.next = new ListNode(sum);//剩余位存入链表

            cur = cur.next;   //指针后移一位，指向链表尾元素
            if (l1 != null)
                l1 = l1.next;  //原链表后移
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);  //最后一次相加有进位，则补在最后
        }
        return pre.next;  //返回链表
    }
}


