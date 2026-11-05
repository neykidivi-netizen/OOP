package ru.vsu.cs.oop26.g41.prudnikov_e_s.my_set_lib;

public class MyDoublyLinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    private static class Node<E>{
        private E value;
        private Node<E> prev;
        private Node<E> next;
        Node(E value){
            this.value = value;
        }

    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void addLast(T value){
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<T> cur = head;
        sb.append("[");
        while (cur != null){
            if (cur.next == null){
                sb.append(cur.value);
            }else {
                sb.append(cur.value + ", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
