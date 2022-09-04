import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) {
        // coded by
        // Breno Silva

        FastReader reader = new FastReader();
        AVL tree = new AVL();
        StringBuilder sb = new StringBuilder();

        int quantityInputs = reader.nextInt();
        for (int i = 0; i < quantityInputs; i++) {
            int option = reader.nextInt();
            int value = reader.nextInt();

            if (option == 1) {
                tree.insertAuxiliar(value);
            } else {
                value = tree.nodeFinder(tree.getRoot(), value, 1);
                if (value == 0) {
                    sb.append("Data tidak ada\n");
                } else {
                    sb.append(value + "\n");
                }
            }
        }

        System.out.println(sb);
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

        int element, children;
        BSTNode left, right;
        int height;

        public BSTNode(int aux) {
            this.element = aux;
            this.height = 0;
            this.children = 0;
        }
    }

    static class AVL {
        static BSTNode root;

        public AVL() {
            this.root = null;
        }

        public int getHeight(BSTNode root) {
            if (root == null) {
                return -1;
            }
            ;

            return root.height;
        }

        public int getChildren(BSTNode root) {
            if (root == null) {
                return 0;
            }

            return root.children + 1;
        }

        public int maxHeight(int auxiliar1, int auxiliar2) {
            return (auxiliar1 > auxiliar2) ? auxiliar1 : auxiliar2;
        }

        public BSTNode rightRotate(BSTNode root) {
            BSTNode auxiliarLeft = root.left;
            BSTNode auxiliarRight = auxiliarLeft.right;

            auxiliarLeft.right = root;
            root.left = auxiliarRight;
            root.height = maxHeight(getHeight(root.left), getHeight(root.right)) + 1;
            root.children = getChildren(root.right) + getChildren(root.left);
            auxiliarLeft.height = maxHeight(getHeight(auxiliarLeft.left), getHeight(auxiliarLeft.right)) + 1;
            auxiliarLeft.children = getChildren(auxiliarLeft.right) + getChildren(auxiliarLeft.left);
            return auxiliarLeft;
        }

        public BSTNode leftRotate(BSTNode root) {
            BSTNode auxiliarRight = root.right;
            BSTNode auxiliarLeft = auxiliarRight.left;

            auxiliarRight.left = root;
            root.right = auxiliarLeft;
            root.height = maxHeight(getHeight(root.left), getHeight(root.right)) + 1;
            root.children = getChildren(root.right) + getChildren(root.left);
            auxiliarRight.height = maxHeight(getHeight(auxiliarRight.left), getHeight(auxiliarRight.right)) + 1;
            auxiliarRight.children = getChildren(auxiliarRight.right) + getChildren(auxiliarRight.left);
            return auxiliarRight;
        }

        public int nodeFinder(BSTNode current, int auxiliar, int contador) {
            if (current == null)
                return 0;
            else if (current != null && auxiliar < current.element) {
                return nodeFinder(current.left, auxiliar, contador);
            } else if (auxiliar > current.element) {
                return nodeFinder(current.right, auxiliar, contador + getChildren(current.left) + 1);
            } else {
                contador += getChildren(current.left);
                return contador;
            }
        }

        int getBalance(BSTNode root) {
            if (root == null) {
                return 0;
            }

            return getHeight(root.left) - getHeight(root.right);
        }

        public BSTNode insert(BSTNode root, int auxiliar) {
            if (root == null) {
                return new BSTNode(auxiliar);
            }

            if (auxiliar <= root.element) {
                root.left = insert(root.left, auxiliar);
            } else if (auxiliar > root.element) {
                root.right = insert(root.right, auxiliar);
            } else {
                return root;
            }

            root.height = maxHeight(getHeight(root.left), getHeight(root.right)) + 1;
            root.children = getChildren(root.right) + getChildren(root.left);
            int balance = getBalance(root);

            if (balance > 1 && auxiliar < root.left.element) {
                return rightRotate(root);
            }

            if (balance < -1 && auxiliar > root.right.element) {
                return leftRotate(root);
            }

            if (balance > 1 && auxiliar > root.left.element) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }

            if (balance < -1 && auxiliar < root.right.element) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }

            return root;
        }

        public BSTNode getRoot() {
            return this.root;
        }

        public void insertAuxiliar(int auxiliar) {
            root = insert(getRoot(), auxiliar);
        }

    }

}