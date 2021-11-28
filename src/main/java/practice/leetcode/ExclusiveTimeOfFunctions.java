/*
 * Author: Kartik Gola
 * Date: 11/28/21, 1:40 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

    private class FunctionCall {
        int id;
        boolean isStart;
        int timestamp;
        int subTime;
        FunctionCall(String str) {
            String[] split = str.split(":");
            this.id = Integer.parseInt(split[0]);
            this.isStart = split[1].equals("start");
            this.timestamp = Integer.parseInt(split[2]);
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<FunctionCall> stack = new Stack<>();
        int[] ans = new int[n];
        for (String log: logs) {
            FunctionCall curr = new FunctionCall(log);
            if (curr.isStart) {
                stack.push(curr);
            } else {
                // top ID will always match the current ID, so it is safe to pop()
                FunctionCall pop = stack.pop();
                int currTime = curr.timestamp - pop.timestamp + 1;

                // need to subtract time taken by sub function calls
                ans[pop.id] += currTime - pop.subTime;

                // if current function has a valid parent, add currTime to parent's subTime
                if (!stack.isEmpty()) {
                    stack.peek().subTime += currTime;
                }
            }
        }
        return ans;
    }
}
