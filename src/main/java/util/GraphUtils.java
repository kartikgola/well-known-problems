/*
 * Author: Kartik Gola
 * Date: 4/2/21, 10:47 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package util;

import util.ds.disjointset.UnionFind;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GraphUtils {

    public static class IntGraph {
        public final Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        public List<int[]> edges;
        public final int size;
        public final boolean isDirected;
        private int time = 0;
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
            int from = edge[0],
                to = edge[1],
                weight = edge.length == 3 ? edge[2] : 0;
            adj.get(from).put(to, weight);
            edges.add(new int[]{from, to, weight});
            if (!isDirected) {
                adj.get(to).put(from, weight);
                edges.add(new int[]{to, from, weight});
            }
        }

        // Cycle detection
        private boolean isCyclic(int u, boolean[] visited, boolean[] path) {
            if (!visited[u]) {
                visited[u] = true;
                path[u] = true;
                for (int v: adj.get(u).keySet()) {
                    if (!visited[v]) {
                        if (isCyclic(v, visited, path))
                            return true;
                    } else if (path[v])
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

        // Topological sort/Kahn's algorithm O(V+E)
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

        // Dijkstra's algorithm O(ElogV)
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
                for (Map.Entry<Integer, Integer> e: adj.getOrDefault(u, new HashMap<>()).entrySet()) {
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

        // Bellman-ford's algorithm O(VE)
        public int[] bellmanFord(int source) {
            int[] prev = new int[size];
            int[] curr = new int[size];
            Arrays.fill(prev, Integer.MAX_VALUE);
            Arrays.fill(curr, Integer.MAX_VALUE);
            prev[source] = 0;

            // relax unique_edges-1 times
            for (int i = 0; i < edges.size()/2 - 1; i++) {
                curr[source] = 0;
                for (int[] edge : edges) {
                    int u = edge[0];
                    int v = edge[1];
                    int w = edge[2];

                    if (prev[u] < Integer.MAX_VALUE) {
                        curr[v] = Math.min(curr[v], prev[u] + w);
                    }
                }
                prev = curr.clone();
            }

            // can we relax 1 more time?
            for (int[] edge: edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (prev[u] < Integer.MAX_VALUE && prev[u] + w < curr[v])
                    return new int[]{};
            }
            return curr;
        }

        // Shortest Path Faster algorithm O(VE)
        public int[] spfa(int source) {
            int[] dist = new int[size];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[source] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(source);
            // we can't use 'visited' here, since this is plain-old BFS with a simple optimization
            // worst-case complexity is same as bellman-ford
            while (!q.isEmpty()) {
                int u = q.poll();
                for (Map.Entry<Integer, Integer> e: adj.getOrDefault(u, new HashMap<>()).entrySet()) {
                    if (dist[u] + e.getValue() < dist[e.getKey()]) {
                        dist[e.getKey()] = dist[u] + e.getValue();
                        q.add(e.getKey());
                    }
                }
            }
            return dist;
        }

        // Floyd-warshall's algorithm O(V^3)
        public int[][] floydWarshall() {
            int[][] dist = new int[size][size];
            for (int u = 0; u < size; ++u) {
                Arrays.fill(dist[u], Integer.MAX_VALUE);
                dist[u][u] = 0;
                for (Map.Entry<Integer, Integer> e: adj.getOrDefault(u, new HashMap<>()).entrySet()) {
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

        // Kruskal's algorithm O(ELogV)
        public IntGraph kruskal() {
            IntGraph mst = new IntGraph(size, isDirected);
            edges.sort(Comparator.comparingInt(e -> e[2]));
            UnionFind uf = new UnionFind(size);
            int edgesTaken = 0;
            for (int[] edge: edges) {
                // MST will always contains V-1 edges
                if (edgesTaken == size-1)
                    break;
                if (uf.union(edge[0], edge[2])) {
                    mst.addEdge(edge);
                }
            }
            return mst;
        }

        // Prim's algorithm O(ELogV)
        public IntGraph prim() {
            boolean[] visited = new boolean[size];
            IntGraph mst = new IntGraph(size, isDirected);
            int randomSource = new Random().nextInt(size);
            // Tuple of (edgeWeight, to, from)
            // 'from' is not really needed & is only there to add edges in new MST
            Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));
            for (Map.Entry<Integer, Integer> edge: adj.get(randomSource).entrySet())
                pq.add(new int[]{edge.getValue(), edge.getKey(), randomSource});
            visited[randomSource] = true;
            int edgesTaken = 0;

            // MST will always contains V-1 edges
            while (!pq.isEmpty() && edgesTaken < size-1) {
                int w = pq.peek()[0];
                int v = pq.peek()[1];
                int u = pq.poll()[2];
                if (visited[v])
                    continue;
                visited[v] = true;
                mst.addEdge(new int[]{u, v, w});
                edgesTaken++;
                for (Map.Entry<Integer, Integer> edge: adj.getOrDefault(v, new HashMap<>()).entrySet())
                    pq.add(new int[]{v, edge.getKey(), edge.getValue()});
            }
            return mst;
        }

        private void cutVertices(int u, int parent, int[] disc, int[] low, Set<Integer> ans) {
            low[u] = disc[u] = ++time;
            int children = 0;
            for (Map.Entry<Integer, Integer> e: adj.get(u).entrySet()) {
                int v = e.getKey();
                if (v == parent)
                    continue;
                if (disc[v] == -1) {
                    cutVertices(v, u, disc, low, ans);
                    low[u] = Math.min(low[u], low[v]);
                    if (parent != -1 && low[v] >= disc[u])
                        ans.add(u);
                    children++;
                } else {
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
            // if u is root and has > 1 children
            if (parent == -1 && children > 1)
                ans.add(u);
        }

        // Tarjan's algorithm to find cut-vertices (AKA articulation points)
        public List<Integer> cutVertices() {
            time = 0;
            Set<Integer> ans = new HashSet<>();
            int[] disc = new int[size];
            int[] low = new int[size];
            Arrays.fill(disc, -1);
            cutVertices(0, -1, disc, low, ans);
            return new ArrayList<>(ans);
        }

        private void cutEdges(int u, int parent, int[] disc, int[] low, List<List<Integer>> ans) {
            low[u] = disc[u] = ++time;
            for (Map.Entry<Integer, Integer> e: adj.get(u).entrySet()) {
                int v = e.getKey();
                if (v == parent)
                    continue;
                if (disc[v] == -1) {
                    cutEdges(v, u, disc, low, ans);
                    low[u] = Math.min(low[u], low[v]);
                    if (low[v] > disc[u])
                        ans.add(Arrays.asList(u, v));
                } else {
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }

        // Tarjan's algorithm to find cut-edges (AKA bridges)
        public List<List<Integer>> cutEdges() {
            time = 0;
            List<List<Integer>> ans = new ArrayList<>();
            int[] disc = new int[size];
            int[] low = new int[size];
            Arrays.fill(disc, -1);
            cutEdges(0, -1, disc, low, ans);
            return ans;
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
