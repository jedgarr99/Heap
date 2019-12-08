
package minheap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Jorge Edgar Rodrigue Ortiz Loyola 181334
 */
public class Pruebas {
     public static void main(String[] arg) 
    { 
        
        Character arr[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',};
        Trie<String> t = new Trie(arr);
        Scanner sc = null;
        String[] lista = new String[90000], aux;
        int i = 0;
        boolean ban;
        long TInicio, TFin, tiempo;
        Sort s = new Sort();
        /*t.insertar("a");
        t.insertar("and");
        t.insertar("as");
        t.insertar("be");
        t.insertar("for");
        t.insertar("had");
        System.out.println(t.toString());
         System.out.println(t.getRaiz().getHijos()[0].cantHijos());
        System.out.println(t.busca("a"));
        System.out.println(t.busca("and"));
        System.out.println(t.busca("as"));
        System.out.println(t.busca("ans"));
        System.out.println(t.busca("be"));
        System.out.println(t.busca("for"));
        System.out.println(t.toString());
        
         t = new Trie(arr);*/
        try {
            File ent = new File("/Users/elisaortizloyola/Desktop/Heap/palabras.txt");
            sc = new Scanner(new FileReader(ent));

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
            System.exit(1);
        }

        while (i < 90000) {
            String text = sc.nextLine().toLowerCase();
            ban = true;
            /*char[] chars = text.toCharArray();

            for (char c : chars) {
                if (!Character.isLetter(c)) {
                    ban = false;
                }
            }*/
            if ((text != null) && (!text.equals("")) && (text.matches("^[a-zA-Z]*$"))) {
                lista[i] = text;
                i++;
            }

            /*if (ban) {
                lista[i] = text;
                i++;
            }*/
        }

        //System.out.println(Arrays.toString(lista));
       /* TInicio = System.currentTimeMillis();
        for (int j = 0; j < 60000; j++) {
            t.insertar(lista[j]);
        }
        //System.out.println("j "+100);

        String[] res = t.ordenamientoLexicografico();
        TFin = System.currentTimeMillis();
        //System.out.println(Arrays.toString(res));
        tiempo = TFin - TInicio;
        System.out.println(tiempo);

        t = new Trie(arr);
        TInicio = System.currentTimeMillis();

        for (int j = 0; j < 1000; j++) {
            t.insertar(lista[j]);
        }
        //System.out.println("j "+1000);

        res = t.ordenamientoLexicografico();
        TFin = System.currentTimeMillis();
        //System.out.println(Arrays.toString(res));
        tiempo = TFin - TInicio;
        System.out.println(tiempo);
        t = new Trie(arr);

        for (int k = 1; k < 10; k++) {
            int limit = k * 10000;
            TInicio = System.currentTimeMillis();
            for (int j = 0; j < limit; j++) {
                t.insertar(lista[j]);
            }
            System.out.println("j " + limit);

            res = t.ordenamientoLexicografico();
            TFin = System.currentTimeMillis();
            // System.out.println(Arrays.toString(res));
            tiempo = TFin - TInicio;
            System.out.println(tiempo);
            t = new Trie(arr);

        }
        System.out.println("merge");
        System.out.println("");
        aux = new String[100];
        for (int j = 0; j < 100; j++) {
            aux[j] = lista[j];
        }

        TInicio = System.currentTimeMillis();

        res = (String[]) s.mergeSort(aux);
        TFin = System.currentTimeMillis();
        //System.out.println(Arrays.toString(res));
        tiempo = TFin - TInicio;
        System.out.println(TInicio);
        System.out.println(TFin);
        System.out.println(tiempo);
        t = new Trie(arr);
        aux = new String[1000];

        for (int j = 0; j < 1000; j++) {

            aux[j] = lista[j];
        }
        TInicio = System.currentTimeMillis();
        res = res = (String[]) s.mergeSort(aux);
        TFin = System.currentTimeMillis();
        //System.out.println(Arrays.toString(res));
        tiempo = TFin - TInicio;
        System.out.println(tiempo);
        t = new Trie(arr);

        for (int k = 1; k < 10; k++) {
            int limit = k * 10000;
            aux = new String[limit];
            for (int j = 0; j < limit; j++) {

                aux[j] = lista[j];
            }
            TInicio = System.currentTimeMillis();
            res = res = (String[]) s.mergeSort(aux);
            TFin = System.currentTimeMillis();
            // System.out.println(Arrays.toString(res));
            tiempo = TFin - TInicio;
            System.out.println(tiempo);
            t = new Trie(arr);

        }
        
        
        */
        
        /*MinHeap<String> minHeap= new MinHeap(15); 
        minHeap.insert("5"); 
        minHeap.insert("3"); 
        minHeap.insert("9"); 
        minHeap.insert("1"); 
        minHeap.insert("7"); 
        minHeap.insert("8"); 
        minHeap.insert("4"); 
        Object[] res2 =  minHeap.heapSort();
        System.out.println(Arrays.toString(res2));*/
        
        int tam =89000;
        double prom=0; 
        for(int k=0; k<100; k++){
        MinHeap<String> minHeap = new MinHeap(tam);
        TInicio = System.currentTimeMillis();
        for (int j = 0; j < tam+1; j++) {
            minHeap.inserta(lista[j]);
        }
        //System.out.println(Arrays.toString(minHeap.heap));
        //minHeap.imprime();
       
        //Arrays.sort(lista);
        //System.out.println(Arrays.toString(lista));
        
             Object[] res3 =  minHeap.heapSort();
        
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        prom+=tiempo;
        
        //System.out.println(Arrays.toString(res3));
        }
        System.out.println(prom/100.0);
        
        //Prueba Trie 
  
        prom=0;
        for (int k = 0; k < 100; k++) {
        t = new Trie(arr);
        TInicio = System.currentTimeMillis();
        for (int j = 0; j < tam; j++) {
            t.insertar(lista[j]);
        }
        String[] res = t.ordenamientoLexicografico();
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
         prom+=tiempo;
        }
        System.out.println(prom/100.0);
        
        
        //Prueba Merge Sort

         prom=0; 
         aux = new String[tam];
        for (int j = 0; j < tam; j++) {
            aux[j] = lista[j];
        }
        for(int k=0; k<100;k++){
            

        TInicio = System.currentTimeMillis();

        String[] res = (String[]) s.mergeSort(aux);
        TFin = System.currentTimeMillis();
        //System.out.println(Arrays.toString(res));
        tiempo = TFin - TInicio;
        prom+=tiempo;

        
        }
        System.out.println(prom/100);
       

        
    } 
}
