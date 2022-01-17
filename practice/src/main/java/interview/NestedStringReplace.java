/*
 * Author: Kartik Gola
 * Date: 1/17/22, 3:07 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package interview;

import java.util.Map;
import java.util.Stack;

public class NestedStringReplace {

    public static String f(String s, Map<String, String> map) {
        Stack<String> stack = new Stack<>();
        Map<String, String> o2c = Map.of("(", ")", "{", "}", "[", "]");
        Map<String, String> c2o = Map.of(")", "(", "}", "{", "]", "[");
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            String curr = s.substring(i,i+1);
            if (!stack.isEmpty() || o2c.containsKey(curr)) {
                if (c2o.containsKey(curr)) {
                    StringBuilder temp = new StringBuilder();
                    String open = c2o.get(curr);
                    while (!stack.peek().equals(open)) {
                        temp.append(stack.pop());
                    }
                    stack.pop();

                    String rev = temp.reverse().toString();
                    if (!rev.isEmpty()) {
                        if (!map.containsKey(rev))
                            return "-1";

                        String replace = map.get(rev);
                        if (!stack.isEmpty())
                            stack.push(replace);
                        else
                            ans.append(replace);
                    }
                } else stack.push(curr);
            } else ans.append(curr);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(f("This is {a[b(c)]} place", Map.of("c", "x", "bx", "y", "ay", "z")));
        System.out.println(f("This is {a[b()]} place", Map.of("c", "x", "b", "y", "ay", "z")));
        System.out.println(f("This is {[{()}]} place", Map.of("c", "x", "b", "y", "ay", "z")));
    }
}
