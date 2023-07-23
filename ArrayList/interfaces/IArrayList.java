package ArrayList.interfaces;

public interface IArrayList<E> {
    void clear();

    E insert(E element);

    E remove();

    void moveToStart();

    void moveToEnd();

    void prev();

    void next();

    int length();

    int currentPosition();

    void moveToPosition(int position);

    E getValue(E value);

    Integer countValues(E value);
}
