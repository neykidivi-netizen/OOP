package ru.vsu.cs.oop26.g41.prudnikov_e_s.my_set_lib;

import java.util.Objects;

public class MyCircularList<T> {
    private MyCircularList.Node<T> head = null;
    private MyCircularList.Node<T> tail = null;
    private int size = 0;

    private static class Node<E> {
        private E value;
        private MyCircularList.Node<E> prev;
        private MyCircularList.Node<E> next;

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
        MyCircularList.Node<T> node = new MyCircularList.Node<>(value);
        if (isEmpty()) {
            head = node;
            tail = node;
            head.prev = tail;
            tail.next = head;
        } else {
            tail.next = node;
            node.prev = tail;
            node.next = head;
            tail = node;
            head.prev = tail;
        }
        size++;
    }

    public void addFirst(T value) {
        MyCircularList.Node<T> node = new MyCircularList.Node<>(value);
        if (isEmpty()) {
            head = node;
            tail = node;
            head.prev = tail;
            tail.next = head;
        } else {
            head.prev = node;
            node.next = head;
            node.prev = tail;
            head = node;
            tail.next = head;
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
            head.prev = tail;
            tail.next = head;
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
            tail.next = head;
            head.prev = tail;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyCircularList.Node<T> cur = head;
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb.append(cur.value);
            } else {
                sb.append(cur.value + ", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();

    }
    public String toStringCount(int countsize) {
        StringBuilder sb = new StringBuilder();
        MyCircularList.Node<T> cur = head;
        sb.append("[");
        for (int i = 0; i < countsize; i++) {
            if (i == countsize - 1) {
                sb.append(cur.value + " ");
                cur = cur.next;
            } else {
                sb.append(cur.value + ", ");
                cur = cur.next;
            }
        }
        sb.append("]");
        return sb.toString();

    }
    private MyCircularList.Node<T> getNode(int index) {
        IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
        if (index < 0 || index >= size) {
            throw ex;
        }
        if (index < (size / 2)) {
            MyCircularList.Node<T> cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur;
        } else {
            MyCircularList.Node<T> cur = tail;
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

        MyCircularList.Node<T> cur = getNode(index);
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
        MyCircularList.Node<T> cur = head;
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

