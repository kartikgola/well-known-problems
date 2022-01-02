/*
 * Author: Kartik Gola
 * Date: 6/18/21, 3:34 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package graph.edge;

public abstract class Edge<T> {

    public T from;
    public T to;
    public int weight;

    public Edge(T from, T to) {
        this.from = from;
        this.to = to;
    }

    public Edge(Edge<T> edge) {
        this.from = edge.from;
        this.to = edge.to;
        this.weight = edge.weight;
    }


    public Edge(T from, T to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

}
