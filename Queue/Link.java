package Queue;

public class Link<E> {
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

    @Override
    public String toString() {
        return "Link [element=" + element + ", next=" + next + "]";
    }

}