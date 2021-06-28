/*
 * Author: Kartik Gola
 * Date: 17/09/2020, 21:57
 * Copyright (c) 2020 | https://kartikgola.com
 */

package util;

import util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class StringUtils {

    /**
     * Checks if a string of length `n` can be evenly divided in `parts` partitions such that
     * each sub-string in all the string partitions are equal
     * @param str
     * @param parts
     * @return true if `str` can be divided into equal `parts` partitions
     */
    public static boolean isEqualInParts(String str, int parts) {
        if (Objects.isNull(str) || str.isEmpty() || parts < 0)
            return false;
        final int n = str.length();
        if ( n % parts == 0 ) {
            final int partsLength = n / parts;
            String prev = null;
            // O(parts * (2 * partsLength))
            for ( int begin = 0, end = partsLength; end <= str.length(); begin = end, end += partsLength ) {
                String part = str.substring(begin, begin + partsLength);
                if ( prev != null && !prev.equals(part) ) {
                    return false;
                }
                prev = part;
            }
            return true;
        }
        return false;
    }

    private static int[] findSuffixArray(String s) {
        s += "$";
        final int n = s.length();
        int[] order = new int[n];
        int[] equivClass = new int[n];
        {
            List<Pair<Character, Integer>> aux = new ArrayList<>(n);
            for (int i = 0; i < n; i++)
                aux.add(new Pair<>(s.charAt(i), i));
            aux.sort((p1, p2) -> p1.getKey() - p2.getKey() != 0 ? p1.getKey() - p2.getKey() : p1.getValue() - p2.getValue());

            for (int i = 0; i < n; i++)
                order[i] = aux.get(i).getValue();

            equivClass[order[0]] = 0;
            for (int i = 1; i < n; i++) {
                if (aux.get(i).getKey() == aux.get(i-1).getKey()) {
                    equivClass[order[i]] = equivClass[order[i-1]];
                } else {
                    equivClass[order[i]] = equivClass[order[i-1]] + 1;
                }
            }
        }
        int k = 0;
        while ((1 << k) < n) {
            int[][] aux = new int[n][3];
            for (int i = 0; i < n; i++)
                aux[i] = new int[]{equivClass[i], equivClass[(i + 1 << k) % n], i};
            Arrays.sort(aux, (a1, a2) -> {
                for (int i = 0; i < a1.length; i++)
                    if (a1[i] - a2[i] != 0)
                        return a1[i] - a2[i];
                return -1;
            });

            for (int i = 0; i < n; i++)
                order[i] = aux[i][2];
            equivClass[order[0]] = 0;

            for (int i = 1; i < n; i++) {
                if (aux[i][0] == aux[i-1][0] && aux[i][1] == aux[i-1][1]) {
                    equivClass[order[i]] = equivClass[order[i-1]];
                } else {
                    equivClass[order[i]] = equivClass[order[i-1]] + 1;
                }
            }

            k++;
        }

        return order;
    }

    /**
     * Generates suffix array of a given string 's$'
     * @param s
     * @return suffix array of string 's$'
     */
    public static int[] suffixArray(String s) {
        return findSuffixArray(s);
    }

    /**
     * Generates suffix list of a given string 's$'
     * @param s
     * @return suffix list of string 's$'
     */
    public static List<Integer> suffixList(String s) {
        return Arrays.stream(findSuffixArray(s)).boxed().collect(Collectors.toList());
    }

    /**
     * Generates suffix list of a given string 's$' along with every suffix substring
     * @param s
     * @return suffix indices list of string 's$' and the suffix itself
     */
    public static List<Pair<Integer, String>> suffixArrayWithStrings(String s) {
        List<Pair<Integer, String>> list = new ArrayList<>();
        int[] p = findSuffixArray(s);
        String temp = s + "$";
        for (int i : p)
            list.add(new Pair<>(i, temp.substring(i)));
        return list;
    }

    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length()-1);
    }

    public static boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; ++i, --j)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
