import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Heap {
    // public for JUnit testing purposes
    public ArrayList<Integer> array;
    public int heap_size;

    public Heap(int size) {
        array = new ArrayList<Integer>(size);
        heap_size = 0;
    }
    public Heap(List<Integer> source) {
        this(source, false);
    }
    public Heap(List<Integer> source, boolean incremental) {
        if (incremental) {
            array = new ArrayList<Integer>(source.size());
            heap_size = 0;
            for (int i = 0; i < source.size(); i++) {
                insert(source.get(i));
            }
        } else {
            array = new ArrayList<Integer>(source);
            heap_size = array.size();
            buildMaxHeap();
        }

    }

    public static int parent(int index) {
        return (index - 1) / 2;
    }
    public static int left(int index) {
        return 2 * index + 1;
    }
    public static int right(int index) {
        return 2 * index + 2;
    }
    
    public void maxHeapify(int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);

        if (l < heap_size && array.get(l) > array.get(largest)) {
            largest = l;
        }

        if (r < heap_size && array.get(r) > array.get(largest)) {
            largest = r;
        }

        if (largest != i) {
            int temp = array.get(i);
            array.set(i, array.get(largest));
            array.set(largest, temp);
            maxHeapify(largest);
        }
    }
    public void buildMaxHeap() {
        int n = heap_size;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }
    public void insert(Integer k) {
        heap_size++;
        int i = heap_size - 1;
        array.add(k);

        while (i > 0 && array.get(parent(i)) < array.get(i)) {
            int temp = array.get(i);
            array.set(i, array.get(parent(i)));
            array.set(parent(i), temp);
            i = parent(i);
        }
    }
    public Integer maximum() {
        if (heap_size < 1) {
            return null;
        }
        return array.get(0);
    }
    public Integer extractMax() {
        if (heap_size < 1) {
            return null;
        }
        int max = array.get(0);
        array.set(0, array.get(heap_size - 1));
        array.remove(heap_size - 1);
        heap_size--;
        maxHeapify(0);
        return max;
    }


    public ArrayList<Integer> sort() {

        // Build the max-heap
        buildMaxHeap();

        // Create a new list to store the sorted elements
        ArrayList<Integer> sortedList = new ArrayList<Integer>(array.size());

        // Extract the maximum element from the heap and add it to the sorted list
        while (heap_size > 0) {
            int max = extractMax();
            sortedList.add(max);
        }

        // Reverse the order of the sorted list to get the ascending order
        Collections.reverse(sortedList);

        // Return the sorted list
        return sortedList;

    }
}
