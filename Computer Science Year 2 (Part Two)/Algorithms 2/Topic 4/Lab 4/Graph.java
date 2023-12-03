import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;
public class Graph {
    public ArrayList<Vertex> vlist;

    public Graph() {
        vlist = new ArrayList<>();
    }

    public void addVertex(String v) {
        vlist.add(new Vertex(v));
    }

    public Vertex getVertex(String v) {
        for (Vertex vertex : vlist) {
            if (vertex.name.equals(v)) {
                return vertex;
            }
        }
        return null;
    }

    public void addEdge(String v1, String v2, int weight) {
        Vertex from = getVertex(v1);
        Vertex to = getVertex(v2);
        Edge edge = new Edge(from, to, weight);
        from.adjlist.add(edge);

        if (!v1.equals(v2)) {
            Edge reverseEdge = new Edge(to, from, weight);
            to.adjlist.add(reverseEdge);
        }
    }

    public Edge getEdge(String v1, String v2) {
        Vertex from = getVertex(v1);
        Vertex to = getVertex(v2);
        for (Edge edge : from.adjlist) {
            if (edge.to.equals(to)) {
                return edge;
            }
        }
        return null;
    }

    public int MSTCost() {
        Graph mst = MST();
        int cost = 0;

        for (Vertex v : mst.vlist) {
            for (Edge e : v.adjlist) {
                cost += e.weight;
            }
        }

        return cost / 2;
    }

    public Graph MST() {
        Graph mst = new Graph();
        if (vlist.size() == 0) {
            return mst;
        }

        for (Vertex v : vlist) {
            mst.addVertex(v.name);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        Vertex start = vlist.get(0);
        for (Edge e : start.adjlist) {
            pq.add(e);
        }
        start.visited = true;

        while (!pq.isEmpty()) {
            Edge minEdge = pq.poll();
            if (minEdge.to.visited) {
                continue;
            }
            mst.addEdge(minEdge.from.name, minEdge.to.name, minEdge.weight);

            minEdge.to.visited = true;
            for (Edge e : minEdge.to.adjlist) {
                if (!e.to.visited) {
                    pq.add(e);
                }
            }
        }

        for (Vertex v : vlist) {
            v.visited = false;
        }

        return mst;
    }

    public int SPCost(String from, String to) {
        Graph spGraph = SP(from, to);
        Vertex destination = spGraph.getVertex(to);
        return destination.minDistance;
    }

    public Graph SP(String from, String to) {
        Vertex src = getVertex(from);
        Vertex dest = getVertex(to);

        HashMap<Vertex, Vertex> previous = new HashMap<>();
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.minDistance));

        for (Vertex v : vlist) {
            if (v != src) {
                v.minDistance = Integer.MAX_VALUE;
            }
            previous.put(v, null);
        }

        src.minDistance = 0;
        pq.add(src);

        while (!pq.isEmpty()) {
            Vertex u = pq.poll();

            for (Edge e : u.adjlist) {
                Vertex v = e.to;
                int alt = u.minDistance + e.weight;
                if (alt < v.minDistance) {
                    pq.remove(v);
                    v.minDistance = alt;
                    previous.put(v, u);
                    pq.add(v);
                }
            }
        }

        Graph spGraph = new Graph();
        for (Vertex v : vlist) {
            spGraph.addVertex(v.name);
        }

        Vertex current = dest;
        while (previous.get(current) != null) {
            Vertex prev = previous.get(current);
            spGraph.addEdge(prev.name, current.name, current.minDistance - prev.minDistance);
            current = prev;
        }

        return spGraph;
    }
}
