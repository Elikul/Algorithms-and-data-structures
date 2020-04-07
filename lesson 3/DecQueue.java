/**
 * Дек
 */
public class DecQueue {
    private int size; //размер дека
    private int[] dec; //сам дек
    private int front; //маркер начала дека
    private int end; //маркер конца дека

    //конструктор
    public DecQueue(int size){
        this.size = size;
        this.dec = new int[size];
        this.front = -1;
        this.end = size - 1;
    }

    //проверка на переполнение начала дека
    public boolean isFullFront(){
        return front == size - 1;
    }

    //проверка на переполнение конца дека
    public boolean isFullEnd(){
        return  end == size;
    }

    //проверка на пустоту начала дека
    public boolean isEmptyFront(){
        return front == front - 1;
    }


    //проверка на пустоту конца дека
    public boolean isEmptyEnd(){
        return end == end - 1;
    }

    //вставка элемента в начало дека
    public boolean insertFront(int i){
        if (isFullFront()) return false;
        dec[++front] = i;
        return true;
    }

    //вставка элемента в конец дека
    public boolean insertEnd(int i) {
        if (isFullEnd()) {
            size *= 2;
            int[] temp = new int[size];
            if (end >= front) {
                System.arraycopy(dec, 0, temp, 0, dec.length);
            } else {
                System.arraycopy(dec, 0, temp, 0, end + 1);
                System.arraycopy(dec, front, temp,
                        size - (dec.length - front),
                        dec.length - front - 1);
                front = size - front - 1;
            }
            dec = temp;
        }
        if (end == size - 1)
            end = -1;
        dec[++end] = i;
        return true;
    }

    //удалить элемент из начала дека
    public int removeFront(){
        if (isEmptyFront()) throw new RuntimeException("empty");
        return dec[front--];
    }

    //удалить элемент из конца дека
    public int removeEnd(){
        if (isEmptyEnd()) throw new RuntimeException("empty");
        return dec[end--];
    }
}
