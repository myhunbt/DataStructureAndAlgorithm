package com.LiuBoTing.AlgorithmBasis.SortAlgorithm;

/**
 * @author liuboting
 * @date 2022/2/15 20:40
 * 归并排序
 * O(N*logN)
 */

public class MergeSort {
    public static void main(String[] args) {

    }

    //传入数组以及数组左边界和数组右边界
    public static void mergeSort(int[] arr,int L,int R){
        //递归到只有一个数则无需排序
        if(L == R) return;
        //取中间值
        int M = L + ((R - L) >> 1);
        mergeSort(arr,L,M);
        mergeSort(arr,M+1,R);
        //排序
        merge(arr,L,M,R);
    }

    private static void merge(int[] arr,int L,int M,int R) {
        //帮助数组，将比较完大小的数依次放入help数组中
        int[] help = new int[R-L+1];
        //定义两个指针，分别指向未排好序的左右两个数组的第一位
        int p1 = L;
        int p2 = M+1;
        int i = 0;
        while (p1 <= M && p2 <= R){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //p1越界或p2越界
        while (p1 <= M){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        //复制回原数组
        for(i = 0;i < R-L+1;i++){
            arr[i] = help[i];
        }
    }

    public static void mergeSort2(int[] arr){
       if(arr == null || arr.length < 2) return;
       int mergeSize = 1;
       while (mergeSize < arr.length){
           int L = 0;
           while (L < arr.length){
               int M = L + mergeSize - 1;
               if(M >= arr.length) break;
               int R = Math.min(M+mergeSize,arr.length-1);
               merge(arr,L,M,R);
               L = R + 1;
           }
            mergeSize <<= 1;
       }
    }
}
