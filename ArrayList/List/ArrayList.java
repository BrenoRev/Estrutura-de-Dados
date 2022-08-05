package List;

import interfaces.IArrayList;

public class ArrayList<E> implements IArrayList<E> {

    private int maxSize;
    private int listSize;
    private int current;
    E[] elementos;

    public ArrayList(int size) {
        this.elementos = (E[]) new Object[size];
        this.listSize = 0;
        this.current = 0;
        this.maxSize = size;
    }

    public ArrayList() {
        this(10);
    }

    @Override
    public void clear() {
        int i = 0;
        while(i  <= this.maxSize) {
            elementos[i] = null;
        }
    }

    @Override
    public E insert(E element) {
        this.aumentaCapacidade();
        if (this.listSize < this.elementos.length){
			this.elementos[this.listSize] = element;
			this.listSize++;
		} 

        return element;
    }

    @Override
    public E remove() {
        if(this.current < 0 || this.current  >= this.listSize) {
            return null;
        }
        
        E item = this.elementos[this.current];
        int indexCurrent = this.current -1;

        while(indexCurrent < this.listSize - 1) {
            elementos[indexCurrent] = elementos[indexCurrent + 1];
            indexCurrent++;
        }

        this.listSize--;
        return item;

    }

    @Override
    public void moveToStart() {
        this.current = 0;
    }

    @Override
    public void moveToEnd() {
        this.current = listSize - 1;
    }

    @Override
    public void prev() {
        if(this.current != 0) {
            this.current--;
        }
    }

    @Override
    public void next() {
        if(this.current < listSize) {
            this.current++;
        }
    }

    @Override
    public int length() {
        return this.listSize;
    }

    @Override
    public int currentPosition() {
        return this.current;
    }

    @Override
    public void moveToPosition(int position) {
        if(position < listSize || position > 0) {
            this.current = position;
        }
    }

    @Override
    public E getValue(E value) {
        moveToStart();
        while(this.current < this.listSize) {
            if(this.elementos[this.current] == value) {
                return this.elementos[this.current];
            }
            next();
        }
        return null;
    }

    private void aumentaCapacidade(){
		if (this.listSize == this.elementos.length){
			E[] elementosNovos = (E[]) new Object[this.elementos.length * 2];
			for (int i=0; i< this.elementos.length; i++){
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}

    @Override
    public Integer countValues(E value) {
        int count = 0;
        for(int index = 0; index < listSize; index++) {
            if(this.elementos[index] == value) {
                count++;
            }
        }
        return count;
    }
}