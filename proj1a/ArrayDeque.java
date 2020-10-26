public class ArrayDeque<T> {
    private T[] items;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    private void resizeLast(int capacity) {
        Item[] a = (T[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }

    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * 2);
        }

    }

    public void addLast(T x) {
        if (size == items.length) {
            resizeLast(size * 2);
        }
        items[size] = x;
        size += 1;
    }

    public T getLast() {

        return items[size - 1];
    }

    public T get(int i) {

        return  items[i];
    }

    public int size() {

        return size;
    }

    public T removeLast() {
        T x = getLast();
        items[size - 1] = null;
        size = size - 1;
        return x;
    }


}