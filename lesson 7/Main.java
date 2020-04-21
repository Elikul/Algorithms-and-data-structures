import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орёл");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва","Тула");
        graph.addEdge("Москва","Рязань");
        graph.addEdge("Москва","Калуга");
        graph.addEdge("Тула","Липецк");
        graph.addEdge("Липецк","Воронеж");
        graph.addEdge("Рязань","Тамбов");
        graph.addEdge("Тамбов","Саратов");
        graph.addEdge("Саратов","Воронеж");
        graph.addEdge("Калуга","Орёл");
        graph.addEdge("Орёл","Курск");
        graph.addEdge("Курск","Воронеж");


        Stack<String> path = graph.shortPath("Москва","Воронеж");
        System.out.println("Короткий путь от Москвы до Воронежа: ");
        showPath(path);




    }

    private static void showPath(Stack<String> path) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        int lenght = 0;

        while ( !path.isEmpty() ) {
            if (!isFirst) {
                sb.append(" -> ");
            }
            isFirst = false;
            sb.append(path.pop());
            lenght++;
        }
        System.out.println(sb);
        System.out.println("Путь составляет - " + lenght + " вершин");
    }

}
