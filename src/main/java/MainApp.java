import Sorting.InsertionSort;

import java.util.ArrayList;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        final int BOUND = 100;
        ArrayList<Integer> array = new ArrayList<>(BOUND);
        Random random=new Random();
        for (int i = 0; i < BOUND; i++) {
            array.add(random.nextInt(BOUND));
        }
        System.out.println((InsertionSort.sort(array)));
    }
}
