package com.LiuBoTing.data_structure.linkedlist;

/**
 * @author liuboting
 * @date 2020/9/17 14:00
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。

 * 示例：
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 *
 * 示例：
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        System.out.println(addTwoNumbers(node1, node4));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode rs = result;
        int carry = 0;
        while (true){
            if(l1 == null && l2 == null){
                if(carry == 0){
                    break;
                }else {
                    l1 = new ListNode(0);
                    l2 = new ListNode(0);
                }
            }else if(l1 == null){
                l1 = new ListNode(0);
            }else if(l2 == null){
                l2  = new ListNode(0);
            }
            result.next = new ListNode(0);
            result = result.next;
            int sum = l1.val + l2.val + carry;
            if(sum >= 10){
                carry = 1;
                sum-=10;
            }else {
                carry = 0;
            }
            result.val = sum;
            l1 = l1.next;
            l2 = l2.next;
        }

        return rs.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}