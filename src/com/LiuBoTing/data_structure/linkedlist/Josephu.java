package com.LiuBoTing.data_structure.linkedlist;

import java.util.ArrayList;

/**
 * @author liuboting
 * @date 2020/9/15 11:31
 * Josephu 问题为：设编号为 1，2，… n 的 n 个人围坐一圈，约定编号为 k（1<=k<=n）的人从 1 开始报数，
 * 数到 m 的那个人出列，它的下一位又从 1 开始报数，数到 m 的那个人又出列，依次类推，直到所有人出列为止，
 * 由此 产生一个出队编号的序列
 */

public class Josephu {

    public static void main(String[] args) {
        SingleAnnularLinkedList list = new SingleAnnularLinkedList();
        Node node1 = new Node(1, "张三", "老大");
        Node node2 = new Node(2, "李四", "老二");
        Node node3 = new Node(3, "王五", "老三");
        Node node4 = new Node(4, "赵六", "老四");
        Node node5 = new Node(5, "吴七", "老五");
        list.addNode(node1);
        list.addNode(node2);
        list.addNode(node3);
        list.addNode(node4);
        list.addNode(node5);
//        list.showLinkedList();
        System.out.println(list.josephu(node1, 2));
    }
}

class SingleAnnularLinkedList{
    public Node head = new Node(0,"","");

    public ArrayList<Integer> josephu(Node head, int m){
        ArrayList<Integer> list = new ArrayList<>();
        if(head.next == head){
            list.add(head.no);
            return list;
        }

        for (int i = 1; i < m-1; i++) {
            head = head.next;
        }
        list.add(head.next.no);
        head.next = head.next.next;
        list.addAll(josephu(head.next,m));
        return list;
    }

    public void showLinkedList(){
        if(head.no == 0){
            System.out.println("链表为空");
            return;
        }
        Node temp = head;
        while (true){
            System.out.println(temp);
            if(temp.next == head){
                break;
            }
            temp = temp.next;
        }

    }


    public void addNode(Node node){
        if(head.no == 0){
            head = node;
            head.next = head;
        }else {
            Node temp = head;
            while (true){
                if(temp.next == head){
                    break;
                }
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }

}

class Node{
    public int no;
    public String name;
    public String nickname;
    public Node next;

    public Node(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
