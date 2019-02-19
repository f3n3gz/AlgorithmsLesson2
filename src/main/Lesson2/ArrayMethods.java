import java.util.ArrayList;

public class ArrayMethods {
    public static <E> ArrayList<E> add(ArrayList<E> array, E element, int index) {
        if (index < 0 || index > array.size() - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = array.size() - 1; i > index; i--) {
            array.set(i + 1, array.get(i));
        }
        array.set(index, element);
        return array;
    }

    public static <E> ArrayList<E> removeFirstOccurenceByIndex(ArrayList<E> array, int index) {
        if (index < 0 || index >= array.size()) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        int arraySize = array.size();
        for (int i = index; i < arraySize; i++) {
            array.set(i, array.get(i + 1));
        }
        array.set(arraySize, null);

        return array;
    }

    public static <E extends Comparable<E>> ArrayList<E> removeFirstOccurenceByValue(ArrayList<E> array, E element) {
        return removeFirstOccurenceByIndex(array, search(array, element));
    }

    public static <E extends Comparable<E>> int search(ArrayList<E> array, E element) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(element)) {
                return i;
            }
        }
        return -1;
    }
}
