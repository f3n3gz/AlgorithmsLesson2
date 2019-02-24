package Sorting;

import java.util.ArrayList;

public class InsertionSort {
    public static <E extends Comparable<E>> ArrayList<E> sort(ArrayList<E> arrayList) {
        for (int i = 1; i < arrayList.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arrayList.get(j + 1).compareTo(arrayList.get(j)) < 0) {
                    E temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                } else {
                    break;
                }
            }
        }
        return arrayList;
    }


}
