package com.walking.intensive.chapter2.task7;

/**
 * Пятиклассник Ваня придумал забаву. Он ввел понятие «дружественной пары» чисел.
 * Два различных натуральных числа N и M он назвал дружественными, если сумма делителей числа N
 * (включая 1, но исключая само N) равна числу M и наоборот.
 *
 * <p>Например, 220 и 284 – дружественные числа:
 *
 * <ul>
 * <li>Список делителей для 220: 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110. Их сумма равна 284;
 * <li>Список делителей для 284: 1, 2, 4, 71, 142. Их сумма равна 220.
 * </ul>
 *
 * <p>Реализуйте метод getFriendlyPair(), который принимает параметром число N,
 * где N - натуральное число не больше 1 000 000.
 *
 * <p>Метод должен вернуть наибольшее число из пары дружественных чисел,
 * сумма дружественных чисел которой максимальна среди всех пар дружественных
 * чисел, большее из которых меньше N.
 *
 * <p> Если входные данные некорректны - метод должен возвращать -1.
 *
 * <p>P.S. Решение не должно использовать массивы и прочие темы, которые пока не были затронуты в курсе.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task7 {
    public static void main(String[] args) {
//        System.out.println(getPossibleFriendlyNumber(0));
//        System.out.println(getFriendlyPair(200));
    }


    static int getPossibleFriendlyNumber(int num) {

        int sum = 1, div = 2;

        while (div < num / div) {
            if (num % div == 0) {
                sum += div != num / div ? div + num / div : div;
            }
            div += 1;
        }
        return sum;
    }

    static int getFriendlyPair(int n) {

        if (n <= 0 || n > 1_000_000) {
            return -1;
        }

        int possible_friendly_number, friendly_number = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            possible_friendly_number = getPossibleFriendlyNumber(i);

            if (i == getPossibleFriendlyNumber(possible_friendly_number) && i != possible_friendly_number) {

                if (Math.max(possible_friendly_number, i) < n) {

                    if (sum < i + possible_friendly_number) {

                        sum = i + possible_friendly_number;
                        friendly_number = Math.max(possible_friendly_number, i);
                    }
                }
            }
        }
        return friendly_number;
    }
}
