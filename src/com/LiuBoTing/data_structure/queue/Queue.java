package com.LiuBoTing.data_structure.queue;

import java.util.Scanner;

/**
 * @author liuboting
 * @date 2020/9/12 20:47
 *
 * 1) 队列是一个有序列表，可以用数组或是链表来实现。
 * 2) 遵循先入先出的原则。即：先存入队列的数据，要先取出。后存入的要后取出
 */

public class Queue {
    public static void main(String[] args) {
        ArrayQueue queue = new Queue().new ArrayQueue(3);
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag){
            System.out.println("s(show)显示队列");
            System.out.println("a(add)添加数据到队列");
            System.out.println("g(get)获取队列的数据");
            System.out.println("h(head)获取队列的头数据");
            System.out.println("e(exit)退出程序");
            char c = scanner.next().charAt(0);
            switch (c){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入数据：");
                    int i = scanner.nextInt();
                    queue.addQueue(i);
                    break;
                case 'g':
                    try {
                        int data = queue.getQueue();
                        System.out.println("取出的数据为"+data);
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case 'h':
                    try {
                        int data = queue.headQueue();
                        System.out.println("队列头数据"+data);
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
            }
        }
    }

    class ArrayQueue{
        private int maxSize; // 表示数组最大容量
        private int front; // 队列头
        private int rear; // 队列尾
        private int[] arr; // 存放数据，模拟队列

        // 创建队列构造器

        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            front = -1;
            rear = -1;
            arr = new int[maxSize];
        }

        public boolean isFull(){

            return rear == maxSize-1;
        }

        public boolean isEmpty(){

            return front == rear;
        }

        public int getQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }else {
                front++;
                return arr[front];
            }
        }

        public int headQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }else {
                return arr[front+1];
            }
        }

        public void addQueue(int n){
            if(isFull()){
                System.out.println("队列满了");
                return;
            }else {
                rear++;
                arr[rear] = n;
            }
        }

        public void showQueue(){
            if(isEmpty()){
                System.out.println("队列为空");
                return;
            }else {
                for (int i = 0; i < arr.length; i++) {
                    System.out.println("arr[i]=" + arr[i]);
                }
            }
        }
    }
}
