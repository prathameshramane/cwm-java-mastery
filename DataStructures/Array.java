package MyJava.DataStructures;
public class Array {
    private int[] items;
    private int count=0;

    public Array(int arraySize){
        items = new int[arraySize];
    }

    public void insert(int item){

        if(count == items.length){
            int[] tempArray = new int[count * 2];
            for(int i=0; i<count; i++){
                tempArray[i] = items[i];
            }
            items=tempArray;
        }

        items[count++] = item;
    }

    public void removeAt(int index){
        if(index<0 || index>=count)
            throw new IllegalArgumentException();
        for(int i=index; i<count-1; i++)
            items[i] = items[i+1];
        count--;
    }

    public int indexOf(int item){
        for(int i=0; i<count; i++)
            if(items[i] == item)
                return i;
        return -1;
    }

    public void print(){
        for(int i=0; i<count; i++)
            System.out.print(items[i] + " ");
    }
}
