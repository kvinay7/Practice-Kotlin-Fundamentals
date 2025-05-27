import java.util.Arrays;

public class CustomArrayList<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
          elements = new Object[INITIAL_CAPACITY];
	}

    public void add(E element) {
		ensureCapacity();
		elements[size++] = element;
	}

    public void add(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
		}
		ensureCapacity();
		// Shift elements right from index to size-1
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = element;
		size++;
    }

	public E get(int index) {
		checkIndex(index);
		return (E) elements[index];
	}

	public E remove(int index) {
		checkIndex(index);
		E removedElement = (E) elements[index];

		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
	}
		elements[--size] = null; // Avoid memory leak
		return removedElement;
	}

public E set(int index, E element) {
		checkIndex(index);
		E oldElement = (E) elements[index];
		elements[index] = element;
		return oldElement;
    }

	public int size() {
		return size;
	}

	private void ensureCapacity() {
		if (size == elements.length) {
			int newCapacity = elements.length * 2;
			elements = Arrays.copyOf(elements, newCapacity);
		}
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		Arrays.fill(elements, 0, size, null);
		size = 0;
	}
}

public class Main {
    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add(1, "Cherry");

        System.out.println("Size: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));
    
        String old = list.set(1, "Blueberry");
        System.out.println("Replaced: " + old);           // Cherry
        System.out.println("After set: " + list.get(1));   // Blueberry

        list.remove(1);
        System.out.println("After removal, size: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));
    }
}
