/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author Abhishek
 */
import java.util.*;

class SpanningTree {

    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    };

    class subset {
        int parent, rank;
    };
    int V, E;
    Edge edge[];

    SpanningTree(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge();
        }
    }

    int find(subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalMSTAlgorithm() {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i) {
            result[i] = new Edge();
        }
        Arrays.sort(edge);
        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i) {
            subsets[i] = new subset();
        }
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        while (e < V - 1) {
            Edge next_edge = new Edge();
            next_edge = edge[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
        System.out.println("Minimum Spanning Tree");
        char[] characters = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (i = 0; i < e; ++i) {
            System.out.println(characters[result[i].src] + " --------- " + characters[result[i].dest] + " = " + result[i].weight);
        }
    }

    public static void main(String[] args) {

        int vertices = 7;
        int edge = 12;
        SpanningTree graph = new SpanningTree(vertices, edge);
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 5; 
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 3;
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 4;
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 6;
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 5;
        graph.edge[5].src = 2;
        graph.edge[5].dest = 5;
        graph.edge[5].weight =11;
        graph.edge[6].src = 3;
        graph.edge[6].dest = 5;
        graph.edge[6].weight = 9;
        graph.edge[7].src = 3;
        graph.edge[7].dest = 4;
        graph.edge[7].weight = 7;
        graph.edge[8].src = 1;
        graph.edge[8].dest = 4;
        graph.edge[8].weight = 2;
        graph.edge[9].src = 4;
        graph.edge[9].dest = 5;
        graph.edge[9].weight = 12;
        graph.edge[10].src = 4;
        graph.edge[10].dest = 6;
        graph.edge[10].weight = 8;
        graph.edge[11].src = 5;
        graph.edge[11].dest = 6;
        graph.edge[11].weight = 7;

        graph.KruskalMSTAlgorithm();
    }
}
