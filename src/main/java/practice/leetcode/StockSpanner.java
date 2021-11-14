/*
 * Author: Kartik Gola
 * Date: 11/13/21, 1:44 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/online-stock-span/
 */

package practice.leetcode;

import java.util.Stack;

public class StockSpanner {

    private class Stock {
        int span;
        int price;
        Stock(int days, int price) {
            this.span = days;
            this.price = price;
        }
    }

    public StockSpanner() { }

    private Stack<Stock> stack = new Stack<>();

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && price >= stack.peek().price)
            span += stack.pop().span;
        stack.push(new Stock(span, price));
        return span;
    }
}
