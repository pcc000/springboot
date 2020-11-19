package com.blackfish.java.suanfa.heap;

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
        private void heapify(int[] arr, int index, int heapSize) {

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
    }


    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.push(3);
        maxHeap.push(5);
        maxHeap.push(6);
        maxHeap.push(3);
        maxHeap.push(2);
        maxHeap.push(3);
        maxHeap.push(7);
        maxHeap.printHeap();

    }
}
