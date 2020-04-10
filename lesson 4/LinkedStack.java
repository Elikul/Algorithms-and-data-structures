/**
 * стек на базе связного списка
 * @param <Item>
 */
public class LinkedStack<Item>{

    private LinkedList<Item> stack = new SimpleLinkedList<>();

    public void push(Item value){
        stack.insertFirst(value);
    }

    public Item pop(){
        return stack.removeFirst();
    }

    public Item peek(){
        return stack.getFirstElement();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }


}
