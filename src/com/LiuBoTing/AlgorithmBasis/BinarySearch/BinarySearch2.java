package com.LiuBoTing.AlgorithmBasis.BinarySearch;

/**
 * @author liuboting
 * @date 2021/9/20 10:52
 * 在一个有序数组中,找到>=某个数最左侧的位置
 */

public class BinarySearch2 {
    public static void main(String[] args) {
        int[] arr = new int[]{-9, -5, -4, 1, 2, 3, 4, 5, 5, 8};
        int target = 5;
        int i = binarySearch2(arr, target);
        System.out.println(i);
    }

    public static int binarySearch2(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right){
            mid = left + ((right - left)>>1);
            if(target > arr[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return mid;
    }
}
