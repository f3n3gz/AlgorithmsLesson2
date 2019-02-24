import Sorting.BubbleSort;
import Sorting.InsertionSort;
import Sorting.SelectionSort;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayMethodsTest {

    @Test
    public void ArrayAddTest() {
        ArrayImpl array = new ArrayImpl();
        array.add(1);
        array.add(2);
        Assert.assertThat(array.get(0), Is.is(1));
        Assert.assertThat(array.get(1), Is.is(2));
        Assert.assertThat(array.size(), Is.is(2));
    }

    @Test
    public void ArraySearchTest() {
        ArrayImpl array = new ArrayImpl();
        array.add(1);
        array.add(2);
        array.add(5);
        array.add(-5);
        Assert.assertThat(array.search(5), Is.is(2));
        Assert.assertThat(array.search(-5), Is.is(3));
        Assert.assertThat(array.search(1), Is.is(0));
    }

    @Test
    public void ArrayRemoveTest() {
        ArrayImpl array = new ArrayImpl();
        array.add(1);
        array.add(2);
        array.add(5);
        array.add(-5);
        array.removeByIndex(2);
        Assert.assertThat(array.size(), Is.is(3));
        Assert.assertThat(array.get(2), Is.is(-5));
    }

    @Test
    public void BubbleSortTest() {
        ArrayList unsortedArrayList = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));

        ArrayList sortedArrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Assert.assertArrayEquals(sortedArrayList.toArray(), BubbleSort.sort(unsortedArrayList).toArray());

    }

    @Test
    public void SelectiontSortTest() {
        ArrayList unsortedArrayList = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));

        ArrayList sortedArrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Assert.assertArrayEquals(sortedArrayList.toArray(), SelectionSort.sort(unsortedArrayList).toArray());

    }

    @Test
    public void InsertionSortTest() {
        ArrayList unsortedArrayList = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));

        ArrayList sortedArrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Assert.assertArrayEquals(sortedArrayList.toArray(), InsertionSort.sort(unsortedArrayList).toArray());

    }
}
