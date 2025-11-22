package QueueImplementations;
class EmptyQueueException extends RuntimeException{}
class QueueImp{
    Object[] arr=new Object[10];
    int index=0;

    //Inserting elements
    public void add(Object ele){
        if(index>arr.length) increase();
        arr[index]=ele;
        index++;
    }

    //To increase the size of the array
    public void increase(){
        Object[] temp=new Object[((arr.length*3)/2)+1];
        for(int i=0; i<arr.length;i++){
            temp[i]=arr[i];
        }
        arr=temp;
    }

    //To find the size of the queue
    public int size(){
        return index;
    }

    //peek()
    public Object peek(){
        if(index==0) throw new EmptyQueueException();
        return arr[0];
    }

    //Poll()
    public Object poll(){
        Object temp=arr[0];
        for(int i=0; i<size();i++){
            arr[i]=arr[i+1];
        }
        arr[index-1]=null;
        index--;
        return temp;
    }

    //To display the queue implementation
    public void display(){
        if(index==0)
            System.out.println("Queue is empty");
        System.out.println("Queue elements:");
        for(int i=0; i<size();i++)
            System.out.println(arr[i]);

    }
}
public class QueueUsingArray {
    public static void main(String[] args){
        QueueImp q=new QueueImp();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.display();
        System.out.println("Peek element:"+q.peek());
        System.out.println("Size of the queue:"+q.size());
        System.out.println("Poll element:"+q.poll());
        q.display();
    }
}
