import java.util.*;

public class HybridSort {
    public static void main(String[] args) {
        int[][] Testing = {
                {},
                {6, 2, 8, 5, 7, 5, 0, 2},
                {2,2,2,2,2,2,2,2},
                {4, -7, 2, 1, 0, 2, 4, 2, -3, 3, -3, 7, -2, 7, 7},
                {-2, -2, -4, -9, -1, -6, -1, -14, -3, -15, -12, -12, -2, -8, -9},
        };
        for (int[] Array: Testing) {

                System.out.println("Array Entered: " + Arrays.toString(Array));
                Array = HybridSorts(Array);
                System.out.println("The Array sorted: " + Arrays.toString(Array)+ "\n");

        }

    }

    public static int[] HybridSorts(int[] A) {
        int array = A.length;
        boolean sort = true;
        int checker = 0;

        if(array <= 0){
            return A;
        }

        while (sort) {
            sort = false;
            int min = checker;

            for(int j = 0; j < array-1; j++){
                if(A[j+1] < A[min] && j > checker){
                    min = j;
                }

                if (A[j] > A[j+1]){
                    int saved = A[j];
                    A[j] = A[j+1];
                    A[j+1] = saved;
                    sort = true;
                }
            }

            // Swapping the minium value
            int saved = A[checker];
            A[checker] = A[min];
            A[min] = saved;

            checker++;
            array--;
        }

        return A;
    }
}
