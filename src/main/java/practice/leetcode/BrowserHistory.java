/*
 * Author: Kartik Gola
 * Date: 12/19/21, 4:14 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {

    private List<String> history = new ArrayList<>();
    // denotes current URL index
    private int curr = -1;
    // denotes the end of history list (exclusive)
    private int len = 0;

    public BrowserHistory(String homepage) {
        history.add(homepage);
        curr = 0;
        len = 1;
    }

    public void visit(String url) {
        if (history.size() > curr+1) {
            history.set(curr+1, url);
        } else {
            history.add(url);
        }
        // On every visit, we simulate removal of all elements after visiting url, by limiting len to curr+1
        curr++;
        len = curr+1;
    }

    public String back(int steps) {
        curr = Math.max(0, curr-steps);
        return history.get(curr);
    }

    public String forward(int steps) {
        curr = Math.min(len-1, curr+steps);
        return history.get(curr);
    }
}
