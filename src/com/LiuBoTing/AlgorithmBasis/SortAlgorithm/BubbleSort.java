package com.LiuBoTing.AlgorithmBasis.SortAlgorithm;


import java.util.Arrays;
import java.util.List;

/**
 * @author liuboting
 * @date 2021/9/19 7:38
 * 冒泡排序
 * O(n2)
 */

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{9,8,7,6,5,4,3,2,1};
//        int[] bubbleSort = bubbleSort(arr);
//        System.out.println(Arrays.toString(bubbleSort));
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            comparator(arr1);
            bubbleSort(arr2);
            if(!isEqual(arr1,arr2)){
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed == true ? "succeed":"failed");
    }

    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length == 1) return;
        for (int e = arr.length - 1; e > 0 ; e--) {
            for (int j = 0; j < e ; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    // 原地异或交换没有申请额外空间
    public static void swap(int[] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    public static int[] copyArray(int[] arr){
        if(arr == null) return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //对数器
    public static int[] generateRandomArray(int maxSize, int maxValue){
//        Math.random() [0,1)
//        Math.random() * N [0,N)
//        (int)(Math.random() * N) [0,N-1]
        // arr随机长度，范围[0,maxSize)
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random() - maxValue * Math.random());
        }
        return arr;
    }

    public static void printArray(int[] arr){
        Arrays.toString(arr);
    }

    public static boolean isEqual(int[] arr1,int[] arr2){
        if(arr1 == null && arr2 == null) return true;
        if(arr1 == null || arr2 == null) return false;
        if(arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
