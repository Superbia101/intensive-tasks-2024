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

        int PossibleFriendlyNumber = 1;

        for (int divider = 2; divider < num / divider; divider++) {

            if (num % divider == 0) {
                PossibleFriendlyNumber += divider != num / divider ? divider + num / divider : divider;
            }
        }

        return PossibleFriendlyNumber;
    }


    static int getFriendlyPair(int n) {

        if (n <= 0 || n > 1_000_000) {
            return -1;
        }

        int getPossibleFriendlyNumber, FriendlyPair = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            getPossibleFriendlyNumber = getPossibleFriendlyNumber(i);

            if (i == getPossibleFriendlyNumber(getPossibleFriendlyNumber) && i != getPossibleFriendlyNumber) {

                if (Math.max(getPossibleFriendlyNumber, i) < n) {

                    if (sum < i + getPossibleFriendlyNumber) {

                        sum = i + getPossibleFriendlyNumber;
                        FriendlyPair = Math.max(getPossibleFriendlyNumber, i);
                    }
                }
            }
        }

        return FriendlyPair;
    }
}
