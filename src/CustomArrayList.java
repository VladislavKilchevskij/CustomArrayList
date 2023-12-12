import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class CustomArrayList<E> {

    private static final int DEFAULT_CAPACITY = 5;
    private E[] elements;
    private int size;

    public CustomArrayList() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public CustomArrayList(int capacity) {
        if (capacity >= 0) {
            this.elements = (E[]) new Object[capacity];
            this.size = 0;
        } else {
            throw new IllegalArgumentException("Capacity must not be negative!");
        }
    }

    public CustomArrayList(Collection<? extends E> collection) {
        if (!collection.isEmpty()) {
            E[] arr = (E[]) collection.toArray();
            this.elements = arr;
            this.size = arr.length;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E element) {
        if (size + 1 > elements.length) {
            expandCapacity(1);
        }
        elements[size++] = element;
    }

    public boolean addAll(Collection<? extends E> collection) {
        Object[] arr = collection.toArray();
        int copiedArraySize = arr.length;
        if (copiedArraySize == 0) {
            return false;
        }
        if (copiedArraySize > elements.length - size) {
            expandCapacity(copiedArraySize);
        }
        System.arraycopy(arr, 0, elements, size, arr.length);
        size += copiedArraySize;
        return false;
    }

    public boolean remove(E o) {
        boolean result = false;
        var arr = (E[]) new Object[size - 1];
        for (int i = 0, j = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                result = true;
                continue;
            }
            arr[j++] = elements[i];
        }
        elements = arr;
        size--;
        return result;
    }

    public E get(int index) {
        if (isIndexValid(index)) {
            return elements[index];
        } else {
            throw new IndexOutOfBoundsException("Illegal index: " + index + " in range [0, " + (size - 1) + "].");
        }
    }

    public E set(int index, E element) {
        if (isIndexValid(index)) {
            E oldElement = elements[index];
            elements[index] = element;
            return oldElement;
        } else {
            throw new IndexOutOfBoundsException("Illegal index: " + index + " in range [0, " + (size - 1) + "].");
        }
    }

    public void sort(Comparator<? super E> comparator) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int in = 0; in < elements.length - 1; in++) {
                if (comparator.compare(elements[in], elements[in + 1]) > 0) {
                    swap(in, in + 1);
                    flag = true;
                }
            }
        }
    }

    public static <E> void sort(CustomArrayList<? extends E> list, Comparator<? super E> comparator) {
        list.sort(comparator);
    }

    private void expandCapacity(int addCapacity) {
        elements = Arrays.copyOf(elements, size + addCapacity);
    }

    private boolean isIndexValid(int index) {
        return 0 <= index && index < size;
    }

    private int indexOf(E e) {
        for (int index = 0; index < size; index++) {
            if (elements[index].equals(e)) {
                return index;
            }
        }
        return -1;
    }

    private void swap(int first, int second) {
        E temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}