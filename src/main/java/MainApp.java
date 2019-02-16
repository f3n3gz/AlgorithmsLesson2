import java.util.ArrayList;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        final int BOUND=1_000_000;
        int[] array=new int[BOUND];
        Random random=new Random();
        for (int i = 0; i < array.length; i++) {
            array[i]=random.nextInt(BOUND);
        }
    }
}
