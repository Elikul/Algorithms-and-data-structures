import java.util.LinkedList;

public class ChainingHashMap {

    private LinkedList<Item>[] hashArr;
    private int size;

    public ChainingHashMap(int size) {
        this.size = size;
        this.hashArr = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashArr[i] = new LinkedList<>();
        }
    }

    public boolean put(Item item) {
        int hashValue = hashFunc(item);
        return hashArr[hashValue].add(item);
    }

    public boolean remove(Item item) {
        int hashValue = hashFunc(item);
        return hashArr[hashValue].remove(item);
    }

    public void display() {
        System.out.println("-----------");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d - %s", i, hashArr[i]);
            System.out.println();
        }
        System.out.println("-----------");

    }

    public Item findKey(int id) {
        int hashValue = hashFunc(id);
        for (Item item : hashArr[hashValue]) {
            System.out.println(" - " + item.getValue());
            if (item.getKey() == id) {
                return item;
            }
        }
        return null;
    }

    public int getSize() {
        int i = 0;
        for (LinkedList<Item> items : hashArr) {
            if (!items.isEmpty()) {
                for (int j = 0; j < items.size(); j++) {
                    i++;
                }
            }
        }
        return i;
    }

    private int hashFunc(Item item) {
        return hashFunc(item.hashCode());
    }

    private int hashFunc(int _key) {
        return _key % size;
    }

    private String hashFunc(String _value) {
        return _value;
    }
}
