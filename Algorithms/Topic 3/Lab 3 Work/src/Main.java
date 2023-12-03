import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] N = {9,8,7,6};
        System.out.println(Arrays.toString(BubbleSort(N)));
        System.out.println(Arrays.toString(InsertionSort(N)));
        System.out.println(Arrays.toString(SelectionSort(N)));

    }


    public static int []  BubbleSort(int [] A){

        int n = A.length;
        boolean change = true;

        while(change){
//            System.out.println("Bubble sort OuterLoop " + Arrays.toString(A));
            change=false;
            for(int i = 0; i < n-1; i++){
                System.out.println("Bubble sort InnerLoop " + Arrays.toString(A));
                if(A[i] > A[i+1]){

                    Swap(A, i, i+1);
                    change = true;
                }

            }
            n = n -1;
        }


        return A;
    }

    public static void Swap(int A [], int a, int b){

        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static int [] InsertionSort(int A []){

        int n = A.length;

        for(int j = 1; j < n-1; j++){
//            System.out.println("Insertion sort OuterLoop " + Arrays.toString(A));

            int ins = A[j];
            int i = j - 1;
            while(i >= 0 && ins < A[i]){
//

                A[i+1] = A[i];

                i--;
            }

            A[i+1] = ins;
        }

        return A;
    }


    public static int [] SelectionSort(int A []){

        int n = A.length;
        for (int i = 0; i < n-1; i++)
        {
//            System.out.println("Selection sort InnerLoop " + Arrays.toString(A));
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (A[j] < A[min_idx])
                    min_idx = j;
                int temp = A[min_idx];
                A[min_idx] = A[i];
                A[i] = temp;
            }

        }


        return A;
    }

}