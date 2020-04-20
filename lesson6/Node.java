/**
 * Узел дерева
 * @param <Item>
 */
public class Node<Item extends Comparable<? super Item>> {
    private  Item value; //значение в узле
    private Node<Item> leftChild; //левый потомок
    private Node<Item> rightChild; //правый потомок

    private int deepOfTree; //глубина поддерева

    public Node(Item _value){
        this.value = _value;
    }

    public Item getValue(){
        return value;
    }

    public Node<Item> getLeftChild(){
        return leftChild;
    }

    public void setLeftChild(Node<Item> _leftChild){
        this.leftChild = _leftChild;
    }

    public Node<Item> getRightChild(){
        return rightChild;
    }

    public void setRightChild(Node<Item> _rightChild){
        this.rightChild = _rightChild;
    }

    //является ли листком (нет ни правых, ни левых потомков)
    public boolean isLeaf(){
        return getLeftChild() == null && getRightChild() == null;
    }

    public int getDeepOfTree(){
        return deepOfTree;
    }

    public void setDeepOfTree(int _deepOfTree){
        this.deepOfTree = _deepOfTree;
    }

    //следует ли двигаться в лево
    public boolean isToLeft(Item _value){
        return value.compareTo(getValue()) < 0;
    }

    @Override
    public String toString(){
        return "Node: value = " + value;
    }
}
