/**
 * Очередь
 */
public class MyQueue {
    private int size; //размер очереди
    private int[] queue; //сама очередь
    private int front; //маркер начала очереди
    private int end; //маркер конца очереди
    private int items; //количество элементов в очереди

    //конструктор
    public MyQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = 0;
        end = -1;
        items = 0;
    }

    //проверка очереди на пустоту
    public boolean isEmpty() {
        return items == 0;
    }

    //проверка очереди на переполнение
    public boolean isFull() {
        return items == size;
    }

    //возращаем размер очереди
    public int size() {
        return items;
    }

    //добавляем элемент
    public void insert(int i) {
        if (isFull()) {
            size *= 2;
            int[] temp = new int[size];
            if (end >= front) {
                System.arraycopy(queue, 0, temp, 0, queue.length);
            } else {
                System.arraycopy(queue, 0, temp, 0, end + 1);
                System.arraycopy(queue, front, temp,
                        size - (queue.length - front),
                        queue.length - front - 1);
                front = size - front - 1;
            }
            queue = temp;
        }
        if (end == size - 1)
            end = -1;
        queue[++end] = i;
        items++;
    }


    //удаляем элемент
    public int remove() {
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        int temp = queue[front++];
        front %= size;
        items--;
        return temp;
    }

    //получаем элемент
    public int peek() {
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return queue[front];
    }
}
