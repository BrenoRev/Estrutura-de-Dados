package Desafios.Add_All;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Coded by
        // Breno Silva

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            BinaryHeap heap = new BinaryHeap();
            for (int i = 0; i < n; i++) {
                heap.insert(sc.nextLong());
            }
            long cost = 0;
            while (heap.size() > 1 && n > 1) {
                long x = heap.extractMin() + heap.extractMin();
                cost += x;
                heap.insert(x);
                n--;
            }
            System.out.println(cost);
        }
    }
}

class BinaryHeap {
    private long[] heap;
    private int size;

    public BinaryHeap() {
        heap = new long[100001];
        size = 0;
    }

    public void insert(long value) {
        heap[size + 1] = value;
        size++;
        heapifyUp(size);
    }

    public long extractMin() {
        long min = heap[1];
        heap[1] = heap[size];
        size--;
        heapifyDown(1);
        return min;
    }

    public int size() {
        return size;
    }

    private void heapifyUp(int index) {
        while (index > 1 && heap[index] < heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left <= size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right <= size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        long temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return 2 * index;
    }

    private int rightChild(int index) {
        return 2 * index + 1;
    }
}