
package minheap;

/**
 *
 * @author Jorge Edgar Rodriguez Ortiz Loyola
 */
public class MinHeap <T extends Comparable<T>> {
    
    private T[] heap;
    private int cant;
    private int max;
    private static final int FRENTE = 1;

    public MinHeap(int tamaño) {
        this.max = tamaño;
        this.cant = 0;
        this.heap = new [this.max + 1];
        heap[0] = 0;
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

    private boolean isLeaf(int pos) {
        if (pos >= (cant / 2) && pos <= cant) {
            return true;
        }
        return false;
    }

    private void swap(int a, int b) {
        int aux;
        aux = heap[a];
        heap[a] = heap[b];
        heap[b] = aux;
    }

   

    public void insert(int element) {
        if (cant >= max) {
            int[] aux  = new int[cant*2];
            System.arraycopy(heap, 0, aux, 0, cant);
            heap=aux;
        }
        heap[++cant] = element;
        int act = cant;

        while (heap[act] < heap[getPapa(act)]) {
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

    
    public int eliminaMin() {
        int aux = heap[FRENTE];
        heap[FRENTE] = heap[cant--];
        eliminaAux(FRENTE);
        return aux;
    }

    private void eliminaAux(int pos) {
        if (!isLeaf(pos)) {
            if (heap[pos] > heap[getIzq(pos)] || heap[pos] > heap[getDer(pos)]) {
                if (heap[getIzq(pos)] < heap[getDer(pos)]) {
                    swap(pos, getIzq(pos));
                    eliminaAux(getIzq(pos));
                } 
                else {
                    swap(pos, getDer(pos));
                    eliminaAux(getDer(pos));
                }
            }
        }
    }


    
     public static void main(String[] arg) 
    { 
        MinHeap minHeap = new MinHeap(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 

  
        minHeap.imprime(); 
        
    } 

}
