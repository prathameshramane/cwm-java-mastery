package MyJava.DataStructures;

public class PriorityQueue {
    private int[] items;
    private int front=0;
    private int back=0;
    private int count=0;

    public PriorityQueue(int size){
        items = new int[size];
    }

    public void add(int value){
        if(isFull())
            throw new IllegalStateException();
        if(isEmpty())
            items[back++]=value;
        else{
            insertionSort(value);
            back++;
        }
        count++;
    }

    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();
        count--;
        return items[front++];
    }

    public boolean isFull(){
        return count==items.length;
    }

    public boolean isEmpty(){
        return count==0;
    }

    private void insertionSort(int value){
        for(int i=back-1; i>=0; i--){
            if(items[i]>value){
                items[i+1]=items[i];
                if(i==0)
                    items[i] = value;
            }
            else{
                items[i+1] = value;
                break;
            }
        }
    }
}
