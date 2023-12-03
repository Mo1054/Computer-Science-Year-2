import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] N = {9,8,7,6};
        System.out.println(Arrays.toString(HybridSort(N)));

    }


    public static int []  HybridSort(int [] A){

        int n = A.length;
        int minIndex = 0;
            for(int i = 0; i < n-1; i++){


                for(int j = 0; j < n-1; j++){

                    System.out.println(Arrays.toString(A));


                    if(A[j] > A[j+1]){

                        Swap(A, j, j+1);
                    }

                    if(A[j] <A[minIndex]){

                        minIndex = j;
                    }

                }


                if(A[i] > A[i+1]){

                    Swap(A, i, i+1);
                    n--;
                }

            }


        return A;
    }

    public static void Swap(int A [], int a, int b){

        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }



}



