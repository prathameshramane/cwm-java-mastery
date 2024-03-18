package MyJava.DataStructures;

import java.util.LinkedList;
public class HashTable {
    private class Entry{
        private int key;
        private String value;
        public Entry(int key, String value){
            this.key=key;
            this.value=value;
        }

        @Override
        public String toString(){
            return "Node-" + value;
        }
    }
    private LinkedList<Entry>[] LL = new LinkedList[5];

    public void insert(int key, String value){
        var bucket = getOrCreateBucket(key);
        var entry = getEntry(bucket, key);
        if(entry!=null){
            entry.value=value;
        } else {
            bucket.addLast(new Entry(key, value));
        }
    }

    public void delete(int key){
        var bucket = getBucket(key);
        if(bucket==null)
            throw new IllegalStateException();
        
        var entry = getEntry(bucket, key);
        if(entry!=null){
            bucket.remove(entry);
            return;
        }

        throw new IllegalStateException();
    }

    public boolean contains(int key){
        var bucket=getBucket(key);
        return getEntry(bucket, key) != null;
    }

    public String getValue(int key){ 
        var bucket=getBucket(key); 
        var entry = getEntry(bucket, key); 
        return entry != null ? entry.value:null;
    }

    private LinkedList<Entry> getBucket(int key){
        return LL[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key){
        int hash = hash(key);
        if(LL[hash]==null){
            LL[hash] = new LinkedList<Entry>();
        }
        return LL[hash];
    }

    private Entry getEntry(LinkedList<Entry> bucket, int key){
        if(!isBucketNull(bucket)){
            for(var entry:bucket){
                if(entry.key==key)
                   return entry;
            }
        }
        
        return null;
    }

    private boolean isBucketNull(LinkedList<Entry> bucket){
        return bucket==null;
    }
    
    private int hash(int key){
        return key%LL.length;
    }
}
