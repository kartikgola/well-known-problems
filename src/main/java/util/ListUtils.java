/*
 * Author: Kartik Gola
 * Date: 08/02/2021, 00:16
 * Copyright (c) 2021 | https://rattl.io
 */

package util;

import java.util.List;

public class ListUtils {

    public static void swap(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(i, temp);
    }

}
