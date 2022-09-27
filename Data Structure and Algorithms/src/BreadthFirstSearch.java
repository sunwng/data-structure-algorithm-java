import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class BreadthFirstSearch {
    static class Vertex {
        Object value;
        ArrayList<Vertex> adjacentVertex;

        Vertex(Object valueIn) {
            value = valueIn;
            adjacentVertex = new ArrayList<>();
        }

        public void addAdjacent(Vertex vertexIn) {
            adjacentVertex.add(vertexIn);
            vertexIn.adjacentVertex.add(this);
        }
    }
    Boolean searchResult = false;
    Queue<Vertex> searchQueue = new LinkedList<>();
    HashSet<Object> searchCheck = new HashSet<>();

    public void traverse(Vertex vertexIn, Object targetValue) {
        if (vertexIn.value == targetValue) {
            searchResult = true;
            return;
        }
        searchQueue.add(vertexIn);
        while (!searchQueue.isEmpty()) {
            Vertex currentVertex = searchQueue.poll();
            searchCheck.add(currentVertex.value);
            for (Vertex vertexI : currentVertex.adjacentVertex) {
                if (vertexI.value == targetValue) {
                    searchResult = true;
                    return;
                } else if (!searchCheck.contains(vertexI.value)) {
                    searchQueue.add(vertexI);
                }
            }
        }
    }

    public Boolean search(Vertex vertexIn, Object targetValue) {
        traverse(vertexIn, targetValue);
        return searchResult;
    }

    public static void main(String[] args) {
        BreadthFirstSearch test = new BreadthFirstSearch();

        Vertex v_1 = new Vertex("Alice");
        Vertex v_2 = new Vertex("Elaine");
        Vertex v_3 = new Vertex("Derek");
        Vertex v_4 = new Vertex("Gina");
        Vertex v_5 = new Vertex("Irena");
        Vertex v_6 = new Vertex("Bob");
        Vertex v_7 = new Vertex("Fred");
        Vertex v_8 = new Vertex("Helen");
        Vertex v_9 = new Vertex("Candy");
        v_1.addAdjacent(v_2);
        v_1.addAdjacent(v_3);
        v_1.addAdjacent(v_9);
        v_1.addAdjacent(v_6);
        v_2.addAdjacent(v_3);
        v_3.addAdjacent(v_4);
        v_4.addAdjacent(v_5);
        v_6.addAdjacent(v_7);
        v_7.addAdjacent(v_8);
        v_8.addAdjacent(v_9);

        System.out.println(test.search(v_1, "Fred"));
    }
}
