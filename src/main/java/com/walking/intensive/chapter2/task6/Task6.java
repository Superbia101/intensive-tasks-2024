package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе

    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {

        if (0 >= m || 0 >= n) {
            return -1;
        }
        int value;

//        value = Math.max(m, n);
//        // Брут форс!)
//        while (!(value % m == 0 && value % n == 0)) {
//            value +=1;
//        }

        value = m * n / getGcd(m, n);
        return value;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {

        if (0 >= m || 0 >= n) {
            return -1;
        }

        if (m < n) { // в 'm' большее значение, в 'n' меньшее
            int tmp = n;
            n = m;
            m = tmp;
        }

//        int value = n;
//        // Брут Форс!)
//        while (!(m % value == 0 && n % value == 0)) {
//            value -=1;
//        }
//        return value;

        while (m != 0) { // алгоритм Евклида
            int tmp = m;
            m = n % m;
            n = tmp;
        }
        return n;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью рекурсивной версии алгоритма Евклида.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {

        if (0 >= m || 0 >= n) {
            return -1;
        }

        return getGcdByEuclideanRecursion(m, n);
    }

    static int getGcdByEuclideanRecursion(int m, int n) {

        if (m == 0 || n == 0) {
            return Math.max(m, n);
        }
        return getGcdByEuclideanRecursion(n % m, m);
    }
}
