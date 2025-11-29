package Assignment_2;

class Heap{
    int[] heap;
    int size;
    int capacity;

    Heap(int capacity){
        this.capacity=capacity;
        this.heap=new int[capacity];
        this.size=0;
    }

    int parent(int i){
        return  (i-1)/2;
    }

    int left(int i){
        return 2*i+1;
    }

    int right(int i){
        return 2*i+2;
    }

    void insert(int val){
        if(size==capacity){
            System.out.println("Hap is full");
            return;
        }
        heap[size]=val;
        int i=size;
        size++;

        while(i!=0 && heap[parent(i)]>heap[i]) {
            swap(i,parent(i));
            i=parent(i);

        }
    }

    int extraMin(){
        if(size==0)
            return Integer.MAX_VALUE;

        int root=heap[0];
        heap[0]=heap[size-1];
        size--;
        heapifyDown(0);

        return root;
    }

    public void heapifyDown(int i){
        int smallest=i;
        int l=left(i);
        int r=right(i);

        if (l < size && heap[l] < heap[smallest]){
            smallest=l;
        }

        if(r<size && heap[r] < heap[smallest]){
            smallest=r;
        }

        if(smallest!=i){
            swap(i,smallest);
            heapifyDown(smallest);
        }
    }

    void swap(int x, int y){
        int temp=heap[x];
        heap[x]=heap[y];
        heap[y]=temp;
    }

    void print(){
        for (int i=0; i<size;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
}

public class MinHeap {
    public static void main(String[] args){
        Heap h=new Heap(10);

        h.insert(10);
        h.insert(49);
        h.insert(20);
        h.insert(5);
        h.insert(7);
        System.out.println("Min="+h.extraMin());
        h.print();

    }
}