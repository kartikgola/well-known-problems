/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistantBarcodes {

    class Barcode {
        int val;
        int count;

        Barcode(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        final int n = barcodes.length;
        Map<Integer, Integer> map = new HashMap<>();
        for ( int bc : barcodes ) {
            if ( map.containsKey(bc) ) {
                map.put(bc, map.get(bc) + 1);
            } else {
                map.put(bc, 1);
            }
        }

        PriorityQueue<Barcode> pq = new PriorityQueue<>((Barcode a, Barcode b) -> {
            return a.count - b.count == 0 ? a.val - b.val : b.count - a.count;
        });

        for ( Map.Entry<Integer, Integer> e : map.entrySet() ) {
            if ( e.getValue() > 0 && e.getValue() <= (n + 1) / 2 ) {
                pq.add(new Barcode(e.getKey(), e.getValue()));
            }
        }

        int[] res = new int[n];
        int w = 0;
        while ( pq.size() >= 2 ) {
            Barcode b1 = pq.poll();
            Barcode b2 = pq.poll();
            res[w++] = b1.val;
            res[w++] = b2.val;
            if ( --b1.count > 0 )
                pq.add(b1);
            if ( --b2.count > 0 )
                pq.add(b2);
        }

        if ( pq.size() > 0 )
            res[w++] = pq.poll().val;

        return res;
    }

}
