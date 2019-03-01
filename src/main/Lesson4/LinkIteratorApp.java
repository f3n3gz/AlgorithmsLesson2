import LinkedList.LinkedListImpl;
import LinkedList.LinkedListIterator;

import java.util.Iterator;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedListImpl<Integer> list = new LinkedList.LinkedListImpl<Integer>();
        list.insert(1);
        list.insert(2);
        list.insert(4);
        list.insert(6);
        list.forEach(System.out::println);
        LinkedListIterator<Integer> iterator = (LinkedListIterator<Integer>) list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            if (iterator.getCurrent() == 2) {
                iterator.insertBefore(3);
            }
            if (iterator.getCurrent() == 6) {
                iterator.insertAfter(5);
            }
        }
        System.out.println("At end :" + iterator.atEnd());
        System.out.println("--------");
        list.forEach(integer -> System.out.println(integer));
        iterator.reset();
        while (iterator.hasNext()) {
            iterator.next();
            if (iterator.getCurrent() == 3 || iterator.getCurrent() == 5) {
                iterator.deleteCurrent();
            }
        }
        System.out.println("--------");
        iterator.reset();
        System.out.println("At end :" + iterator.atEnd());
        while (iterator.hasNext()) {
            iterator.nextLink();
            System.out.println(iterator.getCurrent());
        }
    }
}
