package bag;

public class MainBag {
    public static void main(String[] args) {
        Entity[] items = new Entity[]{new Entity(2, 5),
                new Entity(1, 3),
                new Entity(2, 3),
                new Entity(5, 8),
                new Entity(6, 100)
        };
        Bag bag = new Bag(6, items);
        bag.showBestCombo();
    }
}
