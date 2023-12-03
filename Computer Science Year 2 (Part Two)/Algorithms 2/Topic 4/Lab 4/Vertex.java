import java.util.ArrayList;

public class Vertex {
    public String name;
    public ArrayList<Edge> adjlist;
    public boolean visited;
    public int minDistance;

    public Vertex(String name) {
        this.name = name;
        this.adjlist = new ArrayList<>();
    }
}