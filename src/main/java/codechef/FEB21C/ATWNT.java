/*
 * Author: Kartik Gola
 * Date: 10/02/2021, 14:20
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://www.codechef.com/FEB21C/problems/TEAMNAME
 */

package codechef.FEB21C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ATWNT {

    private static int dfs(int u, Map<Integer, List<Integer>> cMap, int a) {
        int undone = 0;
        List<Integer> children = cMap.getOrDefault(u, new ArrayList<>(0));
        if (children.size() > 0) {
            if (a % children.size() != 0)
                undone += a;
            else {
                for (Integer v: children) {
                    undone += dfs(v, cMap, a / children.size());
                }
            }
        }
        return undone;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, List<Integer>> cMap = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int child = 2;
        while (st.hasMoreTokens()) {
            int parent = Integer.parseInt(st.nextToken());
            cMap.putIfAbsent(parent, new ArrayList<>());
            cMap.get(parent).add(child++);
        }
        int q = Integer.parseInt(br.readLine());

        while (q-- > 0) {
            String inp = br.readLine();
            int v = Integer.parseInt(inp.split(" ")[0]);
            int w = Integer.parseInt(inp.split(" ")[1]);
            sb.append(dfs(v, cMap, w) + "\n");
        }

        System.out.println(sb);
    }
}
