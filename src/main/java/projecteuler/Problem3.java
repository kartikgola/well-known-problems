/*
 * Author: Kartik Gola
 * Date: 28/02/2021, 19:09
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: 
 */

package projecteuler;

import util.MathUtils;

import java.util.Map;

public class Problem3 {

    public Map<Long, Long> solve() {
        return MathUtils.primeFactors(600851475143L);
    }
}
