package com.LiuBoTing.AlgorithmBasis.SortAlgorithm;

import java.util.Arrays;

/**
 * @author liuboting
 * @date 2022/2/17 20:50
 * 堆排序
 * 时间复杂度：O(N*logN)
 * 空间复杂度：O(1)
 */

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,6,2,0,4,7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2) return;
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr,i);
//        }
        for (int i = arr.length-1; i >= 0 ; i--) {
            heapify(arr,i,arr.length);
        }
        System.out.println(Arrays.toString(arr));
        int len = arr.length;
        swap(arr,0,--len);
        while (len > 0){
            heapify(arr,0,len);
            swap(arr,0,--len);
        }
    }

    private static void heapify(int[] heap, int index, int heapSize) {
        int left = index*2+1;
        while (left < heapSize){
            int largest = (left+1<heapSize && heap[left] < heap[left+1]) ? left+1:left;
            largest = heap[largest] > heap[index] ? largest:index;
            if(index == largest) break;
            swap(heap,index,largest);
            index = largest;
            left = index*2+1;
        }
    }

    private static void heapInsert(int[] heap, int index) {
        while (heap[index] > heap[(index-1)/2]){
            swap(heap,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    private static void swap(int[] heap,int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}
