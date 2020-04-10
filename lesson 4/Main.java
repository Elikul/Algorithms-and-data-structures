/**
 * тестируем списки
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Проверка связнного списка:");
        testLinkedList();
        System.out.println();

        System.out.println("Проверка связнного стека:");
        testLinkedStack();
        System.out.println();

        System.out.println("Проверка связнной очереди:");
        testLinkedQueue();
        System.out.println();

    }

    private static void testLinkedList(){
        //LinkedList<Integer> ll = new SimpleLinkedList<>();
        TwoSideLinkedList<Integer> ll = new TwoSideLinkedList<>();

        ll.insertFirst(10);
        ll.insertFirst(20);
        ll.insertFirst(30);

        ll.display();

        System.out.println("Find 20: " + ll.contains(20));

        ll.removeFirst();
        ll.remove(10);

        ll.display();
    }

    private static void testLinkedStack(){
        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(12);
        stack.push(13);
        stack.push(14);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private static void testLinkedQueue(){
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        queue.insert(45);
        queue.insert(55);
        queue.insert(65);

        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue peek: " + queue.peek());

        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }
    }

}
