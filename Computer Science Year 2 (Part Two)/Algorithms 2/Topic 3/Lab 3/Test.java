import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String args[])  //static method
    {

        List<Integer> numbers = new ArrayList<>();

        int[] array = {49, 47, 23, 26, 28, 25, 79, 88};

        for (int i : array) {
            numbers.add(i);
        }


        Heap heap = new Heap(numbers);
        heap.buildMaxHeap();
//        heap.extractMax();

        System.out.println(heap.array);

    }
}
