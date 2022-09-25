package com.LiuBoTing.AlgorithmBasis.XOR;

/**
 * @author liuboting
 * @date 2021/9/20 13:55
 * 一个数组中有一种数出现奇数次,其他数出现偶数次,怎么找到并打印这个数
 */

public class XOR3 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3,3,4};
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        System.out.println(eor);
    }
}
