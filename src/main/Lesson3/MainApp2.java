import Deck.DeckImpl;

public class MainApp2 {
    public static void main(String[] args) {
        String s = "Мама пилорама";
        System.out.println(s);
        DeckImpl deck = new DeckImpl(s.length());
        for (int i = 0; i < s.length(); i++) {
            deck.insertRight(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.print(deck.removeRight());
        }
    }
}
