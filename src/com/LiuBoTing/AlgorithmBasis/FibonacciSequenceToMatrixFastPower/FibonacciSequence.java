package com.LiuBoTing.AlgorithmBasis.FibonacciSequenceToMatrixFastPower;

import java.util.LinkedHashMap;

/**
 * @author liuboting
 * @date 2022/4/13 18:43
 * 斐波那契数列
 * 给定一组数 1，1，2，3，5，8，13....
 * 求第n个数的值
 * 要求时间复杂度O(logN)
 */

public class FibonacciSequence {
    public static void main(String[] args) {
//        long time = System.currentTimeMillis();
//        System.out.println("递归：" + fibonacciSequence1(10));
//        long t1 = (System.currentTimeMillis() - time);
//        System.out.println("递归时间：" + t1);
//        time = System.currentTimeMillis();
//        System.out.println("矩阵快速幂：" + fibonacciSequence2(10));
//        long t2 = (System.currentTimeMillis() - time);
//        System.out.println("矩阵快速幂时间：" + t2);
        System.out.println(fibonacciSequence1(2));
    }
    public static int fibonacciSequence1(int n){
        /*数组第n个数满足：F(N) = F(N-1) + F(N-2) */
        return process4(n);
    }

    /*递归方式解
    * 时间复杂度：O(N)
    * */
    private static int process1(int n) {
        if(n < 1) return 0;
        if(n == 1 || n == 2) return 1;
        return process1(n-1)+process1(n-2);
    }
    public static int process3(int n){
        int[] res = new int[n+1];
        res[1] = 1;
        res[2] = 1;
        for(int i = 3;i <= n;i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }
    public static int process4(int n){
        int a = 0;
        int b = 0;
        int res = 1;
        for(int i = 2; i <= n;i++){
            a = b;
            b = res;
            res = (a + b)%(1000000007);
        }
        return res;
    }
    public static int fibonacciSequence2(int n){
        if(n < 1) return 0;
        if(n == 1 || n == 2) return 1;
        return process2(n);
    }

    /* 矩阵快速幂方式解（严格按照递推方式）
     * 时间复杂度：O(logN)
     * F(N) = F(N-1) + F(N-2) ->二阶递推式（-2）
     * 所以必然存在 |F(N),F(N-1)| = |F(2),F(1)| * |a  b|^(n-2)
     *                                          |c  d|
     * 解：|F(3),F(2)| = |F(2),F(1)| * |a  b|  |F(4),F(3)| = |F(3),F(2)| * |a  b|
     *                                |c  d|                              |c  d|
     * F(3) = F(2) * a + F(1) * c , F(2) = F(2) * b + F(1) * d
     * F(4) = F(3) * a + F(2) * c , F(3) = F(3) * b + F(2) * d
     *
     * 2 = a + c , 1 = b + d
     * 3 = 2a + c , 2 = 2b + d
     *
     * a = 1,c = 1,b = 1,d = 0
     */
    private static int process2(int n) {
        int[][] base = {
                {1,1},
                {1,0}
        };
        int[][] res = matrixPower(base,n-2);
        return res[0][0] + res[1][0];
    }

    private static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            res[i][i] = 1;
        }
        int[][] t = m;

        // 二分思想降低复杂度 10^75 -> 75 = 64+8+2+1  01001011
        for (;p != 0;p >>= 1){
            if((p & 1) != 0){
                res = muliMatrix(res,t);
            }
            t = muliMatrix(t,t);
        }
        return res;
    }

    private static int[][] muliMatrix(int[][] res, int[][] t) {
        int[][] mu = new int[res.length][t[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                int ans = 0;
                for (int k = 0; k < res[0].length; k++) {
                    ans += res[i][k] * t[k][j];
                }
               mu[i][j] = ans;
            }
        }
        return mu;
    }

}
