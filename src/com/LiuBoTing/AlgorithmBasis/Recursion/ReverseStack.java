package com.LiuBoTing.AlgorithmBasis.Recursion;

import java.util.Stack;

/**
 * @author liuboting
 * @date 2022/3/15 13:16
 * 不利用任何数据结构反转栈（没有额外空间）
 * 用递归完成反转
 */

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        reverse(stack);
    }

    private static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        Integer last = returnAndRemoveLast(stack);
        reverse(stack);
        stack.push(last);
    }

    private static Integer returnAndRemoveLast(Stack<Integer> stack) {
        Integer pop = stack.pop();
        if(stack.isEmpty()){
            return pop;
        }else {
            Integer last = returnAndRemoveLast(stack);
            stack.push(pop);
            return last;
        }
    }


}
