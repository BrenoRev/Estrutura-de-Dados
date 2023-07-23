package Queue;

public interface IQueue<E> {
    void clear();

    void enqueue(E element);

    E dequeue();

    E frontValue();

    int length();
}
