package com.LiuBoTing.AlgorithmBasis.XOR;

/**
 * @author liuboting
 * @date 2021/9/20 14:04
 * 一个数组中有两种数出现奇数次,其他数出现偶数次,怎么找到并打印这两个数(a,b)
 */

public class XOR5 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3,3,3,4,4,4,4,5,5,5,5,5};
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];  // eor = a^b
        }

        int rightOne = eor & (~eor + 1);
        int eor2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] & rightOne) != 0){
                eor2 = eor2 ^ arr[i];   // a/b
            }
        }

        System.out.println("a = " + eor2 + "\n" + "b = " + (eor2 ^ eor));
    }
}
