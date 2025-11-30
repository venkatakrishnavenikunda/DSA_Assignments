package Assignment_2;

import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallest {
    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 8, 11, 6, 26};
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            pq.add(num);

            if (pq.size() > k)
                pq.poll();
        }
        System.out.println(k + " Smallest elements: " + pq);
    }
}
