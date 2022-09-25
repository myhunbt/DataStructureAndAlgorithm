package com.LiuBoTing.AlgorithmBasis.BinarySearch;

import java.util.Arrays;

/**
 * @author liuboting
 * @date 2021/9/20 10:07
 * 在一个有序数组中,找到某个数是否存在
 */

public class BinarySearch {
    public static void main(String[] args) {
        int testTime = 500000;
        boolean flag = true;
        int[] arr;
        int target;
        for (int i = 0; i < testTime; i++) {
            arr = generateRandomArray(10, 10);
            Arrays.sort(arr);
            if(arr.length == 0) continue;
            target = arr[(int)(Math.random() * arr.length)];
            flag = binarySearch(arr, target);
            if(flag == false){
                printArray(arr);
                System.out.println("target:" + target);
                break;
            }
        }
        System.out.println(flag);
//        int[] arr = new int[]{-9, -5, -4, 1, 2, 3, 4, 5, 5, 8};
//        int target = 1;
//        System.out.println(binarySearch(arr, target));
    }

    public static boolean binarySearch(int[] arr, int target){
        if(arr == null) return false;
        int left = 0;
        int right = arr.length-1;
        int mid;
        while (left <= right){
            mid = left + ((right - left)>>1);
            if(target == arr[mid]){
                return true;
            }else if(target > arr[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)(Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
        }
        return arr;
    }

    public static void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
