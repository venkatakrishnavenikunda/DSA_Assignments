package Assignment_2;
import java.util.PriorityQueue;

public class PriorityQueueEx {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        pq.add(10);
        pq.add(40);
        pq.add(5);
        pq.add(20);

        System.out.println("Max PQ: " + pq);

        System.out.println("Removing elements:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
