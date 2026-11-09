package ru.vsu.cs.oop26.g41.prudnikov_e_s.my_set_demo;

import ru.vsu.cs.oop26.g41.prudnikov_e_s.my_set_lib.MyDoublyLinkedList;
public class Main {
    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> md = new MyDoublyLinkedList<>();

        System.out.println("=== ТЕСТ 1: Добавление ===");
        md.addLast(10);
        md.addLast(20);
        md.addLast(30);
        md.addLast(40);
        md.addLast(50);

        System.out.println("Прямой:   " + md);
        System.out.println("Обратный: " + md.toStringReverse());
        System.out.println("Размер:   " + md.size());

        System.out.println("\n=== ТЕСТ 2: Удаление ===");
        md.removeFirst();
        System.out.println("После removeFirst: " + md);

        md.removeLast();
        System.out.println("После removeLast:  " + md);

        md.remove(1);
        System.out.println("После remove(1):   " + md);
        System.out.println("Обратный:          " + md.toStringReverse());
        System.out.println("Размер:            " + md.size());

        System.out.println("\n=== ТЕСТ 3: Поиск ===");
        System.out.println("get(0):       " + md.get(0));
        System.out.println("indexOf(30):  " + md.indexOf(30));
        System.out.println("indexOf(100): " + md.indexOf(100));
        System.out.println("contains(30): " + md.contains(30));
        System.out.println("contains(10): " + md.contains(10));

        System.out.println("\n=== ТЕСТ 4: Добавление после удаления ===");
        md.addFirst(5);
        md.addLast(60);
        System.out.println("Прямой:   " + md);
        System.out.println("Обратный: " + md.toStringReverse());

        System.out.println("\n=== ТЕСТ 5: Полная очистка ===");
        md.clear();
        System.out.println("Список: " + md);
        System.out.println("Размер: " + md.size());
        System.out.println("Пустой:  " + md.isEmpty());

        System.out.println("\n=== ТЕСТ 6: Работа после очистки ===");
        md.addLast(777);
        System.out.println("Список: " + md);
        System.out.println("Размер: " + md.size());
        md.removeLast();
        System.out.println("После удаления: " + md);
        System.out.println("Пустой: " + md.isEmpty());
    }


}
