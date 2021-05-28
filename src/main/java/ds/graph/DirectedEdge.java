/*
 * Author: Kartik Gola
 * Date: 5/27/21, 4:26 PM
 * Copyright (c) 2021 | https://rattl.io
 */

package ds.graph;

public class DirectedEdge<T> extends Edge<T> {

    public DirectedEdge(T from, T to) {
        super(from, to);
    }

    public DirectedEdge(Edge<T> edge) {
        super(edge);
    }

    public DirectedEdge(T from, T to, int weight) {
        super(from, to, weight);
    }

    @Override
    public String toString() {
        return "[" + from + "]--" + weight + "-->" + "[" + to + "]";
    }

    @Override
    public int hashCode() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DirectedEdge))
            return false;
        DirectedEdge<T> o = (DirectedEdge<T>) obj;
        return this.weight == o.weight && this.from == o.from && this.to == o.to;
    }
}