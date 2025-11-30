package Assignment_2;

class Heap2{
    int[] heap;
    int size;
    int capacity;

    Heap2(int capacity){
        this.capacity=capacity;
        this.heap=new int [capacity];
        this.size=0;
    }

    int parent(int i){
        return (i-1)/2;
    }

    int left(int i){
        return 2*i+1;
    }

    int right(int i){
        return 2*i+2;
    }

    void insert(int val) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        heap[size] = val; // insert at end
        int i = size;
        size++;

        // Bubble up (heapify up)
        while (i != 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    int extractMax() {
        if (size == 0) return Integer.MIN_VALUE;

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);

        return root;
    }

    void heapifyDown(int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l] > heap[largest])
            largest = l;

        if (r < size && heap[r] > heap[largest])
            largest = r;

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    void print() {
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
}
public class MaxHeap {
    public static void main(String[] args){
        Heap2 h2= new Heap2(10);

        h2.insert(12);
        h2.insert(34);
        h2.insert(21);
        h2.insert(56);
        h2.insert(30);

        h2.print();

        System.out.println("Max Heap:"+h2.extractMax());
        h2.print();
    }
}

