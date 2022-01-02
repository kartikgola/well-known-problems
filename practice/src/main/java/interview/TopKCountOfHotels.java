/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package interview;

import util.Pair;

import java.util.*;

public class TopKCountOfHotels {

    private int[] value;
    private int[] root;

    private int find(int x) {
        if (root[x] < 0)
            return x;
        return root[x] = find(root[x]);
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            value[py] += value[px];
            value[px] = 0;
            root[px] = py;
        }
    }

    public List<int[]> topKDSU(List<int[]> hotels, int k, int n) {
        root = new int[n];
        value = new int[n];
        Arrays.fill(root, -1);
        for (int[] hotel: hotels) {
            value[hotel[1]] += hotel[2];
        }
        for (int[] hotel: hotels) {
            union(hotel[0], hotel[1]);
        }
        Queue<Integer> pq = new PriorityQueue<>((h1, h2) -> value[h1] - value[h2]);
        for (int i = 0; i < n; ++i) {
            pq.offer(i);
            if (pq.size() > k)
                pq.poll();
        }
        List<int[]> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int hotel = pq.poll();
            ans.add(new int[]{hotel, value[hotel]});
        }
        return ans;
    }

    private void dfs(int hotel, int rating, Map<Integer, Pair<Integer, Integer>> parent, Map<Integer, Integer> total) {
        if (!parent.containsKey(hotel)) {
            total.put(hotel, total.getOrDefault(hotel, 0) + rating);
            return;
        }
        Pair<Integer, Integer> pair = parent.get(hotel);
        dfs(pair.getKey(), rating + pair.getValue(), parent, total);
        parent.put(hotel, new Pair<>(pair.getKey(), 0));
    }

    public List<int[]> topKDFS(List<int[]> hotels, int k, int n) {
        // map of child_hotel=(parent_hotel, rating)
        Map<Integer, Pair<Integer, Integer>> parent = new HashMap<>();
        for (int[] hotel: hotels) {
            parent.put(hotel[0], new Pair<>(hotel[1], hotel[2]));
        }
        Map<Integer, Integer> total = new HashMap<>();
        for (int[] hotel: hotels) {
            dfs(hotel[0], 0, parent, total);
        }
        List<int[]> ans = new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<>((h1, h2) -> total.get(h1) - total.get(h2));
        for (Map.Entry<Integer, Integer> e: total.entrySet()) {
            pq.offer(e.getKey());
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            int hotel = pq.poll();
            ans.add(new int[]{hotel, total.get(hotel)});
        }
        return ans;
    }

    public static void main(String[] args) {
        List<int[]> res1 = new TopKCountOfHotels().topKDSU(
            Arrays.asList(
                    new int[]{0, 1, 10},
                    new int[]{1, 2, 20},
                    new int[]{3, 4, 10},
                    new int[]{7, 8, 5}
            ),
            3,
            9
        );

        for (int[] val: res1) {
            System.out.println(Arrays.toString(val));
        }

        List<int[]> res2 = new TopKCountOfHotels().topKDFS(
                Arrays.asList(
                        new int[]{0, 1, 10},
                        new int[]{1, 2, 20},
                        new int[]{3, 4, 10},
                        new int[]{7, 8, 5}
                ),
                3,
                9
        );

        for (int[] val: res2) {
            System.out.println(Arrays.toString(val));
        }
    }
}
