package com.LiuBoTing.AlgorithmBasis.XOR;

/**
 * @author liuboting
 * @date 2021/9/20 13:52
 * 如何不用额外变量交换两个数
 */

public class XOR2 {
    public static void main(String[] args) {
        int a = 11;
        int b = 14;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

}
