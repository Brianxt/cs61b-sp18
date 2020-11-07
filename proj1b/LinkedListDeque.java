public class LinkedListDeque<T> implements Deque<T> {
    private class IntNode {
        private IntNode prev;
        private T item;
        private IntNode next;

        IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;
    //private T whatever;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        IntNode p = new IntNode(sentinel, x, sentinel.next);
        sentinel.next = p;
        sentinel.next.next.prev = p;
        size += 1;
    }

    private T getFirst() {

        return sentinel.next.item;
    }

    @Override
    public void addLast(T x) {
        IntNode p = new IntNode(sentinel.prev, x, sentinel);
        sentinel.prev = p;
        sentinel.prev.prev.next = p;
        size += 1;
    }

    private T getLast() {
        return sentinel.prev.item;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        IntNode p = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
    }

    @Override
    public T removeFirst() {
        if (size > 0) {
            T x = getFirst();
            sentinel.next.item = null;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size = size - 1;
            return x;
        } else {
            return null;
        }
    }

    @Override
    public T removeLast() {
        if (size > 0) {
            T x = getLast();
            sentinel.prev.item = null;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size = size - 1;
            return x;
        } else {
            return null;
        }
    }

    @Override
    public T get(int index) {
        IntNode p = sentinel;
        if (index < size) {
            for (int i = 0; i <= index; i++) {
                p = p.next;
            }
            return p.item;
        } else {
            return null;
        }
    }

    private T getitemRecursive(int index, IntNode p) {
        if (index != 0) {
            return getitemRecursive(index - 1, p.next);
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getitemRecursive(index, sentinel.next);
    }

    /**public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
    }*/
}
