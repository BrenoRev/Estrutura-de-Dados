public class Stack<E> implements IStack<E>{

    Link<E> top;
    int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void clear() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E element) {
        this.top = new Link(element, this.top);
        this.size++;
    }

    @Override
    public E pop() {
        if(this.top == null) {
            throw new IllegalArgumentException("Tamanho nulo");
        }

        E item = this.top.getElement();
        this.top = this.top.getNext();
        this.size--;
        return item;
    }

    @Override
    public E topValue() {
        return (E) this.top;
    }

    @Override
    public int length() {
        return this.size;
    }
}
