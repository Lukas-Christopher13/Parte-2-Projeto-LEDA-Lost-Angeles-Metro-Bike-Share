package com.projetoleda.EstruturasDinamicas.pilha;

public interface PilhaIF<E> {
	
	public void empilhar(E item) throws PilhaCheiaException;
	
	public E desempilhar() throws PilhaVaziaException;
	
	public E topo();
	
	public PilhaIF<E> multitop(int k) throws PilhaVaziaException, PilhaCheiaException;
	
	public boolean isEmpty();

}
