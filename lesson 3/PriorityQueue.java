/**
 * очередь с приоритетом
 */
public class PriorityQueue {
    private int size; //размер очереди
    private int [] queueArray; //сама очередь с приоритетом
    private int items; //количество элементов в очереди

    //конструктор
    public PriorityQueue(int s){
        size = s;
        queueArray = new int[s];
        items = 0;
    }

    //вставка элемента
    public void insert(int item){
        if (isFull()) {
            throw new RuntimeException("Priority Queue is full");
        }
        int i;
        if ( items == 0 )
            queueArray [ items ++] = item;
        else{
            for ( i = items - 1 ; i >= 0 ; i --){
                if ( item > queueArray [ i ] )
                    queueArray [ i + 1 ] = queueArray [ i ];
                else
                    break;
            }
            queueArray [ i + 1 ] = item ; // Вставка элемента
            items ++;
        }
    }

    //удаляем элемент
    public int remove(){
        return queueArray [-- items ];
    }

    public long peek(){
        return queueArray [ items - 1 ];
    }

    //проверка очереди на пустоту
    public boolean isEmpty(){
        return ( items == 0 );
    }

    //проверка очереди на преполнение
    public boolean isFull (){
        return ( items == size );
    }

    //возращаем размер очереди
    public int size(){
        return items;
    }

}
