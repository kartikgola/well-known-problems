/*
 * Author: Kartik Gola
 * Date: 6/11/21, 12:16 AM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPositiveIntegerSolutionForGivenEquation {

    private static class CustomFunction {
        // dummy monotonically increasing function
        int f(int x, int y) {
            return x+y;
        }
    }

    public List<List<Integer>> findSolution(CustomFunction cf, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int x = 1, y = z; x <= z && y > 0;) {
            final int v = cf.f(x, y);
            if (v == z)
                ans.add(Arrays.asList(x++, y--));
            else if (v < z)
                x++;
            else
                y--;
        }
        return ans;
    }
}
