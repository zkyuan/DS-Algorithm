package com.tool;

public class ListNode {
    /**
     *
     * @author: yuan
     * @date: 2022/12/29
     * Description: 链表
     */

    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
