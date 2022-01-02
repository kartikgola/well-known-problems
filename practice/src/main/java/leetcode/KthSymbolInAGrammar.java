/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
