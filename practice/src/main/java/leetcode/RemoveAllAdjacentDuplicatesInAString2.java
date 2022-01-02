/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInAString2 {

    class Item {
        char val;
        int count;
        Item(char val, int count) {
            this.val = val;
            this.count = count;
        }
        public String toString() {
            return "(" + val + ", " + count + ")";
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Item> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(new Item(ch, 1));
            } else {
                Item peek = stack.peek();
                if (peek.val == ch) {
                    peek.count++;
                } else {
                    stack.push(new Item(ch, 1));
                }
            }
            if (!stack.isEmpty() && stack.peek().count == k)
                stack.pop();
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            Item pop = stack.pop();
            ans.append((""+pop.val).repeat(pop.count));
        }

        return ans.reverse().toString();
    }
}
