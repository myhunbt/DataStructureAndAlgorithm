package com.LiuBoTing.data_structure.stack;

/**
 * @author liuboting
 * @date 2020/9/21 18:28
 */

public class Calculator {

    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";
        Stack1 numStack = new Stack1(10);
        Stack1 operStack = new Stack1(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int oper = 0;
        char ch = ' ';
        StringBuffer num = new StringBuffer("");

        while (true){
            ch = expression.charAt(index);
            //判断 ch 是什么，然后做相应的处理
            if(numStack.isOper(ch)){//如果是运算符
                //判断当前的符号栈是否为空
                if(operStack.isEmpty()){
                    //如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,
                    // 就需要从数栈中 pop 出两个数,
                    operStack.push(ch);
                }else if(operStack.priority(operStack.peek()) >= operStack.priority(ch)){
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    oper = operStack.pop();
                    res = numStack.cal(num1, num2, oper);
                    numStack.push(res);
                    operStack.push(ch);
                }else {
                    operStack.push(ch);
                }

            }else { // 数字
                num.append(ch - 48);
                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(num.toString()));
                }else {
                    if (numStack.isOper(expression.charAt(index + 1))) {
                        numStack.push(Integer.parseInt(num.toString()));
                        num = new StringBuffer("");
                    }
                }
            }
            index ++;
            if(index >= expression.length()){
                break;
            }
        }

        while (true){
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }

        System.out.printf("%s=%d",expression,numStack.pop());
    }

}
class Stack1{
    int top = -1;
    int maxSize;
    int[] stack = null;

    public Stack1(int maxSize) {
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

    public void list(Stack1 stack){
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

    public int priority(int oper){
        if(oper == '-' || oper == '+'){
            return 0;
        }else if(oper == '*' || oper == '/'){
            return 1;
        }else {
            return -1;  // 假定目前的表达式只有 +, - , * , /
        }
    }

    public int peek(){
        return stack[top];
    }

    public boolean isOper(char val){
        return priority(val) != -1;
    }

    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
            default:
                break;
        }
        return res;
    }

}
