/**
 * двунаправленный связный список
 * @param <Item>
 */
public class TwoSideLinkedList<Item> extends SimpleLinkedList<Item>implements LinkedList<Item> {

    private Node<Item> lastElement;

    @Override
    public void insertLast(Item value) {
        Node<Item> node = new Node<>(value);

        if(isEmpty()){
            firstElement = node;
        }else{
            lastElement.next = node;
        }
        lastElement = node;
        size++;
    }

    @Override
    public void insertFirst(Item value) {
        super.insertFirst(value);
        if(size() == 1){
            lastElement = firstElement;
        }
    }

    @Override
    public Item removeFirst() {
        Item element = super.removeFirst();
        if(isEmpty()){
            lastElement = null;
        }
        return element;
    }

    @Override
    public boolean remove(Item value) {
        Node<Item> previous = null;
        Node<Item> current = firstElement;

        while (current != null){
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
        }else if(current == lastElement){
            lastElement = previous;
            previous.next = null;
        }else {
            previous.next = current.next;
        }
        size--;
        return true;
    }
}
