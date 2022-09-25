package com.LiuBoTing.data_structure.queue;

import java.util.Scanner;

/**
 * @author liuboting
 * @date 2020/9/13 11:16
 * 对前面的数组模拟队列的优化，充分利用数组. 因此将数组看做是一个环形的。(通过取模的方式来实现即可)
 * 思路如下:
 * 1. front变量的含义做一个调整:front就指向队列的第一个元素,也就是说arr[front]就是队列的第一个元素
 * front的初始值=0
 * 2.rear变量的含义做一个调整:rear指向队列的最后一个元素的后一个位置.因为希望空出一个空间做为约定.
 * rear的初始值=o
 * 3.当队列满时，条件是(rear +1)%maxSize = front【满】
 * 4.对队列为空的条件，rear == front空
 * 5.当我们这样分析，队列中有效的数据的个数(rear+ maxSize-front) %maxSize // rear= 1 front=O
 * 6.我们就可以在原来的队列上修改得到，一个环形队列
 */

public class CircleQueue {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
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

    public static class CircleArrayQueue{
        private int maxSize;
        private int front;
        private int rear;
        private int[] arr;

        public CircleArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            front = 0;
            rear = 0;
            arr = new int[maxSize];
        }

        public boolean isEmpty(){
            return front == rear;
        }

        public boolean isFull(){
            return (rear+1)%maxSize == front;
        }


        public int getQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }else {
                int value = arr[front];
                front = (front+1)%maxSize;
                return value;
            }
        }

        public void addQueue(int value){
            if(isFull()){
                System.out.println("队列满了");
            }else {
                arr[rear] = value;
                rear = (rear+1)%maxSize;
            }
        }

        public int headQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }else {
                return arr[front];
            }
        }

        public void showQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }else{
                for (int i = front; i < front + size(); i++) {
                    System.out.printf("arr[%d]=%d\n",(i%maxSize),arr[i%maxSize]);
                }
            }
        }

        public int size(){
            return  (rear-front+maxSize)%maxSize;
        }
    }
}
