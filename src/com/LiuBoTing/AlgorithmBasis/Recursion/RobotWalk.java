package com.LiuBoTing.AlgorithmBasis.Recursion;

/**
 * @author liuboting
 * @date 2022/3/15 17:03
 * 机器人走路
 * 给定一个正整数N  共有1~N这些位置可以走
 * 假设小机器人在 1~N 的某个位置A  最终小机器人想从A走到目标B 可以走K步
 * 求出一共有多少种走法
 * 例：N=7，A=2，B=5，K=6
 */

public class RobotWalk {
    public static void main(String[] args) {

        walkWay1(2,4,4,7);
    }
    //暴力递归
    //cur(当前位置),rest(剩下可以走的步数),aim(目标位置),N(共有多少位置可以走)
    //分析：1.当小机器人在1位置（也就是左边界），此时它只能朝右走。
    //     2.当小机器人在N位置（也就是右边界），此时它只能超左走。
    //     3.当小机器人在（1,N）中间位置，此时它既可以朝左走也可也朝右走。
    /*  0   1   2   3   4
    * 0 0
    * 1 0
    * 2 0
    * 3 0
    * 4 0
    * */
    private static int walkWay1(int cur, int rest, int aim, int N) {
        // base case ：当剩余步数为0时，判断小机器人是否到达目标点，如到达返回1，否则返回0
        if(rest == 0){
            return cur == aim ? 1 : 0;
        }
        // 1.当小机器人在1位置（也就是左边界），此时它只能朝右走。
        if(cur == 1){
            return walkWay1(cur+1,rest-1,aim,N);
        }
        // 2.当小机器人在N位置（也就是右边界），此时它只能超左走。
        if(cur == N){
            return walkWay1(cur-1,rest-1,aim,N);
        }
        // 3.当小机器人在（1,N）中间位置，此时它既可以朝左走也可也朝右走。
        return walkWay1(cur-1,rest-1,aim,N) + walkWay1(cur+1,rest-1,aim,N);
    }

    // 优化：暴力递归包含大量重复计算，我们增加一个记事本，如果当前情况之前已经计算过则直接返回。
    private static int walkWay2(int cur, int rest, int aim, int N) {
        int[][] notebook = new int[N][rest];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < rest; j++) {
                notebook[i][j] = -1;
            }
        }
        int ans = way2(cur, rest, aim, N, notebook);
        return ans;
    }

    private static int way2(int cur, int rest, int aim, int N, int[][] notebook) {
        if(notebook[cur][rest] != -1) return notebook[cur][rest];
        // base case ：当剩余步数为0时，判断小机器人是否到达目标点，如到达返回1，否则返回0
        if(rest == 0){
            return cur == aim ? (notebook[cur][rest] = 1) : (notebook[cur][rest] = 0);
        }
        // 1.当小机器人在1位置（也就是左边界），此时它只能朝右走。
        if(cur == 1){
            return notebook[cur][rest] = walkWay1(cur+1,rest-1,aim,N);
        }
        // 2.当小机器人在N位置（也就是右边界），此时它只能超左走。
        if(cur == N){
            return notebook[cur][rest] = walkWay1(cur-1,rest-1,aim,N);
        }
        // 3.当小机器人在（1,N）中间位置，此时它既可以朝左走也可也朝右走。
        return notebook[cur][rest] = walkWay1(cur-1,rest-1,aim,N) + walkWay1(cur+1,rest-1,aim,N);
    }

    //递归修改动态规划
    private static int walkWay3(int cur, int rest, int aim, int N) {
        int[][] dp = new int[N+1][rest+1];
        dp[aim][0] = 1;
        for (int i = 1; i < rest; i++) {
            dp[1][i] = dp[2][i-1];
            for (int j = 2; j < N-1; j++) {
                dp[j][i] = dp[j+1][i-1] + dp[j-1][i-1];
            }
            dp[N][i] = dp[N-1][i-1];
        }
        return dp[cur][rest];
    }
}
