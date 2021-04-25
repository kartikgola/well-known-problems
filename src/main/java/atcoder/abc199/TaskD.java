package atcoder.abc199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskD {

    private static long ways(int i, List<Integer> order, int[] colors, Map<Integer, List<Integer>> map) {
        int ways = 0;
        int u = order.get(i);
        outer:
        for (int color = 1; color <= 3; ++color) {
            for (Integer v: map.getOrDefault(u, new ArrayList<>())) {
                if (colors[v] == color)
                    continue outer;
            }
            colors[u] = color;
            if (i < order.size() - 1)
                ways += ways(i+1, order, colors, map);
            else
                ways++;
            colors[u] = 0;
        }
        return ways;
    }

    private static void visit(int u, List<Integer> order, Set<Integer> vis, Map<Integer, List<Integer>> map) {
        vis.add(u);
        order.add(u);
        for (Integer v: map.getOrDefault(u, new ArrayList<>())) {
            if (!vis.contains(v)) {
                visit(v, order, vis, map);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        while (m-- > 0) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]),
                b = Integer.parseInt(s[1]);
            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        long totalWays = 1;
        for (int u = 1; u <= n; ++u) {
            if (!visited.contains(u)) {
                List<Integer> order = new ArrayList<>();
                visit(u, order, visited, map);
                totalWays *= ways(0, order, new int[n+1], map);
            }
        }

        System.out.println(totalWays);
    }
}
