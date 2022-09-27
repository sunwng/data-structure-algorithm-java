import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashSet;


public class DepthFirstSearch {
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
//    Hashtable<Object, Boolean> searchCheck = null;
    HashSet<Object> searchCheck = new HashSet<>();
    Boolean searchResult = false;

    public void traverse(Vertex vertexIn, Object targetValue) {
        searchCheck.add(vertexIn.value);
        if (vertexIn.value == targetValue) {
            searchResult = true;
            return;
        }
        for (Vertex vertexI : vertexIn.adjacentVertex) {
            if (!searchCheck.contains(vertexI.value)) {
                traverse(vertexI, targetValue);
            }
        }
    }

    public Boolean search(Vertex vertexIn, Object targetValue) {
        traverse(vertexIn, targetValue);
        return searchResult;
    }

    public void resetCheck() {
        searchCheck = null;
        searchResult = false;
    }

    public static void main(String[] args) {
        DepthFirstSearch test = new DepthFirstSearch();

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

        System.out.println(test.search(v_1, "bob"));
    }

}
