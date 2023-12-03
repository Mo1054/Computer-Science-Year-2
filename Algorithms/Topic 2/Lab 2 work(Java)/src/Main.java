public class Main {
    public static void main(String[] args) {

        int n = 100;
        int arr [][] = new int[n][n];
        int arr2[][] = new int[n][n];


        for(int i = 0; i < n; i++){

            for(int j = 0; j < n; j++){

                arr[i][j] = i+j;
                arr2[i][j] = i * j;
            }

        }

        System.out.println(ALG3(arr, n));
        System.out.println(ALG4(arr, arr2, n));

    }



    public static int ALG3(int[][] A, int N){

        if(N==0){
            return 0;
        }
        return A[N-1][N-1] + ALG3(A, N - 1);

    }



    public static int ALG4(int[][] A, int[][] B, int N){

        if(N==0){
            return 0;
        }
        return A[N-1][N-1] + B[N-1][N-1] + ALG4(A,B,N-1);

    }
}