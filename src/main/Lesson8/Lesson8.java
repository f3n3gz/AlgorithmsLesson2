import ru.f3n3gz.HashTable.HashTableImpl;

public class Lesson8 {
    public static void main(String[] args) {
        HashTableImpl<String, Integer> hashTable = new HashTableImpl<>(2);
        hashTable.put("Раз", 1);
        hashTable.put("Два", 2);
        hashTable.put("Три", 3);
        hashTable.put("Четыре", 4);
        hashTable.put("Пять", 5);

        System.out.println(hashTable.get("Раз"));
        hashTable.put("Раз", 11);
        System.out.println("Раз " + hashTable.get("Раз"));
        System.out.println("Три " + hashTable.get("Три"));
        System.out.println("Пять " + hashTable.get("Пять"));
        System.out.println("Size " + hashTable.getSize());
        System.out.println("Значение удаленного элмента с ключом Четыре = " + hashTable.remove("Четыре"));
        System.out.println("Size " + hashTable.getSize());
        hashTable.display();
    }
}
