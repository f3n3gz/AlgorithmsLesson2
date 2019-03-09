import ru.f3n3gz.Tree.Tree;
import ru.f3n3gz.Tree.TreeImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainApp6 {
    public static void main(String[] args) {
        int maxHeight = 4;
        int treeCount = 20;
        List<Tree<Integer>> treeList = new ArrayList<Tree<Integer>>();
        for (int i = 0; i < treeCount; i++) {
            treeList.add(new TreeImpl<>(maxHeight));
        }
        int balancedCount = 0;
        Random random = new Random();
        for (Tree<Integer> integerTree : treeList) {
            integerTree.add(0);
            for (int i = 0; i < 100000; i++) {
                integerTree.add(random.nextInt(40) - 20);
            }
            if (integerTree.isBalanced()) {
                balancedCount++;
            }
        }

        System.out.println("Percent of balanced Tree " + ((double) balancedCount / treeCount * 1d) * 100 + "%");
    }
}
