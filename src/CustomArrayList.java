import java.util.Arrays;

class CustomArrayList {
    private Object[] data;
    private int size;

    public CustomArrayList() {
        data = new Object[10]; // Initial capacity
        size = 0;
    }

    public void put(Object value) {
        if (size >= data.length) {
            resize();
        }
        data[size++] = value;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null; // Clear the reference
    }

    private void resize() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}