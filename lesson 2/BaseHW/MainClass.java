package BaseHW;

import java.util.Random;

/**
 * 1. Создать массив большого размера (миллион элементов).
 * 2. Написать методы удаления, добавления, поиска элемента массива.
 * 3. Заполнить массив случайными числами.
 * 4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
 */
public class MainClass {
    public static void main(String[] args) {
        MyArray mas = new MyArray(10);
        Random rnd = new Random();
        int searchEl = 25;

        for (int i = 0; i < 9; i++) {
            int ins = rnd.nextInt(100);
            mas.insert(ins);
        }

        System.out.println("Выводим исходный массив");
        mas.show();

        mas.insert(25);
        System.out.println("Добавили 25 в массив: ");
        mas.show();
        System.out.println("Есть ли в массиве 25?");
        String answer = (mas.binaryFind(searchEl))?"Есть":"Нет";
        System.out.println("Двоичный поиск: " + answer);
        answer = (mas.find(searchEl))?"Есть":"Нет";
        System.out.println("Простой поиск: " + answer);
        System.out.println("Удаляем 25 в массиве: ");
        mas.delete(25);
        mas.show();
        System.out.println("Удаляем весь массив: ");
        mas.deleteAll();
        mas.show();


        /**
         * Методы сортировки
         */

        System.out.println("Методы сортировки\n");
        Sort masForSort = new Sort();

        System.out.println("Быстрая сортировка:");
        long start = System.currentTimeMillis();
        int low = 0;
        int high = masForSort.size - 1;
        masForSort.quickSort(masForSort.arr, low, high);
        long timeProcess = System.currentTimeMillis() - start;
        System.out.println("Время выполнения - " + timeProcess + "\n");

        System.out.println("Пузырьковая сортировка:");
        start = System.currentTimeMillis();
        masForSort.sortBubble();
        timeProcess = System.currentTimeMillis() - start;
        System.out.println("Время выполнения - " + timeProcess + "\n");

        System.out.println("Сортировка выбора:");
        start = System.currentTimeMillis();
        masForSort.sortSelect();
        timeProcess = System.currentTimeMillis() - start;
        System.out.println("Время выполнения - " + timeProcess + "\n");

    }
}
