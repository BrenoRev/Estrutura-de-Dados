package Binary_Search_Tree_BST;

public interface IBST<E, V> {
    V find(BST<E, V> bst, E key);

    V findHelp(BSTNode<E, V> bst, E key);

    void insert(BST<E, V> rt, E key, V value);

    BSTNode<E, V> insertHelp(BSTNode<E, V> rt, E key, V value);

    V remove(BST<E, V> bst, E key);

    BSTNode<E, V> removeHelp(BSTNode<E, V> rt, E key);

    BSTNode<E, V> getMin(BSTNode<E, V> rt);

    BSTNode<E, V> deleteMin(BSTNode<E, V> rt);

    void preOrder(BSTNode<E, V> rt);

    void inOrder(BSTNode<E, V> rt);

    void postOrder(BSTNode<E, V> rt);

}
