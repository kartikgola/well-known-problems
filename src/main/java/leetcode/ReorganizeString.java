package leetcode;

import java.util.Arrays;

public class ReorganizeString {

    public String reorganizeString(String S) {
        if ( S.length() <= 1 )
            return S;

        char[] sArr = S.toCharArray();
        Arrays.sort(sArr);
        final int n = S.length();
        int i = -1, j = 0;
        // a a b b c c
        // a b a b c c
        // a a a b b b c c c
        // a b a a b b c c c
        while ( i < n && j < n ) {
            ++i; ++j;
            // Find the problematic char
            while ( j < n && sArr[i] != sArr[j] ) { ++i; ++j; }
            if ( j >= n || sArr[i] != sArr[j] )
                break;
            // Find the char which will swap with this problematic chara
            int k = j + 1;
            while ( k < n && sArr[k] == sArr[j] ) ++k;

            // a b a a
            if ( k < n && sArr[j] != sArr[k] ) {
                char t = sArr[j];
                sArr[j] = sArr[k];
                sArr[k] = t;
            } else
                return "";
        }

        return new String(sArr);
    }

}
