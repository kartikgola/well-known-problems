/*
 * Author: Kartik Gola
 * Date: 8/8/21, 5:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package util.ds.tree.segment;

public enum RangeQueryType {
    Minimum {
        public int getDefault() {
            return Integer.MAX_VALUE;
        }
        public int merge(int val1, int val2) {
            return Math.min(val1, val2);
        }
    },
    Maximum {
        public int getDefault() {
            return Integer.MIN_VALUE;
        }
        public int merge(int val1, int val2) {
            return Math.max(val1, val2);
        }
    },
    Sum {
        public int getDefault() {
            return 0;
        }
        public int merge(int val1, int val2) {
            return val1+val2;
        }
    };

    public abstract int getDefault();
    public abstract int merge(int val1, int val2);
}