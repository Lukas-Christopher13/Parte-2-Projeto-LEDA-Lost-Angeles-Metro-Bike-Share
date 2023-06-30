package com.projetoleda.EstruturasDinamicas.pilha;

import java.util.Arrays;

public class MinhaPilha<T> {
	
	private int topo;
	private int tamanho = 5;
	private Object[] array = null;

	public MinhaPilha(int tamanho) {
		this.tamanho = tamanho;
		this.topo  = 0;
	}
	
	public MinhaPilha() {
		this.array = new Object[tamanho];
		this.topo = 0;
	}

	public void empilhar(Object item) {
		if(topo == tamanho) {
			this.array = Arrays.copyOf(this.array, (int) (tamanho * 1.5));
			tamanho = (int) (topo * 1.5);
		}
		array[topo] = item;
		topo++;
	}

	public Object desempilhar() {
        if(topo == 0) {
			return null;
		}

        /*

        if(topo > (int) (array.length/2)) {
			array = Arrays.copyOf(array, (int) (array.length/2));
			tamanho = (int) (array.length/2);
		}

		*/

		topo--;
		return array[topo];
	}


	public T topo() {
		if(topo == 0) {
			return null;
		}
		return (T) array[topo-1];
	}

	public boolean isEmpty() {
		if(topo == 0){
			return true;
		}
		return false;
	}

    public Object[] getArray() {
		return array;
	}
}
