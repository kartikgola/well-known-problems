/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

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

    /*
    // 2-stacks solution
    private Stack<String> history = new Stack<>();
    private Stack<String> fwd = new Stack<>();

    public BrowserHistory(String homepage) {
        history.push(homepage);
    }

    public void visit(String url) {
        history.push(url);
        fwd.clear();
    }

    public String back(int steps) {
        steps = Math.min(history.size()-1, steps);
        while (steps-- > 0)
            fwd.push(history.pop());
        return history.peek();
    }

    public String forward(int steps) {
        steps = Math.min(fwd.size(), steps);
        while (steps-- > 0)
            history.push(fwd.pop());
        return history.peek();
    }
    */
}
