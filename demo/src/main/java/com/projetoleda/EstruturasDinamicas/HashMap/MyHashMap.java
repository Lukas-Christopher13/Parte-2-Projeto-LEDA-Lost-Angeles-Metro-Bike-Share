package com.projetoleda.EstruturasDinamicas.HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

// Classe que representa uma entrada (chave-valor) no hash map
class Entry<K, V> {
    private final K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

// Classe do hash map
public class MyHashMap<K, V> {
    private final int size;
    private final ArrayList<LinkedList<Entry<K, V>>> buckets;

    public MyHashMap(int size) {
        this.size = size;
        buckets = new ArrayList<>(size);

        // Inicializa os baldes
        for (int i = 0; i < size; i++) {
            LinkedList<Entry<K,V>> linkedList = new LinkedList<>();
            buckets.add(linkedList);
        }
    }

    // Método para obter o índice do balde para uma chave
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % size;
    }

    // Método para obter um valor do hash map a partir de uma chave
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(bucketIndex);

        // Percorre os elementos do balde procurando pela chave
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null; // Retorna null se a chave não for encontrada
    }

    // Método para adicionar uma entrada ao hash map
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(bucketIndex);

        // Percorre os elementos do balde procurando pela chave
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                // Atualiza o valor se a chave já existe
                entry.setValue(value);
                return;
            }
        }

        // Adiciona uma nova entrada se a chave não existir no balde
        bucket.add(new Entry<>(key, value));
    }

    // Método para remover uma entrada do hash map com base em uma chave
    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(bucketIndex);

        // Percorre os elementos do balde procurando pela chave
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                bucket.remove(entry);
                return;
            }
        }
    }
}