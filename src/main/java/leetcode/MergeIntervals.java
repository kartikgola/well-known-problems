package leetcode;

import java.util.Arrays;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        final int n = intervals.length;
        if ( n == 0 )
            return new int[][]{};

        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if ( a[0] - b[0] != 0 ) return a[0] - b[0];
            else return a[1] - b[1];
        });

        int write = 0;
        for ( int cmp = 0, read = 1; read < n; ++read ) {
            if ( intervals[ cmp ][1] >= intervals[ read ][0] ) {
                intervals[ cmp ][1] = Math.max(intervals[ cmp ][1], intervals[ read ][1]);
            } else {
                intervals[ ++write ] = intervals[ read ];
                cmp = read;
            }
        }

        int[][] res = new int[write + 1][2];
        for ( int i = 0; i < write + 1; ++i )
            res[i] = intervals[i];

        return res;
    }

}
