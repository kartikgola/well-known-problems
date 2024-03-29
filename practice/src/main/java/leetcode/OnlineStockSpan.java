/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Stack;

public class OnlineStockSpan {

    private static class Stock {
        int price;
        int day;
        Stock(int price, int day) {
            this.price = price;
            this.day = day;
        }
    }

    private Stack<Stock> st = new Stack<>();
    private int day = 0;

    public int next(int price) {
        Stock stock = new Stock(price, day);
        // keep a monotonically decreasing stack of (price, day)
        while (!st.isEmpty() && st.peek().price <= price) {
            st.pop();
        }
        int ans = day - (!st.isEmpty() ? st.peek().day : -1);
        st.push(stock);
        day++;
        return ans;
    }
}
