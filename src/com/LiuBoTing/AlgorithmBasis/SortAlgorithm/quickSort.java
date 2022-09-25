package com.LiuBoTing.AlgorithmBasis.SortAlgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author liuboting
 * @date 2022/2/16 20:50
 * 快排
 * 时间复杂度：O(N*logN)
 * 额外空间复杂度：O(logN)
 */

public class quickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,8,1,2,7,2};

        quickSort3(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort1(int[] arr){
        if(arr == null || arr.length < 2) return;
        process1(arr,0,arr.length-1);
    }

    public static void process1(int[] arr,int L,int R) {
        if(L >= R) return;
        int M = partition(arr,L,R);
        process1(arr,L,M-1);
        process1(arr,M+1,R);
    }

    public static int partition(int[] arr,int L,int R) {
        int p1 = L - 1;
        int p2 = R + 1;
        int i = L;
        int num = arr[R];
        while (i < p2){
            if(arr[i] == num){
                i++;
            }else if(arr[i] < num){
                swap(arr,++p1,i++);
            }else {
                swap(arr,--p2,i);
            }
        }
        return p1+1;
    }

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void quickSort2(int[] arr){
        if(arr == null || arr.length < 2) return;
        process2(arr,0,arr.length-1);
    }

    public static void process2(int[] arr,int L,int R) {
        if(L >= R) return;
        int[] temp = partition2(arr,L,R);
        process2(arr,L,temp[0]-1);
        process2(arr,temp[1]+1,R);
    }

    public static int[] partition2(int[] arr, int L, int R) {
        int p1 = L - 1;
        int p2 = R + 1;
        int num = arr[R];
        int i = L;
        while (i < p2){
            if(arr[i] == num){
                i++;
            }else if(arr[i] < num){
                swap(arr,++p1,i++);
            }else {
                swap(arr,--p2,i);
            }
        }
        return new int[]{p1+1,p2-1};
    }

    public static void quickSort3(int[] arr){
        if(arr == null || arr.length < 2) return;
        process3(arr,0,arr.length-1);
    }

    public static void process3(int[] arr, int L, int R) {
        if(L >= R) return;
        swap(arr,(int)(L + (R-L+1) * Math.random()),R);
        int[] temp = partition2(arr,L,R);
        process3(arr,L,temp[0]-1);
        process3(arr,temp[1]+1,R);
    }
}
