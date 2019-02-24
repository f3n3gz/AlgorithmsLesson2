import Deck.DeckImpl;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class DeckTest {
    @Test
    public void DeckTest() {
        DeckImpl deck = new DeckImpl(3);
        deck.insertLeft(1);
        deck.insertLeft(2);
        Assert.assertThat(deck.size(), Is.is(2));
        Assert.assertThat(deck.peekRight(), Is.is(1));
        Assert.assertThat(deck.size(), Is.is(2));
        Assert.assertThat(deck.removeRight(), Is.is(1));
        Assert.assertThat(deck.peekRight(), Is.is(2));
        Assert.assertThat(deck.peekLeft(), Is.is(2));
        Assert.assertThat(deck.removeLeft(), Is.is(2));
        Assert.assertThat(deck.size(), Is.is(0));

        deck.insertRight(3);
        deck.insertRight(5);
        Assert.assertThat(deck.peekRight(), Is.is(5));
        Assert.assertThat(deck.size(), Is.is(2));
        Assert.assertThat(deck.removeLeft(), Is.is(3));
        Assert.assertThat(deck.removeRight(), Is.is(5));
        Assert.assertThat(deck.size(), Is.is(0));
    }
}
