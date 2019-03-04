package bag;

import java.io.StringReader;
import java.util.Arrays;

public class Bag {
    int weight;
    Entity[] items;
    int nod;

    public Bag(int weight, Entity... items) {
        this.weight = weight;
        Arrays.sort(items);
        this.items = items;
    }

    public void showBestCombo() {
        calculateBestCombo();
    }

    private Entity[] calculateBestCombo() {
        calculateNOD();
        int k = this.weight / nod;
        double[][] matrix = new double[items.length][k];
        //заполянем первую строчку, чтобы не делать проверку на выход за гранцы массива в следующем цикле
        //заполняем ценой первого предмета, если он может поместится в заданном размере сумки i*k
        for (int i = 0; i < k; i++) {
            Entity firstItem = items[0];
            matrix[0][i] = firstItem.getWeight() <= (nod * (i + 1)) ? firstItem.getPrice() : 0;
        }
        for (int i = 1; i < items.length; i++) {
            Entity item = items[i];
            for (int j = 0; j < k; j++) {
                try {
                    if (item.getWeight() < nod * (j + 1)) {
                        matrix[i][j] = Math.max(matrix[i - 1][j], item.getPrice() + matrix[i - 1][(j - item.getWeight()) < 0 ? 0 : j - item.getWeight()]);
                    } else if (item.getWeight() == nod * (j + 1)) {
                        matrix[i][j] = Math.max(matrix[i - 1][j], item.getPrice());
                    } else {
                        matrix[i][j] = matrix[i - 1][j];
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("item.weight " + item.getWeight() + " j " + j);
                    throw e;
                }
            }
        }
        return new Entity[]{};
    }

    private void calculateNOD() {
        //вычисляем минимальную кратность веса
        if (items.length > 1) {
            for (int i = 0; i < items.length - 1; i++) {
                int a = items[i].getWeight();
                int b = items[i + 1].getWeight();
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
