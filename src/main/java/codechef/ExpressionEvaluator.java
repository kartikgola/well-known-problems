/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionEvaluator {

    private final String OPERATORS = "+-*/^";

    private boolean hasLowerPriority(String op1, String op2) {
        return OPERATORS.indexOf(op1) < OPERATORS.indexOf(op2);
    }

    private ArrayList<String> toPostfix(ArrayList<String> infix) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> postfix = new ArrayList<>();
        for ( String elem : infix ) {
            if (OPERATORS.contains(elem)) {
                if (stack.empty())
                    stack.push(elem);
                else {
                    if ( OPERATORS.contains(stack.peek()) ) {
                        if ( hasLowerPriority(stack.peek(), elem) ) {
                            stack.push(elem);
                        } else {
                            while ( !stack.empty() && !hasLowerPriority(stack.peek(), elem) ) {
                                postfix.add( stack.pop() );
                            }
                            stack.push(elem);
                        }
                    } else {
                        stack.push(elem);
                    }
                }
            } else if (elem.equals("(")) {
                stack.push(elem);
            } else if (elem.equals(")")) {
                while (!stack.peek().equals("(")) {
                    postfix.add(stack.pop());
                }
                stack.pop();
            } else {
                postfix.add(elem);
            }
        }
        while ( !stack.empty() ) {
            postfix.add( stack.pop() );
        }
        return postfix;
    }

    private double evalPostfix(ArrayList<String> postfix) {
        Stack<Double> stack = new Stack<>();
        for ( String elem: postfix ) {
            if ( OPERATORS.contains(elem) ) {
                switch (elem) {
                    case "+": stack.push( stack.pop() + stack.pop() ); break;
                    case "-": stack.push( stack.pop() - stack.pop() ); break;
                    case "*": stack.push( stack.pop() * stack.pop() ); break;
                    case "/": double divisor = stack.pop(); stack.push( stack.pop() / divisor ); break;
                    case "^": double power = stack.pop(); stack.push( Math.pow(stack.pop(), power) ); break;
                }
            } else {
                stack.push(Double.parseDouble(elem));
            }
        }
        return stack.pop();
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        ArrayList<String> infix = new ArrayList<>();

        while ( tokenizer.hasMoreTokens() ) {
            infix.add( tokenizer.nextToken() );
        }

        // Sample input: 2 + ( 4 + 3 * 2 + 23 ) / 3
        ArrayList<String> postfix = this.toPostfix(infix);
        System.out.println(this.evalPostfix(postfix));
    }
}
