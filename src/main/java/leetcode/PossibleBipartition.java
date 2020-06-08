package leetcode;

import java.util.*;

public class PossibleBipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        // Graph is bipartite if coloring can be done with ONLY 2 colors
        // So, a graph with odd cycle, cannot be colored with 2 colors
        if ( dislikes.length == 0 )
            return true;

        Set<Integer> red = new HashSet<>();
        Set<Integer> blue = new HashSet<>();

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for ( int i = 1; i <= N; ++i )
            map.put(i, new HashSet<>());

        for ( int[] pair : dislikes ) {
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        boolean[] v = new boolean[N + 1];

        for ( int i = 1; i <= N; ++i ) {
            if ( !v[i] ) {
                Queue<Integer> q = new LinkedList<>();
                boolean isRed = true;
                q.add(i);
                q.add(null);
                while ( !q.isEmpty() ) {
                    Integer src = q.poll();
                    if ( src == null ) {
                        isRed = !isRed;
                        if ( q.isEmpty() )
                            break;
                        else {
                            q.add(null);
                            continue;
                        }
                    }
                    v[src] = true;
                    if ( isRed ) {
                        if ( blue.contains(src) ) {
                            return false;
                        }
                        red.add(src);
                    } else {
                        if ( red.contains(src) ) {
                            return false;
                        }
                        blue.add(src);
                    }

                    // add neighbours
                    for ( int nbrs : map.get(src) ) {
                        if ( !v[nbrs] )
                            q.add(nbrs);
                    }
                }
            }
        }

        return true;
    }

}
