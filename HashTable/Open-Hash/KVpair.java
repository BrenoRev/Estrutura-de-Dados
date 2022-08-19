class KVpair<Key, E> {
  private Key k;
  private E e;

  KVpair() {
    k = null;
    e = null;
  }

  KVpair(Key kval, E eval) {
    k = kval;
    e = eval;
  }

  public Key key() {
    return k;
  }

  public E value() {
    return e;
  }
}