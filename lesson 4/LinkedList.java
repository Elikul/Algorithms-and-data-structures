/**
 * интерфейс связнного списка
 * @param <Item>
 */
public interface LinkedList<Item> {

    //добавление элемнта в начало связнного список
    void insertFirst(Item value);

    //добавление элемнта в конец связнного список
    void insertLast(Item value);

    //удвление элемента из начала связнного список
    Item removeFirst();

    //удаление элемента
    boolean remove(Item value);

    //поиск элемента
    boolean contains(Item value);

    //проверка на пустоту
    boolean isEmpty();

    //размер связнного списка
    int size();

    //вывод на экран связнного список
    void display();

    //получение значания первого элемента
    Item getFirstElement();

    //получение первого узла связнного списка
    Node getFirst();

    //узел связнного списка
    class Node<Item> {
        public final Item value; //данные
        public Node<Item> next; //ссылка на следующий узел

        //конструктор
        public Node(Item value) {
            this.value = value;
        }
    }
}
