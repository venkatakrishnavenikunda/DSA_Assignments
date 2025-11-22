//Queue using LinkedList
package QueueImplementations;
class Node{
    Object data;
    Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class QueueImpl{
    Node head;
    Node tail;
    int count;

    //Adding elements to the queue
    public void add(Object data){
        //Node n=new Node(data,null);
        if(head==null){
            head=new Node(data,null);
            count++;
            tail=head;
            return;
        }
        tail.next=new Node(data,null);
        count++;
        tail=tail.next;
    }

    //size of the queue
    public int size(){
        return count;
    }

    //To check queue is empty or not
    public boolean isEmpty(){
        return count==0;
    }

    //peek()
    public Object peek(){
        if(head==null) throw new EmptyQueueException();
        return head.data;
    }

    //poll()
    public Object poll(){
        if(head==null) throw new EmptyQueueException();
        Object key=head.data;
        head=head.next;
        count--;
        return key;
    }

    //Displaying the queue elements
    public void  display(){
        Node curr=head;
        if(curr==null) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue elements:");
        while(curr!=null){
            System.out.print(curr.data);
            curr=curr.next;
            System.out.println();
        }
    }
}
public class QueueUsingLinkedList {
    public static void main(String[] args){
        QueueImpl q=new QueueImpl();
        q.add(100);
        q.add(200);
        q.add(300);
        q.add(400);
        q.add(500);
        q.display();
        System.out.println("Size of the queue:"+q.size());
        System.out.println("Peek element:"+q.peek());
        System.out.println("Poll element:"+q.poll());
        q.display();
    }

}
