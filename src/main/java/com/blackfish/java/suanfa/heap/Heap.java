package com.blackfish.java.suanfa.heap;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @Auther: shuyiwei
 * @Date: 2020/11/19 20:15
 * @Description:
 */
public class Heap {

    public static class MaxHeap{
        private int[] heap;

        private final int limit;

        private int heapSize;

        public MaxHeap(int limit) {
            this.heap = new int[limit];
            this.limit = limit;
            this.heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int value){
            if(heapSize == limit ){
                throw new RuntimeException("is full");
            }
            heap[heapSize] = value;
            heapInsert(heap,heapSize++);
        }

        public void heapInsert(int arr[],int index){
            while (arr[index] > arr[(index-1)/2]){
                swap(arr,index,(index-1)/2);
                index = (index-1)/2;
            }
        }

        public void heapSort(int[] arr){
            if(null == arr || arr.length<2){
                return;
            }
            for(int i=arr.length-1;i>=0;i--){
                heapify(arr,i,arr.length);
            }
            int heapSize = arr.length;
            swap(arr,0,--heapSize);
            while(heapSize>0){
                heapify(arr,0,heapSize);
                swap(arr,0,--heapSize);
            }

        }

        public void heapify(int[] arr, int index, int heapSize) {
            int left = index*2+1;
            while(left < heapSize){
                int largetestIndex =  left+1<heapSize && arr[left+1]>arr[left] ? left+1 : left;
                largetestIndex = arr[largetestIndex]>arr[index] ? largetestIndex : index;
                if(largetestIndex == index){
                    break;
                }
                swap(arr,largetestIndex,index);
                index = largetestIndex;
                left = 2*index+1;
            }
        }

        public void swap(int[] arr,int i,int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }

        public void printHeap(){
            StringBuffer stringBuffer = new StringBuffer();
            for(int i=0;i<heapSize;i++){
                stringBuffer.append(heap[i]).append(",");
            }
            System.out.println(stringBuffer.toString());
        }

        public void printHeap(int[] arr){
            StringBuffer stringBuffer = new StringBuffer();
            for(int i=0;i<arr.length;i++){
                stringBuffer.append(arr[i]).append(",");
            }
            System.out.println(stringBuffer.toString());
        }
    }


    public static void main(String[] args) {
//        MaxHeap maxHeap = new MaxHeap(10);
//        maxHeap.push(3);
//        maxHeap.push(5);
//        maxHeap.push(6);
//        maxHeap.push(3);
//        maxHeap.push(2);
//        maxHeap.push(3);
//        maxHeap.push(7);
//        maxHeap.printHeap();

        int[] heapArr = new int[]{3,5,6,3,2,3,8};
        MaxHeap maxHeap = new MaxHeap(heapArr.length);
        for(int i=heapArr.length-1;i>=0;i--){
            maxHeap.heapify(heapArr,i,heapArr.length);
        }
//        maxHeap.heapSort(heapArr);
        maxHeap.printHeap(heapArr);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.add(3);
        priorityQueue.add(5);
        priorityQueue.add(6);
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(8);
        Object[] resultList = priorityQueue.toArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<resultList.length;i++){
            stringBuilder.append(resultList[i]).append(",");
        }
        System.out.println(stringBuilder.toString());





    }
}
