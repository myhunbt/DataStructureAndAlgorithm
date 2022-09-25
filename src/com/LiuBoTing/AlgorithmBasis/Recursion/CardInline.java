package com.LiuBoTing.AlgorithmBasis.Recursion;

/**
 * @author liuboting
 * @date 2022/3/16 15:38
 * 获取最大分数
 * 给定一个数组arr,arr中每个值都是一个分数
 * 现在有两个人 A和B ，A先手拿牌，B后手拿牌 。但是两人每次只能从牌堆的最底部或最顶部拿一张 (也就是数组的两侧的牌)
 * 两个人都绝顶聪明，都会竭尽全力拿到最大的分数和；
 */

public class CardInline {
    public static void main(String[] args) {

    }


    //解一：暴力递归
    public static int way1(int[] arr){
        int first = first(arr, 0, arr.length - 1);
        int second = second(arr, 0, arr.length - 1);
        return Math.max(first,second);
    }
    //先手
    public static int first(int[] arr,int left,int right){
        //base cas当牌堆只剩一张牌时，A（先手）拿到
        if(left == right) return arr[left];
        //分情况讨论
        //情况一：A选择左边的牌
        int p1 = arr[left] + second(arr,left+1,right);
        //情况二：A选择右边的牌
        int p2 = arr[right] + second(arr,left,right-1);
        return Math.max(p1,p2);
    }
    //后手
    public static int second(int[] arr,int left,int right){
        //base cas当牌堆只剩一张牌时，A（先手）拿到，B拿不到就返回0
        if(left == right) return 0;
        //分情况讨论
        //情况一：B选择左边的牌
        int p1 = first(arr,left+1,right);
        //情况二：B选择右边的牌
        int p2 = first(arr,left,right-1);
        return Math.min(p1,p2);
    }

    //解二：带记事本的递归.(因为递归的过程中存在重复计算可以进行优化)
    public static int way2(int[] arr){
        int[][] notebook1 = new int[arr.length-1][arr.length-1];
        int[][] notebook2 = new int[arr.length-1][arr.length-1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                notebook1[i][j] = -1;
                notebook2[i][j] = -1;
            }
        }
        int first = first2(arr, 0, arr.length - 1,notebook1);
        int second = second2(arr, 0, arr.length - 1,notebook2);
        return Math.max(first,second);
    }
    //先手
    public static int first2(int[] arr,int left,int right,int[][] notebook1){
        //base cas当牌堆只剩一张牌时，A（先手）拿到
        if(left == right) return notebook1[left][right] = arr[left];
        if(notebook1[left][right] != -1) return notebook1[left][right];
        //分情况讨论
        //情况一：A选择左边的牌
        int p1 = arr[left] + second(arr,left+1,right);
        //情况二：A选择右边的牌
        int p2 = arr[right] + second(arr,left,right-1);
        return notebook1[left][right] = Math.max(p1,p2);
    }
    //后手
    public static int second2(int[] arr,int left,int right,int[][] notebook2){
        //base cas当牌堆只剩一张牌时，A（先手）拿到，B拿不到就返回0
        if(left == right) return notebook2[left][right] = 0;
        if(notebook2[left][right] != -1) return notebook2[left][right];
        //分情况讨论
        //情况一：B选择左边的牌
        int p1 = first(arr,left+1,right);
        //情况二：B选择右边的牌
        int p2 = first(arr,left,right-1);
        return notebook2[left][right] = Math.min(p1,p2);
    }

    //解三：动态规划
    public static int way3(int[] arr){
        int[][] firstDP = new int[arr.length-1][arr.length-1];
        int[][] secondDP = new int[arr.length-1][arr.length-1];
        for (int i = 0; i < arr.length; i++) {
            firstDP[i][i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = 1; j < arr.length; j++) {
                firstDP[index][j] = Math.max(arr[index]+secondDP[index+1][j],arr[j]+secondDP[index][j-1]);
                secondDP[index][j] = Math.min(firstDP[index+1][j],firstDP[index][j]);
                index++;
            }
        }
        return Math.max(firstDP[0][arr.length-1],secondDP[0][arr.length-1]);
    }


}
