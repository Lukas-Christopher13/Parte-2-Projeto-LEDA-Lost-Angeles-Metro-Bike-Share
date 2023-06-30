package com.projetoleda.funcoesDeOrdenacao;

import com.projetoleda.EstruturasDinamicas.pilha.MinhaPilha;
import com.projetoleda.csvUtil.SortUtil;
import java.util.Arrays;

class Pair {
    private final int x;
    private final int y;
 
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
    public int getX() { return x; }
    public int getY() { return y; }
}

public class QuicksortM3 implements SortAlgorithm{

    private String[] csvLines;

    public static void swapString(String[] csvLines, int i, int j) {
        String temp = csvLines[i];
        csvLines[i] = csvLines[j];
        csvLines[j] = temp;
    }
 
    public int partition(Object array[], int start, int end) {
        int meidana = meidanaDe3(array, start, end);

        swap(array, meidana, end);
        swapString(csvLines, meidana, end);

        Object pivot = array[end];
 
        int pIndex = start;
 
        for (int i = start; i < end; i++){
            if (SortUtil.comparar(array[i], pivot) < 1) { //a[i] <= pivot
                swap(array, i, pIndex);
                swapString(csvLines, i, pIndex);
                pIndex++;
            }
        }
 
        swap (array, pIndex, end);
        swapString(csvLines, pIndex, end);
 
        return pIndex;
    }

    public void sort(Object[] array) {
    
        MinhaPilha<Pair> stack = new MinhaPilha<>();
 
        int start = 0;
        int end = array.length - 1;
 
        stack.empilhar(new Pair(start, end));
 
        while (!stack.isEmpty()) {
            start = stack.topo().getX();
            end = stack.topo().getY();
            stack.desempilhar();
 
            int pivot = partition(array, start, end);

            if (pivot - 1 > start) {
                stack.empilhar(new Pair(start, pivot - 1));
            }
 
            if (pivot + 1 < end) {
                stack.empilhar(new Pair(pivot + 1, end));
            }
        }
    }
 
    public int meidanaDe3(Object[] values, int left, int right) {
        int mid = (left + right) / 2;
        
        Object[] sorted = {values[left], values[mid], values[right]};
        Arrays.sort(sorted);
        
        if (SortUtil.comparar(sorted[1], values[left]) == 0) return left;
        else if (SortUtil.comparar(sorted[1], values[mid]) == 0) return mid;
        else return right;
    }

    private void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public void setCsvLines(String[] lines) {
        this.csvLines = lines;
    }
}
