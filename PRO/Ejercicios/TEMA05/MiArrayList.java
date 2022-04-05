/**
 * 3) Crear una clase MiArrayList que almacene una lista de 100 enteros como
 * máximo. Deberá tenerlas operaciones add añadir un nuevo entero, remove borrar
 * el entero de la posición que se le pase, get obtener el entero de la posición
 * que se le pase, sort que devolverá un objeto MiArrayList ordenado, size que
 * devolverá el número de elementos almacenados, clear que borrará todos los
 * elementos de la lista, indexOf que devolverá el índice de la primera
 * ocurrencia de un elemento en la lista o -1 si no se encuentra, isEmpty que
 * devolverá true si la lista está vacía o false en caso contrario, set que
 * cambia el valor de la posición que se le indique, toArray que devolverá un
 * array con los elementos actualmente en la lista, toString que devolverá una
 * cadena representando la lista de números.
 * 
 * @author @GuillermoSH
 * @version 0.6
 */
public class MiArrayList {
    private int[] items;
    private int maxCapacity;
    private int numElements;

    public MiArrayList(int maxCapacity) {
        this.items = new int[maxCapacity];
        this.maxCapacity = maxCapacity;
        this.numElements = 0;
    }

    public boolean add(int item) throws Exception {
        if (this.numElements < this.maxCapacity) {
            return this.items[this.numElements] = item;
            this.numElements++;
        } else {
            throw new Exception("Error MiArrayList.get not a valid position.");
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
        int counter = 0;

        for (int index = 0; index < this.items.length; index++) {
            if (this.items[index] == item) {
                break;
                counter++;
            }
        }
        if (counter == 0) {
            return -1;
        } else {
            return index;
        }
    }

    public boolean isEmpty() {
        return this.numElements == 0;
    }

    public boolean remove(int pos) throws Exception {
        if (this.validPosition(pos)) {
            return this.items[pos] = 0;
            this.numElements--;
        } else {
            throw new Exception("Error MiArrayList.remove not a valid position.");
        }
    }

    public boolean set(int pos, int val) throws Exception {
        if (this.validPosition(pos)) {
            return this.items[pos] = val;
        } else {
            throw new Exception("Error MiArrayList.set not a valid position.");
        }
    }

    public int size() {
        return this.numElements;
    }

    public MiArrayList sort() {
        boolean ordered = false;
        int i = 1;
        double auxiliary;

        while (!ordered) {
            ordenado = true;

            for (int j = 0; j < this.items.length - i; j++) {
                if (this.items[j] > this.items[j + 1]) {
                    auxiliary = this.items[j];
                    this.items[j] = this.items[j + 1];
                    this.items[j + 1] = auxiliary;
                    ordered = false;
                }
            }
            i++;
        }
    }

    public int[] toArray() {
        return this.items;
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
        return String.format("The list till this point is the following: \n%s", Arrays.toString(this.items));
    }
}
