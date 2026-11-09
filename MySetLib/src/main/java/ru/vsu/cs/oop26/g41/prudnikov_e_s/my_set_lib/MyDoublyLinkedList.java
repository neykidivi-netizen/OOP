package ru.vsu.cs.oop26.g41.prudnikov_e_s.my_set_lib;

import java.util.Objects;

public class MyDoublyLinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    private static class Node<E> {
        private E value;
        private Node<E> prev;
        private Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty() || size == 1) {
            head = null;
            tail = null;
            size = 0;
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty() || size == 1) {
            head = null;
            tail = null;
            size = 0;
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> cur = head;
        sb.append("[");
        while (cur != null) {
            if (cur.next == null) {
                sb.append(cur.value);
            } else {
                sb.append(cur.value + ", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public String toStringReverse() {
        StringBuilder sb = new StringBuilder();
        Node<T> cur = tail;
        sb.append("[");
        while (cur != null) {
            if (cur.prev == null) {
                sb.append(cur.value);
            } else {
                sb.append(cur.value + ", ");
            }
            cur = cur.prev;
        }
        sb.append("]");
        return sb.toString();
    }

    private Node<T> getNode(int index) {
        IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
        if (index < 0 || index >= size) {
            throw ex;
        }
        if (index < (size / 2)) {
            Node<T> cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur;
        } else {
            Node<T> cur = tail;
            for (int i = size - 1; i > index; i--) {
                cur = cur.prev;
            }
            return cur;
        }
    }

    public T get(int index) {
        return getNode(index).value;
    }

    public void remove(int index) {
        IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
        if (index < 0 || index >= size) {
            throw ex;
        }

        Node<T> cur = getNode(index);
        if (index == 0) {
            removeFirst();
        } else if (index == (size - 1)) {
            removeLast();
        } else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size--;
        }

    }

    public int indexOf(T value) {
        Node<T> cur = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(cur.value, value)) {
                return i;
            } else {
                cur = cur.next;
            }
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public void clear(){
        size = 0;
        head = null;
        tail = null;
    }

}
