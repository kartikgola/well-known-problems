package atcoder.abc199;

import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskD {

    private static long ways(int i, List<Integer> dfsOrder, int[] colors, List<List<Integer>> adj) {
        int ways = 0;
        int u = dfsOrder.get(i);
        outer:
        for (int color = 1; color <= 3; ++color) {
            for (Integer v: adj.get(u)) {
                if (colors[v] == color)
                    continue outer;
            }
            colors[u] = color;
            if (i < dfsOrder.size() - 1)
                ways += ways(i+1, dfsOrder, colors, adj);
            else
                ways++;
            colors[u] = 0;
        }
        return ways;
    }

    private static void visit(int u, List<Integer> dfsOrder, Set<Integer> vis, List<List<Integer>> adj) {
        vis.add(u);
        dfsOrder.add(u);
        for (Integer v: adj.get(u)) {
            if (!vis.contains(v)) {
                visit(v, dfsOrder, vis, adj);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> adj = new ArrayList<>(n+1);
        for (int i = 0; i < n+1; i++)
            adj.add(new ArrayList<>());

        while (m-- > 0) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]),
                b = Integer.parseInt(s[1]);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        long totalWays = 1;
        for (int u = 1; u <= n; ++u) {
            if (!visited.contains(u)) {
                // 1. Prepare a list of nodes visited in DFS order
                List<Integer> dfsOrder = new ArrayList<>();
                visit(u, dfsOrder, visited, adj);
                // 2. Start traversing the DFS order by simulating each color for a node
                totalWays *= ways(0, dfsOrder, new int[n+1], adj);
            }
        }

        System.out.println(totalWays);
    }
}
