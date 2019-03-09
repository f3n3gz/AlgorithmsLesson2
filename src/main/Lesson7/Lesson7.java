public class Lesson7 {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E", "F");
        graph.addEdge("C", "F", "G", "K");
        graph.addEdge("D", "L");
        graph.addEdge("E", "P");
        graph.addEdge("F", "P");
        graph.addEdge("K", "P", "Z");
        graph.addEdge("Z");
        graph.addEdge("P");

        graph.bfs("A", "Z");
        graph.bfs("A", "B");
        graph.bfs("A", "P");
    }
}
