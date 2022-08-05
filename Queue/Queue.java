public class Queue<E> implements  IQueue<E>{

    private Link<E> front;
    private Link<E> rear;
    private int size;


    public Queue() {
        this.front = this.rear = new Link(null);
        this.size = 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void enqueue(E element) {
        this.rear.setNext(new Link(element, null));
        this.rear = this.rear.getNext();
        this.size++;
    }

    @Override
    public E dequeue() {
        if(this.size == 0) {
            throw new IllegalArgumentException("Tamanho zerado");
        }
        E item = (E) this.front.getNext().getElement();
        if(this.front.getNext() == null) {
            this.rear = this.front;
        }

        this.size--;

        return item;
    }

    @Override
    public E frontValue() {
        return (E) this.front;
    }

    @Override
    public int length() {
        return this.size;
    }
}
