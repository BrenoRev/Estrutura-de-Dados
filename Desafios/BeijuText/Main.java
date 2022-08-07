import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) {
        // coded by
        // Breno Silva

        FastReader reader = new FastReader();
        List<String> lista = new List();
        String input = reader.next();

        char[] letters = input.toCharArray();

        for (int k = 0; k < letters.length; k++) {
            if (letters[k] == '[') {
                lista.moveToStart();
            } else if (letters[k] == ']') {
                lista.moveToEnd();
            } else {
                lista.insert(letters[k] + "");
            }
        }

        System.out.println(lista.readText());

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

}

class List<E> {
    private Link<E> head;
    private Link<E> tail;
    private Link<E> current;
    int size;

    public List() {
        this.current = this.tail = this.head = new Link<>(null);
        this.size = 0;
    }

    public void insert(E element) {
        this.current.setNext(new Link<>(element, this.current.getNext()));
        if (this.tail == this.current) {
            this.tail = this.current.getNext();
        }
        this.current = this.current.getNext();
        this.size++;
    }

    public void moveToStart() {
        this.current = this.head;
    }

    public void moveToEnd() {
        this.current = this.tail;
    }

    public void prev() {
        if (this.current == this.head) {
            return;
        }

        Link<E> temporary = this.head;
        while (temporary.getNext() != this.current) {
            temporary = temporary.getNext();
        }

        this.current = temporary;
    }

    public void next() {
        if (this.current != this.tail) {
            this.current = this.current.getNext();
        }
    }

    public E remove() {
        if (this.current.getNext() == null) {
            return null;
        }
        E element = (E) this.current.getNext().getElement();

        if (this.tail == this.current.getNext()) {
            this.tail = this.current;
        }

        this.current.setNext(this.current.getNext().getNext());
        this.size--;

        return element;
    }

    public int countValues(E value) {
        int count = 0;
        Link<E> temporary = this.head.getNext();
        while (temporary != null) {
            if (temporary.getElement().equals(value)) {
                count++;
            }
            temporary = temporary.getNext();
        }
        return count;
    }

    public String readText() {
        StringBuilder sb = new StringBuilder();
        Link<E> temporary = this.head.getNext();
        while (temporary != null) {
            sb.append(temporary.getElement());
            temporary = temporary.getNext();
        }
        return sb.toString();
    }

}

class Link<E> {
    private E element;
    private Link next;

    public Link(E element, Link nextValue) {
        this.element = element;
        this.next = nextValue;
    }

    public Link(Link nextValue) {
        this.next = nextValue;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public Link getNext() {
        return next;
    }

}