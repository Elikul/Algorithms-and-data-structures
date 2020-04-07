public class Main {
    public static void main(String[] args) {
        //проверка скобочной структуры
        String input = "(1+2)-[2+{89*54}/3]";
        Bracket br = new Bracket(input);
        System.out.println(br.check());

        //проверка очереди
        MyQueue q = new MyQueue(5);
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);

        while (!q.isEmpty()) {
            int n = q.remove();
            System.out.println(n);
        }

        //проверка очереди с приоритетом
        PriorityQueue pQ = new PriorityQueue(5);
        pQ.insert(3);
        pQ.insert(5);
        pQ.insert(1);
        pQ.insert(4);
        pQ.insert(2);
        while (!pQ.isEmpty()) {
            int item = pQ.remove();
            System.out.print(item + " ");
        }
        System.out.println("");


        String str = "func trio";
        System.out.println( reverse(str));


    }

    //переворачивает вводимые строки (читает справа налево)
    public static String reverse(String str){
        MyStack stack = new MyStack(str.length());

        StringBuilder reversed = new StringBuilder();

        for (int i = 0; i < str.length() ; i++) {
            char ch = str.charAt(i);
            stack.push(ch);
        }

        for (int i = 0; i < str.length() ; i++) {
            char ch =(char)stack.pop();

            reversed.append(ch);
        }
        return reversed.toString();
    }
}
