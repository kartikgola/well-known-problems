package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public boolean isPalindrome(String str) {
        int p = 0, q = str.length() - 1;
        while ( p <= q ) {
            if ( str.charAt(p) == str.charAt(q) ) {
                p++;
                q--;
            } else return false;
        }
        return true;
    }

    private List<List<String>> _part(String s, int p, int q) {
        List<List<String>> list = new ArrayList<>();

        String str = "";
        for ( int i = p; i < q; ++i ) {
            str = str + s.charAt(i);
            if ( isPalindrome(str) ) {
                for ( List<String> remainingParts : _part(s, i + 1, q) ) {
                    List<String> subList = new ArrayList<>();
                    subList.add(str);
                    subList.addAll(remainingParts);
                    list.add(subList);
                }
            }
        }

        if ( list.size() == 0 ) {
            list.add(new ArrayList<>());
        }
        return list;
    }

    public List<List<String>> partition(String s) {
        return _part(s, 0, s.length());
    }

}
