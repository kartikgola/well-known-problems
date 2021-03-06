/*
 * Author: Kartik Gola
 * Date: 05/12/2020, 12:01
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL:
 */

package leetcode;

public class KthSymbolInAGrammar {

    public int kthGrammar(int N, int K) {
        if (N == 1)
            return 0;
        // If K is odd, output is kthGrammar(N-1, ceil(K/2))
        if (K % 2 != 0)
            return kthGrammar(N - 1, (int)Math.ceil(K / 2.0));
        // Otherwise, output is ~kthGrammar(N-1, ceil(K/2))
        return kthGrammar(N - 1, (int)Math.ceil(K / 2.0)) == 0 ? 1 : 0;
    }
}
