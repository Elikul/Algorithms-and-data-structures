import java.util.Stack;

/**
 *Дерево
 * @param <Item>
 */
public class MyTree<Item extends Comparable<? super Item>> {

    //перемещения
    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER,
    }


    private Node<Item> root; //корень
    private int size; //размер дерева
    private int maxDeep; //глубина дерева

    //класс текущий узел и его родитель
    private  class NodeAndParent{
        Node<Item> current; //текущий узел
        Node<Item> parent; //родитель

        public NodeAndParent(Node<Item> _current, Node<Item> _parent){
            this.current = _current;
            this.parent = _parent;
        }
    }

    public MyTree(int _maxDeep){
        this.maxDeep = _maxDeep;
    }

    public  boolean isEmpty(){
        return root == null;
    }

    public  int size(){
        return size;
    }


    //поиск текущего узла и ео родителя
    private NodeAndParent Search(Item value){
        Node<Item> current = this.root;
        Node<Item> parent = null;

        current.setDeepOfTree(1);

        while (current != null){
            if(parent != null){
                current.setDeepOfTree(parent.getDeepOfTree() + 1);
            }

            if(current.getValue().equals(value)){
                return new NodeAndParent(current, parent);
            }

            parent = current;
            if(current.isToLeft(value)){
                current = current.getLeftChild();
            }else{
                current = current.getRightChild();
            }
        }

        return new NodeAndParent(null, parent);
    }


    //вставить новый узел в дерево
    public boolean insert(Item value){
        Node<Item> newNode = new Node<>(value);
        if(isEmpty()){
            this.root = newNode;
            return true;
        }

        NodeAndParent nodeAndParent = Search(value);
        if(nodeAndParent.current != null){
            return false;
        }

        Node<Item>  parent = nodeAndParent.parent;

        assert parent != null;

        int deep = parent.getDeepOfTree() + 1;
        if(deep > maxDeep){
            return false;
        }

        if(parent.isToLeft(value)){
            parent.setLeftChild(newNode);
        }else{
            parent.setRightChild(newNode);
        }

        size++;
        return true;
    }

    //поиск по дереву
    public boolean find(Item value){
        return Search(value).current != null;
    }

    //получить потомков
    private Node<Item> getSuccessor(Node<Item> node){
        Node<Item> successor = node;
        Node<Item> successorParent = null;
        Node<Item> current = node.getRightChild();

        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if(successor != node.getRightChild()){
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }

        return successor;
    }


    //удаление узла из дерева. который имеет и правого и левого потомка
    private void removeNode(Node<Item> parent, Node<Item> removedNode){
        Node<Item> successor = getSuccessor(removedNode);

        if(removedNode == root){
            root = successor;
        }else if(parent.isToLeft(removedNode.getValue())){
            parent.setLeftChild(successor);
        }else{
            parent.setRightChild(successor);
        }

        successor.setLeftChild(removedNode.getLeftChild());
    }

    //удаление узла из дерева, который имеет либо только правого, либо только левого потомка
    private void removeNodeWithSingleChild(Node<Item> parent, Node<Item> removedNode){
        Node<Item> childNode = removedNode.getLeftChild() != null ? removedNode.getLeftChild() : removedNode.getRightChild();

        if(removedNode == root){
            root = childNode;
        }else if(parent.isToLeft(removedNode.getValue())){
            parent.setLeftChild(childNode);
        }else {
            parent.setRightChild(childNode);
        }
    }

    //удаление узла из дерева, который не имеет потомков
    private void removeLeaf(Node<Item> parent, Node<Item> removeNode){
        if(removeNode == root){
            root = null;
        }else if(parent.isToLeft(removeNode.getValue())){
            parent.setLeftChild(null);
        }else{
            parent.setRightChild(null);
        }
    }

    //проверка, только ли один потомок
    private  boolean hasOnlySingleChild(Node<Item> node){
        return node.getLeftChild() != null ^ node.getRightChild() != null;
    }

    //удаление узла из дерева
    public boolean remove(Item value){
        NodeAndParent nodeAndParent = Search(value);
        Node<Item> parent = nodeAndParent.parent;
        Node<Item> removedNode = nodeAndParent.current;

        if(removedNode == null){
            return false;
        }

        if(removedNode.isLeaf()){
            removeLeaf(parent, removedNode);
        }else if(hasOnlySingleChild(removedNode)){
            removeNodeWithSingleChild(parent, removedNode);
        }else {
            removeNode(parent, removedNode);
        }

        size--;
        return true;
    }

    //отображение дерева на экране
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    //высота дерева
    private int height(Node node){
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    //проверка является ли дерево сбалансированным
    private boolean isBalanced(Node node){
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    //проверка является ли дерево сбалансированным
    public boolean isBalanced(){
        return isBalanced(root);
    }


    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown value: " + mode);
        }
    }

    private void postOrder(Node<Item> current) {
        if (current == null) {
            return;
        }
        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.println(current);
    }

    private void preOrder(Node<Item> current) {
        if (current == null) {
            return;
        }
        System.out.println(current);
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    private void inOrder(Node<Item> current) {
        if (current == null) {
            return;
        }
        inOrder(current.getLeftChild());
        System.out.println(current);
        inOrder(current.getRightChild());
    }

}
