/*
 * Author: Kartik Gola
 * Date: 4/4/21, 10:30 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package ds.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractGraph implements Graph {

    protected final int size;
    protected Map<Integer, Map<Integer, Integer>> adj;

    public AbstractGraph(int size) {
        this.size = size;
        this.adj = new HashMap<>(size);
    }

    @Override
    public int getSize() {
        return size;
    }

    public Map<Integer, Map<Integer, Integer>> getAdj() {
        return adj;
    }

    public List<Integer> getVertices() {
        return IntStream.range(0, size).boxed().collect(Collectors.toList());
    }
}
