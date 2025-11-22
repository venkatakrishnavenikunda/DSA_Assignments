import java.util.Deque;
import java.util.ArrayDeque;


public class DequeImp {
    public static void main(String[] args) {

        Deque<Integer> dq = new ArrayDeque<>();

        // Insert elements
        dq.addFirst(10);   // [10]
        dq.addLast(20);    // [10, 20]
        dq.addLast(30);    // [10, 20, 30]
        dq.addFirst(5);    // [5, 10, 20, 30]

        System.out.println("Deque: " + dq);

        // Peek operations
        System.out.println("Peek First: " + dq.peekFirst()); // 5
        System.out.println("Peek Last: " + dq.peekLast());   // 30

        // Remove operations
        System.out.println("Removed First: " + dq.removeFirst()); // removes 5
        System.out.println("Removed Last: " + dq.removeLast());   // removes 30

        System.out.println("Deque after removals: " + dq);

        // Size check
        System.out.println("Size: " + dq.size());
    }
}
