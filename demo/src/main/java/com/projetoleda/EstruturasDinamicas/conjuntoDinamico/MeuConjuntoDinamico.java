package com.projetoleda.EstruturasDinamicas.conjuntoDinamico;

import java.util.Arrays;

public class MeuConjuntoDinamico<E> implements ConjuntoDinamicoIF<E>{

	private Object[] array;
	private int capacity;
	private int size;

	public MeuConjuntoDinamico() {
		this.array = new Object[10];
		this.capacity = 10;
		this.size = 0;
	}
	
	@Override
	public void inserir(E item) {
		if(capacity == size){
		    this.array = Arrays.copyOf(this.array, (int) (capacity * 1.5));
			capacity = (int) (capacity * 1.5);
		}
		array[size] = item;
		size++;
	}
	
	@Override
	public E remover(E item) {
		int index = -1;

        for(int i = 0; i < capacity; i++) {
			if(item == array[i]) {
				index = i;
				break;
			}
		}

		if(index == -1) {
			throw new IllegalArgumentException("Item não encontrado");
		}

		item = (E) array[index];

		Object[] copy = Arrays.copyOf(array, size);
		for(int i = size-1; i > index; i--) {
			array[i-1] = copy[i];
		}
		size--;
		return item;
	}

	@Override
	public E predecessor(E item) {
        if(size == 0){
			throw new IllegalArgumentException("Tamanho 0");
		}

        for(int i = 0; i < size; i++) {
			if(item == array[i]) {
				if(i-1  == -1) {
					return null;
				}
				return (E) array[i-1];
			}
		}
		throw new IllegalArgumentException("Item não encontrado");
	}

	@Override
	public E sucessor(E item) {
		if(size == 0){
			throw new IllegalArgumentException("Tamanho 0");
		}

        for(int i = 0; i < size; i++) {
			if(item == array[i]) {
				if(i == size) {
					return null;
				}
				return (E) array[i+1];
			}
		}
		throw new IllegalArgumentException("Item não encontrado");
	}

	@Override
	public int tamanho() {
		return size;
	}

	@Override
	public E buscar(E item) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == item){
				return (E) array[i];
			}
		}
		throw new IllegalArgumentException("Item não existe");
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}

	@Override
	public Object[] toArray(int first, int last) {
		return Arrays.copyOfRange(array, first, last);
	}
}