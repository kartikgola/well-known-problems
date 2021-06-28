/*
 * Author: Kartik Gola
 * Date: 6/13/20 7:39 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandom1 {

    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;
    private Random random = new Random();

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom1() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if ( map.containsKey(val) ) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if ( !map.containsKey(val) ) return false;
        int pos = map.get(val);

        // if removing non-last element
        if ( pos < list.size() - 1 ) {
            list.set(pos, list.get(list.size() - 1));
            list.remove(list.size() - 1);
            map.put(list.get(pos), pos);
            map.remove(val);
        } else {
            list.remove(list.size() - 1);
            map.remove(val);
        }

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        final int randVal = random.nextInt(list.size());
        return list.get(randVal);
    }
}
