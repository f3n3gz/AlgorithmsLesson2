import java.util.Objects;

public class Vertex {

    private final String label;
    private boolean wasVisited;
    private Vertex previous;

    public Vertex(String label) {
        this.label = label;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    public void markAsVisited() {
        this.wasVisited = true;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void resetState() {
        this.wasVisited = false;
        this.previous = null;
    }
}