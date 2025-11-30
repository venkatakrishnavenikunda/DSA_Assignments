package Assignment_2;

import java.util.PriorityQueue;

public class ConnectRopesMinCost {

    public static int minCost(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // Min Heap

        // Add all ropes to Min Heap
        for (int r : ropes) {
            pq.add(r);
        }

        int totalCost = 0;

        // Connect until only 1 rope is left
        while (pq.size() > 1) {
            int first = pq.poll();   // smallest rope
            int second = pq.poll();  // second smallest rope

            int cost = first + second;
            totalCost += cost;

            pq.add(cost); // push back the combined rope
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};

        System.out.println("Minimum cost to connect ropes = " + minCost(ropes));
    }
}
