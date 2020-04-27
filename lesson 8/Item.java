import java.util.Objects;

public class Item {

    private  int key;
    private  String value;

    public Item(int _key, String _value) {
        this.key = _key;
        this.value = _value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        if (key != item.key) {
            return false;
        }
        return Objects.equals(value, item.value);
    }

    @Override
    public int hashCode() {
        return key;
        //return Objects.hash(id);
    }
}
