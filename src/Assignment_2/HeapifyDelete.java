package Assignment_2;


public class HeapifyDelete {
    int[] heap;
    int size;

    HeapifyDelete(int[] arr) {
        this.heap = arr;
        this.size = arr.length;


        for (int i = size / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    // Delete root using Heapify Down
    int deleteRoot() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return Integer.MIN_VALUE;
        }

        int root = heap[0];


        heap[0] = heap[size - 1];
        size--;


        heapifyDown(0);

        return root;
    }

    // Heapify Down (Sink Down)
    void heapifyDown(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l] < heap[smallest])
            smallest = l;

        if (r < size && heap[r] < heap[smallest])
            smallest = r;

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
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
        int[] arr = {5, 15, 30, 20};

        HeapifyDelete h = new HeapifyDelete(arr);
        System.out.println("Deleted root = " + h.deleteRoot());
        h.printHeap();
    }
}
