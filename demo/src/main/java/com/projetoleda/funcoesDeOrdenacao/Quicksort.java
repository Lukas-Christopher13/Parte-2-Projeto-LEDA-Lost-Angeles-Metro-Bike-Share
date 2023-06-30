package com.projetoleda.funcoesDeOrdenacao;

import java.util.Stack;

import com.projetoleda.EstruturasDinamicas.pilha.MinhaPilha;
import com.projetoleda.csvUtil.SortUtil;

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

public class Quicksort implements SortAlgorithm{

    private String[] csvLines;

    public static void swap (Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swapString(String[] csvLines, int i, int j) {
        String temp = csvLines[i];
        csvLines[i] = csvLines[j];
        csvLines[j] = temp;
    }
 
    public int partition(Object array[], int start, int end) {

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
    
    @Override
    public void setCsvLines(String[] lines) {
        this.csvLines = lines;
    }
}

