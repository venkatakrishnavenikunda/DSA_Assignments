package Assignment_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;


public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency using HashMap
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap to store top k elements
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int key : freq.keySet()) {
            pq.add(new int[]{key, freq.get(key)});  // store {number, frequency}

            if (pq.size() > k)
                pq.poll();  // remove least frequent
        }

        // Step 3: extract the result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0]; // only number
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] ans = topKFrequent(arr, k);

        System.out.println("Top " + k + " Frequent Elements:");
        System.out.println(Arrays.toString(ans));
    }
}
