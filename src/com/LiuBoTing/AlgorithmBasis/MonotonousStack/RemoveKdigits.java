package com.LiuBoTing.AlgorithmBasis.MonotonousStack;

import java.util.ArrayDeque;

/**
 * @author liuboting
 * @date 2022/9/22 19:58
 */

public class RemoveKdigits {
    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        System.out.println(removeKdigits(num,k));
    }
    public static String removeKdigits(String num, int k) {
        if(k>=num.length()) return "0";
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char cur:num.toCharArray()) {
            while (k>0 && !stack.isEmpty() && stack.peek()>cur){
                stack.pop();
                k--;
            }
            stack.push(cur);
        }
        while (k>0){
            stack.pop();
            k--;
        }

        while (!stack.isEmpty() && stack.peekLast() == '0'){
            stack.pollLast();
        }
        if(stack.isEmpty()) return "0";
        while (!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
