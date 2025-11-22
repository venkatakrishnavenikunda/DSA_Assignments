package StackImplementations;

class Stack{
    int arrsize=10;
    int index=0;
    Object[] arr=new Object[arrsize];

    //Add elements into the stack
    public void push(Object ele){
        if(index>arr.length) increase();
        arr[index]=ele;
        index++;
    }

    //To increase the array size
    public void increase(){
        Object[] temp=new Object[((arr.length*3)/2)+1];
        for(int i=0; i<arr.length;i++){
            temp[i]=arr[i];
        }
        arr=temp;
    }

    //To find the size of the stack
    public int size(){
        return index;
    }

    //To check the stack is empty or not
    public boolean isEmpty(){
        return index==0;
    }

    //To display the last added element in the stack
    public Object peek(){
        if(index==0) throw new ArrayIndexOutOfBoundsException();
        int s=size()-1;
        return arr[s];

    }
    //Display the elements from the stack
    public void display(){
        if(index==0)
            System.out.println("Stack is empty");
        for(int i=0; i< size();i++){
            System.out.println(arr[i]);
        }
    }

    //Pop(Deleting the last added element and display that element)
    public Object pop(){
        int s=size()-1;
        Object temp=arr[s];
        arr[s]=null;
        index--;
        return temp;
    }
}

public class StackUsingArray {
    public static void main(String[] args){
        Stack s=new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.display();
        System.out.println("Peek element:"+s.peek());
        System.out.println("Pop element:"+s.pop());
        s.display();
        System.out.println("Size of the stack:"+s.size());
    }
}