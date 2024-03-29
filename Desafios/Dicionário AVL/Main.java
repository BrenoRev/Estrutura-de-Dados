import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        // Coded by
        // Breno Silva
        
        FastReader reader = new FastReader();
        StringBuilder stringBuilder = new StringBuilder();

        int operations = reader.nextInt();

        for (int index = 0; index < operations; index++) {
            BST<Integer, Integer> avlTree = new BST<Integer, Integer>();
            int numOper = reader.nextInt();

            for (int j = 0; j < numOper; j++) {
                int value = reader.nextInt();
                avlTree.insert(avlTree, value, value);
            }

            avlTree.preOrder(avlTree.getRoot(), stringBuilder);
            
            if(index == operations - 1) {
                stringBuilder.append("END");
            } else {
                stringBuilder.append("END\n"); 
            }
        }

        System.out.println(stringBuilder);
    }

    static class BST<E, V> {
        private BSTNode<E, V> root;
        private int nodeCount;

        public BST() {
            this.root = null;
            this.nodeCount = 0;
        }

        public V find(BST<E, V> bst, E key) {
            return findHelp(bst.root, key);
        }

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

        public void insert(BST<E, V> bst, E key, V value) {
            this.setRoot(insertHelp(bst.root, key, value));
            this.nodeCount++;
        }

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

        public V remove(BST<E, V> bst, E key) {
            V temporary = findHelp(bst.root, key);
            if (temporary != null) {
                bst.root = removeHelp(bst.root, key);
                this.nodeCount--;
            }
            return temporary;
        }

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

        public BSTNode<E, V> deleteMin(BSTNode<E, V> rt) {
            if (rt.getLeft() == null) {
                return rt;
            }

            return getMin(rt.getLeft());
        }

        public void preOrder(BSTNode<E, V> rt, StringBuilder sb) {
            if (rt != null) {
                sb.append(rt.getElement()).append("\n");
                preOrder(rt.getLeft(), sb);
                preOrder(rt.getRight(), sb);
            }
        }

        public BSTNode<E, V> getMin(BSTNode<E, V> rt) {
            BSTNode<E, V> ptr = rt;
            while (ptr.getLeft() != null) {
                ptr = ptr.getLeft();
            }
            return ptr;
        }

        public BSTNode<E, V> getRoot() {
            return this.root;
        }

        public void setRoot(BSTNode<E, V> root) {
            this.root = root;
        }
    }

    static class BSTNode<E, V> {
        private E key;
        private V element;
        private BSTNode<E, V> left;
        private BSTNode<E, V> right;
        private int height;

        public BSTNode(E key, V element) {
            this.key = key;
            this.element = element;
            this.left = null;
            this.right = null;
            this.height = 0;
        }

        public E getKey() {
            return this.key;
        }

        public void setKey(E key) {
            this.key = key;
        }

        public V getElement() {
            return this.element;
        }

        public void setElement(V element) {
            this.element = element;
        }

        public BSTNode<E, V> getLeft() {
            return this.left;
        }

        public void setLeft(BSTNode<E, V> left) {
            this.left = left;
        }

        public BSTNode<E, V> getRight() {
            return this.right;
        }

        public void setRight(BSTNode<E, V> right) {
            this.right = right;
        }

        public int getHeight() {
            return this.height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
