package bag;

import java.util.ArrayList;
import java.util.Arrays;

public class Bag {
    private int weight;
    private Entity[] items;
    private int nod;

    public Bag(int weight, Entity... items) {
        this.weight = weight;
        this.nod = weight;
        //Arrays.sort(items);
        this.items = items;
    }

    public void showBestCombo() {
        ArrayList<Entity> bestCombo = getBestCombo();
        for (Entity entity : bestCombo) {
            System.out.println(entity);
        }
        System.out.println("Overall price " + getNodePrice(bestCombo));
    }

    private ArrayList<Entity> getBestCombo() {
        calculateNOD();
        int k = this.weight / nod;
        ArrayList[][] matrix = new ArrayList[items.length][k];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < k; j++) {
                matrix[i][j] = new ArrayList();
            }
        }
        //заполянем первую строчку, чтобы не делать проверку на выход за гранцы массива в следующем цикле
        //заполняем ценой первого предмета, если он может поместится в заданном размере сумки (i+1)*k
        for (int i = 0; i < k; i++) {
            Entity firstItem = items[0];
            if (firstItem.getWeight() <= (nod * (i + 1))) {
                matrix[0][i].add(firstItem);
            }
        }
        for (int i = 1; i < items.length; i++) {
            Entity item = items[i];
            for (int j = 0; j < k; j++) {
                ArrayList preventNode = matrix[i - 1][j];
                // если предмет может поместится в заданном объеме, то выбираем между предыдущим максимумом цены
                // по данному объему и ценой текущего предмета + максимум по оставшемуся объему
                if (item.getWeight() <= nod * (j + 1)) {
                    ArrayList potentialNode = new ArrayList();
                    potentialNode.add(item);
                    if (((j + 1) * nod) - item.getWeight() > 0) {
                        potentialNode.addAll(matrix[i - 1][((j + 1) * nod - item.getWeight()) / nod - 1]);
                    }
                    matrix[i][j] = getNodePrice(preventNode) > getNodePrice(potentialNode) ? new ArrayList(preventNode) : new ArrayList(potentialNode);
                    } else {
                    matrix[i][j] = new ArrayList(preventNode);
                }
            }
        }
        return matrix[items.length - 1][k - 1];
    }

    private int getNodePrice(ArrayList<Entity> list) {
        if (list.size() == 0) {
            return 0;
        } else {
            int result = 0;
            for (Entity entity : list) {
                result += entity.getPrice();
            }
            return result;
        }
    }

    private void calculateNOD() {
        //вычисляем минимальную кратность веса
        if (items.length > 1) {
            for (Entity item : items) {
                int a = nod;
                int b = item.getWeight();
                int temp;
                while (a % b != 0) {
                    temp = b;
                    b = a % b;
                    a = temp;
                }
                nod = b;
            }

        } else {
            nod = items[0].getWeight();
        }
    }
}
