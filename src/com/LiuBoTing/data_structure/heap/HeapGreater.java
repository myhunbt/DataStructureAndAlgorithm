package com.LiuBoTing.data_structure.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author liuboting
 * @date 2022/3/10 20:10
 * 加强堆
 */

public class HeapGreater<T> {
    private ArrayList<T> heap;
    //反向索引表
    private HashMap<T,Integer> indexMap;
    private int heapSize;
    private Comparator<? super T> myComparator;

    public HeapGreater(Comparator<T> comparator){
        myComparator = comparator;
        heapSize = 0;
        indexMap = new HashMap<T,Integer>();
        heap = new ArrayList<T>();
    }
    //判断是否为空
    public boolean isEmpty(){
        return heapSize == 0;
    }

    public int size(){
        return heapSize;
    }

    public boolean contain(T t){
        return indexMap.containsKey(t);
    }

    public T peek(){
        return heap.get(0);
    }

    public void push(T obj){
        indexMap.put(obj,heapSize);
        heap.add(obj);
        heapInsert(heapSize++);
    }

    public T pop(){
        T ans = heap.get(0);
        //交换第一个和最后一个的位置
        swap(0,heapSize-1);
        //堆中去掉ans
        heapSize--;
        //反向索引表去掉ans
        indexMap.remove(ans);
        //向下调整堆结构
        heapify(0);
        return ans;
    }

    private void swap(int a, int b) {
        T temp = heap.get(a);
        heap.set(a,heap.get(b));
        heap.set(b,temp);
        indexMap.put(heap.get(a),b);
        indexMap.put(heap.get(b),a);
    }

    private void heapInsert(int index) {
        while (myComparator.compare(heap.get(index),heap.get((index-1)/2)) > 0){
            swap(index,index/2-1);
            index = index/2-1;
        }
    }

    private void heapify(int index){
        while ((index*2+1) >= heapSize){
            //找到当前节点的左右孩子，并找到左右孩子的最大值的索引
            int maxIndex = (index*2+2) < heapSize ? (myComparator.compare(heap.get(index * 2 + 1), heap.get(index * 2 + 2)) > 0 ? (index*2+1) : (index*2+2)) : index*2+1;
            maxIndex = myComparator.compare(heap.get(maxIndex),heap.get(index)) > 0 ? maxIndex : index;
            if(maxIndex == index) break;
            swap(index,maxIndex);
            index = maxIndex;
        }
    }

    public void resign(T t){
        int index = indexMap.get(t);
        heapInsert(index);
        heapify(index);
    }

    public void remove(T t){
        int index = indexMap.get(t);
        swap(index,--heapSize);
        heapInsert(index);
        heapify(index);
    }

    public List<T> getAllElements() {
        return heap;
    }


}
