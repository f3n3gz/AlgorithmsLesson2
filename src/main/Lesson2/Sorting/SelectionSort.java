package Sorting;

import java.util.ArrayList;

public class SelectionSort implements SortInterface {

    public static <E extends Comparable<E>> ArrayList<E> sort(ArrayList<E> arrayList) {

        for (int i = 1; i < arrayList.size(); i++) {
            E smallest = arrayList.get(i - 1);
            int smallestIndex = i - 1;

            for (int j = i; j < arrayList.size(); j++) {
                if (smallest.compareTo(arrayList.get(j)) > 0) {
                    smallest = arrayList.get(j);
                    smallestIndex = j;
                }
            }

            // если элементы первый элемент в итоге не равен наименьшему в неотсортированной части, то меняем
            if (!smallest.equals(arrayList.get(i - 1))) {
                E temp = arrayList.get(i - 1);
                arrayList.set(i - 1, smallest);
                arrayList.set(smallestIndex, temp);
            }
        }

        return arrayList;
    }
}
