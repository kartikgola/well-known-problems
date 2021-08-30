/*
 * Author: Kartik Gola
 * Date: 8/30/21, 4:03 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.Pair;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int wdLen = 0;
        int len = 0;
        List<Pair<List<String>, Integer>> lines = new ArrayList<>();
        List<String> line = new ArrayList<>();

        for (int i = 0; i < words.length;) {
            if (!line.isEmpty() && 1+len+words[i].length() > maxWidth) {
                lines.add(new Pair<>(line, wdLen));
                line = new ArrayList<>();
                len = 0;
                wdLen = 0;
            } else {
                if (line.isEmpty())
                    len = words[i].length();
                else
                    len += 1+words[i].length();
                wdLen += words[i].length();
                line.add(words[i++]);
            }
        }

        if (!line.isEmpty())
            lines.add(new Pair<>(line, wdLen));

        for (int i = 0; i < lines.size(); ++i) {
            List<String> ln = lines.get(i).getKey();
            int totalLen = lines.get(i).getValue();
            if (i == lines.size()-1) {
                for (String wd: line) {
                    if (sb.length() == 0)
                        sb.append(wd);
                    else sb.append(" " + wd);
                }
                sb.append(" ".repeat(maxWidth-sb.length()));
            } else {
                int spaces = ln.size() == 1 ? 1 : ln.size()-1;
                int spaceLen = spaces > 0 ? (maxWidth - totalLen) / spaces : 0;
                int mod = spaces > 0 ? (maxWidth - totalLen) % spaces : 0;
                for (String wd: ln) {
                    sb.append(wd);
                    if (spaces-- > 0)
                        sb.append(" ".repeat(spaceLen + (mod-- > 0 ? 1 : 0)));
                }
            }
            ans.add(sb.toString());
            sb = new StringBuilder();
        }

        return ans;
    }
}
