import LinkedList.TwoSide.StackLinkedList;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class LinkedStackTest {
    StackLinkedList<Integer> stack = new StackLinkedList<Integer>(6);

    @Test
    public void LinkedStackTest() {
        Assert.assertThat(stack.isEmpty(), Is.is(true));
        Assert.assertThat(stack.isFull(), Is.is(false));
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        Assert.assertThat(stack.isEmpty(), Is.is(false));
        Assert.assertThat(stack.isFull(), Is.is(true));
        Assert.assertThat(stack.size(), Is.is(6));
        Assert.assertThat(stack.peek(), Is.is(6));
        Assert.assertThat(stack.pop(), Is.is(6));
        Assert.assertThat(stack.size(), Is.is(5));

    }

}
