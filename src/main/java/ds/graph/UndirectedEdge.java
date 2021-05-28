/*
 * Author: Kartik Gola
 * Date: 5/27/21, 4:26 PM
 * Copyright (c) 2021 | https://rattl.io
 */

package ds.graph;

public class UndirectedEdge<T> extends Edge<T> {

    public UndirectedEdge(T from, T to) {
        super(from, to);
    }

    public UndirectedEdge(Edge<T> edge) {
        super(edge);
    }

    public UndirectedEdge(T from, T to, int weight) {
        super(from, to, weight);
    }

    @Override
    public String toString() {
        return "[" + from + "]<--" + weight + "-->" + "[" + to + "]";
    }

    @Override
    public int hashCode() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UndirectedEdge))
            return false;
        UndirectedEdge<T> o = (UndirectedEdge<T>) obj;
        return this.weight == o.weight && ((this.from == o.from && this.to == o.to)
                || (this.from == o.to && this.to == o.from));
    }
}
