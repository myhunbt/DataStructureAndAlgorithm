package com.LiuBoTing.AlgorithmBasis.XOR;

/**
 * @author liuboting
 * @date 2021/9/20 13:58
 * 怎么把一个int类型的数,提取出最右侧的1来
 * 10100100
 * 00000100
 */

public class XOR4 {
    public static void main(String[] args) {
        int a = 66;
        int b = a & (~a + 1);
        System.out.println(b);
    }
}
