package Main;

public class BSTNode<E, V> {

    private E key;
    private V element;
    private BSTNode<E, V> left;
    private BSTNode<E, V> right;
    private int height;

    public BSTNode(E key, V value) {
        this.key = key;
        this.element = value;
        this.left = this.right = null;
        this.height = 0;
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public V getElement() {
        return element;
    }

    public void setElement(V element) {
        this.element = element;
    }

    public BSTNode<E, V> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<E, V> left) {
        this.left = left;
    }

    public BSTNode<E, V> getRight() {
        return right;
    }

    public void setRight(BSTNode<E, V> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    
}
