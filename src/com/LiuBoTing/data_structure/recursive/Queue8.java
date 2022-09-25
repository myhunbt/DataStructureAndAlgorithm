package com.LiuBoTing.data_structure.recursive;

/**
 * @author liuboting
 * @date 2020/9/12 10:36
 */

public class Queue8 {
    int max = 8;
    int[] arr = new int[max];
    public static int count = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }


    private void check(int n){
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if(judge(n)){ // 不冲突
                if(n < 7){ //继续摆放
                    check(n+1);
                }else { // 已经摆放到第八个位置了，winner
                    print();
                }
            }
        }
    }

    //判断当前第n-1个皇后与前面的皇后是否冲突
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if(arr[i] == arr[n] || Math.abs(i-n) == Math.abs(arr[i] - arr[n])){
                return false;
            }
        }
        return true;
    }

    // 打印出八皇后的位置
    private void print(){
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
