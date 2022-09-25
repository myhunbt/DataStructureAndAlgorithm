package com.LiuBoTing.data_structure.heap;

/**
 * @author liuboting
 * @date 2022/2/17 20:57
 */

public class Heap01 {
    //大顶堆
    public static void main(String[] args) {

    }
    public static class MyMaxHeap{
        private int[] heap;
        private int limit;
        private int heapSize;

        public MyMaxHeap(int limit){
            this.limit = limit;
            heap = new int[limit];
            heapSize = 0;
        }

        // 判断堆是否为空
        public boolean isEmpty(){
            return heapSize == 0;
        }

        // 判断堆是否满
        public boolean isFull(){
            return heapSize == limit;
        }

        // 放入元素
        public void push(int value){
            // 满了则抛异常
            if(isFull()) throw new RuntimeException("heap is full");

            heap[heapSize++] = value;
            heapInsert(heap,heapSize);
        }
        //弹出堆最大值，也就是堆顶heap[0]
        public int pop(){
            int ans = heap[0];
            swap(heap,0,--heapSize);
            heapify(heap,0,heapSize);
            return ans;
        }

        private void heapify(int[] heap, int index, int heapSize) {
            int left = index>>1|1;
            while (left < heapSize){
                int largest = left+1<heapSize && heap[left] < heap[left+1] ? left:left+1;
                largest = heap[left] > heap[index] ? left:index;
                if(index == largest) break;
                swap(heap,index,largest);
                index = largest;
                left = index>>1|1;
            }
        }

        private void heapInsert(int[] heap, int index) {
            while (heap[index] > heap[(index-1)>>1]){
                swap(heap,heap[index],heap[(index-1)>>1]);
                index = (index-1)>>1;
            }
        }

        private void swap(int[] heap,int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }


    }
}
