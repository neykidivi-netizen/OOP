package ru.vsu.cs.oop26.g41.prudnikov_e_s.my_set_demo;

import ru.vsu.cs.oop26.g41.prudnikov_e_s.my_set_lib.MyCircularList;
import ru.vsu.cs.oop26.g41.prudnikov_e_s.my_set_lib.MyDoublyLinkedList;
public class Main {
    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> md = new MyDoublyLinkedList<>();
        MyCircularList<Integer> mc = new MyCircularList<>();
        mc.addLast(1);
        mc.addLast(2);
        mc.addLast(3);
        System.out.println(mc.toStringCount(8));
    }


}
