/*
 * Author: Kartik Gola
 * Date: 19/06/20, 7:02 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> m = new HashMap<>();
        for ( String word: words ) {
            if ( m.containsKey(word) )
                m.put( word, m.get(word) + 1 );
            else
                m.put( word, 1 );
        }

        Queue<String> pq = new PriorityQueue<>(k, (String a, String b) -> {
            // element with lower frequency, should come first, so that it gets removed first
            int diff = m.get(a) - m.get(b);
            // element with higher alphabetical order, should come first
            return diff != 0 ? diff : b.compareTo(a);
        });

        for ( Map.Entry<String, Integer> e : m.entrySet() ) {
            if ( pq.size() < k )
                pq.add( e.getKey() );
            else {
                // Check if front of PQ is smaller than current key
                int diff = m.get(pq.peek()) - e.getValue();
                // Element with higher alpha order, should be removed
                if ( diff == 0 )
                    diff = e.getKey().compareTo(pq.peek());
                if ( diff < 0 ) {
                    pq.poll();
                    pq.add( e.getKey() );
                }
            }
        }

        List<String> l = new ArrayList<>(k);
        while ( !pq.isEmpty() )
            l.add( pq.poll() );

        Collections.reverse(l);
        return l;
    }
}
