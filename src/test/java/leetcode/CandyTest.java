/*
 * Author: Kartik Gola
 * Date: 6/27/21, 11:52 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CandyTest {

    @Test
    void candy() {
        Candy c = new Candy();
        System.out.println(c.candy(new int[]{1,1,1}));
        System.out.println(c.candy(new int[]{1,0,2}));
        System.out.println(c.candy(new int[]{1,2,2}));
        System.out.println(c.candy(new int[]{4,1,2,5,3}));
    }
}