import LinkedList.TwoSide.LinkedQueueImpl;
import LinkedList.TwoSide.StackLinkedList;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class LinkedQueueTest {
    @Test
    public void LinkedQueueTest() {
        LinkedQueueImpl<Integer> queue = new LinkedQueueImpl<>();
        Assert.assertThat(queue.isEmpty(), Is.is(true));
        Assert.assertThat(queue.isFull(), Is.is(false));
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        Assert.assertThat(queue.isEmpty(), Is.is(false));
        Assert.assertThat(queue.isFull(), Is.is(false));
        Assert.assertThat(queue.size(), Is.is(6));
        Assert.assertThat(queue.peek(), Is.is(6));
        Assert.assertThat(queue.size(), Is.is(6));
        Assert.assertThat(queue.remove(), Is.is(6));
        Assert.assertThat(queue.remove(), Is.is(5));
        Assert.assertThat(queue.size(), Is.is(4));
    }
}
