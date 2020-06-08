package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JNext {

    private int[] getArrayInput(final BufferedReader reader, int n) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int[] arr = new int[n];
        int i = 0;
        while ( tokenizer.hasMoreTokens() ) {
            arr[i++] = Integer.parseInt(tokenizer.nextToken());
        }
        return arr;
    }

    private String getNumFromArray(int[] A) {
        StringBuilder builder = new StringBuilder();
        for ( int num : A ) {
            builder.append(num);
        }
        return builder.toString();
    }

    private void swapElements(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private void reverseArray(int[] A, int i, int j) {
        for ( int start = i, end = j; start < end; start++, end--) {
            this.swapElements(A, start, end);
        }
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            int n = Integer.parseInt(reader.readLine());
            int[] A = this.getArrayInput(reader, n);

            int i = n - 1;
            while ( i >= 1 && A[i - 1] >= A[i] )
                --i;

            if ( i <= 0 )
                System.out.println(-1);
            else {
                int j = n - 1;
                while ( j > i - 1 && A[j] <= A[i - 1] )
                    --j;
                this.swapElements(A, i - 1, j);
                this.reverseArray(A, i, n - 1);
                System.out.println(getNumFromArray(A));
            }
        }
    }
}
