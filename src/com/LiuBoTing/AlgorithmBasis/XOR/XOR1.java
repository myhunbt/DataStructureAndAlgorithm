package com.LiuBoTing.AlgorithmBasis.XOR;

/**
 * @author liuboting
 * @date 2021/9/20 12:00
 * 异或满足交换律和结合律
 *  0^N = N
 *  N^N = 0
 */

public class XOR1 {
    public static void main(String[] args) {
        int a = 10;
        int c = a^a;
        System.out.println("a^a = " + c);
        c = 0^a;
        System.out.println("0^a = " + c);
    }
}
