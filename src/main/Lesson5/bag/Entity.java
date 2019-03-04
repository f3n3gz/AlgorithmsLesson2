package bag;

public class Entity implements Comparable<Entity> {
    private int weight;
    private double price;
    private static int count;
    private String name;

    public Entity(int weight, double price) {
        this.weight = weight;
        this.price = price;
        this.name = "Item " + count;
        count++;
    }

    public int getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name + ", Price = " + this.price + ", Weight = " + this.weight;
    }

    @Override
    public int compareTo(Entity o) {
        double epsilon = 0.000001;
        if (this.weight == o.weight) {
            if (Math.abs((o.price / this.price) - 1) > epsilon) {
                return -1;
            } else if (Math.abs((this.price / o.price) - 1) > epsilon) {
                return 1;
            }
            return 0;
        } else if (this.weight > o.weight) return 1;
        else return -1;
    }
}
