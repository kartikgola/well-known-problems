/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RabinKarpStringMatching {

    // Basic algorithm to calculate the hash of a string
    private long hash(String s) {
        // hash = (s[0] + s[1].p + s[2].p^2 + .. + s[n-1].p^n-1) % m
        long hash = 0;

        // if s is only english lowercase(26), p=31 is a good choice
        // is s is english lowercase+uppercase(52), p=53 is a good choice and so on
        final long p = 31;

        // m should be sufficiently large prime
        final long m = (long)1e9 + 9;

        long pow = 1;
        for (char ch: s.toCharArray()) {
            hash = (hash + (ch-'a'+1) * pow) % m;
            pow = (p * pow) % m;
        }
        return hash;
    }


    // Rabin-Karp algorithm for pattern matching O(max(len(text), len(pattern))
    public List<Integer> findMatches(String text, String pattern) {
        if (text.isEmpty())
            return Collections.emptyList();
        if (pattern.isEmpty())
            return IntStream.range(0, text.length()).boxed().collect(Collectors.toList());

        final long p = 31;
        final long m = (long)1e9 + 9;

        // pre-compute powers of p
        // pow[i] = p^i
        long[] pow = new long[Math.max(text.length(), pattern.length())];
        pow[0] = 1;
        for (int i = 1; i < pow.length; ++i)
            pow[i] = (pow[i-1] * p) % m;

        // calculate hash of all the prefixes of text
        // hash of empty prefix string is tHash[0]
        long[] tHash = new long[text.length()+1];
        for (int i = 1; i <= text.length(); ++i)
            tHash[i] = (tHash[i-1] + (text.charAt(i-1)-'a'+1) * pow[i-1]) % m;

        // calculate pattern hash
        long pHash = 0;
        for (int i = 0; i < pattern.length(); ++i)
            pHash = (pHash + (pattern.charAt(i)-'a'+1) * pow[i]) % m;

        // iterate over text and compare the hashes of substring text[i+len(pattern)] and pattern
        // while comparing, pHash needs to be multiplied by pow[i] to have same powers as substring of text
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i+pattern.length()-1 < text.length(); ++i) {
            long currHash = (tHash[i+pattern.length()] + m - tHash[i]) % m;
            if (currHash == pHash * pow[i] % m)
                ans.add(i);
        }

        return ans;
    }
}
