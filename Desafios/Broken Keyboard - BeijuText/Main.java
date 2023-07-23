import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // Coded by
        // Breno Silva

        BufferedReader bufferedReaderr = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = bufferedReaderr.readLine()) != null) {
            LinkedList value = new LinkedList();

            int pointerLocation = 0;

            for (char c : input.toCharArray()) {
                if (c == '[')
                    pointerLocation = 0;
                else if (c == ']')
                    pointerLocation = value.size();
                else
                    value.add(pointerLocation++, c);
            }

            Node current = value.head;

            StringBuilder stringBuilder = new StringBuilder();

            while (current != null) {
                stringBuilder.append(current.data);
                current = current.next;
            }

            System.out.println(stringBuilder);
        }
    }
}

class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int index, char data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (size == 0) {
                tail = newNode;
            }
        } else if (index == size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node prevNode = getNode(index - 1);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }
        size++;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int size() {
        return size;
    }
}
