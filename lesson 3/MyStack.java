import java.util.EmptyStackException;

/**
 * Стек
 */
public class MyStack {
    private int size; //размер стека
    private int[] stack; //сам стэк
    private int top; //вершина стека

    //конструктор
    public MyStack(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    //проверка стека на пустоту
    public boolean isEmpty() {
        return top == -1;
    }

    //проверка стека на полноту
    public boolean isFull() {
        return top == size - 1;
    }

    //добавляем элемент в стек
    public boolean push(int i) {
        if (isFull()) return false;
        stack[++top] = i;
        return true;
    }

    //удаляем элемент из стека
    public int pop() {
        if (isEmpty()){
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        return stack[top--];
    }

    //получаем элемент
    public int peek() {
        if (isEmpty()){
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        return stack[top];
    }
}
