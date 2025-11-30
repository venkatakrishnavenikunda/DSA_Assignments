package Assignment_2;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInStreams {

    // Max Heap for smaller half
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());

    // Min Heap for larger half
    PriorityQueue<Integer> right = new PriorityQueue<>();

    // Insert number into stream
    public void addNum(int num) {
        // Step 1: Add to max heap
        if (left.isEmpty() || num <= left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }

        // Step 2: Balance heaps (size difference <= 1)
        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        } else if (right.size() > left.size()) {
            left.add(right.poll());
        }
    }

    // Step 3: Get current median
    public double getMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }
        return left.peek(); // left is always bigger or equal
    }

    public static void main(String[] args) {
        MedianInStreams ms = new MedianInStreams();

        int[] stream = {5, 15, 1, 3};

        for (int num : stream) {
            ms.addNum(num);
            System.out.println("Inserted: " + num + ", Current Median: " + ms.getMedian());
        }
    }
}