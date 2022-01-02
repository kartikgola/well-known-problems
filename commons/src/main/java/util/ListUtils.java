/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:45 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package util;import java.util.List;

public class ListUtils {

    public static void swap(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(i, temp);
    }

}
