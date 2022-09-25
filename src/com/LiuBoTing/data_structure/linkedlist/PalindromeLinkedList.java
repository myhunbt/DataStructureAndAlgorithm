package com.LiuBoTing.data_structure.linkedlist;

import java.util.Stack;

/**
 * @author liuboting
 * @date 2022/2/22 19:52
 * 判断链表是否是回文链表
 */

public class PalindromeLinkedList {

    public static class Node{
        private int value;
        private Node next;

        public Node(int v){
            value = v;
        }
    }

    public static void main(String[] args) {

    }
    //借助容器
    public static boolean palindromeLinkedList1(Node head){
        if(head == null || head.next == null) return true;
        Stack<Node> stack = new Stack<>();
        Node cur = head;

        //入栈(先进后出)
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        System.out.println(stack);
        cur = head;

        while (cur != null){
            if(cur != stack.pop()) return false;
            cur = cur.next;
        }
        return true;
    }

    //不借助容器
    public static boolean palindromeLinkedList2(Node head){
        if(head == null || head.next == null) return true;
        Node mid = midOrUpMidNode(head);
        Node prev = mid;
        Node cur = prev.next;
        prev.next = null;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        next = prev;
        cur = head;
        boolean res = true;
        while (cur != null && prev != null){
            if(cur.value != prev.value){
                res = false;
                break;
            }
            cur = cur.next;
            prev = prev.next;
        }
        cur = next.next;
        next.next = null;
        while (cur != null){
            prev = cur.next;
            cur.next = next;
            next = cur;
            cur = prev;
        }
        return res;
    }

    public static Node midOrUpMidNode(Node head){
        if(head == null || head.next == null || head.next.next == null) return head;
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null || fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
