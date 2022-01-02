/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

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
