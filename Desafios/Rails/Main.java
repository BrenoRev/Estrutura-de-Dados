package Desafios.Rails;

import java.util.Scanner;

public class Main {
    // coded by
    // Breno Silva

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            boolean br = true;
            while (br) {
                Pilha<Integer> stack = new Pilha<Integer>();
                int j = 0;
                for (int i = 0; i < N; i++) {
                    int x = sc.nextInt();
                    if (x == 0) {
                        br = false;
                        break;
                    }
                    while (j < N && j != x) {
                        if (stack.size() > 0 && stack.peek() == x) {
                            break;
                        }
                        j++;
                        stack.push(j);
                    }
                    if (stack.peek() == x) {
                        stack.pop();
                    }
                }
                if (br) {
                    if (stack.size() == 0) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                }
            }
            System.out.println();
        }
    }
}

interface IStack<E> {
    void clear();

    void push(E element);

    E pop();

    E topValue();

    int size();

    E peek();
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

    @Override
    public String toString() {
        return "Link [element=" + element + ", next=" + next + "]";
    }

}

class Pilha<E> implements IStack<E> {
    Link<E> top;
    int size;

    public Pilha() {
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
        if (this.top == null) {
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
    public int size() {
        return this.size;
    }

    @Override
    public E peek() {
        if (this.top == null) {
            throw new IllegalArgumentException("Tamanho nulo");
        }
        return this.top.getElement();
    }
}
