package com.LiuBoTing.AlgorithmBasis.BinarySearch;

/**
 * @author liuboting
 * @date 2021/9/20 11:30
 * 局部最小值问题(无序数组)
 * 找到一个局部最小值位置返回即可
 * 正常遍历最差情况O(N)
 * 有没有复杂度更低的算法O(logN)
 */

public class BinarySearch4 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, -5, -4, 1, 2, 3, 4, 5, 5, 8};
        int i = binarySearch4(arr);
        System.out.println(i);
    }

    public static int binarySearch4(int[] arr){
        if(arr == null || arr.length <= 1) return -1;
        if(arr[0] < arr[1]) return 0;
        if(arr[arr.length-1] < arr[arr.length - 2]) return arr.length - 1;
        if(arr.length <= 2) return -1;
        int left = 0;
        int right = arr.length - 1;
        int mid = -1;
        while (left <= right){
            mid = left + ((right - left)>>1);
            if(arr[mid] < arr[mid+1] && arr[mid] < arr[mid-1]){
                break;
            }else if(arr[mid] > arr[mid-1]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return mid;
    }
}
