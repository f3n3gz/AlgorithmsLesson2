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

    public static <E> ArrayList<E> removeFirstAccure(ArrayList<E> array, E element) {

        int index;
        for (index = 0; index < array.size(); index++) {
            if (array.get(index) == element) {
                break;
            }
        }
        int arraySize = array.size();
        for (int i = index; i < arraySize; i++) {
            array.set(i, array.get(i + 1));
        }

        return array;
    }

    public static <E> int search(ArrayList<E> array, E element) {
        return 1;
    }
}
