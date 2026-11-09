package ru.vsu.cs.oop26.g41.prudnikov_e_s.my_set_demo;

import ru.vsu.cs.oop26.g41.prudnikov_e_s.my_set_lib.MyDoublyLinkedList;
public class Main {
    static void main() {
        MyDoublyLinkedList<Integer> md = new MyDoublyLinkedList<Integer>();
        md.addFirst(4);
        md.addFirst(3);
        md.addFirst(2);
        md.addFirst(1);
        System.out.println(md);
        System.out.println(md.get(3));
    }


}
