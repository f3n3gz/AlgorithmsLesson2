package Sorting;

import java.util.ArrayList;

public class BubbleSort {
    public static <E extends Comparable<E>> ArrayList<E> sort(ArrayList<E> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arrayList.size() - 1; j++) {
                if (arrayList.get(j).compareTo(arrayList.get(j + 1)) > 0) {
                    E temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                    swapped = true;
                }
            }
            // если не меняли местами, то выходим из цикла
            if (!swapped) {
                break;
            }
        }
        return arrayList;
    }
}
