/*
 * Author: Kartik Gola
 * Date: 4/2/21, 10:47 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package util;

import ds.disjointset.UnionFind;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphUtils {

    public static class IntGraph {
        public final Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        public List<int[]> edges;
        public final int size;
        public final boolean isDirected;
        public IntGraph(int size, boolean isDirected) {
            this.size = size;
            this.isDirected = isDirected;
            this.edges = new ArrayList<>(size);
            for (int u = 0; u < size; ++u)
                adj.put(u, new HashMap<>());
        }
        public IntGraph(int size, boolean isDirected, int[][] edges) {
            this(size, isDirected);
            for (int[] edge: edges)
                addEdge(edge);
        }
        public void addEdge(int[] edge) {
            adj.get(edge[0]).put(edge[1], edge[2]);
            edges.add(new int[]{edge[0], edge[1], edge[2]});
            if (!isDirected) {
                adj.get(edge[1]).put(edge[0], edge[2]);
                edges.add(new int[]{edge[1], edge[0], edge[2]});
            }
        }

        // Cycle detection
        private boolean isCyclic(int u, boolean[] visited, boolean[] path) {
            if (!visited[u]) {
                visited[u] = true;
                path[u] = true;
                for (int v: adj.get(u).keySet()) {
                    if (isCyclic(v, visited, path))
                        return true;
                    else if (path[v])
                        return true;
                }
            }
            path[u] = false;
            return false;
        }
        public boolean isCyclic() {
            boolean[] visited = new boolean[size];
            boolean[] path = new boolean[size];
            for (int u = 0; u < size; ++u) {
                if (!visited[u] && isCyclic(u, visited, path)) {
                    return true;
                }
            }
            return false;
        }

        // Tree detection
        public boolean isTree() {
            boolean[] visited = new boolean[size];
            boolean[] path = new boolean[size];
            if (isCyclic(0, visited, path))
                return false;
            for (boolean vis: visited)
                if (!vis) return false;
            return true;
        }

        // Topological sort
        public int[] topologicalSort() {
            int[] indegree = new int[size];
            int[] ans = new int[size];
            boolean[] visited = new boolean[size];
            Queue<Integer> q = new LinkedList<>();
            adj.values().stream().map(Map::keySet).flatMap(Collection::stream).forEach(u -> indegree[u]++);
            for (int u = 0; u < size; u++) {
                if (indegree[u] == 0) {
                    q.add(u);
                }
            }
            int j = 0;
            while (!q.isEmpty()) {
                int u = q.poll();
                ans[j++] = u;
                for (int v: adj.get(u).keySet()) {
                    if (!visited[v] && --indegree[v] == 0) {
                        q.add(v);
                        visited[v] = true;
                    }
                }
            }
            if (j < size)
                return new int[]{};
            return ans;
        }

        // Dijkstra's algorithm
        public int[] dijkstra(int source) {
            int[] dist = new int[size];
            boolean[] visited = new boolean[size];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[source] = 0;
            Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
            pq.add(new int[]{0, source});

            while (!pq.isEmpty()) {
                int d = pq.peek()[0],
                    u = pq.poll()[1];
                if (visited[u])
                    continue;
                visited[u] = true;
                for (Map.Entry<Integer, Integer> e: adj.get(u).entrySet()) {
                    int v = e.getKey(),
                        w = e.getValue();
                    if (d + w < dist[v]) {
                        dist[v] = d + w;
                        pq.add(new int[]{dist[v], v});
                    }
                }
            }

            return dist;
        }

        // Bellman-ford's algorithm
        public int[] bellmanFord(int source) {
            int[] dist = new int[size];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[source] = 0;
            for (int i = 0; i < size-1; ++i) {
                for (int[] edge: edges) {
                    int from = edge[0], to = edge[1], weight = edge[2];
                    if (dist[from] != Integer.MAX_VALUE && dist[from] + weight < dist[to]) {
                        dist[to] = dist[from] + weight;
                    }
                }
            }
            for (int[] edge: edges) {
                int from = edge[0], to = edge[1], weight = edge[2];
                if (dist[from] != Integer.MAX_VALUE && dist[from] + weight < dist[to]) {
                    // Graph has -ve weight cycle
                    return new int[]{};
                }
            }
            return dist;
        }

        // Floyd-warshall's algorithm
        public int[][] floydWarshall() {
            int[][] dist = new int[size][size];
            for (int u = 0; u < size; ++u) {
                Arrays.fill(dist[u], Integer.MAX_VALUE);
                dist[u][u] = 0;
                for (Map.Entry<Integer, Integer> e: adj.get(u).entrySet()) {
                    dist[u][e.getKey()] = e.getValue();
                }
            }
            for (int k = 0; k < size; ++k) {
                for (int u = 0; u < size; ++u) {
                    for (int v = 0; v < size; ++v) {
                        if (dist[u][k] != Integer.MAX_VALUE && dist[k][v] != Integer.MAX_VALUE
                        && dist[u][k] + dist[k][v] < dist[u][v]) {
                            dist[u][v] = dist[u][k] + dist[k][v];
                        }
                    }
                }
            }
            return dist;
        }

        // Kruskal's algorithm
        public IntGraph kruskal() {
            IntGraph mst = new IntGraph(size, isDirected);
            edges.sort(Comparator.comparingInt(e -> e[2]));
            UnionFind uf = new UnionFind(size);
            for (int[] edge: edges) {
                if (uf.union(edge[0], edge[2])) {
                    mst.addEdge(edge);
                }
            }
            return mst;
        }

        // Prim's algorithm
        public IntGraph prim() {
            boolean[] visited = new boolean[size];
            Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));
            IntGraph mst = new IntGraph(size, isDirected);
            int randomSource = new Random().nextInt(size);
            for (Map.Entry<Integer, Integer> edge: adj.get(randomSource).entrySet())
                pq.add(new int[]{randomSource, edge.getKey(), edge.getValue()});
            visited[randomSource] = true;

            while (!pq.isEmpty()) {
                int u = pq.peek()[0],
                    v = pq.peek()[1],
                    w = pq.poll()[2];
                if (visited[v])
                    continue;
                visited[v] = true;
                mst.addEdge(new int[]{u, v, w});
                for (Map.Entry<Integer, Integer> edge: adj.get(v).entrySet())
                    pq.add(new int[]{v, edge.getKey(), edge.getValue()});
            }
            return mst;
        }
    }

    public static List<Character> topologicalSort(Map<Character, Set<Character>> adj) {
        final int n = adj.size();
        List<Character> ans = new ArrayList<>(n);

        // Find out indegrees of all the vertices
        Map<Character, Long> indegreesMap = adj.values()
            .stream()
            .flatMap(Collection::stream)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Put in queue all those vertices whose indegree = 0
        Queue<Character> q = adj.keySet()
                .stream()
                .filter(vertex -> !indegreesMap.containsKey(vertex))
                .collect(Collectors.toCollection(LinkedList::new));

        // Mark all the vertices present in queue as visited
        Set<Character> visited = new HashSet<>(q);

        while (!q.isEmpty()) {
            Character from = q.remove();
            ans.add(from);
            for (Character to: adj.getOrDefault(from, Collections.emptySet())) {
                if (!visited.contains(to)) {
                    // Remove incoming edge of 'to'
                    indegreesMap.put(to, indegreesMap.get(to) - 1);
                    if (indegreesMap.get(to) == 0) {
                        visited.add(to);
                        q.add(to);
                    }
                }
            }
        }

        // Check if there is a cycle
        if (ans.size() != n)
            return null;

        return ans;
    }

}
