package com.LiuBoTing.data_structure.stack;

/**
 * @author liuboting
 * @date 2020/9/15 20:30
 */

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
//        list.show(list.head);
        LinkedListStack stack = new LinkedListStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
//        stack.push(5);
        System.out.println(stack.pop());
        stack.show();

    }
}

class LinkedListStack{
    private int top = -1;
    private int maxSize;
    private LinkList stack;

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new LinkList();
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("满了");
            return;
        }
        top++;
        stack.add(new Node(value));
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }

        Node node = stack.delLastNode();
        top--;
        return node.val;
    }

    public void show(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        stack.show(stack.head);
    }
}

class LinkList{
    Node head = null;

    public LinkList() {

    }

    public boolean isEmpty(){
        return head == null;
    }

    public void add(Node node){
        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public Node delLastNode(){
        if(head == null){
            System.out.println("栈空，删啥子");
            return null;
        }
        if(head.next == null){
            Node n = head;
            head = null;
            return n;
        }
        Node temp = head;
        while (true){
            if(temp.next.next == null){
                break;
            }
            temp = temp.next;
        }
        Node n = temp.next;
        temp.next = null;
        return n;
    }

    public void show(Node head){
        if(head.next == null){
            System.out.println(head);
            return;
        }

        show(head.next);
        System.out.println(head);

    }
}

class Node{
     Node next;
     int val;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                " val=" + val +
                '}';
    }
}