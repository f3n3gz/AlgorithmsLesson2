import java.util.*;
import java.util.stream.Stream;

public class Graph {
    private HashMap<Vertex, List<Vertex>> data;

    public void Graph() {
        data = new HashMap<>();
    }

    public void addEdge(String vertexLabel, String... children) {
        addEdge(new Vertex(vertexLabel),
                Stream.of(children)
                        .map(Vertex::new)
                        .toArray(Vertex[]::new));
    }

    public void addEdge(Vertex vertex, Vertex... children) {
        if (data.keySet().contains(vertex)) {
            throw new IllegalArgumentException("Graph already contain vertex with label " + vertex.getLabel() + " .");
        }
        data.put(vertex, Arrays.asList(children));
    }

    public void bfs(String startLabel, String endLabel) {
        if (!data.keySet().contains(new Vertex(startLabel))) {
            throw new IllegalArgumentException("Graph isn't contain vertex with label " + startLabel + " .");
        }
        if (!data.keySet().contains(new Vertex(endLabel))) {
            throw new IllegalArgumentException("Graph isn't contain vertex with label " + endLabel + " .");
        }

        Deque<Vertex> deque = new LinkedList<>();
        deque.push(data.keySet()
                .stream()
                .filter(vertex -> vertex.getLabel().equals(startLabel))
                .findFirst()
                .get());

        // deque.push(new Vertex(startLabel));
        Vertex parent = null;
        while (!deque.isEmpty()) {
            Vertex current = deque.pollLast();
            current.markAsVisited();
            //если нашли конечную, берем его папку
            if (current.getLabel().equals(endLabel)) {
                parent = current;
                break;
            }
            try {
                if (data.get(current) != null) {
                    data.get(current).forEach(child -> {
                        if (!child.isWasVisited()) {
                            child.setPrevious(current);
                            child.markAsVisited();
                            deque.push(child);
                        }
                    });
                }
            } catch (NullPointerException e) {
                System.out.println(current);
            }
        }

        deque.clear();
        int pathLength = -1; // так как начинаем с самого конца
        while (parent != null) {
            deque.push(parent);
            parent = parent.getPrevious();
            pathLength++;
        }
        System.out.println("Path length is " + pathLength);
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(Objects.requireNonNull(deque.pollFirst()).getLabel()).append("->");
        }
        sb.replace(sb.length() - 2, sb.length(), "");
        System.out.println(sb);
        resetParentLinks();
    }

    private void resetParentLinks() {
        data.forEach((vertex, vertices) -> vertices.forEach(Vertex::resetState));
    }
}
