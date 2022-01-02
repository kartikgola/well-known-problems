/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfShipsInARectangle {

    class Sea {

        public boolean hasShips(int[] topRight, int[] bottomLeft) {
            return true;
        }
    }

    private class Rectangle {
        // bottom-left coordinates
        int x1, y1;
        // top-right coordinates
        int x2, y2;

        Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public List<Rectangle> half() {
            List<Rectangle> halves = new ArrayList<>(2);
            // x-coordinate is same
            if (x1 == x2) {
                int x = x1;
                int my = y1 + (y2 - y1) / 2;
                halves.add(new Rectangle(x, y1, x, my));
                halves.add(new Rectangle(x, my+1, x, y2));
            } else if (y1 == y2) {
                // y-coordinate is same
                int y = y1;
                int mx = x1 + (x2 - x1) / 2;
                halves.add(new Rectangle(x1, y, mx, y));
                halves.add(new Rectangle(mx+1, y, x2, y));
            } else {
                // we can half using either x or y coordinate
                // using x-coordinate half here
                int mx = x1 + (x2 - x1) / 2;
                halves.add(new Rectangle(x1, y1, mx, y2));
                halves.add(new Rectangle(mx+1, y1, x2, y2));
            }
            return halves;
        }

        public int[] tr() { return new int[]{x2, y2}; }

        public int[] bl() { return new int[]{x1, y1}; }

        public boolean canHalf() { return !(x1 == x2 && y1 == y2); }

        public String toString() { return Arrays.asList(x1, y1, x2, y2).toString(); }
    }

    // Keep dividing the rectangle until it is reduced to a single point
    // Only proceed with dividing if the rectangle has ships
    private int countShips(Sea sea, Rectangle r) {
        if (!r.canHalf())
            return sea.hasShips(r.tr(), r.bl()) ? 1 : 0;
        int ships = 0;
        for (Rectangle half: r.half()) {
            if (sea.hasShips(half.tr(), half.bl()))
                ships += countShips(sea, half);
        }
        return ships;
    }

    public int countShips(Sea sea, int[] tr, int[] bl) {
        return countShips(sea, new Rectangle(bl[0], bl[1], tr[0], tr[1]));
    }
}
