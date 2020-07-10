/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

import codechef.JUNE20B.*;
import codeforces.MaximumXorSecondary;
import codeforces.MinimalString;
import ds.SegmentTree;
import geeksforgeeks.DiagonalSum;
import geeksforgeeks.NextGreaterElement;
import leetcode.OptimalUtilization;
import leetcode.ValidIpAddress;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    }
}

class Node {
    char val;
    int times = 0;
    Set<Node> children = new HashSet<>();

    Node(char val) {
        this.val = val;
    }

    Node(char val, int times) {
        this.val = val;
        this.times = times;
    }

    @Override
    public int hashCode() {
        return (int) val;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Node && ((Node) obj).val == this.val);
    }
}
