package com.LiuBoTing.data_structure.recursive;

import com.LiuBoTing.DesignPatterns.Singleton.EnumSingleton;

/**
 * @author liuboting
 * @date 2022/6/13 16:22
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class qingwatiaotai {
    public static void main(String[] args) {
        System.out.println(numWays3(44));
    }

    // 解法1：递归 ：时间超出限制
    public static int numWays1(int n) {
        if(n < 2) return 1;
        return process1(n);
    }

    public static int process1(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        return (process1(n-1) + process1(n-2))%(1000000007);
    }

    // 解法2：备忘录递归
    public static int numWays2(int n) {
        if(n < 2) return 1;
        int[] note  = new int[n+1];
        note[0] = note[1] = 1;
        return process2(n,note);
    }

    public static int process2(int n,int[] note) {
        int way1 = (note[n-1] == 0 ? process2(n-1,note) : note[n-1]);
        int way2 = (note[n-2] == 0 ? process2(n-2,note) : note[n-2]);
        note[n] = (way1 + way2)%(1000000007);
        return note[n];
    }

    // 解法2：动态规划
    public static int numWays3(int n){
        int[] note = new int[n + 1];
        note[0] = note[1] = 1;
        for (int i = 2; i <= n; i++) {
            note[i] = (note[i-1] + note[i-2])%(1000000007);
        }
        return note[n];
    }
}
