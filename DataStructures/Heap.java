package MyJava.DataStructures;

class Heap {
    private int[] a;
    private int elements_count = -1;

    public Heap(int size) {
        this.a = new int[size];
    }

    public void insert(int value) {
        a[++elements_count] = value;
        bubbleUp();
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        int value = a[0];
        a[0] = a[elements_count--];
        bubbleDown();

        return value;
    }

    public int max() {
        if(isEmpty())
            throw new IllegalStateException();
        
        return a[0];
    }

    private void bubbleUp() {
        int index = elements_count;

        while (hasParent(index) && a[index] > parent(index)) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void bubbleDown() {
        int index = 0;
        while (!isValidParent(index)) {
            int Lindex = largerIndex(index);
            swap(index, Lindex);
            index = Lindex;
        }
    }

    private void swap(int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    private int largerIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index){
        if(!hasLeftChild(index))
            return true;

        boolean isValid = a[index] > leftChild(index);
        if(!hasRightChild(index))
            return isValid;
        
        return isValid && a[index] > rightChild(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= elements_count;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= elements_count;
    }

    private boolean hasParent(int index) {
        return index != 0;
    }

    private int parent(int index) {
        return a[parentIndex(index)];
    }

    private int leftChild(int index) {
        return a[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return a[rightChildIndex(index)];
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private boolean isEmpty() {
        return elements_count == -1;
    }
}