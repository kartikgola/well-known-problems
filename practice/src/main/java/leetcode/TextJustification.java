/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import util.Pair;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> al = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int len = 0;
        for (String word: words) {
            if (len + word.length() > maxWidth) {
                al.add(temp);
                temp = new ArrayList<>();
                temp.add(word);
                len = word.length() + 1;
            } else {
                len += word.length() + 1;
                temp.add(word);
            }
        }

        if (!temp.isEmpty())
            al.add(temp);

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < al.size(); ++i) {
            StringBuilder sb = new StringBuilder();
            int chars = al.get(i).stream().mapToInt(String::length).sum();
            int numWords = al.get(i).size();
            int space = maxWidth - chars;

            if (numWords == 1 || i == al.size()-1) {
                for (String word: al.get(i)) {
                    sb.append(word);
                    if (sb.length()+1 <= maxWidth)
                        sb.append(" ");
                }
                sb.append(" ".repeat(maxWidth - sb.length()));
            } else {
                // Example,
                // space=5, numWords=4
                // spaceBetween = 5/3 = 1
                // extra=2
                // a--b--c-d
                int spaceBetween = space / (numWords-1);
                int extra = space % (numWords-1);

                for (String word: al.get(i)) {
                    sb.append(word);
                    if (sb.length()+spaceBetween <= maxWidth) {
                        sb.append(" ".repeat(spaceBetween));
                        if (extra > 0) {
                            sb.append(" ");
                            extra--;
                        }
                    }
                }
            }
            ans.add(sb.toString());
        }

        return ans;
    }
}
