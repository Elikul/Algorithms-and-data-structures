/**
 * очередь на базе связного списка
 * @param <Item>
 */
public class LinkedQueue<Item> {

    private TwoSideLinkedList<Item> queue = new TwoSideLinkedList<>();

    public boolean insert(Item value){
        queue.insertLast(value);
        return true;
    }

    public Item remove(){
        return queue.removeFirst();
    }

    public Item peek(){
        return queue.getFirstElement();
    }

    public int size(){
        return queue.size();
    }

    public  boolean isEmpty(){
        return queue.isEmpty();
    }
}
