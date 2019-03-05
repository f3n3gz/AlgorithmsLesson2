import bag.Bag;
import bag.Entity;

public class MainApp5 {
    public static void main(String[] args) {
        System.out.println(PowRecursion.Pow(2, -1));
        System.out.println(PowRecursion.Pow(0, 5));
        System.out.println(PowRecursion.Pow(3, 4));
        System.out.println(PowRecursion.Pow(-6, 5));
        //       System.out.println(PowRecursion.Pow(0,0));
        System.out.println(PowRecursion.Pow(-6, 0));

        Entity[] items = new Entity[]{new Entity(2, 5),
                new Entity(1, 100),
                new Entity(2, 3),
                new Entity(5, 8),
                new Entity(6, 100)
        };
        Bag bag = new Bag(6, items);
        bag.showBestCombo();
    }
}
