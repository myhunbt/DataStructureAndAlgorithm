package com.LiuBoTing.AlgorithmBasis.Recursion;

/**
 * @author liuboting
 * @date 2022/3/18 12:30
 * 背包问题
 * 给定两个数组w,v
 * w = [5,6,8,1,4] 重量 w[i] >= 0
 * v = [1,0,5,7,3] 价值 v[i] >= 0
 * 背包最大可负载重量：bag
 * 求背包最大可获得的价值
 */

public class knapsack {
    public static void main(String[] args) {

    }

    //解一：暴力递归
    public static int getMaxValue1(int[] weight,int[] value,int bag){
        return process1(weight,value,0,bag);
    }

    private static int process1(int[] weight, int[] value, int index, int bag) {
        if(bag < 0){
            return -1;
        }
        if(index == weight.length){
            return 0;
        }
        //不要当前的物品
        int p1 = process1(weight,value,index+1,bag);

        //要当前的物品
        int p2 = 0;
        int next = process1(weight, value, index + 1, bag - weight[index]);
        if(next != -1){
            p2 = value[index] + next;
        }
        return Math.max(p1,p2);
    }

    //解二：带备忘录的递归 （优化：因为递归过程中存在重复解）
    public static int getMaxValue2(int[] weight,int[] value,int bag){
        int[][] notebook = new int[weight.length+1][bag];
        for (int i = 0; i < weight.length+1; i++) {
            for (int j = 0; j < bag; j++) {
                notebook[i][j] = -1;
            }
        }
        return process2(weight,value,0,bag,notebook);
    }

    private static int process2(int[] weight, int[] value, int index, int bag, int[][] notebook) {
        if(bag < 0){
            return -1;
        }
        if(index == weight.length){
            return 0;
        }
        if(notebook[index][bag] != -1) return notebook[index][bag];
        //不要当前的物品
        int p1 = process2(weight,value,index+1,bag,notebook);

        //要当前的物品
        int p2 = 0;
        int next = process2(weight, value, index + 1, bag - weight[index],notebook);
        if(next != -1){
            p2 = value[index] + next;
        }
        return notebook[index][bag] = Math.max(p1,p2);
    }

    //解三：动态规划
    public static int getMaxValue3(int[] weight,int[] value,int bag){
        int[][] dp = new int[weight.length+1][bag+1];
        for (int i = weight.length-1; i >= 0; i--) {
            for (int j = 0; j < bag+1; j++) {
                //不要当前的物品
                int p1 = dp[i+1][j];
                //要当前的物品
                int p2 = 0;
                if(j - weight[i] >= 0){
                    p2 = value[i] + dp[i+1][j];
                }
                dp[i][j] = Math.max(p1,p2);
            }
        }
        return dp[0][bag];
    }
}
