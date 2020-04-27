public class Main {
    public static void main(String[] args) {
        ChainingHashMap hashTable = new ChainingHashMap(7);
        Item item1 = new Item(15, "Book");
        Item item2 = new Item(21, "Magazine");
        Item item3 = new Item(8, "Literature");

        hashTable.put(item1);
        hashTable.put(item2);
        hashTable.put(item3);

        System.out.println("After insert:");
        hashTable.display();

        System.out.println("After remove:");
        hashTable.remove(item1);
        hashTable.display();

        System.out.println("Find Magazine: " + hashTable.findKey(item2.getKey()));


    }
}
