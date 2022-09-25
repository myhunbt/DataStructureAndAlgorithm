package com.LiuBoTing.data_structure.linkedlist;

/**
 * @author liuboting
 * @date 2022/2/22 21:04
 */

public class DutchFlagLinkedList {
    public static class Node{
        private int value;
        private Node next;

        public Node(int v){
            value = v;
        }
    }
    public static void main(String[] args) {

    }

    public static Node dutchFlagLinkedList(Node head,int value){
        Node LH = null; //<
        Node LL = null; //<
        Node MH = null; //=
        Node ML = null; //=
        Node RH = null; //>
        Node RL = null; //>
        Node cur = head;
        while (cur != null){
            if(cur.value > value){
                if(LH == null){
                    LH = cur;
                }else {
                    LL.next = cur;
                }
                LL = cur;
            }
            if(cur.value == value){
                if(MH == null){
                    MH = cur;
                }else {
                    ML.next = cur;
                }
                ML = cur;
            }
            if(cur.value < value){
                if(RH == null){
                    RH = cur;
                }else {
                    RL.next = cur;
                }
                RL = cur;
            }
            cur = cur.next;
        }

        if(LH != null) LL.next = MH;
        if(MH != null) ML.next = RH;
        return LH != null ? LH : (MH != null? MH : RH);
    }

}
