public class List<E> {
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
        this.size++;
    }

    public void moveToStart() {
        this.current = this.head;
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
        if(this.current.getNext() == null) {
            return null;
        }
        E element = (E) this.current.getNext().getElement();

        if(this.tail == this.current.getNext()) {
            this.tail = this.current;
        }

        this.current.setNext(this.current.getNext().getNext());
        this.size--;

        return element;
    }

    public int countValues(E value) {
        int count = 0;
        Link<E> temporary = this.head.getNext();
        while(temporary != null) {
            if(temporary.getElement().equals(value)) {
                count++;
            }
            temporary = temporary.getNext();
        }
        return count;
    }

    @Override
    public String toString() {
        return "List [current=" + current + ", head=" + head + ", size=" + size + ", tail=" + tail + "]";
    }

}
