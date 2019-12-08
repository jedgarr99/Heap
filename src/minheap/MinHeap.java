package minheap;

/**
 *
 * @author Jorge Edgar Rodriguez Ortiz Loyola 181334
 */
public class MinHeap<T extends Comparable<T>> {

    public T[] heap;
    private int cant;
    private int max;
    private static final int FRENTE = 1;

    public MinHeap(int tamaño) {
        this.max = tamaño;
        this.cant = 0;
        heap = (T[]) (new Comparable[this.max + 1]);
        heap[0] = null;
    }

    private int getPapa(int pos) {
        return pos / 2;
    }

    private int getIzq(int pos) {
        return (2 * pos);
    }

    private int getDer(int pos) {
        return (2 * pos) + 1;
    }

    private boolean esHoja(int pos) {
        if (pos >= (cant / 2) && pos <= cant) {
            return true;
        }
        return false;
    }

    private void swap(int a, int b) {
        T aux = heap[a];

        heap[a] = heap[b];
        heap[b] = aux;
    }

    public void inserta(T element) {
        if (cant >= max) {
            T[] aux = (T[]) (new Comparable[cant * 2]);
            System.arraycopy(heap, 0, aux, 0, cant);
            heap = aux;
        }
        heap[++cant] = element;
        int act = cant;

        while (getPapa(act) != 0 && heap[act].compareTo(heap[getPapa(act)]) < 0) {
            swap(act, getPapa(act));
            act = getPapa(act);
        }
    }

    public void imprime() {
        for (int i = 1; i <= cant / 2; i++) {
            System.out.print(" Papá : " + heap[i]
                    + " Izquierdo : " + heap[2 * i]
                    + " Derecho :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public T eliminaMin() {
        T aux = heap[FRENTE];
        heap[FRENTE] = heap[cant--];
        eliminaAux(FRENTE);
        return aux;
    }

    private void eliminaAux(int pos) {
        if (heap[pos] != null && !esHoja(pos)) {
            if ((heap[getIzq(pos)] != null && heap[pos].compareTo(heap[getIzq(pos)]) > 0) || (heap[getDer(pos)] != null && heap[pos].compareTo(heap[getDer(pos)]) > 0)) {
                if (heap[getDer(pos)] != null && heap[getIzq(pos)].compareTo(heap[getDer(pos)]) < 0) {
                    swap(pos, getIzq(pos));
                    eliminaAux(getIzq(pos));
                } else {
                    swap(pos, getDer(pos));
                    eliminaAux(getDer(pos));
                }
            }
        }
    }

    public <T extends Comparable<T>> T[] heapSort() {
        T[] res = (T[]) (new Comparable[cant]);
        int i = 0;
        while (cant != 0) {
            Object elem = this.eliminaMin();
            if (elem != null) {
                res[i] = (T) elem;

                i++;
            }

        }
        return res;
    }

}
