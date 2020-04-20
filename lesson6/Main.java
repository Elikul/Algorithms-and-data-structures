import java.util.Random;

public class Main {

    //значения рандомные  [-100,100]
    private static int randomValues(){
        return (int) (Math.random()*(200+1)) - 100;
    }


    public static void analysTree(int deep, int treeCount) {
        int balancedTreeCount = 0;
        int nodeCount = (int) (Math.pow(2, deep) - 1);
        for (int i = 0; i < treeCount; i++) {
            MyTree<Integer> tree = new MyTree<>(deep);
            for (int j = 0; j < nodeCount; j++) {
                tree.insert(randomValues());
            }
            if (tree.isBalanced()) {
                balancedTreeCount++;
            }
            tree.display();
        }
        System.out.println("Balanced tree count = " + ((balancedTreeCount / treeCount) * 100) + "%");
    }

    public static void main(String[] args) {
        int deep = 6;
        int treeCount = 20;
        analysTree(deep, treeCount);
    }


}
