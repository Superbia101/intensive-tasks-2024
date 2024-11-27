package com.walking.intensive.chapter2.task8;

/**
 * Добираясь в школу на трамвае Вова проверяет, является ли купленный билет счастливым.
 * Если является, то нужно загадать желание и съесть билетик.
 *
 * <p>Билет содержит 6 цифр, комбинации подбираются случайным образом от 000000 до 999999.
 *
 * <p>Билет считается счастливым, если сумма первых трех цифр равна сумме последних трех цифр.
 *
 * <p>Пример: 123411 – счастливый (1 + 2 + 3 == 4 + 1 + 1).
 *
 * <p>Реализуйте метод getHappyTicketChance(), который будет возвращать вероятность
 * выпадения счастливого билета.
 *
 * <p>P.S. Вероятность – это отношение благоприятных исходов к числу всех исходов.
 * Вероятность не может принимать значение больше 1.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task8 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
//        System.out.println(getHappyTicketChance());
    }


    static boolean isEqual(int num) {
        int temp = num / 1000;
        int sumFirstThird = num % 10 + (num % 100) / 10 + (num % 1000) / 100;
        int sumSecondThird = temp % 10 + (temp % 100) / 10 + (temp % 1000) / 100;

        return sumFirstThird == sumSecondThird;
    }


    static double getHappyTicketChance() {
        int HappyTicketChance = 0;

        for (int i = 0; i < 1000000; i++) {

            if (isEqual(i)) {
                HappyTicketChance += 1;
            }
        }

        return (double) HappyTicketChance / 1000000;
    }
}
