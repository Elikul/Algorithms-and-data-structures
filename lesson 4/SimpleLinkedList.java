/**
 * связный список
 * @param <Item>
 */
public class SimpleLinkedList<Item> implements LinkedList<Item> {

    protected Node<Item> firstElement;
    protected int size;

    @Override
    public void insertFirst(Item value) {
        Node<Item> node = new Node<>(value);
        node.next = firstElement;
        firstElement = node;
        size++;
    }

    @Override
    public void insertLast(Item value) {

    }

    @Override
    public Item removeFirst() {
        if(isEmpty()){
            return null;
        }

        Item element = this.firstElement.value;
        firstElement = firstElement.next;
        size--;
        return element;
    }

    @Override
    public boolean remove(Item value) {
        Node<Item> previous = null;
        Node<Item> current = firstElement;

        while(current != null){
            if(current.value.equals(value)){
                break;
            }
            previous = current;
            current = current.next;
        }
        if(current == null){
            return false;
        }

        if(current == firstElement){
            firstElement = firstElement.next;
        }else{
            previous.next = current.next;
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(Item value) {
        Node<Item> current = firstElement;
        while (current != null){
            if(current.value.equals(value)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Node<Item> current = firstElement;
        while (current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    @Override
    public Item getFirstElement() {
        return firstElement.value;
    }

    @Override
    public Node getFirst() {
        return firstElement;
    }
}
