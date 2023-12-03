import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashTable hash = new HashTable(31,37,50);

        for(int i = 0; i < 30; i++){

            hash.insert(i);
        }

        System.out.println(hash.loadFactor());
        System.out.println(Arrays.toString(hash.buckets));

    }
}