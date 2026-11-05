package ru.vsu.cs.oop26.g41.prudnikov_e_s.my_set_demo;

import ru.vsu.cs.oop26.g41.prudnikov_e_s.my_set_lib.MyDoublyLinkedList;

public class Main {
    static void main() {
        MyDoublyLinkedList<Integer> md = new MyDoublyLinkedList<Integer>();
        md.addLast(1);
        md.addLast(2);
        md.addLast(3);
        System.out.println(md);
    }


}
