package leetcode;

import util.ArrayInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum2 {

    private List<List<Integer>> twoSumCount2(int[] A, int[] B, int target) {
        List<List<Integer>> list = new ArrayList<>();

        final int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = n - 1;
        while ( i < n && j > -1 ) {
            if ( A[i] + B[j] == target ) {
                while ( i < n - 1 && A[i] == A[i + 1] ) ++i;
                while ( j > 0 && B[j - 1] == B[j] ) --j;
                list.add(Arrays.asList(A[i], B[j]));
                ++i;
                --j;
            } else if ( A[i] + B[j] > target ) --j;
            else ++i;
        }

        return list;
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(reader.readLine());
        final int target = Integer.parseInt(reader.readLine());
        System.out.println(twoSumCount2(
                ArrayInput.readArray(reader, N),
                ArrayInput.readArray(reader, N),
                target
        ));
    }
}
