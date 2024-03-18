package MyJava.DataStructures;

class Heapify {
    public static void heapify(int[] array) {
        // for(int i=0; i<array.length; i++)
        //     heapify(array, i);

        //Optimised Solution
        var lastParentIndex = array.length / 2 - 1;
        for(var i = lastParentIndex; i>=0; i--)
            heapify(array, i);
    }

    public static void heapify(int[] array, int index){
        var largerIndex = index;

        var leftChild = index*2 + 1;
        if(leftChild <  array.length && array[leftChild] > array[largerIndex])
            largerIndex = leftChild;
        
        var rightChild = index * 2 + 2;
        if(rightChild < array.length && array[rightChild] > array[largerIndex])
            largerIndex = rightChild;
        
        if(largerIndex == index)
            return;

        swap(array, largerIndex, index);
        heapify(array, largerIndex);
    }

    public static void swap(int[] array, int first, int second){
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int geKthLargest(int[] array, int k){
        if(k < 1 || k > array.length)
            throw new IllegalArgumentException();

        Heap heap = new Heap(array.length);

        for(var item : array)
            heap.insert(item);

        for(int i=0; i < k-1; i++)
            heap.remove();

        return heap.max();
    }
}