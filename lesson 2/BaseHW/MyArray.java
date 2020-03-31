package BaseHW;

/**
 * Класс массив
 */
public class MyArray {
    private int[] arr; //сам массив
    private int size; // размер массива

    //конструктор
    public MyArray(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public int[] getArr() {
        return arr;
    }

    public int getSize() {
        return size;
    }

    //двоичный поиск по массиву
    public boolean binaryFind(int value){
        int low = 0;
        int high = this.size - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (value == this.arr[mid]) {
                return true;
            } else {
                if (value < this.arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    //поиск элемента в массиве
    public boolean find(int value) {
        int i;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    //вывод элементов массива на экран
    public void show() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.arr[i]);
        }
    }

    //удаление элемента из массива
    public void delete(int value){
        int i = 0;
        for(i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                break;
            }
        }

        for (int j = i; j < this.size - 1; j++){
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;
    }

    //удаление всех элементов из массива
    public boolean deleteAll() {
        for (int i = 0; i < size ; i++) {
            size = i--;
        }
        return true;
    }

    //добавление элемента в массив
    public void insert(int value){
        int i;
        for(i = 0; i < this.size; i++) {
            if (this.arr[i]>value) {
                break;
            }
        }
        for (int j = this.size; j > i; j--){
            this.arr[j] = this.arr[j-1];
        }
        this.arr[i] = value;
        this.size++;
    }

}