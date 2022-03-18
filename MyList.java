import javax.security.auth.login.AccountLockedException;

public class MyList<T> {

    int size = 10;
    int index = -1;
    Object[] array;

    public MyList() {
        array = (T[]) new Object[size];
    }

    public MyList(int capacity) {
        size = capacity;
        array = (T[]) new Object[size];
    }

    public int size(){
        return index+1;
    }

    public int getCapacity() {
        return size;
    }

    public void add(T data) {
        if (index+1 == size) {
            size = size*2;
            Object[] newArray = (T[]) new Object[size];

            for(int i = 0; i < index; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }

        array[index+1] = data;
        index++;
    }

    public T get(int index) {
        if (index > this.index || index < -1)
            return null;
        else
            return (T) array[index];

    }

    public T remove(int index) {
        if (index > this.index || index < -1)
            return null;
        else {
            T result = (T) array[index];
            if(this.index == index ) {
                array[this.index] = null;
                this.index--;
                return result;
            }
            for(int i = index; i < this.index; i++) {
                array[i] = array[i+1];
            }
            array[this.index] = null;
            this.index--;

            return result;
        }
    }

    public T set(int index, T data) {
        if (index > this.index || index < -1)
            return null;
        else {
            array[index] = data;
            return data;
        }
    }

    public String toString() {
        String result = "[";

        for(int i = 0; i <= index; i++){
            result = result  + array[i] +",";
        }

        if(index > -1)
            result = result.substring(0, result.length()-1) ;
        return result + "]";
    }

    public int indexOf(T data) {

        for (int i = 0; i <= index; i++) {
            if (array[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        int result =-1;

        for (int i = 0; i <= index; i++) {
            if (array[i] == data) {
                result = i;
            }
        }
        return result;
    }

    public boolean isEmpty() {
        return index == -1;
    }

    public T[] toArray() {
        return (T[]) array;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        index = -1;
    }

    public MyList<T> subList(int start, int finish) {
        MyList<T> result = new MyList<>(finish-start +1);

        for(int i = start; i <= finish; i++) {
            result.add(get(i));
        }

        return result;
    }

    public boolean contains(T data) {

        for (int i = 0; i <= index; i++) {
            if (array[i] == data) {
                return true;
            }
        }
        return false;
    }


}
