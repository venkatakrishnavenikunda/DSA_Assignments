package Assignment_2;

public class HeapSort {

    // Heapify function - Max Heap
    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check left child
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Check right child
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Heap Sort function
    static void heapSort(int[] arr) {
        int n = arr.length;

        // STEP 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // STEP 2: One by one extract max from heap
        for (int i = n - 1; i >= 0; i--) {

            // Move root (max) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    // Print array
    static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 6, 1, 8};

        System.out.println("Original Array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
