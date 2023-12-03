import java.util.Arrays;

public class HashTable{
    // public for testing purposes
    public int buckets[];

    long a;
    long c;
    long m;
    //hash(x) = (ax + c)  % m
    public HashTable(long _a, long _c, long _m) {
        this.a = _a;
        this.c = _c;
        this.m = _m;
        buckets = new int[(int)_m];

    }
    public long hash(int key){
        long hash = 0;
        hash = ((a * key) + c) % m;
        return hash;
    }

    public void insert(int key) {
        int i = (int)hash(key);

        while(i < buckets.length && buckets[i] != 0){
            i++;
        }
        if(i >= buckets.length){
            extend();
        }
        buckets[i] = key;
    }
    public boolean find(int key) {
        for(int i=0; i < buckets.length; i++){
            if (buckets[i] == key){
                return true;
            }
        }

        return false;
    }
    public double loadFactor() {
        int numBuckets = buckets.length;
        int numOccupiedBuckets = 0;
        for (int i = 0; i < numBuckets; i++) {
            if (buckets[i] != 0) {
                numOccupiedBuckets++;
            }
        }
        return (float) numOccupiedBuckets / numBuckets;
    }
    public void remove(int key){
        for(int i=0; i < buckets.length; i++){
            if (buckets[i] == key){
                break;
            }
        }


    }

    private void extend() {

        int lenNew = buckets.length * 2;
        int storageNew [] = new int[lenNew];
        for (int j = 0; j < buckets.length; j++ ){
            storageNew[j] = buckets[j];
        }
        buckets = storageNew;

    }
}