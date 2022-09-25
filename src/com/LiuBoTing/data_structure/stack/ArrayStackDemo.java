package com.LiuBoTing.data_structure.stack;

/**
 * @author liuboting
 * @date 2020/9/15 19:58
 */

public class ArrayStackDemo {

}

class Stack{
    int top = -1;
    int maxSize;
    int[] stack = null;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("满了呀");
            return;
        }
        stack[++top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈里啥都莫得，你取个锤子");
        }

        return stack[top--];
    }

    public void list(Stack stack){
        if(isEmpty()){
            System.out.println("栈里啥都莫得，你取个锤子");
        }

        while (true){
            if(isEmpty()){
                break;
            }
            System.out.printf("stack[%d] = %d" ,top ,stack.pop());
        }
    }


}


