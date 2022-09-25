package com.LiuBoTing.data_structure.linkedlist;

/**
 * @author liuboting
 * @date 2022/2/21 20:45
 * 找到链表中点（快慢指针）
 */

public class LinkedListMid {
    public static class Node{
        public int value;
        public Node next;
        public Node(int v){
            value = v;
        }
    }

    //链表节点个数奇数则返回中点，偶数则返回前中点
    public static Node midOrUpMidNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //链表节点个数奇数则返回中点，偶数则返回下中点
    public static Node midOrDownMidNode(Node head){
        if(head == null || head.next == null) return head;
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //链表节点个数奇数则返回中点前一个，偶数则返回上中点前一个
    public static Node midUpOrUpMidUpNode(Node head){
        if(head == null || head.next == null || head.next.next == null) return head;
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //链表节点个数奇数则返回中点前一个，偶数则返回下中点前一个
    public static Node midUpOrDownMidUpNode(Node head){
        if(head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
