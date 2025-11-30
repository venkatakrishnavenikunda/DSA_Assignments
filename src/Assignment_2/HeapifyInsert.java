package Assignment_2;

public class HeapifyInsert {
    int[] heap;
    int size;
    int capacity;

    HeapifyInsert(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    // Insert using Heapify Up
    void insert(int val) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }

        heap[size] = val;  // insert at end
        int i = size;
        size++;

        // Heapify Up (Bubble Up)
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    void printHeap() {
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        HeapifyInsert h = new HeapifyInsert(10);

        h.insert(20);
        h.insert(15);
        h.insert(30);
        h.insert(5);

        h.printHeap();
    }
}