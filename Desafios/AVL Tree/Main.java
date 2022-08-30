

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) {
        // coded by
        // Breno Silva

        FastReader reader = new FastReader();
        BST avlTree = new BST();

        int operations = reader.nextInt();

        for(int index = 0; index < operations; index++) {
            int command = reader.nextInt();
            if(command == 1){
                int value = reader.nextInt();
                avlTree.insert(avlTree, value, value);
            }
            else if(command == 2){
                int findKey = reader.nextInt();
                Integer result = avlTree.find(avlTree, findKey);
                if(result == null) {
                    System.out.println("Data tidak ada");
                }
                else {
                    System.out.println(result);
                }
            }
        }
        
    }


static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    FastReader() {
        br = new BufferedReader(
                new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            if (st.hasMoreTokens()) {
                str = st.nextToken("\n");
            } else {
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

static class BSTNode {

    private Integer key;
    private Integer element;
    private BSTNode left;
    private BSTNode right;
    private int height;

    public BSTNode(Integer key, Integer value) {
        this.key = key;
        this.element = value;
        this.left = this.right = null;
        this.height = 0;
    }

    Integer getKey() {
        return key;
    }

    void setKey(Integer key) {
        this.key = key;
    }

    Integer getElement() {
        return element;
    }

    void setElement(Integer element) {
        this.element = element;
    }

    BSTNode getLeft() {
        return left;
    }

    void setLeft(BSTNode left) {
        this.left = left;
    }

    BSTNode getRight() {
        return right;
    }

    void setRight(BSTNode right) {
        this.right = right;
    }

    int getHeight() {
        return height;
    }

    void setHeight(int height) {
        this.height = height;
    }

    
}

static class BST{
    static BSTNode root;
    static int nodeCount;

    BST() {
        this.root = null;
        this.nodeCount = 0;
    }

    Integer find(BST bst, Integer key) {
        return findHelp(bst.root, key);
    }

    static Integer findHelp(BSTNode rt, Integer key) {
        if (rt == null) {
            return null;
        }

        if (Integer.parseInt(rt.getKey().toString()) > Integer.parseInt(key.toString())) {
            return findHelp(rt.getLeft(), key);
        } else if (rt.getKey() == key) {
            return rt.getElement();
        } else {
            return findHelp(rt.getRight(), key);
        }
    }

    void insert(BST bst, Integer key, Integer value) {
        this.setRoot(insertHelp(bst.root, key, value));
        this.nodeCount++;
    }

    static BSTNode insertHelp(BSTNode rt, Integer key, Integer value) {
        if (rt == null) {
            return new BSTNode(key, value);
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

        if (balance < -1 && (int) key >= (int) rt.getRight().getKey()) {
            return leftRotate(rt);
        }

        if (balance > 1 && (int) key < (int) rt.getLeft().getKey()) {
            return rightRotate(rt);
        }

        if (balance > 1 && (int) key >= (int) rt.getLeft().getKey()) {
            rt.setLeft(leftRotate(rt.getLeft()));
            return rightRotate(rt);
        }

        if (balance < -1 && (int) key < (int) rt.getRight().getKey()) {
            rt.setRight(rightRotate(rt.getRight()));
            return leftRotate(rt);
        }

        return rt;
    }

    static int getBalance(BSTNode rt) {
        if (rt == null) {
            return 0;
        }
        return height(rt.getLeft()) - height(rt.getRight());
    }

    static int height(BSTNode rt) {
        if (rt == null) {
            return -1;
        }
        return rt.getHeight();
    }

    static BSTNode rightRotate(BSTNode rt) {
        BSTNode left = rt.getLeft();
        BSTNode leftRight = left.getRight();
        left.setRight(rt);
        rt.setLeft(leftRight);
        rt.setHeight(1 + Math.max(height(rt.getLeft()), height(rt.getRight())));
        left.setHeight(1 + Math.max(height(left.getLeft()), height(left.getRight())));
        return left;
    }

    static BSTNode leftRotate(BSTNode rt) {
        BSTNode right = rt.getRight();
        BSTNode rightLeft = right.getLeft();
        right.setLeft(rt);
        rt.setRight(rightLeft);
        rt.setHeight(1 + Math.max(height(rt.getLeft()), height(rt.getRight())));
        right.setHeight(1 + Math.max(height(right.getLeft()), height(right.getRight())));
        return right;
    }

    static Integer remove(BST bst, Integer key) {
        Integer temporary = findHelp(bst.root, key);
        if (temporary != null) {
            bst.root = removeHelp(bst.root, key);
            nodeCount--;
        }
        return temporary;
    }

    static BSTNode removeHelp(BSTNode rt, Integer key) {

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
                    BSTNode temporary = getMin(rt.getRight());
                    rt.setElement(temporary.getElement());
                    rt.setKey(temporary.getKey());
                    rt.setRight(deleteMin(rt.getRight()));
                }
            }
        }
        return rt;

    }

    static BSTNode deleteMin(BSTNode rt) {
        if (rt.getLeft() == null) {
            return rt;
        }

        return getMin(rt.getLeft());
    }

    void preOrder(BSTNode rt) {
        if (rt != null) {
            System.out.print(rt.getElement() + " ");
            preOrder(rt.getLeft());
            preOrder(rt.getRight());
        }
    }

    void inOrder(BSTNode rt) {
        if (rt != null) {
            inOrder(rt.getLeft());
            System.out.print(rt.getElement() + " ");
            inOrder(rt.getRight());
        }
    }

    void postOrder(BSTNode rt) {
        if (rt != null) {
            postOrder(rt.getLeft());
            postOrder(rt.getRight());
            System.out.print(rt.getElement() + " ");
        }
    }

    static BSTNode getMin(BSTNode rt) {
        if (rt.getLeft() == null) {
            return rt.getRight();
        }

        rt.setLeft(deleteMin(rt.getLeft()));

        return rt;
    }

    BSTNode getRoot() {
        return root;
    }

    void setRoot(BSTNode root) {
        this.root = root;
    }

    int getNodeCount() {
        return nodeCount;
    }

    void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

}


}