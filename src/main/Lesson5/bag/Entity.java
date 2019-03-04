package bag;

import LinkedList.Entry;

public class Entity implements Comparable<Entity> {
    private int weight;
    private double price;

    public Entity(int weight, double price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public int compareTo(Entity o) {
        double epsilon = 0.000001;
        if (Math.abs(this.weight - o.weight) < epsilon) return 0;
        else if (this.weight - o.weight > epsilon) return 1;
        else return -1;
    }
}
