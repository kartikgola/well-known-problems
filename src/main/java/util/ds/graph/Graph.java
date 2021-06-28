/*
 * Author: Kartik Gola
 * Date: 4/4/21, 10:29 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package util.ds.graph;

import util.ds.graph.edge.Edge;

import java.util.List;
import java.util.Map;

public interface Graph<T extends Number> {

    /**
     * Get the size of graph (no. of vertices)
     * @return int
     */
    int getSize();

    /**
     * Get the adjacency map of the graph
     * @return Map<T, Map<T, Integer>>
     */
    Map<T, Map<T, Edge<T>>> getAdjMap();

    /**
     * Get List of all unique edges as tuples of (fromVertex, toVertex, edgeWeight)
     * For Undirected edges, the result includes only 1 edge among (A, B, X) & (B, A, X)
     * @return List<List<Integer>>
     */
    List<Edge<T>> getDistinctEdges();

    /**
     * Get List of all edges as tuples of (fromVertex, toVertex, edgeWeight)
     * @return List<List<Integer>>
     */
    List<Edge<T>> getEdges();

    /**
     * Get list of all vertices in the graph
     * @return List<T>
     */
    List<T> getVertices();

    /**
     * Get the neighbors of a specific vertex 'u'
     * @param u : input vertex
     * @return Map<T, Integer> where key is the neighboring vertex and value is the weight
     */
    Map<T, Edge<T>> getAdjMapOf(T u);

    /**
     * Get list of all edges starting from vertex 'u'
     * @param u : input vertex
     * @return List<Edge<T>>
     */
    List<Edge<T>> getEdgesFrom(T u);

    /**
     * Sets the adjacency list and list of edges using a 2D array of edges
     * @param edges: 2D array of size Nx3 where every sub-array is a tuple of (fromVertex, toVertex, edgeWeight) 
     */
    void setEdges(List<Edge<T>> edges);

    /**
     * Adds an edge to the Graph and updates adjacency list and list of edges
     * @param edge: a tuple of (fromVertex, toVertex, edgeWeight) 
     */
    void addEdge(Edge<T> edge);

    /**
     * Get any adjacent vertex from a vertex 'u'
     * @param u : input vertex
     * @return a vertex of type T
     */
    T getAnyAdjacentVertex(T u);

}
