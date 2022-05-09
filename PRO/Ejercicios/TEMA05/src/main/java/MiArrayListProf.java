import java.util.*;

public class MiArrayListProf {
    private int[] items;
    private int maxCapacity;
    private int numElements;

    public MiArrayListProf(int maxCapacity) {
        this.items = new int[maxCapacity];
        this.maxCapacity = maxCapacity;
        this.numElements = 0;
    }

    public boolean add(int item) throws Exception {
        if (this.numElements < this.maxCapacity) {
            this.items[this.numElements++] = item;
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        this.numElements = 0;
    }

    private boolean validPosition(int pos) {
        return pos >= 0 && pos < this.numElements;
    }

    public int get(int pos) throws Exception {
        if (this.validPosition(pos)) {
            return this.items[pos];
        } else {
            throw new Exception("Error MiArrayList.get not a valid position.");
        }
    }

    public int indexOf(int item) {
        for (int index = 0; index < this.numElements; index++) {
            if (this.items[index] == item) {
                return index;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.numElements == 0;
    }

    public boolean remove(int pos) throws Exception {
        if (this.validPosition(pos)) {
            this.numElements--;
            return true;
        } else {
            throw new Exception("Error MiArrayList.remove not a valid position.");
        }
    }

    public boolean set(int pos, int val) throws Exception {
        if (this.validPosition(pos)) {
            this.items[pos] = val;
            return true;
        } else {
            throw new Exception("Error MiArrayList.set not a valid position.");
        }
    }

    public int size() {
        return this.numElements;
    }

    public MiArrayList sort() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Error MiArrayList.sort the list is empty.");
        }
        MiArrayList result = new MiArrayList(this.maxCapacity);

        for (int index = 0; index < this.numElements; index++) {
            result.add(result.get(index));
        }
        Arrays.sort(this.items, 0, this.numElements);

        return result;
    }

    public int[] toArray() {
        int[] result = new int[this.numElements];
        for (int index = 0; index < this.numElements; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    public int pop() throws Exception {
        if (!this.isEmpty()) {
            this.numElements--;
            return this.items[this.numElements];
        } else {
            throw new Exception("Error MiArrayList.pop is empty.");
        }
    }

    @Override
    public String toString() {
        String result = "[";
        for (int index = 0; index < this.numElements; index++) {
            if (index < this.numElements - 1) {
                result += this.items[index] + ",";
            } else {
                result += this.items[index];
            }
        }
        return result;
    }

    public static void main(String args[]) {
        MiArrayList numbers = new MiArrayList(6);

        if (numbers.size() < 6) {
            
        }
    }
}
