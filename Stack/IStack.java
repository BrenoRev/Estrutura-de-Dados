public interface IStack<E> {
    void clear();
    void push(E element);
    E pop();
    E topValue();
    int length();
}
