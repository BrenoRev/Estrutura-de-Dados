package Main;

public class BST<E, V> implements IBST<E, V> {
    private BSTNode<E, V> root;
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
        if (rt == null) {
            return null;
        }

        if (Integer.parseInt(rt.getKey().toString()) > Integer.parseInt(key.toString())) {
            return this.findHelp(rt.getLeft(), key);
        } else if (rt.getKey() == key) {
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
        if (rt == null) {
            return new BSTNode<>(key, value);
        }

        int binaryKeyValue = Integer.parseInt(rt.getKey().toString());
        int keyValue = Integer.parseInt(key.toString());

        if (binaryKeyValue > keyValue) {
            rt.setLeft(insertHelp(rt.getLeft(), key, value));
        } else {
            rt.setRight(insertHelp(rt.getRight(), key, value));
        }

        rt.setHeight(1 + Math.max(height(rt.getLeft()), height(rt.getRight()))); 
        
        int balance = getBalance(rt);
        if(balance < -1 && balance > (int) rt.getRight().getKey()) {
            return leftRotate(rt);
        }

        if(balance > 1 && (int) key < (int) rt.getLeft().getKey()) {
            return rightRotate(rt);
        }

        if(balance > 1 && (int) key >= (int) rt.getLeft().getKey()) {
            rt.setLeft(rightRotate(rt.getRight()));
            return leftRotate(rt);
        }

        return rt;
    }

    public int getBalance(BSTNode<E, V> rt) {
        if (rt == null) {
            return 0;
        }
        return height(rt.getLeft()) - height(rt.getRight());
    }

    private int height(BSTNode<E, V> rt) {
        if (rt == null) {
            return -1;
        }
        return rt.getHeight();
    }

    public BSTNode<E, V> rightRotate(BSTNode<E, V> rt) {
        BSTNode<E, V> left = rt.getLeft();
        BSTNode<E, V> leftRight = left.getRight();
        left.setRight(rt);
        rt.setLeft(leftRight);
        rt.setHeight(1 + Math.max(height(rt.getLeft()), height(rt.getRight())));
        left.setHeight(1 + Math.max(height(left.getLeft()), height(left.getRight())));
        return left;
    }

    public BSTNode<E, V> leftRotate(BSTNode<E, V> rt) {
        BSTNode<E, V> right = rt.getRight();
        BSTNode<E, V> rightLeft = right.getLeft();
        right.setLeft(rt);
        rt.setRight(rightLeft);
        rt.setHeight(1 + Math.max(height(rt.getLeft()), height(rt.getRight())));
        right.setHeight(1 + Math.max(height(right.getLeft()), height(right.getRight())));
        return right;
    }

    @Override
    public V remove(BST<E, V> bst, E key) {
        V temporary = findHelp(bst.root, key);
        if (temporary != null) {
            bst.root = removeHelp(bst.root, key);
            this.nodeCount--;
        }
        return temporary;
    }

    @Override
    public BSTNode<E, V> removeHelp(BSTNode<E, V> rt, E key) {

        if (rt != null) {
            int binaryKeyValue = Integer.parseInt(rt.getKey().toString());
            int keyValue = Integer.parseInt(key.toString());
            if (binaryKeyValue > keyValue) {
                rt.setLeft(removeHelp(rt.getLeft(), key));
            } else if (binaryKeyValue < keyValue) {
                rt.setRight(removeHelp(rt.getRight(), key));
            } else {
                if (rt.getLeft() == null) {
                    return rt.getRight();
                } else if (rt.getRight() == null) {
                    return rt.getLeft();
                } else {
                    BSTNode<E, V> temporary = getMin(rt.getRight());
                    rt.setElement(temporary.getElement());
                    rt.setKey(temporary.getKey());
                    rt.setRight(deleteMin(rt.getRight()));
                }
            }
        }
        return rt;

    }

    @Override
    public BSTNode<E, V> deleteMin(BSTNode<E, V> rt) {
        if (rt.getLeft() == null) {
            return rt;
        }

        return getMin(rt.getLeft());
    }

    @Override
    public void preOrder(BSTNode<E, V> rt) {
        if (rt != null) {
            System.out.print(rt.getElement() + " ");
            preOrder(rt.getLeft());
            preOrder(rt.getRight());
        }
    }

    @Override
    public void inOrder(BSTNode<E, V> rt) {
        if (rt != null) {
            inOrder(rt.getLeft());
            System.out.print(rt.getElement() + " ");
            inOrder(rt.getRight());
        }
    }

    @Override
    public void postOrder(BSTNode<E, V> rt) {
        if (rt != null) {
            postOrder(rt.getLeft());
            postOrder(rt.getRight());
            System.out.print(rt.getElement() + " ");
        }
    }

    @Override
    public BSTNode<E, V> getMin(BSTNode<E, V> rt) {
        if (rt.getLeft() == null) {
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
