package com.LiuBoTing.AlgorithmBasis.Recursion;

/**
 * @author liuboting
 * @date 2022/3/18 13:15
 * 数字转化字符方案
 * 给定一共数字字符数组，返回有多少种转化结果。规定 1:A ,2:B ... 26:Z
 * 例：[1,2,3,4] -> ABCD, LCD ...
 *
 */

public class ConvertToString {
    public static void main(String[] args) {

    }

    public static int way1(String str){
        return process1(str.toCharArray(),0);
    }
    public static int process1(char[] arr,int index){
        if(index == arr.length) return 1;
        if(arr[index] == '0') return 0;

        int p1 = process1(arr,index+1);

        int p2 = 0;
        if(index+1 != arr.length && arr[index] * 10 + arr[index + 1] <= 26){
            p2 = process1(arr,index+2);
        }
        return p1 + p2;
    }
}
