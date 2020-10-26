public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    private void resize(int sz, double factor) {
        double dcapacity = sz * factor;
        int capacity = (int) dcapacity;
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, nextLast);
        if (factor > 1) {
            System.arraycopy(items, nextFirst + 1, a,
                    a.length * 1 / 2 + nextFirst + 1, sz - nextFirst - 1);
        } else {
            System.arraycopy(items, nextFirst + 1, a,
                    nextFirst - a.length + 1, sz - nextFirst - 1);
        }
        items = a;
        if (factor > 1) {
            nextFirst = a.length * 1 / 2 + nextFirst;
        } else {
            nextFirst = nextFirst - a.length;
        }
    }

    public void addFirst(T x) {
        if (size == items.length) {
            resize(size, 2);
        }
        items[nextFirst] = x;
        size += 1;
        nextFirst = (nextFirst - 1) % items.length;
    }

    public void addLast(T x) {
        if (size == items.length) {
            resize(size, 2);
        }
        items[nextLast] = x;
        size += 1;
        nextLast = (nextLast + 1) % items.length;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        for (int i = nextFirst + 1; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        for (int j = 0; j < nextLast; j++) {
            System.out.print(items[j] + " ");
        }
    }

    public T removeFirst() {
        if (size > 0) {
            size = size - 1;
        } else {
            return null;
        }
        T x = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst = nextFirst + 1;
        if (items.length > 8) {
            double dsize = size;
            double l = items.length;
            if (dsize / l <= 0.25) {
                int k = items.length;
                resize(k, 0.5);
            }
        }
        return  x;
    }

    public T get(int i) {
        if (i < items.length - nextFirst - 1) {
            return items[nextFirst + 1 + i];
        }
        if ((items.length - nextFirst - 1 <= i) && (i < nextLast + items.length - nextFirst - 1)) {
            return items[i - (items.length - nextFirst - 1)];
        } else {
            return null;
        }
    }

    public int size() {

        return size;
    }

    public T removeLast() {
        if (size > 0) {
            size = size - 1;
        } else {
            return null;
        }
        T x = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast = nextLast - 1;
        if (items.length > 8) {
            double dsize = size;
            double l = items.length;
            if (dsize / l <= 0.25) {
                int k = items.length;
                resize(k, 0.5);
            }
        }
        return x;
    }

    /**public static void main(String[] args) {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        System.out.println(A.isEmpty());
        A.addFirst(1);
        A.addFirst(2);
        A.addLast(3);
        A.addFirst(4);
        A.addFirst(5);
        A.addFirst(6);
        A.addLast(7);
        A.addFirst(8);
        A.addLast(9);
        System.out.println(A.size());
        System.out.println(A.get(1));
        A.printDeque();
        A.removeFirst();
        A.removeLast();
        System.out.println(" ");
        A.printDeque();
    }*/

}
