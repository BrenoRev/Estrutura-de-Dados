import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Desafio {
    public static void main(String[] args) {
        // coded by
        // Breno Silva

        FastReader reader = new FastReader();
        BST<Integer, Integer> map = new BST<Integer, Integer>();

        int operations = reader.nextInt();
        for (int indexJ = 0; indexJ < operations; indexJ++) {
            int value = reader.nextInt();
            map.insert(map, value, value);
        }
        System.out.print("Pre order : ");
        map.preOrder(map.getRoot());
        System.out.println();
        System.out.print("In order  : ");
        map.inOrder(map.getRoot());
        System.out.println();
        System.out.print("Post order: ");
        map.postOrder(map.getRoot());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

    static class BSTNode<E, V> {

        private E key;
        private V element;
        private BSTNode<E, V> left;
        private BSTNode<E, V> right;

        public BSTNode(E key, V value) {
            this.key = key;
            this.element = value;
            this.left = this.right = null;
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
    }

   static interface IBST<E, V> {
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

    static class BST<E, V> implements IBST<E, V> {
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

            return rt;
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

}