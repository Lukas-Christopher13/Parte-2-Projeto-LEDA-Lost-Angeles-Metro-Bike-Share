package com.projetoleda.funcoesDeOrdenacao;

import com.projetoleda.csvUtil.SortUtil;

public class HeapSort implements SortAlgorithm {

    private String[] lines;

	public void sort(Object array[])
	{
		int size = array.length;

		for (int i = size / 2 - 1; i >= 0; i--)
			heapify(array, size, i);

		for (int i = size - 1; i >= 0; i--) {
            swap(array, 0, i);
            swapCsvLine(0, i);
			
			heapify(array, i, 0);
		}
	}

	void heapify(Object array[], int n, int i)
	{
		int largest = i; 
		int left = 2 * i + 1; 
		int right = 2 * i + 2; 

		if (left < n && SortUtil.comparar(array[left],(array[largest])) > -1) //array[l] > array[largest]
			largest = left;

		if (right < n && SortUtil.comparar(array[right],(array[largest])) > -1) //array[r] > array[largest]
			largest = right;

		if (largest != i) {
            swap(array, i, largest);
            swapCsvLine(i, largest);
			
			heapify(array, n, largest);
		}
	}
	
    private void swap(Object [] array, int i, int j){
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void swapCsvLine (int i, int j) {
        String temp = lines[i];
        lines[i] = lines[j];
        lines[j] = temp;
    }

	@Override
	public void setCsvLines(String[] lines) {
		this.lines = lines;
	}
}
