import java.util.HashMap;
import java.util.Iterator;

class CustomHashSet {
    private HashMap<Object, Boolean> data;

    public CustomHashSet() {
        data = new HashMap<>();
    }

    public void put(Object value) {
        data.put(value, true);
    }

    public boolean contains(Object value) {
        return data.containsKey(value);
    }

    public void delete(Object value) {
        data.remove(value);
    }

    public int size() {
        return data.size();
    }

    public Iterator<Object> iterator() {
        return data.keySet().iterator();
    }

    @Override
    public String toString() {
        return data.keySet().toString();
    }
}

