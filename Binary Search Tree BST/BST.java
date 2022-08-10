package Main;

public class BST<E, V> implements IBST<E, V> {
    private BSTNode<E,V> root;
    private int nodeCount;

    public BST() {
        this.root = null;
        this.nodeCount = 0;
    }

    @Override
    public V find(BST<E, V> bst, E key) {
        return findHelp(bst.root, key);
    }

    @Override
    public V findHelp(BSTNode<E, V> rt, E key) {
       if(rt == null) {
           return null;
       }

        if(Integer.parseInt(this.root.getKey().toString()) > Integer.parseInt(key.toString())) {
            return this.findHelp(rt.getLeft(), key);
       }
       else if(rt.getKey() == key) {
           return rt.getElement();
       } else {
           return findHelp(rt.getRight(), key);
       }
    }

    @Override
    public void insert(BST<E, V> bst, E key, V value) {
        this.setRoot(insertHelp(bst.root, key, value));
        this.nodeCount++;
    }

    @Override
    public BSTNode<E, V> insertHelp(BSTNode<E, V> rt, E key, V value) {
        if(rt == null) {
            return new BSTNode<>(key, value);
        }

        if(Integer.parseInt(rt.getKey().toString()) > Integer.parseInt(key.toString())) {
            rt.setLeft(insertHelp(rt.getLeft(), key, value));
        } else {
            rt.setRight(insertHelp(rt.getRight(), key, value));
        }

        return rt;
    }

    @Override
    public V remove(BST<E, V> bst, E key) {
        V temporary = findHelp(bst.root, key);
        if(temporary != null) {
            bst.root = removeHelp(bst.root, key);
            this.nodeCount--;
        }
        return temporary;
    }

    @Override
    public BSTNode<E, V> removeHelp(BSTNode<E, V> rt, E key) {
        if(rt == null) {
            return null;
        }

        if(Integer.parseInt(this.root.getKey().toString()) > Integer.parseInt(key.toString())) {
            rt.setLeft(removeHelp(rt.getLeft(), key));
        }
        else if(Integer.parseInt(this.root.getKey().toString()) < Integer.parseInt(key.toString())) {
            rt.setRight(removeHelp(rt.getRight(), key));
        } else {
          if(rt.getLeft() == null) {
              return rt.getRight();
          } else if(rt.getRight() == null) {
              return rt.getLeft();
          } else {
              BSTNode<E, V> temporary = getMin(rt.getRight());
              rt.setElement(temporary.getElement());
              rt.setKey(temporary.getKey());
              rt.setRight(deleteMin(rt.getRight()));
          }
        }

        return rt;
    }

    @Override
    public BSTNode<E, V> deleteMin(BSTNode<E, V> rt) {
        if(rt.getLeft() == null) {
            return rt;
        }

        return getMin(rt.getLeft());
    }

    @Override
    public void preOrder(BSTNode<E, V> rt) {
        if(rt != null) {
            //  imprima os números armazenados na árvore, na ordem em que foram visitados, separados por espaço;
            preOrder(rt.getLeft());
            preOrder(rt.getRight());
        }
    }

    @Override
    public void inOrder(BSTNode<E, V> rt) {
        if(rt != null) {
            //  imprima os números armazenados na árvore, na ordem em que foram visitados, separados por espaço.
            System.out.println(root.getKey());
            inOrder(rt.getLeft());
            inOrder(rt.getRight());
        }
    }

    @Override
    public void posOrder(BSTNode<E, V> rt) {
        if(rt != null) {
            //  imprima os números armazenados na árvore, na ordem em que foram visitados, separados por espaço.
            posOrder(rt.getLeft());
            posOrder(rt.getRight());
        }
    }

    @Override
    public BSTNode<E, V> getMin(BSTNode<E, V> rt) {
        if(rt.getLeft() == null) {
            return rt.getRight();
        }

        rt.setLeft(deleteMin(rt.getLeft()));

        return rt;
    }

    public BSTNode<E, V> getRoot() {
        return root;
    }

    public void setRoot(BSTNode<E, V> root) {
        this.root = root;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }
}
