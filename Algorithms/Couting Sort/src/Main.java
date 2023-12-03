import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int P [] = {1,4,2,8};
       int Arr [] = Counting(P, 8);

        System.out.println(Arrays.toString(Arr));
    }


    public static int [] Counting(int A [], int k){


        int C [] = new int [k+1];
        int R [] = new int [A.length];
        int pos = 0;
        int counter = 0;

        for(int j = 0; j < A.length; j ++){

            C[A[j]] = C[A[j]] + 1;
        }

        for(int i = 0; i < k+1; i++) {

            int r;
            for (r = pos; r < pos + C[i]; r++) {

                R[r] = i;
            }

            pos = r;
        }

        return R;
    }
}