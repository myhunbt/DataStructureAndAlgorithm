package com.LiuBoTing.AlgorithmBasis.BinarySearch;

/**
 * @author liuboting
 * @date 2021/9/20 11:16
 * 在一共有序数组中,找<=某个数最右侧的位置
 */

public class BinarySearch3 {
    public static void main(String[] args) {
        int[] arr = new int[]{-9, -5, -4, 1, 2, 3, 4, 5, 5, 8};
        int target = 5;
        int i = binarySearch3(arr, target);
        System.out.println(i);
    }

    public static int binarySearch3(int[] arr, int target){
        int mid = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            mid = left + ((right - left)>>1);
            if(target >= arr[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return mid;
    }
}
