/*
 * Author: Kartik Gola
 * Date: 10/4/21, 9:59 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package numbertheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrialDivision {

    public List<Integer> solve(int n) {
        if (n <= 1)
            return Collections.emptyList();
        List<Integer> factors = new ArrayList<>();
        int f = 2;
        while (n % f == 0) {
            factors.add(f);
            n /= f;
        }
        f = 3;
        while (f*f <= n) {
            if (n % f == 0) {
                factors.add(f);
                n /= f;
            } else {
                f += 2;
            }
        }
        if (n != 1)
            factors.add(n);
        return factors;
    }

    public static void main(String[] args) {
        System.out.println(new TrialDivision().solve(20));
    }
}
