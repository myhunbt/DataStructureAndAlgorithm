package com.LiuBoTing.AlgorithmBasis.DynamicProgramming;

/**
 * @author liuboting
 * @date 2022/9/1 21:38
 * 0 1 背包问题
 * int[] weight
 * int[] value
 * bag 可装载的重量
 */

public class _01Bag {
    public static void main(String[] args) {

    }
    public static int process(int[] w,int[] v,int index,int bag){
        if(bag < 0) return -1;
        if(index == w.length) return 0;
        int p1 = process(w,v,index+1,bag);

        int p2 = -1;
        int next = process(w,v,index+1,bag-w[index]);
        if(next != -1) p2 = next + v[index];
        return Math.max(p1,p2);
    }
    public static int dp(int[] w,int[] v,int index,int bag){
        int[][] dp = new int[w.length+1][bag+1];
        for (int i = 0; i < bag+1; i++) {
            dp[w.length][i] = 0;
        }
        for (int i = w.length-1; i >= 0; i--) {
            for (int j = 0; j < bag+1; j++) {
                int p1 = dp[i+1][bag];
                int p2 = -1;
                if(bag - w[i] >= 0){
                    p2 = dp[i+1][bag-w[i]] + v[i];
                }

            }
        }
        return dp[0][bag];
    }
}

