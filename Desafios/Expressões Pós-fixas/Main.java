import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        // Coded by
        // Breno Silva

        final String END = "EOF";

        StringBuilder stringBuilder = new StringBuilder();
        FastReader reader = new FastReader();
        Stack stack = new Stack();

        String input = reader.nextLine();

        while (!input.equals(END)) {
            String[] tokens = input.split(" ");

            for (String token : tokens) {
                if (token.equals("END")) {
                    continue;
                }
                if (isInteger(token)) {
                    stack.push(Integer.parseInt(token));
                } else {
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();

                    int result = makeCalcs(operand1, operand2, token);
                    stack.push(result);
                }
            }

            stringBuilder.append(stack.topValue()).append("\n");

            input = reader.nextLine();
        }

        if (stringBuilder.length() > 0) {
            int lastNewlineIndex = stringBuilder.lastIndexOf("\n");
            stringBuilder.delete(lastNewlineIndex, stringBuilder.length());
        }

        System.out.println(stringBuilder);
    }

    // Utils

    public static int makeCalcs(int valueOne, int valueTwo, String operation) {
        switch (operation) {
            case "*":
                return valueOne * valueTwo;
            case "+":
                return valueOne + valueTwo;
            case "-":
                return valueOne - valueTwo;
            default:
                throw new IllegalArgumentException("Operacao nao encontrada");
        }
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Implementation

    static class Stack {
        private static final int DEFAULT_CAPACITY = 10;
        private int[] array;
        private int top;
        private int size;

        public Stack() {
            array = new int[DEFAULT_CAPACITY];
            top = -1;
            size = 0;
        }

        public void push(int element) {
            if (size == array.length) {
                expandCapacity();
            }
            top++;
            array[top] = element;
            size++;
        }

        public int pop() {
            if (isEmpty()) {
                throw new IllegalArgumentException("Pilha vazia");
            }
            int removedElement = array[top];
            top--;
            size--;
            return removedElement;
        }

        public int topValue() {
            if (isEmpty()) {
                throw new IllegalArgumentException("Pilha vazia");
            }
            return array[top];
        }

        public int length() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void expandCapacity() {
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    // Reader

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

        String nextLine() {
            String str = "";
            try {
                st = new StringTokenizer(br.readLine());
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
}